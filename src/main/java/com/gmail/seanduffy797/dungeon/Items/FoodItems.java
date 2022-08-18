package com.gmail.seanduffy797.dungeon.Items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class FoodItems {

    public static ItemStack createRareSteak() {
        ItemStack rareSteak = new ItemStack(Material.BEEF);
        ItemMeta meta = rareSteak.getItemMeta();
        meta.displayName(Component.text("Specialty Steak"));
        rareSteak.setItemMeta(meta);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Extra Rare").color(NamedTextColor.GOLD));
        rareSteak.lore(lore);
        return rareSteak;
    }
    public static ItemStack createJeremiahsSoup() {
        ItemStack soup = new ItemStack(Material.BEETROOT_SOUP);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Prepared with love").color(NamedTextColor.GOLD));
        soup.lore(lore);
        return soup;
    }
}
