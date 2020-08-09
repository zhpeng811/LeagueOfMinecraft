package com.zhpeng.Swords;

import com.zhpeng.MinecraftLegends;

import net.minecraft.item.ItemSword;

public class CustomSword extends ItemSword {
	public CustomSword(ToolMaterial material, String name) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MinecraftLegends.creativeTabWeapons);
	}
}
