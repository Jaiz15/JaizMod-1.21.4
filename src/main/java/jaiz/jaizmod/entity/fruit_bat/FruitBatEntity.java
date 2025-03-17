package jaiz.jaizmod.entity.fruit_bat;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.thrown_entity.GuanoEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;


public class FruitBatEntity extends BatEntity {

    public int poopTime = this.random.nextInt(5000) + 3000;

    public FruitBatEntity(EntityType<? extends BatEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canBeLeashed() {
        return true;
    }

    @Override
    public void tick() {
        if (!this.getWorld().isClient && this.isAlive() && --this.poopTime <= 0) {
            GuanoEntity poop = new GuanoEntity(ModEntities.GUANO, this.getWorld());
            this.getWorld().spawnEntity(poop);
            this.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 0.5f,
                    (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.5f);
            poop.refreshPositionAndAngles(this.getX(),
                    this.getY() - 0.5, this.getZ(), 0.0F, 0.0F);
            poopTime = this.random.nextInt(5000) + 3000;
        }
        super.tick();
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SWEET_BERRIES) && this.isRoosting()) {
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.AMBIENT, 15.0f, this.getPitch() * -0.05f + 1f);
            if(!player.isCreative()){
            itemStack.decrement(1);}
            GuanoEntity poop = new GuanoEntity(ModEntities.GUANO, this.getWorld());
            if (this.random.nextInt(4) == 1) {
                this.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 0.5f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.5f);
                poop.refreshPositionAndAngles(this.getX(), this.getY() - 0.5, this.getZ(), 0.0F, 0.0F);
                this.getWorld().spawnEntity(poop);
            }
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    public static boolean canSpawn(EntityType<FruitBatEntity> fruitBatEntityEntityType, ServerWorldAccess serverWorldAccess, SpawnReason spawnReason, BlockPos blockPos, Random random) {
            int i = 1;
            int j = 10;
            return i == random.nextInt(j) && canMobSpawn(fruitBatEntityEntityType, serverWorldAccess, spawnReason, blockPos, random);
        }
}
