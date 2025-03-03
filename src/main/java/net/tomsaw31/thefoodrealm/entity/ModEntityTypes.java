package net.tomsaw31.thefoodrealm.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.entity.custom.*;

public class ModEntityTypes{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheFoodRealm.MOD_ID);

    public static final RegistryObject<EntityType<SlowshiEntity>> SLOWSHI =
            ENTITY_TYPES.register("slowshi",
                    () -> EntityType.Builder.of(SlowshiEntity::new, MobCategory.CREATURE)
                            .sized(1f, 0.7f)
                            .build(new ResourceLocation(TheFoodRealm.MOD_ID, "slowshi").toString()));

    public static final RegistryObject<EntityType<GrapeDragonEntity>> GRAPE_DRAGON =
            ENTITY_TYPES.register("grape_dragon",
                    () -> EntityType.Builder.of(GrapeDragonEntity::new, MobCategory.CREATURE)
                            .sized(5f, 5f)
                            .build(new ResourceLocation(TheFoodRealm.MOD_ID, "grape_dragon").toString()));

    public static final RegistryObject<EntityType<ArmangilloEntity>> ARMANGILLO =
            ENTITY_TYPES.register("armangillo",
                    () -> EntityType.Builder.of(ArmangilloEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.7f)
                            .build(new ResourceLocation(TheFoodRealm.MOD_ID, "armangillo").toString()));

    public static final RegistryObject<EntityType<CuptoiseEntity>> CUPTOISE =
            ENTITY_TYPES.register("cuptoise",
                    () -> EntityType.Builder.of(CuptoiseEntity::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.9f)
                            .build(new ResourceLocation(TheFoodRealm.MOD_ID, "cuptoise").toString()));

    public static final RegistryObject<EntityType<BeetarrotEntity>> BEETARROT =
            ENTITY_TYPES.register("beetarrot",
                    () -> EntityType.Builder.of(BeetarrotEntity::new, MobCategory.MONSTER)
                            .sized(1.25f, 0.6f)
                            .build(new ResourceLocation(TheFoodRealm.MOD_ID, "beetarrot").toString()));

    public static final RegistryObject<EntityType<GingerbreadManEntity>> GINGERBREAD_MAN =
            ENTITY_TYPES.register("gingerbread_man",
                    () -> EntityType.Builder.of(GingerbreadManEntity::new, MobCategory.MONSTER)
                            .sized(0.75f, 2f)
                            .build(new ResourceLocation(TheFoodRealm.MOD_ID, "gingerbread_man").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
