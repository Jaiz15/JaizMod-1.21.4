package jaiz.jaizmod.entity.butterfly;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.Bottlable;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class ButterflyEntity extends AnimalEntity implements Flutterer, Bottlable {
    private static final TrackedData<Boolean> FROM_BOTTLE = DataTracker.registerData(ButterflyEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public ButterflyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 4;
        this.moveControl = new FlightMoveControl(this, 20, true);
        this.lookControl = new ButterflyLookControl(this);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0f);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0f);
        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 16.0f);
        this.setPathfindingPenalty(PathNodeType.COCOA, -1.0f);
        this.setPathfindingPenalty(PathNodeType.FENCE, -1.0f);
    }

    @Override
    public boolean cannotDespawn() {
        return super.cannotDespawn() || this.isFromBottle();
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        return Bottlable.tryBottle(player, hand, this).orElse(super.interactMob(player, hand));
    }


    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        if (world.getBlockState(pos).isAir()) {
            return 10.0f;
        }
        return 0.0f;
    }

    public AnimationState butterflyAnimationState = new AnimationState();
    public AnimationState idlebutterflyAnimationState = new AnimationState();
    private int butterflyAnimationTimeout = 0;

    private void setupAnimationStates() {
                if (this.butterflyAnimationTimeout <= 0) {
            this.butterflyAnimationTimeout = 10;
            if (this.isOnGround() && this.navigation.isIdle()) {
                this.butterflyAnimationState.stop();
                this.idlebutterflyAnimationState.start(this.age);
            } else {
                this.idlebutterflyAnimationState.stop();
                this.butterflyAnimationState.start(this.age);
            }
        } else {
            --this.butterflyAnimationTimeout;
        }
    }


    @Override
    public void tick() {
        super.tick();

        if (this.isTouchingWater()){
            this.setVelocity(this.getVelocity().add(0.0, 0.01, 0.0));
        }

        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }


    @Override
    protected void initGoals() {
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(2, new ButterflyWanderAroundGoal());
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.25, stack -> stack.isIn(ItemTags.BEE_FOOD), false));
    }
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.BEE_FOOD);
    }



    public static DefaultAttributeContainer.Builder createButterflyAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 5)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25f)
                .add(EntityAttributes.FOLLOW_RANGE, 16)
                .add(EntityAttributes.TEMPT_RANGE, 16)
                .add(EntityAttributes.FLYING_SPEED, 0.6f);

    }

    @Override
    @Nullable
    public PassiveEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return ModEntities.CATERPILLAR.spawn(serverWorld, ButterflyEntity.this.getBlockPos(), SpawnReason.MOB_SUMMONED);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PARROT_FLY;
    }


    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world) {

            @Override
            public boolean isValidPosition(BlockPos pos) {
                return !this.world.getBlockState(pos.down()).isAir();
            }

            @Override
            public void tick() {
                super.tick();
            }
        };
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(false);
        birdNavigation.setCanPathThroughDoors(true);
        return birdNavigation;
    }

    @Override
    public boolean isInAir() {
        return !this.isOnGround();
    }

    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("FromBottle", this.isFromBottle());
        nbt.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.setFromBottle(nbt.getBoolean("FromBottle"));
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(FROM_BOTTLE, false);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
    }

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(ButterflyEntity.class, TrackedDataHandlerRegistry.INTEGER);

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        setTexture();
        return super.initialize(world, difficulty, spawnReason, entityData);
    }


    public void setTexture(){
        int i = random.nextInt(100)+1;
        if(i >= 1 && i <= 30) {setVariant(ButterflyVariant.MONARCH);}
        if(i >= 31 && i <= 45) {setVariant(ButterflyVariant.WHITE_MONARCH);}
        if(i >= 46 && i <= 60) {setVariant(ButterflyVariant.YELLOW_MONARCH);}
        if(i >= 61 && i <= 70) {setVariant(ButterflyVariant.CABBAGE_MOTH);}
        if(i >= 71 && i <= 80) {setVariant(ButterflyVariant.ULYSSES);}
        if(i >= 81 && i <= 90) {setVariant(ButterflyVariant.CARINS_BIRDWING);}
        if(i >= 91 && i <= 95) {setVariant(ButterflyVariant.LUNA_MOTH);}
        if(i >= 96 && i <= 99) {setVariant(ButterflyVariant.ATLAS_MOTH);}
        if(i == 100) {setVariant(ButterflyVariant.JAMPOTT);}
    }

    public Object getVariant() {
        return ButterflyVariant.byId(this.getTypeVariant() & 255);
    }


    public int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(ButterflyVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    private int getButterflyVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public boolean isFromBottle() {
        return this.dataTracker.get(FROM_BOTTLE);
    }

    @Override
    public void setFromBottle(boolean fromBottle) {
        this.dataTracker.set(FROM_BOTTLE, fromBottle);
    }

    @Override
    public ItemStack getBottleItem() {
        return new ItemStack(ModItems.BUTTERFLY_BOTTLE);
    }


    @Override
    public void copyDataToStack(ItemStack stack) {
        Bottlable.copyDataToStack(this, stack);
        NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, stack, nbtCompound -> nbtCompound.putInt("BottleVariantTag", this.getButterflyVariant()));
    }

    @Override
    public void copyDataFromNbt(NbtCompound nbt) {
        Bottlable.copyDataFromNbt(this, nbt);
        if (nbt.contains("BottleVariantTag", NbtElement.INT_TYPE)) {
            this.setVariant(ButterflyVariant.byId(nbt.getInt("BottleVariantTag")));
        }
    }




    static class ButterflyLookControl
            extends LookControl {
        ButterflyLookControl(MobEntity entity) {
            super(entity);
        }

        @Override
        public void tick() {
            super.tick();
        }

    }


    class ButterflyWanderAroundGoal
            extends Goal {

        ButterflyWanderAroundGoal() {
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return ButterflyEntity.this.navigation.isIdle() && ButterflyEntity.this.random.nextInt(10) == 1;
        }

        @Override
        public boolean shouldContinue() {
            return ButterflyEntity.this.navigation.isFollowingPath();
        }

        @Override
        public void start() {
            Vec3d vec3d = this.getRandomLocation();
            if (vec3d != null) {
                ButterflyEntity.this.navigation.startMovingAlong(ButterflyEntity.this.navigation.findPathTo(BlockPos.ofFloored(vec3d), 1), 1.0);
            }
        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d vec3d2;
            vec3d2 = ButterflyEntity.this.getRotationVec(0.0f);
            int i = 8;
            Vec3d vec3d3 = AboveGroundTargeting.find(ButterflyEntity.this, 4, 14, vec3d2.x, vec3d2.z, 1.5707964f, 3, 1);
            if (vec3d3 != null) {
                return vec3d3;
            }return NoPenaltySolidTargeting.find(ButterflyEntity.this, 4, 8, -2, vec3d2.x, vec3d2.z, 1.5707963705062866);}

    }

}
