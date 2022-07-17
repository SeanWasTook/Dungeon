package com.gmail.seanduffy797.dungeon.events;

import org.bukkit.GameMode;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class HitHangingEntityEvent implements Listener {

    // Prevents any mobs and players not in creative from breaking paintings of item frames
    @EventHandler
    public static void onHangingBreakByEntity(HangingBreakByEntityEvent event) {
        Entity breaker = event.getRemover();
        if (breaker instanceof Player
                && ((Player) breaker).getGameMode().equals(GameMode.CREATIVE)) {
            return;
        } else {
            Hanging hanging = event.getEntity();
            if (hanging instanceof Painting || hanging instanceof ItemFrame) {
                event.setCancelled(true);
            }
        }
    }
}
