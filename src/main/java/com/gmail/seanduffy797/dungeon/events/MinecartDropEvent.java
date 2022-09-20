package com.gmail.seanduffy797.dungeon.events;

import com.destroystokyo.paper.NamespacedTag;
import com.gmail.seanduffy797.dungeon.DungeonItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

import static org.bukkit.Bukkit.getServer;

public class MinecartDropEvent implements Listener {

    @EventHandler
    public static void onMinecartDrop(EntityDropItemEvent event) {
        Item item = event.getItemDrop();
        if(item.getItemStack().getType() == Material.MINECART) {
            item.setItemStack(DungeonItem.MINECART.getItemStack());
//            ItemStack itemStack = item.getItemStack();
//            ItemMeta meta = itemStack.getItemMeta();
//            meta.setPlaceableKeys(Collections.singletonList(NamespacedTag.minecraft("rails")));
//            itemStack.setItemMeta(meta);
        } else if (item.getItemStack().getType() == Material.RAIL) {
            item.setItemStack(DungeonItem.RAILS.getItemStack());
        } else if (item.getItemStack().getType() == Material.POWERED_RAIL) {
            item.setItemStack(DungeonItem.POWERED_RAILS.getItemStack());
        } else if (item.getItemStack().getType() == Material.DETECTOR_RAIL) {
            item.setItemStack(DungeonItem.DETECTOR_RAILS.getItemStack());
        } else if (item.getItemStack().getType() == Material.ACTIVATOR_RAIL) {
            item.setItemStack(DungeonItem.ACTIVATOR_RAILS.getItemStack());
        } else if (item.getItemStack().getType() == Material.SEA_PICKLE) {
            item.setItemStack(DungeonItem.SEA_PICKLES.getItemStack());
        } else if (item.getItemStack().getType() == Material.LILY_PAD) {
            item.setItemStack(DungeonItem.LILY_PAD.getItemStack());
        }
    }
}
