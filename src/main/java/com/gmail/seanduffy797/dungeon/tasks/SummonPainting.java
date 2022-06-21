package com.gmail.seanduffy797.dungeon.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class SummonPainting extends BukkitRunnable {

    private Location loc;
    private String motive;

    public SummonPainting(Location loc, String motive) {
        this.loc = loc;
        this.motive = motive;
    }

    @Override
    public void run() {
        getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "summon minecraft:painting " + ((int)loc.getX()) + " " + ((int)loc.getY()) + " " + ((int)loc.getZ()) + " {Motive:\"minecraft:" + motive + "\"}");
    }
}
