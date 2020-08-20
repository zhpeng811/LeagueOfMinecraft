package com.zhpeng.Champions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.Utils.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

class BlindingDart extends AbilityBase {
	public BlindingDart() {
		super("blinding_dart");
	}
	
	protected void rightClickAction(@Nullable World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<EffectInstance> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new EffectInstance(Effects.BLINDNESS, 10 * ticksPerSecond , 1));
		ItemStack blindPotion = PotionUtils.appendEffects(splashPotion, effects);
		
	    if (checkForItemInInventory(blindPotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
	    } else {
	        playerIn.inventory.addItemStackToInventory(blindPotion); 
	        addItemCooldown(playerIn, 25);
	    }
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.blinding_dart.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.25_seconds_cooldown"));
	}
}

class MoveQuick extends AbilityBase {
	public MoveQuick() {
		super("move_quick");
	}
	
	protected void rightClickAction(@Nullable World worldIn, PlayerEntity playerIn, Hand handIn) {
		addPotionEffect(playerIn, Effects.SPEED, 5, 3);
	    addItemCooldown(playerIn, 15);
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.move_quick.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
	}
}

class ToxicShot extends AbilityBase {
	public ToxicShot() {
		super("toxic_shot");
	}
	
	protected void rightClickAction(@Nullable World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack tippedArrow = new ItemStack(Items.TIPPED_ARROW, 8);
		ArrayList<EffectInstance> effects = new ArrayList<>();
		effects.add(new EffectInstance(Effects.POISON, 10 * Constants.ticksPerSecond , 0));
		ItemStack poisonArrow = PotionUtils.appendEffects(tippedArrow, effects);
		
        if (checkForItemAmountInInventory(poisonArrow, playerIn.inventory, 8)) {
        	playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
        } else {
        	playerIn.inventory.deleteStack(poisonArrow);
        	playerIn.inventory.addItemStackToInventory(poisonArrow); 
        	addItemCooldown(playerIn, 30);
        }
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.toxic_shot.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.30_seconds_cooldown"));
	}
}

class NoxiousTrap extends AbilityBase {
	public NoxiousTrap() {
		super("noxious_trap");
	}
	
	protected void rightClickAction(@Nullable World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<EffectInstance> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new EffectInstance(Effects.POISON, 10 * ticksPerSecond , 4));
		effects.add(new EffectInstance(Effects.SLOWNESS, 10 * ticksPerSecond , 4));
		ItemStack customPotion = PotionUtils.appendEffects(splashPotion, effects);

		if (checkForItemInInventory(customPotion, playerIn.inventory)) {
		    playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
		} else {
			playerIn.inventory.addItemStackToInventory(customPotion); 
			addItemCooldown(playerIn, 40);
		}
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.noxious_trap.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.40_seconds_cooldown"));
	}
}

public class Teemo extends ChampionBase {
	public Teemo(Item.Properties prop) {
		super("teemo", prop);
		ABILITIES.add(new BlindingDart());
		ABILITIES.add(new MoveQuick());
		ABILITIES.add(new ToxicShot());
		ABILITIES.add(new NoxiousTrap());
	}
}
