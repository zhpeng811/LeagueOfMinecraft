package com.zhpeng.Champions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.Utils.Constants;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

class Consume extends AbilityBase {
	public Consume() {
		super("consume");
	}
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack damagePotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), Potions.STRONG_HARMING);
		ItemStack healingPotion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.STRONG_HEALING);
		
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
	    	playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
	    } else {
	        addItemCooldown(playerIn, 20);
	    }
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.consume.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.20_seconds_cooldown"));
	}
}

class BiggestSnowballEver extends AbilityBase {
	public BiggestSnowballEver() {
		super("biggest_snowball_ever");
	}
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		addPotionEffect(playerIn, Effects.SPEED, 5, 3);
        addItemCooldown(playerIn, 15);
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.biggest_snowball_ever.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.15_seconds_cooldown"));
	}
}

class SnowballBarrage extends AbilityBase {
	public SnowballBarrage() {
		super("snowball_barrage");
	}
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
        EntityDamageSnowball snowballentity = new EntityDamageSnowball(worldIn, playerIn);
        snowballentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.addEntity(snowballentity);
        addItemCooldown(playerIn, 3);
	} 

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.snowball_barrage.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.3_seconds_cooldown"));
	}
	
	private class EntityDamageSnowball extends SnowballEntity {
		public EntityDamageSnowball(World worldIn, LivingEntity throwerIn) {
	        super(worldIn, throwerIn);
	    }
		
		@Override
		protected void onImpact(RayTraceResult result) {
	        if (result.getType() == RayTraceResult.Type.ENTITY) {
	        	Entity entityHit = ((EntityRayTraceResult)result).getEntity();
	            entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4.0F);
	            if (entityHit instanceof PlayerEntity) {
	            	((PlayerEntity) entityHit).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 2 * Constants.ticksPerSecond, 2));
	            }
	        }

	        if (!this.world.isRemote) {
	            this.world.setEntityState(this, (byte)3);
	            this.remove();
	        }
	    }
	}
}

class AbsoluteZero extends AbilityBase {
	public AbsoluteZero() {
		super("absolute_zero");
	}
	
	protected void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack splashPotion = new ItemStack(Items.SPLASH_POTION);
		ArrayList<EffectInstance> effects = new ArrayList<>();
		int ticksPerSecond = Constants.ticksPerSecond;
		effects.add(new EffectInstance(Effects.INSTANT_DAMAGE, 1 * ticksPerSecond , 1));
		effects.add(new EffectInstance(Effects.WITHER, 10 * ticksPerSecond , 3));
		effects.add(new EffectInstance(Effects.SLOWNESS, 10 * ticksPerSecond , 3));
		ItemStack customPotion = PotionUtils.appendEffects(splashPotion, effects);

		if (checkForItemInInventory(customPotion, playerIn.inventory)) {
			playerIn.sendMessage(new TranslationTextComponent("message.already_obtained"));
		} else {
		    playerIn.inventory.addItemStackToInventory(customPotion); 
		    addItemCooldown(playerIn, 120);
		}
	}

	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.absolute_zero.tooltip"));
		tooltip.add(new TranslationTextComponent("tooltip.120_seconds_cooldown"));
	}
}

public class Nunu extends ChampionBase {
	public Nunu(Item.Properties prop) {
		super("nunu", prop);
		ABILITIES.add(new Consume());
		ABILITIES.add(new BiggestSnowballEver());
		ABILITIES.add(new SnowballBarrage());
		ABILITIES.add(new AbsoluteZero());
	}
}
