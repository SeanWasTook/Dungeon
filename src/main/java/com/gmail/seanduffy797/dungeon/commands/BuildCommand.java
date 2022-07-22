package com.gmail.seanduffy797.dungeon.commands;

import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.builders.*;
import com.gmail.seanduffy797.dungeon.builders.maze.StoneBrickMazeBuilder;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.Bukkit.getServer;

public class BuildCommand implements CommandExecutor {

    //Currently defaults to BrickBuilder for ease of use, should be expanded considerably later

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("build")){
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("brick")) {
                    BrickBuilder.build();
                } else if (args[0].equalsIgnoreCase("crypt")) {
                    CryptBuilder.build();
                } else if (args[0].equalsIgnoreCase("mine")) {
                    MineBuilder.build();
                } else if (args[0].equalsIgnoreCase("maze")) {
                    StoneBrickMazeBuilder builder = new StoneBrickMazeBuilder();
                    builder.buildStoneBrickMaze(new Location(DungeonManager.world, 85, 50, 0), StructureRotation.NONE);
                } else if (args[0].equalsIgnoreCase("data")){
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Counts: " + BrickPiecePicker.counts);
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Necessary: " + BrickPiecePicker.necessarys);
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Openings: " + BrickPiecePicker.openings);
                } else {
                    sender.sendMessage("That's not something I can build");
                }
            }
        }

        return true;
    }
}
