package jaiz.jaizmod.block;

import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import jaiz.jaizmod.JaizMod;
//import jaiz.jaizmod.block.blockentities.WaterTickingBlock;
import jaiz.jaizmod.block.blockentities.WaterTickingBlock;
import jaiz.jaizmod.block.custom.*;
import jaiz.jaizmod.worldgen.features.ModConfiguredFeatures;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures;

import java.util.Optional;
import java.util.function.Function;

public class ModBlocks {
    public static final IntProperty SIZE = IntProperty.of("size", 0, 2);
    public static final IntProperty STAGE = IntProperty.of("stage", 1, 3);
    public static final IntProperty ROTTING = IntProperty.of("rotting", 0, 1);
    public static final IntProperty COCOON_HATCH = IntProperty.of("hatch", 0, 3);
    public static final BooleanProperty HAS_CUP = BooleanProperty.of("has_cup");
    public static final BooleanProperty LOCKED = BooleanProperty.of("locked");
    public static final BooleanProperty GROWING = BooleanProperty.of("growing");


    public static final Block PLATED_CALCITE = registerBlock("plated_calcite",
            Block::new,AbstractBlock.Settings.copy(Blocks.CALCITE));

    public static final Block ANCIENT_SPROUT = registerBlock("ancient_sprout",
            settings -> new AncientSproutBlock(StatusEffects.ABSORPTION, 60, settings),
            AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY));

    public static final Block BLOOMING_IVY_CROP = registerBlock(
            "blooming_ivy_crop",
            CropBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block ANCIENT_SPROUT_CROP = registerBlock(
            "ancient_sprout_crop",
            CropBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );


    public static final Block SNIFFER_WOOL = registerBlock("sniffer_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.GREEN_WOOL));

    public static final Block SNIFFER_CARPET = registerBlock("sniffer_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.GREEN_CARPET));

    public static final Block CHISELED_PLATED_CALCITE = registerBlock("chiseled_plated_calcite",
            ExtraDirectionalModelBlock::new,AbstractBlock.Settings.copy(Blocks.CALCITE));

    public static final Block BLOOMING_IVY = registerBlock("blooming_ivy",
            BloomingIvyBlock::new,AbstractBlock.Settings.copy(Blocks.VINE).sounds(BlockSoundGroup.VINE).ticksRandomly());

    public static final Block WHITE_FLORAL_VEIL = registerBlock("white_floral_veil",
            GlowLichenBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.GRASS).breakInstantly().noCollision());
    public static final Block PINK_FLORAL_VEIL = registerBlock("pink_floral_veil",
            GlowLichenBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.GRASS).breakInstantly().noCollision());
    public static final Block YELLOW_FLORAL_VEIL = registerBlock("yellow_floral_veil",
            GlowLichenBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.GRASS).breakInstantly().noCollision());
    public static final Block FROST = registerBlock("frost",
            MultifaceBlock::new,AbstractBlock.Settings.copy(Blocks.ICE).sounds(BlockSoundGroup.GLASS).breakInstantly().noCollision());

    public static final Block BIOLUMINESCENT_BOTTLE = registerBlock("bioluminescent_bottle",
            BioluminescentBottleBlock::new,AbstractBlock.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).luminance(state -> 15));

    public static final Block WATER_TEMPORARY_LIGHT = registerBlock("water_temporary_light", WaterTickingBlock::new,AbstractBlock.Settings.create()
            .replaceable().noCollision().liquid().strength(-1.0F, 3600000.8F).mapColor(MapColor.CLEAR).dropsNothing()
            .nonOpaque().luminance(state -> 7));

    public static final Block TEAPOTBLOCK = registerBlock("tea_pot_block", TeaPotBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).luminance(state -> 13).nonOpaque());

    public static final Block AMETHYST_THORN = registerBlock("amethyst_thorn",
            AmethystThornBlock::new,AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER).sounds(BlockSoundGroup.AMETHYST_CLUSTER).ticksRandomly().noCollision());

    public static final Block FANCY_WHITE_WOOL = registerBlock("fancy_white_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_BLUE_WOOL = registerBlock("fancy_blue_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_CYAN_WOOL = registerBlock("fancy_cyan_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.CYAN_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_LIGHT_BLUE_WOOL = registerBlock("fancy_light_blue_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_BROWN_WOOL = registerBlock("fancy_brown_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_PINK_WOOL = registerBlock("fancy_pink_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.PINK_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_MAGENTA_WOOL = registerBlock("fancy_magenta_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_PURPLE_WOOL = registerBlock("fancy_purple_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_BLACK_WOOL = registerBlock("fancy_black_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.BLACK_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_LIGHT_GRAY_WOOL = registerBlock("fancy_light_gray_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_GRAY_WOOL = registerBlock("fancy_gray_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.GRAY_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_LIME_WOOL = registerBlock("fancy_lime_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.LIME_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_GREEN_WOOL = registerBlock("fancy_green_wool",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_ORANGE_WOOL = registerBlock("fancy_orange_wool",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_RED_WOOL = registerBlock("fancy_red_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.RED_WOOL).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_YELLOW_WOOL = registerBlock("fancy_yellow_wool",
            Block::new,AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL).sounds(BlockSoundGroup.WOOL));

    //Carpets

    public static final Block FANCY_WHITE_CARPET = registerBlock("fancy_white_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_BLUE_CARPET = registerBlock("fancy_blue_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.BLUE_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_CYAN_CARPET = registerBlock("fancy_cyan_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.CYAN_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_LIGHT_BLUE_CARPET = registerBlock("fancy_light_blue_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_BROWN_CARPET = registerBlock("fancy_brown_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.BROWN_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_PINK_CARPET = registerBlock("fancy_pink_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.PINK_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_MAGENTA_CARPET = registerBlock("fancy_magenta_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.MAGENTA_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_PURPLE_CARPET = registerBlock("fancy_purple_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.PURPLE_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_BLACK_CARPET = registerBlock("fancy_black_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.BLACK_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_LIGHT_GRAY_CARPET = registerBlock("fancy_light_gray_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_GRAY_CARPET = registerBlock("fancy_gray_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.GRAY_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_LIME_CARPET = registerBlock("fancy_lime_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.LIME_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_GREEN_CARPET = registerBlock("fancy_green_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.GREEN_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_ORANGE_CARPET = registerBlock("fancy_orange_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.ORANGE_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_RED_CARPET = registerBlock("fancy_red_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.RED_CARPET).sounds(BlockSoundGroup.WOOL));
    public static final Block FANCY_YELLOW_CARPET = registerBlock("fancy_yellow_carpet",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET).sounds(BlockSoundGroup.WOOL));

    //sandstone

    public static final Block GILDED_SANDSTONE = registerBlock("gilded_sandstone",
            Block::new,AbstractBlock.Settings.copy(Blocks.GILDED_BLACKSTONE).sounds(BlockSoundGroup.GILDED_BLACKSTONE).requiresTool());
    public static final Block GILDED_CUT_SANDSTONE = registerBlock("gilded_cut_sandstone",
            Block::new,AbstractBlock.Settings.copy(Blocks.GILDED_BLACKSTONE).sounds(BlockSoundGroup.GILDED_BLACKSTONE).requiresTool());
    public static final Block GILDED_CHISELED_SANDSTONE = registerBlock("gilded_chiseled_sandstone",
            Block::new,AbstractBlock.Settings.copy(Blocks.GILDED_BLACKSTONE).sounds(BlockSoundGroup.GILDED_BLACKSTONE).requiresTool());


    public static final Block DESERT_OAK_LOG = registerBlock("desert_oak_log",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(3f));

    public static final SaplingGenerator DESERT_OAK = new SaplingGenerator("desert_oak",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.DESERT_OAK_KEY),
            Optional.empty());
    public static final Block DESERT_OAK_SAPLING = registerBlock("desert_oak_sapling",
            settings -> new SaplingBlock(DESERT_OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));

    public static final Block DESERT_OAK_WOOD = registerBlock("desert_oak_wood",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(3f));

    public static final Block STRIPPED_DESERT_OAK_LOG = registerBlock("stripped_desert_oak_log",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(3f));

    public static final Block STRIPPED_DESERT_OAK_WOOD = registerBlock("stripped_desert_oak_wood",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f));

    public static final Block DESERT_OAK_PLANKS = registerBlock("desert_oak_planks",
            Block::new,AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(3f));

    public static final Block DESERT_OAK_BUTTON = registerBlock("desert_oak_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 10, settings),AbstractBlock.Settings.copy(Blocks.OAK_BUTTON));
    public static final Block DESERT_OAK_PRESSURE_PLATE = registerBlock("desert_oak_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE));


    public static final Identifier DESERT_OAK_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/desert_oak");
    public static final Identifier DESERT_OAK_HANGING_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/hanging/desert_oak");
    public static final Identifier DESERT_OAK_HANGING_GUI_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/gui/hanging_signs/desert_oak");
    // Fancy Bits for the desert oak
    public static final Block DESERT_OAK_STAIRS = registerBlock("desert_oak_stairs",
            settings -> new StairsBlock(ModBlocks.DESERT_OAK_PLANKS.getDefaultState(), settings),AbstractBlock.Settings.copy(Blocks.OAK_STAIRS));
    public static final Block DESERT_OAK_SLAB = registerBlock("desert_oak_slab",
            SlabBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_STAIRS));

    public static final Block DESERT_OAK_FENCE = registerBlock("desert_oak_fence",
            FenceBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block DESERT_OAK_FENCE_GATE = registerBlock("desert_oak_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));

    public static final Block DESERT_OAK_DOOR = registerBlock("desert_oak_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block DESERT_OAK_TRAPDOOR = registerBlock("desert_oak_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());




    public static final Block TERRACOTTA_BRICKS = registerBlock("terracotta_bricks",
            Block::new,AbstractBlock.Settings.copy(Blocks.TERRACOTTA).requiresTool());

    public static final BlockFamily TERRACOTTA_BRICK_FAMILY = BlockFamilies.register(ModBlocks.TERRACOTTA_BRICKS)
            .group("terracotta_group").build();



    public static final Block FOSSIL_SOIL = registerBlock(
            "fossil_soil",
            settings -> new FossilSoilBlock(
                    Blocks.AIR,
                    SoundEvents.ITEM_BRUSH_BRUSHING_GRAVEL,
                    SoundEvents.BLOCK_GRAVEL_BREAK,
                    settings),AbstractBlock.Settings.create()
                            .mapColor(MapColor.BROWN)
                            .instrument(NoteBlockInstrument.SNARE)
                            .strength(0.25F)
                            .sounds(BlockSoundGroup.SUSPICIOUS_GRAVEL)
                            .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block PETRIFIED_DIRT = registerBlock("petrified_dirt",
            Block::new,AbstractBlock.Settings.copy(Blocks.COARSE_DIRT).strength(2f));

    public static final Block TERRACOTTA_BRICK_STAIRS = registerBlock("terracotta_brick_stairs",
            settings -> new StairsBlock(ModBlocks.TERRACOTTA_BRICKS.getDefaultState(), settings),AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS).requiresTool());

    public static final Block TERRACOTTA_BRICK_SLAB = registerBlock("terracotta_brick_slab",
            SlabBlock::new,AbstractBlock.Settings.copy(Blocks.STONE_BRICK_SLAB).requiresTool());

    public static final Block TERRACOTTA_BRICK_WALL= registerBlock("terracotta_brick_wall",
            WallBlock::new,AbstractBlock.Settings.copy(Blocks.STONE_BRICK_WALL).requiresTool());



    public static final Block SPICE_BARREL = registerBlock("spice_barrel",
            SpiceBarrelBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));


    public static final Block GUANO_PILE = registerBlock("guano_pile",
            CarpetBlock::new,AbstractBlock.Settings.copy(Blocks.MOSS_CARPET).nonOpaque()
                    .noCollision().sounds(BlockSoundGroup.HONEY));

    public static final Block GUANO_BLOCK = registerBlock("guano_block",
            Block::new,AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK)
                    .sounds(BlockSoundGroup.HONEY));

    public static final Block PACKED_GUANO = registerBlock("packed_guano",
            Block::new,AbstractBlock.Settings.copy(Blocks.PACKED_MUD)
                    .sounds(BlockSoundGroup.PACKED_MUD));
    public static final Block GUANO_BRICKS = registerBlock("guano_bricks",
            Block::new,AbstractBlock.Settings.copy(Blocks.PACKED_MUD)
                    .sounds(BlockSoundGroup.PACKED_MUD));

    public static final BlockFamily GUANO_FAMILY = BlockFamilies.register(ModBlocks.GUANO_BRICKS)
            .group("guano_group").build();

    public static final Block GUANO_BRICK_STAIRS = registerBlock("guano_brick_stairs",
            settings -> new StairsBlock(ModBlocks.GUANO_BRICKS.getDefaultState(), settings),AbstractBlock.Settings.copy(Blocks.STONE_BRICK_STAIRS).requiresTool());

    public static final Block GUANO_BRICK_SLAB = registerBlock("guano_brick_slab",
            SlabBlock::new,AbstractBlock.Settings.copy(Blocks.STONE_BRICK_SLAB).requiresTool());

    public static final Block GUANO_BRICK_WALL= registerBlock("guano_brick_wall",
            WallBlock::new,AbstractBlock.Settings.copy(Blocks.STONE_BRICK_WALL).requiresTool());



    public static final Block SLIME_DRIP = registerBlock("slime_drip",
            SlimeHangingDripBlock::new,AbstractBlock.Settings.copy(Blocks.HANGING_ROOTS).nonOpaque()
                    .noCollision().sounds(BlockSoundGroup.SLIME));

    public static final Block SLIMEY_STONE = registerBlock("slimey_stone",
            SlimeDripBlock::new,AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE).ticksRandomly());

    public static final Block DEAD_LEAVES = registerBlock(
            "dead_leaves",
            settings -> new ParticleLeavesBlock(50, JaizMod.DEAD_LEAF_PARTICLE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BROWN)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
    );


    public static final Block DRIED_LEAVES = registerBlock(
            "dried_leaves",
            settings -> new DriedLeavesBlock(50, JaizMod.DRY_LEAF_PARTICLE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.ORANGE)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
    );

    public static final Block BLOOMING_IVY_BLOCK = registerBlock(
            "blooming_ivy_block",
            settings -> new DriedLeavesBlock(50, JaizMod.BLOOMING_IVY_PARTICLE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TEAL)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
    );

    public static final Block SNOWY_LEAVES = registerBlock(
            "snowy_leaves",
            settings -> new ParticleLeavesBlock(50, JaizMod.SNOW_PARTICLE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.OFF_WHITE)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.SNOW)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)
    );

    public static final Block DESERT_OAK_LEAVES = registerBlock("desert_oak_leaves", LeavesBlock::new, createLeavesSettings(BlockSoundGroup.GRASS));
    public static final Block MAHOGANY_LEAVES = registerBlock("mahogany_leaves", LeavesBlock::new, createLeavesSettings(BlockSoundGroup.GRASS));

    public static AbstractBlock.Settings createLeavesSettings(BlockSoundGroup sounds) {
        return AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN)
                .strength(0.2F)
                .ticksRandomly()
                .sounds(sounds)
                .nonOpaque()
                .allowsSpawning(Blocks::canSpawnOnLeaves)
                .suffocates(Blocks::never)
                .blockVision(Blocks::never)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
                .solidBlock(Blocks::never);
    }

    public static final Block MAHOGANY_LOG = registerBlock("mahogany_log",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_LOG).burnable());

    public static final Block MAHOGANY_WOOD = registerBlock("mahogany_wood",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_WOOD).burnable());

    public static final Block STRIPPED_MAHOGANY_LOG = registerBlock("stripped_mahogany_log",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).burnable());

    public static final Block STRIPPED_MAHOGANY_WOOD = registerBlock("stripped_mahogany_wood",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).burnable());

    public static final Block MAHOGANY_PLANKS = registerBlock("mahogany_planks",
            Block::new,AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable());

    public static final Block MAHOGANY_BUTTON = registerBlock("mahogany_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 10, settings),AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).burnable());
    public static final Block MAHOGANY_PRESSURE_PLATE = registerBlock("mahogany_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).burnable());

    public static final Identifier MAHOGANY_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/mahogany");
    public static final Identifier MAHOGANY_HANGING_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/hanging/mahogany");
    public static final Identifier MAHOGANY_HANGING_GUI_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/gui/hanging_signs/mahogany");


    public static final Block MAHOGANY_STAIRS = registerBlock("mahogany_stairs",
            settings -> new StairsBlock(ModBlocks.MAHOGANY_PLANKS.getDefaultState(), settings),AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).burnable());
    public static final Block MAHOGANY_SLAB = registerBlock("mahogany_slab",
            SlabBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).burnable());

    public static final Block MAHOGANY_FENCE = registerBlock("mahogany_fence",
            FenceBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable());
    public static final Block MAHOGANY_FENCE_GATE = registerBlock("mahogany_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable());

    public static final Block MAHOGANY_DOOR = registerBlock("mahogany_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().burnable());
    public static final Block MAHOGANY_TRAPDOOR = registerBlock("mahogany_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.JUNGLE_TRAPDOOR).nonOpaque().burnable());

    public static final SaplingGenerator MAHOGANY = new SaplingGenerator("mahogany_tree",
            Optional.of(ModConfiguredFeatures.MAHOGANY_TREE),
            Optional.of(ModConfiguredFeatures.SMALL_MAHOGANY_TREE),
            Optional.empty());
    public static final SaplingGenerator AUTUMN = new SaplingGenerator("autumn_tree",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.AUTUMN_TREE),
            Optional.empty());

    public static final Block MAHOGANY_SAPLING = registerBlock("mahogany_sapling",
            settings -> new SaplingBlock(MAHOGANY, settings),AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));

    public static final Block AUTUMN_SAPLING = registerBlock("autumn_sapling",
            settings -> new SaplingBlock(AUTUMN, settings),AbstractBlock.Settings.copy(Blocks.OAK_SAPLING));

    public static final Block FIREFLY_BOTTLE = registerBlock("firefly_bottle",
            FireflyBottleBlock::new,AbstractBlock.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).luminance(state -> 15));

    public static final Block COCOON_BLOCK = registerBlock("cocoon_block",
            CocoonBlock::new,AbstractBlock.Settings.copy(Blocks.HONEY_BLOCK).sounds(BlockSoundGroup.HONEY));

    public static final Block ROT_BLOCK = registerBlock("rot_block", settings ->
            new RotBlock(ModConfiguredFeatures.ROT_DIRT, settings), AbstractBlock.Settings.copy(Blocks.DIRT).sounds(BlockSoundGroup.MUD).ticksRandomly());

    public static final Block IVY = registerBlock("ivy",
            IvyBlock::new,AbstractBlock.Settings.copy(Blocks.VINE).sounds(BlockSoundGroup.VINE).ticksRandomly());

    public static final Block UNDERGROWTH = registerBlock("undergrowth",
            UndergrowthBlock::new,AbstractBlock.Settings.copy(Blocks.MOSS_CARPET).sounds(BlockSoundGroup.WET_GRASS).noCollision().breakInstantly().replaceable());

    public static final Block SHELF_MUSHROOM_BLOCK = registerBlock("shelf_mushroom",
            ShelfMushroomBlock::new,AbstractBlock.Settings.copy(Blocks.MUSHROOM_STEM).sounds(BlockSoundGroup.SHROOMLIGHT));

    public static final Block CALLALILY_WHITE = registerBlock("callalily_white",
            TallFlowerBlock::new,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block CALLALILY_PINK = registerBlock("callalily_pink",
            TallFlowerBlock::new,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block CALLALILY_YELLOW = registerBlock("callalily_yellow",
            TallFlowerBlock::new,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block CALLALILY_LILAC = registerBlock("callalily_lilac",
            TallFlowerBlock::new,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block CALLALILY_PURPLE = registerBlock("callalily_purple",
            TallFlowerBlock::new,AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block ROT_ROOTS = registerBlock("rot_roots",
            settings -> new FlowerBlock(StatusEffects.DARKNESS, 60, settings),AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.MUD).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY));

    public static final Block COLUMBINE = registerBlock("columbine",
            settings -> new FlowerBlock(StatusEffects.DARKNESS, 60, settings),AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY));

    //Rotten Wood

    public static final Block ROTTEN_LOG = registerBlock("rotten_log",
            RottingLog::new,AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(2f).burnable().ticksRandomly());

    public static final Block ROTTEN_WOOD = registerBlock("rotten_wood",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(2f).burnable());

    public static final Block STRIPPED_ROTTEN_LOG = registerBlock("stripped_rotten_log",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(2f).burnable());

    public static final Block STRIPPED_ROTTEN_WOOD = registerBlock("stripped_rotten_wood",
            PillarBlock::new,AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(2f).burnable());

    public static final Block ROTTEN_PLANKS = registerBlock("rotten_planks",
            Block::new,AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(2f).burnable());

    public static final Block ROTTEN_BUTTON = registerBlock("rotten_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 10, settings),AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).burnable());
    public static final Block ROTTEN_PRESSURE_PLATE = registerBlock("rotten_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).burnable());

    public static final Identifier ROTTEN_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/rotten");
    public static final Identifier ROTTEN_HANGING_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "entity/signs/hanging/rotten");
    public static final Identifier ROTTEN_HANGING_GUI_SIGN_TEXTURE = Identifier.of(JaizMod.MOD_ID, "textures/gui/hanging_signs/rotten");

    public static final Block HANGING_ROTTEN_SIGN = registerBlock("rotten_hanging_sign", settings -> new TerraformHangingSignBlock(ROTTEN_HANGING_SIGN_TEXTURE, ROTTEN_HANGING_GUI_SIGN_TEXTURE,
            settings), AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN));
    public static final Block WALL_HANGING_ROTTEN_SIGN = registerBlock("rotten_wall_hanging_sign", settings -> new TerraformWallHangingSignBlock(ROTTEN_HANGING_SIGN_TEXTURE, ROTTEN_HANGING_GUI_SIGN_TEXTURE,
            settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).lootTable(HANGING_ROTTEN_SIGN.getLootTableKey()));
    public static final Block STANDING_ROTTEN_SIGN = registerBlock("rotten_standing_sign", settings -> new TerraformSignBlock(ROTTEN_SIGN_TEXTURE, settings), AbstractBlock.Settings.copy(Blocks.OAK_SIGN));
    public static final Block WALL_ROTTEN_SIGN = registerBlock("rotten_wall_sign", settings -> new TerraformWallSignBlock(ROTTEN_SIGN_TEXTURE, settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
            .lootTable(STANDING_ROTTEN_SIGN.getLootTableKey()));

    public static final Block HANGING_DESERT_OAK_SIGN = registerBlock("desert_oak_hanging_sign", settings -> new TerraformHangingSignBlock(DESERT_OAK_HANGING_SIGN_TEXTURE, DESERT_OAK_HANGING_GUI_SIGN_TEXTURE,
            settings), AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN));
    public static final Block WALL_HANGING_DESERT_OAK_SIGN = registerBlock("desert_oak_wall_hanging_sign", settings -> new TerraformWallHangingSignBlock(DESERT_OAK_HANGING_SIGN_TEXTURE, DESERT_OAK_HANGING_GUI_SIGN_TEXTURE,
            settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).lootTable(HANGING_DESERT_OAK_SIGN.getLootTableKey()));
    public static final Block STANDING_DESERT_OAK_SIGN = registerBlock("desert_oak_standing_sign", settings -> new TerraformSignBlock(DESERT_OAK_SIGN_TEXTURE, settings), AbstractBlock.Settings.copy(Blocks.OAK_SIGN));
    public static final Block WALL_DESERT_OAK_SIGN = registerBlock("desert_oak_wall_sign", settings -> new TerraformWallSignBlock(DESERT_OAK_SIGN_TEXTURE, settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
            .lootTable(STANDING_DESERT_OAK_SIGN.getLootTableKey()));

    public static final Block HANGING_MAHOGANY_SIGN = registerBlock("mahogany_hanging_sign", settings -> new TerraformHangingSignBlock(MAHOGANY_HANGING_SIGN_TEXTURE, MAHOGANY_HANGING_GUI_SIGN_TEXTURE,
            settings), AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN));
    public static final Block WALL_HANGING_MAHOGANY_SIGN = registerBlock("mahogany_wall_hanging_sign", settings -> new TerraformWallHangingSignBlock(MAHOGANY_HANGING_SIGN_TEXTURE, MAHOGANY_HANGING_GUI_SIGN_TEXTURE,
            settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).lootTable(HANGING_MAHOGANY_SIGN.getLootTableKey()));
    public static final Block STANDING_MAHOGANY_SIGN = registerBlock("mahogany_standing_sign", settings -> new TerraformSignBlock(MAHOGANY_SIGN_TEXTURE, settings), AbstractBlock.Settings.copy(Blocks.OAK_SIGN));
    public static final Block WALL_MAHOGANY_SIGN = registerBlock("mahogany_wall_sign", settings -> new TerraformWallSignBlock(MAHOGANY_SIGN_TEXTURE, settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN)
            .lootTable(STANDING_MAHOGANY_SIGN.getLootTableKey()));

    public static final BlockFamily DESERT_OAK_FAMILY = BlockFamilies.register(ModBlocks.DESERT_OAK_PLANKS)
            .sign(ModBlocks.STANDING_DESERT_OAK_SIGN, ModBlocks.WALL_DESERT_OAK_SIGN)
           .group("wooden").unlockCriterionName("has_planks").build();

    public static final BlockFamily MAHOGANY_FAMILY = BlockFamilies.register(ModBlocks.MAHOGANY_PLANKS)
            .sign(ModBlocks.STANDING_MAHOGANY_SIGN, ModBlocks.WALL_MAHOGANY_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final BlockFamily ROTTEN_FAMILY = BlockFamilies.register(ModBlocks.ROTTEN_PLANKS)
            .sign(ModBlocks.STANDING_ROTTEN_SIGN, ModBlocks.WALL_ROTTEN_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();



    public static final Block ROTTEN_STAIRS = registerBlock("rotten_stairs",
            settings -> new StairsBlock(ModBlocks.ROTTEN_PLANKS.getDefaultState(), settings),AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).burnable());
    public static final Block ROTTEN_SLAB = registerBlock("rotten_slab",
            SlabBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).burnable());

    public static final Block ROTTEN_FENCE = registerBlock("rotten_fence",
            FenceBlock::new,AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable());
    public static final Block ROTTEN_FENCE_GATE = registerBlock("rotten_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).burnable());

    public static final Block ROTTEN_DOOR = registerBlock("rotten_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().burnable());

    public static final Block ROTTEN_TRAPDOOR = registerBlock("rotten_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().burnable());



    public static final Block WATER_TORCH = registerBlock(
            "water_torch",
            settings -> new WaterTorchBlock(
                    ParticleTypes.GLOW,settings),
                    AbstractBlock.Settings.create().noCollision().breakInstantly()
                            .luminance(state -> WallWaterTorchBlock.isDry(state) ? 3 : 15)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static final Block WALL_WATER_TORCH = registerBlock(
            "wall_water_torch",
            settings -> new WallWaterTorchBlock(
                    ParticleTypes.GLOW,settings),
                    AbstractBlock.Settings.create()
                            .noCollision()
                            .breakInstantly()
                            .luminance(state -> WallWaterTorchBlock.isDry(state) ? 3 : 15)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .pistonBehavior(PistonBehavior.DESTROY)
    );

    //Main Bits

    public static <B extends Block> B registerBlock(String name, Function<AbstractBlock.Settings, B> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(JaizMod.MOD_ID, name));
        B block = factory.apply(settings.registryKey(key));

        return Registry.register(Registries.BLOCK, key, block);
    }

    public static void registerModBlocks() {
        JaizMod.LOGGER.info("Registering ModBlocks for " + JaizMod.MOD_ID);
    }

}
