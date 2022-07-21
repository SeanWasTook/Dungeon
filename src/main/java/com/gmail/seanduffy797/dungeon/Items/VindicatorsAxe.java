package com.gmail.seanduffy797.dungeon.Items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class VindicatorsAxe {

    public static ItemStack vindicatorsAxe;

    public static void init() { createAxe();}

    public static ItemStack createAxe() {
        vindicatorsAxe = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = vindicatorsAxe.getItemMeta();
        meta.displayName(Component.text("Vindicator's Axe"));
        meta.setDestroyableKeys(Collections.singletonList(Material.DARK_OAK_LOG.getKey()));
        vindicatorsAxe.setItemMeta(meta);
        return vindicatorsAxe;
    }
}
