package net.tomsaw31.thefoodrealm.fluid;

import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;

public class ModFluidsTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWERING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation ORANGE_JUICE_RL = new ResourceLocation("misc/in_orange_juice_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TheFoodRealm.MOD_ID);

    public static final RegistryObject<FluidType> ORANGE_JUICE_FLUID_TYPE = register("orange_juice_fluid",0xA1FFAF00, 255, 175, 0,
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));

    public static final RegistryObject<FluidType> SODA_FLUID_TYPE = register("soda_fluid", 0xA1AF5F00, 75, 10, 0,
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));

    public static final RegistryObject<FluidType> MAPLE_SYRUP_TYPE = register("maple_syrup_fluid", 0xA1821E08, 130, 31, 8,
            FluidType.Properties.create().lightLevel(0).density(5).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));

    private static RegistryObject<FluidType> register(String name, int color, int R, int G, int B, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWERING_RL, ORANGE_JUICE_RL,
                color, new Vector3f(R / 255f, G / 255f, B / 255f), properties ));
    }


    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}

