package com.zhpeng.proxy;

import com.zhpeng.Weapons.Weapons;
import com.zhpeng.util.Config;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = Config.MODID, value = {Side.CLIENT})
public class ClientProxy extends Proxy{
	@EventHandler
	public void preInit() {
	    OBJLoader.INSTANCE.addDomain(Config.MODID);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		for (Item weapon : Weapons.weapons) {
			registerRender(weapon);
		}
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		for (Item weapon : Weapons.weapons) {
			registry.registerAll(weapon);
		}
	}
}
