package com.zhpeng.Champions;

import java.util.ArrayList;
import java.util.List;

import com.zhpeng.Utils.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

class BlindingDart extends AbilityBase {
	public BlindingDart() {
		super("blinding_dart");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<PotionEffect> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new PotionEffect(MobEffects.BLINDNESS, 10 * ticksPerSecond , 1));
		ItemStack blindPotion = PotionUtils.appendEffects(splashPotion, effects);
		
	    if (checkForItemInInventory(blindPotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
	    } else {
	        playerIn.inventory.addItemStackToInventory(blindPotion); 
	        addItemCooldown(playerIn, 25);
	    }
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.blinding_dart.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.25_seconds_cooldown"));
	}
}

class MoveQuick extends AbilityBase {
	public MoveQuick() {
		super("move_quick");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		addPotionEffect(playerIn, MobEffects.SPEED, 5, 3);
	    addItemCooldown(playerIn, 15);
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.move_quick.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
	}
}

class ToxicShot extends AbilityBase {
	public ToxicShot() {
		super("toxic_shot");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack tippedArrow = new ItemStack(Items.TIPPED_ARROW, 8);
		ArrayList<PotionEffect> effects = new ArrayList<>();
		effects.add(new PotionEffect(MobEffects.POISON, 10 * Constants.ticksPerSecond , 0));
		ItemStack poisonArrow = PotionUtils.appendEffects(tippedArrow, effects);
		
        if (checkForItemAmountInInventory(poisonArrow, playerIn.inventory, 8)) {
        	playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
        } else {
        	playerIn.inventory.clearMatchingItems(poisonArrow.getItem(), -1, -1, null);
        	playerIn.inventory.addItemStackToInventory(poisonArrow); 
        	addItemCooldown(playerIn, 30);
        }
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.toxic_shot.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.30_seconds_cooldown"));
	}
}

class NoxiousTrap extends AbilityBase {
	public NoxiousTrap() {
		super("noxious_trap");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<PotionEffect> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new PotionEffect(MobEffects.POISON, 10 * ticksPerSecond , 4));
		effects.add(new PotionEffect(MobEffects.SLOWNESS, 10 * ticksPerSecond , 4));
		ItemStack customPotion = PotionUtils.appendEffects(splashPotion, effects);

		if (checkForItemInInventory(customPotion, playerIn.inventory)) {
		    playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
		} else {
			playerIn.inventory.addItemStackToInventory(customPotion); 
			addItemCooldown(playerIn, 40);
		}
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.noxious_trap.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.40_seconds_cooldown"));
	}
}

public class Teemo extends ChampionBase {
	public Teemo() {
		super("teemo");
		ABILITIES.add(new BlindingDart());
		ABILITIES.add(new MoveQuick());
		ABILITIES.add(new ToxicShot());
		ABILITIES.add(new NoxiousTrap());
	}
}
