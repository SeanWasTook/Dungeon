package com.gmail.seanduffy797.dungeon.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class SetSpawner extends BukkitRunnable {

    private Location loc;
    private String details;

    public SetSpawner(Location loc, String details) {
        this.loc = loc;
        this.details = details;
    }

    @Override
    public void run() {
        Chunk chunk = loc.getChunk();
        boolean wasLoaded = true;
        if(!chunk.isLoaded()) {
            wasLoaded = false;
            chunk.load();
        }

        getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "setblock " + ((int)loc.getX()) + " " +
                        ((int)loc.getY()) + " " +
                        ((int)loc.getZ()) + " spawner" +
                        details + " replace");

        if(!wasLoaded) {
            chunk.unload();
        }
    }
}
