/*

    Pandaemonium
    TechschurelisseToolMaterial.java
    The effective. Power tool

 */

package net.compii.pandaemonium.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TechschurelisseToolMaterial implements ToolMaterial {

    public static final TechschurelisseToolMaterial TECHSCHURELISSE_TOOL_MATERIAL = new TechschurelisseToolMaterial();

    @Override
    public int getDurability() {
        return 1922;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 45;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.TECHSCHURELISSE_INGOT);
    }



}

