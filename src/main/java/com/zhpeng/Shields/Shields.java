package com.zhpeng.Shields;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class Shields {
	public static ArrayList<Item> shields = new ArrayList<>();
	
	public static void addAllShields() {
		addShield("ageis_of_the_legion");
	}
	
	private static void addShield(String name) {
		Item shield = new CustomShield(name);
		shields.add(shield);
	}
}
