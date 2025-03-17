package jaiz.jaizmod.worldgen;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.fruit_bat.FruitBatEntity;
import jaiz.jaizmod.worldgen.biome.ModBiomes;
import jaiz.jaizmod.worldgen.features.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModFeaturePlacer {
    public static void addPlacedFeaturesSpawn() {

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DESERT, BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DESERT_OAK_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SMALL_MAHOGANY_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.POO_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.POO_PLACED_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.MOSS_PATCH_FRUIT_BAT_CAVES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.MOSS_PATCH_FRUIT_BAT_CAVES_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.LEAVES_PATCH_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.LEAVES_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.LEAVES_CEILING_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.MOSS_CARPET_FRUIT_BAT_CAVES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.MOSS_CARPET_DEEPSLATE_FRUIT_BAT_CAVES);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PODZOL_PATCH);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE, ModBiomes.MAHOGANY_FOREST, BiomeKeys.BAMBOO_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MUD_PATCH);


        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.TAIGA,
                        BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.SWAMP, BiomeKeys.DARK_FOREST, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ROT_RED_MUSHROOM_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST,
                        BiomeKeys.FLOWER_FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.SWAMP, BiomeKeys.DARK_FOREST, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ROT_BROWN_MUSHROOM_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST,
                        BiomeKeys.FLOWER_FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.SWAMP, BiomeKeys.DARK_FOREST, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ROT_ROOTS_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST,
                        BiomeKeys.FLOWER_FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.SWAMP, BiomeKeys.DARK_FOREST, BiomeKeys.WOODED_BADLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ROTTEN_LOG_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BIRCH_FOREST_ROCK);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.RIVER, BiomeKeys.BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CALLALILY_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DISK_ROOTED_DIRT);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.WHITE_FLORAL_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.PINK_FLORAL_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.YELLOW_FLORAL_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_BIRCH_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_OAK_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BIRCH_LOG_MOSS);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BIRCH_FALLEN_LOG);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DISK_ROT_DIRT);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MOSS_BLOCK_PATCH);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MOSS_PATCH_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.DARK_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FLOWER_COLUMBINE);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST,
                        BiomeKeys.TAIGA, BiomeKeys.DARK_FOREST, BiomeKeys.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.UNDERGROWTH_PATCH_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST,
                        BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_FERNS_JAIZMOD);


        //entities
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.MAHOGANY_FOREST), SpawnGroup.AMBIENT,
                ModEntities.FRUIT_BAT, 15, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES), SpawnGroup.AMBIENT,
                ModEntities.FRUIT_BAT, 60, 1, 5);

        SpawnRestriction.register(ModEntities.FRUIT_BAT, SpawnRestriction.getLocation(ModEntities.FRUIT_BAT), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, FruitBatEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SUNFLOWER_PLAINS), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.TAIGA), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MEADOW), SpawnGroup.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), SpawnGroup.CREATURE,
                ModEntities.DRAGONFLY, 3, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP), SpawnGroup.CREATURE,
                ModEntities.DRAGONFLY, 3, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MANGROVE_SWAMP), SpawnGroup.CREATURE,
                ModEntities.DRAGONFLY, 3, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH), SpawnGroup.CREATURE,
                ModEntities.DRAGONFLY, 3, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 5, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MANGROVE_SWAMP), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 5, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.CHERRY_GROVE), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.TAIGA), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), SpawnGroup.CREATURE,
                ModEntities.CATERPILLAR, 1, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.CREATURE,
                ModEntities.CATERPILLAR, 1, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP), SpawnGroup.CREATURE,
                ModEntities.SNAIL, 2, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MANGROVE_SWAMP), SpawnGroup.CREATURE,
                ModEntities.SNAIL, 2, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT), SpawnGroup.CREATURE,
                EntityType.CAMEL, 1, 1, 1);


        // Spawn Restrictors

        SpawnRestriction.register(ModEntities.BUTTERFLY, SpawnRestriction.getLocation(ModEntities.BUTTERFLY), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.CATERPILLAR, SpawnRestriction.getLocation(ModEntities.CATERPILLAR), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.FIRE_FLY_SWARM, SpawnRestriction.getLocation(ModEntities.FIRE_FLY_SWARM), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.DRAGONFLY, SpawnRestriction.getLocation(ModEntities.DRAGONFLY), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.SNAIL, SpawnRestriction.getLocation(ModEntities.SNAIL), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(EntityType.CAMEL, SpawnRestriction.getLocation(EntityType.CAMEL), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canMobSpawn);
    }
}
