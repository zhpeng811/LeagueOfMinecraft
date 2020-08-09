package com.zhpeng;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhpeng.Shields.Shields;
import com.zhpeng.Weapons.Weapons;
import com.zhpeng.proxy.Proxy;
import com.zhpeng.util.Config;
import com.zhpeng.util.MLCreativeTabItems;
import com.zhpeng.util.MLCreativeTabShields;
import com.zhpeng.util.MLCreativeTabWeapons;

@Mod(modid = Config.MODID, name = Config.NAME, version = Config.VERSION, acceptedMinecraftVersions = Config.ACCEPTED_VERSIONS)
public class MinecraftLegends {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@SidedProxy(clientSide = "com.zhpeng.proxy.ClientProxy", serverSide = "com.zhpeng.proxy.ServerProxy")
	public static Proxy proxy;
	
	@Instance
	public static MinecraftLegends instance;
	
	public static MLCreativeTabWeapons creativeTabWeapons = new MLCreativeTabWeapons();
	public static MLCreativeTabItems creativeTabItems = new MLCreativeTabItems();
	public static MLCreativeTabShields creativeTabShields = new MLCreativeTabShields();
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent e) {
		Weapons.addAllWeapons();
		Shields.addAllShields();
		proxy.preInit();
	}
}
