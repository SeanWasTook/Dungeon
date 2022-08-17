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
    private int id;

    public SpawnMob(Location loc, DungeonMob mob) {
        this.loc = loc;
        this.mob = mob;
    }

    public SpawnMob(Location loc, DungeonMob mob, int id) {
        this.loc = loc;
        this.mob = mob;
        this.id = id;
    }

    @Override
    public void run() {
        if (this.id > 0) {
            mob.spawn(loc, id);
        } else {
            mob.spawn(loc);
        }
    }
}
