package com.gmail.seanduffy797.dungeon.builders;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.Bricks;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.Pieces.PieceLayout;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.*;
import org.bukkit.plugin.Plugin;

import java.util.*;

import static org.bukkit.Bukkit.*;

public class BrickBuilder {

    static int minX = 56;
    static int maxX = 298;
    static int minZ = -148;
    static int maxZ = 148;

    public static boolean[][][] map = new boolean[300][300][130];

    // This queue is used to build the dungeon outwards in a breadth first style
    // LOL nvm it's random now
    // This represents every hallway/path that still hasn't been completed
    public static ArrayList<BrickUnit> openEnds = new ArrayList<>();

    public static ArrayList<BrickUnit> bigPipe = new ArrayList<>();

    public static void build() {

        for (boolean[][] row: map)
            for (boolean[] col: row)
                Arrays.fill(col, false);

        BrickPiecePicker.init();
        TaskList.tasks = new ArrayList<>();
        FocusMeta.init();

        Location startPoint = new Location(Bukkit.getWorld("Dungeon"), 55, 50, 0);

        buildQueue(Region.BRICK, startPoint, StructureRotation.NONE);
    }

    public static void buildQueue(Region region, Location startPoint, StructureRotation rotation) {
        openEnds.add(new BrickUnit(region, startPoint, rotation, StructureMirror.NONE, 0, null));

        while (openEnds.size() > 0) {
            int len = openEnds.size();

            Random rand = new Random();
            int index = rand.nextInt(len);
            BrickUnit piece = openEnds.remove(index);
            placePiece(piece.start, piece.depth, piece.rotation, piece.region, (Bricks) piece.previous);
        }

        // buildBigPipe(bigPipe);
    }

    public static void clear() {
        for (int z = minZ; z < maxZ; z += 5) {
            for (int x = minX - 1; x < maxX; x += 5) {
                getServer().dispatchCommand(Bukkit.getConsoleSender(), "fill " + x + " 1 " + z + " " + (x + 5) + " 80 " + (z + 5) + " minecraft:air");
            }
        }
    }

