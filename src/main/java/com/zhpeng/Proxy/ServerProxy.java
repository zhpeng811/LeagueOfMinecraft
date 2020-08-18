package com.zhpeng.Proxy;

import com.zhpeng.Utils.Constants;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = Constants.MODID, value = { Side.SERVER })
public class ServerProxy extends Proxy {
	public void preInit(FMLPreInitializationEvent event) {
	}

	public void init(FMLPreInitializationEvent event) {
	}

	public void postInit(FMLPreInitializationEvent event) {
	}
}