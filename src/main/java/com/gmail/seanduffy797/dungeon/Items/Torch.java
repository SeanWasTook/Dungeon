package com.gmail.seanduffy797.dungeon.Items;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Torch {

    public static ItemStack torch;
    public static ItemStack soulTorch;

    public static void init() {
        createTorch();
        createSoulTorch();
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
}
