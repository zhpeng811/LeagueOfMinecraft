package com.zhpeng.Champions;

import java.util.ArrayList;
import java.util.List;

import com.zhpeng.Util.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

class HymnOfValor extends AbilityBase {
	public HymnOfValor() {
		super("hymn_of_valor");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack damagePotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), PotionTypes.HARMING);

	    if (checkForItemInInventory(damagePotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
	    } else {
	        playerIn.inventory.addItemStackToInventory(damagePotion); 
	        addItemCooldown(playerIn, 15);
	    }
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.hymn_of_valor.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
	}
}

class AriaOfPerseverance extends AbilityBase {
	public AriaOfPerseverance() {
		super("aria_of_perseverance");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack healingPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), PotionTypes.STRONG_HEALING);

	    if (checkForItemInInventory(healingPotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
	    } else {
	        playerIn.inventory.addItemStackToInventory(healingPotion); 
	        addItemCooldown(playerIn, 30);
	    }
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.aria_of_perseverance.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.30_seconds_cooldown"));
	}
}

class SongOfCelerity extends AbilityBase {
	public SongOfCelerity() {
		super("song_of_celerity");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack speedPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), PotionTypes.STRONG_SWIFTNESS);

	    if (checkForItemInInventory(speedPotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
	    } else {
	        playerIn.inventory.addItemStackToInventory(speedPotion); 
	        addItemCooldown(playerIn, 20);
	    }
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.song_of_celerity.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.20_seconds_cooldown"));
	}
}

class Crescendo extends AbilityBase {
	public Crescendo() {
		super("crescendo");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<PotionEffect> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1 * ticksPerSecond , 1));
		effects.add(new PotionEffect(MobEffects.SLOWNESS, 10 * ticksPerSecond , 4));
		effects.add(new PotionEffect(MobEffects.WEAKNESS, 10 * ticksPerSecond , 4));
		ItemStack customPotion = PotionUtils.appendEffects(splashPotion, effects);

	    if (checkForItemInInventory(customPotion, playerIn.inventory)) {
	        playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
	    } else {
	        playerIn.inventory.addItemStackToInventory(customPotion); 
	        addItemCooldown(playerIn, 120);
	    }
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.crescendo.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.100_seconds_cooldown"));
	}
}
public class Sona extends ChampionBase {

	public Sona() {
		super("sona");
		ABILITIES.add(new HymnOfValor());
		ABILITIES.add(new AriaOfPerseverance());
		ABILITIES.add(new SongOfCelerity());
		ABILITIES.add(new Crescendo());
	}

}
