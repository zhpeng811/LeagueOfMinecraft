package com.zhpeng.SummonerSpells;

import java.util.ArrayList;

import com.zhpeng.MinecraftLegends;

import net.minecraft.item.Item;

public class SummonerSpells {
	public static final ArrayList<SpellBase> SPELLS = new ArrayList<>();
	
	public static void addAllSpells() {
		Item.Properties prop = new Item.Properties();
		prop.maxStackSize(1);
		prop.group(MinecraftLegends.creativeTabSpells);
		
		SPELLS.add(new Flash(prop));
		SPELLS.add(new Ignite(prop));
		SPELLS.add(new Heal(prop));
		SPELLS.add(new Barrier(prop));
		SPELLS.add(new Ghost(prop));
	}
}
