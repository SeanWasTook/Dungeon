package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.tasks.SpawnMob;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class DungeonEntity extends Focus {

    public DungeonMob mobType;
    public boolean respawn;
    public int respawnCoolDown;

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
        if (respawnCoolDown == 0) {
            this.respawn = false;
        }
    }

    private DungeonEntity(Location location, DungeonMob mobType, boolean respawn, int coolDown) {
        this.location = location;
        this.mobType = mobType;
        this.respawn = respawn;
        this.respawnCoolDown = coolDown;
    }


    public DungeonEntity makeCopy(Focus entity) {
        if (entity instanceof DungeonEntity) {
            DungeonEntity other = (DungeonEntity) entity;
            return new DungeonEntity(other.location.clone(), other.mobType, other.respawn, other.respawnCoolDown);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        Plugin plugin = Dungeon.getPlugin();
        BukkitTask task;
        if(respawn) {
            task = new SpawnMob(location, mobType)
                    .runTaskTimer(plugin, 400L < respawnCoolDown ? respawnCoolDown : 400L, respawnCoolDown);
        } else {
            task = new SpawnMob(location, mobType).runTaskLater(plugin, 400L);
        }

        TaskList.tasks.add(task);
    }
}
