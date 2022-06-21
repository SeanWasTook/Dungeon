package com.gmail.seanduffy797.dungeon.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class FillChests extends BukkitRunnable {

    private Location loc;
    private String path;

    public FillChests(Location loc, String path) {
        this.loc = loc;
        this.path = path;
    }

    @Override
    public void run() {

        //getServer().getConsoleSender().sendMessage("Inserted " + path + " at " + ((int)loc.getX()) + ", " + ((int)loc.getY()) + ", " + ((int)loc.getZ()));

        getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "data modify block " + ((int)loc.getX()) + " " + ((int)loc.getY()) + " " + ((int)loc.getZ()) + " LootTable set value \"" + path + "\"");
    }
}
