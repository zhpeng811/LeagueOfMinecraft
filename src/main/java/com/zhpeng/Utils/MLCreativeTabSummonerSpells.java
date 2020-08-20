package com.zhpeng.Utils;

import java.util.Collection;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

public class MLCreativeTabSummonerSpells extends ItemGroup {
	public MLCreativeTabSummonerSpells() {
		super("minecraftlegends_summoner_spells");
	}

	@Override
	public ItemStack createIcon() {
		Collection<RegistryObject<Item>> entries = RegistryHandler.ITEMS.getEntries();
		for (RegistryObject<Item> entry : entries) {
			if (entry.get().getRegistryName().getPath().contains("flash")) {
				return new ItemStack(entry.get());
		    }
		}
		return new ItemStack(Items.ENDER_PEARL);
	}
}