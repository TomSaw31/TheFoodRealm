package net.tomsaw31.thefoodrealm.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FirePepperItem extends Item {
    public FirePepperItem(Properties p_40710_) {
        super(p_40710_);
    }

    public ItemStack finishUsingItem(ItemStack p_40712_, Level p_40713_, LivingEntity p_40714_) {
        ItemStack itemstack = super.finishUsingItem(p_40712_, p_40713_, p_40714_);
        if (!p_40713_.isClientSide) {
            p_40714_.setSecondsOnFire(7);
            }

        return itemstack;
    }
}

