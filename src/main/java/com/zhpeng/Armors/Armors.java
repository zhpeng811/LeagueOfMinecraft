package com.zhpeng.Armors;

import java.util.ArrayList;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class Armors {
	public static final ArrayList<Item> ARMORS = new ArrayList<>();
	
	// the armor/magic resist added in league * armorRatio = armor in minecraft
	// e.g. cloth armor +15 armor in league
	// so in minecraft it will be 15*0.1 = 1.5 armor
	public static final float armorRatio = 0.1F;
	
	// until we are adding maximum health into the game, health in league will be used for toughness ratio
	// the health added in lol * toughnessRatio = toughness in minecraft
	// e.g. adaptive helm +350 health in league
	// so in minecraft it will be 350*00.1 = 3.5 armor toughness
	public static final float toughnessRatio = 0.01F;
	
	public static void addAllArmors() {
		addArmor(
				"cloth_armor", 
				"minecraftlegends:cloth_armor", 
				300, 
				new int[]{ 0, 0, (int) (15 * armorRatio), 0 }, 
				0, 
				0.0F * toughnessRatio, 
				SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 
				EntityEquipmentSlot.CHEST
		);
		addArmor(
				"null_magic_mantle",
				"minecraftlegends:null_magic_mantle",
				450,
				new int[]{ 0, (int) (25 * armorRatio), 0, 0 },
				0,
				0.0F * toughnessRatio,
				SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 
				EntityEquipmentSlot.LEGS
		);
		addArmor(
				"spectre_cowl", 
				"minecraftlegends:spectre_cowl", 
				1200, 
				new int[]{ 0, 0, 0, (int) (25 * armorRatio) }, 
				0, 
				250F * toughnessRatio, 
				SoundEvents.ITEM_ARMOR_EQUIP_IRON, 
				EntityEquipmentSlot.HEAD
		);
		addArmor(
				"adaptive_helm",
				"minecraftlegends:adaptive_helm",
				2800,
				new int[]{ 0, 0, 0, (int) (55 * armorRatio) },
				0,
				350F * toughnessRatio,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 
				EntityEquipmentSlot.HEAD
		);	
	}
	
	/** 
	 * 
	 * @param {String} name - name of the armor
	 * @param {String} textureName - texture name of the armor, require the mod id prefix
	 * @param {int} durability - armor durability, will equal to the cost of item in league 
	 * @param {int[]} reductionAmounts - an int array of length 4, indexing mapping below:
	 * 						   		   - 0 - boot, 1 - leg, 2 - chest, 3 - head
	 *                                 - to see how armor amount is determined, see "armorRatio" attribute
	 * @param enchantability - set as not enchantable for all armor
	 * @param toughness - armor toughness, to see how armor toughness is determined, see "toughnessRatio" attribute
	 * @param soundOnEquip
	 * @param equipmentSlotIn
	 */
	private static void addArmor(
		String name,
		String textureName,
		int durability,
		int[] reductionAmounts,
		int enchantability,
		float toughness,
		SoundEvent soundOnEquip,
		EntityEquipmentSlot equipmentSlotIn
	) {
		ArmorMaterial material = EnumHelper.addArmorMaterial(
				name, 
				textureName, 
				durability, 
				reductionAmounts, 
				enchantability, 
				soundOnEquip, 
				toughness
		);
		Item armor = new CustomArmor(material, 1, equipmentSlotIn, name);
		ARMORS.add(armor);
	}
}
