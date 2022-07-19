package com.gmail.seanduffy797.dungeon.commands;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.*;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class PlaceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("place")) {
            World world = getServer().getWorld("Dungeon");
            Location loc = new Location(world, 50, 50, 50);

            StructureRotation rotation = StructureRotation.NONE;
            StructureMirror mirror = StructureMirror.NONE;
            if (args.length >= 3) { // Rotation is specified
                String rotationArg = args[2];
                rotationArg = "rotation_" + rotationArg;
                try {
                    rotation = StructureRotation.valueOf(rotationArg.toUpperCase());
                } catch (IllegalArgumentException e) {
                    sender.sendMessage("Invalid Argument: " + rotationArg + " is not a valid rotation. Defaulting to None");
                }
            } else if (args.length < 2) {
                sender.sendMessage("Usage: /place <region> <name> [90|180|270] [0|1]");
                return false;
            }
            if (args.length >= 4) { // Mirror is specified
                String mirrorArg = args[3];
                if (mirrorArg.equals("1")) {
                    mirror = StructureMirror.LEFT_RIGHT;
                }
            }
            String regionArg = args[0];
            String nameArg = args[1];
            Region region;
            Bricks piece;
            try {
                region = Region.valueOf(regionArg.toUpperCase());
            } catch (IllegalArgumentException e) {
                sender.sendMessage("Invalid Argument: " + regionArg + " is not a valid region");
                return false;
            }
            try {
                switch(region) {
                    case BRICK:
                        piece = BricksZone1.valueOf(nameArg.toUpperCase());
                        break;
                    case BRICK2: case HOUSE:
                        piece = BricksZone2.valueOf(nameArg.toUpperCase());
                        break;
                    case SEWER:
                        piece = Sewer.valueOf(nameArg.toUpperCase());
                        break;
                    case PIPE2: case PIPE3:
                        piece = Pipe.valueOf(nameArg.toUpperCase());
                        break;
                    case TEST:
                        piece = TestPiece.valueOf(nameArg.toUpperCase());
                        break;
                    default:
                        sender.sendMessage("Place command is not currently supported for that region");
                        return false;
                }
            } catch (IllegalArgumentException e) {
                sender.sendMessage("Invalid Argument: " + nameArg + " is not a valid piece in that region");
                return false;
            }

            TaskList.tasks = new ArrayList<>();
            FocusMeta.init();

            // Offset Calculations - Necessary to line up with focuses
            Location offset = piece.getStartOffset().clone();
            if(mirror.equals(StructureMirror.LEFT_RIGHT)) {
                offset = BuilderUtils.applyRotation(BuilderUtils.applyMirror(offset, piece.isEven()), rotation);
            } else {
                offset = BuilderUtils.applyRotation(offset, rotation);
            }

            // Handle focuses
            for (Focus foc: piece.getFocuses()) {
                Focus newFoc = foc.makeCopy(foc);
                Location newLoc = loc.clone();
                if(mirror.equals(StructureMirror.LEFT_RIGHT)) {
                    newFoc.mirror = StructureMirror.LEFT_RIGHT;
                    newFoc.location = newLoc.add(BuilderUtils.applyRotation(BuilderUtils.applyMirror(newFoc.location, piece.isEven()), rotation));
                } else {
                    newFoc.mirror = StructureMirror.NONE;
                    newFoc.location = newLoc.add(BuilderUtils.applyRotation(newFoc.location, rotation));
                }
                newFoc.rotation = rotation;
                newFoc.start();
            }

            piece.place(loc.add(offset), rotation, mirror);
        }
        return true;
    }
}
