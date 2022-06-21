package com.gmail.seanduffy797.dungeon.tasks;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class BurnOut extends BukkitRunnable {

    private Block block;

    public BurnOut(Block torch) {
        this.block = torch;
    }

    @Override
    public void run() {
        block.setType(Material.AIR);
    }
}
