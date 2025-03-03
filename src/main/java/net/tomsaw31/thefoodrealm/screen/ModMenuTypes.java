package net.tomsaw31.thefoodrealm.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
        DeferredRegister.create(ForgeRegistries.MENU_TYPES, TheFoodRealm.MOD_ID);

    public static final RegistryObject<MenuType<LemonChargerMenu>> LEMON_CHARGER_MENU =
            registerMenuType(LemonChargerMenu::new, "lemon_charger_menu");
    public static final RegistryObject<MenuType<FreezerMenu>> FREEZER_MENU =
            registerMenuType(FreezerMenu::new, "freezer_menu");
    public static final RegistryObject<MenuType<CookingPotMenu>> COOKING_POT_MENU =
            registerMenuType(CookingPotMenu::new, "cooking_pot_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

