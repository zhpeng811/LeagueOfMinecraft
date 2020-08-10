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
	
	// the armor/magic resist in lol * armorRatio = armor in minecraft
	// e.g. cloth armor +15 armor in lol
	// so in minecraft it will be 15*0.1 = 1.5 armor
	public static final float armorRatio = 0.1F;
	
	public static void addAllArmors() {
		addArmor(
				"cloth_armor", 
				"minecraftlegends:cloth_armor", 
				300, 
				new int[]{ 0, 0, (int) (15 * armorRatio), 0 }, 
				0, 
				0.0F, 
				SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 
				EntityEquipmentSlot.CHEST
		);
		addArmor(
				"null_magic_mantle",
				"minecraftlegends:null_magic_mantle",
				450,
				new int[]{ 0, (int) (25 * armorRatio), 0, 0 },
				0,
				0.0F,
				SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 
				EntityEquipmentSlot.LEGS
		);
		
	}
	
	/** 
	 * 
	 * @param {String} name - name of the armor
	 * @param {String} textureName - texture name of the armor, require the mod id prefix
	 * @param {int} durability - armor durability 
	 * @param {int[]} reductionAmounts - an int array of length 4, indexing mapping below:
	 * 						   		   * index 0 - boot
	 *                                 * index 1 - leg
	 *                                 * index 2 - chest
	 *                                 * index 3 - head
	 * @param enchantability
	 * @param toughness
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
