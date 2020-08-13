package com.zhpeng.Champions;

import java.util.ArrayList;

public class Champions {

	public static final ArrayList<ChampionBase> CHAMPIONS = new ArrayList<>();
	
	public static void addAllChampions() {
		CHAMPIONS.add(new Udyr());
		CHAMPIONS.add(new Twitch());
		CHAMPIONS.add(new Sona());
		CHAMPIONS.add(new Zilean());
	}
}
