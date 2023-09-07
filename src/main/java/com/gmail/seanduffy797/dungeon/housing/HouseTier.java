package com.gmail.seanduffy797.dungeon.housing;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;

public enum HouseTier {

    TIER1(9, 9, 5, new Location(DungeonManager.world, 0, -1, -4)),
    TIER2(13, 13, 6, new Location(DungeonManager.world, 0, -2, -6)),
    TIER3(19, 19, 8, new Location(DungeonManager.world, 0, -2, -9));

    final int length;
    final int width;
    final int height;
    final Location offset;

    HouseTier(int length, int width, int height, Location offset) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.offset = offset;
    }
}
