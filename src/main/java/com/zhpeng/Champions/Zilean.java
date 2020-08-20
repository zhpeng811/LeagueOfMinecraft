package com.zhpeng.Champions;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

class TimeBomb extends AbilityBase {
	
	public static TimeBomb instance;
	
	@SuppressWarnings("static-access")
	public TimeBomb() {
		super("time_bomb");
		this.instance = this;
	}
	
	protected void rightClickAction(@Nullable World worldIn, PlayerEntity playerIn, Hand handIn) {
		EntityThrowingTNT entityTNT = new EntityThrowingTNT(worldIn, playerIn);
		entityTNT.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
		worldIn.addEntity(entityTNT);
		addItemCooldown(playerIn, 15);
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.time_bomb.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
	}
	
	private class EntityThrowingTNT extends SnowballEntity {
		
		public EntityThrowingTNT(@Nullable World worldIn, LivingEntity throwerIn) {
			super(worldIn, throwerIn);
		}

		@Override
		protected void onImpact(RayTraceResult result) {
			BlockPos pos = null;
			if (result.getType() == RayTraceResult.Type.ENTITY) {
				pos = ((EntityRayTraceResult) result).getEntity().getPosition();
			} else if(result.getType() == RayTraceResult.Type.BLOCK) {
				pos = ((BlockRayTraceResult) result).getPos();
			}
			
			if (pos == null) {
				return;
			}
			if (!this.world.isRemote) {
				TNTEntity entitytntprimed = new TNTEntity(this.world, (double) ((float) pos.getX() + 0.5F),
						((double) pos.getY() + 1.0F), (double) ((float) pos.getZ() + 0.5F), this.getThrower());
				this.remove();
				this.world.addEntity(entitytntprimed);
				this.world.playSound((PlayerEntity) null, entitytntprimed.getPosX(), entitytntprimed.getPosY(), entitytntprimed.getPosZ(),
						SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	}
}

class Rewind extends AbilityBase {
	public Rewind() {
		super("rewind");
	}
	
	protected void rightClickAction(@Nullable World worldIn, PlayerEntity playerIn, Hand handIn) {
		removeItemCooldown(playerIn, TimeBomb.instance);
		removeItemCooldown(playerIn, TimeWrap.instance);
		addItemCooldown(playerIn, 20);
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.rewind.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.20_seconds_cooldown"));	
	}
	
}

class TimeWrap extends AbilityBase {
	
	public static TimeWrap instance;
	
	@SuppressWarnings("static-access")
	public TimeWrap() {
		super("time_wrap");
		this.instance = this;
	}
	
	protected void rightClickAction(@Nullable World worldIn, PlayerEntity playerIn, Hand handIn) {
		addPotionEffect(playerIn, Effects.SPEED, 5, 3);
		addItemCooldown(playerIn, 15);
	}
	
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.time_wrap.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));	
	}
}

class Chronoshift extends AbilityBase {
	public Chronoshift() {
		super("chronoshift");
	}
	
	protected void rightClickAction(@Nullable World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack totemOfUndying = new ItemStack(Items.TOTEM_OF_UNDYING);
		
		if (checkForItemInInventory(totemOfUndying, playerIn.inventory)) {
	        playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
	    } else {
	        playerIn.inventory.addItemStackToInventory(totemOfUndying); 
	        addItemCooldown(playerIn, 120);
	    }
	}
	
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.chronoshift.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.120_seconds_cooldown"));	
	}
}

public class Zilean extends ChampionBase {
	public Zilean(Item.Properties prop) {
		super("zilean", prop);
		ABILITIES.add(new TimeBomb());
		ABILITIES.add(new Rewind());
		ABILITIES.add(new TimeWrap());
		ABILITIES.add(new Chronoshift());
	}
}
