package jaiz.jaizmod.datagen;


import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataOutput;
import net.minecraft.data.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends RecipeGenerator {

    public ModRecipeProvider(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        super(wrapperLookup, recipeExporter);
    }

    @Override
    public void generate() {


        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATED_CALCITE, 4)
                .pattern("RX")
                .pattern("XR")
                .input('R', Items.CALCITE)
                .input('X', Items.POLISHED_BLACKSTONE)
                .criterion(hasItem(Items.CALCITE), conditionsFromItem(Items.CALCITE))
                .criterion(hasItem(Items.POLISHED_BLACKSTONE), conditionsFromItem(Items.POLISHED_BLACKSTONE))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_PLATED_CALCITE, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.PLATED_CALCITE)
                .criterion(hasItem(ModItems.PLATED_CALCITE), conditionsFromItem(ModItems.PLATED_CALCITE))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FROST, 4)
                .pattern("RR")
                .input('R', Items.ICE)
                .criterion(hasItem(Items.ICE), conditionsFromItem(Items.ICE))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.DECORATIONS, ModItems.BLOOMING_IVY_BLOCK, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.BLOOMING_IVY)
                .criterion(hasItem(ModItems.BLOOMING_IVY), conditionsFromItem(ModItems.BLOOMING_IVY))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SNIFFER_WOOL, 1)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.SNIFFER_TUFT)
                .criterion(hasItem(ModItems.SNIFFER_TUFT), conditionsFromItem(ModItems.SNIFFER_TUFT))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "sniffer_wool_from_tuft")));

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SNIFFER_CARPET, 3)
                .pattern("RR")
                .input('R', ModItems.SNIFFER_WOOL)
                .criterion(hasItem(ModItems.SNIFFER_WOOL), conditionsFromItem(ModItems.SNIFFER_WOOL))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "sniffer_carpet_from_wool")));

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, Items.ARROW, 4)
                .pattern("R")
                .pattern("G")
                .pattern("X")
                .input('X', ModItems.SNIFFER_TUFT)
                .input('G', Items.FLINT)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.SNIFFER_TUFT), conditionsFromItem(ModItems.SNIFFER_TUFT))
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "arrow_from_tuft")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.WRITABLE_BOOK, 1)
                .input(ModItems.SNIFFER_TUFT)
                .input(Items.BOOK)
                .input(Items.INK_SAC)
                .criterion(hasItem(ModItems.SNIFFER_TUFT), conditionsFromItem(ModItems.SNIFFER_TUFT))
                .criterion(hasItem(Items.INK_SAC), conditionsFromItem(Items.INK_SAC))
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "book_and_quill_from_tuft")));

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, Items.BRUSH, 1)
                .pattern("X")
                .pattern("G")
                .pattern("R")
                .input('X', ModItems.SNIFFER_TUFT)
                .input('G', Items.COPPER_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.SNIFFER_TUFT), conditionsFromItem(ModItems.SNIFFER_TUFT))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "brush_from_tuft")));

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, Items.GREEN_BED, 1)
                .pattern("GGG")
                .pattern("RRR")
                .input('G', ModItems.SNIFFER_WOOL)
                .input('R', ItemTags.PLANKS)
                .criterion(hasItem(ModItems.SNIFFER_WOOL), conditionsFromItem(ModItems.SNIFFER_WOOL))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "bed_from_sniffer_wool")));

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, Items.GREEN_BANNER, 6)
                .pattern("GGG")
                .pattern("GGG")
                .pattern(" R ")
                .input('G', ModItems.SNIFFER_WOOL)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.SNIFFER_WOOL), conditionsFromItem(ModItems.SNIFFER_WOOL))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "banner_from_sniffer_wool")));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModItems.PLATED_CALCITE), RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_PLATED_CALCITE, 1)
                .criterion(hasItem(ModItems.PLATED_CALCITE), conditionsFromItem(ModItems.PLATED_CALCITE))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "chiseled_plated_calcite_from_stone_cutter")));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModItems.PLATED_CALCITE, 1)
                .criterion(hasItem(Items.CALCITE), conditionsFromItem(Items.CALCITE))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "plated_calcite_from_stone_cutter")));

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.TERRACOTTA), RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICKS, 1)
                .criterion(hasItem(Items.TERRACOTTA), conditionsFromItem(Items.TERRACOTTA))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "terracotta_bricks_from_stone_cutter")));


        this.createShapeless(RecipeCategory.MISC, ModItems.DYNAMITE, 1)
                .input(Items.PAPER)
                .input(Items.STRING)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(ModItems.DYNAMITE), conditionsFromItem(ModItems.DYNAMITE))
                .offerTo(this.exporter);

        List<ItemConvertible> UNFIRED_TEA_CUP = List.of(ModItems.UNFIRED_TEA_CUP);
        this.offerSmelting(UNFIRED_TEA_CUP, RecipeCategory.FOOD, ModItems.TEA_CUP, 0.25f, 200, "tea_cup");
        this.offerBlasting(UNFIRED_TEA_CUP, RecipeCategory.FOOD, ModItems.TEA_CUP, 0.25f, 150, "tea_cup");

        List<ItemConvertible> SNIFFER_MEAT = List.of(ModItems.SNIFFER_MEAT);
        this.offerSmelting(SNIFFER_MEAT, RecipeCategory.FOOD, ModItems.COOKED_SNIFFER_MEAT, 0.25f, 200, "sniffer_meat");

        this.createShaped(RecipeCategory.FOOD, ModItems.UNFIRED_TEA_CUP, 1)
                .pattern("R R")
                .pattern(" R ")
                .input('R', Items.CLAY_BALL)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.FOOD, ModItems.TEAPOTBLOCK, 1)
                .pattern("R R")
                .pattern(" R ")
                .pattern("XCX")
                .input('R', Items.COPPER_INGOT)
                .input('X', ItemTags.LOGS)
                .input('C', Items.COAL)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.OAK_LOG), conditionsFromItem(Items.OAK_LOG))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .offerTo(exporter);


        this.createShaped(RecipeCategory.TOOLS, ModItems.GLOWING_SPYGLASS, 1)
                .pattern("LLL")
                .pattern("LXL")
                .pattern("LLL")
                .input('X', Items.SPYGLASS)
                .input('L', Items.GLOW_INK_SAC)
                .criterion(hasItem(Items.SPYGLASS), conditionsFromItem(Items.SPYGLASS))
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .offerTo(exporter);

        this.createShapeless(RecipeCategory.FOOD, ModItems.GOURMET_MEAL, 1)
                .input(ModItems.RARE_SPICES)
                .input(Items.BEETROOT)
                .input(Items.COOKED_CHICKEN)
                .input(Items.CARROT)
                .criterion(hasItem(ModItems.RARE_SPICES), conditionsFromItem(ModItems.RARE_SPICES))
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(Items.COOKED_CHICKEN), conditionsFromItem(Items.COOKED_CHICKEN))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "gourmet_meal_chicken")));

        this.createShapeless(RecipeCategory.FOOD, ModItems.GOURMET_MEAL, 1)
                .input(ModItems.RARE_SPICES)
                .input(Items.BEETROOT)
                .input(Items.COOKED_RABBIT)
                .input(Items.CARROT)
                .criterion(hasItem(ModItems.RARE_SPICES), conditionsFromItem(ModItems.RARE_SPICES))
                .criterion(hasItem(Items.BEETROOT), conditionsFromItem(Items.BEETROOT))
                .criterion(hasItem(Items.CARROT), conditionsFromItem(Items.CARROT))
                .criterion(hasItem(Items.COOKED_RABBIT), conditionsFromItem(Items.COOKED_RABBIT))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "gourmet_meal_rabbit")));


        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.WATER_TORCH, 4)
                .pattern("Y")
                .pattern("X")
                .input('Y', Items.GLOW_INK_SAC)
                .input('X', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);


        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICKS, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.TERRACOTTA)
                .input('R', Items.BRICK)
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .criterion(hasItem(Items.TERRACOTTA), conditionsFromItem(Items.TERRACOTTA))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PETRIFIED_DIRT, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.RESIN_CLUMP)
                .input('R', Items.DIRT)
                .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                .criterion(hasItem(Blocks.DIRT), conditionsFromItem(Items.DIRT))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BLACK_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.BLACK_WOOL)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_GRAY_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.GRAY_WOOL)
                .criterion(hasItem(Items.GRAY_WOOL), conditionsFromItem(Items.GRAY_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIGHT_GRAY_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.LIGHT_GRAY_WOOL)
                .criterion(hasItem(Items.LIGHT_GRAY_WOOL), conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_WHITE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.WHITE_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BROWN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.BROWN_WOOL)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_ORANGE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.ORANGE_WOOL)
                .criterion(hasItem(Items.ORANGE_WOOL), conditionsFromItem(Items.ORANGE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_RED_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.RED_WOOL)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_YELLOW_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.YELLOW_WOOL)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIME_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.LIME_WOOL)
                .criterion(hasItem(Items.LIME_WOOL), conditionsFromItem(Items.LIME_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_GREEN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.GREEN_WOOL)
                .criterion(hasItem(Items.GREEN_WOOL), conditionsFromItem(Items.GREEN_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_CYAN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.CYAN_WOOL)
                .criterion(hasItem(Items.CYAN_WOOL), conditionsFromItem(Items.CYAN_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIGHT_BLUE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.LIGHT_BLUE_WOOL)
                .criterion(hasItem(Items.LIGHT_BLUE_WOOL), conditionsFromItem(Items.LIGHT_BLUE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BLUE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.BLUE_WOOL)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_PURPLE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.PURPLE_WOOL)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_MAGENTA_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.MAGENTA_WOOL)
                .criterion(hasItem(Items.MAGENTA_WOOL), conditionsFromItem(Items.MAGENTA_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_PINK_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', ModItems.SILK)
                .input('R', Items.PINK_WOOL)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .criterion(hasItem(ModItems.SILK), conditionsFromItem(ModItems.SILK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BLACK_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_BLACK_WOOL)
                .criterion(hasItem(ModItems.FANCY_BLACK_WOOL), conditionsFromItem(ModItems.FANCY_BLACK_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BROWN_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_BROWN_WOOL)
                .criterion(hasItem(ModItems.FANCY_BROWN_WOOL), conditionsFromItem(ModItems.FANCY_BROWN_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_GRAY_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_GRAY_WOOL)
                .criterion(hasItem(ModItems.FANCY_GRAY_WOOL), conditionsFromItem(ModItems.FANCY_GRAY_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIGHT_GRAY_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_LIGHT_GRAY_WOOL)
                .criterion(hasItem(ModItems.FANCY_LIGHT_GRAY_WOOL), conditionsFromItem(ModItems.FANCY_LIGHT_GRAY_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_WHITE_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_WHITE_WOOL)
                .criterion(hasItem(ModItems.FANCY_WHITE_WOOL), conditionsFromItem(ModItems.FANCY_WHITE_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BLUE_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_BLUE_WOOL)
                .criterion(hasItem(ModItems.FANCY_BLUE_WOOL), conditionsFromItem(ModItems.FANCY_BLUE_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIGHT_BLUE_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_LIGHT_BLUE_WOOL)
                .criterion(hasItem(ModItems.FANCY_LIGHT_BLUE_WOOL), conditionsFromItem(ModItems.FANCY_LIGHT_BLUE_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIME_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_LIME_WOOL)
                .criterion(hasItem(ModItems.FANCY_LIME_WOOL), conditionsFromItem(ModItems.FANCY_LIME_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_GREEN_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_GREEN_WOOL)
                .criterion(hasItem(ModItems.FANCY_GREEN_WOOL), conditionsFromItem(ModItems.FANCY_GREEN_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_YELLOW_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_YELLOW_WOOL)
                .criterion(hasItem(ModItems.FANCY_YELLOW_WOOL), conditionsFromItem(ModItems.FANCY_YELLOW_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_RED_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_RED_WOOL)
                .criterion(hasItem(ModItems.FANCY_RED_WOOL), conditionsFromItem(ModItems.FANCY_RED_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_ORANGE_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_ORANGE_WOOL)
                .criterion(hasItem(ModItems.FANCY_ORANGE_WOOL), conditionsFromItem(ModItems.FANCY_ORANGE_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_PINK_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_PINK_WOOL)
                .criterion(hasItem(ModItems.FANCY_PINK_WOOL), conditionsFromItem(ModItems.FANCY_PINK_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_CYAN_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_CYAN_WOOL)
                .criterion(hasItem(ModItems.FANCY_CYAN_WOOL), conditionsFromItem(ModItems.FANCY_CYAN_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_MAGENTA_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_MAGENTA_WOOL)
                .criterion(hasItem(ModItems.FANCY_MAGENTA_WOOL), conditionsFromItem(ModItems.FANCY_MAGENTA_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_PURPLE_CARPET, 2)
                .pattern("RR")
                .input('R', ModItems.FANCY_PURPLE_WOOL)
                .criterion(hasItem(ModItems.FANCY_PURPLE_WOOL), conditionsFromItem(ModItems.FANCY_PURPLE_WOOL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GILDED_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.GOLD_NUGGET)
                .input('R', Items.SANDSTONE)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(Items.SANDSTONE), conditionsFromItem(Items.SANDSTONE))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GILDED_CHISELED_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.GOLD_NUGGET)
                .input('R', Items.CHISELED_SANDSTONE)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(Items.CHISELED_SANDSTONE), conditionsFromItem(Items.CHISELED_SANDSTONE))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GILDED_CUT_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .input('S', Items.GOLD_NUGGET)
                .input('R', Items.CUT_SANDSTONE)
                .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(Items.CUT_SANDSTONE), conditionsFromItem(Items.CUT_SANDSTONE))
                .offerTo(exporter);

        //Desert Oak

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .input('X', ModItems.DESERT_OAK_PLANKS)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_SLAB, 6)
                .pattern("RRR")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.TRANSPORTATION, ModItems.DESERT_OAK_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.DESERT_OAK_LOG)
                .criterion(hasItem(ModItems.DESERT_OAK_LOG), conditionsFromItem(ModItems.DESERT_OAK_LOG))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STRIPPED_DESERT_OAK_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.STRIPPED_DESERT_OAK_LOG)
                .criterion(hasItem(ModItems.STRIPPED_DESERT_OAK_LOG), conditionsFromItem(ModItems.STRIPPED_DESERT_OAK_LOG))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.REDSTONE, ModItems.DESERT_OAK_PRESSURE_PLATE, 1)
                .pattern("RR")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.SHARP_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        //custom ones
        this.createShaped(RecipeCategory.COMBAT, ModItems.SHARP_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('C', ModItems.OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('C', ModItems.OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.SHARP_WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.SHARP_WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("C")
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "sharp_wedge_obsidian_sword_2")));

        this.createShaped(RecipeCategory.COMBAT, ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.OBSIDIAN_SHARD)
                .input('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "regular_wedge_obsidian_sword_2")));

        this.createShaped(RecipeCategory.COMBAT, ModItems.SHARP_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .input('R', ModItems.OBSIDIAN_SHARD)
                .input('C', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "regular_sharp_obsidian_sword_2")));

        this.createShaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.OBSIDIAN_SHARD), conditionsFromItem(ModItems.OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.WEDGE_OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.WEDGE_OBSIDIAN_SHARD), conditionsFromItem(ModItems.WEDGE_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.SHARP_OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .input('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.SHARP_OBSIDIAN_SHARD), conditionsFromItem(ModItems.SHARP_OBSIDIAN_SHARD))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_SLAB, 6)
                .pattern("RRR")
                .input('R', ModItems.TERRACOTTA_BRICKS)
                .criterion(hasItem(ModItems.TERRACOTTA_BRICKS), conditionsFromItem(ModItems.TERRACOTTA_BRICKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModItems.TERRACOTTA_BRICKS)
                .criterion(hasItem(ModItems.TERRACOTTA_BRICKS), conditionsFromItem(ModItems.TERRACOTTA_BRICKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_WALL, 6)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.TERRACOTTA_BRICKS)
                .criterion(hasItem(ModItems.TERRACOTTA_BRICKS), conditionsFromItem(ModItems.TERRACOTTA_BRICKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GUANO_BRICKS, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.PACKED_GUANO)
                .criterion(hasItem(ModItems.PACKED_GUANO), conditionsFromItem(ModItems.PACKED_GUANO))
                .offerTo(exporter);


        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GUANO_BRICK_SLAB, 6)
                .pattern("RRR")
                .input('R', ModItems.GUANO_BRICKS)
                .criterion(hasItem(ModItems.GUANO_BRICKS), conditionsFromItem(ModItems.GUANO_BRICKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GUANO_BRICK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModItems.GUANO_BRICKS)
                .criterion(hasItem(ModItems.GUANO_BRICKS), conditionsFromItem(ModItems.GUANO_BRICKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GUANO_BRICK_WALL, 6)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.GUANO_BRICKS)
                .criterion(hasItem(ModItems.GUANO_BRICKS), conditionsFromItem(ModItems.GUANO_BRICKS))
                .offerTo(exporter);





        this.createShaped(RecipeCategory.FOOD, ModItems.SPICE_BARREL, 1)
                .pattern("RRR")
                .pattern("RXR")
                .pattern("RRR")
                .input('R', ModItems.RARE_SPICES)
                .input('X', Items.BARREL)
                .criterion(hasItem(ModItems.RARE_SPICES), conditionsFromItem(ModItems.RARE_SPICES))
                .criterion(hasItem(Items.BARREL), conditionsFromItem(Items.BARREL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.TOOLS, ModItems.BATTERED_AXE, 1)
                .pattern("RYR")
                .pattern(" X ")
                .input('Y', ModItems.BATTERED_AXE_REMNANT)
                .input('X', Items.STICK)
                .input('R', Items.COPPER_INGOT)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(ModItems.BATTERED_AXE_REMNANT), conditionsFromItem(ModItems.BATTERED_AXE_REMNANT))
                .offerTo(exporter);


        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_HANGING_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.STRIPPED_DESERT_OAK_LOG)
                .input('X', Blocks.CHAIN)
                .criterion(hasItem(ModItems.STRIPPED_DESERT_OAK_LOG), conditionsFromItem(ModItems.STRIPPED_DESERT_OAK_LOG))
                .criterion(hasItem(Blocks.CHAIN), conditionsFromItem(Blocks.CHAIN))
                .offerTo(exporter);

        this.offerSmithingTemplateCopyingRecipe(ModItems.PETRIFIED_ARMOR_TRIM_SMITHING_TEMPLATE, Ingredient.ofItems(ModItems.PETRIFIED_DIRT));

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_BUTTON, 1)
                .pattern("R")
                .input('R', ModItems.DESERT_OAK_PLANKS)
                .criterion(hasItem(ModItems.DESERT_OAK_PLANKS), conditionsFromItem(ModItems.DESERT_OAK_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.UNDERGROWTH, 3)
                .pattern("RR")
                .criterion(hasItem(Items.SHEARS), conditionsFromItem(Items.SHEARS))
                .input('R', ItemTags.LEAVES)
                .offerTo(exporter);


        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_PLANKS, 4)
                .input(ModItems.DESERT_OAK_LOG)
                .criterion(hasItem(ModItems.DESERT_OAK_LOG), conditionsFromItem(ModItems.DESERT_OAK_LOG))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_desert0")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_PLANKS, 4)
                .input(ModItems.STRIPPED_DESERT_OAK_LOG)
                .criterion(hasItem(ModItems.STRIPPED_DESERT_OAK_LOG), conditionsFromItem(ModItems.STRIPPED_DESERT_OAK_LOG))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_desert1")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_PLANKS, 4)
                .input(ModItems.STRIPPED_DESERT_OAK_WOOD)
                .criterion(hasItem(ModItems.STRIPPED_DESERT_OAK_WOOD), conditionsFromItem(ModItems.STRIPPED_DESERT_OAK_WOOD))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_desert2")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_PLANKS, 4)
                .input(ModItems.DESERT_OAK_WOOD)
                .criterion(hasItem(ModItems.DESERT_OAK_WOOD), conditionsFromItem(ModItems.DESERT_OAK_WOOD))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_desert3")));

        this.createShapeless(RecipeCategory.MISC, ModItems.SILK, 1)
                .input(Items.STRING)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter);



        this.createShapeless(RecipeCategory.MISC, Items.MAGENTA_DYE, 2)
                .input(ModItems.CALLALILY_LILAC)
                .criterion(hasItem(ModItems.CALLALILY_LILAC), conditionsFromItem(ModItems.CALLALILY_LILAC))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "magenta_dye_lily")));

        this.createShapeless(RecipeCategory.MISC, Items.PINK_DYE, 2)
                .input(ModItems.CALLALILY_PINK)
                .criterion(hasItem(ModItems.CALLALILY_PINK), conditionsFromItem(ModItems.CALLALILY_PINK))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "pink_dye_lily")));


        this.createShapeless(RecipeCategory.MISC, Items.WHITE_DYE, 2)
                .input(ModItems.CALLALILY_WHITE)
                .criterion(hasItem(ModItems.CALLALILY_WHITE), conditionsFromItem(ModItems.CALLALILY_WHITE))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "white_dye_lily")));

        this.createShapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .input(ModItems.COLUMBINE)
                .criterion(hasItem(ModItems.COLUMBINE), conditionsFromItem(ModItems.COLUMBINE))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "purple_dye_columbine")));


        this.createShapeless(RecipeCategory.MISC, Items.YELLOW_DYE, 2)
                .input(ModItems.CALLALILY_YELLOW)
                .criterion(hasItem(ModItems.CALLALILY_YELLOW), conditionsFromItem(ModItems.CALLALILY_YELLOW))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "yellow_dye_lily")));

        this.createShapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 2)
                .input(ModItems.CALLALILY_PURPLE)
                .criterion(hasItem(ModItems.CALLALILY_PURPLE), conditionsFromItem(ModItems.CALLALILY_PURPLE))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "purple_dye_lily")));



        //rotten wood
        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_BUTTON, 1)
                .pattern("R")
                .input('R', ModItems.ROTTEN_PLANKS)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PRESSURE_PLATE, 1)
                .pattern("RR")
                .input('R', ModItems.ROTTEN_PLANKS)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.ROTTEN_PLANKS)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.ROTTEN_PLANKS)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .input('R', ModItems.ROTTEN_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .input('X', ModItems.ROTTEN_PLANKS)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);


        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .input('R', ModItems.ROTTEN_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_HANGING_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.STRIPPED_ROTTEN_LOG)
                .input('X', Blocks.CHAIN)
                .criterion(hasItem(ModItems.STRIPPED_ROTTEN_LOG), conditionsFromItem(ModItems.STRIPPED_ROTTEN_LOG))
                .criterion(hasItem(Blocks.CHAIN), conditionsFromItem(Blocks.CHAIN))
                .offerTo(exporter);


        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_SLAB, 6)
                .pattern("RRR")
                .input('R', ModItems.ROTTEN_PLANKS)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModItems.ROTTEN_PLANKS)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.TRANSPORTATION, ModItems.ROTTEN_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .input('R', ModItems.ROTTEN_PLANKS)
                .criterion(hasItem(ModItems.ROTTEN_PLANKS), conditionsFromItem(ModItems.ROTTEN_PLANKS))
                                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.ROTTEN_LOG)
                .criterion(hasItem(ModItems.ROTTEN_LOG), conditionsFromItem(ModItems.ROTTEN_LOG))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STRIPPED_ROTTEN_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.STRIPPED_ROTTEN_LOG)
                .criterion(hasItem(ModItems.STRIPPED_ROTTEN_LOG), conditionsFromItem(ModItems.STRIPPED_ROTTEN_LOG))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.DECORATIONS, ModItems.ROT_BLOCK, 4)
                .pattern("XR")
                .pattern("RX")
                .input('R', Blocks.DIRT)
                .input('X', Items.BONE_MEAL)
                .criterion(hasItem(Blocks.DIRT), conditionsFromItem(Blocks.DIRT))
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.DECORATIONS, ModItems.GUANO_PILE, 2)
                .pattern("RR")
                .input('R', ModItems.GUANO)
                .criterion(hasItem(ModItems.GUANO), conditionsFromItem(ModItems.GUANO))
                .offerTo(exporter);
        this.createShaped(RecipeCategory.DECORATIONS, ModItems.GUANO_BLOCK, 1)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.GUANO)
                .criterion(hasItem(ModItems.GUANO), conditionsFromItem(ModItems.GUANO))
                .offerTo(exporter);

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.BONE_MEAL, 3)
                .input(ModItems.GUANO)
                .criterion(hasItem(ModItems.GUANO), conditionsFromItem(ModItems.GUANO))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "bonemeal_from_guano")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PLANKS, 4)
                .input(ModItems.MAHOGANY_LOG)
                .criterion(hasItem(ModItems.MAHOGANY_LOG), conditionsFromItem(ModItems.MAHOGANY_LOG))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_mahogany0")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PLANKS, 4)
                .input(ModItems.STRIPPED_MAHOGANY_LOG)
                .criterion(hasItem(ModItems.STRIPPED_MAHOGANY_LOG), conditionsFromItem(ModItems.STRIPPED_MAHOGANY_LOG))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_mahogany1")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PLANKS, 4)
                .input(ModItems.STRIPPED_MAHOGANY_WOOD)
                .criterion(hasItem(ModItems.STRIPPED_MAHOGANY_WOOD), conditionsFromItem(ModItems.STRIPPED_MAHOGANY_WOOD))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_mahogany2")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PLANKS, 4)
                .input(ModItems.MAHOGANY_WOOD)
                .criterion(hasItem(ModItems.MAHOGANY_WOOD), conditionsFromItem(ModItems.MAHOGANY_WOOD))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_mahogany3")));




        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PLANKS, 4)
                .input(ModItems.ROTTEN_LOG)
                .criterion(hasItem(ModItems.ROTTEN_LOG), conditionsFromItem(ModItems.ROTTEN_LOG))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_rotten0")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PLANKS, 4)
                .input(ModItems.STRIPPED_ROTTEN_LOG)
                .criterion(hasItem(ModItems.STRIPPED_ROTTEN_LOG), conditionsFromItem(ModItems.STRIPPED_ROTTEN_LOG))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_rotten1")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PLANKS, 4)
                .input(ModItems.STRIPPED_ROTTEN_WOOD)
                .criterion(hasItem(ModItems.STRIPPED_ROTTEN_WOOD), conditionsFromItem(ModItems.STRIPPED_ROTTEN_WOOD))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_rotten2")));

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PLANKS, 4)
                .input(ModItems.ROTTEN_WOOD)
                .criterion(hasItem(ModItems.ROTTEN_WOOD), conditionsFromItem(ModItems.ROTTEN_WOOD))
                .offerTo(exporter, String.valueOf(Identifier.of(JaizMod.MOD_ID, "planks_rotten3")));


        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .input('X', ModItems.MAHOGANY_PLANKS)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_SLAB, 6)
                .pattern("RRR")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.TRANSPORTATION, ModItems.MAHOGANY_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.MAHOGANY_LOG)
                .criterion(hasItem(ModItems.MAHOGANY_LOG), conditionsFromItem(ModItems.MAHOGANY_LOG))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STRIPPED_MAHOGANY_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.STRIPPED_MAHOGANY_LOG)
                .criterion(hasItem(ModItems.STRIPPED_MAHOGANY_LOG), conditionsFromItem(ModItems.STRIPPED_MAHOGANY_LOG))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_HANGING_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.STRIPPED_MAHOGANY_LOG)
                .input('X', Blocks.CHAIN)
                .criterion(hasItem(ModItems.STRIPPED_MAHOGANY_LOG), conditionsFromItem(ModItems.STRIPPED_MAHOGANY_LOG))
                .criterion(hasItem(Blocks.CHAIN), conditionsFromItem(Blocks.CHAIN))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_BUTTON, 1)
                .pattern("R")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PRESSURE_PLATE, 1)
                .pattern("RR")
                .input('R', ModItems.MAHOGANY_PLANKS)
                .criterion(hasItem(ModItems.MAHOGANY_PLANKS), conditionsFromItem(ModItems.MAHOGANY_PLANKS))
                .offerTo(exporter);

        this.createShapeless(RecipeCategory.COMBAT, ModItems.GLOW_BALL, 1)
                .input(Items.SNOWBALL)
                .input(Items.GLOW_INK_SAC)
                .criterion(hasItem(Items.SNOWBALL), conditionsFromItem(Items.SNOWBALL))
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .offerTo(this.exporter);

        this.createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.BIOLUMINESCENT_BOTTLE.asItem(), 1)
                .input(Items.GLASS_BOTTLE)
                .input(Items.GLOW_INK_SAC)
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .offerTo(this.exporter);

        this.createShapeless(RecipeCategory.TRANSPORTATION, ModItems.DESERT_OAK_CHEST_BOAT, 1)
                .input(ModItems.DESERT_OAK_BOAT)
                .input(Items.CHEST)
                .criterion(hasItem(ModItems.DESERT_OAK_BOAT), conditionsFromItem(ModItems.DESERT_OAK_BOAT))
                .criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST))
                .offerTo(exporter);

        this.createShapeless(RecipeCategory.TRANSPORTATION, ModItems.MAHOGANY_CHEST_BOAT, 1)
                .input(ModItems.MAHOGANY_BOAT)
                .input(Items.CHEST)
                .criterion(hasItem(ModItems.MAHOGANY_BOAT), conditionsFromItem(ModItems.MAHOGANY_BOAT))
                .criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST))
                .offerTo(exporter);

        this.createShapeless(RecipeCategory.TRANSPORTATION, ModItems.ROTTEN_CHEST_BOAT, 1)
                .input(ModItems.ROTTEN_BOAT)
                .input(Items.CHEST)
                .criterion(hasItem(ModItems.ROTTEN_BOAT), conditionsFromItem(ModItems.ROTTEN_BOAT))
                .criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST))
                .offerTo(exporter);


        this.createShapeless(RecipeCategory.TRANSPORTATION, ModItems.PACKED_GUANO, 4)
                .input(ModItems.GUANO_BLOCK)
                .input(Items.WHEAT)
                .criterion(hasItem(ModItems.GUANO_BLOCK), conditionsFromItem(ModItems.GUANO_BLOCK))
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter);

        this.createShaped(RecipeCategory.COMBAT, ModItems.MACUAHUITL, 1)
                .pattern("RCR")
                .pattern("RCR")
                .pattern(" X ")
                .input('R', ModTags.Items.OBSIDIAN_SHARDS)
                .input('C', ItemTags.PLANKS)
                .input('X', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

    }

    public static class Provider extends RecipeGenerator.RecipeProvider {
        public Provider(DataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(dataOutput, completableFuture);
        }

        @Override
        protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
            return new ModRecipeProvider(registries, exporter);
        }

        @Override
        public String getName() {
            return "JaizMod Recipes";
        }
    }

}