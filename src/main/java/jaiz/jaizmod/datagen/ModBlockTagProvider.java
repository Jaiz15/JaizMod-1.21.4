package jaiz.jaizmod.datagen;

import jaiz.jaizmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.WOOL)
                .add(ModBlocks.SNIFFER_WOOL)
                .add(ModBlocks.FANCY_WHITE_WOOL)
                .add(ModBlocks.FANCY_LIGHT_GRAY_WOOL)
                .add(ModBlocks.FANCY_GRAY_WOOL)
                .add(ModBlocks.FANCY_BLACK_WOOL)
                .add(ModBlocks.FANCY_BROWN_WOOL)
                .add(ModBlocks.FANCY_RED_WOOL)
                .add(ModBlocks.FANCY_ORANGE_WOOL)
                .add(ModBlocks.FANCY_YELLOW_WOOL)
                .add(ModBlocks.FANCY_LIME_WOOL)
                .add(ModBlocks.FANCY_GREEN_WOOL)
                .add(ModBlocks.FANCY_CYAN_WOOL)
                .add(ModBlocks.FANCY_LIGHT_BLUE_WOOL)
                .add(ModBlocks.FANCY_BLUE_WOOL)
                .add(ModBlocks.FANCY_PURPLE_WOOL)
                .add(ModBlocks.FANCY_MAGENTA_WOOL)
                .add(ModBlocks.FANCY_PINK_WOOL);

        getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
                .add(ModBlocks.FANCY_WHITE_CARPET)
                .add(ModBlocks.SNIFFER_CARPET)
                .add(ModBlocks.FANCY_LIGHT_GRAY_CARPET)
                .add(ModBlocks.FANCY_GRAY_CARPET)
                .add(ModBlocks.FANCY_BLACK_CARPET)
                .add(ModBlocks.FANCY_BROWN_CARPET)
                .add(ModBlocks.FANCY_RED_CARPET)
                .add(ModBlocks.FANCY_ORANGE_CARPET)
                .add(ModBlocks.FANCY_YELLOW_CARPET)
                .add(ModBlocks.FANCY_LIME_CARPET)
                .add(ModBlocks.FANCY_GREEN_CARPET)
                .add(ModBlocks.FANCY_CYAN_CARPET)
                .add(ModBlocks.FANCY_LIGHT_BLUE_CARPET)
                .add(ModBlocks.FANCY_BLUE_CARPET)
                .add(ModBlocks.FANCY_PURPLE_CARPET)
                .add(ModBlocks.FANCY_MAGENTA_CARPET)
                .add(ModBlocks.FANCY_PINK_CARPET);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.DESERT_OAK_PLANKS)
                .add(ModBlocks.MAHOGANY_PLANKS)
                .add(ModBlocks.ROTTEN_PLANKS);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.DESERT_OAK_LOG)
                .add(ModBlocks.DESERT_OAK_WOOD)
                .add(ModBlocks.STRIPPED_DESERT_OAK_LOG)
                .add(ModBlocks.STRIPPED_DESERT_OAK_WOOD)
                .add(ModBlocks.MAHOGANY_LOG)
                .add(ModBlocks.MAHOGANY_WOOD)
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG)
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD)
                .add(ModBlocks.ROTTEN_LOG)
                .add(ModBlocks.ROTTEN_WOOD)
                .add(ModBlocks.STRIPPED_ROTTEN_LOG)
                .add(ModBlocks.STRIPPED_ROTTEN_WOOD);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.DESERT_OAK_FENCE)
                .add(ModBlocks.ROTTEN_FENCE)
                .add(ModBlocks.MAHOGANY_FENCE);


        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.FOSSIL_SOIL)
                .add(Blocks.SAND)
                .add(Blocks.GRAVEL)
                .add(Blocks.RED_SAND)
                .add(ModBlocks.PETRIFIED_DIRT)
                .add(ModBlocks.ROT_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.FOSSIL_SOIL)
                .add(ModBlocks.GUANO_BLOCK)
                .add(ModBlocks.PETRIFIED_DIRT)
                .add(ModBlocks.ROT_BLOCK);

        getOrCreateTagBuilder(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(ModBlocks.FOSSIL_SOIL)
                .add(ModBlocks.PETRIFIED_DIRT);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.GUANO_BRICK_WALL)
                .add(ModBlocks.TERRACOTTA_BRICK_WALL);


        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.DESERT_OAK_FENCE_GATE)
                .add(ModBlocks.MAHOGANY_FENCE_GATE)
                .add(ModBlocks.ROTTEN_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.DESERT_OAK_LEAVES)
                .add(ModBlocks.DRIED_LEAVES)
                .add(ModBlocks.DEAD_LEAVES)
                .add(ModBlocks.SNOWY_LEAVES)
                .add(ModBlocks.MAHOGANY_LEAVES);


        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.DESERT_OAK_SLAB)
                .add(ModBlocks.ROTTEN_SLAB)
                .add(ModBlocks.MAHOGANY_SLAB);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.DESERT_OAK_SLAB)
                .add(ModBlocks.TERRACOTTA_BRICK_SLAB)
                .add(ModBlocks.GUANO_BRICK_SLAB)
                .add(ModBlocks.ROTTEN_SLAB)
                .add(ModBlocks.MAHOGANY_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.DESERT_OAK_BUTTON)
                .add(ModBlocks.MAHOGANY_BUTTON)
                .add(ModBlocks.ROTTEN_BUTTON);


        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.DESERT_OAK_STAIRS)
                .add(ModBlocks.ROTTEN_STAIRS)
                .add(ModBlocks.MAHOGANY_STAIRS);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.DESERT_OAK_STAIRS)
                .add(ModBlocks.TERRACOTTA_BRICK_STAIRS)
                .add(ModBlocks.GUANO_BRICK_STAIRS)
                .add(ModBlocks.ROTTEN_STAIRS)
                .add(ModBlocks.MAHOGANY_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.DESERT_OAK_PRESSURE_PLATE)
                .add(ModBlocks.ROTTEN_PRESSURE_PLATE)
                .add(ModBlocks.MAHOGANY_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.DESERT_OAK_FENCE)
                .add(ModBlocks.ROTTEN_FENCE)
                .add(ModBlocks.MAHOGANY_FENCE);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.DESERT_OAK_DOOR)
                .add(ModBlocks.DESERT_OAK_TRAPDOOR)
                .add(ModBlocks.ROTTEN_DOOR)
                .add(ModBlocks.ROTTEN_TRAPDOOR)
                .add(ModBlocks.MAHOGANY_DOOR)
                .add(ModBlocks.MAHOGANY_TRAPDOOR);


        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.MAHOGANY_SAPLING)
                .add(ModBlocks.DESERT_OAK_SAPLING);

        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK)
                .add(ModBlocks.ROT_BLOCK)
                .add(ModBlocks.ROTTEN_LOG)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.OAK_LOG)
                .add(ModBlocks.ROTTEN_WOOD)
                .add(ModBlocks.STRIPPED_ROTTEN_LOG)
                .add(ModBlocks.STRIPPED_ROTTEN_WOOD);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)

                .add(ModBlocks.PACKED_GUANO)
                .add(ModBlocks.GUANO_BRICK_WALL)
                .add(ModBlocks.GUANO_BRICK_STAIRS)
                .add(ModBlocks.GUANO_BRICK_SLAB)
                .add(ModBlocks.GUANO_BRICKS)
                .add(ModBlocks.TERRACOTTA_BRICK_WALL)
                .add(ModBlocks.TERRACOTTA_BRICK_STAIRS)
                .add(ModBlocks.TERRACOTTA_BRICKS)
                .add(ModBlocks.GILDED_CHISELED_SANDSTONE)
                .add(ModBlocks.GILDED_SANDSTONE)
                .add(ModBlocks.GILDED_CUT_SANDSTONE)
                .add(ModBlocks.CHISELED_PLATED_CALCITE)
                .add(ModBlocks.PLATED_CALCITE)
                .add(ModBlocks.TERRACOTTA_BRICK_SLAB);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.DESERT_OAK_LEAVES)
                .add(ModBlocks.BLOOMING_IVY_BLOCK)
                .add(ModBlocks.DEAD_LEAVES)
                .add(ModBlocks.DRIED_LEAVES)
                .add(ModBlocks.MAHOGANY_LEAVES);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.ROTTEN_PLANKS)
                .add(ModBlocks.ROTTEN_DOOR)
                .add(ModBlocks.ROTTEN_TRAPDOOR)
                .add(ModBlocks.ROTTEN_FENCE)
                .add(ModBlocks.ROTTEN_FENCE_GATE)
                .add(ModBlocks.ROTTEN_SLAB)
                .add(ModBlocks.ROTTEN_STAIRS)
                .add(ModBlocks.WALL_ROTTEN_SIGN)
                .add(ModBlocks.STANDING_ROTTEN_SIGN)
                .add(ModBlocks.HANGING_ROTTEN_SIGN)
                .add(ModBlocks.WALL_HANGING_ROTTEN_SIGN)
                .add(ModBlocks.ROTTEN_LOG)
                .add(ModBlocks.ROTTEN_WOOD)
                .add(ModBlocks.STRIPPED_ROTTEN_LOG)
                .add(ModBlocks.STRIPPED_ROTTEN_WOOD)
                .add(ModBlocks.SHELF_MUSHROOM_BLOCK)
                .add(ModBlocks.MAHOGANY_LOG)
                .add(ModBlocks.STRIPPED_MAHOGANY_LOG)
                .add(ModBlocks.MAHOGANY_STAIRS)
                .add(ModBlocks.MAHOGANY_FENCE)
                .add(ModBlocks.MAHOGANY_FENCE_GATE)
                .add(ModBlocks.MAHOGANY_BUTTON)
                .add(ModBlocks.MAHOGANY_PLANKS)
                .add(ModBlocks.MAHOGANY_SLAB)
                .add(ModBlocks.MAHOGANY_STAIRS)
                .add(ModBlocks.MAHOGANY_WOOD)
                .add(ModBlocks.STRIPPED_MAHOGANY_WOOD)
                .add(ModBlocks.MAHOGANY_DOOR)
                .add(ModBlocks.MAHOGANY_PRESSURE_PLATE)
                .add(ModBlocks.MAHOGANY_TRAPDOOR)
                .add(ModBlocks.HANGING_MAHOGANY_SIGN)
                .add(ModBlocks.WALL_HANGING_MAHOGANY_SIGN)
                .add(ModBlocks.WALL_MAHOGANY_SIGN)
                .add(ModBlocks.STANDING_DESERT_OAK_SIGN)
                .add(ModBlocks.DESERT_OAK_LOG)
                .add(ModBlocks.STRIPPED_DESERT_OAK_LOG)
                .add(ModBlocks.DESERT_OAK_STAIRS)
                .add(ModBlocks.DESERT_OAK_FENCE)
                .add(ModBlocks.DESERT_OAK_FENCE_GATE)
                .add(ModBlocks.DESERT_OAK_BUTTON)
                .add(ModBlocks.DESERT_OAK_PLANKS)
                .add(ModBlocks.DESERT_OAK_SLAB)
                .add(ModBlocks.DESERT_OAK_STAIRS)
                .add(ModBlocks.DESERT_OAK_WOOD)
                .add(ModBlocks.STRIPPED_DESERT_OAK_WOOD)
                .add(ModBlocks.DESERT_OAK_DOOR)
                .add(ModBlocks.DESERT_OAK_PRESSURE_PLATE)
                .add(ModBlocks.DESERT_OAK_TRAPDOOR)
                .add(ModBlocks.HANGING_DESERT_OAK_SIGN)
                .add(ModBlocks.WALL_HANGING_DESERT_OAK_SIGN)
                .add(ModBlocks.WALL_DESERT_OAK_SIGN)
                .add(ModBlocks.SPICE_BARREL)
                .add(ModBlocks.STANDING_DESERT_OAK_SIGN);


        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.ANCIENT_SPROUT)
                .add(ModBlocks.PINK_FLORAL_VEIL)
                .add(ModBlocks.WHITE_FLORAL_VEIL)
                .add(ModBlocks.YELLOW_FLORAL_VEIL)
                .add(ModBlocks.COLUMBINE);

        getOrCreateTagBuilder(BlockTags.BEE_ATTRACTIVE)
                .add(ModBlocks.CALLALILY_LILAC)
                .add(ModBlocks.PINK_FLORAL_VEIL)
                .add(ModBlocks.WHITE_FLORAL_VEIL)
                .add(ModBlocks.YELLOW_FLORAL_VEIL)
                .add(ModBlocks.CALLALILY_YELLOW)
                .add(ModBlocks.CALLALILY_PURPLE)
                .add(ModBlocks.CALLALILY_WHITE)
                .add(ModBlocks.CALLALILY_PINK)
                .add(ModBlocks.BLOOMING_IVY)
                .add(ModBlocks.COLUMBINE);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE)
                .add(ModBlocks.COLUMBINE)
                .add(ModBlocks.BLOOMING_IVY)
                .add(ModBlocks.PINK_FLORAL_VEIL)
                .add(ModBlocks.WHITE_FLORAL_VEIL)
                .add(ModBlocks.YELLOW_FLORAL_VEIL)
                .add(ModBlocks.CALLALILY_LILAC)
                .add(ModBlocks.CALLALILY_YELLOW)
                .add(ModBlocks.CALLALILY_PURPLE)
                .add(ModBlocks.CALLALILY_WHITE)
                .add(ModBlocks.CALLALILY_PINK)
                .add(ModBlocks.SHELF_MUSHROOM_BLOCK)
                .add(ModBlocks.IVY)
                .add(ModBlocks.ROT_ROOTS)
                .add(ModBlocks.UNDERGROWTH);

        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES)
                .add(ModBlocks.SHELF_MUSHROOM_BLOCK)
                .add(ModBlocks.IVY)
                .add(ModBlocks.PINK_FLORAL_VEIL)
                .add(ModBlocks.WHITE_FLORAL_VEIL)
                .add(ModBlocks.YELLOW_FLORAL_VEIL)
                .add(ModBlocks.BLOOMING_IVY)
                .add(ModBlocks.ROT_ROOTS)
                .add(ModBlocks.UNDERGROWTH);


    }
}
