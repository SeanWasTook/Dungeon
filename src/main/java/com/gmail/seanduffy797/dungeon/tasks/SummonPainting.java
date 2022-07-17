package com.gmail.seanduffy797.dungeon.tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class SummonPainting extends BukkitRunnable {

    private Location loc;
    private String motif;
    private int facing;

    public SummonPainting(Location loc, String motif, int facing) {
        this.loc = loc;
        this.motif = motif;
        this.facing = facing;
    }

    @Override
    public void run() {
        getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "summon minecraft:painting " +
                        ((int)loc.getX()) + " " +
                        ((int)loc.getY()) + " " +
                        ((int)loc.getZ()) +
                        " {variant:\"minecraft:" + motif + "\", facing: " + facing + "b}");
    }
}