    public static void placePiece(Location current, int depth, StructureRotation rotation, Region region, Bricks previous) {

        OpenSpaces spaces = checkSurroundings(current, rotation);

        PieceLayout layout = BuilderUtils.pickLayout(spaces);

        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        if(plugin == null) {return;}

        Bricks piece;
        //piece = BrickPiecePicker.pick(depth, region, previous);
        piece = BrickPiecePicker.pick(layout, region, depth, previous);

        int length = piece.getLength();
        int width = piece.getWidth();
        int height = piece.getHeight();
        Location cornerOffset = new Location(getWorld("Dungeon"), length - 1, height - 1, width - 1);

        Location offset = piece.getStartOffset();

        boolean isEven = piece.isEven();
        boolean mirror = false;
        StructureMirror mirrorType = StructureMirror.NONE;
        if(piece.getMirror()) {
            if (layout == PieceLayout.LEFTTURN || layout == PieceLayout.LEFT_T) {
                mirror = false;
            } else if (layout == PieceLayout.RIGHTTURN || layout == PieceLayout.RIGHT_T) {
                mirror = true;
                offset = BuilderUtils.applyMirror(offset, isEven);
                cornerOffset = BuilderUtils.applyMirror(cornerOffset, isEven);
                mirrorType = StructureMirror.LEFT_RIGHT;
            } else if (Math.random() < 0.5) {
                mirror = true;
                offset = BuilderUtils.applyMirror(offset, isEven);
                cornerOffset = BuilderUtils.applyMirror(cornerOffset, isEven);
                mirrorType = StructureMirror.LEFT_RIGHT;
            }
        }

        Location finalOffset = BuilderUtils.applyRotation(offset, rotation);
        cornerOffset = BuilderUtils.applyRotation(cornerOffset, rotation);

        current.add(finalOffset);

        Location corner = new Location(current.getWorld(), current.getX(), current.getY(), current.getZ());
        corner.add(cornerOffset);

        // COLLISION DETECTION
        int tries = 0;
        while(depth > 0 && BuilderUtils.checkMap(map, current, corner) && tries < 4) {
            tries++;
            piece = BrickPiecePicker.replace(region, tries, piece);
            //getPluginManager().getPlugin("Dungeon").getLogger().log(Level.INFO, ChatColor.RED + "Try number: " + tries + " Tried to place: " + piece.getName());
            current.subtract(finalOffset);
            corner.subtract(cornerOffset);
            if(mirror) {
                isEven = piece.isEven();
                finalOffset = BuilderUtils.applyRotation(BuilderUtils.applyMirror(piece.getStartOffset(), isEven), rotation);
                cornerOffset = BuilderUtils.applyRotation(BuilderUtils.applyMirror(new Location(getWorld("Dungeon"), piece.getLength() - 1, piece.getHeight() - 1, piece.getWidth() - 1), isEven), rotation);
            } else {
                finalOffset = BuilderUtils.applyRotation(piece.getStartOffset(), rotation);
                cornerOffset = BuilderUtils.applyRotation(new Location(getWorld("Dungeon"), piece.getLength() - 1, piece.getHeight() - 1, piece.getWidth() - 1), rotation);
            }
            current.add(finalOffset);
            corner = new Location(current.getWorld(), current.getX(), current.getY(), current.getZ());
            corner.add(cornerOffset);
        }

        BuilderUtils.fillMap(map, current, corner);
        BrickPiecePicker.update(piece, region);
        piece.place(current, rotation, mirrorType);

        corner.subtract(cornerOffset);
        current.subtract(finalOffset);
        int newDepth = depth + 1;

        // HANDLE FOCUSES
        for (Focus foc: piece.getFocuses()) {
            Focus newFoc = foc.makeCopy(foc);
            Location newLoc = current.clone();
            if(mirror) {
                newFoc.mirror = StructureMirror.LEFT_RIGHT;
                newFoc.location = newLoc.add(BuilderUtils.applyRotation(BuilderUtils.applyMirror(newFoc.location, isEven), rotation));
            } else {
                newFoc.mirror = StructureMirror.NONE;
                newFoc.location = newLoc.add(BuilderUtils.applyRotation(newFoc.location, rotation));
            }
            newFoc.rotation = rotation;
            newFoc.start();
        }

        // PREPARING THE NEXT SECTIONS
        for (Location loc: piece.getExits().keySet()) {
            StructureRotation newRotation = StructureRotation.NONE;

            Region newRegion = piece.getExits().get(loc);
            if(newRegion == Region.INHERIT) {
                newRegion = region;
            }

            switch((int)loc.getYaw()) {
                case 90:
                    newRotation = StructureRotation.ROTATION_90;
                    if (mirror) {newRotation = StructureRotation.ROTATION_270;}
                    break;
                case 180:
                    newRotation = StructureRotation.ROTATION_180;
                    break;
                case 270:
                    newRotation = StructureRotation.ROTATION_270;
                    if (mirror) {newRotation = StructureRotation.ROTATION_90;}
            }

            newRotation = BuilderUtils.addRotations(newRotation, rotation);
            Location newLoc = new Location(getWorld("Dungeon"), current.getX(), current.getY(), current.getZ());

            if(newRegion == Region.BIGPIPE) {
                bigPipe.add(new BrickUnit(newRegion, newLoc.add(BuilderUtils.applyRotation(loc, rotation)), newRotation, StructureMirror.NONE, newDepth, piece));
            } else if(mirror) {
                // If statement is necessary for the edge case of an odd width path transitioning to an even width one
                if ((region == Region.SEWER || region == Region.BRICK) && newRegion == Region.PIPE2) {
                    openEnds.add(new BrickUnit(newRegion, newLoc.add(BuilderUtils.applyRotation(BuilderUtils.applyMirror(loc, isEven, true), rotation)), newRotation, StructureMirror.NONE, newDepth, piece));
                } else {
                    openEnds.add(new BrickUnit(newRegion, newLoc.add(BuilderUtils.applyRotation(BuilderUtils.applyMirror(loc, isEven), rotation)), newRotation, StructureMirror.NONE, newDepth, piece));
                }
            } else {
                openEnds.add(new BrickUnit(newRegion, newLoc.add(BuilderUtils.applyRotation(loc, rotation)), newRotation, StructureMirror.NONE, newDepth, piece));
            }
        }
    }

