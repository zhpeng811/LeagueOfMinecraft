package com.zhpeng.Champions;

import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.util.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class AbilityBase extends Item {
	public AbilityBase(String name) {
	    this.setRegistryName(name);
	    this.setUnlocalizedName(name);
	    this.maxStackSize = 1;
	}
	
	protected void addPotionEffect(EntityPlayer playerIn, Potion potionType, int duration, int amplifier) {
		int ticksPerSecond = Constants.ticksPerSecond;
		playerIn.addPotionEffect(new PotionEffect(potionType, duration * ticksPerSecond, amplifier));
	}
	
	protected void addItemCooldown(EntityPlayer playerIn, int cooldownTime) {
		int ticksPerSecond = Constants.ticksPerSecond;
		playerIn.getCooldownTracker().setCooldown(this, cooldownTime * ticksPerSecond);
	}
	
	protected abstract void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn);
	
	protected boolean checkForItemInInventory(Item item, InventoryPlayer inventory) {
		return checkForItemAmountInInventory(item, inventory, 1);
	}
	
	/** 
	 * check if the player's inventory has at least {amount} stacks of item
	 */
	protected boolean checkForItemAmountInInventory(Item item, InventoryPlayer inventory, int amount) {
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
        	ItemStack stack = inventory.getStackInSlot(i);
        	if (stack.getItem().equals(item)) {
        		if (stack.getCount() >= amount) {
        			return true;        			
        		}
        	} 
        } 
        return false;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		if (!worldIn.isRemote) {
			rightClickAction(worldIn, playerIn, handIn);
	    }
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	};

	@SideOnly(Side.CLIENT)
	public abstract void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn);
	
}

