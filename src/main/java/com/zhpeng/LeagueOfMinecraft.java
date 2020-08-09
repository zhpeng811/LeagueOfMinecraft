package com.zhpeng;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhpeng.Weapons.Weapons;
import com.zhpeng.proxy.Proxy;
import com.zhpeng.util.Config;
import com.zhpeng.util.LOMCreativeTabItems;
import com.zhpeng.util.LOMCreativeTabWeapons;

@Mod(modid = Config.MODID, name = Config.NAME, version = Config.VERSION, acceptedMinecraftVersions = Config.ACCEPTED_VERSIONS)
public class LeagueOfMinecraft {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@SidedProxy(clientSide = "com.zhpeng.proxy.ClientProxy", serverSide = "com.zhpeng.proxy.ServerProxy")
	public static Proxy proxy;
	
	@Instance
	public static LeagueOfMinecraft instance;
	
	public static LOMCreativeTabWeapons creativeTabWeapon = new LOMCreativeTabWeapons();
	public static LOMCreativeTabItems creativeTabItems = new LOMCreativeTabItems();
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent e) {
		Weapons.addAllWeapons();
		proxy.preInit();
	}
}
