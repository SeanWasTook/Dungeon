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
        // DOES NOT WORK
        // Seems to save the entities before they're loaded in or smth weird
        for (Entity entity : loadedEntities) {
            getServer().getConsoleSender().sendMessage("[Dungeon]: Entity removed " + entity.getType());
            entity.setGlowing(true);
        }
        loadedEntities.clear();
    }
}
