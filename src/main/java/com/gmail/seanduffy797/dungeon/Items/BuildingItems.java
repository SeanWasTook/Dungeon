package com.gmail.seanduffy797.dungeon.Items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class BuildingItems {

    public static ItemStack chiseledStonePick;

    public static void init() {
        createChiseledStonePick();
    }

    public static ItemStack createChiseledStonePick() {
        chiseledStonePick = new ItemStack(Material.GOLDEN_PICKAXE);
        Damageable meta = (Damageable) chiseledStonePick.getItemMeta();
        meta.setDestroyableKeys(Collections.singletonList(Material.CHISELED_STONE_BRICKS.getKey()));
        meta.setDamage(31);
        meta.displayName(Component.text("Chiseled Stone Brick Pick"));
        chiseledStonePick.setItemMeta(meta);
        return chiseledStonePick;
    }

}
