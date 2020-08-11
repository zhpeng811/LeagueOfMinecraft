package com.zhpeng.Champions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.MinecraftLegends;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ChampionBase extends Item {
	public final ArrayList<Item> ABILITIES = new ArrayList<>();
	
	public ChampionBase(String name) {
	    this.setRegistryName(name);
	    this.setUnlocalizedName(name);
	    this.maxStackSize = 1;
	    this.setCreativeTab(MinecraftLegends.creativeTabChampions);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        InventoryPlayer inventory = playerIn.inventory;
        
        if (!worldIn.isRemote) {
        	inventory.deleteStack(stack);
        	for (Item ability : ABILITIES) {
        		inventory.addItemStackToInventory(new ItemStack(ability));
        	}
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
		 tooltip.add(I18n.translateToLocal("item.champion.tooltip"));
	};
}
