package com.zhpeng.Items;

import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.Utils.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HealthPotion extends ItemsBase {
	public HealthPotion() {
		super("health_potion");
		this.maxStackSize = 64;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		int ticksPerSecond = Constants.ticksPerSecond;
		
		if (!worldIn.isRemote) {
			playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 5 * ticksPerSecond, 1));
			stack.shrink(1);
			playerIn.getCooldownTracker().setCooldown(this, 5 * ticksPerSecond);
	    }
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	};
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.health_potion.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.5_seconds_cooldown"));
	}
}
