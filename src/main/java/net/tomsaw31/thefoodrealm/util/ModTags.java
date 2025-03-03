package net.tomsaw31.thefoodrealm.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tomsaw31.thefoodrealm.TheFoodRealm;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PORTAL_FRAME_BLOCKS = tag("portal_frame_blocks");
        public static final TagKey<Block> FORK = tag("fork");
        public static final TagKey<Block> COOKING_POT_FIRE = tag("cooking_pot_fire");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TheFoodRealm.MOD_ID, name));
        }

        private static  TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }


    public static class Items {
        public static final TagKey<Item> COOKING_POT_FOOD = tag("cooking_pot_food_items");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TheFoodRealm.MOD_ID, name));
        }

        private static  TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));


        }



    }

}