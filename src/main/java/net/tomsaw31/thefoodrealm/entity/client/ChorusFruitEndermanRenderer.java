package net.tomsaw31.thefoodrealm.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.tomsaw31.thefoodrealm.entity.custom.ChorusFruitEndermanEntity;
import net.tomsaw31.thefoodrealm.entity.custom.SlowshiEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class ChorusFruitEndermanRenderer extends GeoEntityRenderer<ChorusFruitEndermanEntity> {


    public ChorusFruitEndermanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ChorusFruitEndermanModel());
        this.shadowRadius = 1f;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        float f = -16.0F;
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("branch", CubeListBuilder.create().addBox("right_arm", -6.0F, -1.0F, -24.0F, 12, 5, 16, 176, 44), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 256, 256);
    }


    @Override
    public RenderType getRenderType(ChorusFruitEndermanEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable,texture,bufferSource,partialTick);
    }
}
