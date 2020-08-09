package com.zhpeng.Shields;

import com.zhpeng.MinecraftLegends;

import net.minecraft.item.ItemShield;

public class CustomShield extends ItemShield {
	public CustomShield(String name) {
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MinecraftLegends.creativeTabShields);
	}
}
