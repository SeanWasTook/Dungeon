package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import com.gmail.seanduffy797.dungeon.tasks.SpawnMob;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getServer;

public class DungeonEntity extends Focus {

    public DungeonMob mobType;
    public boolean respawn;
    public int respawnCoolDown;
    public int id = -1;

    public DungeonEntity(Location location, DungeonMob mobType) {
        this.location = location;
        this.mobType = mobType;
        this.respawn = false;
        this.respawnCoolDown = 0;
    }

    public DungeonEntity(Location location, DungeonMob mobType, int coolDown) {
        this.location = location;
        this.mobType = mobType;
        this.respawn = true;
        this.respawnCoolDown = coolDown;
        if (respawnCoolDown <= 0) {
            this.respawn = false;
        }
    }
    public DungeonEntity(Location location, DungeonMob mobType, int coolDown, int id) {
        this.location = location;
        this.mobType = mobType;
        this.respawn = true;
        this.respawnCoolDown = coolDown;
        if (respawnCoolDown <= 0) {
            this.respawn = false;
        }
        this.id = id;
    }

    public DungeonEntity makeCopy(Focus entity) {
        if (entity instanceof DungeonEntity) {
            DungeonEntity other = (DungeonEntity) entity;
            return new DungeonEntity(other.location.clone(), other.mobType, other.respawnCoolDown, other.id);
        } else {
            return null;
        }
    }

    @Override
    public void start(Region region) {
        Plugin plugin = Dungeon.getPlugin();
        BukkitTask task;
        if(respawn) {
            if(id < 0) {
                task = new SpawnMob(location, mobType)
                        .runTaskTimer(plugin, 400L, respawnCoolDown);
            } else {
                task = new SpawnMob(location, mobType, id)
                        .runTaskTimer(plugin, 400L, respawnCoolDown);
            }
        } else {
            if(id < 0) {
                task = new SpawnMob(location, mobType).runTaskLater(plugin, 400L);
            } else {
                task = new SpawnMob(location, mobType, id).runTaskLater(plugin, 400L);
            }
        }

        DungeonManager.addTaskToRegion(region, task);
    }
}
