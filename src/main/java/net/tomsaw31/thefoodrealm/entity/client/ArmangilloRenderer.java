package net.tomsaw31.thefoodrealm.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.entity.custom.ArmangilloEntity;
import net.tomsaw31.thefoodrealm.entity.custom.GrapeDragonEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ArmangilloRenderer extends GeoEntityRenderer<ArmangilloEntity> {



    public ArmangilloRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ArmangilloModel());
        this.shadowRadius = 0.3f;
    }


    @Override
    public RenderType getRenderType(ArmangilloEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        if(animatable.isBaby()) {
            stack.scale(0.4F, 0.4F, 0.4F);
        } else {
            stack.scale(1.25F, 1.25F, 1.25F);
        }

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
