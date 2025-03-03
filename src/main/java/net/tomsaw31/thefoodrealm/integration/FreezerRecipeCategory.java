package net.tomsaw31.thefoodrealm.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.block.ModBlocks;
import net.tomsaw31.thefoodrealm.item.ModItems;
import net.tomsaw31.thefoodrealm.recipe.FreezerRecipe;

public class FreezerRecipeCategory implements IRecipeCategory<FreezerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TheFoodRealm.MOD_ID, "freezer");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TheFoodRealm.MOD_ID, "textures/gui/freezer_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public FreezerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FREEZER.get()));
    }

    @Override
    public RecipeType<FreezerRecipe> getRecipeType() {
        return JEITheFoodRealmModPlugin.FREEZER;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Freezer");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FreezerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 126, 40).addIngredients(Ingredient.of(new ItemStack(ModItems.CHARGED_LEMON.get())));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 103, 18).addIngredients(Ingredient.of(new ItemStack(Blocks.BLUE_ICE)));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getResultItem());
    }
}

