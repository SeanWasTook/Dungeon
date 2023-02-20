package com.gmail.seanduffy797.dungeon.Items;

import com.destroystokyo.paper.Namespaced;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Items.management.ItemManager;
import com.gmail.seanduffy797.dungeon.Items.management.Rarity;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTStringList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;

public class Placeables {

    public static ItemStack createRails() {
        ItemStack rails = new ItemStack(Material.RAIL);
        ItemMeta meta = rails.getItemMeta();
        ArrayList<Namespaced> keys = new ArrayList<>(DungeonManager.commonBlocks);
        meta.setPlaceableKeys(keys);
        rails.setItemMeta(meta);
        ItemManager.addRarity(rails, Rarity.COMMON);
        return rails;
    }

    public static ItemStack createPoweredRails() {
        ItemStack rails = new ItemStack(Material.POWERED_RAIL);
        ItemMeta meta = rails.getItemMeta();
        ArrayList<Namespaced> keys = new ArrayList<>(DungeonManager.commonBlocks);
        meta.setPlaceableKeys(keys);
        rails.setItemMeta(meta);
        ItemManager.addRarity(rails, Rarity.COMMON);
        return rails;
    }

    public static ItemStack createDetectorRails() {
        ItemStack rails = new ItemStack(Material.DETECTOR_RAIL);
        ItemMeta meta = rails.getItemMeta();
        ArrayList<Namespaced> keys = new ArrayList<>(DungeonManager.commonBlocks);
        meta.setPlaceableKeys(keys);
        rails.setItemMeta(meta);
        ItemManager.addRarity(rails, Rarity.COMMON);
        return rails;
    }

    public static ItemStack createActivatorRails() {
        ItemStack rails = new ItemStack(Material.ACTIVATOR_RAIL);
        ItemMeta meta = rails.getItemMeta();
        ArrayList<Namespaced> keys = new ArrayList<>(DungeonManager.commonBlocks);
        meta.setPlaceableKeys(keys);
        rails.setItemMeta(meta);
        ItemManager.addRarity(rails, Rarity.COMMON);
        return rails;
    }

    public static ItemStack createSeaPickles() {
        ItemStack pickles = new ItemStack(Material.SEA_PICKLE);
        ItemMeta meta = pickles.getItemMeta();
        ArrayList<Namespaced> keys = new ArrayList<>(DungeonManager.commonBlocks);
        meta.setPlaceableKeys(keys);
        pickles.setItemMeta(meta);
        ItemManager.addRarity(pickles, Rarity.COMMON);
        return pickles;
    }

    public static ItemStack createLilyPad() {
        ItemStack lilyPad = new ItemStack(Material.LILY_PAD);
        ItemMeta meta = lilyPad.getItemMeta();
        meta.setPlaceableKeys(Collections.singletonList(Material.WATER.getKey()));
        lilyPad.setItemMeta(meta);
        ItemManager.addRarity(lilyPad, Rarity.COMMON);
        return lilyPad;
    }

    public static ItemStack createMinecart() {
        ItemStack minecart = new ItemStack(Material.MINECART);
        NBTItem nbti = new NBTItem(minecart);
        NBTStringList blocks = (NBTStringList) nbti.getStringList("CanPlaceOn");
        blocks.add("#minecraft:rails");
        minecart = nbti.getItem();
        ItemManager.addRarity(minecart, Rarity.COMMON);
        return minecart;
    }
}
