package net.tomsaw31.thefoodrealm.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class FortuneCookieItem extends Item {
    public FortuneCookieItem(Properties p_40710_) {
        super(p_40710_);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        ItemStack itemstack = super.finishUsingItem(itemStack, level, livingEntity);
        if (!level.isClientSide) {
            if (livingEntity instanceof Player player) {
                Integer value = RandomSource.createNewThreadLocalInstance().nextInt(10);
                switch (value) {
                    case 0:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("Error 404 : Message not found")));
                        break;
                    case 1:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("Imagination")));
                        break;
                    case 2:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("Trying is the first step towards failure")));
                        break;
                    case 3:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("Amogus")));
                        break;
                    case 4:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("Ok Zoomer")));
                        break;
                    case 5:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("You're no stranger to love")));
                        break;
                    case 6:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("Reject your humanity")));
                        break;
                    case 7:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("Your dog stepped on a bee")));
                        break;
                    case 8:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("Do or do not, there is no try")));
                        break;
                    case 9:
                        player.getInventory().add(new ItemStack(Items.PAPER).setHoverName(Component.literal("You've met with a terrible fate")));
                        break;
                }
            }
        }

        return itemstack;
    }
}

