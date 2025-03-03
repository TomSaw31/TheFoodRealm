package net.tomsaw31.thefoodrealm.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.SlowshiEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SlowshiModel extends AnimatedGeoModel<SlowshiEntity> {
    @Override
    public ResourceLocation getModelResource(SlowshiEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "geo/slowshi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SlowshiEntity object) {
        return SlowshiRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }
    @Override
    public ResourceLocation getAnimationResource(SlowshiEntity animatable) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "animations/slowshi.animation.json");
    }


}
