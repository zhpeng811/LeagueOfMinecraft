package com.zhpeng.Swords;

import java.util.ArrayList;

import com.zhpeng.Util.Constants;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Swords {
	public static final ArrayList<Item> SWORDS = new ArrayList<>();
	
	public static void addAllWeapons() {
		float damageRatio = Constants.damageRatio;
		float swordBaseDamage = Constants.swordBaseDamage;
		
		addWeapon("long_sword", 2, 350, 2.0F, 10 * damageRatio - swordBaseDamage, 30);
		addWeapon("vampiric_scepter", 3, 900, 3.0F, 15 * damageRatio - swordBaseDamage, 30);
		addWeapon("caulfield_warhammer", 3, 1100, 3.0F, 25 * damageRatio - swordBaseDamage, 30);
		addWeapon("serrated_dirk", 3, 1100, 3.0F, 30 * damageRatio - swordBaseDamage, 30);
		addWeapon("phage", 3, 1200, 3.0F, 15 * damageRatio - swordBaseDamage, 30);
		addWeapon("bf_sword", 3, 1300, 3.0F, 40 * damageRatio - swordBaseDamage, 30);
		addWeapon("death_dance", 4, 3600, 5.0F, 50 * damageRatio - swordBaseDamage, 30);
		addWeapon("black_cleaver", 4, 3000, 5.0F, 40 * damageRatio - swordBaseDamage, 30);
		addWeapon("duskblade_of_draktharr", 4, 2900, 5.0F, 60 * damageRatio - swordBaseDamage, 30);
		addWeapon("infinity_edge", 4, 3400, 5.0F, 80 * damageRatio - swordBaseDamage, 30);
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
		SWORDS.add(sword);
	}
}
