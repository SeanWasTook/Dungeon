package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Spider;

public class CommonSpider extends CustomMob {

    public CommonSpider() {}

    public Entity spawn(Location location) {
        Spider spider = (Spider) DungeonManager.world.spawnEntity(location, EntityType.SPIDER);
        return spider;
    }
}
