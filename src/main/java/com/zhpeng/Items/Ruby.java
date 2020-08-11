package com.zhpeng.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Ruby extends ItemsBase
{
    public Ruby()
    {	
    	super("ruby_crystal");
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        playerIn.getCooldownTracker().setCooldown(this, 100);

        if (!worldIn.isRemote)
        {
        	playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 1000, 2));
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}