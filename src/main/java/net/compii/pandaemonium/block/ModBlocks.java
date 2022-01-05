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
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.compii.pandaemonium.Pandaemonium;

public class ModBlocks {

    // The Testing Block
    public static final Block THE_TESTING_BLOCK = registerNewBlock("the_testing_block", Rarity.EPIC, new TestingBlock(FabricBlockSettings.of(Material.WOOD)
            .hardness(5.5f).
            resistance(2000.0f).
            requiresTool().
            sounds(BlockSoundGroup.AMETHYST_BLOCK)),
            Pandaemonium.ITEM_GROUP_GENERAL);

    // Dirt Slab
    public static final Block DIRT_SLAB = registerNewBlock("dirt_slab", Rarity.COMMON, new DirtSlab(FabricBlockSettings.of(Material.SOIL)
                    .hardness(1.0f).
                    resistance(1.0f).
                    sounds(BlockSoundGroup.GRAVEL)),
            Pandaemonium.ITEM_GROUP_GENERAL);

    // Dirt Stairs
    public static final Block DIRT_STAIRS = registerNewBlock("dirt_stairs", Rarity.COMMON, new DirtStairs(FabricBlockSettings.of(Material.SOIL)
                    .hardness(1.0f).
                    resistance(1.0f).
                    sounds(BlockSoundGroup.GRAVEL)),
            Pandaemonium.ITEM_GROUP_GENERAL);

    // Techschurelisse Ore
    public static final Block TECHSCHURELISSE_ORE = registerNewBlock("techschurelisse_ore", Rarity.COMMON, new TestingBlock(FabricBlockSettings.of(Material.STONE)
                    .hardness(4.5f).
                    resistance(16.0f).
                    requiresTool().
                    sounds(BlockSoundGroup.STONE)),
            Pandaemonium.ITEM_GROUP_GENERAL);

    // Techschurelisse Block
    public static final Block TECHSCHURELISSE_BLOCK = registerNewBlock("techschurelisse_block", Rarity.COMMON, new TestingBlock(FabricBlockSettings.of(Material.METAL)
                    .hardness(6.5f).
                    resistance(18.0f).
                    requiresTool().
                    sounds(BlockSoundGroup.METAL)),
            Pandaemonium.ITEM_GROUP_GENERAL);

    // Raw Techschurelisse Block
    public static final Block RAW_TECHSCHURELISSE_BLOCK = registerNewBlock("raw_techschurelisse_block", Rarity.COMMON, new TestingBlock(FabricBlockSettings.of(Material.METAL)
                    .hardness(5.7f).
                    resistance(17.0f).
                    requiresTool().
                    sounds(BlockSoundGroup.STONE)),
            Pandaemonium.ITEM_GROUP_GENERAL);

    // Test Chest
    public static final Block TEST_CHEST = registerNewBlock("test_chest", Rarity.COMMON, new TestChest(FabricBlockSettings.of(Material.METAL)
                    .hardness(1.0f).
                    resistance(20.0f).
                    requiresTool().
                    sounds(BlockSoundGroup.METAL)),
            Pandaemonium.ITEM_GROUP_GENERAL);

    // Etho Slab
    public static final Block ETHO_SLAB = registerNewBlock("etho_slab", Rarity.COMMON, new EthoSlab(FabricBlockSettings.of(Material.TNT)
                    .hardness(1.0f).
                    resistance(1.0f).
                    breakInstantly().
                    sounds(BlockSoundGroup.GRASS)),
            Pandaemonium.ITEM_GROUP_MISC);

    // Easy block registering
    private static <T extends Block> T registerNewBlock(String name, Rarity rarity, T block, ItemGroup itemGroup) {
        Registry.register(Registry.BLOCK, new Identifier(Pandaemonium.MODID, name), block);

        // Register to an item group if specified
        if (itemGroup != null) {
            Registry.register(Registry.ITEM,
                    new Identifier(Pandaemonium.MODID, name),
                    new BlockItem(block, new Item.Settings().group(itemGroup).rarity(rarity)));
        }
        // Register item to misc group if not specified
        else {
            Registry.register(Registry.ITEM,
                    new Identifier(Pandaemonium.MODID, name),
                    new BlockItem(block, new Item.Settings().group(Pandaemonium.ITEM_GROUP_MISC).rarity(rarity)));
        }

        return block;
    }

    public static void register() {}

}
