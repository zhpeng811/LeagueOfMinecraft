package com.zhpeng.SummonerSpells;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class Ghost extends SpellBase {
	public Ghost(Item.Properties prop) {
		super("ghost", prop);
	}

	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		addPotionEffect(playerIn, Effects.SPEED, 10, 4);
	    addItemCooldown(playerIn, 150);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.ghost.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.150_seconds_cooldown"));
	}
}
