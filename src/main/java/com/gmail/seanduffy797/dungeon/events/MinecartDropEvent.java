package com.gmail.seanduffy797.dungeon.events;

import com.destroystokyo.paper.NamespacedTag;
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
            ItemStack itemStack = item.getItemStack();
            ItemMeta meta = itemStack.getItemMeta();
            meta.setPlaceableKeys(Collections.singletonList(NamespacedTag.minecraft("rails")));
            itemStack.setItemMeta(meta);
        }
    }
}
