package com.zhpeng.Utils;

import java.util.Collection;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

public class MLCreativeTabShields extends ItemGroup {
	public MLCreativeTabShields() {
		super("minecraftlegends_shields");
	}

	@Override
	public ItemStack createIcon() {
		Collection<RegistryObject<Item>> entries = RegistryHandler.ITEMS.getEntries();
		for (RegistryObject<Item> entry : entries) {
			if (entry.get().getRegistryName().getPath().contains("ageis_of_the_legion")) {
				return new ItemStack(entry.get());
		    }
		}
		return new ItemStack(Items.SHIELD);
	}
}
