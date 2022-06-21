package com.gmail.seanduffy797.dungeon.events;


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
            ItemStack itemStack = item.getItemStack();
            if(itemStack.getType() == Material.TORCH || itemStack.getType() == Material.SOUL_TORCH || itemStack.getType() == Material.LANTERN || itemStack.getType() == Material.SOUL_LANTERN){
                ItemMeta meta = itemStack.getItemMeta();
                meta.setPlaceableKeys(Arrays.asList(NamespacedKey.minecraft("bricks"), NamespacedKey.minecraft("polished_granite"), NamespacedKey.minecraft("granite"), NamespacedKey.minecraft("stone_bricks"), NamespacedKey.minecraft("spruce_planks"), NamespacedKey.minecraft("stone")));
                itemStack.setItemMeta(meta);
            } else if(itemStack.getType() == Material.RAIL || itemStack.getType() == Material.ACTIVATOR_RAIL || itemStack.getType() == Material.DETECTOR_RAIL || itemStack.getType() == Material.POWERED_RAIL){
                ItemMeta meta = itemStack.getItemMeta();
                meta.setPlaceableKeys(Collections.singletonList(NamespacedKey.minecraft("stone")));
                itemStack.setItemMeta(meta);
            }
        }
    }
}
