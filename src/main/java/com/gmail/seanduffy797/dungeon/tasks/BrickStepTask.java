package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.builders.BrickBuilder;
import org.bukkit.scheduler.BukkitRunnable;

public class BrickStepTask extends BukkitRunnable {

    public BrickStepTask() {}

    @Override
    public void run() {
        BrickBuilder.takeStep();
    }
}
