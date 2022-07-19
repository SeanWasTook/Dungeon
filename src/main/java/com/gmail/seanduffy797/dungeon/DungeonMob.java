package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.mobs.AxeVindicator;
import com.gmail.seanduffy797.dungeon.mobs.BrickHusk;
import com.gmail.seanduffy797.dungeon.mobs.BrickSkeleton;
import com.gmail.seanduffy797.dungeon.mobs.CustomMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public enum DungeonMob {

    BRICKHUSK (new BrickHusk()),
    BRICKSKELETON (new BrickSkeleton()),
    AXEVINDICATOR (new AxeVindicator());

    private final CustomMob mobClass;

    DungeonMob(CustomMob mobClass) {
        this.mobClass = mobClass;
    }

    public Entity spawn(Location location) {
        Entity entity = mobClass.spawn(location);
        EntityManager.addEntity(entity);
        return entity;
    }
}
