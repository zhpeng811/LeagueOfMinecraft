package com.zhpeng.Armors;

import java.util.UUID;

import com.google.common.collect.Multimap;
import com.zhpeng.MinecraftLegends;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class ArmorBase extends ArmorItem {
	
	private Armors armorMaterial;
	
	private static final UUID[] ARMOR_MODIFIERS = new UUID[] { UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150") };
	
	public ArmorBase(Armors armorMaterial) {
		super(armorMaterial, armorMaterial.getSlot(), new Item.Properties().group(MinecraftLegends.creativeTabArmors));
		this.armorMaterial = armorMaterial;
	}
	
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);

        if (equipmentSlot == this.slot) {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor modifier", (double)this.damageReduceAmount, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor toughness", (double)this.toughness, AttributeModifier.Operation.ADDITION));
            if (armorMaterial.getAddedMaxHealth() != 0.0F) {
            	multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor health", (double)armorMaterial.getAddedMaxHealth(), AttributeModifier.Operation.ADDITION));            	
            }
            if (armorMaterial.getAddedSpeed() != 0.0F) {
            	multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor movement speed", (double)armorMaterial.getAddedSpeed(), AttributeModifier.Operation.MULTIPLY_TOTAL));            	
            }
        }

        return multimap;
    }
}

