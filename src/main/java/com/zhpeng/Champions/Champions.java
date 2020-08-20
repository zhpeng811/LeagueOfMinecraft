package com.zhpeng.Champions;

import java.util.ArrayList;

import com.zhpeng.MinecraftLegends;

import net.minecraft.item.Item;

public class Champions {

	public static final ArrayList<ChampionBase> CHAMPIONS = new ArrayList<>();
	
	public static void addAllChampions() {
		Item.Properties prop = new Item.Properties();
		prop.maxStackSize(1);
		prop.group(MinecraftLegends.creativeTabChampions);
		CHAMPIONS.add(new Udyr(prop));
		CHAMPIONS.add(new Twitch(prop));
		CHAMPIONS.add(new Sona(prop));
		CHAMPIONS.add(new Zilean(prop));
		CHAMPIONS.add(new Teemo(prop));
		CHAMPIONS.add(new Nunu(prop));
	}
}
