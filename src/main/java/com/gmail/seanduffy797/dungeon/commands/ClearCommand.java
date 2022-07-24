package com.gmail.seanduffy797.dungeon.commands;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.EntityManager;
import com.gmail.seanduffy797.dungeon.builders.BrickBuilder;
import com.gmail.seanduffy797.dungeon.builders.MineBuilder;
import com.gmail.seanduffy797.dungeon.builders.maze.StoneBrickMazeBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;

import static com.gmail.seanduffy797.dungeon.tasks.TaskList.tasks;

public class ClearCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("clear")){
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("brick") || args[0].equalsIgnoreCase("crypt")) {
                    BrickBuilder.clear();
                } else if (args[0].equalsIgnoreCase("mine")) {
                    MineBuilder.clear();
                } else if (args[0].equalsIgnoreCase("maze")) {
                    StoneBrickMazeBuilder.clear();
                } else {
                    sender.sendMessage("That's not something I can clear");
                    // If called without valid arguments, it still clears tasks
                }
            }

            if(tasks == null) {return true; }
            for(BukkitTask task: tasks) {
                task.cancel();
            }
            tasks.clear();
            EntityManager.clearEntities();
            DungeonManager.isGenerated = false;
        }

        return true;
    }
}
