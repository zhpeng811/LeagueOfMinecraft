package com.zhpeng.util;

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
 	
 	public static final int ticksPerSecond = 20;
}
