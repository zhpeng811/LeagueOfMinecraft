package com.zhpeng.util;

import com.zhpeng.Shields.Shields;
import com.zhpeng.Swords.Swords;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MLCreativeTabWeapons extends CreativeTabs {
	public MLCreativeTabWeapons() {
		super("minecraftlegends_weapons");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Swords.swords.get(0));
	}
}
