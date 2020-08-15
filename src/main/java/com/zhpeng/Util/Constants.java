package com.zhpeng.Util;

public class Constants {
    public static final String MODID = "minecraftlegends";
    public static final String NAME = "Minecraft Legends";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
    
    // the damage in league * damageRatio = damage in minecraft
 	// e.g. long sword +10 attack damage in league
 	// so in minecraft it will be 10*0.4 = 4 attack damage
 	public static final float damageRatio = 0.4F;
 	
 	// ItemSword class have a base damage of 4
 	public static final float swordBaseDamage = 4.0F;
 	
 	// unbreakable
 	public static final int swordDurability = -1;
 	public static final int armorDurability = -1;
 	
 	// unfinished item must not have the ability enchantment, otherwise the enchanted item will become uncraftable
 	public static final int unfinishedItemEnchantability = 0;
 	public static final int finishedItemEnchantability = 30;
 	
	// the armor/magic resist added in league * armorRatio = armor in minecraft
	// e.g. cloth armor +15 armor in league
	// so in minecraft it will be 15*0.2 = 3 armor
	public static final float armorRatio = 0.2F;
	
	// unfinished armor have a no armor toughness
	public static final float unfinishedArmorToughness = 0F;
	
	// finished armor have a constant toughness
	public static final float finishedArmorToughness = 2F;
	
	// the health added in lol * healthRatio = the health added for minecraft
	// e.g. adaptive helm +350 health in league
	// so in minecraft it will be 350*0.04 = +14 maximum health
	public static final float healthRatio = 0.04F;
	
 	public static final int ticksPerSecond = 20;
}
