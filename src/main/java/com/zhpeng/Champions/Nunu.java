package com.zhpeng.Champions;

import java.util.ArrayList;
import java.util.List;

import com.zhpeng.Utils.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

class Consume extends AbilityBase {
	public Consume() {
		super("consume");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack damagePotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), PotionTypes.STRONG_HARMING);
		ItemStack healingPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.STRONG_HEALING);
		
		int itemExistCount = 0;
	    if (checkForItemInInventory(damagePotion, playerIn.inventory)) {
	    	itemExistCount++;
	    } else {
	    	playerIn.inventory.addItemStackToInventory(damagePotion); 
	    }
	    if (checkForItemInInventory(healingPotion, playerIn.inventory)) {
	    	itemExistCount++;
	    } else {
	    	playerIn.inventory.addItemStackToInventory(healingPotion); 
	    } 
	    
	    if (itemExistCount == 2) {
	    	playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
	    } else {
	        addItemCooldown(playerIn, 20);
	    }
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.consume.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.20_seconds_cooldown"));
	}
}

class BiggestSnowballEver extends AbilityBase {
	public BiggestSnowballEver() {
		super("biggest_snowball_ever");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		addPotionEffect(playerIn, MobEffects.SPEED, 5, 3);
        addItemCooldown(playerIn, 15);
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.biggest_snowball_ever.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
	}
}

class SnowballBarrage extends AbilityBase {
	public SnowballBarrage() {
		super("snowball_barrage");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		EntityDamageSnowball entitysnowball = new EntityDamageSnowball(worldIn, playerIn);
        entitysnowball.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.spawnEntity(entitysnowball);
        addItemCooldown(playerIn, 3);
	} 

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.snowball_barrage.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.3_seconds_cooldown"));
	}
	
	private class EntityDamageSnowball extends EntitySnowball {
		public EntityDamageSnowball(World worldIn, EntityLivingBase throwerIn) {
	        super(worldIn, throwerIn);
	    }
		
		@Override
		protected void onImpact(RayTraceResult result) {
			Entity entityHit = result.entityHit;
	        if (entityHit != null) {
	            entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4.0F);
	            if (entityHit instanceof EntityPlayer) {
	            	((EntityPlayer) entityHit).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 2 * Constants.ticksPerSecond, 2));
	            }
	        }

	        if (!this.world.isRemote) {
	            this.world.setEntityState(this, (byte)3);
	            this.setDead();
	        }
	    }
	}
}

class AbsoluteZero extends AbilityBase {
	public AbsoluteZero() {
		super("absolute_zero");
	}
	
	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<PotionEffect> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1 * ticksPerSecond , 1));
		effects.add(new PotionEffect(MobEffects.WITHER, 10 * ticksPerSecond , 3));
		effects.add(new PotionEffect(MobEffects.SLOWNESS, 10 * ticksPerSecond , 3));
		ItemStack customPotion = PotionUtils.appendEffects(splashPotion, effects);

		if (checkForItemInInventory(customPotion, playerIn.inventory)) {
			playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("message.already_obtained")));
		} else {
		    playerIn.inventory.addItemStackToInventory(customPotion); 
		    addItemCooldown(playerIn, 120);
		}
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.absolute_zero.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.120_seconds_cooldown"));
	}
}

public class Nunu extends ChampionBase {
	public Nunu() {
		super("nunu");
		ABILITIES.add(new Consume());
		ABILITIES.add(new BiggestSnowballEver());
		ABILITIES.add(new SnowballBarrage());
		ABILITIES.add(new AbsoluteZero());
	}
}
