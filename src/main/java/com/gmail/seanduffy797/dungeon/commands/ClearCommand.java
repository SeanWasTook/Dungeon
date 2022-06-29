package com.gmail.seanduffy797.dungeon.commands;

import com.gmail.seanduffy797.dungeon.EntityManager;
import com.gmail.seanduffy797.dungeon.builders.BrickBuilder;
import com.gmail.seanduffy797.dungeon.builders.MineBuilder;
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
                } else {
                    sender.sendMessage("That's not something I can clear");
                }
            }

            if(tasks == null) {return true; }
            for(BukkitTask task: tasks) {
                task.cancel();
            }
            tasks.clear();
            EntityManager.clearEntities();
        }

        return true;
    }
}
