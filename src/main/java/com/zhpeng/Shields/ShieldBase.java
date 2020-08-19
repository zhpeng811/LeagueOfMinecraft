package com.zhpeng.Shields;

import com.zhpeng.MinecraftLegends;

import net.minecraft.item.Item;
import net.minecraft.item.ShieldItem;

public class ShieldBase extends ShieldItem {
	public ShieldBase() {
		super(new Item.Properties().group(MinecraftLegends.creativeTabShields));
	}
}
