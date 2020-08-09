package com.zhpeng.Swords;

import com.zhpeng.LeagueOfMinecraft;

import net.minecraft.item.ItemSword;

public class CustomSword extends ItemSword {

	public CustomSword(ToolMaterial material, String name) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(LeagueOfMinecraft.creativeTabWeapon);
	}
}
