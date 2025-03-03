package net.tomsaw31.thefoodrealm.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.CuptoiseEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CuptoiseModel extends AnimatedGeoModel<CuptoiseEntity> {
    @Override
    public ResourceLocation getModelResource(CuptoiseEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "geo/cuptoise.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CuptoiseEntity object) {
        return CuptoiseRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }
    @Override
    public ResourceLocation getAnimationResource(CuptoiseEntity animatable) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "animations/cuptoise.animation.json");
    }


}
