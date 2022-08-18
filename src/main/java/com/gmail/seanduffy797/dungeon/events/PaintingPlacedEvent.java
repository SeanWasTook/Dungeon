package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.EntityManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import static org.bukkit.Bukkit.getServer;

public class PaintingPlacedEvent implements Listener {

    @EventHandler
    public static void onEntitySpawned(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.PAINTING) {
            Entity entity = event.getEntity();
            if (DungeonManager.isGenerated) {
                EntityManager.addEntity(entity);
            }
        } else if (event.getEntityType() == EntityType.ARMOR_STAND) {
            Entity entity = event.getEntity();
            if (DungeonManager.isGenerated) {
                EntityManager.addEntity(entity);
            }
        }
    }
}
