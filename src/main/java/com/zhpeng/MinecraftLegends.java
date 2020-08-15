package com.zhpeng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhpeng.Armors.Armors;
import com.zhpeng.Champions.Champions;
import com.zhpeng.Proxy.Proxy;
import com.zhpeng.Shields.Shields;
import com.zhpeng.Util.Constants;
import com.zhpeng.Util.MLCreativeTabArmors;
import com.zhpeng.Util.MLCreativeTabChampions;
import com.zhpeng.Util.MLCreativeTabItems;
import com.zhpeng.Util.MLCreativeTabShields;
import com.zhpeng.Util.MLCreativeTabWeapons;
import com.zhpeng.Weapons.Weapons;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MODID, name = Constants.NAME, version = Constants.VERSION, acceptedMinecraftVersions = Constants.ACCEPTED_VERSIONS)
public class MinecraftLegends {

	public static final Logger LOGGER = LogManager.getLogger();

	@SidedProxy(clientSide = "com.zhpeng.Proxy.ClientProxy", serverSide = "com.zhpeng.Proxy.ServerProxy")
	public static Proxy proxy;

	@Instance
	public static MinecraftLegends instance;

	public static MLCreativeTabWeapons creativeTabWeapons = new MLCreativeTabWeapons();
	public static MLCreativeTabItems creativeTabItems = new MLCreativeTabItems();
	public static MLCreativeTabShields creativeTabShields = new MLCreativeTabShields();
	public static MLCreativeTabArmors creativeTabArmors = new MLCreativeTabArmors();
	public static MLCreativeTabChampions creativeTabChampions = new MLCreativeTabChampions();
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		Weapons.addAllWeapons();
		Shields.addAllShields();
		Armors.addAllArmors();
		Champions.addAllChampions();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		proxy.init(event);
	}
}
