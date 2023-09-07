package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class DestroyBlockEvent implements Listener {

    @EventHandler
    public static void onDamageBlock(BlockDamageEvent event) {
        Player player = event.getPlayer();
        Location loc = event.getBlock().getLocation();
        if (player.getGameMode() == GameMode.SURVIVAL) {
            if (event.getBlock().getBlockData().getMaterial() == Material.IRON_DOOR) {
                event.setCancelled(true);
                return;
            }
            Region region = DungeonManager.getRegionAt(loc);
            if (region != Region.PLAYER_HOME) {
                event.setCancelled(true);
                return;
            }
        }
    }
}
