package com.gmail.seanduffy797.dungeon.Items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GladiatorWeapons {

    public static ItemStack gladius;
    public static ItemStack rudis;
    public static ItemStack sica;
    public static ItemStack reflexBow;
    public static ItemStack palmBranch;

    public static void init() {
        createGladius();
        createRudis();
        createSica();
        createReflexBow();
        createPalmBranch();
    }

    public static ItemStack createGladius() {
        gladius = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = gladius.getItemMeta();
        meta.displayName(Component.text("Gladius"));
        gladius.setItemMeta(meta);
        return gladius;
    }
    public static ItemStack createRudis() {
        rudis = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = rudis.getItemMeta();
        meta.displayName(Component.text("Rudis"));
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
        rudis.setItemMeta(meta);
        return rudis;
    }
    public static ItemStack createSica() {
        sica = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta meta = sica.getItemMeta();
        meta.displayName(Component.text("Sica"));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,
                new AttributeModifier("Speed", 2, AttributeModifier.Operation.ADD_NUMBER));
        sica.setItemMeta(meta);
        return sica;
    }
    public static ItemStack createReflexBow() {
        reflexBow = new ItemStack(Material.BOW);
        ItemMeta meta = reflexBow.getItemMeta();
        meta.displayName(Component.text("Reflex Bow"));
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH,
                new AttributeModifier("Health", -4, AttributeModifier.Operation.ADD_NUMBER));
        reflexBow.setItemMeta(meta);
        return reflexBow;
    }
    public static ItemStack createPalmBranch() {
        palmBranch = new ItemStack(Material.BAMBOO);
        ItemMeta meta = palmBranch.getItemMeta();
        meta.displayName(Component.text("Palm Branch"));
        palmBranch.setItemMeta(meta);
        return palmBranch;
    }
}
