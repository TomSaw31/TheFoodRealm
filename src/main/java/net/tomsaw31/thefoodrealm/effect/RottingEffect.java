package net.tomsaw31.thefoodrealm.effect;

import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.items.ItemHandlerHelper;
import net.tomsaw31.thefoodrealm.item.ModItems;
import net.tomsaw31.thefoodrealm.util.ModTags;

public class RottingEffect extends MobEffect {
    public RottingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
    int timer = 0;

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        Integer level = pAmplifier;
        if (level>3) { level=3;}
        if(!pLivingEntity.level.isClientSide) {
        if (pLivingEntity instanceof Player player) {
            timer=timer+1;
            if(timer>=100-(level*5)) {
                timer=0;
                for (int i = 0; i < player.getInventory().items.size(); i++) {
                    if (player.getInventory().items.get(i).isEdible() && player.getInventory().items.get(i)!=new ItemStack(Items.ROTTEN_FLESH) && player.getInventory().items.get(i)!=new ItemStack(ModItems.CHEESE.get()) && player.getInventory().items.get(i)!=new ItemStack(Items.HONEY_BOTTLE)) {
                        ItemStack toremove = player.getInventory().items.get(i);
                        player.getInventory().clearOrCountMatchingItems(x -> toremove.getItem() == x.getItem(), 1, player.inventoryMenu.getCraftSlots());
                        ItemStack stack = new ItemStack(Items.ROTTEN_FLESH);
                        ItemHandlerHelper.giveItemToPlayer(player, stack);
                        break;
                    }
                }
            }
            }

        }

    }
        @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }



}
