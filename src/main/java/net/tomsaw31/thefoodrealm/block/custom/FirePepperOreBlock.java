package net.tomsaw31.thefoodrealm.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FirePepperOreBlock extends RedStoneOreBlock {
    public FirePepperOreBlock(Properties p_221081_) {
        super(p_221081_);
    }

    @Override
    public void stepOn(Level p_152431_, BlockPos p_152432_, BlockState p_152433_, Entity p_152434_) {
        if (!p_152431_.isClientSide) {
            p_152434_.setSecondsOnFire(7);
        }
        super.stepOn(p_152431_, p_152432_, p_152433_, p_152434_);
    }

}
