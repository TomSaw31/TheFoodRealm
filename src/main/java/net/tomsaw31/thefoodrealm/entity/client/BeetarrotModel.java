package net.tomsaw31.thefoodrealm.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.BeetarrotEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BeetarrotModel extends AnimatedGeoModel<BeetarrotEntity> {
    @Override
    public ResourceLocation getModelResource(BeetarrotEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "geo/beetarrot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BeetarrotEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/beetarrot/beetarrot.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BeetarrotEntity animatable) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "animations/beetarrot.animation.json");
    }
}
