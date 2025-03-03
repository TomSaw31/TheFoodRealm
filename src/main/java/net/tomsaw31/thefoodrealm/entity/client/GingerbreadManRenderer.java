package net.tomsaw31.thefoodrealm.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.GingerbreadManEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class GingerbreadManRenderer extends GeoEntityRenderer<GingerbreadManEntity> {
    public GingerbreadManRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GingerbreadManModel());
        this.shadowRadius = 0.6f;
    }

    @Override
    public ResourceLocation getTextureLocation(GingerbreadManEntity instance) {
        return new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/gingerbread_man/gingerbread_man.png");
    }

    @Override
    public RenderType getRenderType(GingerbreadManEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1, 1, 1);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}