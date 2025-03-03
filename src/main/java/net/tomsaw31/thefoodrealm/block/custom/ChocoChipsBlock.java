package net.tomsaw31.thefoodrealm.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChocoChipsBlock extends CarpetBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty COLOR = IntegerProperty.create("color",0,15);
    public ChocoChipsBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }



    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player.getMainHandItem().getItem() instanceof DyeItem) {
            if (!level.isClientSide) {
                if (player.getMainHandItem().getItem() == Items.BROWN_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,0),0);
                }
                if (player.getMainHandItem().getItem() == Items.ORANGE_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,1),1);
                }
                if (player.getMainHandItem().getItem() == Items.MAGENTA_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,2),2);
                }
                if (player.getMainHandItem().getItem() == Items.LIGHT_BLUE_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,3),3);
                }
                if (player.getMainHandItem().getItem() == Items.YELLOW_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,4),4);
                }
                if (player.getMainHandItem().getItem() == Items.LIME_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,5),5);
                }
                if (player.getMainHandItem().getItem() == Items.PINK_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,6),6);
                }
                if (player.getMainHandItem().getItem() == Items.GRAY_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,7),7);
                }
                if (player.getMainHandItem().getItem() == Items.LIGHT_GRAY_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,8),8);
                }
                if (player.getMainHandItem().getItem() == Items.CYAN_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,9),9);
                }
                if (player.getMainHandItem().getItem() == Items.PURPLE_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,10),10);
                }
                if (player.getMainHandItem().getItem() == Items.BLUE_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,11),11);
                }
                if (player.getMainHandItem().getItem() == Items.WHITE_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,12),12);
                }
                if (player.getMainHandItem().getItem() == Items.GREEN_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,13),13);
                }
                if (player.getMainHandItem().getItem() == Items.RED_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,14),14);
                }
                if (player.getMainHandItem().getItem() == Items.BLACK_DYE) {
                    level.setBlock(blockPos, state.setValue(COLOR,15),15);
                }



                level.playSound((Player) null, blockPos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.FAIL;


    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(COLOR);
    }
}
