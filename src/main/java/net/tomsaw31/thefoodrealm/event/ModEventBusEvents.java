package net.tomsaw31.thefoodrealm.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.ModEntityTypes;
import net.tomsaw31.thefoodrealm.entity.custom.*;
import net.tomsaw31.thefoodrealm.recipe.FreezerRecipe;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = TheFoodRealm.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.SLOWSHI.get(), SlowshiEntity.setAttributes());
        event.put(ModEntityTypes.GRAPE_DRAGON.get(), GrapeDragonEntity.setAttributes());
        event.put(ModEntityTypes.ARMANGILLO.get(), ArmangilloEntity.setAttributes());
        event.put(ModEntityTypes.CUPTOISE.get(), CuptoiseEntity.setAttributes());
        event.put(ModEntityTypes.BEETARROT.get(), BeetarrotEntity.setAttributes());
        event.put(ModEntityTypes.GINGERBREAD_MAN.get(), GingerbreadManEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(TheFoodRealm.MOD_ID, FreezerRecipe.Type.ID),
                    FreezerRecipe.Type.INSTANCE);
        });
    }
}
