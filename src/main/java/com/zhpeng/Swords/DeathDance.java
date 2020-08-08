package com.zhpeng.Swords;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class DeathDance {
    public static void addWeapon() {
        String name = "death_dance";
        int harvestLevel = 4;
        int maxUses = 3600;
        float efficiency = 5.0F;
        float damage = 16F;
        int enchantability = 30;
        ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
        Item sword = new CustomSword(toolMaterial, name);
        Swords.registerWeapon(sword);
    }
}
