package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class CommonDrowned extends CustomMob {

    public CommonDrowned() {}

    public Entity spawn(Location location) {
        Drowned drowned = (Drowned) DungeonManager.world.spawnEntity(location, EntityType.DROWNED);
        return drowned;
    }
}
