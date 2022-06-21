package com.gmail.seanduffy797.dungeon.events;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;


public class AgeBabyZombiesEvent implements Listener {

    @EventHandler
    public static void onCreatureSpawn(CreatureSpawnEvent event) {
        Entity entity = event.getEntity();
        EntityType type = entity.getType();
        if(type == EntityType.ZOMBIE || type == EntityType.HUSK || type == EntityType.DROWNED) {
            Ageable ageable = (Ageable) entity;

            if(!ageable.isAdult()) {
                ageable.setAdult();
            }
        }
    }
}
