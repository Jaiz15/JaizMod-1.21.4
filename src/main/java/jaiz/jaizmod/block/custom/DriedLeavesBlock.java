package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class DriedLeavesBlock extends ParticleLeavesBlock {
    public static final IntProperty ROTTING = ModBlocks.ROTTING;

    public DriedLeavesBlock(int chance, ParticleEffect particle, AbstractBlock.Settings settings) {
        super(chance, particle, settings);
        this.setDefaultState(this.getDefaultState().with(ROTTING, 0).with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)).with(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return !(Boolean)state.get(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        BlockPos blockPos = pos.up();
        BlockPos blockPos1 = pos.down();
        BlockPos blockPos2 = pos.east();
        BlockPos blockPos3 = pos.west();
        BlockPos blockPos4 = pos.north();
        BlockPos blockPos5 = pos.south();
        BlockState blockState = world.getBlockState(blockPos);
        BlockState blockState1 = world.getBlockState(blockPos1);
        BlockState blockState2 = world.getBlockState(blockPos2);
        BlockState blockState3 = world.getBlockState(blockPos3);
        BlockState blockState4 = world.getBlockState(blockPos4);
        BlockState blockState5 = world.getBlockState(blockPos5);
        BlockState blockStatedried = ModBlocks.DRIED_LEAVES.getDefaultState().with(ROTTING, 1).with(DISTANCE, 3);
        BlockState blockStatedead = ModBlocks.DEAD_LEAVES.getDefaultState().with(DISTANCE, 3);

        if (random.nextInt(100) == 1 && state.get(ROTTING) == 1) {
            world.setBlockState(pos, blockStatedead);
        }
        if (random.nextInt(5) == 1) {
            if (blockState.isIn(ModTags.Blocks.ROTTABLE_LEAVES) && state.get(ROTTING) == 1) {
                world.setBlockState(blockPos, blockStatedried);
            }}
        if (random.nextInt(5) == 1) {
            if (blockState1.isIn(ModTags.Blocks.ROTTABLE_LEAVES) && state.get(ROTTING) == 1) {
                world.setBlockState(blockPos1, blockStatedried);
            }}
        if (random.nextInt(5) == 1) {
            if (blockState2.isIn(ModTags.Blocks.ROTTABLE_LEAVES) && state.get(ROTTING) == 1) {
                world.setBlockState(blockPos2, blockStatedried);
            }}
        if (random.nextInt(5) == 1) {
            if (blockState3.isIn(ModTags.Blocks.ROTTABLE_LEAVES) && state.get(ROTTING) == 1) {
                world.setBlockState(blockPos3, blockStatedried);
            }}
        if (random.nextInt(5) == 1) {
            if (blockState4.isIn(ModTags.Blocks.ROTTABLE_LEAVES) && state.get(ROTTING) == 1) {
                world.setBlockState(blockPos4, blockStatedried);
            }}
        if (random.nextInt(5) == 1) {
            if (blockState5.isIn(ModTags.Blocks.ROTTABLE_LEAVES)  && state.get(ROTTING) == 1) {
                world.setBlockState(blockPos5, blockStatedried);
            }}
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT, ROTTING, WATERLOGGED);
    }

}
