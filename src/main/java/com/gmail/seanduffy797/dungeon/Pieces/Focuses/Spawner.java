package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.tasks.SetSpawner;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;

public class Spawner extends Focus {

    public SpawnerEnum spawnerType;

    public Spawner(Location location, SpawnerEnum spawnerType) {
        this.location = location;
        this.spawnerType = spawnerType;
    }

    public Spawner makeCopy(Focus spawner) {
        if (spawner instanceof Spawner) {
            Spawner other = (Spawner) spawner;
            return new Spawner(other.location.clone(), other.spawnerType);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        Plugin plugin = Dungeon.getPlugin();

        BukkitTask task = new SetSpawner(location, spawnerType)
                .runTaskLater(plugin, 400L);
    }
}
