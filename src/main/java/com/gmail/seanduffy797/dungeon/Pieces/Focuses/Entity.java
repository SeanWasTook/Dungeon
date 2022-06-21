package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.tasks.SpawnMob;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;

public class Entity extends Focus {

    public Mob mobType;
    public boolean respawn;
    public int respawnCoolDown;

    public Entity(Location location, Mob mobType) {
        this.location = location;
        this.mobType = mobType;
        this.respawn = false;
        this.respawnCoolDown = 0;
    }

    public Entity(Location location, Mob mobType, int coolDown) {
        this.location = location;
        this.mobType = mobType;
        this.respawn = true;
        this.respawnCoolDown = coolDown;
    }

    private Entity(Location location, Mob mobType, boolean respawn, int coolDown) {
        this.location = location;
        this.mobType = mobType;
        this.respawn = respawn;
        this.respawnCoolDown = coolDown;
    }


    public Entity makeCopy(Focus entity) {
        if (entity instanceof Entity) {
            Entity other = (Entity) entity;
            return new Entity(other.location.clone(), other.mobType, other.respawn, other.respawnCoolDown);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        BukkitTask task;
        if(respawn) {
            task = new SpawnMob(location, mobType).runTaskTimer(plugin, 400L < respawnCoolDown ? respawnCoolDown : 400L, respawnCoolDown);
        } else {
            task = new SpawnMob(location, mobType).runTaskLater(plugin, 400L);
        }

        TaskList.tasks.add(task);
    }
}
