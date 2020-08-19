package com.zhpeng.Items;

public enum Items {
	COIN_10("coin_10"),
	COIN_50("coin_50"),
	COIN_100("coin_100"),
	COIN_500("coin_500"),
	COIN_1000("coin_1000"),
	
	REJUVENATION_BEAD("rejuvenation_bead"),
	RUBY_CRYSTAL("ruby_crystal"),
	CRYSTALLINE_BRACER("crystalline_bracer"),
	KINDLEGEM("kindlegem"),
	
	AMPLIFYING_TOME("amplifying_tome"),
	CLOAK_OF_AGILITY("cloak_of_agility");
	
	private String name;
	
	Items(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
 