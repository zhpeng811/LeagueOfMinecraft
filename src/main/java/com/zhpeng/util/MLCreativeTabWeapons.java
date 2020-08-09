package com.zhpeng.util;

import com.zhpeng.Weapons.Weapons;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MLCreativeTabWeapons extends CreativeTabs {
	public MLCreativeTabWeapons() {
		super("minecraftlegends_weapons");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Weapons.weapons.get(0));
	}
}
