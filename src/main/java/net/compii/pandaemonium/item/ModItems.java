/*

    Pandaemonium
    ModItems.java
    Mod items registry

    This class registers the items to the loader when invoked.

 */

package net.compii.pandaemonium.item;

import net.compii.pandaemonium.EffectivePowerTool;
import net.compii.pandaemonium.Pandaemonium;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Effective Power Pickaxe
    public static ToolItem EFFECTIVE_POWER_PICKAXE = new CustomPickaxes(EffectivePowerTool.EFFECTIVE_POWER_TOOL,
            10,
            -1.2F,
            new Item.Settings()
                    .group(Pandaemonium.ITEM_GROUP_TOOLS)
    );
    // Raw Techschurelisse
    public static final Item RAW_TECHSCHURELISSE = new Item(new FabricItemSettings().group(Pandaemonium.ITEM_GROUP_MATS));
    // Techschurelisse Ingot
    public static final Item TECHSCHURELISSE_INGOT = new Item(new FabricItemSettings().group(Pandaemonium.ITEM_GROUP_MATS));

    private static void registerNewItem(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(Pandaemonium.MODID, name), item);
    }

    public static void register() {
        // Register Effective Power Pickaxe
        registerNewItem("effective_power_pickaxe", EFFECTIVE_POWER_PICKAXE);
        // Register Raw Techschurelisse
        registerNewItem("raw_techschurelisse", RAW_TECHSCHURELISSE);
        // Register Techschurelisse Ingot
        registerNewItem("techschurelisse_ingot", TECHSCHURELISSE_INGOT);
    }

}
