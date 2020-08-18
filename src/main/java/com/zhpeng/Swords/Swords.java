package com.zhpeng.Swords;

import java.util.ArrayList;

import com.zhpeng.Utils.Constants;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Swords {
	public static final ArrayList<Item> SWORDS = new ArrayList<>();
	
	public static void addAllWeapons() {
		float damageRatio = Constants.damageRatio;
		float powerToDamageRatio = Constants.powerToDamageRatio;
		float swordBaseDamage = Constants.swordBaseDamage;
		int durability = Constants.swordDurability;
		int unfinishedItemEnchantability = Constants.unfinishedItemEnchantability;
		int finishedItemEnchantability = Constants.finishedItemEnchantability;
		
		// starting and advanced items
		addWeapon("long_sword", 2, durability, 2.0F, 10 * damageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("vampiric_scepter", 3, durability, 3.0F, 15 * damageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("caulfield_warhammer", 3, durability, 3.0F, 25 * damageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("serrated_dirk", 3, durability, 3.0F, 30 * damageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("phage", 3, durability, 3.0F, 15 * damageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("bf_sword", 3, durability, 3.0F, 40 * damageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("pickaxe", 3, durability, 3.0F, 25 * damageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("tiamat", 3, durability, 3.0F, 25 * damageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("blasting_wand", 3, durability, 3.0F, 40 * powerToDamageRatio - swordBaseDamage, unfinishedItemEnchantability);
		addWeapon("needlessly_large_rod", 3, durability, 3.0F, 60 * powerToDamageRatio - swordBaseDamage, unfinishedItemEnchantability);
		
		// finished items
		addWeapon("death_dance", 4, -1, 5.0F, 50 * damageRatio - swordBaseDamage, finishedItemEnchantability);
		addWeapon("black_cleaver", 4, -1, 5.0F, 40 * damageRatio - swordBaseDamage, finishedItemEnchantability);
		addWeapon("duskblade_of_draktharr", 4, -1, 5.0F, 60 * damageRatio - swordBaseDamage, finishedItemEnchantability);
		addWeapon("infinity_edge", 4, -1, 5.0F, 80 * damageRatio - swordBaseDamage, finishedItemEnchantability);
		addWeapon("bloodthirster", 4, -1, 5.0F, 80 * damageRatio - swordBaseDamage, finishedItemEnchantability);
		addWeapon("ravenous_hydra", 4, -1, 5.0F, 80 * damageRatio - swordBaseDamage, finishedItemEnchantability);
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
