package net.tomsaw31.thefoodrealm.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.block.entity.ModBlockEntities;
import net.tomsaw31.thefoodrealm.block.entity.renderer.CookingPotBlockEntityRenderer;
import net.tomsaw31.thefoodrealm.block.entity.renderer.LemonChargerBlockEntityRenderer;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = TheFoodRealm.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.COOKING_POT_ENTITY.get(),
                    CookingPotBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.LEMON_CHARGER_BLOCK_ENTITY.get(),
                    LemonChargerBlockEntityRenderer::new);
        }
    }
}

