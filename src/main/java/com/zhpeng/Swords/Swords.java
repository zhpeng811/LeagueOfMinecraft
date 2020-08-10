package com.zhpeng.Swords;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Swords {
	public static final ArrayList<Item> SWORDS = new ArrayList<>();
	
	// the damage in lol * damageRatio = damage in minecraft
	// e.g. long sword +10 attack damage in lol
	// so in minecraft it will be 10*0.4 = 4 attack damage
	public static final float damageRatio = 0.4F;
	
	// ItemSword class have a base damage of 4, need to subtract it
	public static final float swordBaseDamage = 4.0F;
	
	public static void addAllWeapons() {
		addWeapon("long_sword", 2, 350, 2.0F, 10F * damageRatio - swordBaseDamage, 30);
		addWeapon("vampiric_scepter", 3, 900, 3.0F, 15F * damageRatio - swordBaseDamage, 30);
		addWeapon("caulfield_warhammer", 3, 1100, 3.0F, 25 * damageRatio - swordBaseDamage, 30);
		addWeapon("serrated_dirk", 3, 1100, 3.0F, 30 * damageRatio - swordBaseDamage, 30);
		addWeapon("phage", 3, 1200, 3.0F, 15F * damageRatio - swordBaseDamage, 30);
		addWeapon("death_dance", 4, 3600, 5.0F, 50F * damageRatio - swordBaseDamage, 30);
		addWeapon("black_cleaver", 4, 3000, 5.0F, 40F * damageRatio - swordBaseDamage, 30);
		addWeapon("duskblade_of_draktharr", 4, 2900, 5.0F, 60F * damageRatio - swordBaseDamage, 30);
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
