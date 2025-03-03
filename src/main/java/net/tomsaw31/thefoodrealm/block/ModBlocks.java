package net.tomsaw31.thefoodrealm.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tomsaw31.thefoodrealm.TheFoodRealm;
import net.tomsaw31.thefoodrealm.block.custom.*;
import net.tomsaw31.thefoodrealm.fluid.ModFluids;
import net.tomsaw31.thefoodrealm.item.ModCreativeModTab;
import net.tomsaw31.thefoodrealm.item.ModItems;
import net.tomsaw31.thefoodrealm.world.feature.tree.MintTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheFoodRealm.MOD_ID);


    //FOOD WOOD
    public static final RegistryObject<Block> MINT_TREE_LOG = registerBlock("mint_tree_log",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_WOOD = registerBlock("mint_tree_wood",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_MINT_TREE_LOG = registerBlock("stripped_mint_tree_log",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_MINT_TREE_WOOD = registerBlock("stripped_mint_tree_wood",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_PLANKS = registerBlock("mint_tree_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_STAIRS = registerBlock("mint_tree_stairs",
            () -> new StairBlock(() -> ModBlocks.MINT_TREE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).strength(3f)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_SLAB = registerBlock("mint_tree_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_FENCE = registerBlock("mint_tree_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_FENCE_GATE = registerBlock("mint_tree_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_DOOR = registerBlock("mint_tree_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_TRAPDOOR = registerBlock("mint_tree_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_PRESSURE_PLATE = registerBlock("mint_tree_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).strength(3f).noCollission()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_BUTTON = registerBlock("mint_tree_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).strength(3f).noCollission()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_LEAVES = registerBlock("mint_tree_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_SAPLING = registerBlock("mint_tree_sapling",
            ()-> new SaplingBlock(new MintTreeGrower() ,BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).strength(2.0F, 3.0F).randomTicks().instabreak().sound(SoundType.GRASS)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_BLOCK = registerBlock("carrot_block",
            ()-> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f).sound(SoundType.WART_BLOCK)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_CARROT_BLOCK = registerBlock("stripped_carrot_block",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_PLANKS = registerBlock("carrot_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_STAIRS = registerBlock("carrot_stairs",
            () -> new StairBlock(() -> ModBlocks.CARROT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).strength(3f)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_SLAB = registerBlock("carrot_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_FENCE = registerBlock("carrot_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_FENCE_GATE = registerBlock("carrot_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_DOOR = registerBlock("carrot_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_TRAPDOOR = registerBlock("carrot_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).strength(2.0F, 3.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_PRESSURE_PLATE = registerBlock("carrot_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).strength(3f).noCollission()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARROT_BUTTON = registerBlock("carrot_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).strength(3f).noCollission()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> VEGETABLE_LEAVES = registerBlock("vegetable_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModTab.THE_FOOD_REALM_BLOCKS);

    //FOOD STONE
    public static final RegistryObject<Block> BLUEBERRY_STONE = registerBlock("blueberry_stone",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLUEBERRY_STONE_STAIRS = registerBlock("blueberry_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.BLUEBERRY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).strength(3f).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLUEBERRY_STONE_SLAB = registerBlock("blueberry_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).strength(1.5F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLUEBERRY_STONE_BRICKS = registerBlock("blueberry_stone_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).strength(1.5F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLUEBERRY_STONE_BRICK_STAIRS = registerBlock("blueberry_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.BLUEBERRY_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).strength(3f).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLUEBERRY_STONE_BRICK_SLAB = registerBlock("blueberry_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).strength(1.5F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLUEBERRY_COBBLESTONE = registerBlock("blueberry_cobblestone",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLUEBERRY_COBBLESTONE_STAIRS = registerBlock("blueberry_cobblestone_stairs",
            () -> new StairBlock(() -> ModBlocks.BLUEBERRY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).strength(2f,6.0f).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLUEBERRY_COBBLESTONE_SLAB = registerBlock("blueberry_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).strength(2F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_STONE = registerBlock("blackberry_stone",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_STONE_STAIRS = registerBlock("blackberry_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.BLACKBERRY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).strength(3f,6.0f).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_STONE_SLAB = registerBlock("blackberry_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).strength(3F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_STONE_BRICKS = registerBlock("blackberry_stone_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).strength(3F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_STONE_BRICK_STAIRS = registerBlock("blackberry_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.BLACKBERRY_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS).strength(3f).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_STONE_BRICK_SLAB = registerBlock("blackberry_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB).strength(3F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_COBBLESTONE = registerBlock("blackberry_cobblestone",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.5F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_COBBLESTONE_STAIRS = registerBlock("blackberry_cobblestone_stairs",
            () -> new StairBlock(() -> ModBlocks.BLACKBERRY_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).strength(3.5F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BLACKBERRY_COBBLESTONE_SLAB = registerBlock("blackberry_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).strength(3.5F, 6.0F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);






    //FOOD ORE BLOCKS
    public static final RegistryObject<Block> FIRE_PEPPER_ORE = registerBlock("fire_pepper_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARAMEL_ORE = registerBlock("caramel_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> GHOST_PEPPER_ORE = registerBlock("ghost_pepper_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);

    //FOOD BLOCKS
    public static final RegistryObject<Block> CHOCO_BLOCK = registerBlock("choco_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> DARK_CHOCO_BLOCK = registerBlock("dark_choco_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> WHITE_CHOCO_BLOCK = registerBlock("white_choco_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CARAMEL_BLOCK = registerBlock("caramel_block",
            ()-> new HoneyBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).strength(3F).requiresCorrectToolForDrops()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> GHOST_PEPPER_BLOCK = registerBlock("ghost_pepper_block",
            ()-> new GhostPepperBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().noOcclusion().strength(25.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> PANCAKE_BLOCK = registerBlock("pancake_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> CANDY_CANE_BLOCK = registerBlock("candy_cane_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.5F, 1.0F)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> PINEAPPLE_BLOCK = registerBlock("pineapple_block",
            ()-> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f).sound(SoundType.WART_BLOCK)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> STRAWBERRY_BLOCK = registerBlock("strawberry_block",
            ()-> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f).sound(SoundType.WART_BLOCK)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> GRAPE_BLOCK = registerBlock("grape_block",
            ()-> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5f).sound(SoundType.WART_BLOCK)), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> OAK_SAP_BLOCK = registerBlock("oak_sap_block",
            ()-> new SapBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops(), 0), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> SPRUCE_SAP_BLOCK = registerBlock("spruce_sap_block",
            ()-> new SapBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops(), 1), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> BIRCH_SAP_BLOCK = registerBlock("birch_sap_block",
            ()-> new SapBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops(), 2), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> JUNGLE_SAP_BLOCK = registerBlock("jungle_sap_block",
            ()-> new SapBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops(), 3), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> ACACIA_SAP_BLOCK = registerBlock("acacia_sap_block",
            ()-> new SapBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops(), 4), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> DARK_OAK_SAP_BLOCK = registerBlock("dark_oak_sap_block",
            ()-> new SapBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops(), 5), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MANGROVE_SAP_BLOCK = registerBlock("mangrove_sap_block",
            ()-> new SapBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops(), 6), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> MINT_TREE_SAP_BLOCK = registerBlock("mint_tree_sap_block",
            ()-> new SapBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3F).requiresCorrectToolForDrops(), 7), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    //BLOCK ENTITIES
    public static final RegistryObject<Block> EXTRACTOR = registerBlock("extractor",
            ()-> new ExtractorBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).strength(3F).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> LEMON_CHARGER = registerBlock("lemon_charger",
            () -> new LemonChargerBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()),
            ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> FREEZER = registerBlock("freezer",
            () -> new FreezerBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()),
            ModCreativeModTab.THE_FOOD_REALM_BLOCKS);
    public static final RegistryObject<Block> COOKING_POT = registerBlock("cooking_pot",
            () -> new CookingPotBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()),
            ModCreativeModTab.THE_FOOD_REALM_BLOCKS);

    //BLOCK WITHOUT BLOCK ITEM
    public static final RegistryObject<Block> CHOCO_CHIPS_BLOCK = registerBlockWithoutBlockItem("choco_chips_block",
            ()-> new ChocoChipsBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().noCollission()));
    public static final RegistryObject<Block> BLUEBERRY_BUSH = registerBlockWithoutBlockItem("blueberry_bush",
            ()-> new CustomBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH),0));
    public static final RegistryObject<Block> BLACKBERRY_BUSH = registerBlockWithoutBlockItem("blackberry_bush",
            ()-> new CustomBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH),1));
    public static final RegistryObject<Block> RASPBERRY_BUSH = registerBlockWithoutBlockItem("raspberry_bush",
            ()-> new CustomBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH),2));
    public static final RegistryObject<Block> STRAWBERRY_BUSH = registerBlockWithoutBlockItem("strawberry_bush",
            ()-> new CustomBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH),3));
    public static final RegistryObject<LiquidBlock> ORANGE_JUICE_WATER_BLOCK = BLOCKS.register("orange_juice_water_block",
            ()-> new LiquidBlock(ModFluids.SOURCE_ORANGE_JUICE, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
    public static final RegistryObject<LiquidBlock> SODA_WATER_BLOCK = BLOCKS.register("soda_water_block",
            ()-> new LiquidBlock(ModFluids.SOURCE_SODA, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
    public static final RegistryObject<LiquidBlock> MAPLE_SYRUP_BLOCK = BLOCKS.register("maple_syrup_block",
            ()-> new LiquidBlock(ModFluids.SOURCE_MAPLE_SYRUP, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));
    public static final RegistryObject<Block> FOOD_PORTAl = BLOCKS.register("food_portal",
            FoodPortalBlock::new);



    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> ToReturn = BLOCKS.register(name, block);
        registerBlockItem(name, ToReturn, tab);
        return ToReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);

    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
