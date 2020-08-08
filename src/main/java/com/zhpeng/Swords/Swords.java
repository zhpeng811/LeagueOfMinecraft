package com.zhpeng.Swords;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class Swords {
	public static ArrayList<Item> swords = new ArrayList<>();

	public static void addAllWeapons() {
		DeathDance.addWeapon();
		BlackCleaver.addWeapon();
	}
	public static void registerWeapon(Item weapon) {
		swords.add(weapon);
	}
}
