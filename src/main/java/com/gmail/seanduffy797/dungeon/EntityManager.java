package com.gmail.seanduffy797.dungeon;

import org.bukkit.entity.Entity;

import java.util.ArrayList;

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
