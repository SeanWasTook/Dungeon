package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Mob;
import com.gmail.seanduffy797.dungeon.mobs.AxeVindicator;
import com.gmail.seanduffy797.dungeon.mobs.BrickHusk;
import com.gmail.seanduffy797.dungeon.mobs.BrickSkeleton;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class SpawnMob extends BukkitRunnable {

    private Location loc;
    private Mob mob;

    public SpawnMob(Location loc, Mob mob) {
        this.loc = loc;
        this.mob = mob;
    }

    @Override
    public void run() {
        switch(mob){
            case BRICKHUSK:
                BrickHusk husky = new BrickHusk(loc);
                break;
            case BRICKSKELETON:
                BrickSkeleton skelly = new BrickSkeleton(loc);
                break;
            case AXEVINDICATOR:
                AxeVindicator vinny = new AxeVindicator(loc);
                break;
        }
    }
}
