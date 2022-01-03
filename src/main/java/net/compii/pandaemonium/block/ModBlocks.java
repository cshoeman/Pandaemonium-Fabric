/*

    Pandaemonium
    ModBlocks.java
    Mod Blocks registry

    This class registers the blocks to the loader when invoked.

 */

package net.compii.pandaemonium.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.compii.pandaemonium.Pandaemonium;

public class ModBlocks {

    // public static final TestingBlock THE_TESTING_BLOCK = new TestingBlock(FabricBlockSettings.of(Material.WOOD).hardness(0.7f).resistance(2000.0f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block THE_TESTING_BLOCK = registerNewBlock("the_testing_block", new TestingBlock(FabricBlockSettings.of(Material.WOOD)
            .hardness(0.7f).
            resistance(2000.0f).
            requiresTool().
            sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            Pandaemonium.ITEM_GROUP_GENERAL);

    // Easy block registering
    private static <T extends Block> T registerNewBlock(String name, T block, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, new Identifier(Pandaemonium.MODID, name), block);
        // Register to an item group if specified
        if (itemGroup != null) {
            Registry.register(Registry.ITEM,
                    new Identifier(Pandaemonium.MODID, name),
                    new BlockItem(block, new Item.Settings().group(itemGroup)));
        }
        // Register item to misc group if not specified
        else {
            Registry.register(Registry.ITEM,
                    new Identifier(Pandaemonium.MODID, name),
                    new BlockItem(block, new Item.Settings().group(Pandaemonium.ITEM_GROUP_MISC)));
        }
        return block;
    }

    // Loads the class to register blocks when called (ex. in main class type "ModBlocks.register();"
    public static void register() {}

}
