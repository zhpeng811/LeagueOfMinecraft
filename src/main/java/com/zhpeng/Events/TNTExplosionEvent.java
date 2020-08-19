package com.zhpeng.Events;

import net.minecraft.world.World;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TNTExplosionEvent {
	@SubscribeEvent
	public void onExplosionDetonate(final ExplosionEvent.Detonate event) {
		final World world = event.getWorld();
		if (!world.isRemote) {
			// prevent TNT from destroying blocks
			// useful for Zilean's Time Bomb
			event.getAffectedBlocks().clear();
		}
	}
}
