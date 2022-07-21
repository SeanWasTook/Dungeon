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
    public static ItemStack arachnicide;
    public static ItemStack achillobator;

    public static void init() {
        createGuardBow();
        createArachnicide();
        createAchillobator();
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
        lore.add(Component.text("Adept at clearing cobwebs too").color(NamedTextColor.GOLD));
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
}
