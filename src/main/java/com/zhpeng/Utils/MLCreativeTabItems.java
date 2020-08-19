package com.zhpeng.Utils;

import java.util.Collection;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

public class MLCreativeTabItems extends ItemGroup {
	public MLCreativeTabItems() {
		super("minecraftlegends_items");
	}

	@Override
	public ItemStack createIcon() {
		Collection<RegistryObject<Item>> entries = RegistryHandler.ITEMS.getEntries();
		for (RegistryObject<Item> entry : entries) {
			if (entry.get().getRegistryName().getPath().contains("kindlegem")) {
				return new ItemStack(entry.get());
		    }
		}
		return new ItemStack(Items.QUARTZ);
	}
}
