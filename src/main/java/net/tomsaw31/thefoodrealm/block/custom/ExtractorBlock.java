package net.tomsaw31.thefoodrealm.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemHandlerHelper;
import net.tomsaw31.thefoodrealm.block.ModBlocks;
import net.tomsaw31.thefoodrealm.item.ModItems;

public class ExtractorBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ExtractorBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape SHAPE = Block.box(0,0,0,16,16,16);

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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }


    @Override
            public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
            if (player.getMainHandItem().getItem() == Items.GLASS_BOTTLE) {
                    if (state.getValue(FACING).toString() == "north") {
                            getSap(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ() + 1), level, player);
                        }
                    if (state.getValue(FACING).toString() == "south") {
                            getSap(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ() - 1), level, player);
                        }
                    if (state.getValue(FACING).toString() == "west") {
                            getSap(new BlockPos(blockPos.getX() + 1, blockPos.getY(), blockPos.getZ()), level, player);
                        }
                    if (state.getValue(FACING).toString() == "east") {
                            getSap(new BlockPos(blockPos.getX() - 1, blockPos.getY(), blockPos.getZ()), level, player);
                    }

                }

            return super.use(state, level, blockPos, player, interactionHand, blockHitResult);
        }

    public void getSap(BlockPos blockPos, Level level, Player player) {
        if ((level.getBlockState(blockPos).getBlock() == Blocks.OAK_LOG)) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.OAK_SAP.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == Blocks.SPRUCE_LOG)) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.SPRUCE_SAP.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == Blocks.BIRCH_LOG)) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.BIRCH_SAP.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == Blocks.DARK_OAK_LOG)) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.DARK_OAK_SAP.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == Blocks.JUNGLE_LOG)) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.JUNGLE_SAP.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == Blocks.MANGROVE_LOG)) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.MANGROVE_SAP.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == Blocks.ACACIA_LOG)) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.ACACIA_SAP.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == ModBlocks.MINT_TREE_LOG.get())) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.MINT_TREE_SAP.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == ModBlocks.STRAWBERRY_BLOCK.get())) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.STRAWBERRY_JUICE.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == ModBlocks.GRAPE_BLOCK.get())) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.GRAPE_JUICE.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == ModBlocks.CARROT_BLOCK.get())) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.CARROT_JUICE.get()));
        }
        if ((level.getBlockState(blockPos).getBlock() == ModBlocks.PINEAPPLE_BLOCK.get())) {
            player.getMainHandItem().shrink(1);
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.PINEAPPLE_JUICE.get()));
        }
    }
}
