/*

    Pandaemonium
    StickaxeMaterial.java
    The Stickaxe

 */

package net.compii.pandaemonium.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class StickaxeMaterial implements ToolMaterial {

    public static final StickaxeMaterial STICKAXE_MATERIAL = new StickaxeMaterial();

    @Override
    public int getDurability() {
        return 2;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 50;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.STICK);
    }



}

