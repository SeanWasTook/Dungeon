package com.gmail.seanduffy797.dungeon.commands;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.BricksZone1;
import com.gmail.seanduffy797.dungeon.Pieces.BricksZone2;
import com.gmail.seanduffy797.dungeon.Pieces.Pipe;
import com.gmail.seanduffy797.dungeon.regions.Region;
import com.gmail.seanduffy797.dungeon.builders.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
                } else if (args[0].equalsIgnoreCase("pueblo")) {
                    DungeonManager.buildRegion(Region.PUEBLO);
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
