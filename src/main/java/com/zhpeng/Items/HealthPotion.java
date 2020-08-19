package com.zhpeng.Items;

import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.Utils.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HealthPotion extends ItemsBase {
	public HealthPotion() {
		super();
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		int ticksPerSecond = Constants.ticksPerSecond;
		
		if (!worldIn.isRemote) {
			playerIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 5 * ticksPerSecond, 1));
			stack.shrink(1);
			playerIn.getCooldownTracker().setCooldown(this, 5 * ticksPerSecond);
	    }
		return ActionResult.resultPass(playerIn.getHeldItem(handIn));
	};
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.health_potion.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.5_seconds_cooldown"));
	}
}
