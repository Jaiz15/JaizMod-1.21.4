package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

import static net.minecraft.block.LeavesBlock.DISTANCE;
import static net.minecraft.block.LeavesBlock.PERSISTENT;

public class RottingLog extends PillarBlock {

    public static final IntProperty ROTTING = ModBlocks.ROTTING;

    public RottingLog(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y).with(ROTTING, 0));
    }


    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 1) {
            return;
        }
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        BlockState blockState2 = ModBlocks.ROTTEN_LOG.getDefaultState().with(ROTTING, 1);
        BlockState blockState3 = ModBlocks.DRIED_LEAVES.getDefaultState().with(ROTTING, 1).with(DISTANCE, 3);
        if(state.get(ROTTING) == 1){
        if (blockState.isIn(BlockTags.LOGS)) {
            world.setBlockState(blockPos, blockState2);
        }
        if (blockState.isIn(ModTags.Blocks.ROTTABLE_LEAVES)) {
            world.setBlockState(blockPos, blockState3);
        }
        }

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, ROTTING);
    }
}
