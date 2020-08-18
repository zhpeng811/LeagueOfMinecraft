package com.zhpeng.Utils;

import com.zhpeng.Champions.Champions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MLCreativeTabChampions extends CreativeTabs  {
	public MLCreativeTabChampions() {
		super("minecraftlegends_champions");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Champions.CHAMPIONS.get(0));
	}
}
