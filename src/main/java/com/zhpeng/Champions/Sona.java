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
import net.minecraft.potion.Potions;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

class HymnOfValor extends AbilityBase {
	public HymnOfValor() {
		super("hymn_of_valor");
	}

	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack damagePotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), Potions.STRONG_HARMING);

	    if (checkForItemInInventory(damagePotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
	    } else {
	        playerIn.inventory.addItemStackToInventory(damagePotion); 
	        addItemCooldown(playerIn, 15);
	    }
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.hymn_of_valor.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
	}
}

class AriaOfPerseverance extends AbilityBase {
	public AriaOfPerseverance() {
		super("aria_of_perseverance");
	}

	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack healingPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), Potions.STRONG_HEALING);

	    if (checkForItemInInventory(healingPotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
	    } else {
	        playerIn.inventory.addItemStackToInventory(healingPotion); 
	        addItemCooldown(playerIn, 30);
	    }
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.aria_of_perseverance.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.30_seconds_cooldown"));
	}
}

class SongOfCelerity extends AbilityBase {
	public SongOfCelerity() {
		super("song_of_celerity");
	}

	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<EffectInstance> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new EffectInstance(Effects.SPEED, 8 * ticksPerSecond , 3));
		ItemStack customPotion = PotionUtils.appendEffects(splashPotion, effects);

	    if (checkForItemInInventory(customPotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
	    } else {
	        playerIn.inventory.addItemStackToInventory(customPotion); 
	        addItemCooldown(playerIn, 20);
	    }
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.song_of_celerity.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.20_seconds_cooldown"));
	}
}

class Crescendo extends AbilityBase {
	public Crescendo() {
		super("crescendo");
	}

	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<EffectInstance> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new EffectInstance(Effects.INSTANT_DAMAGE, 1 * ticksPerSecond , 1));
		effects.add(new EffectInstance(Effects.SLOWNESS, 10 * ticksPerSecond , 4));
		effects.add(new EffectInstance(Effects.WEAKNESS, 10 * ticksPerSecond , 4));
		ItemStack customPotion = PotionUtils.appendEffects(splashPotion, effects);

	    if (checkForItemInInventory(customPotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
	    } else {
	        playerIn.inventory.addItemStackToInventory(customPotion); 
	        addItemCooldown(playerIn, 120);
	    }
	}
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.crescendo.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.100_seconds_cooldown"));
	}
}
public class Sona extends ChampionBase {
	public Sona(Item.Properties prop) {
		super("sona", prop);
		ABILITIES.add(new HymnOfValor());
		ABILITIES.add(new AriaOfPerseverance());
		ABILITIES.add(new SongOfCelerity());
		ABILITIES.add(new Crescendo());
	}

}
