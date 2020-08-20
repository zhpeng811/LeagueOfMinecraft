package com.zhpeng.Champions;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

class TigerStance extends AbilityBase {
	public TigerStance() {	
    	super("tiger_stance");
    }

    protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
    	addPotionEffect(playerIn, Effects.HASTE, 5, 1);
        addItemCooldown(playerIn, 15);
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(new TranslationTextComponent("item.minecraftlegends.tiger_stance.tooltip"));
    	tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
    }
}

class TurtleStance extends AbilityBase {
	public TurtleStance() {	
    	super("turtle_stance");
    }
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		addPotionEffect(playerIn, Effects.ABSORPTION, 5, 1);
        addItemCooldown(playerIn, 15);
    }
    
    @OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(new TranslationTextComponent("item.minecraftlegends.turtle_stance.tooltip"));
    	tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
    }
}

class BearStance extends AbilityBase {
	public BearStance() {	
    	super("bear_stance");
    }
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		addPotionEffect(playerIn, Effects.SPEED, 5, 3);
        addItemCooldown(playerIn, 15);
    }
    
    @OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(new TranslationTextComponent("item.minecraftlegends.bear_stance.tooltip"));
    	tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
    }
}

class PhoenixStance extends AbilityBase {
	public PhoenixStance() {	
    	super("phoenix_stance");
    }
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {      
        addPotionEffect(playerIn, Effects.STRENGTH, 5, 0);
        addItemCooldown(playerIn, 15);
    }
    
    @OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    	tooltip.add(new TranslationTextComponent("item.minecraftlegends.phoenix_stance.tooltip"));
    	tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
    }
}

public class Udyr extends ChampionBase {
	public Udyr(Item.Properties prop) {
		super("udyr", prop);
		ABILITIES.add(new TigerStance());
		ABILITIES.add(new TurtleStance());
		ABILITIES.add(new BearStance());
		ABILITIES.add(new PhoenixStance());
	}
}
