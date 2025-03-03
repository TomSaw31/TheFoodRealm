package net.tomsaw31.thefoodrealm.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier CHOCO = new ForgeTier(2, 300,8f,1f,
            15, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.CHOCO_INGOT.get()));
    public static final ForgeTier DARK_CHOCO = new ForgeTier(2, 500,6f,1f,
            20, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.DARK_CHOCO_INGOT.get()));
    public static final ForgeTier WHITE_CHOCO = new ForgeTier(3, 150,10f,1f,
            10, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.WHITE_CHOCO_INGOT.get()));
    public static final ForgeTier FORK = new ForgeTier(1, 96, 4.0F, 1.0F,
            5, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.IRON_INGOT));
    public static final ForgeTier CARAMEL = new ForgeTier(0, 200, 12.0F, 0.0F,
            22, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.CARAMEL_INGOT.get()));
    public static final ForgeTier GHOST_PEPPER = new ForgeTier(3, 1561, 8.0F, 3.0F, 15, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.GHOST_PEPPER.get()));
}
