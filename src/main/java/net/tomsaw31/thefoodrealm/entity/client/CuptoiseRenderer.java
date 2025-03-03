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
import net.tomsaw31.thefoodrealm.entity.custom.CuptoiseEntity;
import net.tomsaw31.thefoodrealm.entity.variant.CuptoiseVariant;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class CuptoiseRenderer extends GeoEntityRenderer<CuptoiseEntity> {

    public static final Map<CuptoiseVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CuptoiseVariant.class), (p_114874_) -> {
                p_114874_.put(CuptoiseVariant.PINK,
                        new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/cuptoise/cuptoise_pink.png"));
                p_114874_.put(CuptoiseVariant.BLUE,
                        new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/cuptoise/cuptoise_blue.png"));
                p_114874_.put(CuptoiseVariant.YELLOW,
            new ResourceLocation(TheFoodRealm.MOD_ID, "textures/entity/cuptoise/cuptoise_yellow.png"));});


    
    
    
    
    public CuptoiseRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CuptoiseModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(CuptoiseEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(CuptoiseEntity animatable, float partialTicks, PoseStack stack,
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
