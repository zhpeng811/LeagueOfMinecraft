package com.zhpeng.Armors;

import com.zhpeng.MinecraftLegends;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class CustomArmor extends ItemArmor {
	public CustomArmor(ItemArmor.ArmorMaterial material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name) {
		super(material, renderIndexIn, equipmentSlotIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MinecraftLegends.creativeTabArmors);
	}
}