    public static void buildBigPipe(ArrayList<BrickUnit> ends) {
        if (ends.size() != 2) {
            getServer().getConsoleSender().sendMessage("[Dungeon]: Sewer generated wrong: wrong number of big pipe openings");
            return;
        }
        BrickUnit opening1 = ends.get(0);
        BrickUnit opening2 = ends.get(1);

        // ROTATION REFERENCE: 0 = North = +x |||| 90 = EAST = +z |||| 180 = SOUTH = -x |||| 270 = WEST = -z
        int xDistance = (int)(opening1.start.getX() - opening2.start.getX());
        int zDistance = (int)(opening1.start.getZ() - opening2.start.getZ());



    }

    public static OpenSpaces checkSurroundings(Location startPoint, StructureRotation rotation){
        OpenSpaces spaces = new OpenSpaces();

        Location l1Start = BuilderUtils.applyRotation(OpenSpaces.l1Start, rotation);
        Location l1Corner = BuilderUtils.applyRotation(OpenSpaces.l1Corner, rotation);

        l1Start = startPoint.clone().add(l1Start);
        l1Corner = startPoint.clone().add(l1Corner);

        if(!BuilderUtils.checkMap(map, l1Start, l1Corner)) {
            spaces.left1 = true;

            Location l2Start = BuilderUtils.applyRotation(OpenSpaces.l2Start, rotation);
            Location l2Corner = BuilderUtils.applyRotation(OpenSpaces.l2Corner, rotation);

            l2Start = startPoint.clone().add(l2Start);
            l2Corner = startPoint.clone().add(l2Corner);
            if(!BuilderUtils.checkMap(map, l2Start, l2Corner)) {
                spaces.left2 = true;
            }
        }

        Location r1Start = BuilderUtils.applyRotation(OpenSpaces.r1Start, rotation);
        Location r1Corner = BuilderUtils.applyRotation(OpenSpaces.r1Corner, rotation);

        r1Start = startPoint.clone().add(r1Start);
        r1Corner = startPoint.clone().add(r1Corner);
        if(!BuilderUtils.checkMap(map, r1Start, r1Corner)) {
            spaces.right1 = true;

            Location r2Start = BuilderUtils.applyRotation(OpenSpaces.r2Start, rotation);
            Location r2Corner = BuilderUtils.applyRotation(OpenSpaces.r2Corner, rotation);

            r2Start = startPoint.clone().add(r2Start);
            r2Corner = startPoint.clone().add(r2Corner);
            if(!BuilderUtils.checkMap(map, r2Start, r2Corner)) {
                spaces.right2 = true;
            }
        }

        Location f1Start = BuilderUtils.applyRotation(OpenSpaces.f1Start, rotation);
        Location f1Corner = BuilderUtils.applyRotation(OpenSpaces.f1Corner, rotation);

        f1Start = startPoint.clone().add(f1Start);
        f1Corner = startPoint.clone().add(f1Corner);
        if(!BuilderUtils.checkMap(map, f1Start, f1Corner)) {
            spaces.front1 = true;

            Location f2Start = BuilderUtils.applyRotation(OpenSpaces.f2Start, rotation);
            Location f2Corner = BuilderUtils.applyRotation(OpenSpaces.f2Corner, rotation);

            f2Start = startPoint.clone().add(f2Start);
            f2Corner = startPoint.clone().add(f2Corner);
            if(!BuilderUtils.checkMap(map, f2Start, f2Corner)) {
                spaces.front2 = true;
            }
        }

        return spaces;
    }
}
