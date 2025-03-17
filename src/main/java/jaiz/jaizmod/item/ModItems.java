package jaiz.jaizmod.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.boats.ModBoats;
import jaiz.jaizmod.item.custom.*;
import jaiz.jaizmod.item.custom.ancient_horns.AmethystHornItem;
import jaiz.jaizmod.item.custom.ancient_horns.AirHornItem;
import jaiz.jaizmod.item.custom.ancient_horns.AncientHornItem;
import jaiz.jaizmod.item.custom.GlowingSpyGlassItem;
import jaiz.jaizmod.item.custom.teas.*;
import jaiz.jaizmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

import java.util.function.Function;

public class ModItems {

    public static BlockItem registerBlockItem(String name, Block block) {
        return registerItem(name, settings -> new BlockItem(block, settings), new Item.Settings().useBlockPrefixedTranslationKey());
    }


    public static <I extends Item> I registerItem(String name, Function<Item.Settings, I> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JaizMod.MOD_ID, name));
        I item = factory.apply(settings.registryKey(key));

        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, blockItem);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    public static Item registerItem(String id, Function<Item.Settings, Item> factory) {
        return registerItem(id, factory, new Item.Settings());
    }

    public static final Item SNIFFER_TUFT = registerItem("sniffer_tuft", Item::new, new Item.Settings());

    public static final Item PETRIFIED_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem(
            "petrified_armor_trim_smithing_template", SmithingTemplateItem::of, new Item.Settings().rarity(Rarity.UNCOMMON)
    );

    public static final Item BUTTERFLY_BOTTLE = registerItem(
            "butterfly_bottle",
            settings -> new EntityBottle(ModEntities.BUTTERFLY, settings),
            new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT)
    );
    public static final Item DRAGONFLY_BOTTLE = registerItem(
            "dragonfly_bottle",
            settings -> new EntityBottle(ModEntities.DRAGONFLY, settings),
            new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT)
    );
    public static final Item CATERPILLAR_BOTTLE = registerItem(
            "caterpillar_bottle",
            settings -> new EntityBottle(ModEntities.CATERPILLAR, settings),
            new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT)
    );

    public static final Item SNAIL_BOTTLE = registerItem(
            "snail_bottle",
            settings -> new EntityBottle(ModEntities.SNAIL, settings),
            new Item.Settings().maxCount(1).component(DataComponentTypes.BUCKET_ENTITY_DATA, NbtComponent.DEFAULT)
    );


    public static final Item GLOWING_SPYGLASS = registerItem("glowing_spyglass", GlowingSpyGlassItem::new, new Item.Settings().maxCount(1).maxDamage(64));

    public static final Item MAHOGANY_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAHOGANY_BOAT_ID, false, false);
    public static final Item MAHOGANY_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MAHOGANY_BOAT_ID, true, false);

    public static final Item DESERT_OAK_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.DESERT_OAK_BOAT_ID, false, false);
    public static final Item DESERT_OAK_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.DESERT_OAK_BOAT_ID, true, false);

    public static final Item ROTTEN_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ROTTEN_BOAT_ID, false, false);
    public static final Item ROTTEN_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ROTTEN_BOAT_ID, true, false);


    public static final Item FRUIT_BAT_SPAWN_EGG = registerItem("fruit_bat_spawn_egg", settings -> new SpawnEggItem(ModEntities.FRUIT_BAT, settings));

    public static final Item WATER_TORCH = registerItem(
            "water_torch",
            settings -> new VerticallyAttachableBlockItem(ModBlocks.WATER_TORCH, ModBlocks.WALL_WATER_TORCH, Direction.DOWN, settings)
    );

    public static final Item GUANO = registerItem("guano", GuanoItem:: new, new Item.Settings());
    public static final Item GLOW_BALL = registerItem("glowball", GlowBallItem::new, new Item.Settings());

    public static final Item SNAIL_SPAWN_EGG = registerItem("snail_spawn_egg", settings -> new SpawnEggItem(ModEntities.SNAIL, settings));
    public static final Item CATERPILLAR_SPAWN_EGG = registerItem("caterpillar_spawn_egg", settings -> new SpawnEggItem(ModEntities.CATERPILLAR, settings));
    public static final Item BUTTERFLY_SPAWN_EGG = registerItem("butterfly_spawn_egg", settings -> new SpawnEggItem(ModEntities.BUTTERFLY, settings));
    public static final Item FIREFLY_SWARM_SPAWN_EGG = registerItem("firefly_swarm_spawn_egg", settings -> new SpawnEggItem(ModEntities.FIRE_FLY_SWARM, settings));
    public static final Item DRAGONFLY_SPAWN_EGG = registerItem("dragonfly_spawn_egg", settings -> new SpawnEggItem(ModEntities.DRAGONFLY, settings));

    public static final Item MIMIC_POT = registerItem("mimic_pot", settings -> new SpawnEggItem(ModEntities.MASON_MOUTH, settings.maxCount(1)));

    public static final Item BANDIT_SPAWN_EGG = registerItem("bandit_spawn_egg", settings -> new SpawnEggItem(ModEntities.BANDIT, settings));

    public static final Item SILK = registerItem("silk", Item::new, new Item.Settings());
    public static final Item BATTERED_AXE_REMNANT = registerItem("battered_axe_remnant", Item::new, new Item.Settings());

    public static final Item ANCIENT_HORN = registerItem(
            "ancient_horn", settings -> new AncientHornItem(settings, InstrumentTags.GOAT_HORNS), new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1).maxDamage(64)
    );
    public static final Item AIR_HORN = registerItem(
            "air_horn", settings -> new AirHornItem(settings, InstrumentTags.GOAT_HORNS), new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1).maxDamage(64)
    );
    public static final Item AMETHYST_HORN = registerItem(
            "amethyst_horn", settings -> new AmethystHornItem(settings, InstrumentTags.GOAT_HORNS), new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(1).maxDamage(64)
    );

    public static final Item SNIFFER_MEAT = registerItem("sniffer_meat", Item::new, new Item.Settings().food(ModFoodComponents.SNIFFER_MEAT));
    public static final Item COOKED_SNIFFER_MEAT = registerItem("cooked_sniffer_meat", Item::new, new Item.Settings().food(ModFoodComponents.COOKED_SNIFFER_MEAT));

    public static final Item DYNAMITE = registerItem("dynamite", DynamiteItem::new, new Item.Settings());

    public static final Item RARE_SPICES = registerItem("rare_spices", Item::new, new Item.Settings().food(ModFoodComponents.RARE_SPICES, ConsumableComponents.RARE_SPICES));
    public static final Item GOURMET_MEAL = registerItem("gourmet_meal", Item::new, new Item.Settings().food(ModFoodComponents.GOURMET_MEAL, ConsumableComponents.GOURMET_MEAL).maxCount(16));
    public static final Item OBSIDIAN_SHARD = registerItem("obsidian_shard", Item::new, new Item.Settings());
    public static final Item SHARP_OBSIDIAN_SHARD = registerItem("sharp_obsidian_shard", Item::new, new Item.Settings());
    public static final Item WEDGE_OBSIDIAN_SHARD = registerItem("wedge_obsidian_shard", Item::new, new Item.Settings());

    public static final Item UNFIRED_TEA_CUP = registerItem("unfired_tea_cup", Item::new, new Item.Settings().maxCount(1));
    public static final Item TEA_CUP = registerItem("tea_cup", Item::new, new Item.Settings().maxCount(1));
    public static final Item CHORUS_FRUIT_TEA = registerItem("chorus_fruit_tea",  ChorusTeaItem::new, new Item.Settings().food(ModFoodComponents.CHORUS_TEA, ConsumableComponents.CHORUS_TEA).maxCount(1));
    public static final Item NOVEL_TEA = registerItem("novel_tea",  NovelTeaItem::new, new Item.Settings().food(ModFoodComponents.TEA, ConsumableComponents.TEA).maxCount(1));
    public static final Item FLOWER_TEA = registerItem("flower_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.TEA, ConsumableComponents.TEA).maxCount(1));
    public static final Item GLOW_BERRY_TEA = registerItem("glow_berry_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.GLOW_BERRY_TEA, ConsumableComponents.GLOW_BERRY_TEA).maxCount(1));
    public static final Item GUNPOWDER_GREEN_TEA = registerItem("gunpowder_green_tea",  GunPowderTeaItem::new, new Item.Settings().food(ModFoodComponents.TEA, ConsumableComponents.TEA).maxCount(1));
    public static final Item HERBAL_TEA = registerItem("herbal_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.TEA, ConsumableComponents.TEA).maxCount(1));
    public static final Item KOMBUCHA_TEA = registerItem("kombucha_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.TEA, ConsumableComponents.TEA).maxCount(1));
    public static final Item NETHER_FUNGUS_TEA = registerItem("nether_fungus_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.NETHER_FUNGAL_TEA, ConsumableComponents.NETHER_FUNGAL_TEA).maxCount(1));
    public static final Item WARPED_NETHER_FUNGUS_TEA = registerItem("warped_nether_fungus_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.NETHER_FUNGAL_TEA, ConsumableComponents.NETHER_FUNGAL_TEA).maxCount(1));
    public static final Item PITCHER_PLANT_TEA = registerItem("pitcher_plant_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.PITCHER_PLANT_TEA, ConsumableComponents.PITCHER_PLANT_TEA).maxCount(1));
    public static final Item PUMPKIN_SPICE_TEA = registerItem("pumpkin_spice_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.TEA, ConsumableComponents.TEA).maxCount(1));
    public static final Item SPORE_BLOSSOM_TEA = registerItem("spore_blossom_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.SPORE_BLOSSOM_TEA, ConsumableComponents.SPORE_BLOSSOM_TEA).maxCount(1));
    public static final Item TORCH_FLOWER_TEA = registerItem("torch_flower_tea",  TeaItem::new, new Item.Settings().food(ModFoodComponents.TORCH_FLOWER_TEA, ConsumableComponents.TORCH_FLOWER_TEA).maxCount(1));
    public static final Item WITHER_ROSE_TEA = registerItem("wither_rose_tea",  WitherTeaItem::new, new Item.Settings().food(ModFoodComponents.WITHER_ROSE_TEA, ConsumableComponents.WITHER_ROSE_TEA).maxCount(1));


    public static final Item MACUAHUITL = registerItem(
            "macuahuitl",
            settings -> new MayanSwordItem(ModToolMaterial.MAYAN_SWORD, 3, -3.5f, settings));


    public static final Item OBSIDIAN_SWORD = registerItem(
            "obsidian_sword",
            settings -> new SwordItem(ModToolMaterial.OBSIDIAN_SWORD, 2, -2.4f, settings));
    public static final Item SHARP_OBSIDIAN_SWORD = registerItem(
            "sharp_obsidian_sword",
            settings -> new SwordItem(ModToolMaterial.SHARP_OBSIDIAN_SWORD, 2, -2.0f, settings));
    public static final Item WEDGE_OBSIDIAN_SWORD = registerItem(
            "wedge_obsidian_sword",
            settings -> new SwordItem(ModToolMaterial.WEDGE_OBSIDIAN_SWORD, 1, -2.8f, settings));
    public static final Item WEDGE_REGULAR_OBSIDIAN_SWORD = registerItem(
            "wedge_regular_obsidian_sword",
            settings -> new SwordItem(ModToolMaterial.WEDGE_REGULAR_OBSIDIAN_SWORD, 2, -2.8f, settings));
    public static final Item SHARP_REGULAR_OBSIDIAN_SWORD = registerItem(
            "sharp_regular_obsidian_sword",
            settings -> new SwordItem(ModToolMaterial.SHARP_REGULAR_OBSIDIAN_SWORD, 3, -2.0f, settings));
    public static final Item SHARP_WEDGE_OBSIDIAN_SWORD = registerItem(
            "sharp_wedge_obsidian_sword",
            settings -> new SwordItem(ModToolMaterial.SHARP_WEDGE_OBSIDIAN_SWORD, 3, -3.2f, settings));
    public static final Item OBSIDIAN_DAGGER = registerItem(
            "obsidian_dagger",
            settings -> new SwordItem(ModToolMaterial.OBSIDIAN_DAGGER, 2, -2.4f, settings));
    public static final Item SHARP_OBSIDIAN_DAGGER = registerItem(
            "sharp_obsidian_dagger",
            settings -> new SwordItem(ModToolMaterial.SHARP_OBSIDIAN_DAGGER, 2, -2.0f, settings));
    public static final Item WEDGE_OBSIDIAN_DAGGER = registerItem(
            "wedge_obsidian_dagger",
            settings -> new SwordItem(ModToolMaterial.WEDGE_OBSIDIAN_DAGGER, 3, -2.8f, settings));

    public static final Item BATTERED_AXE = registerItem("battered_axe", settings -> new AxeItem(ModToolMaterial.BATTERED, 5.0F, -2.8f, settings));

    public static final Item ORIGAMI_HAIRBALL_MUSIC_DISC = registerItem("origami_hairball_music_disc", Item::new, new Item.Settings().jukeboxPlayable(ModSounds.of("origami_hairball")).rarity(Rarity.RARE).maxCount(1));

    public static final Item ROTTEN_SIGN = registerItem("rotten_sign", settings -> new SignItem(ModBlocks.STANDING_ROTTEN_SIGN, ModBlocks.WALL_ROTTEN_SIGN, settings), new Item.Settings().maxCount(16).useBlockPrefixedTranslationKey());
    public static final Item ROTTEN_HANGING_SIGN = registerItem("rotten_hanging_sign", settings -> new HangingSignItem(ModBlocks.HANGING_ROTTEN_SIGN, ModBlocks.WALL_HANGING_ROTTEN_SIGN, settings), new Item.Settings().maxCount(16).useBlockPrefixedTranslationKey());
    public static final Item MAHOGANY_SIGN = registerItem("mahogany_sign", settings -> new SignItem(ModBlocks.STANDING_MAHOGANY_SIGN, ModBlocks.WALL_MAHOGANY_SIGN, settings), new Item.Settings().maxCount(16).useBlockPrefixedTranslationKey());
    public static final Item MAHOGANY_HANGING_SIGN = registerItem("mahogany_hanging_sign", settings -> new HangingSignItem(ModBlocks.HANGING_MAHOGANY_SIGN, ModBlocks.WALL_HANGING_MAHOGANY_SIGN, settings), new Item.Settings().maxCount(16).useBlockPrefixedTranslationKey());
    public static final Item DESERT_OAK_SIGN = registerItem("desert_oak_sign", settings -> new SignItem(ModBlocks.STANDING_DESERT_OAK_SIGN, ModBlocks.WALL_DESERT_OAK_SIGN, settings), new Item.Settings().maxCount(16).useBlockPrefixedTranslationKey());
    public static final Item DESERT_OAK_HANGING_SIGN = registerItem("desert_oak_hanging_sign", settings -> new HangingSignItem(ModBlocks.HANGING_DESERT_OAK_SIGN, ModBlocks.WALL_HANGING_DESERT_OAK_SIGN, settings), new Item.Settings().maxCount(16).useBlockPrefixedTranslationKey());


    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }
    public static final Item BLOOMING_IVY_SEEDS = registerItem("blooming_ivy_seeds", createBlockItemWithUniqueName(ModBlocks.BLOOMING_IVY_CROP));
    public static final Item ANCIENT_SPROUT_SEEDS = registerItem("ancient_sprout_seeds", createBlockItemWithUniqueName(ModBlocks.ANCIENT_SPROUT_CROP));

    //BlockItems

    public static BlockItem PLATED_CALCITE = registerBlockItem("plated_calcite", ModBlocks.PLATED_CALCITE);
    public static BlockItem CHISELED_PLATED_CALCITE = registerBlockItem("chiseled_plated_calcite", ModBlocks.CHISELED_PLATED_CALCITE);

    public static BlockItem DEAD_LEAVES = registerBlockItem("dead_leaves", ModBlocks.DEAD_LEAVES);
    public static BlockItem DRIED_LEAVES = registerBlockItem("dried_leaves", ModBlocks.DRIED_LEAVES);
    public static BlockItem BLOOMING_IVY_BLOCK = registerBlockItem("blooming_ivy_block", ModBlocks.BLOOMING_IVY_BLOCK);

    public static BlockItem FROST = registerBlockItem("frost", ModBlocks.FROST);
    public static BlockItem SNOWY_LEAVES = registerBlockItem("snowy_leaves", ModBlocks.SNOWY_LEAVES);
    public static BlockItem WHITE_FLORAL_VEIL = registerBlockItem("white_floral_veil", ModBlocks.WHITE_FLORAL_VEIL);
    public static BlockItem PINK_FLORAL_VEIL = registerBlockItem("pink_floral_veil", ModBlocks.PINK_FLORAL_VEIL);
    public static BlockItem YELLOW_FLORAL_VEIL = registerBlockItem("yellow_floral_veil", ModBlocks.YELLOW_FLORAL_VEIL);

    public static BlockItem ANCIENT_SPROUT = registerBlockItem("ancient_sprout", ModBlocks.ANCIENT_SPROUT);
    public static final Item FANCY_WHITE_WOOL = registerBlockItem("fancy_white_wool",ModBlocks.FANCY_WHITE_WOOL);
    public static final Item FANCY_LIGHT_GRAY_WOOL = registerBlockItem("fancy_light_gray_wool", ModBlocks.FANCY_LIGHT_GRAY_WOOL);
    public static final Item FANCY_GRAY_WOOL = registerBlockItem("fancy_gray_wool", ModBlocks.FANCY_GRAY_WOOL);
    public static final Item FANCY_BLACK_WOOL = registerBlockItem("fancy_black_wool", ModBlocks.FANCY_BLACK_WOOL);
    public static final Item FANCY_BROWN_WOOL = registerBlockItem("fancy_brown_wool", ModBlocks.FANCY_BROWN_WOOL);
    public static final Item FANCY_RED_WOOL = registerBlockItem("fancy_red_wool", ModBlocks.FANCY_RED_WOOL);
    public static final Item FANCY_ORANGE_WOOL = registerBlockItem("fancy_orange_wool", ModBlocks.FANCY_ORANGE_WOOL);
    public static final Item FANCY_YELLOW_WOOL = registerBlockItem("fancy_yellow_wool", ModBlocks.FANCY_YELLOW_WOOL);
    public static final Item FANCY_LIME_WOOL = registerBlockItem("fancy_lime_wool", ModBlocks.FANCY_LIME_WOOL);
    public static final Item FANCY_GREEN_WOOL = registerBlockItem("fancy_green_wool", ModBlocks.FANCY_GREEN_WOOL);
    public static final Item FANCY_CYAN_WOOL = registerBlockItem("fancy_cyan_wool", ModBlocks.FANCY_CYAN_WOOL);
    public static final Item FANCY_LIGHT_BLUE_WOOL = registerBlockItem("fancy_light_blue_wool", ModBlocks.FANCY_LIGHT_BLUE_WOOL);
    public static final Item FANCY_BLUE_WOOL = registerBlockItem("fancy_blue_wool", ModBlocks.FANCY_BLUE_WOOL);
    public static final Item FANCY_PURPLE_WOOL = registerBlockItem("fancy_purple_wool", ModBlocks.FANCY_PURPLE_WOOL);
    public static final Item FANCY_MAGENTA_WOOL = registerBlockItem("fancy_magenta_wool", ModBlocks.FANCY_MAGENTA_WOOL);
    public static final Item FANCY_PINK_WOOL = registerBlockItem("fancy_pink_wool", ModBlocks.FANCY_PINK_WOOL);

    public static final Item FANCY_WHITE_CARPET = registerBlockItem("fancy_white_carpet", ModBlocks.FANCY_WHITE_CARPET);
    public static final Item FANCY_LIGHT_GRAY_CARPET = registerBlockItem("fancy_light_gray_carpet", ModBlocks.FANCY_LIGHT_GRAY_CARPET);
    public static final Item FANCY_GRAY_CARPET = registerBlockItem("fancy_gray_carpet", ModBlocks.FANCY_GRAY_CARPET);
    public static final Item FANCY_BLACK_CARPET = registerBlockItem("fancy_black_carpet", ModBlocks.FANCY_BLACK_CARPET);
    public static final Item FANCY_BROWN_CARPET = registerBlockItem("fancy_brown_carpet", ModBlocks.FANCY_BROWN_CARPET);
    public static final Item FANCY_RED_CARPET = registerBlockItem("fancy_red_carpet", ModBlocks.FANCY_RED_CARPET);
    public static final Item FANCY_ORANGE_CARPET = registerBlockItem("fancy_orange_carpet", ModBlocks.FANCY_ORANGE_CARPET);
    public static final Item FANCY_YELLOW_CARPET = registerBlockItem("fancy_yellow_carpet", ModBlocks.FANCY_YELLOW_CARPET);
    public static final Item FANCY_LIME_CARPET = registerBlockItem("fancy_lime_carpet", ModBlocks.FANCY_LIME_CARPET);
    public static final Item FANCY_GREEN_CARPET = registerBlockItem("fancy_green_carpet", ModBlocks.FANCY_GREEN_CARPET);
    public static final Item FANCY_CYAN_CARPET = registerBlockItem("fancy_cyan_carpet", ModBlocks.FANCY_CYAN_CARPET);
    public static final Item FANCY_LIGHT_BLUE_CARPET = registerBlockItem("fancy_light_blue_carpet", ModBlocks.FANCY_LIGHT_BLUE_CARPET);
    public static final Item FANCY_BLUE_CARPET = registerBlockItem("fancy_blue_carpet", ModBlocks.FANCY_BLUE_CARPET);
    public static final Item FANCY_PURPLE_CARPET = registerBlockItem("fancy_purple_carpet", ModBlocks.FANCY_PURPLE_CARPET);
    public static final Item FANCY_MAGENTA_CARPET = registerBlockItem("fancy_magenta_carpet", ModBlocks.FANCY_MAGENTA_CARPET);
    public static final Item FANCY_PINK_CARPET = registerBlockItem("fancy_pink_carpet", ModBlocks.FANCY_PINK_CARPET);

    public static final Item GILDED_CHISELED_SANDSTONE = registerBlockItem("gilded_chiseled_sandstone", ModBlocks.GILDED_CHISELED_SANDSTONE);
    public static final Item GILDED_CUT_SANDSTONE = registerBlockItem("gilded_cut_sandstone", ModBlocks.GILDED_CUT_SANDSTONE);
    public static final Item GILDED_SANDSTONE = registerBlockItem("gilded_sandstone", ModBlocks.GILDED_SANDSTONE);

    public static final Item TERRACOTTA_BRICKS = registerBlockItem("terracotta_bricks", ModBlocks.TERRACOTTA_BRICKS);
    public static final Item TERRACOTTA_BRICK_STAIRS = registerBlockItem("terracotta_brick_stairs", ModBlocks.TERRACOTTA_BRICK_STAIRS);
    public static final Item TERRACOTTA_BRICK_WALL = registerBlockItem("terracotta_brick_wall", ModBlocks.TERRACOTTA_BRICK_WALL);
    public static final Item TERRACOTTA_BRICK_SLAB = registerBlockItem("terracotta_brick_slab", ModBlocks.TERRACOTTA_BRICK_SLAB);

    public static final Item PACKED_GUANO = registerBlockItem("packed_guano", ModBlocks.PACKED_GUANO);
    public static final Item GUANO_BRICKS = registerBlockItem("guano_bricks", ModBlocks.GUANO_BRICKS);
    public static final Item GUANO_BRICK_STAIRS = registerBlockItem("guano_brick_stairs", ModBlocks.GUANO_BRICK_STAIRS);
    public static final Item GUANO_BRICK_WALL = registerBlockItem("guano_brick_wall", ModBlocks.GUANO_BRICK_WALL);
    public static final Item GUANO_BRICK_SLAB = registerBlockItem("guano_brick_slab", ModBlocks.GUANO_BRICK_SLAB);

    public static final Item DESERT_OAK_BUTTON = registerBlockItem("desert_oak_button", ModBlocks.DESERT_OAK_BUTTON);
    public static final Item DESERT_OAK_PRESSURE_PLATE = registerBlockItem("desert_oak_pressure_plate", ModBlocks.DESERT_OAK_PRESSURE_PLATE);
    public static final Item DESERT_OAK_PLANKS = registerBlockItem("desert_oak_planks", ModBlocks.DESERT_OAK_PLANKS);
    public static final Item DESERT_OAK_DOOR = registerBlockItem("desert_oak_door", ModBlocks.DESERT_OAK_DOOR);
    public static final Item DESERT_OAK_TRAPDOOR = registerBlockItem("desert_oak_trapdoor", ModBlocks.DESERT_OAK_TRAPDOOR);
    public static final Item DESERT_OAK_FENCE = registerBlockItem("desert_oak_fence", ModBlocks.DESERT_OAK_FENCE);
    public static final Item DESERT_OAK_FENCE_GATE = registerBlockItem("desert_oak_gate", ModBlocks.DESERT_OAK_FENCE_GATE);
    public static final Item DESERT_OAK_SLAB = registerBlockItem("desert_oak_slab", ModBlocks.DESERT_OAK_SLAB);
    public static final Item DESERT_OAK_STAIRS = registerBlockItem("desert_oak_stairs", ModBlocks.DESERT_OAK_STAIRS);

    public static final Item SPICE_BARREL = registerBlockItem("spice_barrel", ModBlocks.SPICE_BARREL);

    public static final Item DESERT_OAK_SAPLING = registerBlockItem("desert_oak_sapling", ModBlocks.DESERT_OAK_SAPLING);
    public static final Item DESERT_OAK_LEAVES = registerBlockItem("desert_oak_leaves", ModBlocks.DESERT_OAK_LEAVES);
    public static final Item DESERT_OAK_LOG = registerBlockItem("desert_oak_log", ModBlocks.DESERT_OAK_LOG);
    public static final Item DESERT_OAK_WOOD = registerBlockItem("desert_oak_wood", ModBlocks.DESERT_OAK_WOOD);
    public static final Item STRIPPED_DESERT_OAK_LOG = registerBlockItem("stripped_desert_oak_log", ModBlocks.STRIPPED_DESERT_OAK_LOG);
    public static final Item STRIPPED_DESERT_OAK_WOOD = registerBlockItem("stripped_desert_oak_wood", ModBlocks.STRIPPED_DESERT_OAK_WOOD);

    public static final Item ROT_BLOCK = registerBlockItem("rot_block", ModBlocks.ROT_BLOCK);
    public static final Item FOSSIL_SOIL = registerBlockItem("fossil_soil", ModBlocks.FOSSIL_SOIL);
    public static final Item PETRIFIED_DIRT = registerBlockItem("petrified_dirt", ModBlocks.PETRIFIED_DIRT);
    public static final Item FIREFLY_BOTTLE = registerBlockItem("firefly_bottle", ModBlocks.FIREFLY_BOTTLE);

    public static final Item ROTTEN_PLANKS = registerBlockItem("rotten_planks", ModBlocks.ROTTEN_PLANKS);
    public static final Item ROTTEN_DOOR = registerBlockItem("rotten_door", ModBlocks.ROTTEN_DOOR);
    public static final Item ROTTEN_TRAPDOOR = registerBlockItem("rotten_trapdoor", ModBlocks.ROTTEN_TRAPDOOR);
    public static final Item ROTTEN_FENCE = registerBlockItem("rotten_fence", ModBlocks.ROTTEN_FENCE);
    public static final Item ROTTEN_FENCE_GATE = registerBlockItem("rotten_fence_gate", ModBlocks.ROTTEN_FENCE_GATE);
    public static final Item ROTTEN_SLAB = registerBlockItem("rotten_slab", ModBlocks.ROTTEN_SLAB);
    public static final Item ROTTEN_STAIRS = registerBlockItem("rotten_stairs", ModBlocks.ROTTEN_STAIRS);
    public static final Item ROTTEN_LOG = registerBlockItem("rotten_log", ModBlocks.ROTTEN_LOG);
    public static final Item ROTTEN_WOOD = registerBlockItem("rotten_wood", ModBlocks.ROTTEN_WOOD);
    public static final Item STRIPPED_ROTTEN_LOG = registerBlockItem("stripped_rotten_log", ModBlocks.STRIPPED_ROTTEN_LOG);
    public static final Item ROTTEN_PRESSURE_PLATE = registerBlockItem("rotten_pressure_plate", ModBlocks.ROTTEN_PRESSURE_PLATE);
    public static final Item ROTTEN_BUTTON = registerBlockItem("rotten_button", ModBlocks.ROTTEN_BUTTON);
    public static final Item STRIPPED_ROTTEN_WOOD = registerBlockItem("stripped_rotten_wood", ModBlocks.STRIPPED_ROTTEN_WOOD);

    public static final Item SHELF_MUSHROOM_BLOCK = registerBlockItem("shelf_mushroom_block", ModBlocks.SHELF_MUSHROOM_BLOCK);

    public static BlockItem registerCocoonBlockItem(String name, Block block) {
        return registerItem(name, settings -> new BlockItem(block, settings), new Item.Settings().useBlockPrefixedTranslationKey().food(ModFoodComponents.COCOON, ConsumableComponents.COCOON).maxCount(1));
    }
    public static final Item COCOON_BLOCK = registerCocoonBlockItem("cocoon_block", ModBlocks.COCOON_BLOCK);

    public static final Item COLUMBINE = registerBlockItem("columbine", ModBlocks.COLUMBINE);
    public static final Item ROT_ROOTS = registerBlockItem("rot_roots", ModBlocks.ROT_ROOTS);
    public static final Item CALLALILY_WHITE = registerBlockItem("callalily_white", ModBlocks.CALLALILY_WHITE);
    public static final Item CALLALILY_LILAC = registerBlockItem("callalily_lilac", ModBlocks.CALLALILY_LILAC);
    public static final Item CALLALILY_PINK = registerBlockItem("callalily_pink", ModBlocks.CALLALILY_PINK);
    public static final Item CALLALILY_PURPLE = registerBlockItem("callalily_purple", ModBlocks.CALLALILY_PURPLE);
    public static final Item CALLALILY_YELLOW = registerBlockItem("callalily_yellow", ModBlocks.CALLALILY_YELLOW);
    public static final Item IVY = registerBlockItem("ivy", ModBlocks.IVY);
    public static final Item UNDERGROWTH = registerBlockItem("undergrowth", ModBlocks.UNDERGROWTH);

    public static final Item BLOOMING_IVY = registerBlockItem("blooming_ivy", ModBlocks.BLOOMING_IVY);

    public static final Item AUTUMN_SAPLING = registerBlockItem("autumn_sapling", ModBlocks.AUTUMN_SAPLING);

    public static final Item MAHOGANY_PLANKS = registerBlockItem("mahogany_planks", ModBlocks.MAHOGANY_PLANKS);
    public static final Item MAHOGANY_STAIRS = registerBlockItem("mahogany_stairs", ModBlocks.MAHOGANY_STAIRS);
    public static final Item MAHOGANY_SLAB = registerBlockItem("mahogany_slab", ModBlocks.MAHOGANY_SLAB);
    public static final Item MAHOGANY_LOG = registerBlockItem("mahogany_log", ModBlocks.MAHOGANY_LOG);
    public static final Item MAHOGANY_LEAVES = registerBlockItem("mahogany_leaves", ModBlocks.MAHOGANY_LEAVES);
    public static final Item MAHOGANY_SAPLING = registerBlockItem("mahogany_sapling", ModBlocks.MAHOGANY_SAPLING);
    public static final Item MAHOGANY_WOOD = registerBlockItem("mahogany_wood", ModBlocks.MAHOGANY_WOOD);
    public static final Item STRIPPED_MAHOGANY_LOG = registerBlockItem("stripped_mahogany_log", ModBlocks.STRIPPED_MAHOGANY_LOG);
    public static final Item STRIPPED_MAHOGANY_WOOD = registerBlockItem("stripped_mahogany_wood", ModBlocks.STRIPPED_MAHOGANY_WOOD);
    public static final Item MAHOGANY_DOOR = registerBlockItem("mahogany_door", ModBlocks.MAHOGANY_DOOR);
    public static final Item MAHOGANY_TRAPDOOR = registerBlockItem("mahogany_trapdoor", ModBlocks.MAHOGANY_TRAPDOOR);
    public static final Item MAHOGANY_PRESSURE_PLATE = registerBlockItem("mahogany_pressure_plate", ModBlocks.MAHOGANY_PRESSURE_PLATE);
    public static final Item MAHOGANY_BUTTON = registerBlockItem("mahogany_button", ModBlocks.MAHOGANY_BUTTON);
    public static final Item MAHOGANY_FENCE = registerBlockItem("mahogany_fence", ModBlocks.MAHOGANY_FENCE);
    public static final Item MAHOGANY_FENCE_GATE = registerBlockItem("mahogany_fence_gate", ModBlocks.MAHOGANY_FENCE_GATE);

    public static final Item SLIMEY_STONE = registerBlockItem("slimey_stone", ModBlocks.SLIMEY_STONE);
    public static final Item SLIME_DRIP = registerBlockItem("slime_drip", ModBlocks.SLIME_DRIP);
    public static final Item GUANO_BLOCK = registerBlockItem("guano_block", ModBlocks.GUANO_BLOCK);
    public static final Item GUANO_PILE = registerBlockItem("guano_pile", ModBlocks.GUANO_PILE);
    public static final Item TEAPOTBLOCK = registerBlockItem("tea_pot_block", ModBlocks.TEAPOTBLOCK);
    public static final Item BIOLUMINESCENT_BOTTLE = registerBlockItem("bioluminescent_bottle", ModBlocks.BIOLUMINESCENT_BOTTLE);

    public static final Item SNIFFER_CARPET = registerBlockItem("sniffer_carpet", ModBlocks.SNIFFER_CARPET);
    public static final Item SNIFFER_WOOL = registerBlockItem("sniffer_wool", ModBlocks.SNIFFER_WOOL);

    public static void registerModItems() {
        JaizMod.LOGGER.info("registering Mod Items for " + JaizMod.MOD_ID);
    }
}

