package net.compii.pandaemonium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
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
	// Invoke the logger (sure hope log4j is patched here lol)
	public static final Logger LOGGER = LogManager.getLogger("Pandaemonium");

	// Establish Item Group for creative menu
	public static final ItemGroup ITEM_GROUP_GENERAL = FabricItemGroupBuilder.build(
			new Identifier("pandaemonium", "general"),
			() -> new ItemStack(Pandaemonium.THE_TESTING_BLOCK));
	public static final ItemGroup ITEM_GROUP_TOOLS = FabricItemGroupBuilder.create(
					new Identifier("pandaemonium", "tools"))
			.icon(() -> new ItemStack(Pandaemonium.EFFECTIVE_POWER_PICKAXE))
			.build();

	// The testing block
	public static final TestingBlock THE_TESTING_BLOCK = new TestingBlock(FabricBlockSettings.of(Material.WOOD).hardness(0.7f).resistance(2000.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
	// The Effective Power Pickaxe
	public static ToolItem EFFECTIVE_POWER_PICKAXE = new CustomPickaxes(EffectivePowerTool.EFFECTIVE_POWER_TOOL, 10, -1.2F, new Item.Settings().group(Pandaemonium.ITEM_GROUP_TOOLS));

	// Sound events
	public static final Identifier TEST_SOUND = new Identifier("pandaemonium:block.the_testing_block.break");
	public static SoundEvent TEST_SOUND_EVENT = new SoundEvent(TEST_SOUND);

	// Ore configured feature to generate the testing block for testing purposes
	private static ConfiguredFeature<?, ?> OVERWORLD_TESTING_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
					Pandaemonium.THE_TESTING_BLOCK.getDefaultState(),
					32)); // Setting vein size to 32 for testing
	public static PlacedFeature OVERWORLD_TESTING_ORE_PLACED_FEATURE = OVERWORLD_TESTING_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(10), // How many veins to place in each chunk
			SquarePlacementModifier.of(), // Horizontal spreading
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(127))); // Ore placement height

	@Override
	public void onInitialize() {
		// Main stuff
		LOGGER.info("Loading Pandaemonium v0.2.0");
		LOGGER.info("https://github.com/cshoeman/Pandaemonium-Fabric");

		// Register the testing block
		Registry.register(Registry.BLOCK, new Identifier("pandaemonium", "the_testing_block"), THE_TESTING_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("pandaemonium", "the_testing_block"), new BlockItem(THE_TESTING_BLOCK, new FabricItemSettings().group(Pandaemonium.ITEM_GROUP_GENERAL)));

		// Register the Effective Power Pickaxe
		Registry.register(Registry.ITEM, new Identifier("pandaemonium", "effective_power_pickaxe"), EFFECTIVE_POWER_PICKAXE);

		// Register the test sound
		Registry.register(Registry.SOUND_EVENT, Pandaemonium.TEST_SOUND, TEST_SOUND_EVENT);

		// Register the testing ore generation
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("pandaemonium", "overworld_testing_ore"), OVERWORLD_TESTING_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("pandaemonium", "overworld_testing_ore"),
				OVERWORLD_TESTING_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("pandaemonium", "overworld_testing_ore")));

		LOGGER.info("Loading complete! Hopefully no errors :D");
	}
}
