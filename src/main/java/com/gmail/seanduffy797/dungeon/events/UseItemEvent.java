package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.Items.TeleportPearl;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static org.bukkit.Bukkit.getWorld;

public class UseItemEvent implements Listener {

    @EventHandler
    public static void onItemUse(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
            if (event.getItem() != null) {
                // Pearl of Teleportation functionality
                if (event.getItem().getItemMeta().equals(TeleportPearl.teleportPearl.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.teleport(new Location(getWorld("Dungeon"), 0.5, 102, 0.5));
                    event.setCancelled(true);
                    event.getItem().subtract();
                }
            }
        }
    }
}
