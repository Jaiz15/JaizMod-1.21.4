package jaiz.jaizmod.mixin;

import jaiz.jaizmod.entity.sniffer_mixins.SnifferGroupRevengeGoal;
import jaiz.jaizmod.entity.sniffer_mixins.SnifferMixinAccessor;
import jaiz.jaizmod.entity.sniffer_mixins.SnifferRevengeGoal;
import jaiz.jaizmod.entity.sniffer_mixins.SnifferVariant;
import jaiz.jaizmod.util.ModLootTables;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.brain.task.TargetUtil;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Objects;

@Mixin(SnifferEntity.class)
public abstract class SnifferEntityMixin
        extends AnimalEntity implements
        SnifferMixinAccessor {

    @Unique
    private static final TargetPredicate.EntityPredicate RAM_FILTER = (entity, world)
            -> !(entity instanceof PlayerEntity playerEntity) || !playerEntity.isCreative();

    @Unique
    private static final TargetPredicate RAM_TARGET_PREDICATE = TargetPredicate.createNonAttackable()
            .ignoreDistanceScalingFactor()
            .ignoreVisibility()
            .setPredicate(RAM_FILTER);

    @Unique
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(SnifferEntityMixin.class, TrackedDataHandlerRegistry.INTEGER);

    @Shadow @Final public AnimationState sniffingAnimationState;
    @Shadow @Final public AnimationState scentingAnimationState;

    @Unique
    private static final TrackedData<Boolean> SNOWY =
            DataTracker.registerData(SnifferEntityMixin.class,
                    TrackedDataHandlerRegistry.BOOLEAN);
    @Unique
    private static final TrackedData<Boolean> SADDLED =
            DataTracker.registerData(SnifferEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);
    @Unique
    private static final TrackedData<Boolean> MOSSY =
            DataTracker.registerData(SnifferEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);
    @Unique
    private static final TrackedData<Boolean> MUDDY =
            DataTracker.registerData(SnifferEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Unique
    private static final TrackedData<Boolean> CHERRY_BLOSSOM =
            DataTracker.registerData(SnifferEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);
    @Unique
    private static final TrackedData<Boolean> BULL =
            DataTracker.registerData(SnifferEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);


    protected SnifferEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 3.0, true));
        this.targetSelector.add(2, new SnifferRevengeGoal(this));
        this.targetSelector.add(3, new SnifferGroupRevengeGoal(this).setGroupRevenge());
    }


    @Unique
    private RegistryKey<LootTable> getSnifferCoatLootTable() {
        return ModLootTables.SNIFFER_BRUSH_COAT_GAMEPLAY;
    }
    @Unique
    public List<ItemStack> getSnifferCoatLoot(SnifferEntityMixin sniffer, ServerWorld serverWorld) {
        LootTable lootTable = serverWorld.getServer().getReloadableRegistries().getLootTable(getSnifferCoatLootTable());
        LootWorldContext lootContextParameterSet = new LootWorldContext.Builder(serverWorld)
                .add(LootContextParameters.ORIGIN, sniffer.getPos())
                .add(LootContextParameters.THIS_ENTITY, sniffer)
                .build(LootContextTypes.GIFT);
        return lootTable.generateLoot(lootContextParameterSet);
    }

    @Unique
    private void CoatLootItemDropper(SnifferEntityMixin sniffer, LivingEntity recipient) {
        sniffer.playSound(SoundEvents.ITEM_BRUSH_BRUSHING_GENERIC, 0.7F, (sniffer.random.nextFloat() - sniffer.random.nextFloat()) * 0.2F + 1.0F);
        if (getWorld() instanceof ServerWorld serverWorld) {
            for (ItemStack itemStack : this.getSnifferCoatLoot(sniffer, serverWorld)) {
                TargetUtil.give(sniffer, itemStack, recipient.getPos());
            }

        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        super.interactMob(player, hand);
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BRUSH) && this.brushSniffer()) {
            itemStack.damage(4, player, getSlotForHand(hand));
            return ActionResult.SUCCESS;
        }
        else if (itemStack.isOf(Items.SADDLE) && !this.isBaby() && !this.isSaddled() && this.isBull()) {
            itemStack.decrement(1);
            this.setSaddled(true);
            this.playSoundIfNotSilent(SoundEvents.ENTITY_PIG_SADDLE);
            return ActionResult.SUCCESS;
        }
        else if (itemStack.isIn(ItemTags.SHOVELS) && this.isSnowy()) {
            itemStack.damage(1, player, getSlotForHand(hand));
            this.snowItemDropper();
            this.setSnowy(false);
            return ActionResult.SUCCESS;
        }
        else if (itemStack.isOf(Items.SNOW) && !this.isSnowy()) {
            itemStack.decrement(1);
            this.playSoundIfNotSilent(SoundEvents.BLOCK_SNOW_PLACE);
            this.setSnowy(true);
            return ActionResult.SUCCESS;
        }
        else if (itemStack.isOf(Items.CHERRY_LEAVES) && !this.isCherryBlossom()) {
            itemStack.decrement(1);
            this.playSoundIfNotSilent(SoundEvents.BLOCK_SNOW_PLACE);
            this.setCherryBlossom(true);
            return ActionResult.SUCCESS;
        }
        else if (itemStack.isOf(Items.MOSS_CARPET) && !this.isMossy()) {
            itemStack.decrement(1);
            this.playSoundIfNotSilent(SoundEvents.BLOCK_SNOW_PLACE);
            this.setMossy(true);
            return ActionResult.SUCCESS;
        }
        else if (itemStack.isOf(Items.MUD) && !this.isMuddy()) {
            itemStack.decrement(1);
            this.playSoundIfNotSilent(SoundEvents.BLOCK_MUD_PLACE);
            this.setMuddy(true);
            return ActionResult.SUCCESS;
        }
        else if (itemStack.isOf(Items.SHEARS) && this.isMossy() || itemStack.isOf(Items.SHEARS) && this.isCherryBlossom()) {
            this.playSoundIfNotSilent(SoundEvents.ENTITY_SHEEP_SHEAR);
            itemStack.damage(1, player, getSlotForHand(hand));
            this.setMossy(false);
            this.setCherryBlossom(false);
            return ActionResult.SUCCESS;
        }
        else if (itemStack.isOf(Items.WATER_BUCKET) && this.isMuddy()) {
            this.playSoundIfNotSilent(SoundEvents.ITEM_BUCKET_EMPTY);
            this.setMuddy(false);
            return ActionResult.SUCCESS;
        }
        //has to be at bottom
        else if (!this.hasPassengers() && !player.shouldCancelInteraction() && this.isSaddled()) {
            if (!this.getWorld().isClient) {
                player.startRiding(this);
            }
            return ActionResult.SUCCESS;
        }
        else if(this.isSaddled()){
            this.saddleItemDropper();
            this.setSaddled(false);
            return ActionResult.SUCCESS;
        }
        else {
            return ActionResult.FAIL;
        }
    }

    @Unique
    public boolean brushSniffer() {
        if (this.isBaby()) {
            return false;
        } else {
            if (this.getWorld() instanceof ServerWorld) {
                this.CoatLootItemDropper(this, this.getEntityWorld().getClosestPlayer(this, 32));
                this.emitGameEvent(GameEvent.ENTITY_INTERACT);
            }

            return true;
        }
    }

    @Unique
    public void snowItemDropper() {
        if (this.getWorld() instanceof ServerWorld serverWorld) {
            this.dropStack(serverWorld, new ItemStack(Items.SNOWBALL));
            this.emitGameEvent(GameEvent.ENTITY_INTERACT);
            this.playSoundIfNotSilent(SoundEvents.BLOCK_SNOW_BREAK);
        }
    }
    @Unique
    public void saddleItemDropper() {
        if (this.getWorld() instanceof ServerWorld serverWorld) {
            this.dropStack(serverWorld, new ItemStack(Items.SADDLE));
            this.emitGameEvent(GameEvent.ENTITY_INTERACT);
            this.playSoundIfNotSilent(SoundEvents.ENTITY_PIG_SADDLE);
        }
    }

    @Unique
    public void setBull(boolean bull) {
        this.dataTracker.set(BULL, bull);
    }
    @Unique
    public boolean isBull() {
        return this.dataTracker.get(BULL);
    }

    @Unique
    public void setSaddled(boolean saddled) {
        this.dataTracker.set(SADDLED, saddled);
    }
    @Unique
    public boolean isSaddled() {
        return this.dataTracker.get(SADDLED);
    }

    @Unique
    public boolean isMossy() {
        return this.dataTracker.get(MOSSY);
    }
    @Unique
    public void setMossy(boolean mossy) {
        this.dataTracker.set(MOSSY, mossy);
    }
    @Unique
    public boolean isMuddy() {
        return this.dataTracker.get(MUDDY);
    }
    @Unique
    public void setMuddy(boolean muddy) {
        this.dataTracker.set(MUDDY, muddy);
    }
    @Unique
    public boolean isCherryBlossom() {
        return this.dataTracker.get(CHERRY_BLOSSOM);
    }
    @Unique
    public void setCherryBlossom(boolean cherry_blossom) {
        this.dataTracker.set(CHERRY_BLOSSOM, cherry_blossom);
    }
    @Unique
    public boolean isSnowy() {
        return this.dataTracker.get(SNOWY);
    }

    @Unique
    public void setSnowy(boolean snowy) {
        this.dataTracker.set(SNOWY, snowy);
    }


    /**
     * @author
     * @reason
     */
    @Overwrite
    public static DefaultAttributeContainer.Builder createSnifferAttributes() {
        return AnimalEntity.createAnimalAttributes()
                .add(EntityAttributes.MOVEMENT_SPEED, 0.1F)
                .add(EntityAttributes.MAX_HEALTH, 14.0)
                .add(EntityAttributes.ATTACK_KNOCKBACK, 2.0)
                .add(EntityAttributes.FOLLOW_RANGE, 24.0)
                .add(EntityAttributes.ATTACK_DAMAGE, 2.0);
    }

    @Inject(method = "initDataTracker", at = @At("TAIL"))
    public void initDataTracker(DataTracker.Builder builder, CallbackInfo ci){
        builder.add(DATA_ID_TYPE_VARIANT, 0);
        builder.add(BULL, false);
        builder.add(SADDLED, false);
        builder.add(SNOWY, false);
        builder.add(MOSSY, false);
        builder.add(MUDDY, false);
        builder.add(CHERRY_BLOSSOM, false);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Variant", this.getTypeVariant());
        nbt.putBoolean("Bull", this.isBull());
        nbt.putBoolean("Saddled", this.isSaddled());
        nbt.putBoolean("Snowy", this.isSnowy());
        nbt.putBoolean("Mossy", this.isMossy());
        nbt.putBoolean("Muddy", this.isMuddy());
        nbt.putBoolean("Cherry_Blossom", this.isCherryBlossom());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("Variant"));
        this.dataTracker.set(BULL, nbt.getBoolean("Bull"));
        this.dataTracker.set(SADDLED, nbt.getBoolean("Saddled"));
        this.dataTracker.set(SNOWY, nbt.getBoolean("Snowy"));
        this.dataTracker.set(MOSSY, nbt.getBoolean("Mossy"));
        this.dataTracker.set(MUDDY, nbt.getBoolean("Muddy"));
        this.dataTracker.set(CHERRY_BLOSSOM, nbt.getBoolean("Cherry_Blossom"));
    }

    @Unique
    private void ram(ServerWorld world, MobEntity target) {
        this.tryAttack(world, target);
        this.playSound(SoundEvents.ENTITY_GOAT_RAM_IMPACT, 1.0F, 1.0F);
    }
    @Unique
    int rammingCooldown = 0;
    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo ci){
        if(rammingCooldown > 0){
        rammingCooldown--;
        }
        if(rammingCooldown > 100){
            rammingCooldown = 80;
        }
        if (this.getSteppingBlockState().isOf(Blocks.MUD) && !this.isMuddy()) {
            this.setMuddy(true);
        }
        if (this.hasControllingPassenger() && Objects.requireNonNull
                (this.getControllingPassenger()).isSprinting() && rammingCooldown < 30)
        {
            if (this.getWorld() instanceof ServerWorld serverWorld && this.isAlive()) {
                for (MobEntity mobEntity : this.getWorld()
                        .getEntitiesByClass(MobEntity.class, this.getBoundingBox().expand(0.3),
                                mobEntityx -> RAM_TARGET_PREDICATE.test(serverWorld, this, mobEntityx))) {
                    if (mobEntity.isAlive()) {
                        this.ram(serverWorld, mobEntity);
                        rammingCooldown += 45;
                    }
                }
            }
        }
        if(this.random.nextInt(250) == 1){
            this.heal(1);
        }

        RegistryEntry<Biome> registryEntry = this.getWorld().getBiome(this.getBlockPos());
        if(this.random.nextInt(10000) == 1 && !this.getWorld().isClient()){
            if (registryEntry.isIn(ModTags.Biomes.SNIFFER_CHERRY) && !this.isCherryBlossom()) {
                this.setCherryBlossom(true);
            }
            if (registryEntry.isIn(ModTags.Biomes.SNIFFER_MOSSY) && !this.isMossy()) {
                this.setMossy(true);
            }
            if (registryEntry.isIn(BiomeTags.SPAWNS_SNOW_FOXES) && this.getWorld()
                    .isRaining() && !this.isSnowy()) {
            this.setSnowy(true);
            }
            else if (registryEntry.isIn(BiomeTags.SPAWNS_WARM_VARIANT_FROGS) && this.isSnowy()) {
            this.setSnowy(false);
            }
        }
        if(this.isSnowy() || this.isMuddy()){
            if (this.getSteppingBlockState().isOf(Blocks.WATER)) {
                this.setMuddy(false);
                this.setSnowy(false);
            }
        }
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        if (entityData == null) {
            entityData = new PassiveEntity.PassiveData(true);
        }
        PassiveEntity.PassiveData passiveData = (PassiveEntity.PassiveData)entityData;
        if (passiveData.canSpawnBaby() && passiveData.getSpawnedCount() > 0 && world.getRandom().nextFloat() <= passiveData.getBabyChance()) {
            this.setBreedingAge(-24000);
        }
        passiveData.countSpawned();
        if(this.random.nextInt(50) == 1  && !this.getWorld().isClient()){
            this.setBull(true);
            Objects.requireNonNull(this.
                    getAttributeInstance(EntityAttributes.ATTACK_DAMAGE)).setBaseValue(8.0);
            Objects.requireNonNull(this.
                    getAttributeInstance(EntityAttributes.MAX_HEALTH)).setBaseValue(40.0);
            this.heal(32);
        }
        setTexture();

        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Unique
    public void setTexture(){
        int i = random.nextInt(100);
        if(i <= 10) {setVariant(SnifferVariant.GREEN);
        }else if(i <= 20) {setVariant(SnifferVariant.LIME);
        }else if(i <= 30) {setVariant(SnifferVariant.DUSK_LIME);
        }else if(i <= 40) {setVariant(SnifferVariant.PALE);
        }else if(i <= 50) {setVariant(SnifferVariant.MUSKY);
        }else if(i <= 53) {setVariant(SnifferVariant.BLUE);
        }else if(i <= 55) {setVariant(SnifferVariant.DANDELION);
        }else if(i <= 57) {setVariant(SnifferVariant.AUTUMN);
        }else if(i <= 60) {setVariant(SnifferVariant.SUNSET);
        }else if(i == 61) {setVariant(SnifferVariant.DUSK);}
        else if(i == 62) {setVariant(SnifferVariant.WHITE);}
        else if(i == 63) {setVariant(SnifferVariant.GREY);}
        else{setVariant(SnifferVariant.DEFAULT);
        }

    }


    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
        super.tickControlled(controllingPlayer, movementInput);
        Vec2f vec2f = this.getControlledRotation(controllingPlayer);
        this.setRotation(vec2f.y, vec2f.x);
        this.sniffingAnimationState.stop();
        this.scentingAnimationState.stop();
        this.prevYaw = this.bodyYaw = this.headYaw = this.getYaw();
    }

    @Unique
    protected Vec2f getControlledRotation(LivingEntity controllingPassenger) {
        return new Vec2f(controllingPassenger.getPitch() * 0.5F, controllingPassenger.getYaw());
    }

    @Override
    protected Vec3d getControlledMovementInput(PlayerEntity controllingPlayer, Vec3d movementInput) {
            float f = controllingPlayer.sidewaysSpeed * 0.5F;
            float g = controllingPlayer.forwardSpeed;
            return new Vec3d(f, 0.0, g);
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        Entity var2 = this.getFirstPassenger();
        if(this.isSaddled()){
            if (var2 instanceof PlayerEntity) {
                return (PlayerEntity)var2;
            }
        }
        return super.getControllingPassenger();
    }

    @Override
    public boolean canSprintAsVehicle() {
        return true;
    }

    @Override
    protected float getSaddledSpeed(PlayerEntity controllingPlayer) {
        if(!controllingPlayer.isSprinting()){
            return 0.075f;
        }
        return 0.15f;
    }

    @Unique
    public Object getVariant() {
        return SnifferVariant.byId(this.getTypeVariant() & 255);
    }

    @Unique
    public void setVariant(SnifferVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Unique
    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }
}
