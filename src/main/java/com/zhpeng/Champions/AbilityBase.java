package com.zhpeng.Champions;

import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.Utils.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbilityBase extends Item {
	
	private String name;
	
	public AbilityBase(String name) {
		super(new Item.Properties().maxStackSize(1));
		this.name = name;
	}
	
	public String getAbilityName() {
		return this.name;
	}
	
	protected void addPotionEffect(PlayerEntity playerIn, Effect potionType, int duration, int amplifier) {
		int ticksPerSecond = Constants.ticksPerSecond;
		playerIn.addPotionEffect(new EffectInstance(potionType, duration * ticksPerSecond, amplifier));
	}
	
	public void removeItemCooldown(PlayerEntity playerIn, Item item) {
		playerIn.getCooldownTracker().removeCooldown(item);
	}
	
	protected void addItemCooldown(PlayerEntity playerIn, int cooldownTime) {
		int ticksPerSecond = Constants.ticksPerSecond;
		playerIn.getCooldownTracker().setCooldown(this, cooldownTime * ticksPerSecond);
	}
	
	protected abstract void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn);
	
	protected boolean checkForItemInInventory(ItemStack stack, PlayerInventory inventory) {
		return checkForItemAmountInInventory(stack, inventory, 1);
	}
	
	/** 
	 * check if the player's inventory has at least {amount} stacks of item
	 */
	protected boolean checkForItemAmountInInventory(ItemStack stack, PlayerInventory inventory, int amount) {
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
        	ItemStack inventoryStack = inventory.getStackInSlot(i);
        	if (
        			stack.getItem().equals(inventoryStack.getItem()) &&
        			ItemStack.areItemStackTagsEqual(stack, inventoryStack)
        	) {
        		if (stack.getCount() >= amount) {
        			return true;        			
        		}
        	} 
        } 
        return false;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		if (!worldIn.isRemote) {
			rightClickAction(worldIn, playerIn, handIn);
	    }
		
		return ActionResult.resultPass(stack);
	};

	@OnlyIn(Dist.CLIENT)
	public abstract void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn);
	
}

