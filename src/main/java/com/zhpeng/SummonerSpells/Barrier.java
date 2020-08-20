package com.zhpeng.SummonerSpells;

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

public class Barrier extends SpellBase {
	public Barrier(Item.Properties prop) {
		super("barrier", prop);
	}

	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		addPotionEffect(playerIn, Effects.ABSORPTION, 10, 2);
	    addItemCooldown(playerIn, 120);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.barrier.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.120_seconds_cooldown"));
	}
}
