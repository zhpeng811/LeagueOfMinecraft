package com.zhpeng.Shields;

public enum Shields {
	AGEIS_OF_THE_LEGION("ageis_of_the_legion");
	
	private String name;
	
	Shields(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
