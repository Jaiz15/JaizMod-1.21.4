package jaiz.jaizmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CrafterBlock;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.enums.Orientation;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;

public class ExtraDirectionalModelBlock extends Block {
    public ExtraDirectionalModelBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Orientation.NORTH_UP));
    }
    private static final EnumProperty<Orientation> FACING = Properties.ORIENTATION;


    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerLookDirection().getOpposite();

        Direction direction2 = switch (direction) {
            case DOWN -> ctx.getHorizontalPlayerFacing().getOpposite();
            case UP -> ctx.getHorizontalPlayerFacing();
            case NORTH, SOUTH, WEST, EAST -> Direction.UP;
        };
        return this.getDefaultState()
                .with(FACING, Orientation.byDirections(direction, direction2));
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.getDirectionTransformation().mapJigsawOrientation(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.with(FACING, mirror.getDirectionTransformation().mapJigsawOrientation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
