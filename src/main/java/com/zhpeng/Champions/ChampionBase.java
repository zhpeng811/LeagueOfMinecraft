package com.zhpeng.Champions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class ChampionBase extends Item {
	public final ArrayList<AbilityBase> ABILITIES = new ArrayList<>();
	private String name;
	
	public ChampionBase(String name, Item.Properties prop) {
	    super(prop);
	    this.name = name;
	}
	
	public String getChampionName() {
		return this.name;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        PlayerInventory inventory = playerIn.inventory;
        
        if (!worldIn.isRemote) {
        	inventory.deleteStack(stack);
        	for (Item ability : ABILITIES) {
        		inventory.addItemStackToInventory(new ItemStack(ability));
        	}
        }

        return ActionResult.resultPass(stack);
    }
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		 tooltip.add(new TranslationTextComponent("item.minecraftlegends.champion.tooltip"));
	};
}
