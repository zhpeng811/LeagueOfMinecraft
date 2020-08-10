package com.zhpeng.Shields;

import com.zhpeng.MinecraftLegends;

import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public class CustomShield extends ItemShield {
	
	private String name;
	
	public CustomShield(String name) {
		super();
		this.name = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MinecraftLegends.creativeTabShields);
	}
	
	@Override
	// necessary since minecraft hardcoded ItemShield class display name to be "item.shield.name"
	public String getItemStackDisplayName(ItemStack stack) {
		return I18n.translateToLocal("item." + this.name + ".name");
	}
}
