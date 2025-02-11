package jaiz.jaizmod.worldgen.features;

import jaiz.jaizmod.JaizMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> DESERT_OAK_KEY = registerKey("desert_oak");

    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_TREE = registerKey("autumn_tree");

    public static final RegistryKey<ConfiguredFeature<?, ?>> MAHOGANY_TREE = registerKey("mahogany_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_MAHOGANY_TREE = registerKey("mahogany_tree_small");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ROT_DIRT = registerKey("disk_rot_dirt");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ROT_ROOTS = registerKey("rot_roots_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COLUMBINE_PATCH = registerKey("flower_columbine");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM = registerKey("brown_mushroom_rot_patch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MUSHROOM = registerKey("mushroom_rot_patch");
    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(JaizMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
