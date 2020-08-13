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
 	
	// the armor/magic resist added in league * armorRatio = armor in minecraft
	// e.g. cloth armor +15 armor in league
	// so in minecraft it will be 15*0.2 = 3 armor
	public static final float armorRatio = 0.2F;
	
	// until we are adding maximum health into the game, health in league will be used for toughness ratio
	// the health added in lol * toughnessRatio = toughness in minecraft
	// e.g. adaptive helm +350 health in league
	// so in minecraft it will be 350*00.1 = 3.5 armor toughness
	public static final float toughnessRatio = 0.01F;
	
 	public static final int ticksPerSecond = 20;
}
