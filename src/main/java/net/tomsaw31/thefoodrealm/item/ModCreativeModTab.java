package net.tomsaw31.thefoodrealm.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tomsaw31.thefoodrealm.block.ModBlocks;

public class ModCreativeModTab {
    public static final CreativeModeTab THE_FOOD_REALM_FOOD = new CreativeModeTab("the_food_realm_food_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.STRAWBERRY.get());
        }
    };
    public static final CreativeModeTab THE_FOOD_REALM_BLOCKS= new CreativeModeTab("the_food_realm_blocks_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CHOCO_BLOCK.get());
        }
    };
    public static final CreativeModeTab THE_FOOD_REALM_TOOLS = new CreativeModeTab("the_food_realm_tools_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GHOST_PEPPER_SWORD.get());
        }
    };
    public static final CreativeModeTab THE_FOOD_REALM_MISCELLANEOUS = new CreativeModeTab("the_food_realm_miscellaneous_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ARMANGILLO_SPAWN_EGG.get());
        }
    };
}
