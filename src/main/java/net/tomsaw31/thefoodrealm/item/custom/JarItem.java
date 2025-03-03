package net.tomsaw31.thefoodrealm.item.custom;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.tomsaw31.thefoodrealm.item.ModItems;

public class JarItem extends Item {
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 7);

    public JarItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return this.UseItem(itemStack);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;

    }

    public ItemStack UseItem(ItemStack itemStack) {
        ItemStack container = itemStack.copy();
        if (container.getDamageValue() != 7) {
            container.hurt(1, RandomSource.create(), null);
            itemStack.getOrCreateTag().putDouble("durability", container.getDamageValue());
            return container;
        } else {
            return new ItemStack(ModItems.EMPTY_JAR.get());
        }

    }
}



