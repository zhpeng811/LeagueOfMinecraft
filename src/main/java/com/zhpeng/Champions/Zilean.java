package com.zhpeng.Champions;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

class TimeBomb extends AbilityBase {
	public TimeBomb() {
		super("time_bomb");
	}

	protected void rightClickAction(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
//		EntitySnowball entitysnowball = new EntitySnowball(worldIn, playerIn);
//        entitysnowball.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
//        worldIn.spawnEntity(entitysnowball);
//		EntityTNT entityTNT = new EntityTNT(worldIn, playerIn);
//		entityTNT.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
//		worldIn.spawnEntity(new EntityTNTPrimed(worldIn));
		BlockPos pos = playerIn.getPosition();
		EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldIn, (double) ((float) pos.getX() + 0.5F),
				(double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), playerIn);
		worldIn.spawnEntity(entitytntprimed);
		worldIn.playSound((EntityPlayer) null, entitytntprimed.posX, entitytntprimed.posY, entitytntprimed.posZ,
				SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
		addItemCooldown(playerIn, 15);
	}

	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.time_bomb.tooltip"));
		tooltip.add(I18n.translateToLocal("tooltip.15_seconds_cooldown"));
	}

//	private class EntityTNT extends EntityTNTPrimed {
//	   public EntityTNT(World worldIn) {
//		   super(worldIn);
//	   }
//
//	   public EntityTNT(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
//	       super(worldIn, x, y,z, igniter);
//	   }
//	}
}

public class Zilean extends ChampionBase {
	public Zilean() {
		super("zilean");
		ABILITIES.add(new TimeBomb());
	}
}
