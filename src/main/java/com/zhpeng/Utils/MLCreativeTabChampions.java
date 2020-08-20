package com.zhpeng.Utils;

import java.util.Collection;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

public class MLCreativeTabChampions extends ItemGroup {
	public MLCreativeTabChampions() {
		super("minecraftlegends_champions");
	}

	@Override
	public ItemStack createIcon() {
		Collection<RegistryObject<Item>> entries = RegistryHandler.ITEMS.getEntries();
		for (RegistryObject<Item> entry : entries) {
			if (entry.get().getRegistryName().getPath().contains("nunu")) {
				return new ItemStack(entry.get());
		    }
		}
		return new ItemStack(Items.PLAYER_HEAD);
	}
}
