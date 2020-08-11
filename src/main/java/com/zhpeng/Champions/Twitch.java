package com.zhpeng.Champions;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

class Ambush extends AbilityBase {

	public Ambush() {
		super("ambush");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		addPotionEffect(playerIn, MobEffects.INVISIBILITY, 8, 1);
        addItemCooldown(playerIn, 25);
    }

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.ambush.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.25_seconds_cooldown"));
	}
}

class VenomCask extends AbilityBase {

	public VenomCask() {
		super("venom_cask");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {    
        ItemStack poisonPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), PotionTypes.STRONG_POISON);

        if (checkForItemInInventory(poisonPotion.getItem(), playerIn.inventory)) {
        	playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
        } else {
        	playerIn.inventory.addItemStackToInventory(poisonPotion); 
        	addItemCooldown(playerIn, 15);
        }
    }

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.venom_cask.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
	}
}

class Contaminate extends AbilityBase {

	public Contaminate() {
		super("contaminate");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {    
		ItemStack poisonArrow = PotionUtils.addPotionToItemStack(
        		new ItemStack(Items.TIPPED_ARROW, 8), 
        		PotionType.getPotionTypeForName("strong_poison")
        );

				
        if (checkForItemAmountInInventory(poisonArrow.getItem(), playerIn.inventory, 8)) {
        	playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
        } else {
        	playerIn.inventory.clearMatchingItems(poisonArrow.getItem(), -1, -1, null);
        	playerIn.inventory.addItemStackToInventory(poisonArrow); 
        	addItemCooldown(playerIn, 30);
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.contaminate.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.30_seconds_cooldown"));
	}
}

public class Twitch extends ChampionBase {

	public Twitch() {
		super("twitch");
		ABILITIES.add(new Ambush());
		ABILITIES.add(new VenomCask());
		ABILITIES.add(new Contaminate());
	}

}
