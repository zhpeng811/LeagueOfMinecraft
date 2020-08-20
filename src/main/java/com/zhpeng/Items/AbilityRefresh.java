package com.zhpeng.Items;

import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.Champions.AbilityBase;
import com.zhpeng.Champions.ChampionBase;
import com.zhpeng.Champions.Champions;
import com.zhpeng.SummonerSpells.SpellBase;
import com.zhpeng.SummonerSpells.SummonerSpells;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AbilityRefresh extends ItemsBase {
	public AbilityRefresh() {
		super();
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		
		if (!worldIn.isRemote) {
			for (ChampionBase champion : Champions.CHAMPIONS) {
				for (Item ability : champion.ABILITIES) {
					((AbilityBase) ability).removeItemCooldown(playerIn, ability);
				}
			}
			for (Item spell : SummonerSpells.SPELLS) {
				((SpellBase) spell).removeItemCooldown(playerIn, spell);
			}
			stack.shrink(1);
	    }
		return ActionResult.resultPass(stack);
	};
	
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("item.minecraftlegends.ability_refresh.tooltip"));
	}
}
