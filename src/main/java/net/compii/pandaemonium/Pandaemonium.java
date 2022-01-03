package net.compii.pandaemonium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pandaemonium implements ModInitializer {
	// Invoke the logger (sure hope log4j is patched here lol)
	public static final Logger LOGGER = LogManager.getLogger("Pandaemonium");

	// The testing block
	public static final Block THE_TESTING_BLOCK = new Block(FabricBlockSettings.of(Material.WOOD).hardness(0.7f).resistance(2000.0f).requiresTool());

	// Sound events
	public static final Identifier TEST_SOUND = new Identifier("pandaemonium:test_sound");
	public static SoundEvent TEST_SOUND_EVENT = new SoundEvent(TEST_SOUND);

	@Override
	public void onInitialize() {
		// Main stuff

		// Register the testing block
		Registry.register(Registry.BLOCK, new Identifier("pandaemonium", "the_testing_block"), THE_TESTING_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("pandaemonium", "the_testing_block"), new BlockItem(THE_TESTING_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));

		// Register the test sound
		Registry.register(Registry.SOUND_EVENT, Pandaemonium.TEST_SOUND, TEST_SOUND_EVENT);

		LOGGER.info("This is a test.");
	}
}
