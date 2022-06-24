package com.gmail.seanduffy797.dungeon.events;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.*;

import static org.bukkit.Bukkit.getWorld;

public class HopperEvent implements Listener {

    @EventHandler
    public static void onHopperPickupItem(InventoryPickupItemEvent event) {
        // Ugly Code!
        Item item = event.getItem();
        ItemStack itemStack = item.getItemStack();
        TextComponent text = ((TextComponent)itemStack.getItemMeta().displayName());
        String itemName;
        if(text != null) {
            itemName = text.content();
        } else {
            itemName = "";
        }
        InventoryHolder holder = event.getInventory().getHolder();
        Hopper hopper;
        try {hopper = (Hopper)holder;}
        catch (IllegalStateException e) {return;}
        String name = null;
        if (hopper != null && hopper.customName() != null) {
            name = ((TextComponent)hopper.customName()).content();
        }

        if(name == null) {return;}

        if (name.equals("shrine1") && itemStack.getType() == Material.EMERALD) {
            if (item.getThrower() == null) { return; }
            Player player = Bukkit.getPlayer(item.getThrower());
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 2000, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000, 0));
            player.sendMessage(ChatColor.DARK_PURPLE + "You have been blessed by the gods");
            return;
        } else if (name.equals("room3") && itemStack.getType() == Material.TRIPWIRE_HOOK && itemName.equals("Old Key")) {
            Door door;
            Location loc = event.getInventory().getLocation();
            Location loc2;
            if ((new Location(getWorld("Dungeon"), loc.getX() + 2, loc.getY(), loc.getZ())).getBlock().getType() == Material.IRON_DOOR) {
                loc2 = new Location(getWorld("Dungeon"), loc.getX() + 2, loc.getY(), loc.getZ());
            } else if ((new Location(getWorld("Dungeon"), loc.getX() - 2, loc.getY(), loc.getZ())).getBlock().getType() == Material.IRON_DOOR) {
                loc2 = new Location(getWorld("Dungeon"), loc.getX() - 2, loc.getY(), loc.getZ());
            } else if ((new Location(getWorld("Dungeon"), loc.getX(), loc.getY(), loc.getZ() + 2)).getBlock().getType() == Material.IRON_DOOR) {
                loc2 = new Location(getWorld("Dungeon"), loc.getX(), loc.getY(), loc.getZ() + 2);
            } else if ((new Location(getWorld("Dungeon"), loc.getX(), loc.getY(), loc.getZ() - 2)).getBlock().getType() == Material.IRON_DOOR) {
                loc2 = new Location(getWorld("Dungeon"), loc.getX(), loc.getY(), loc.getZ() - 2);
            } else {
                return;
            }
            Block block = loc2.getBlock();
            door = (Door)block.getState().getBlockData();
            door.setOpen(true);
            block.setBlockData(door);
        }
    }
}
