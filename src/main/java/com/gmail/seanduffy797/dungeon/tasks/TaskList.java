package com.gmail.seanduffy797.dungeon.tasks;

import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class TaskList {

    public ArrayList<BukkitTask> tasks;
    public TaskList() {
        tasks = new ArrayList<>();
    }
    public void addTask(BukkitTask task) {
        tasks.add(task);
    }
    public void clear() {
        for (BukkitTask task: tasks) {
            task.cancel();
        }
        tasks.clear();
    }
}
