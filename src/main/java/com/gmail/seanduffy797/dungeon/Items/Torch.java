package com.gmail.seanduffy797.dungeon.Items;

import com.destroystokyo.paper.Namespaced;
import com.gmail.seanduffy797.dungeon.DungeonManager;
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
        ItemMeta meta = torch.getItemMeta();
        meta.setPlaceableKeys(DungeonManager.commonBlocks);
        torch.setItemMeta(meta);
        return torch;
    }

    public static ItemStack createSoulTorch() {
        soulTorch = new ItemStack(Material.SOUL_TORCH);
        ItemMeta meta = soulTorch.getItemMeta();
        meta.setPlaceableKeys(DungeonManager.commonBlocks);
        soulTorch.setItemMeta(meta);
        return soulTorch;
    }

    public static ItemStack createCandle() {
        candle = new ItemStack(Material.CANDLE);
        ItemMeta meta = candle.getItemMeta();
        ArrayList<Namespaced> keys = new ArrayList<>(DungeonManager.commonBlocks);
        keys.add(Material.CANDLE.getKey());
        meta.setPlaceableKeys(keys);
        candle.setItemMeta(meta);
        return candle;
    }

    public static ItemStack createLantern() {
        ItemStack lantern = new ItemStack(Material.TORCH);
        ItemMeta meta = lantern.getItemMeta();
        meta.setPlaceableKeys(DungeonManager.commonBlocks);
        lantern.setItemMeta(meta);
        return lantern;
    }

    public static ItemStack createSoulLantern() {
        ItemStack soulLantern = new ItemStack(Material.SOUL_LANTERN);
        ItemMeta meta = soulLantern.getItemMeta();
        meta.setPlaceableKeys(DungeonManager.commonBlocks);
        soulLantern.setItemMeta(meta);
        return soulLantern;
    }
}
