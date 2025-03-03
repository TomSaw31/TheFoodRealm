package net.tomsaw31.thefoodrealm.item.custom;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tomsaw31.thefoodrealm.util.ModTags;

public class ForkItem extends PickaxeItem {
    public ForkItem(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos blockPos, LivingEntity livingEntity) {
        if(!level.isClientSide) {
            if (state.is(ModTags.Blocks.FORK)) {
                if (livingEntity instanceof Player player) {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 1);
                    return super.mineBlock(null, level, state, blockPos, livingEntity);
                }
            }
        }
        return super.mineBlock(itemStack, level, state, blockPos, livingEntity);
    }


}
