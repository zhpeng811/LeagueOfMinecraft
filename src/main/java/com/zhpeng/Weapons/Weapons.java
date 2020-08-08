package com.zhpeng.Weapons;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Weapons {
	
	public static ArrayList<Item> weapons = new ArrayList<>();

	public static void addAllWeapons() {
		DeathDance.addWeapon();
		BlackCleaver.addWeapon();
	}
	public static void registerWeapon(Item weapon) {
		weapons.add(weapon);
	}
}
