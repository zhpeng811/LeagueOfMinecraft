package com.zhpeng.Items;

import java.util.ArrayList;

import net.minecraft.item.Item;

public class Items {
	public static final ArrayList<Item> ITEMS = new ArrayList<>();
	
	public static final Item COIN_10 = (Item) new ItemsBase("coin_10");
	public static final Item COIN_50 = (Item) new ItemsBase("coin_50");
	public static final Item COIN_100 = (Item) new ItemsBase("coin_100");
	public static final Item COIN_500 = (Item) new ItemsBase("coin_500");
	public static final Item COIN_1000 = (Item) new ItemsBase("coin_1000");
	
	public static final Item REJUVENATION_BEAD = (Item) new ItemsBase("rejuvenation_bead");
	public static final Item RUBY_CRYSTAL = (Item) new ItemsBase("ruby_crystal");
	public static final Item CRYSTALLINE_BRACER = (Item) new ItemsBase("crystalline_bracer");
	public static final Item KINDLEGEM = (Item) new ItemsBase("kindlegem");
	
	public static final Item AMPLIFYING_TOME = (Item) new ItemsBase("amplifying_tome");
	public static final Item CLOAK_OF_AGILITY = (Item) new ItemsBase("cloak_of_agility");
	
	public static final Item ABILITY_REFRESH = (Item) new AbilityRefresh();
	public static final Item HEALTH_POTION = (Item) new HealthPotion();
}
 