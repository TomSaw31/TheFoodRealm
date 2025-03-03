package net.tomsaw31.thefoodrealm.entity.client.armor;

import net.tomsaw31.thefoodrealm.item.custom.GhostPepperArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class GhostPepperArmorRenderer extends GeoArmorRenderer<GhostPepperArmorItem> {
    public GhostPepperArmorRenderer() {
        super(new GhostPepperArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
