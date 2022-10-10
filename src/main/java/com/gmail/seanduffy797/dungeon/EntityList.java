package com.gmail.seanduffy797.dungeon;

import org.bukkit.entity.Entity;

import java.util.ArrayList;

public class EntityList {

    public ArrayList<Entity> loadedEntities;

    public EntityList() {
        this.loadedEntities = new ArrayList<>();
    }

    public void addEntity(Entity entity){
        loadedEntities.add(entity);
    }

    public void clearEntities() {
        for (Entity entity : loadedEntities) {
            entity.remove();
        }
        loadedEntities.clear();
    }
}
