package net.tomsaw31.thefoodrealm.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TheFoodRealm.MOD_ID);

    public static RegistryObject<Enchantment> PUTREFIED_STRIKE =
            ENCHANTMENTS.register("putrefied_strike",
                    () -> new PutrefiedStrikeEnchantment(Enchantment.Rarity.COMMON,
                            EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}