package com.zhpeng.Weapons;

import java.util.ArrayList;

import com.zhpeng.Swords.Swords;

import net.minecraft.item.Item;


public class Weapons {
	
	public static ArrayList<Item> weapons = new ArrayList<>();

	public static void addAllWeapons() {
		weapons.addAll(Swords.swords);
	}
	public static void registerWeapon(Item weapon) {
		weapons.add(weapon);
	}
}
