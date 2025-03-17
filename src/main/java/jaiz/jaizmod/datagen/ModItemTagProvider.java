package jaiz.jaizmod.datagen;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(ItemTags.WOOL)
                .add(ModItems.SNIFFER_WOOL)
                .add(ModItems.FANCY_WHITE_WOOL)
                .add(ModItems.FANCY_LIGHT_GRAY_WOOL)
                .add(ModItems.FANCY_GRAY_WOOL)
                .add(ModItems.FANCY_BLACK_WOOL)
                .add(ModItems.FANCY_BROWN_WOOL)
                .add(ModItems.FANCY_RED_WOOL)
                .add(ModItems.FANCY_ORANGE_WOOL)
                .add(ModItems.FANCY_YELLOW_WOOL)
                .add(ModItems.FANCY_LIME_WOOL)
                .add(ModItems.FANCY_GREEN_WOOL)
                .add(ModItems.FANCY_CYAN_WOOL)
                .add(ModItems.FANCY_LIGHT_BLUE_WOOL)
                .add(ModItems.FANCY_BLUE_WOOL)
                .add(ModItems.FANCY_PURPLE_WOOL)
                .add(ModItems.FANCY_MAGENTA_WOOL)
                .add(ModItems.FANCY_PINK_WOOL);

        getOrCreateTagBuilder(ItemTags.WOOL_CARPETS)
                .add(ModItems.FANCY_WHITE_CARPET)
                .add(ModItems.SNIFFER_CARPET)
                .add(ModItems.FANCY_LIGHT_GRAY_CARPET)
                .add(ModItems.FANCY_GRAY_CARPET)
                .add(ModItems.FANCY_BLACK_CARPET)
                .add(ModItems.FANCY_BROWN_CARPET)
                .add(ModItems.FANCY_RED_CARPET)
                .add(ModItems.FANCY_ORANGE_CARPET)
                .add(ModItems.FANCY_YELLOW_CARPET)
                .add(ModItems.FANCY_LIME_CARPET)
                .add(ModItems.FANCY_GREEN_CARPET)
                .add(ModItems.FANCY_CYAN_CARPET)
                .add(ModItems.FANCY_LIGHT_BLUE_CARPET)
                .add(ModItems.FANCY_BLUE_CARPET)
                .add(ModItems.FANCY_PURPLE_CARPET)
                .add(ModItems.FANCY_MAGENTA_CARPET)
                .add(ModItems.FANCY_PINK_CARPET);


        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BATTERED_AXE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_OBSIDIAN_DAGGER)
                .add(ModItems.WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_SWORD)
                .add(ModItems.MACUAHUITL)
                .add(ModItems.OBSIDIAN_SWORD);

        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_OBSIDIAN_DAGGER)
                .add(ModItems.WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_SWORD)
                .add(ModItems.MACUAHUITL)
                .add(ModItems.BATTERED_AXE)
                .add(ModItems.OBSIDIAN_SWORD);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.BATTERED_AXE);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.BATTERED_AXE);

        getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .add(ModItems.OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_OBSIDIAN_DAGGER)
                .add(ModItems.WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_SWORD)
                .add(ModItems.MACUAHUITL)
                .add(ModItems.AIR_HORN)
                .add(ModItems.GLOWING_SPYGLASS)
                .add(ModItems.AMETHYST_HORN)
                .add(ModItems.ANCIENT_HORN)
                .add(ModItems.BATTERED_AXE)
                .add(ModItems.OBSIDIAN_SWORD);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.OBSIDIAN_DAGGER)
                .add(ModItems.GLOWING_SPYGLASS)
                .add(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_DAGGER)
                .add(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD)
                .add(ModItems.WEDGE_OBSIDIAN_DAGGER)
                .add(ModItems.WEDGE_OBSIDIAN_SWORD)
                .add(ModItems.SHARP_OBSIDIAN_SWORD)
                .add(ModItems.MACUAHUITL)
                .add(ModItems.AIR_HORN)
                .add(ModItems.AMETHYST_HORN)
                .add(ModItems.ANCIENT_HORN)
                .add(ModItems.BATTERED_AXE)
                .add(ModItems.OBSIDIAN_SWORD);

        getOrCreateTagBuilder(ItemTags.FENCES)
                .add(ModItems.ROTTEN_FENCE)
                .add(ModItems.DESERT_OAK_FENCE)
                .add(ModItems.MAHOGANY_FENCE);

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModItems.TERRACOTTA_BRICK_WALL);

        getOrCreateTagBuilder(ItemTags.STONE_BRICKS)
                .add(ModItems.TERRACOTTA_BRICKS);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModItems.MAHOGANY_LOG)
                .add(ModItems.MAHOGANY_WOOD)
                .add(ModItems.STRIPPED_MAHOGANY_LOG)
                .add(ModItems.STRIPPED_MAHOGANY_WOOD)
                .add(ModItems.ROTTEN_LOG)
                .add(ModItems.ROTTEN_WOOD)
                .add(ModItems.STRIPPED_ROTTEN_LOG)
                .add(ModItems.STRIPPED_ROTTEN_WOOD)
                .add(ModItems.DESERT_OAK_LOG)
                .add(ModItems.DESERT_OAK_WOOD)
                .add(ModItems.STRIPPED_DESERT_OAK_LOG)
                .add(ModItems.STRIPPED_DESERT_OAK_WOOD);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModItems.ROTTEN_PLANKS)
                .add(ModItems.DESERT_OAK_PLANKS)
                .add(ModItems.MAHOGANY_PLANKS);

        getOrCreateTagBuilder(ItemTags.DIRT)
                .add(ModItems.PETRIFIED_DIRT)
                .add(ModItems.ROT_BLOCK);

        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModItems.DESERT_OAK_FENCE_GATE)
                .add(ModItems.MAHOGANY_FENCE_GATE)
                .add(ModItems.ROTTEN_FENCE_GATE);

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModItems.DESERT_OAK_SLAB)
                .add(ModItems.ROTTEN_SLAB)
                .add(ModItems.MAHOGANY_SLAB);

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModItems.DESERT_OAK_BUTTON)
                .add(ModItems.MAHOGANY_BUTTON)
                .add(ModItems.ROTTEN_BUTTON);

        getOrCreateTagBuilder(ItemTags.BEE_FOOD)
                .add(ModItems.CALLALILY_LILAC)
                .add(ModItems.CALLALILY_YELLOW)
                .add(ModItems.CALLALILY_PURPLE)
                .add(ModItems.CALLALILY_WHITE)
                .add(ModItems.CALLALILY_PINK)
                .add(ModItems.PINK_FLORAL_VEIL)
                .add(ModItems.WHITE_FLORAL_VEIL)
                .add(ModItems.YELLOW_FLORAL_VEIL)
                .add(ModItems.COLUMBINE);


        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModItems.DESERT_OAK_STAIRS.asItem())
                .add(ModItems.ROTTEN_STAIRS.asItem())
                .add(ModItems.MAHOGANY_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModItems.DESERT_OAK_PRESSURE_PLATE.asItem())
                .add(ModItems.ROTTEN_PRESSURE_PLATE.asItem())
                .add(ModItems.MAHOGANY_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModItems.ROTTEN_FENCE.asItem())
                .add(ModItems.DESERT_OAK_FENCE.asItem())
                .add(ModItems.MAHOGANY_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModItems.DESERT_OAK_DOOR)
                .add(ModItems.DESERT_OAK_TRAPDOOR)
                .add(ModItems.ROTTEN_DOOR)
                .add(ModItems.ROTTEN_TRAPDOOR)
                .add(ModItems.MAHOGANY_DOOR)
                .add(ModItems.MAHOGANY_TRAPDOOR);

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModItems.DESERT_OAK_LEAVES)
                .add(ModItems.DEAD_LEAVES)
                .add(ModItems.DRIED_LEAVES)
                .add(ModItems.SNOWY_LEAVES)
                .add(ModItems.MAHOGANY_LEAVES);

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModItems.DESERT_OAK_SAPLING)
                .add(ModItems.MAHOGANY_SAPLING);

        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModItems.COLUMBINE)
                .add(ModItems.PINK_FLORAL_VEIL)
                .add(ModItems.WHITE_FLORAL_VEIL)
                .add(ModItems.YELLOW_FLORAL_VEIL)
                .add(ModItems.ANCIENT_SPROUT);

        getOrCreateTagBuilder(ItemTags.SNIFFER_FOOD)
                .add(ModItems.BLOOMING_IVY)
                .add(Items.SMALL_DRIPLEAF)
                .add(Items.TORCHFLOWER)
                .add(Items.PITCHER_POD)
                .add(Items.PITCHER_PLANT)
                .add(ModItems.ANCIENT_SPROUT);

    }


}
