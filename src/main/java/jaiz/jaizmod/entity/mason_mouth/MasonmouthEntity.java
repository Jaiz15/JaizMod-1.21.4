package jaiz.jaizmod.entity.mason_mouth;

import jaiz.jaizmod.util.ModTags;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.Cracks;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;


public class MasonmouthEntity extends GolemEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(MasonmouthEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> CRACKED =
            DataTracker.registerData(MasonmouthEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public MasonmouthEntity(EntityType<? extends GolemEntity> entityType, World world) {

        super(entityType, world);
        this.disableExperienceDropping();
    }


    public int getMaxLookPitchChange() {
        return 180;
    }

    public int getMaxHeadRotation() {
        return 180;
    }

    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        this.bodyYaw = 0.0F;
        this.prevBodyYaw = 0.0F;
    }

    protected BodyControl createBodyControl() {
        return new MimicBodyControl(this);
    }

    private static class MimicBodyControl extends BodyControl {
        public MimicBodyControl(MobEntity mobEntity) {
            super(mobEntity);
        }

        public void tick() {
        }
    }

    public boolean isCollidable() {
        return this.isAlive();
    }






    public void setPosition(double x, double y, double z) {
        BlockPos blockPos = this.getBlockPos();
        if (this.hasVehicle()) {
            super.setPosition(x, y, z);
        } else {
            super.setPosition((double) MathHelper.floor(x) + 0.5, (double)MathHelper.floor(y + 0.5), (double)MathHelper.floor(z) + 0.5);
        }
    }

    public void updateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps) {
        this.bodyTrackingIncrements = 0;
        this.setPosition(x, y, z);
        this.setRotation(yaw, pitch);
    }

    protected MoveEffect getMoveEffect() {
        return MoveEffect.NONE;
    }

    @Override
    public void pushAwayFrom(Entity entity) {
    }

    @Override
    public void checkDespawn() {
        if (this.getWorld().getDifficulty() == Difficulty.PEACEFUL && this.isDisallowedInPeaceful()) {
            this.discard();
            return;
        }
        this.despawnCounter = 0;
    }


    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking()  && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 25;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }

    }



    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    public boolean damage(ServerWorld world,
                          DamageSource source, float amount) {
        boolean bl = super.damage(world, source, amount);
        if (bl) {
            this.setCracked(this.getHealth() <= 5);
        }
        return bl;
    }

    @Override
    protected void initGoals() {
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.add(2, new MasonMouthAttackGoal(this, 1d, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(4, new RevengeGoal(this));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, SnowGolemEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createMasonMouthAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 14)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.0f)
                .add(EntityAttributes.ARMOR, 0.5f)
                .add(EntityAttributes.ATTACK_DAMAGE, 16)
                .add(EntityAttributes.FOLLOW_RANGE, 2)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 5.0f);

    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    public void setCracked(boolean cracked) {
        this.dataTracker.set(CRACKED, cracked);
    }

    public boolean isCracked() {
        return this.dataTracker.get(CRACKED);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
        builder.add(ATTACKING, false);
        builder.add(CRACKED, false);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
        nbt.putBoolean("Cracked", this.isCracked());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
        this.dataTracker.set(CRACKED, nbt.getBoolean("Cracked"));
    }

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(MasonmouthEntity.class, TrackedDataHandlerRegistry.INTEGER);

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        setVariant(MasonMouthVariant.ORIGINAL);
        this.setYaw(0.0F);
        this.headYaw = this.getYaw();
        this.resetPosition();
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    public Object getVariant() {
        return MasonMouthVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(MasonMouthVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SHULKER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_DEEPSLATE_TILES_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPLASH_POTION_BREAK;
    }

    public static HashMap<Item, MasonMouthVariant> getSherdVariant() {
        HashMap<Item, MasonMouthVariant> sherd_variant = new HashMap<>();
        sherd_variant.put(Items.ANGLER_POTTERY_SHERD, MasonMouthVariant.ANGLER);
        sherd_variant.put(Items.ARCHER_POTTERY_SHERD, MasonMouthVariant.ARCHER);
        sherd_variant.put(Items.ARMS_UP_POTTERY_SHERD, MasonMouthVariant.ARMS_UP);
        sherd_variant.put(Items.BLADE_POTTERY_SHERD, MasonMouthVariant.BLADE);
        sherd_variant.put(Items.BREWER_POTTERY_SHERD, MasonMouthVariant.BREWER);
        sherd_variant.put(Items.BURN_POTTERY_SHERD, MasonMouthVariant.BURN);
        sherd_variant.put(Items.DANGER_POTTERY_SHERD, MasonMouthVariant.DANGER);
        sherd_variant.put(Items.EXPLORER_POTTERY_SHERD, MasonMouthVariant.EXPLORER);
        sherd_variant.put(Items.FLOW_POTTERY_SHERD, MasonMouthVariant.FLOW);
        sherd_variant.put(Items.FRIEND_POTTERY_SHERD, MasonMouthVariant.FRIEND);
        sherd_variant.put(Items.GUSTER_POTTERY_SHERD, MasonMouthVariant.GUSTER);
        sherd_variant.put(Items.HEART_POTTERY_SHERD, MasonMouthVariant.HEART);
        sherd_variant.put(Items.HEARTBREAK_POTTERY_SHERD, MasonMouthVariant.HEARTBREAK);
        sherd_variant.put(Items.HOWL_POTTERY_SHERD, MasonMouthVariant.HOWL);
        sherd_variant.put(Items.MINER_POTTERY_SHERD, MasonMouthVariant.MINER);
        sherd_variant.put(Items.MOURNER_POTTERY_SHERD, MasonMouthVariant.MOURNER);
        sherd_variant.put(Items.PLENTY_POTTERY_SHERD, MasonMouthVariant.PLENTY);
        sherd_variant.put(Items.PRIZE_POTTERY_SHERD, MasonMouthVariant.PRIZE);
        sherd_variant.put(Items.SCRAPE_POTTERY_SHERD, MasonMouthVariant.SCRAPE);
        sherd_variant.put(Items.SHEAF_POTTERY_SHERD, MasonMouthVariant.SHEAF);
        sherd_variant.put(Items.SHELTER_POTTERY_SHERD, MasonMouthVariant.SHELTER);
        sherd_variant.put(Items.SKULL_POTTERY_SHERD, MasonMouthVariant.SKULL);
        sherd_variant.put(Items.SNORT_POTTERY_SHERD, MasonMouthVariant.SNORT);
        sherd_variant.put(Items.GOLD_NUGGET, MasonMouthVariant.GILDED);
        sherd_variant.put(Items.CLAY_BALL, MasonMouthVariant.CLAY);
        return sherd_variant;
    }

    @Override
    public ProjectileDeflection getProjectileDeflection(ProjectileEntity projectile) {
            return ProjectileDeflection.SIMPLE;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        HashMap<Item, MasonMouthVariant> sherd_variant = getSherdVariant();
        if (itemStack.isIn(ModTags.Items.MASON_MOUTH_TRANSFORMABLE)){
            if (sherd_variant.containsKey(player.getStackInHand(hand).getItem())) {
                MasonMouthVariant output = sherd_variant.get(player.getStackInHand(hand).getItem());
                this.setVariant(output);
            }
            int o = this.getRandom().nextInt(9) + 3;
            for (int i = 0; i < o; i++) {
                this.getWorld().addParticle(ParticleTypes.SCRAPE, this.getParticleX(1.2), this.getRandomBodyY(), this.getParticleZ(1.2), 0.0, 0.0, 0.0);
            }
            this.getWorld().playSound(null, this.getX() + 0.5, this.getY() + 0.5,
                    this.getZ() + 0.5, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.HOSTILE, 1.0f, 1.0f);

            if (!player.getAbilities().creativeMode) {
                player.getStackInHand(hand).decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

}
