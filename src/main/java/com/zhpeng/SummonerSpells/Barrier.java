package com.zhpeng.SummonerSpells;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class Barrier extends SpellBase {
	public Barrier() {
		super("barrier");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		addPotionEffect(playerIn, MobEffects.ABSORPTION, 10, 2);
	    addItemCooldown(playerIn, 120);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.barrier.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.120_seconds_cooldown"));
	}
}
