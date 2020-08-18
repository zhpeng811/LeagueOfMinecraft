package com.zhpeng.Utils;

import com.zhpeng.Items.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MLCreativeTabItems extends CreativeTabs {
	public MLCreativeTabItems() {
		super("minecraftlegends_items");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.KINDLEGEM);
	}
}
