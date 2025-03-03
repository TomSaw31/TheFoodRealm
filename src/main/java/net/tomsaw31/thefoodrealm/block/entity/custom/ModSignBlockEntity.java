package net.tomsaw31.thefoodrealm.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tomsaw31.thefoodrealm.block.entity.ModBlockEntities;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(pWorldPosition, pBlockState);
    }

    //@Override
    //public BlockEntityType<?> getType() {
    //    return ModBlockEntities.SIGN_BLOCK_ENTITY.get();
    //}
}
