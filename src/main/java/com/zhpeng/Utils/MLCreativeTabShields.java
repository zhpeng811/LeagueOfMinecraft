package com.zhpeng.Utils;

import com.zhpeng.Shields.Shields;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MLCreativeTabShields extends CreativeTabs {
	public MLCreativeTabShields() {
		super("minecraftlegends_shields");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Shields.SHIELDS.get(0));
	}
}
