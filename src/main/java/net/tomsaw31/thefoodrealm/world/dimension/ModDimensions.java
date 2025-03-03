package net.tomsaw31.thefoodrealm.world.dimension;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.tomsaw31.thefoodrealm.TheFoodRealm;

public class ModDimensions {
    public static final ResourceKey<Level> FOOD_REALM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(TheFoodRealm.MOD_ID, "food_realm"));
    public static final ResourceKey<DimensionType> FOOD_REALM_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, FOOD_REALM_KEY.registry());

    public static void register() {
        System.out.println("Register The Food Realm for " + TheFoodRealm.MOD_ID);
    }
}
