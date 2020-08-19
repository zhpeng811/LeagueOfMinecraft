package com.zhpeng.SummonerSpells;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class Ignite extends SpellBase{
	public Ignite() {
		super("ignite");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack woodenSword = new ItemStack(Items.WOODEN_SWORD);
		Enchantment fireAspect = Enchantment.getEnchantmentByID(20);
		woodenSword.setItemDamage(59);
		woodenSword.addEnchantment(fireAspect, 2);
		
		if (checkForItemInInventory(woodenSword, playerIn.inventory)) {
	        playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
	    } else {
	        playerIn.inventory.addItemStackToInventory(woodenSword); 
	        addItemCooldown(playerIn, 150);
	    }
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.ignite.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.150_seconds_cooldown"));
	}
	
}
