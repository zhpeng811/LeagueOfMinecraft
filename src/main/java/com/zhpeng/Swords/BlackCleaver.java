package com.zhpeng.Swords;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class BlackCleaver {
	public static void addWeapon() {
        String name = "black_cleaver";
        int harvestLevel = 4;
        int maxUses = 3000;
        float efficiency = 5.0F;
        float damage = 11F;
        int enchantability = 30;
        ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
        Item sword = new CustomSword(toolMaterial, name);
        Swords.registerWeapon(sword);
    }
}
