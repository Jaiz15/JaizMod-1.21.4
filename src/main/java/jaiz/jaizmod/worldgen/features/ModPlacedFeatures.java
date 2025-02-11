package jaiz.jaizmod.worldgen.features;


import jaiz.jaizmod.JaizMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> DESERT_OAK_PLACED_KEY = registerKey("desert_oak_placed");

    public static final RegistryKey<PlacedFeature> SMALL_MAHOGANY_PLACED = registerKey("small_mahogany_tree_placed");

    public static final RegistryKey<PlacedFeature> ROTTEN_LOG_PLACED = registerKey("rotten_trees");

    public static final RegistryKey<PlacedFeature> WHITE_FLORAL_PLACED = registerKey("white_floral_veil");
    public static final RegistryKey<PlacedFeature> PINK_FLORAL_PLACED = registerKey("pink_floral_veil");
    public static final RegistryKey<PlacedFeature> YELLOW_FLORAL_PLACED = registerKey("yellow_floral_veil");

    public static final RegistryKey<PlacedFeature> AUTUMN_OAK_PLACED = registerKey("autumn_oak_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_BIRCH_PLACED = registerKey("autumn_birch_placed");

    public static final RegistryKey<PlacedFeature> ROT_RED_MUSHROOM_PLACED = registerKey("red_mushroom_rot_patch_placed");
    public static final RegistryKey<PlacedFeature> ROT_BROWN_MUSHROOM_PLACED = registerKey("brown_mushroom_rot_patch_placed");

    public static final RegistryKey<PlacedFeature> ROT_ROOTS_PLACED = registerKey("rot_roots_patch_placed");

    public static final RegistryKey<PlacedFeature> POO_PLACED = registerKey("poo_patch_placed");
    public static final RegistryKey<PlacedFeature> POO_PLACED_DEEPSLATE = registerKey("deepslate_poo_patch_placed");

    public static final RegistryKey<PlacedFeature> MOSS_PATCH_FRUIT_BAT_CAVES = registerKey("fruitbat_caves_moss_block_patch");
    public static final RegistryKey<PlacedFeature> MOSS_PATCH_FRUIT_BAT_CAVES_DEEPSLATE = registerKey("fruitbat_caves_moss_block_patch_deepslate");

    public static final RegistryKey<PlacedFeature> LEAVES_PATCH_DEEPSLATE = registerKey("leaves_block_patch_deepslate");
    public static final RegistryKey<PlacedFeature> LEAVES_PATCH = registerKey("leaves_block_patch");
    public static final RegistryKey<PlacedFeature> LEAVES_CEILING_PATCH = registerKey("leaves_leaves_block_patch");

    public static final RegistryKey<PlacedFeature> MOSS_CARPET_DEEPSLATE_FRUIT_BAT_CAVES = registerKey("fruitbat_caves_moss_carpet_placed_deepslate");
    public static final RegistryKey<PlacedFeature> MOSS_CARPET_FRUIT_BAT_CAVES = registerKey("fruitbat_caves_moss_carpet_placed");

    public static final RegistryKey<PlacedFeature> PODZOL_PATCH = registerKey("podzol_block_patch");

    public static final RegistryKey<PlacedFeature> MUD_PATCH = registerKey("mud_block_patch");

    public static final RegistryKey<PlacedFeature> BIRCH_LOG_MOSS = registerKey("birch_log_moss_patch_placed");

    public static final RegistryKey<PlacedFeature> BIRCH_FOREST_ROCK = registerKey("birch_forest_rock");
    public static final RegistryKey<PlacedFeature> CALLALILY_PLACED = registerKey("callalily_placed");
    public static final RegistryKey<PlacedFeature> DISK_ROOTED_DIRT = registerKey("disk_rooted_dirt");
    public static final RegistryKey<PlacedFeature> BIRCH_FALLEN_LOG = registerKey("fallen_birch_log_placed");
    public static final RegistryKey<PlacedFeature> DISK_ROT_DIRT = registerKey("disk_rot_dirt");
    public static final RegistryKey<PlacedFeature> FLOWER_COLUMBINE = registerKey("flower_columbine");
    public static final RegistryKey<PlacedFeature> MOSS_PATCH_PLACED = registerKey("moss_patch_placed");
    public static final RegistryKey<PlacedFeature> MOSS_BLOCK_PATCH = registerKey("moss_block_patch");
    public static final RegistryKey<PlacedFeature> UNDERGROWTH_PATCH_PLACED = registerKey("undergrowth_patch_placed");
    public static final RegistryKey<PlacedFeature> LARGE_FERNS_JAIZMOD = registerKey("large_ferns_jaizmod");


    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(JaizMod.MOD_ID, name));
    }

    public static RegistryKey<PlacedFeature> registerVanillaIDKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.ofVanilla(name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
