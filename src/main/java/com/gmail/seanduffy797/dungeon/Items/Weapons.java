package com.gmail.seanduffy797.dungeon.Items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Weapons {

    public static ItemStack guardBow;
    public static ItemStack pillagerCrossbow;
    public static ItemStack arachnicide;
    public static ItemStack achillobator;
    public static ItemStack brunhildesFury;

    public static void init() {
        createGuardBow();
        createArachnicide();
        createAchillobator();
        createPillagerCrossbow();
    }

    public static ItemStack createGuardBow() {
        guardBow = new ItemStack(Material.BOW);
        ItemMeta meta = guardBow.getItemMeta();
        meta.displayName(Component.text("Guard Bow"));
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
        guardBow.setItemMeta(meta);
        return guardBow;
    }
    public static ItemStack createArachnicide() {
        arachnicide = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta meta = arachnicide.getItemMeta();
        meta.displayName(Component.text("Arachnicide"));
        int rnd = new Random().nextInt(7);
        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, rnd + 1, true);
        meta.setDestroyableKeys(Collections.singletonList(Material.COBWEB.getKey()));
        arachnicide.setItemMeta(meta);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Adept at clearing cobwebs").color(NamedTextColor.GOLD));
        arachnicide.lore(lore);
        return arachnicide;
    }
    public static ItemStack createAchillobator() {
        achillobator = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta meta = achillobator.getItemMeta();
        meta.displayName(Component.text("Achillobator"));
        int rnd = new Random().nextInt(7);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, rnd + 1, true);
        achillobator.setItemMeta(meta);
        return achillobator;
    }
    public static ItemStack createPillagerCrossbow() {
        pillagerCrossbow = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = pillagerCrossbow.getItemMeta();
        meta.displayName(Component.text("Raiding Crossbow"));
        pillagerCrossbow.setItemMeta(meta);
        return pillagerCrossbow;
    }
    public static ItemStack createBrunhildesFury() {
        brunhildesFury = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = brunhildesFury.getItemMeta();
        meta.displayName(Component.text("Brunhilde's Fury"));
        meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        brunhildesFury.setItemMeta(meta);
        return brunhildesFury;
    }
    public static ItemStack createAncientGoldAxe() {
        ItemStack ancientGoldAxe = new ItemStack(Material.GOLDEN_AXE);
        ItemMeta meta = ancientGoldAxe.getItemMeta();
        meta.setUnbreakable(true);
        meta.displayName(Component.text("Ancient Gold Axe"));
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 3, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        ancientGoldAxe.setItemMeta(meta);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Passed down in Sette's family for generations").color(NamedTextColor.GOLD));
        ancientGoldAxe.lore(lore);
        return ancientGoldAxe;
    }
}
