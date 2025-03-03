package net.tomsaw31.thefoodrealm.world.biome;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.ModEntityTypes;
import net.tomsaw31.thefoodrealm.world.feature.ModPlacedFeatures;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registry.BIOME_REGISTRY, TheFoodRealm.MOD_ID);

    public static final RegistryObject<Biome> MINT_TREE_FOREST = registerBiome("mint_tree_forest", ModBiomes::mint_tree_forest);

    public static RegistryObject<Biome> registerBiome(String name, Supplier<Biome> biomeSupplier) {
        ResourceKey<Biome> biome = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(TheFoodRealm.MOD_ID, name));
        return BIOMES.register(biome.location().getPath(), biomeSupplier);
    }

    public static Biome mint_tree_forest() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntityTypes.ARMANGILLO.get(), 1, 0, 2));

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        //addModDecorations(biomeBuilder);
        //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MINT_TREE_PLACED.getHolder().get());

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE)
                .temperature(1.2f)
                .downfall(0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x00AAFF)
                        .waterFogColor(0x1d1352)
                        .fogColor(0x00AAFF)
                        .skyColor(0x00FFFF)
                        .ambientLoopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.055f))
                        .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SOUL_SAND_VALLEY)).build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    public static void addModDecorations(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MINT_TREE_PLACED.getHolder().get());
    }
    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}

