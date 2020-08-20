package com.zhpeng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhpeng.Utils.Constants;
import com.zhpeng.Utils.MLCreativeTabArmors;
import com.zhpeng.Utils.MLCreativeTabChampions;
import com.zhpeng.Utils.MLCreativeTabItems;
import com.zhpeng.Utils.MLCreativeTabShields;
import com.zhpeng.Utils.MLCreativeTabSummonerSpells;
import com.zhpeng.Utils.MLCreativeTabWeapons;
import com.zhpeng.Utils.RegistryHandler;

import net.minecraft.item.ItemGroup;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MODID)
public class MinecraftLegends {

	public static final Logger LOGGER = LogManager.getLogger();

	public static MinecraftLegends instance;
	
	public static ItemGroup creativeTabWeapons = (ItemGroup) new MLCreativeTabWeapons();
	public static ItemGroup creativeTabItems = (ItemGroup) new MLCreativeTabItems();
	public static ItemGroup creativeTabShields = (ItemGroup) new MLCreativeTabShields();
	public static ItemGroup creativeTabArmors = (ItemGroup) new MLCreativeTabArmors();
	public static ItemGroup creativeTabChampions = (ItemGroup) new MLCreativeTabChampions();
	public static ItemGroup creativeTabSpells = (ItemGroup) new MLCreativeTabSummonerSpells();
	
	public MinecraftLegends() {
		instance = this;
		RegistryHandler.init();
		MinecraftForge.EVENT_BUS.register(this);	
	}
	
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
