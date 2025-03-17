package jaiz.jaizmod.mixin;

import jaiz.jaizmod.entity.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnifferEggBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(SnifferEggBlock.class)
public abstract class SnifferEggMixin extends Block {


    @Shadow
    public static final IntProperty HATCH = Properties.HATCH;

    @Shadow
    private boolean isReadyToHatch(BlockState state) {
        return this.getHatchStage(state) == 2;
    }

    @Shadow
    public int getHatchStage(BlockState state) {
        return state.get(HATCH);
    }


    public SnifferEggMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At("HEAD"), method = "scheduledTick", cancellable = true)
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if (!this.isReadyToHatch(state)) {
            world.playSound(null, pos, SoundEvents.BLOCK_SNIFFER_EGG_CRACK, SoundCategory.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
            world.setBlockState(pos, state.with(HATCH, Integer.valueOf(this.getHatchStage(state) + 1)), Block.NOTIFY_LISTENERS);
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_SNIFFER_EGG_HATCH, SoundCategory.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
            world.breakBlock(pos, false);
            Objects.requireNonNull(EntityType.SNIFFER.spawn(world, pos, SpawnReason.BREEDING)).setBaby(true);
        }
        ci.cancel();
    }
}
