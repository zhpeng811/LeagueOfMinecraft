package com.zhpeng.util;

import com.zhpeng.Items.Items;
import com.zhpeng.Shields.Shields;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MLCreativeTabShields extends CreativeTabs {
	public MLCreativeTabShields() {
		super("minecraftlegends_shields");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Shields.shields.get(0));
	}
}
