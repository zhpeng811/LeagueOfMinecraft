package com.zhpeng.SummonerSpells;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Ignite extends SpellBase{
	public Ignite(Item.Properties prop) {
		super("ignite", prop);
	}

	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack woodenSword = new ItemStack(Items.WOODEN_SWORD);
		woodenSword.setDamage(59);
		woodenSword.addEnchantment(Enchantments.FIRE_ASPECT, 2);
		
		if (checkForItemInInventory(woodenSword, playerIn.inventory)) {
	        playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
	    } else {
	        playerIn.inventory.addItemStackToInventory(woodenSword); 
	        addItemCooldown(playerIn, 150);
	    }
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.ignite.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.150_seconds_cooldown"));
	}
	
}
