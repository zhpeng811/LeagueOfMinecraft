package com.zhpeng.SummonerSpells;

import com.zhpeng.MinecraftLegends;
import com.zhpeng.Champions.AbilityBase;

public abstract class SpellBase extends AbilityBase {
	public SpellBase(String name) {
		super(name);
		this.setCreativeTab(MinecraftLegends.creativeTabSpells);
	}
}

