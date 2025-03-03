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
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.block.ModBlocks;
import net.tomsaw31.thefoodrealm.recipe.CookingPotRecipe;

public class CookingPotRecipeCategory  implements IRecipeCategory<CookingPotRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(TheFoodRealm.MOD_ID, "cooking_pot");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(TheFoodRealm.MOD_ID, "textures/gui/cooking_pot_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CookingPotRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COOKING_POT.get()));
    }

    @Override
    public RecipeType<CookingPotRecipe> getRecipeType() {
        return JEITheFoodRealmModPlugin.COOKING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Cooking Pot");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CookingPotRecipe recipe, IFocusGroup focuses) {


        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            if (i<3) {
                builder.addSlot(RecipeIngredientRole.INPUT, i * 18+44, 23).addIngredients(recipe.getIngredients().get(i));
            } else {
                builder.addSlot(RecipeIngredientRole.INPUT, i * 18-10, 41).addIngredients(recipe.getIngredients().get(i));
            }

        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, 140, 33).addItemStack(recipe.getResultItem());
    }
}