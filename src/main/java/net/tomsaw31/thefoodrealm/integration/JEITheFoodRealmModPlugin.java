package net.tomsaw31.thefoodrealm.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.recipe.CookingPotRecipe;
import net.tomsaw31.thefoodrealm.recipe.FreezerRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITheFoodRealmModPlugin implements IModPlugin {
    public static RecipeType<CookingPotRecipe> COOKING_TYPE =
            new RecipeType<>(CookingPotRecipeCategory.UID, CookingPotRecipe.class);
    public static RecipeType<FreezerRecipe> FREEZER =
            new RecipeType<>(FreezerRecipeCategory.UID, FreezerRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                CookingPotRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                FreezerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<CookingPotRecipe> recipesInfusing = rm.getAllRecipesFor(CookingPotRecipe.Type.INSTANCE);
        registration.addRecipes(COOKING_TYPE, recipesInfusing);
        List<FreezerRecipe> recipesFreezer = rm.getAllRecipesFor(FreezerRecipe.Type.INSTANCE);
        registration.addRecipes(FREEZER, recipesFreezer);
    }
}
