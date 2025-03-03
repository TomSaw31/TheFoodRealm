package net.tomsaw31.thefoodrealm.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.item.custom.GhostPepperArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GhostPepperArmorModel extends AnimatedGeoModel<GhostPepperArmorItem> {
    @Override
    public ResourceLocation getModelResource(GhostPepperArmorItem object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "geo/ghost_pepper_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GhostPepperArmorItem object) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "textures/armor/ghost_pepper_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GhostPepperArmorItem animatable) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "animations/ghost_pepper_armor.animation.json");
    }
}