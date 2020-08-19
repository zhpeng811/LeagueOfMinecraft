package com.zhpeng.Swords;

import com.zhpeng.Utils.Constants;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public enum Swords implements IItemTier {
	// starting and advanced items
	LONG_SWORD("long_sword", 2, Constants.swordDurability, 2.0F, 10 * Constants.damageRatio, Constants.unfinishedItemEnchantability),
	VAMPIRIC_SCEPTER("vampiric_scepter", 3, Constants.swordDurability, 3.0F, 15 * Constants.damageRatio, Constants.unfinishedItemEnchantability),
	CAULFIELD_WARHAMMER("caulfield_warhammer", 3, Constants.swordDurability, 3.0F, 25 * Constants.damageRatio, Constants.unfinishedItemEnchantability),
	SERRATED_DIRK("serrated_dirk", 3, Constants.swordDurability, 3.0F, 30 * Constants.damageRatio, Constants.unfinishedItemEnchantability),
	PHAGE("phage", 3, Constants.swordDurability, 3.0F, 15 * Constants.damageRatio, Constants.unfinishedItemEnchantability),
	BF_SWORD("bf_sword", 3, Constants.swordDurability, 3.0F, 40 * Constants.damageRatio, Constants.unfinishedItemEnchantability),
	PICKAXE("pickaxe", 3, Constants.swordDurability, 3.0F, 25 * Constants.damageRatio, Constants.unfinishedItemEnchantability),
	TIAMAT("tiamat", 3, Constants.swordDurability, 3.0F, 25 * Constants.damageRatio, Constants.unfinishedItemEnchantability),
	BLASTING_WAND("blasting_wand", 3, Constants.swordDurability, 3.0F, 40 * Constants.powerToDamageRatio, Constants.unfinishedItemEnchantability),
	NEEDLESSLY_LARGE_ROD("needlessly_large_rod", 3, Constants.swordDurability, 3.0F, 60 * Constants.powerToDamageRatio, Constants.unfinishedItemEnchantability),
			
	// finished items
	DEATH_DANCE("death_dance", 4, Constants.swordDurability, 5.0F, 50 * Constants.damageRatio, Constants.finishedItemEnchantability),
	BLACK_CLEAVER("black_cleaver", 4, Constants.swordDurability, 5.0F, 40 * Constants.damageRatio, Constants.finishedItemEnchantability),
	DUSKBLADE_OF_DRAKTHARR("duskblade_of_draktharr", 4, Constants.swordDurability, 5.0F, 60 * Constants.damageRatio, Constants.finishedItemEnchantability),
	INFINITY_EDGE("infinity_edge", 4, Constants.swordDurability, 5.0F, 80 * Constants.damageRatio, Constants.finishedItemEnchantability),
	BLOODTHIRSTER("bloodthirster", 4, Constants.swordDurability, 5.0F, 80 * Constants.damageRatio, Constants.finishedItemEnchantability),
	RAVENOUS_HYDRA("ravenous_hydra", 4, Constants.swordDurability, 5.0F, 80 * Constants.damageRatio, Constants.finishedItemEnchantability);

	private final String name;
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float damage;
	private final int enchantability;
	
	Swords(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability) {
		this.name = name;
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.damage = damage;
		this.enchantability = enchantability;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getMaxUses() {
		return this.maxUses;
	}

	@Override
	public float getEfficiency() {
		return this.efficiency;
	}

	@Override
	public float getAttackDamage() {
		return this.damage;
	}

	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(Items.DIAMOND);
	}
}
