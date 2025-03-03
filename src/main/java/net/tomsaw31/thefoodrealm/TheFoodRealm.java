package net.tomsaw31.thefoodrealm;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tomsaw31.thefoodrealm.block.ModBlocks;
import net.tomsaw31.thefoodrealm.block.entity.ModBlockEntities;
import net.tomsaw31.thefoodrealm.block.entity.ModWoodTypes;
import net.tomsaw31.thefoodrealm.block.entity.renderer.CookingPotBlockEntityRenderer;
import net.tomsaw31.thefoodrealm.effect.ModEffects;
import net.tomsaw31.thefoodrealm.enchant.ModEnchantments;
import net.tomsaw31.thefoodrealm.entity.ModEntityTypes;
import net.tomsaw31.thefoodrealm.entity.client.*;
import net.tomsaw31.thefoodrealm.fluid.ModFluids;
import net.tomsaw31.thefoodrealm.fluid.ModFluidsTypes;
import net.tomsaw31.thefoodrealm.item.ModItems;
import net.tomsaw31.thefoodrealm.networking.ModMessages;
import net.tomsaw31.thefoodrealm.recipe.ModRecipes;
import net.tomsaw31.thefoodrealm.screen.*;
import net.tomsaw31.thefoodrealm.villager.ModPOIs;
import net.tomsaw31.thefoodrealm.world.biome.ModBiomeModifiers;
import net.tomsaw31.thefoodrealm.world.biome.ModBiomes;
import net.tomsaw31.thefoodrealm.world.dimension.ModDimensions;
import net.tomsaw31.thefoodrealm.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TheFoodRealm.MOD_ID)
public class TheFoodRealm
{
    public static final String MOD_ID = "thefoodrealm";

    private static final Logger LOGGER = LogUtils.getLogger();
    public TheFoodRealm()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModEffects.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidsTypes.register(modEventBus);
        ModDimensions.register();
        ModPOIs.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModEnchantments.register(modEventBus);
        ModBiomes.register(modEventBus);
        ModBiomeModifiers.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);






        GeckoLib.initialize();
        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModMessages.register();
            ModPOIs.registerPOIs();
            Sheets.addWoodType(ModWoodTypes.MINT_TREE);
            SpawnPlacements.register(ModEntityTypes.GINGERBREAD_MAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
            SpawnPlacements.register(ModEntityTypes.ARMANGILLO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.SLOWSHI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.CUPTOISE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ModEntityTypes.BEETARROT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);


        });
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_ORANGE_JUICE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_ORANGE_JUICE_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SODA.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SODA_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MAPLE_SYRUP.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SODA_WATER.get(), RenderType.translucent());
            WoodType.register(ModWoodTypes.MINT_TREE);
            EntityRenderers.register(ModEntityTypes.SLOWSHI.get(), SlowshiRenderer::new);
            EntityRenderers.register(ModEntityTypes.GRAPE_DRAGON.get(), GrapeDragonRenderer::new);
            EntityRenderers.register(ModEntityTypes.CUPTOISE.get(), CuptoiseRenderer::new);
            EntityRenderers.register(ModEntityTypes.ARMANGILLO.get(), ArmangilloRenderer::new);
            EntityRenderers.register(ModEntityTypes.BEETARROT.get(), BeetarrotRenderer::new);
            EntityRenderers.register(ModEntityTypes.GINGERBREAD_MAN.get(), GingerbreadManRenderer::new);
            MenuScreens.register(ModMenuTypes.LEMON_CHARGER_MENU.get(), LemonChargerScreen::new);
            MenuScreens.register(ModMenuTypes.FREEZER_MENU.get(), FreezerScreen::new);
            MenuScreens.register(ModMenuTypes.COOKING_POT_MENU.get(), CookingPotScreen::new);
        }
    }


}
