package com.gmail.seanduffy797.dungeon.builders;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.Crypt;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public class CryptBuilder {

    public static boolean[][][] map = new boolean[300][300][150];

    public static void build() {

        for (boolean[][] row: map)
            for (boolean[] col: row)
                Arrays.fill(col, false);

        CryptPiecePicker.init();

        Location startPoint = new Location(Bukkit.getWorld("Dungeon"), 55, 50, 0);

        placePiece(startPoint, 0, StructureRotation.NONE,  null, 0);
    }

    public static void placePiece(Location current, int depth, StructureRotation rotation, Crypt previous, int turns) {

        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        if (plugin == null) {
            return;
        }

        Crypt piece;
        if (BuilderUtils.checkValid(current)) {
            piece = CryptPiecePicker.pick(depth, previous);
        } else {
            piece = CryptPiecePicker.getEnd();
        }
        int length = piece.getLength();
        int width = piece.getWidth();
        int height  = piece.getHeight();

        Location cornerOffset = new Location(getWorld("Dungeon"), length - 1, height - 1, width - 1);
        Location offset = piece.getOffset();

        boolean mirror = false;
        StructureMirror mirrorType = StructureMirror.NONE;
        if(piece.getMirror()) {
            if(Math.random() < 0.5) {
                mirror = true;
                mirrorType = StructureMirror.LEFT_RIGHT;
                offset = BuilderUtils.applyMirror(offset, true);
                cornerOffset = BuilderUtils.applyMirror(cornerOffset, true);
            }
        }

        Location finalOffset = BuilderUtils.applyRotation(offset, rotation);
        cornerOffset = BuilderUtils.applyRotation(cornerOffset, rotation);

        current.add(finalOffset);

        Location corner = new Location(current.getWorld(), current.getX(), current.getY(), current.getZ());
        corner.add(cornerOffset);

        int tries = 0;
        while(depth > 0 && BuilderUtils.checkMap(map, current, corner) && tries < 4) {
            tries++;
            if (tries == 1) {
                piece = CryptPiecePicker.getPiece(CryptPiecePicker.narrowHalls);
            } else if (tries == 2) {
                piece = CryptPiecePicker.getPiece(CryptPiecePicker.ends);
            } else if (tries == 3) {
                piece = Crypt.END1;
            } else {
                piece = Crypt.WALL;
            }
            getPluginManager().getPlugin("Dungeon").getLogger().log(Level.INFO, ChatColor.RED + "Try number: " + tries + " Tried to place: " + piece.getName());
            current.subtract(finalOffset);
            corner.subtract(cornerOffset);
            if(mirror) {
                finalOffset = BuilderUtils.applyRotation(BuilderUtils.applyMirror(piece.getOffset(), true), rotation);
                cornerOffset = BuilderUtils.applyRotation(BuilderUtils.applyMirror(new Location(getWorld("Dungeon"), piece.getLength() - 1, piece.getHeight() - 1, piece.getWidth() - 1), true), rotation);
            } else {
                finalOffset = BuilderUtils.applyRotation(piece.getOffset(), rotation);
                cornerOffset = BuilderUtils.applyRotation(new Location(getWorld("Dungeon"), piece.getLength() - 1, piece.getHeight() - 1, piece.getWidth() - 1), rotation);
            }
            current.add(finalOffset);
            corner = new Location(current.getWorld(), current.getX(), current.getY(), current.getZ());
            corner.add(cornerOffset);
        }

        BuilderUtils.fillMap(map, current, corner);

        corner.subtract(cornerOffset);

        CryptPiecePicker.update(piece);

        piece.place(current, rotation, mirrorType);

        current.subtract(finalOffset);

        if (piece.getChests().size() > 0){
            BuilderUtils.fillChests(piece.getChests(), current, rotation, mirror, true, "d:chests/cryptt1");
        }

        int newDepth = depth + 1;

        for (Location loc: piece.getExits()) {
            StructureRotation newRotation = StructureRotation.NONE;

            boolean turn = false;
            switch ((int) loc.getYaw()) {
                case 90:
                    newRotation = StructureRotation.ROTATION_90;
                    if (mirror) {
                        newRotation = StructureRotation.ROTATION_270;
                    }
                    turn = true;
                    break;
                case 180:
                    newRotation = StructureRotation.ROTATION_180;
                    turn = true;
                    break;
                case 270:
                    newRotation = StructureRotation.ROTATION_270;
                    if (mirror) {
                        newRotation = StructureRotation.ROTATION_90;
                    }
                    turn = true;
            }

            newRotation = BuilderUtils.addRotations(newRotation, rotation);

            if (turn) {
                turns++;
            }
            if (mirror) {
                placePiece(current.add(BuilderUtils.applyRotation(BuilderUtils.applyMirror(loc, true), rotation)), newDepth, newRotation, piece, turns);
                current.subtract(BuilderUtils.applyRotation(BuilderUtils.applyMirror(loc, true), rotation));
            } else {
                placePiece(current.add(BuilderUtils.applyRotation(loc, rotation)), newDepth, newRotation, piece, turns);
                current.subtract(BuilderUtils.applyRotation(loc, rotation));
            }
            if (turn) {
                turns--;
            }
        }
    }
}
