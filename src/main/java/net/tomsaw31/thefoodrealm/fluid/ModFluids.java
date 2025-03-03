package net.tomsaw31.thefoodrealm.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.block.ModBlocks;
import net.tomsaw31.thefoodrealm.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid>  FLUIDS =
            DeferredRegister.create(ForgeRegistries.Keys.FLUIDS, TheFoodRealm.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_ORANGE_JUICE = FLUIDS.register("orange_juice_water_fluid",
            ()-> new ForgeFlowingFluid.Source(ModFluids.ORANGE_JUICE_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_ORANGE_JUICE_WATER = FLUIDS.register("flowing_orange_juice_water",
            ()-> new ForgeFlowingFluid.Flowing(ModFluids.ORANGE_JUICE_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_SODA = FLUIDS.register("soda_water_fluid",
            ()-> new ForgeFlowingFluid.Source(ModFluids.SODA_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_SODA_WATER = FLUIDS.register("flowing_soda_water",
            ()-> new ForgeFlowingFluid.Flowing(ModFluids.SODA_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_MAPLE_SYRUP = FLUIDS.register("maple_syrup_fluid",
            ()-> new ForgeFlowingFluid.Source(ModFluids.ORANGE_JUICE_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_MAPLE_SYRUP = FLUIDS.register("flowing_maple_syrup",
            ()-> new ForgeFlowingFluid.Flowing(ModFluids.ORANGE_JUICE_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties ORANGE_JUICE_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.ORANGE_JUICE_FLUID_TYPE, SOURCE_ORANGE_JUICE, FLOWING_ORANGE_JUICE_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.ORANGE_JUICE_WATER_BLOCK).bucket(ModItems.ORANGE_JUICE_WATER_BUCKET);

    public static final ForgeFlowingFluid.Properties SODA_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.SODA_FLUID_TYPE, SOURCE_SODA, FLOWING_SODA_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.SODA_WATER_BLOCK).bucket(ModItems.SODA_WATER_BUCKET);

    public static final ForgeFlowingFluid.Properties MAPLE_SYRUP_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.MAPLE_SYRUP_TYPE, SOURCE_MAPLE_SYRUP, FLOWING_MAPLE_SYRUP)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.MAPLE_SYRUP_BLOCK).bucket(ModItems.MAPLE_SYRUP_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);

    }
}
