package com.zhpeng.Items;

import com.zhpeng.MinecraftLegends;

import net.minecraft.item.Item;

public class ItemsBase extends Item {
	public ItemsBase(String name) {
	    this.setRegistryName(name);
	    this.setUnlocalizedName(name);
	    this.setCreativeTab(MinecraftLegends.creativeTabItems);
	    if (name.startsWith("coin")) {
	    	this.maxStackSize = 64;
	    } else {
	    	this.maxStackSize = 1;	    	
	    }
	    Items.ITEMS.add(this);
	}
}
