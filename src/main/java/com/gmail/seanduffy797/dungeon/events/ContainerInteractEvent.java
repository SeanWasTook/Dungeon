package com.gmail.seanduffy797.dungeon.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ContainerInteractEvent implements Listener {

    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (player.getGameMode().equals(GameMode.ADVENTURE)) {
            if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
                Block block = event.getClickedBlock();
                // Prevent players in Adventure Mode from opening dispensers
                if (block != null && block.getType().equals(Material.DISPENSER)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
