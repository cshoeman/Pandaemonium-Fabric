/*

    Pandaemonium
    EffectivePowerTool.java
    The effective. Power tool

    Registers the Effective Power pickaxe.

 */

// TODO: Merge this with ModItems.java once that's figured out

package net.compii.pandaemonium;

import net.compii.pandaemonium.block.ModBlocks;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EffectivePowerTool implements ToolMaterial {

    public static final EffectivePowerTool EFFECTIVE_POWER_TOOL = new EffectivePowerTool();

    @Override
    public int getDurability() {
        return 4763;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.5F;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModBlocks.THE_TESTING_BLOCK);
    }



}

