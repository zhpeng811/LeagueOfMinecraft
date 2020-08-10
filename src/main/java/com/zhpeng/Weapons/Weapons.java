package com.zhpeng.Weapons;

import java.util.ArrayList;

import com.zhpeng.Swords.Swords;

import net.minecraft.item.Item;


public class Weapons {
	
	public static ArrayList<Item> WEAPONS = new ArrayList<>();

	public static void addAllWeapons() {
		Swords.addAllWeapons();
		WEAPONS.addAll(Swords.SWORDS);
	}
}
