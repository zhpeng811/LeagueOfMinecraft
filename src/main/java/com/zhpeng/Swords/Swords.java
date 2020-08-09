package com.zhpeng.Swords;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Swords {
	public static ArrayList<Item> swords = new ArrayList<>();

	public static void addAllWeapons() {
		addWeapon("long_sword", 2, 350, 2.0F, 0F, 30);
		addWeapon("phage", 3, 1200, 3.0F, 4F, 30);
		addWeapon("death_dance", 4, 3600, 5.0F, 16F, 30);
		addWeapon("black_cleaver", 4, 3000, 5.0F, 11F, 30);
	}
	
	private static void addWeapon(
			String name, 
			int harvestLevel, 
			int maxUses,
			float efficiency,
			float damage,
			int enchantability
	) {
		ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
		Item sword = new CustomSword(toolMaterial, name);
		swords.add(sword);
	}
}
