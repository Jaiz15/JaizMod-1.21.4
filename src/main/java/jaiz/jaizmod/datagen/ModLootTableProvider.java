package jaiz.jaizmod.datagen;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.BeetrootsBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {


    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.HANGING_DESERT_OAK_SIGN);
        addDrop(ModBlocks.WALL_HANGING_DESERT_OAK_SIGN);
        addDrop(ModBlocks.STANDING_DESERT_OAK_SIGN);
        addDrop(ModBlocks.WALL_DESERT_OAK_SIGN);
        addDrop(ModBlocks.HANGING_MAHOGANY_SIGN);
        addDrop(ModBlocks.WALL_HANGING_MAHOGANY_SIGN);
        addDrop(ModBlocks.STANDING_MAHOGANY_SIGN);
        addDrop(ModBlocks.WALL_MAHOGANY_SIGN);
        addDrop(ModBlocks.HANGING_ROTTEN_SIGN);
        addDrop(ModBlocks.WALL_HANGING_ROTTEN_SIGN);
        addDrop(ModBlocks.STANDING_ROTTEN_SIGN);
        addDrop(ModBlocks.WALL_ROTTEN_SIGN);

        addDrop(ModBlocks.AUTUMN_SAPLING);
        addDrop(ModBlocks.FANCY_WHITE_WOOL);
        addDrop(ModBlocks.FANCY_LIGHT_GRAY_WOOL);
        addDrop(ModBlocks.FANCY_GRAY_WOOL);
        addDrop(ModBlocks.FANCY_BLACK_WOOL);
        addDrop(ModBlocks.FANCY_BROWN_WOOL);
        addDrop(ModBlocks.FANCY_ORANGE_WOOL);
        addDrop(ModBlocks.FANCY_RED_WOOL);
        addDrop(ModBlocks.FANCY_YELLOW_WOOL);
        addDrop(ModBlocks.FANCY_LIME_WOOL);
        addDrop(ModBlocks.FANCY_GREEN_WOOL);
        addDrop(ModBlocks.FANCY_CYAN_WOOL);
        addDrop(ModBlocks.FANCY_LIGHT_BLUE_WOOL);
        addDrop(ModBlocks.FANCY_BLUE_WOOL);
        addDrop(ModBlocks.FANCY_PURPLE_WOOL);
        addDrop(ModBlocks.FANCY_MAGENTA_WOOL);
        addDrop(ModBlocks.FANCY_PINK_WOOL);

        addDrop(ModBlocks.BIOLUMINESCENT_BOTTLE);

        addDrop(ModBlocks.BLOOMING_IVY_BLOCK);

        addDrop(ModBlocks.GILDED_CHISELED_SANDSTONE);
        addDrop(ModBlocks.GILDED_CUT_SANDSTONE);
        addDrop(ModBlocks.GILDED_SANDSTONE);

        addDrop(ModBlocks.DESERT_OAK_WOOD);
        addDrop(ModBlocks.STRIPPED_DESERT_OAK_WOOD);
        addDrop(ModBlocks.DESERT_OAK_LOG);
        addDrop(ModBlocks.STRIPPED_DESERT_OAK_LOG);
        addDrop(ModBlocks.DESERT_OAK_PLANKS);

        addDrop(ModBlocks.DESERT_OAK_DOOR, doorDrops(ModBlocks.DESERT_OAK_DOOR));
        addDrop(ModBlocks.DESERT_OAK_SLAB, slabDrops(ModBlocks.DESERT_OAK_SLAB));
        addDrop(ModBlocks.DESERT_OAK_TRAPDOOR);
        addDrop(ModBlocks.DESERT_OAK_FENCE);
        addDrop(ModBlocks.DESERT_OAK_STAIRS);
        addDrop(ModBlocks.DESERT_OAK_FENCE_GATE);
        addDrop(ModBlocks.DESERT_OAK_SAPLING);
        addDrop(ModBlocks.DESERT_OAK_BUTTON);
        addDrop(ModBlocks.DESERT_OAK_PRESSURE_PLATE);

        addDrop(ModBlocks.PETRIFIED_DIRT);
        addDrop(ModBlocks.TERRACOTTA_BRICKS);

        addDrop(ModBlocks.TERRACOTTA_BRICK_WALL);
        addDrop(ModBlocks.TERRACOTTA_BRICK_SLAB, slabDrops(ModBlocks.TERRACOTTA_BRICK_SLAB));
        addDrop(ModBlocks.TERRACOTTA_BRICK_STAIRS);

        addDrop(ModBlocks.DESERT_OAK_LEAVES, leavesDrops(ModBlocks.DESERT_OAK_LEAVES, ModBlocks.DESERT_OAK_SAPLING, 0.2f));

        addDrop(ModBlocks.MAHOGANY_WOOD);
        addDrop(ModBlocks.STRIPPED_MAHOGANY_WOOD);
        addDrop(ModBlocks.MAHOGANY_LOG);
        addDrop(ModBlocks.STRIPPED_MAHOGANY_LOG);
        addDrop(ModBlocks.MAHOGANY_PLANKS);

        addDrop(ModBlocks.MAHOGANY_DOOR, doorDrops(ModBlocks.MAHOGANY_DOOR));
        addDrop(ModBlocks.MAHOGANY_SLAB, slabDrops(ModBlocks.MAHOGANY_SLAB));
        addDrop(ModBlocks.MAHOGANY_TRAPDOOR);
        addDrop(ModBlocks.MAHOGANY_FENCE);
        addDrop(ModBlocks.MAHOGANY_STAIRS);
        addDrop(ModBlocks.MAHOGANY_FENCE_GATE);
        addDrop(ModBlocks.MAHOGANY_BUTTON);
        addDrop(ModBlocks.MAHOGANY_PRESSURE_PLATE);

        addDrop(ModBlocks.CHISELED_PLATED_CALCITE);
        addDrop(ModBlocks.PLATED_CALCITE);
        addDrop(ModBlocks.MAHOGANY_SAPLING);

        addDrop(ModBlocks.GUANO_PILE, ModItems.GUANO);
        this.addDrop(ModBlocks.SLIME_DRIP, block -> this.oreDrops(block, Items.SLIME_BALL));

        addDrop(ModBlocks.WATER_TORCH, ModItems.WATER_TORCH);
        addDrop(ModBlocks.WALL_WATER_TORCH, ModItems.WATER_TORCH);

        addDrop(ModBlocks.WHITE_FLORAL_VEIL, multifaceGrowthDrops(ModBlocks.WHITE_FLORAL_VEIL));
        addDrop(ModBlocks.PINK_FLORAL_VEIL, multifaceGrowthDrops(ModBlocks.PINK_FLORAL_VEIL));
        addDrop(ModBlocks.YELLOW_FLORAL_VEIL, multifaceGrowthDrops(ModBlocks.YELLOW_FLORAL_VEIL));

        addDrop(ModBlocks.MAHOGANY_LEAVES, leavesDrops(ModBlocks.MAHOGANY_LEAVES, ModBlocks.MAHOGANY_SAPLING, 0.1f));

        addDrop(ModBlocks.DRIED_LEAVES, leavesDrops(ModBlocks.DRIED_LEAVES, ModBlocks.AUTUMN_SAPLING, 0.1f));
        addDrop(ModBlocks.DEAD_LEAVES, leavesDrops(ModBlocks.DEAD_LEAVES, Blocks.DEAD_BUSH, 0.1f));

        addDrop(ModBlocks.SNIFFER_WOOL);
        addDrop(ModBlocks.SNIFFER_CARPET);
        addDrop(ModBlocks.SHELF_MUSHROOM_BLOCK);
        addDrop(ModBlocks.COLUMBINE);
        addDrop(ModBlocks.BLOOMING_IVY);
        addDrop(ModBlocks.ANCIENT_SPROUT);
        LootCondition.Builder ancient_sprout_builder = BlockStatePropertyLootCondition.builder(ModBlocks.ANCIENT_SPROUT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7));
        addDrop(ModBlocks.ANCIENT_SPROUT_CROP, cropDrops(ModBlocks.ANCIENT_SPROUT_CROP, ModItems.ANCIENT_SPROUT, ModItems.ANCIENT_SPROUT_SEEDS, ancient_sprout_builder));

        LootCondition.Builder blooming_ivy_builder = BlockStatePropertyLootCondition.builder(ModBlocks.BLOOMING_IVY_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7));
        addDrop(ModBlocks.BLOOMING_IVY_CROP, cropDrops(ModBlocks.BLOOMING_IVY_CROP, ModItems.BLOOMING_IVY, ModItems.BLOOMING_IVY_SEEDS, blooming_ivy_builder));


        addDrop(ModBlocks.ROTTEN_WOOD);
        addDrop(ModBlocks.STRIPPED_ROTTEN_WOOD);
        addDrop(ModBlocks.ROTTEN_LOG);
        addDrop(ModBlocks.STRIPPED_ROTTEN_LOG);
        addDrop(ModBlocks.ROTTEN_PLANKS);
        addDrop(ModBlocks.ROTTEN_BUTTON);
        addDrop(ModBlocks.ROTTEN_PRESSURE_PLATE);
        addDrop(ModBlocks.ROT_BLOCK);

        addDrop(ModBlocks.IVY, shortPlantDrops(ModBlocks.IVY));
        addDrop(ModBlocks.UNDERGROWTH, shortPlantDrops(ModBlocks.UNDERGROWTH));
        addDrop(ModBlocks.ROT_ROOTS, shortPlantDrops(ModBlocks.ROT_ROOTS));

        addDrop(ModBlocks.ROTTEN_DOOR, doorDrops(ModBlocks.ROTTEN_DOOR));
        addDrop(ModBlocks.ROTTEN_SLAB, slabDrops(ModBlocks.ROTTEN_SLAB));
        addDrop(ModBlocks.ROTTEN_TRAPDOOR);
        addDrop(ModBlocks.ROTTEN_FENCE);
        addDrop(ModBlocks.ROTTEN_STAIRS);
        addDrop(ModBlocks.ROTTEN_FENCE_GATE);
    }
}
