package com.zhpeng.Weapons;

import com.zhpeng.Main;

import net.minecraft.item.ItemSword;

public class CustomSword extends ItemSword {

	public CustomSword(ToolMaterial material, String name) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Main.creativeTab);
	}
}
