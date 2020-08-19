package com.zhpeng.Armors;

import com.zhpeng.Utils.Constants;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum Armors implements IArmorMaterial {
	// unfinished armors
	CLOTH_ARMOR(
			"cloth_armor", 
			Constants.armorDurability, 
			new int[] { 0, 0, (int) (15 * Constants.armorRatio), 0 }, 
			Constants.unfinishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 
			Constants.unfinishedArmorToughness,
			EquipmentSlotType.CHEST,
			0F * Constants.healthRatio
	),
	NULL_MAGIC_MANTLE(
			"null_magic_mantle",
			Constants.armorDurability,
			new int[] { 0, (int) (25 * Constants.armorRatio), 0, 0 },
			Constants.unfinishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 
			Constants.unfinishedArmorToughness,
			EquipmentSlotType.LEGS,
			0F * Constants.healthRatio
	),
	SPECTRE_COWL(
			"spectre_cowl", 
			Constants.armorDurability,
			new int[] { 0, 0, 0, (int) (25 * Constants.armorRatio) }, 
			Constants.unfinishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_IRON,
			Constants.unfinishedArmorToughness,
			EquipmentSlotType.HEAD,
			250F * Constants.healthRatio
	),
	BRAMBLE_VEST(
			"bramble_vest", 
			Constants.armorDurability, 
			new int[] { 0, 0, (int) (35 * Constants.armorRatio), 0}, 
			Constants.unfinishedItemEnchantability, 
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 
			Constants.unfinishedArmorToughness, 
			EquipmentSlotType.CHEST,
			0F * Constants.healthRatio
	),
	WARDEN_MAIL(
			"warden_mail", 
			Constants.armorDurability, 
			new int[] { 0, 0, (int) (40 * Constants.armorRatio), 0}, 
			Constants.unfinishedItemEnchantability, 
			SoundEvents.ITEM_ARMOR_EQUIP_IRON, 
			Constants.unfinishedArmorToughness, 
			EquipmentSlotType.CHEST,
			0F * Constants.healthRatio
	),
	GIANT_BELT(
			"giant_belt",
			Constants.armorDurability,
			new int[] { 0, 0, 0, 0},
			Constants.unfinishedItemEnchantability, 
			SoundEvents.ITEM_ARMOR_EQUIP_IRON,
			Constants.unfinishedArmorToughness, 
			EquipmentSlotType.LEGS,
			380F * Constants.healthRatio
	),
	HAUNTING_GUISE(
			"haunting_guise",
			Constants.armorDurability,
			new int[] { 0, 0, 0, (int) (35 * Constants.powerToArmorRatio)},
			Constants.unfinishedItemEnchantability, 
			SoundEvents.ITEM_ARMOR_EQUIP_IRON,
			Constants.unfinishedArmorToughness, 
			EquipmentSlotType.HEAD,
			200F * Constants.healthRatio
	),
	BOOTS_OF_SPEED(
			"boots_of_speed",
			Constants.armorDurability,
			new int[] { 0, 0, 0, 0},
			Constants.unfinishedItemEnchantability, 
			SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
			Constants.unfinishedArmorToughness, 
			EquipmentSlotType.FEET,
			0F * Constants.healthRatio,
			0.25F
	),
	
	// finished armor
	ADAPTIVE_HELM(
			"adaptive_helm",
			Constants.armorDurability,
			new int[] { 0, 0, 0, (int) (55 * Constants.armorRatio) },
			Constants.finishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 
			Constants.finishedArmorToughness,
			EquipmentSlotType.HEAD,
			350F * Constants.healthRatio
	),
	SPIRIT_VISAGE(
			"spirit_visage",
			Constants.armorDurability,
			new int[] { 0, 0, (int) (55 * Constants.armorRatio) },
			Constants.finishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			Constants.finishedArmorToughness,
			EquipmentSlotType.CHEST,
			450F * Constants.healthRatio
	),
	THORNMAIL(
			"thornmail",
			Constants.armorDurability,
			new int[] { 0, 0, (int) (80 * Constants.armorRatio) },
			Constants.finishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			Constants.finishedArmorToughness,
			EquipmentSlotType.CHEST,
			250F * Constants.healthRatio
	),
	WARMOG_ARMOR(
			"warmog_armor",
			Constants.armorDurability,
			new int[] { 0, 0, 0, 0 },
			Constants.finishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			Constants.finishedArmorToughness,
			EquipmentSlotType.CHEST,
			800F * Constants.healthRatio
	),
	LIANDRY_TORMENT(
			"liandry_torment",
			Constants.armorDurability,
			new int[] { 0, 0, 0, (int) (75 * Constants.powerToArmorRatio) },
			Constants.finishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			Constants.finishedArmorToughness,
			EquipmentSlotType.HEAD,
			300F * Constants.healthRatio
	),
	RABADON_DEATHCAP(
			"rabadon_deathcap",
			Constants.armorDurability,
			new int[] { 0, 0, 0, (int) (120 * Constants.powerToArmorRatio) },
			Constants.finishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			Constants.finishedArmorToughness,
			EquipmentSlotType.HEAD,
			0F * Constants.healthRatio
	),
	MERCURY_TREADS(
			"mercury_treads",
			Constants.armorDurability,
			new int[] { (int) (25 * Constants.armorRatio), 0, 0, 0 },
			Constants.finishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			Constants.finishedArmorToughness,
			EquipmentSlotType.FEET,
			0F * Constants.healthRatio,
			0.45F
	),
	BOOTS_OF_SWIFTNESS(
			"boots_of_swiftness",
			Constants.armorDurability,
			new int[] { 0, 0, 0, 0 },
			Constants.finishedItemEnchantability,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
			Constants.finishedArmorToughness,
			EquipmentSlotType.FEET,
			0F * Constants.healthRatio,
			0.60F
	);
	
	
	private final String name;
    private final int durability;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private float addedMovementSpeed = 0;
    private EquipmentSlotType slot;
    private float addedHealth;
    
    Armors(String name, int durability, int[] damageReduction, int enchantability, SoundEvent sound, float toughness, EquipmentSlotType slot, float addedHealth) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmountArray = damageReduction;
        this.enchantability = enchantability;
        this.soundEvent = sound;
        this.toughness = toughness;
        this.slot = slot;
        this.addedHealth = addedHealth;
    }
    
    Armors(String name, int durability, int[] damageReduction, int enchantability, SoundEvent sound, float toughness, EquipmentSlotType slot, float addedHealth, float speed) {
    	this(name, durability, damageReduction, enchantability, sound, toughness, slot, addedHealth);
    	this.addedMovementSpeed = speed;
    }
    
    public int getDurability() {
        return this.durability;
    }

    public int getDamageReductionAmount() {
    	for (int i : this.damageReductionAmountArray) {
    		if (i != 0) {
    			return i;
    		}
    	}
        return 0;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }
    
    public Ingredient getRepairMaterial() {
    	return Ingredient.fromItems(Items.DIAMOND);
    }

	public int getDurability(EquipmentSlotType slotIn) {
		return this.durability;
	}

	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		for (int i : this.damageReductionAmountArray) {
    		if (i != 0) {
    			return i;
    		}
    	}
        return 0;
	}
	
	public int getEnchantability() {
		return this.enchantability;
	}
	
	public EquipmentSlotType getSlot() {
		return this.slot;
	}
	
	public float getAddedSpeed() {
		return this.addedMovementSpeed;
	}
	
	public float getAddedMaxHealth() {
		return this.addedHealth;
	}
}
