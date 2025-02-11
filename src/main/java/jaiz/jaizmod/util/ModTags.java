package jaiz.jaizmod.util;

import jaiz.jaizmod.JaizMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> ROTTABLE_LEAVES =
                createTag("rottable_leaves");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(JaizMod.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> SNIFFER_CHERRY =
                createTag("sniffer_cherry");
        public static final TagKey<Biome> SNIFFER_MOSSY =
                createTag("sniffer_mossy");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(JaizMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BATTERED_REPARABLE =
                createTag("battered_reparable");
        public static final TagKey<Item> MASON_MOUTH_TRANSFORMABLE =
                createTag("mason_mouth_transformable");
        public static final TagKey<Item> TEA_INGREDIENT =
                createTag("tea_ingredient");
        public static final TagKey<Item> TEA_FLOWERS =
                createTag("tea_flowers");
        public static final TagKey<Item> OBSIDIAN_SHARDS =
                createTag("obsidian_shards");



        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(JaizMod.MOD_ID, name));
        }
    }
}
