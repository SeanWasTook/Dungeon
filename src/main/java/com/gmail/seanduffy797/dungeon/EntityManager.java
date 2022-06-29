package com.gmail.seanduffy797.dungeon;

import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;

import static com.bergerkiller.bukkit.mw.MyWorlds.plugin;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public class EntityManager {

    public static ArrayList<UUID> loadedEntities = new ArrayList<>();

    public static void addEntity(UUID uuid){
        loadedEntities.add(uuid);
    }

    public static void clearEntities() {
        // DOES NOT WORK
        // Seems to save the entities before they're loaded in or smth weird
        for (UUID uuid : loadedEntities) {
            Entity entity = getWorld("Dungeon").getEntity(uuid);
            getServer().getConsoleSender().sendMessage("[Dungeon]: Entity removed " + entity.getType());
        }
        loadedEntities.clear();
    }
}
