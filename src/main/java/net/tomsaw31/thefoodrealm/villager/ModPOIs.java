package net.tomsaw31.thefoodrealm.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.block.ModBlocks;

import java.lang.reflect.InvocationTargetException;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI_TYPES
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, TheFoodRealm.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TheFoodRealm.MOD_ID);

    public static final RegistryObject<PoiType> FREEZER_BLOCK_POI = POI_TYPES.register("freezer_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.FREEZER.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> FRUITS_MERCHANT = VILLAGER_PROFESSIONS.register("fruits_merchant",
            () -> new VillagerProfession("fruits_merchant", x -> x.get() == FREEZER_BLOCK_POI.get(),
                    x -> x.get() == FREEZER_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FARMER));

    public static final RegistryObject<PoiType> COOKING_POT_BLOCK_POI = POI_TYPES.register("cooking_pot_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.COOKING_POT.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> CHEF = VILLAGER_PROFESSIONS.register("chef",
            () -> new VillagerProfession("chef", x -> x.get() == COOKING_POT_BLOCK_POI.get(),
                    x -> x.get() == COOKING_POT_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_BUTCHER));












    public static final RegistryObject<PoiType> FOOD_PORTAL =
            POI_TYPES.register("food_portal", () -> new PoiType(
                    ImmutableSet.copyOf(ModBlocks.FOOD_PORTAl.get().getStateDefinition().getPossibleStates())
            ,0,1));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, FREEZER_BLOCK_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}