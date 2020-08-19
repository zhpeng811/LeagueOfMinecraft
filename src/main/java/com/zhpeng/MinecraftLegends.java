package com.zhpeng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhpeng.Utils.Constants;
import com.zhpeng.Utils.MLCreativeTabArmors;
import com.zhpeng.Utils.MLCreativeTabItems;
import com.zhpeng.Utils.MLCreativeTabShields;
import com.zhpeng.Utils.MLCreativeTabWeapons;
import com.zhpeng.Utils.RegistryHandler;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MODID)
public class MinecraftLegends {

	public static final Logger LOGGER = LogManager.getLogger();

	public static MinecraftLegends instance;
	
	public MinecraftLegends() {
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
		RegistryHandler.init();
		
	}
	
	public static ItemGroup creativeTabWeapons = (ItemGroup) new MLCreativeTabWeapons();
	public static ItemGroup creativeTabItems = (ItemGroup) new MLCreativeTabItems();
	public static ItemGroup creativeTabShields = (ItemGroup) new MLCreativeTabShields();
	public static ItemGroup creativeTabArmors = (ItemGroup) new MLCreativeTabArmors();
//	public static ItemGroup creativeTabChampions = (ItemGroup) new MLCreativeTabChampions();
//	public static ItemGroup creativeTabSpells = (ItemGroup) new MLCreativeTabSummonerSpells();
}
