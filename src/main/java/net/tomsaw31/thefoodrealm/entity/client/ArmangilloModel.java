package net.tomsaw31.thefoodrealm.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.ArmangilloEntity;
import net.tomsaw31.thefoodrealm.entity.custom.GrapeDragonEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArmangilloModel extends AnimatedGeoModel<ArmangilloEntity> {
    @Override
    public ResourceLocation getModelResource(ArmangilloEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "geo/armangillo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArmangilloEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/armangillo/armangillo.png");
    }
    @Override
    public ResourceLocation getAnimationResource(ArmangilloEntity animatable) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "animations/armangillo.animation.json");
    }


}
