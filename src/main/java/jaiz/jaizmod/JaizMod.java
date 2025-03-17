package jaiz.jaizmod;

import com.mojang.serialization.MapCodec;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.block.blockentities.CustomBlockEntities;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.bandit.BanditEntity;
import jaiz.jaizmod.entity.boats.ModBoats;
import jaiz.jaizmod.entity.butterfly.ButterflyEntity;
import jaiz.jaizmod.entity.caterpillar.CaterpillarEntity;
import jaiz.jaizmod.entity.dragonfly.DragonflyEntity;
import jaiz.jaizmod.entity.firefly.FireFlySwarmEntity;
import jaiz.jaizmod.entity.fruit_bat.FruitBatEntity;
import jaiz.jaizmod.entity.mason_mouth.MasonmouthEntity;
import jaiz.jaizmod.entity.snail.SnailEntity;
import jaiz.jaizmod.item.ModItemGroups;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.statuseffects.ModStatusEffects;
import jaiz.jaizmod.util.ModCustomTrades;
import jaiz.jaizmod.util.ModGameRules;
import jaiz.jaizmod.util.ModLootTables;
import jaiz.jaizmod.villager.ModVillagers;
import jaiz.jaizmod.worldgen.ModWorldGeneration;
import jaiz.jaizmod.worldgen.structure.StructurePlacerTypes;
import jaiz.jaizmod.worldgen.tree.ModTreeDecorator;
import jaiz.jaizmod.worldgen.tree.TrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JaizMod implements ModInitializer {
	public static final String MOD_ID = "jaizmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final SimpleParticleType STINK_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType DRY_LEAF_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType DEAD_LEAF_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType SLIME_DRIP_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType STINK_ITEM_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType AMETHYST_SPARKLE_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType FIREFLY_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType SPROUT_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType BLOOMING_IVY_PARTICLE = FabricParticleTypes.simple();
	public static final SimpleParticleType SNOW_PARTICLE = FabricParticleTypes.simple();


	@Override
	public void onInitialize() {
		TrunkPlacerTypes.register();
		ModStatusEffects.registerModEffects();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModWorldGeneration.generateModWorldGen();
		ModTreeDecorator.register();
		StructurePlacerTypes.register();
		ModVillagers.registerVillagers();
		ModSounds.registerSounds();
		ModCustomTrades.registerCustomTrades();
		CustomBlockEntities.registerBlockEntities();
		ModGameRules.registerGamerules();
		ModBoats.registerBoats();
		ModLootTables.registerLootTables();
		ModBlocks.registerModBlocks();

		BlockEntityType.BRUSHABLE_BLOCK.addSupportedBlock(ModBlocks.FOSSIL_SOIL);

		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_LOG, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.STRIPPED_MAHOGANY_LOG, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.STRIPPED_MAHOGANY_WOOD, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_WOOD, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_SAPLING, 40, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_PLANKS, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_SLAB, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_STAIRS, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_FENCE, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_FENCE_GATE, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_TRAPDOOR, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_DOOR, 10, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.MAHOGANY_LEAVES, 20, 40);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_WHITE_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_LIGHT_GRAY_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_GRAY_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_BLACK_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_BROWN_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_RED_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_ORANGE_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_YELLOW_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_LIME_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_GREEN_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_LIGHT_BLUE_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_CYAN_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_BLUE_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_PURPLE_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_PINK_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_MAGENTA_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_WHITE_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_LIGHT_GRAY_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_GRAY_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_BLACK_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_BROWN_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_RED_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_ORANGE_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_YELLOW_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_LIME_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_GREEN_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_LIGHT_BLUE_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_CYAN_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_BLUE_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_PURPLE_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_PINK_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.SNIFFER_WOOL, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.SNIFFER_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.FANCY_MAGENTA_CARPET, 30, 60);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_LOG, 3, 5);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.STRIPPED_DESERT_OAK_LOG, 3, 5);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.STRIPPED_DESERT_OAK_WOOD, 3, 5);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_WOOD, 3, 5);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_PLANKS, 3, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.SPICE_BARREL, 1, 40);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_SLAB, 3, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_STAIRS, 3, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_FENCE, 3, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_FENCE_GATE, 3, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_TRAPDOOR, 3, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_DOOR, 3, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DESERT_OAK_LEAVES, 20, 40);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_LOG, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.STRIPPED_ROTTEN_LOG, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.STRIPPED_ROTTEN_WOOD, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_WOOD, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_PLANKS, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_SLAB, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_STAIRS, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_FENCE, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_FENCE_GATE, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_TRAPDOOR, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.ROTTEN_DOOR, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.BLOOMING_IVY, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DEAD_LEAVES, 6, 10);
		FlammableBlockRegistry.getDefaultInstance()
				.add(ModBlocks.DRIED_LEAVES, 6, 10);

		StrippableBlockRegistry.register(ModBlocks.DESERT_OAK_LOG, ModBlocks.STRIPPED_DESERT_OAK_LOG);
		StrippableBlockRegistry.register(ModBlocks.DESERT_OAK_WOOD, ModBlocks.STRIPPED_DESERT_OAK_WOOD);
		FabricDefaultAttributeRegistry.register(ModEntities.FRUIT_BAT, FruitBatEntity.createBatAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MASON_MOUTH, MasonmouthEntity.createMasonMouthAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BANDIT, BanditEntity.createBanditAttributes());

		StrippableBlockRegistry.register(ModBlocks.MAHOGANY_LOG, ModBlocks.STRIPPED_MAHOGANY_LOG);
		StrippableBlockRegistry.register(ModBlocks.MAHOGANY_WOOD, ModBlocks.STRIPPED_MAHOGANY_WOOD);

		// Register our custom particle type in the mod initializer.
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "stink_particle"), STINK_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "slime_drip_particle"), SLIME_DRIP_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "stink_item_particle"), STINK_ITEM_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "amethyst_sparkle_particle"), AMETHYST_SPARKLE_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "sprout_particle"), SPROUT_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "dry_leaf_particle"), DRY_LEAF_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "dead_leaf_particle"), DEAD_LEAF_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "firefly_particle"), FIREFLY_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "blooming_ivy_particle"), BLOOMING_IVY_PARTICLE);
		Registry.register(Registries.PARTICLE_TYPE, Identifier.of(JaizMod.MOD_ID, "snow_particle"), SNOW_PARTICLE);

		FabricDefaultAttributeRegistry.register(ModEntities.CATERPILLAR, CaterpillarEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SNAIL, SnailEntity.createSnailAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BUTTERFLY, ButterflyEntity.createButterflyAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.DRAGONFLY, DragonflyEntity.createDragonflyAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FIRE_FLY_SWARM, FireFlySwarmEntity.createFireflyAttributes());

		StrippableBlockRegistry.register(ModBlocks.ROTTEN_LOG, ModBlocks.STRIPPED_ROTTEN_LOG);
		StrippableBlockRegistry.register(ModBlocks.ROTTEN_WOOD, ModBlocks.STRIPPED_ROTTEN_WOOD);

	}
}