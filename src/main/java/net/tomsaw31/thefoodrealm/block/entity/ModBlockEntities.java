package net.tomsaw31.thefoodrealm.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.block.ModBlocks;
import net.tomsaw31.thefoodrealm.block.entity.custom.CookingPotBlockEntity;
import net.tomsaw31.thefoodrealm.block.entity.custom.FreezerBlockEntity;
import net.tomsaw31.thefoodrealm.block.entity.custom.LemonChargerBlockEntity;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TheFoodRealm.MOD_ID);

    //public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITY =
    //        BLOCK_ENTITIES.register("sign_block_entity", () ->
    //                BlockEntityType.Builder.of(ModSignBlockEntity::new,
    //                        ModBlocks.MINT_TREE_WALL_SIGN.get(),
    //                        ModBlocks.MINT_TREE_SIGN.get())
    //                        .build(null));


    public static final RegistryObject<BlockEntityType<LemonChargerBlockEntity>> LEMON_CHARGER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("lemon_charger_block_entity", ()->
                    BlockEntityType.Builder.of(LemonChargerBlockEntity::new,
                    ModBlocks.LEMON_CHARGER.get())
                            .build(null));

    public static final RegistryObject<BlockEntityType<FreezerBlockEntity>> FREEZER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("freezer_block_entity", ()->
                    BlockEntityType.Builder.of(FreezerBlockEntity::new,
                            ModBlocks.FREEZER.get())
                            .build(null));

    public static final RegistryObject<BlockEntityType<CookingPotBlockEntity>> COOKING_POT_ENTITY =
            BLOCK_ENTITIES.register("cooking_pot_entity", ()->
                    BlockEntityType.Builder.of(CookingPotBlockEntity::new, ModBlocks.COOKING_POT.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
