package com.zhpeng.Items;

import com.zhpeng.LeagueOfMinecraft;
import net.minecraft.item.Item;

public class ItemsBase extends Item {
	public ItemsBase(String name) {
	    this.setRegistryName(name);
	    this.setUnlocalizedName(name);
	    this.setCreativeTab(LeagueOfMinecraft.creativeTabItems);
	    Items.ITEMS.add(this);
	}
}
