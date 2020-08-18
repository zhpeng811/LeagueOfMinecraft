package com.zhpeng.Armors;

import java.util.ArrayList;

import com.zhpeng.Utils.Constants;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class Armors {
	public static final ArrayList<Item> ARMORS = new ArrayList<>();
	
	public static void addAllArmors() {
		float armorRatio = Constants.armorRatio;
		float powerToArmorRatio = Constants.powerToArmorRatio;
		float unfinishedArmorToughness = Constants.unfinishedArmorToughness;
		float finishedArmorToughness = Constants.finishedArmorToughness;
		float healthRatio = Constants.healthRatio;
		float speedRatio = Constants.speedRatio;
		int armorDurability = Constants.armorDurability;
		int unfinishedItemEnchantability = Constants.unfinishedItemEnchantability;
		int finishedItemEnchantability = Constants.finishedItemEnchantability;
		
		// unfinished armor
		addArmor(
				"cloth_armor", 
				"minecraftlegends:cloth_armor", 
				armorDurability, 
				new int[] { 0, 0, (int) (15 * armorRatio), 0 }, 
				unfinishedItemEnchantability, 
				unfinishedArmorToughness, 
				SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 
				EntityEquipmentSlot.CHEST,
				0F * healthRatio
		);
		addArmor(
				"null_magic_mantle",
				"minecraftlegends:null_magic_mantle",
				armorDurability,
				new int[] { 0, (int) (25 * armorRatio), 0, 0 },
				unfinishedItemEnchantability,
				unfinishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 
				EntityEquipmentSlot.LEGS,
				0F * healthRatio
		);
		addArmor(
				"spectre_cowl", 
				"minecraftlegends:spectre_cowl", 
				armorDurability, 
				new int[] { 0, 0, 0, (int) (25 * armorRatio) }, 
				unfinishedItemEnchantability, 
				unfinishedArmorToughness, 
				SoundEvents.ITEM_ARMOR_EQUIP_IRON, 
				EntityEquipmentSlot.HEAD,
				250F * healthRatio
		);
		addArmor(
				"bramble_vest", 
				"minecraftlegends:bramble_vest", 
				armorDurability, 
				new int[] { 0, 0, (int) (35 * armorRatio), 0}, 
				unfinishedItemEnchantability, 
				unfinishedArmorToughness, 
				SoundEvents.ITEM_ARMOR_EQUIP_IRON, 
				EntityEquipmentSlot.CHEST,
				0F * healthRatio
		);
		addArmor(
				"warden_mail", 
				"minecraftlegends:warden_mail", 
				armorDurability, 
				new int[] { 0, 0, (int) (40 * armorRatio), 0}, 
				unfinishedItemEnchantability, 
				unfinishedArmorToughness, 
				SoundEvents.ITEM_ARMOR_EQUIP_IRON, 
				EntityEquipmentSlot.CHEST,
				0F * healthRatio
		);
		addArmor(
				"giant_belt",
				"minecraftlegends:giant_belt",
				armorDurability,
				new int[] { 0, 0, 0, 0},
				unfinishedItemEnchantability, 
				unfinishedArmorToughness, 
				SoundEvents.ITEM_ARMOR_EQUIP_IRON,
				EntityEquipmentSlot.LEGS,
				380F * healthRatio
		);
		addArmor(
				"haunting_guise",
				"minecraftlegends:haunting_guise",
				armorDurability,
				new int[] { 0, 0, 0, (int) (35 * powerToArmorRatio)},
				unfinishedItemEnchantability, 
				unfinishedArmorToughness, 
				SoundEvents.ITEM_ARMOR_EQUIP_IRON,
				EntityEquipmentSlot.HEAD,
				200F * healthRatio
		);
		addArmor(
				"boots_of_speed",
				"minecraftlegends:boots_of_speed",
				armorDurability,
				new int[] { 0, 0, 0, 0},
				unfinishedItemEnchantability, 
				unfinishedArmorToughness, 
				SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
				EntityEquipmentSlot.FEET,
				0F * healthRatio,
				25F * speedRatio
		);
		
		
		// finished armor
		addArmor(
				"adaptive_helm",
				"minecraftlegends:adaptive_helm",
				armorDurability,
				new int[] { 0, 0, 0, (int) (55 * armorRatio) },
				finishedItemEnchantability,
				finishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 
				EntityEquipmentSlot.HEAD,
				350F * healthRatio
		);	
		addArmor(
				"spirit_visage",
				"minecraftlegends:spirit_visage",
				armorDurability,
				new int[] { 0, 0, (int) (55 * armorRatio) },
				finishedItemEnchantability,
				finishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
				EntityEquipmentSlot.CHEST,
				450F * healthRatio
		);
		addArmor(
				"thornmail",
				"minecraftlegends:thornmail",
				armorDurability,
				new int[] { 0, 0, (int) (80 * armorRatio) },
				finishedItemEnchantability,
				finishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
				EntityEquipmentSlot.CHEST,
				250F * healthRatio
		);
		addArmor(
				"warmog_armor",
				"minecraftlegends:warmog_armor",
				armorDurability,
				new int[] { 0, 0, 0, 0 },
				finishedItemEnchantability,
				finishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
				EntityEquipmentSlot.CHEST,
				800F * healthRatio
		);
		addArmor(
				"liandry_torment",
				"minecraftlegends:liandry_torment",
				armorDurability,
				new int[] { 0, 0, 0, (int) (75 * powerToArmorRatio) },
				finishedItemEnchantability,
				finishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
				EntityEquipmentSlot.HEAD,
				300F * healthRatio
		);
		addArmor(
				"rabadon_deathcap",
				"minecraftlegends:rabadon_deathcap",
				armorDurability,
				new int[] { 0, 0, 0, (int) (120 * powerToArmorRatio) },
				finishedItemEnchantability,
				finishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
				EntityEquipmentSlot.HEAD,
				0F * healthRatio
		);
		addArmor(
				"mercury_treads",
				"minecraftlegends:mercury_treads",
				armorDurability,
				new int[] { (int) (25 * armorRatio), 0, 0, 0 },
				finishedItemEnchantability,
				finishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
				EntityEquipmentSlot.FEET,
				0F * healthRatio,
				45F * speedRatio
		);
		addArmor(
				"boots_of_swiftness",
				"minecraftlegends:boots_of_swiftness",
				armorDurability,
				new int[] { 0, 0, 0, 0 },
				finishedItemEnchantability,
				finishedArmorToughness,
				SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
				EntityEquipmentSlot.FEET,
				0F * healthRatio,
				60F * speedRatio
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
		EntityEquipmentSlot equipmentSlotIn,
		float addedMaxHealth
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
		Item armor = new CustomArmor(material, 1, equipmentSlotIn, name, addedMaxHealth);
		ARMORS.add(armor);
	}
	
	private static void addArmor(
			String name,
			String textureName,
			int durability,
			int[] reductionAmounts,
			int enchantability,
			float toughness,
			SoundEvent soundOnEquip,
			EntityEquipmentSlot equipmentSlotIn,
			float addedMaxHealth,
			float movementSpeed
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
			Item armor = new CustomArmor(material, 1, equipmentSlotIn, name, addedMaxHealth, movementSpeed);
			ARMORS.add(armor);
	}
}
