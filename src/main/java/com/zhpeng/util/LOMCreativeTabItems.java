package com.zhpeng.util;

import com.zhpeng.Items.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class LOMCreativeTabItems extends CreativeTabs {
	public LOMCreativeTabItems() {
		super("lom_items");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.RUBY_CRYSTAL);
	}
}
