package com.gmail.seanduffy797.dungeon.commands;

import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.BricksZone1;
import com.gmail.seanduffy797.dungeon.Pieces.BricksZone2;
import com.gmail.seanduffy797.dungeon.Pieces.Pipe;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
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
                    DungeonManager.buildRegion(Region.BRICK);
                } else if (args[0].equalsIgnoreCase("crypt")) {
                    CryptBuilder.build();
                } else if (args[0].equalsIgnoreCase("mine")) {
                    DungeonManager.buildRegion(Region.MINE);
                } else if (args[0].equalsIgnoreCase("maze")) {
                    DungeonManager.buildRegion(Region.STONE_BRICK);
//                    double chance = 0.25;
//                    if (args.length >= 2) {
//                        chance = parseDouble(args[1]);
//                    }
//                    int[] start = new int[3];
//                    start[0] = 1; // Height level
//                    start[1] = 0; // # of units from the front
//                    start[2] = 5; // # of units from the left
//                    int[] exit1 = new int[4];
//                    exit1[0] = 1;
//                    exit1[1] = 16;
//                    exit1[2] = 0;
//                    exit1[3] = 270;
//                    int[] exit2 = new int[4];
//                    exit2[0] = 0;
//                    exit2[1] = 19;
//                    exit2[2] = 15;
//                    exit2[3] = 0;
//                    int[] exit3 = new int[4];
//                    exit3[0] = 4;
//                    exit3[1] = 11;
//                    exit3[2] = 17;
//                    exit3[3] = 90;
//                    ArrayList<int[]> exits = new ArrayList<>();
//                    exits.add(exit1);
//                    exits.add(exit2);
//                    exits.add(exit3);
//                    StoneBrickMazeBuilder builder = new StoneBrickMazeBuilder(
//                            6,
//                            20,
//                            18,
//                            start,
//                            exits,
//                            chance);
//                    builder.buildStoneBrickMaze(new Location(DungeonManager.world, -2, 100, -47), StructureRotation.ROTATION_270);
                } else if (args[0].equalsIgnoreCase("all")) {
                    DungeonManager.buildAll();
                } else if (args[0].equalsIgnoreCase("data")){
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Counts: ");
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Room6: " + BrickPiecePicker.counts.get(BricksZone1.ROOM6));
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Room104: " + BrickPiecePicker.counts.get(BricksZone2.ROOM104));
                    getServer().getConsoleSender().sendMessage("[Dungeon]: p3room2: " + BrickPiecePicker.counts.get(Pipe.P3ROOM2));
                    getServer().getConsoleSender().sendMessage("[Dungeon]: p2end3: " + BrickPiecePicker.counts.get(Pipe.P2END3));
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Necessary: " + BrickPiecePicker.necessarys);
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Openings: " + BrickPiecePicker.openings);
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Brick Layouts: " + BrickPiecePicker.layouts.get(Region.BRICK));
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Brick2 Layouts: " + BrickPiecePicker.layouts.get(Region.BRICK2));
                    getServer().getConsoleSender().sendMessage("[Dungeon]: Sewer Layouts: " + BrickPiecePicker.layouts.get(Region.SEWER));
                } else {
                    sender.sendMessage("That's not something I can build");
                }
            }
        }

        return true;
    }
}
