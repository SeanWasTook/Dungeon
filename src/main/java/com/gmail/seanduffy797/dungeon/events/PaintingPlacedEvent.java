package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class PaintingPlacedEvent implements Listener {

    @EventHandler
    public static void onEntitySpawned(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.PAINTING) {
            Entity entity = event.getEntity();
            if (DungeonManager.isGenerated) {
                Region region = DungeonManager.getRegionAt(entity.getLocation());
                DungeonManager.addEntityToRegion(region, entity);
            }
        } else if (event.getEntityType() == EntityType.ARMOR_STAND) {
            Entity entity = event.getEntity();
            if (DungeonManager.isGenerated) {
                Region region = DungeonManager.getRegionAt(entity.getLocation());
                DungeonManager.addEntityToRegion(region, entity);
            }
        }
    }
}
