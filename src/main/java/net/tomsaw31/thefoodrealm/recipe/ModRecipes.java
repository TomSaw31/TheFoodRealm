package net.tomsaw31.thefoodrealm.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TheFoodRealm.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FreezerRecipe>> FREEZER_SERIALIZER =
            SERIALIZERS.register("freezer", ()-> FreezerRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CookingPotRecipe>> COOKING_POT_SERIALIZER =
            SERIALIZERS.register("cooking_pot", ()-> CookingPotRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
