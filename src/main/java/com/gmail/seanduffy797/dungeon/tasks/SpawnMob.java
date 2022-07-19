package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.mobs.AxeVindicator;
import com.gmail.seanduffy797.dungeon.mobs.BrickHusk;
import com.gmail.seanduffy797.dungeon.mobs.BrickSkeleton;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnMob extends BukkitRunnable {

    private Location loc;
    private DungeonMob mob;

    public SpawnMob(Location loc, DungeonMob mob) {
        this.loc = loc;
        this.mob = mob;
    }

    @Override
    public void run() {
        mob.spawn(loc);
    }
}
