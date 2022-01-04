/*

    Pandaemonium

    by cshoeman
    Version 0.2.0
    https://github.com/cshoeman/Pandaemonium-Fabric

    Pandaemonium.java
    Main class/initialization

    This class initializes the mod and stuff. Basic main class fare.

 */

// TODO: Move initialization code to their respective classes

package net.compii.pandaemonium;

import net.compii.pandaemonium.block.ModBlocks;
import net.compii.pandaemonium.block.TestingBlock;
import net.compii.pandaemonium.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pandaemonium implements ModInitializer {

	// Universal Mod ID and name for easy changing if you want to steal and rebrand my mod :D
	public static final String MODID = "pandaemonium";
	public static final String MODNAME = "Pandaemonium";
	public static final String MODVER = "0.2.0";
	public static final String MODREPO = "https://github.com/cshoeman/Pandaemonium-Fabric";

	// Invoke the logger
	public static final Logger LOGGER = LogManager.getLogger(MODNAME);

	// Establish Item Group for creative menu
	public static final ItemGroup ITEM_GROUP_GENERAL = FabricItemGroupBuilder.build(
			new Identifier(MODID, "general"),
			() -> new ItemStack(ModBlocks.THE_TESTING_BLOCK));
	public static final ItemGroup ITEM_GROUP_TOOLS = FabricItemGroupBuilder.create(
					new Identifier(MODID, "tools"))
			.icon(() -> new ItemStack(ModItems.EFFECTIVE_POWER_PICKAXE))
			.build();
	public static final ItemGroup ITEM_GROUP_MISC = FabricItemGroupBuilder.create(
					new Identifier(MODID, "misc"))
			.icon(() -> new ItemStack(Blocks.BEDROCK))
			.build();
	public static final ItemGroup ITEM_GROUP_MATS = FabricItemGroupBuilder.create(
					new Identifier(MODID, "materials"))
			.icon(() -> new ItemStack(ModItems.TECHSCHURELISSE_INGOT))
			.build();

	// The testing block
    // public static final TestingBlock THE_TESTING_BLOCK = new TestingBlock(FabricBlockSettings.of(Material.WOOD).hardness(0.7f).resistance(2000.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
	// The Effective Power Pickaxe
    // public static ToolItem EFFECTIVE_POWER_PICKAXE = new CustomPickaxes(EffectivePowerTool.EFFECTIVE_POWER_TOOL, 10, -1.2F, new Item.Settings().group(Pandaemonium.ITEM_GROUP_TOOLS));

	// Sound events
	public static final Identifier TEST_SOUND = new Identifier(MODID, "block.the_testing_block.break");
	public static SoundEvent TEST_SOUND_EVENT = new SoundEvent(TEST_SOUND);

	// Ore configured feature to generate the testing block for testing purposes
	private static ConfiguredFeature<?, ?> OVERWORLD_TESTING_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					ModBlocks.TECHSCHURELISSE_ORE.getDefaultState(),
					9)); // Setting vein size to 32 for testing
	public static PlacedFeature OVERWORLD_TESTING_ORE_PLACED_FEATURE = OVERWORLD_TESTING_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(20), // How many veins to place in each chunk
			SquarePlacementModifier.of(), // Horizontal spreading
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(66))); // Ore placement height

	@Override
	public void onInitialize() {

		// Log that the mod is starting to initialize
		LOGGER.info(Messages.Initializing_Begin);
		LOGGER.info(Messages.Initializing_ModRepo);
		LOGGER.info(Messages.Initializing_IfErrors);

		// Invoke all classes and register everything
		ModBlocks.register();
		ModItems.register();

		// Register the test sound
		Registry.register(Registry.SOUND_EVENT, Pandaemonium.TEST_SOUND, TEST_SOUND_EVENT);

		// Register the testing ore generation
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier(MODID, "overworld_testing_ore"), OVERWORLD_TESTING_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("pandaemonium", "overworld_testing_ore"),
				OVERWORLD_TESTING_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier(MODID, "overworld_testing_ore")));

		// Log that initialization is complete
		LOGGER.info(Messages.Initializing_Complete);
	}
}
