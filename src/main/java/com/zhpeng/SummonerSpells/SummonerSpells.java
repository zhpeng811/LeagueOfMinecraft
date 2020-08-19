package com.zhpeng.SummonerSpells;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class SummonerSpells {
	public static final ArrayList<Item> SPELLS = new ArrayList<>();
	
	public static void addAllSpells() {
		SPELLS.add(new Flash());
		SPELLS.add(new Ignite());
		SPELLS.add(new Heal());
		SPELLS.add(new Barrier());
		SPELLS.add(new Ghost());
	}
}
