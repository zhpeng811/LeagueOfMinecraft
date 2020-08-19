package com.zhpeng.Utils;

import java.util.Collection;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;

public class MLCreativeTabArmors extends ItemGroup {
	public MLCreativeTabArmors() {
		super("minecraftlegends_armors");
	}

	@Override
	public ItemStack createIcon() {
        Collection<RegistryObject<Item>> entries = RegistryHandler.ITEMS.getEntries();
        for (RegistryObject<Item> entry : entries) {
            if (entry.get().getRegistryName().getPath().contains("warmog_armor")) {
                return new ItemStack(entry.get());
            }
        }
        return new ItemStack(Items.DIAMOND_CHESTPLATE);
    }
}