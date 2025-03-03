package net.tomsaw31.thefoodrealm.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.ChorusFruitEndermanEntity;
import software.bernie.geckolib.model.GeoModel;

public class ChorusFruitEndermanModel extends GeoModel<ChorusFruitEndermanEntity> {
    @Override
    public ResourceLocation getModelResource(ChorusFruitEndermanEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "geo/chorus_fruit_enderman.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChorusFruitEndermanEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/chorus_fruit_enderman/chorus_fruit_enderman.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChorusFruitEndermanEntity animatable) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "animations/chorus_fruit_enderman.animation.json");
    }
}
