package com.zhpeng.util;

import com.zhpeng.Armors.Armors;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MLCreativeTabArmors extends CreativeTabs {
	public MLCreativeTabArmors() {
		super("minecraftlegends_armors");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Armors.ARMORS.get(0));
	}
}