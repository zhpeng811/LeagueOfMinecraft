package com.zhpeng.Events;

import java.util.ArrayList;

public class Events {
	public static final ArrayList<Object> events = new ArrayList<>();

	public static void addAllEvents() {
		events.add((Object) new TNTExplosionEvent());
	}
}
