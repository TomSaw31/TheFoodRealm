package net.tomsaw31.thefoodrealm.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.block.ModBlocks;
import net.tomsaw31.thefoodrealm.entity.ModEntityTypes;
import net.tomsaw31.thefoodrealm.fluid.ModFluids;
import net.tomsaw31.thefoodrealm.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheFoodRealm.MOD_ID);



    //FOOD
    public static final RegistryObject<Item> FIRE_PEPPER = ITEMS.register("fire_pepper",
            () -> new FirePepperItem(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FIRE_PEPPER)));
    public static final RegistryObject<Item> GHOST_PEPPER = ITEMS.register("ghost_pepper",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));


    //FRUITS
    public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(), (new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.BLUEBERRIES))));
    public static final RegistryObject<Item> BLACKBERRIES = ITEMS.register("blackberries",
            () -> new ItemNameBlockItem(ModBlocks.BLACKBERRY_BUSH.get(), (new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.BLACKBERRIES))));
    public static final RegistryObject<Item> RASPBERRY = ITEMS.register("raspberry",
            () -> new ItemNameBlockItem(ModBlocks.RASPBERRY_BUSH.get(), (new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.RASPBERRIES))));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_BUSH.get(), (new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.STRAWBERRIES))));
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> CHERRIES = ITEMS.register("cherries",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> KIWI = ITEMS.register("kiwi",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> FIG = ITEMS.register("fig",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.FRUIT)));
    public static final RegistryObject<Item> MINT = ITEMS.register("mint",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> VANILLA = ITEMS.register("vanilla",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));




    //CRAFTED FOOD
    public static final RegistryObject<Item> FIRE_PEPPER_POWDER = ITEMS.register("fire_pepper_powder",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> DOUGH = ITEMS.register("dough",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> CHOCO_CHIP = ITEMS.register("choco_chips",
            () -> new ItemNameBlockItem(ModBlocks.CHOCO_CHIPS_BLOCK.get(), (new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD))));
    public static final RegistryObject<Item> CHOCO_INGOT = ITEMS.register("choco_ingot", CatalystItem::new);
    public static final RegistryObject<Item> DARK_CHOCO_INGOT = ITEMS.register("dark_choco_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> WHITE_CHOCO_INGOT = ITEMS.register("white_choco_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> CARAMEL_INGOT = ITEMS.register("caramel_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> GHOST_PEPPER_INGOT = ITEMS.register("ghost_pepper_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> CHARGED_LEMON = ITEMS.register("charged_lemon",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> PINEAPPLE_JUICE = ITEMS.register("pineapple_juice",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE).food(ModFoods.JUICE)));
    public static final RegistryObject<Item> STRAWBERRY_JUICE = ITEMS.register("strawberry_juice",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE).food(ModFoods.JUICE)));
    public static final RegistryObject<Item> GRAPE_JUICE = ITEMS.register("grape_juice",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE).food(ModFoods.JUICE)));
    public static final RegistryObject<Item> CARROT_JUICE = ITEMS.register("carrot_juice",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE).food(ModFoods.JUICE)));
    public static final RegistryObject<Item> OAK_SAP = ITEMS.register("oak_sap",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> SPRUCE_SAP = ITEMS.register("spruce_sap",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> BIRCH_SAP = ITEMS.register("birch_sap",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> JUNGLE_SAP = ITEMS.register("jungle_sap",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> ACACIA_SAP = ITEMS.register("acacia_sap",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> DARK_OAK_SAP = ITEMS.register("dark_oak_sap",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> MANGROVE_SAP = ITEMS.register("mangrove_sap",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> MINT_TREE_SAP = ITEMS.register("mint_tree_sap",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).craftRemainder(Items.GLASS_BOTTLE)));

    //DISHES
    public static final RegistryObject<Item> DONUT = ITEMS.register("donut",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.DONUT)));
    public static final RegistryObject<Item> CHOCOLATINE = ITEMS.register("chocolatine",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.CHOCOLATINE)));
    public static final RegistryObject<Item> CROISSANT = ITEMS.register("croissant",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.CROISSANT)));
    public static final RegistryObject<Item> FORTUNE_COOKIE = ITEMS.register("fortune_cookie",
            () -> new FortuneCookieItem(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(Foods.COOKIE)));
    public static final RegistryObject<Item> CUPCAKE = ITEMS.register("cupcake",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.CUPCAKE)));
    public static final RegistryObject<Item> CARAMEL_APPLE = ITEMS.register("caramel_apple",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.CARAMEL_APPLE)));
    public static final RegistryObject<Item> SUSHI = ITEMS.register("sushi",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.SUSHI)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.CHEESE)));
    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.APPLE_PIE)));
    public static final RegistryObject<Item> BERRY_SKEWER = ITEMS.register("berry_skewer",
            () -> new StickFoodItem(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.BERRY_SKEWER).stacksTo(1)));
    public static final RegistryObject<Item> MUSHROOM_OMELET = ITEMS.register("mushroom_omelet",
            () -> new BowlFoodItem(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).food(ModFoods.MUSHROOM_OMELET)));
    public static final RegistryObject<Item> EMPTY_JAR = ITEMS.register("empty_jar",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)));
    public static final RegistryObject<Item> MILK_JAR = ITEMS.register("milk_jar",
            () -> new JarItem(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).stacksTo(1).durability(8)));
    public static final RegistryObject<Item> WATER_JAR = ITEMS.register("water_jar",
            () -> new JarItem(new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_FOOD).stacksTo(1).durability(8)));


    //MISCELLANEOUS
    public static final RegistryObject<Item> ORANGE_JUICE_WATER_BUCKET = ITEMS.register("orange_juice_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ORANGE_JUICE,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> SODA_WATER_BUCKET = ITEMS.register("soda_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SODA,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> MAPLE_SYRUP_BUCKET = ITEMS.register("maple_syrup_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MAPLE_SYRUP,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS).craftRemainder(Items.BUCKET).stacksTo(1)));

    //TOOLS
    public static final RegistryObject<Item> CHOCO_SWORD = ITEMS.register("choco_sword",
            () -> new SwordItem(ModTiers.CHOCO, 4, -2.4f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CHOCO_SHOVEL = ITEMS.register("choco_shovel",
            () -> new ShovelItem(ModTiers.CHOCO, 2.5f, -3f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CHOCO_PICKAXE = ITEMS.register("choco_pickaxe",
            () -> new PickaxeItem(ModTiers.CHOCO, 2, -2.8f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CHOCO_AXE = ITEMS.register("choco_axe",
            () -> new AxeItem(ModTiers.CHOCO, 7f, -3.1f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CHOCO_HOE = ITEMS.register("choco_hoe",
            () -> new HoeItem(ModTiers.CHOCO, -1, -1f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> DARK_CHOCO_SWORD = ITEMS.register("dark_choco_sword",
            () -> new SwordItem(ModTiers.DARK_CHOCO, 4, -2.4f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> DARK_CHOC_SHOVEL = ITEMS.register("dark_choco_shovel",
            () -> new ShovelItem(ModTiers.DARK_CHOCO, 2.5f, -3f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> DARK_CHOC_PICKAXE = ITEMS.register("dark_choco_pickaxe",
            () -> new PickaxeItem(ModTiers.DARK_CHOCO, 2, -2.8f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> DARK_CHOCO_AXE = ITEMS.register("dark_choco_axe",
            () -> new AxeItem(ModTiers.DARK_CHOCO, 7f, -3.1f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> DARK_CHOCO_HOE = ITEMS.register("dark_choco_hoe",
            () -> new HoeItem(ModTiers.DARK_CHOCO, -1, -1f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> WHITE_CHOCO_SWORD = ITEMS.register("white_choco_sword",
            () -> new SwordItem(ModTiers.WHITE_CHOCO, 5, -2.4f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> WHITE_CHOC_SHOVEL = ITEMS.register("white_choco_shovel",
            () -> new ShovelItem(ModTiers.WHITE_CHOCO, 3.5f, -3f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> WHITE_CHOC_PICKAXE = ITEMS.register("white_choco_pickaxe",
            () -> new PickaxeItem(ModTiers.WHITE_CHOCO, 3, -2.8f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> WHITE_CHOCO_AXE = ITEMS.register("white_choco_axe",
            () -> new AxeItem(ModTiers.WHITE_CHOCO, 8f, -3.1f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> WHITE_CHOCO_HOE = ITEMS.register("white_choco_hoe",
            () -> new HoeItem(ModTiers.WHITE_CHOCO, 0, -1f, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_SWORD = ITEMS.register("caramel_sword",
            () -> new SwordItem(ModTiers.CARAMEL, 3, -2.4F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_SHOVEL = ITEMS.register("caramel_shovel",
            () -> new ShovelItem(ModTiers.CARAMEL, 1.5F, -3.0F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_PICKAXE = ITEMS.register("caramel_pickaxe",
            () -> new PickaxeItem(ModTiers.CARAMEL, 1, -2.8F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_AXE = ITEMS.register("caramel_axe",
            () -> new AxeItem(ModTiers.CARAMEL, 5.0F, -3.0F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_HOE = ITEMS.register("caramel_hoe",
            () -> new HoeItem(ModTiers.CARAMEL, -3, 0.0F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_SWORD = ITEMS.register("ghost_pepper_sword",
            () -> new SwordItem(ModTiers.GHOST_PEPPER, 3, -2.4F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_SHOVEL = ITEMS.register("ghost_pepper_shovel",
            () -> new ShovelItem(ModTiers.GHOST_PEPPER, 1.5F, -3.0F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_PICKAXE = ITEMS.register("ghost_pepper_pickaxe",
            () -> new PickaxeItem(ModTiers.GHOST_PEPPER, 1, -2.8F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_AXE = ITEMS.register("ghost_pepper_axe",
            () -> new AxeItem(ModTiers.GHOST_PEPPER, 5.0F, -3.0F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_HOE = ITEMS.register("ghost_pepper_hoe",
            () -> new HoeItem(ModTiers.GHOST_PEPPER, -3, 0.0F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> FORK = ITEMS.register("fork",
            () -> new ForkItem(ModTiers.FORK, 1, -2.8F, new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));

    //ARMOR
    public static final RegistryObject<Item> CHOCO_HELMET = ITEMS.register("choco_helmet",
            () -> new ArmorItem(ModArmorMaterials.CHOCO, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CHOCO_CHESTPLATE = ITEMS.register("choco_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CHOCO, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CHOCO_LEGGING = ITEMS.register("choco_leggings",
            () -> new ArmorItem(ModArmorMaterials.CHOCO, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CHOCO_BOOTS = ITEMS.register("choco_boots",
            () -> new ArmorItem(ModArmorMaterials.CHOCO, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_HELMET = ITEMS.register("caramel_helmet",
            () -> new ArmorItem(ModArmorMaterials.CARAMEL, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_CHESTPLATE = ITEMS.register("caramel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CARAMEL, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_LEGGING = ITEMS.register("caramel_leggings",
            () -> new ArmorItem(ModArmorMaterials.CARAMEL, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CARAMEL_BOOTS = ITEMS.register("caramel_boots",
            () -> new ArmorItem(ModArmorMaterials.CARAMEL, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_HELMET = ITEMS.register("ghost_pepper_helmet",
            () -> new GhostPepperArmorItem(ModArmorMaterials.GHOST_PEPPER, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_CHESTPLATE = ITEMS.register("ghost_pepper_chestplate",
            () -> new GhostPepperArmorItem(ModArmorMaterials.GHOST_PEPPER, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_LEGGING = ITEMS.register("ghost_pepper_leggings",
            () -> new GhostPepperArmorItem(ModArmorMaterials.GHOST_PEPPER, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> GHOST_PEPPER_BOOTS = ITEMS.register("ghost_pepper_boots",
            () -> new GhostPepperArmorItem(ModArmorMaterials.GHOST_PEPPER, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS)));
    public static final RegistryObject<Item> CHOCO_HORSE_ARMOR = ITEMS.register("choco_horse_armor",
            () -> new HorseArmorItem(7, "choco",
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_TOOLS).stacksTo(1)));



    //MISC
    public static final RegistryObject<Item> SLUSHY_SPAWN_EGG = ITEMS.register("slowshi_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SLOWSHI,0xFFFFFF,0xFFFF00,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS)));
    public static final RegistryObject<Item> ARMANGILLO_SPAWN_EGG = ITEMS.register("armangillo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ARMANGILLO,0x55FF00,0xFF0000,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS)));
    public static final RegistryObject<Item> CUPTOISE_SPAWN_EGG = ITEMS.register("cuptoise_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CUPTOISE,0x00FF00,0xFF00FF,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS)));
    public static final RegistryObject<Item> BEETARROT_SPAWN_EGG = ITEMS.register("beetarrot_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BEETARROT,0x800080,0xFFAA00,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS)));
    public static final RegistryObject<Item> GINGERBREAD_MAN_SPAWN_EGG = ITEMS.register("gingerbread_man_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GINGERBREAD_MAN,0x808000,0xFFFFFF,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS)));
    public static final RegistryObject<Item> GRAPE_DRAGON_SPAWN_EGG = ITEMS.register("grape_dragon_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GRAPE_DRAGON,0x000000,0xFF00FF,
                    new Item.Properties().tab(ModCreativeModTab.THE_FOOD_REALM_MISCELLANEOUS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
