package com.zhpeng.proxy;

import com.zhpeng.util.Config;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = Config.MODID, value = {Side.SERVER})
public class ServerProxy extends Proxy {
  public void preInit() {}
  
  public void init() {}
  
  public void postInit() {}
}