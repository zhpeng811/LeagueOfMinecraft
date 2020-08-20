package com.zhpeng.Champions;

import java.util.ArrayList;
import java.util.List;

import com.zhpeng.Utils.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

class Ambush extends AbilityBase {

	public Ambush() {
		super("ambush");
	}
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		addPotionEffect(playerIn, Effects.INVISIBILITY, 8, 1);
        addItemCooldown(playerIn, 25);
    }

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.ambush.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.25_seconds_cooldown"));
	}
}

class VenomCask extends AbilityBase {

	public VenomCask() {
		super("venom_cask");
	}
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {    
        ItemStack poisonPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), Potions.STRONG_POISON);

        if (checkForItemInInventory(poisonPotion, playerIn.inventory)) {
        	playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
        } else {
        	playerIn.inventory.addItemStackToInventory(poisonPotion); 
        	addItemCooldown(playerIn, 15);
        }
    }

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.venom_cask.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
	}
}

class Contaminate extends AbilityBase {

	public Contaminate() {
		super("contaminate");
	}
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {    
		ItemStack tippedArrow = new ItemStack(Items.TIPPED_ARROW, 8);
		ArrayList<EffectInstance> effects = new ArrayList<>();
		effects.add(new EffectInstance(Effects.POISON, 10 * Constants.ticksPerSecond , 1));
		ItemStack poisonArrow = PotionUtils.appendEffects(tippedArrow, effects);
		
        if (checkForItemAmountInInventory(poisonArrow, playerIn.inventory, 8)) {
        	playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
        } else {
        	playerIn.inventory.deleteStack(poisonArrow);
        	playerIn.inventory.addItemStackToInventory(poisonArrow); 
        	addItemCooldown(playerIn, 30);
        }
    }
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.contaminate.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.30_seconds_cooldown"));
	}
}

class SprayAndPray extends AbilityBase {
	
	public SprayAndPray() {
		super("spray_and_pray");
	}
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {    
		addPotionEffect(playerIn, Effects.STRENGTH, 15, 1);
        addItemCooldown(playerIn, 100);
    }
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.spray_and_pray.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.100_seconds_cooldown"));
	}
}

public class Twitch extends ChampionBase {

	public Twitch(Item.Properties prop) {
		super("twitch", prop);
		ABILITIES.add(new Ambush());
		ABILITIES.add(new VenomCask());
		ABILITIES.add(new Contaminate());
		ABILITIES.add(new SprayAndPray());
	}

}
