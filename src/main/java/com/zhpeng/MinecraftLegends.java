package com.zhpeng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhpeng.Armors.Armors;
import com.zhpeng.Champions.Champions;
import com.zhpeng.Proxy.Proxy;
import com.zhpeng.Shields.Shields;
import com.zhpeng.SummonerSpells.SummonerSpells;
import com.zhpeng.Utils.Constants;
import com.zhpeng.Utils.MLCreativeTabArmors;
import com.zhpeng.Utils.MLCreativeTabChampions;
import com.zhpeng.Utils.MLCreativeTabItems;
import com.zhpeng.Utils.MLCreativeTabShields;
import com.zhpeng.Utils.MLCreativeTabSummonerSpells;
import com.zhpeng.Utils.MLCreativeTabWeapons;
import com.zhpeng.Weapons.Weapons;

import net.minecraft.creativetab.CreativeTabs;
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

	public static CreativeTabs creativeTabWeapons = (CreativeTabs) new MLCreativeTabWeapons();
	public static CreativeTabs creativeTabItems = (CreativeTabs) new MLCreativeTabItems();
	public static CreativeTabs creativeTabShields = (CreativeTabs) new MLCreativeTabShields();
	public static CreativeTabs creativeTabArmors = (CreativeTabs) new MLCreativeTabArmors();
	public static CreativeTabs creativeTabChampions = (CreativeTabs) new MLCreativeTabChampions();
	public static CreativeTabs creativeTabSpells = (CreativeTabs) new MLCreativeTabSummonerSpells();

	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		Weapons.addAllWeapons();
		Shields.addAllShields();
		Armors.addAllArmors();
		Champions.addAllChampions();
		SummonerSpells.addAllSpells();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLPreInitializationEvent event) {
		proxy.init(event);
	}
}
