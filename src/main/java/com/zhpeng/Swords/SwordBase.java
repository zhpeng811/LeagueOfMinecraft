package com.zhpeng.Swords;

import com.zhpeng.MinecraftLegends;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class SwordBase extends SwordItem {
	public SwordBase(Swords swordMaterial) {
		super(swordMaterial, 0, 96F, new Item.Properties().group(MinecraftLegends.creativeTabWeapons));
	}
}
