package com.zhpeng.Champions;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

class TimeBomb extends AbilityBase {
	
	public static TimeBomb instance;
	
	@SuppressWarnings("static-access")
	public TimeBomb() {
		super("time_bomb");
		this.instance = this;
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		EntityThrowingTNT entityTNT = new EntityThrowingTNT(worldIn, playerIn);
		entityTNT.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
		worldIn.spawnEntity(entityTNT);
		addItemCooldown(playerIn, 15);
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.time_bomb.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
	}
	
	private class EntityThrowingTNT extends EntitySnowball {
		
		public EntityThrowingTNT(World worldIn) {
			super(worldIn);
		}
		
		public EntityThrowingTNT(World worldIn, EntityLivingBase throwerIn) {
			super(worldIn, throwerIn);
		}

		@Override
		protected void onImpact(RayTraceResult result) {
			BlockPos pos = result.getBlockPos();
			if (pos == null) {
				return;
			}
			if (!this.world.isRemote) {
				EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(this.world, (double) ((float) pos.getX() + 0.5F),
						((double) pos.getY() + 1.0F), (double) ((float) pos.getZ() + 0.5F), this.thrower);
				this.setDead();
				this.world.spawnEntity(entitytntprimed);
				this.world.playSound((EntityPlayer) null, entitytntprimed.posX, entitytntprimed.posY, entitytntprimed.posZ,
						SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	}
}

class Rewind extends AbilityBase {
	public Rewind() {
		super("rewind");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		removeItemCooldown(playerIn, TimeBomb.instance);
		removeItemCooldown(playerIn, TimeWrap.instance);
		addItemCooldown(playerIn, 20);
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.rewind.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.20_seconds_cooldown"));	
	}
	
}

class TimeWrap extends AbilityBase {
	
	public static TimeWrap instance;
	
	@SuppressWarnings("static-access")
	public TimeWrap() {
		super("time_wrap");
		this.instance = this;
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		addPotionEffect(playerIn, MobEffects.SPEED, 5, 3);
		addItemCooldown(playerIn, 15);
	}
	
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.time_wrap.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));	
	}
}

class Chronoshift extends AbilityBase {
	public Chronoshift() {
		super("chronoshift");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack totemOfUndying = new ItemStack(Items.TOTEM_OF_UNDYING);
		
		if (checkForItemInInventory(totemOfUndying, playerIn.inventory)) {
	        playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
	    } else {
	        playerIn.inventory.addItemStackToInventory(totemOfUndying); 
	        addItemCooldown(playerIn, 120);
	    }
	}
	
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.chronoshift.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.120_seconds_cooldown"));	
	}
}

public class Zilean extends ChampionBase {
	public Zilean() {
		super("zilean");
		ABILITIES.add(new TimeBomb());
		ABILITIES.add(new Rewind());
		ABILITIES.add(new TimeWrap());
		ABILITIES.add(new Chronoshift());
	}
}
