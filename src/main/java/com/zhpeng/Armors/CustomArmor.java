package com.zhpeng.Armors;

import java.util.UUID;

import com.google.common.collect.Multimap;
import com.zhpeng.MinecraftLegends;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class CustomArmor extends ItemArmor {
	
	private float addedMaxHealth;
	private float addedMovementSpeed;
	
	private static final UUID[] ARMOR_MODIFIERS = new UUID[] { UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150") };
	public CustomArmor(ItemArmor.ArmorMaterial material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name, float addedMaxHealth) {
		super(material, renderIndexIn, equipmentSlotIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MinecraftLegends.creativeTabArmors);
		this.addedMaxHealth = addedMaxHealth;
		
	}
	
	public CustomArmor(ItemArmor.ArmorMaterial material, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name, float addedMaxHealth, float movementSpeed) {
		this(material, renderIndexIn, equipmentSlotIn, name, addedMaxHealth);
		this.addedMovementSpeed = movementSpeed;
	}
	
	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == this.armorType) {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor modifier", (double)this.damageReduceAmount, 0));
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor toughness", (double)this.toughness, 0));
            if (addedMaxHealth != 0.0F) {
            	multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor health", (double)this.addedMaxHealth, 0));            	
            }
            if (addedMovementSpeed != 0.0F) {
            	multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor movement speed", (double)this.addedMovementSpeed, 0));            	
            }
        }

        return multimap;
    }
}

