package com.zhpeng.Champions;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

class TigerStance extends AbilityBase {
	public TigerStance() {	
    	super("tiger_stance");
    }

    protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
    	addPotionEffect(playerIn, MobEffects.HASTE, 5, 1);
        addItemCooldown(playerIn, 15);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(I18n.translateToLocal("item.tiger_stance.tooltip"));
    	tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
    }
}

class TurtleStance extends AbilityBase {
	public TurtleStance() {	
    	super("turtle_stance");
    }
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		addPotionEffect(playerIn, MobEffects.ABSORPTION, 5, 1);
        addItemCooldown(playerIn, 15);
    }
    
    @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(I18n.translateToLocal("item.turtle_stance.tooltip"));
    	tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
    }
}

class BearStance extends AbilityBase {
	public BearStance() {	
    	super("bear_stance");
    }
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		addPotionEffect(playerIn, MobEffects.SPEED, 5, 1);
        addItemCooldown(playerIn, 15);
    }
    
    @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(I18n.translateToLocal("item.bear_stance.tooltip"));
    	tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
    }
}

class PhoenixStance extends AbilityBase {
	public PhoenixStance() {	
    	super("phoenix_stance");
    }
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {      
        addPotionEffect(playerIn, MobEffects.STRENGTH, 5, 0);
        addItemCooldown(playerIn, 15);
    }
    
    @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(I18n.translateToLocal("item.phoenix_stance.tooltip"));
    	tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
    }
}

public class Udyr extends ChampionBase {
	public Udyr() {
		super("udyr");
		ABILITIES.add(new TigerStance());
		ABILITIES.add(new TurtleStance());
		ABILITIES.add(new BearStance());
		ABILITIES.add(new PhoenixStance());
	}
}
