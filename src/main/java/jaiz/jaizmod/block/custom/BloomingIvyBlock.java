package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class BloomingIvyBlock extends VineBlock {

    public static final IntProperty STAGE = ModBlocks.STAGE;
    public static final BooleanProperty LOCKED = ModBlocks.LOCKED;

    public BloomingIvyBlock(Settings settings) {
        super(settings);

        this.setDefaultState(
                this.stateManager
                        .getDefaultState()
                        .with(UP, Boolean.FALSE)
                        .with(NORTH, Boolean.FALSE)
                        .with(EAST, Boolean.FALSE)
                        .with(SOUTH, Boolean.FALSE)
                        .with(WEST, Boolean.FALSE)
                        .with(STAGE, 1)
                        .with(LOCKED, false)
        );
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return !state.get(LOCKED);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        if (random.nextInt(25) == 1 && !state.get(LOCKED) && state.get(STAGE) < 3) {
            BlockState blockState = state.with(STAGE, state.get(STAGE) + 1);
            world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
        }
    }

    private static boolean shearItem(ItemStack stack) {
        return stack.isOf(Items.SHEARS);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (BloomingIvyBlock.shearItem(itemStack)) {
            BloomingIvyBlock.shear(player, world, pos, state);
            if (!player.getAbilities().creativeMode) {
                stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            }
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    public static void shear(@Nullable Entity user, World world, BlockPos pos, BlockState state) {
        BlockState blockState = state.with(LOCKED, true);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(user, blockState));
        world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH, EAST, SOUTH, WEST, STAGE, LOCKED);
    }
}
