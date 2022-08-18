package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MushroomCow;

public class BabyMooshroom extends CustomMob {

    public BabyMooshroom() {}

    public Entity spawn(Location location) {
        World world = DungeonManager.world;
        MushroomCow moo = (MushroomCow) world.spawnEntity(location, EntityType.MUSHROOM_COW);
        moo.setAge(-999999999);
        return moo;
    }
}
