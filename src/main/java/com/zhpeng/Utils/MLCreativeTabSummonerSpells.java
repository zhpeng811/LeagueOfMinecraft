package com.zhpeng.Utils;

import com.zhpeng.SummonerSpells.SummonerSpells;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MLCreativeTabSummonerSpells extends CreativeTabs {
	public MLCreativeTabSummonerSpells() {
		super("minecraftlegends_summoner_spells");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SummonerSpells.SPELLS.get(0));
	}
}