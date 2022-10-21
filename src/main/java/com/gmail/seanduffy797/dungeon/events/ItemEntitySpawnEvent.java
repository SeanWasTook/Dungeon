package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

public class ItemEntitySpawnEvent implements Listener {

    @EventHandler
    public static void onItemEntitySpawn(ItemSpawnEvent event) {
        // Item entities are tracked to be removed when the dungeon is cleared
        if (DungeonManager.isGenerated) {
            Entity entity = event.getEntity();
            Region region = DungeonManager.getRegionAt(entity.getLocation());
            DungeonManager.addEntityToRegion(region, entity);
        }
    }
}
