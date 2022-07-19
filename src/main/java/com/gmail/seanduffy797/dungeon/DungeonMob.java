package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.mobs.*;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

public enum DungeonMob {

    BRICK_HUSK(new BrickHusk()),
    BRICK_SKELETON(new BrickSkeleton()),
    AXE_VINDICATOR(new AxeVindicator()),
    DUNGEON_LLAMA(new DungeonLlama());

    private final CustomMob mobClass;

    DungeonMob(CustomMob mobClass) {
        this.mobClass = mobClass;
    }

    public Entity spawn(Location location) {
        Entity entity = mobClass.spawn(location);
        entity.getPersistentDataContainer().set(
                DungeonManager.customMobKey, PersistentDataType.STRING, this.name());
        EntityManager.addEntity(entity);
        return entity;
    }
}
