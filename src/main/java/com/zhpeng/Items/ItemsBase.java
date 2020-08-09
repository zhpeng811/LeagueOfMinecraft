package com.zhpeng.Items;

import com.zhpeng.MinecraftLegends;
import net.minecraft.item.Item;

public class ItemsBase extends Item {
	public ItemsBase(String name) {
	    this.setRegistryName(name);
	    this.setUnlocalizedName(name);
	    this.setCreativeTab(MinecraftLegends.creativeTabItems);
	    Items.ITEMS.add(this);
	}
}
