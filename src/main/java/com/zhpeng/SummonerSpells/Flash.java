package com.zhpeng.SummonerSpells;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class Flash extends SpellBase {
	public Flash() {
		super("flash");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		EntityEnderPearl entityEnderPearl = new EntityEnderPearl(worldIn, playerIn);
		entityEnderPearl.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.spawnEntity(entityEnderPearl);
        addItemCooldown(playerIn, 180);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.flash.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.180_seconds_cooldown"));
	}

}
