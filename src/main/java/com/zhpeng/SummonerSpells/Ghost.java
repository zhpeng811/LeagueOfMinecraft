package com.zhpeng.SummonerSpells;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class Ghost extends SpellBase {
	public Ghost() {
		super("ghost");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		addPotionEffect(playerIn, MobEffects.SPEED, 10, 4);
	    addItemCooldown(playerIn, 150);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.ghost.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.150_seconds_cooldown"));
	}
}
