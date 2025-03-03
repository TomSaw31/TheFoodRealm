package net.tomsaw31.thefoodrealm.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.BeetarrotEntity;
import net.tomsaw31.thefoodrealm.entity.custom.GingerbreadManEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GingerbreadManModel extends AnimatedGeoModel<GingerbreadManEntity> {
    @Override
    public ResourceLocation getModelResource(GingerbreadManEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "geo/gingerbread_man.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GingerbreadManEntity object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/gingerbread_man/gingerbread_man.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GingerbreadManEntity animatable) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "animations/gingerbread_man.animation.json");
    }
}
