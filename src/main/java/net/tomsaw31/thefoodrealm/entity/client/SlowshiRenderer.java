package net.tomsaw31.thefoodrealm.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.SlowshiEntity;
import net.tomsaw31.thefoodrealm.entity.variant.SlushyVariant;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class SlowshiRenderer extends GeoEntityRenderer<SlowshiEntity> {

    public static final Map<SlushyVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SlushyVariant.class), (p_114874_) -> {
                p_114874_.put(SlushyVariant.DEFAULT,
                        new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/slowshi/slowshi_default.png"));
                p_114874_.put(SlushyVariant.BLACK,
                        new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/slowshi/slowshi_black.png"));});


    
    
    
    
    public SlowshiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SlowshiModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(SlowshiEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(SlowshiEntity animatable, float partialTicks, PoseStack stack,
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
