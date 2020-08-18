package com.zhpeng.Items;

import java.util.List;

import javax.annotation.Nullable;

import com.zhpeng.Champions.AbilityBase;
import com.zhpeng.Champions.ChampionBase;
import com.zhpeng.Champions.Champions;
import com.zhpeng.SummonerSpells.SpellBase;
import com.zhpeng.SummonerSpells.SummonerSpells;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AbilityRefresh extends ItemsBase {
	public AbilityRefresh() {
		super("ability_refresh");
		this.maxStackSize = 64;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
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
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	};
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.ability_refresh.tooltip"));
	}
}
