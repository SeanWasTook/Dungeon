package com.gmail.seanduffy797.dungeon.Items;

import com.destroystokyo.paper.Namespaced;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Items.management.ItemManager;
import com.gmail.seanduffy797.dungeon.Items.management.Rarity;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTList;
import de.tr7zw.nbtapi.NBTStringList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Torch {

    public static ItemStack torch;
    public static ItemStack soulTorch;
    public static ItemStack candle;

    public static void init() {
        createTorch();
        createSoulTorch();
        createCandle();
    }

    public static ItemStack createTorch() {
        torch = new ItemStack(Material.TORCH);
        NBTItem nbti = new NBTItem(torch);
        NBTStringList blocks = (NBTStringList) nbti.getStringList("CanPlaceOn");
        blocks.add("#d:common_blocks");
        torch = nbti.getItem();
//        ItemMeta meta = torch.getItemMeta();
//        meta.setPlaceableKeys(DungeonManager.commonBlocks);
//        torch.setItemMeta(meta);
        return torch;
    }

    public static ItemStack createSoulTorch() {
        soulTorch = new ItemStack(Material.SOUL_TORCH);
        NBTItem nbti = new NBTItem(soulTorch);
        NBTStringList blocks = (NBTStringList) nbti.getStringList("CanPlaceOn");
        blocks.add("#d:common_blocks");
        soulTorch = nbti.getItem();
//        ItemMeta meta = soulTorch.getItemMeta();
//        meta.setPlaceableKeys(DungeonManager.commonBlocks);
//        soulTorch.setItemMeta(meta);
        ItemManager.addRarity(soulTorch, Rarity.COMMON);
        return soulTorch;
    }

    public static ItemStack createCandle() {
        candle = new ItemStack(Material.CANDLE);
        ItemMeta meta = candle.getItemMeta();
        ArrayList<Namespaced> keys = new ArrayList<>(DungeonManager.commonBlocks);
        keys.add(Material.CANDLE.getKey());
        meta.setPlaceableKeys(keys);
        candle.setItemMeta(meta);
        ItemManager.addRarity(candle, Rarity.COMMON);
        return candle;
    }

    public static ItemStack createLantern() {
        ItemStack lantern = new ItemStack(Material.LANTERN);
        NBTItem nbti = new NBTItem(lantern);
        NBTStringList blocks = (NBTStringList) nbti.getStringList("CanPlaceOn");
        blocks.add("#d:common_blocks");
        lantern = nbti.getItem();
//        ItemMeta meta = lantern.getItemMeta();
//        meta.setPlaceableKeys(DungeonManager.commonBlocks);
//        lantern.setItemMeta(meta);
        ItemManager.addRarity(lantern, Rarity.UNCOMMON);
        return lantern;
    }

    public static ItemStack createSoulLantern() {
        ItemStack soulLantern = new ItemStack(Material.SOUL_LANTERN);
        NBTItem nbti = new NBTItem(soulLantern);
        NBTStringList blocks = (NBTStringList) nbti.getStringList("CanPlaceOn");
        blocks.add("#d:common_blocks");
        soulLantern = nbti.getItem();
//        ItemMeta meta = soulLantern.getItemMeta();
//        meta.setPlaceableKeys(DungeonManager.commonBlocks);
//        soulLantern.setItemMeta(meta);
        ItemManager.addRarity(soulLantern, Rarity.UNCOMMON);
        return soulLantern;
    }
}
