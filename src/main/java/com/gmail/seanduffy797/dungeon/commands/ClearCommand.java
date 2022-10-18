package com.gmail.seanduffy797.dungeon.commands;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClearCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("clear")){
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("brick") || args[0].equalsIgnoreCase("crypt")) {
                    DungeonManager.clearRegion(Region.BRICK);
                } else if (args[0].equalsIgnoreCase("mine")) {
                    DungeonManager.clearRegion(Region.MINE);
                } else if (args[0].equalsIgnoreCase("maze")) {
                    DungeonManager.clearRegion(Region.STONE_BRICK);
                } else if (args[0].equalsIgnoreCase("pueblo")) {
                    DungeonManager.clearRegion(Region.PUEBLO);
                } else if (args[0].equalsIgnoreCase("all")) {
                    DungeonManager.clearAll();
                } else if (args[0].equalsIgnoreCase("fluff")) {
                    DungeonManager.clearFluff();
                } else {
                    sender.sendMessage("That's not something I can clear");
                    // If called without valid arguments, it still clears tasks
                }
            }

//            if(tasks == null) {return true; }
//            for(BukkitTask task: tasks) {
//                task.cancel();
//            }
//            tasks.clear();
//            EntityList.clearEntities();
//            DungeonManager.isGenerated = false;
        }

        return true;
    }
}
