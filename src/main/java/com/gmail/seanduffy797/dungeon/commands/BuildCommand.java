package com.gmail.seanduffy797.dungeon.commands;

import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.builders.*;
import com.gmail.seanduffy797.dungeon.builders.maze.StoneBrickMazeBuilder;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static org.bukkit.Bukkit.getServer;

public class BuildCommand implements CommandExecutor {

    //Currently defaults to BrickBuilder for ease of use, should be expanded considerably later

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("build")){
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("brick")) {
                    BrickBuilder.build();
                } else if (args[0].equalsIgnoreCase("crypt")) {
                    CryptBuilder.build();
                } else if (args[0].equalsIgnoreCase("mine")) {
                    MineBuilder.build();
                } else if (args[0].equalsIgnoreCase("maze")) {
                    double chance = 0.25;
                    if (args.length >= 2) {
                        chance = parseDouble(args[1]);
                    }
                    int[] start = new int[3];
                    start[0] = 1; // Height level
                    start[1] = 0; // # of units from the front
                    start[2] = 5; // # of units from the left
                    int[] exit1 = new int[4];
                    exit1[0] = 1;
                    exit1[1] = 8;
                    exit1[2] = 0;
                    exit1[3] = 270;
                    int[] exit2 = new int[4];
                    exit2[0] = 6;
                    exit2[1] = 10;
                    exit2[2] = 7;
                    exit2[3] = 0;
                    ArrayList<int[]> exits = new ArrayList<>();
                    // exits.add(exit1);
                    // exits.add(exit2);
                    StoneBrickMazeBuilder builder = new StoneBrickMazeBuilder(
                            6,
                            25,
                            18,
                            start,
                            exits,
                            chance);
                    builder.buildStoneBrickMaze(new Location(DungeonManager.world, -2, 100, -47), StructureRotation.ROTATION_270);
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
