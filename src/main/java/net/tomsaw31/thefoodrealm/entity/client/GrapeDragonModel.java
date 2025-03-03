package net.tomsaw31.thefoodrealm.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.GrapeDragonEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GrapeDragonModel extends AnimatedGeoModel<GrapeDragonEntity> {
    @Override
    public ResourceLocation getModelResource(GrapeDragonEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "geo/grape_dragon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GrapeDragonEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/grape_dragon/grape_dragon.png");
    }
    @Override
    public ResourceLocation getAnimationResource(GrapeDragonEntity animatable) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "animations/grape_dragon.animation.json");
    }


}
