/*

    Pandaemonium
    ModItems.java
    Mod items registry

    This class registers the items to the loader when invoked.

 */

package net.compii.pandaemonium.item;

import net.compii.pandaemonium.Pandaemonium;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Effective Power Pickaxe
    public static ToolItem EFFECTIVE_POWER_PICKAXE = new CustomPickaxes(EffectivePowerTool.EFFECTIVE_POWER_TOOL,
            20,
            -0.0F,
            new Item.Settings()
                    .group(Pandaemonium.ITEM_GROUP_TOOLS)
                    .rarity(Rarity.EPIC)
    );

    // Stickaxe
    public static ToolItem STICKAXE = new CustomPickaxes(StickaxeMaterial.STICKAXE_MATERIAL,
            1,
            -1.0F,
            new Item.Settings()
                    .group(Pandaemonium.ITEM_GROUP_MISC)
    );

    // TECHSCHURELISSE

    // Raw Techschurelisse
    public static final Item RAW_TECHSCHURELISSE = new Item(new FabricItemSettings().group(Pandaemonium.ITEM_GROUP_MATS));
    // Techschurelisse Ingot
    public static final Item TECHSCHURELISSE_INGOT = new Item(new FabricItemSettings().group(Pandaemonium.ITEM_GROUP_MATS));

    // Techschurelisse Pickaxe
    public static ToolItem TECHSCHURELISSE_PICKAXE = new CustomPickaxes(TechschurelisseToolMaterial.TECHSCHURELISSE_TOOL_MATERIAL,
            6,
            -1.6F,
            new Item.Settings()
                    .group(Pandaemonium.ITEM_GROUP_TOOLS)
    );
    // Techschurelisse Axe
    public static ToolItem TECHSCHURELISSE_AXE = new CustomAxes(TechschurelisseToolMaterial.TECHSCHURELISSE_TOOL_MATERIAL,
            10.5F,
            -3.0F,
            new Item.Settings()
                    .group(Pandaemonium.ITEM_GROUP_TOOLS)
    );
    // Techschurelisse Hoe
    public static ToolItem TECHSCHURELISSE_HOE = new CustomHoes(TechschurelisseToolMaterial.TECHSCHURELISSE_TOOL_MATERIAL,
            2,
            -0.5F,
            new Item.Settings()
                    .group(Pandaemonium.ITEM_GROUP_TOOLS)
    );
    // Techschurelisse Sword
    public static ToolItem TECHSCHURELISSE_SWORD = new CustomSwords(TechschurelisseToolMaterial.TECHSCHURELISSE_TOOL_MATERIAL,
            9,
            -1.4F,
            new Item.Settings()
                    .group(Pandaemonium.ITEM_GROUP_COMBAT));
    // Techschurelisse Shovel
    public static ToolItem TECHSCHURELISSE_SHOVEL = new CustomShovels(TechschurelisseToolMaterial.TECHSCHURELISSE_TOOL_MATERIAL,
            8,
            -2.0F,
            new Item.Settings()
                    .group(Pandaemonium.ITEM_GROUP_TOOLS));

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
        // Register Techschurelisse Pickaxe
        registerNewItem("techschurelisse_pickaxe", TECHSCHURELISSE_PICKAXE);
        // Register Techschurelisse Sword
        registerNewItem("techschurelisse_sword", TECHSCHURELISSE_SWORD);
        // Register Techschurelisse Axe
        registerNewItem("techschurelisse_axe", TECHSCHURELISSE_AXE);
        // Register Techschurelisse Hoe
        registerNewItem("techschurelisse_hoe", TECHSCHURELISSE_HOE);
        // Register Techschurelisse Shovel
        registerNewItem("techschurelisse_shovel", TECHSCHURELISSE_SHOVEL);
        // Register Stickaxe
        registerNewItem("stickaxe", STICKAXE);
    }

}
