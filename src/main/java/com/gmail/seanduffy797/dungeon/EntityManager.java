package com.gmail.seanduffy797.dungeon;

import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;

import static com.bergerkiller.bukkit.mw.MyWorlds.plugin;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public class EntityManager {

    public static ArrayList<Entity> loadedEntities = new ArrayList<>();

    public static void addEntity(Entity entity){
        loadedEntities.add(entity);
    }

    public static void clearEntities() {
        for (Entity entity : loadedEntities) {
            entity.remove();
        }
        loadedEntities.clear();
    }
}
