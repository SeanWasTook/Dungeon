package com.gmail.seanduffy797.dungeon.events;


import com.gmail.seanduffy797.dungeon.DungeonItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DungeonBlockBreakEvent implements Listener {

    @EventHandler
    public static void onBlockBreak(BlockDropItemEvent event) {
        List<Item> items = event.getItems();
        for(Item item: items) {
            Material mat = item.getItemStack().getType();
            if (mat == Material.RAIL) {
                item.setItemStack(DungeonItem.RAILS.getItemStack());
            } else if (mat == Material.POWERED_RAIL) {
                item.setItemStack(DungeonItem.POWERED_RAILS.getItemStack());
            } else if (mat == Material.DETECTOR_RAIL) {
                item.setItemStack(DungeonItem.DETECTOR_RAILS.getItemStack());
            } else if (mat == Material.ACTIVATOR_RAIL) {
                item.setItemStack(DungeonItem.ACTIVATOR_RAILS.getItemStack());
            } else if (mat == Material.SEA_PICKLE) {
                item.setItemStack(DungeonItem.SEA_PICKLES.getItemStack());
            } else if (mat == Material.LILY_PAD) {
                item.setItemStack(DungeonItem.LILY_PAD.getItemStack());
            } else if (mat == Material.TORCH) {
                item.setItemStack(DungeonItem.TORCH.getItemStack());
            } else if (mat == Material.SOUL_TORCH) {
                item.setItemStack(DungeonItem.SOUL_TORCH.getItemStack());
            } else if (mat == Material.LANTERN) {
                item.setItemStack(DungeonItem.LANTERN.getItemStack());
            } else if (mat == Material.SOUL_LANTERN) {
                item.setItemStack(DungeonItem.SOUL_LANTERN.getItemStack());
            } else if (mat == Material.CANDLE) {
                item.setItemStack(DungeonItem.CANDLE.getItemStack());
            }
        }
    }
}
