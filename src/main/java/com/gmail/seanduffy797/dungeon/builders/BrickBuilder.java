package com.gmail.seanduffy797.dungeon.builders;

import com.fastasyncworldedit.core.FaweAPI;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Bricks;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.Pieces.PieceLayout;
import com.gmail.seanduffy797.dungeon.regions.Region;
import com.gmail.seanduffy797.dungeon.tasks.BrickStepTask;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.world.block.BlockTypes;
import org.bukkit.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

import static org.bukkit.Bukkit.*;

public class BrickBuilder {

    static int minX = -260;
    static int maxX = -48;
    static int minZ = -148;
    static int maxZ = 148;

    // USES X, Z, Y ORDER
    public static boolean[][][] map = new boolean[300][300][130];

    // This queue is used to build the dungeon outwards in a breadth first style
    // LOL nvm it's random now
    // This represents every hallway/path that still hasn't been completed
    public static ArrayList<BrickUnit> openEnds = new ArrayList<>();

    public static ArrayList<BrickUnit> bigPipe = new ArrayList<>();
    public static boolean isWool = true;
    public static boolean isDelayed = false;

    public static void build() {

        for (boolean[][] row: map)
            for (boolean[] col: row)
                Arrays.fill(col, false);

        BrickPiecePicker.init();
        if (!DungeonManager.isGenerated) {
            FocusMeta.init();
        }

        Location startPoint = new Location(Bukkit.getWorld("Dungeon"), -48, 102, 0);

        buildQueue(Region.BRICK, startPoint, StructureRotation.ROTATION_180);
    }

    public static void buildQueue(Region region, Location startPoint, StructureRotation rotation) {
        openEnds.add(new BrickUnit(region, startPoint, rotation, StructureMirror.NONE, 0, null));

        if (isDelayed) {
            BukkitTask task = new BrickStepTask().runTaskLater(Dungeon.getPlugin(), 40);
            DungeonManager.addTaskToRegion(Region.BRICK, task);
        } else {
            while (openEnds.size() > 0) {
                int len = openEnds.size();

                Random rand = new Random();
                int index = rand.nextInt(len);
                BrickUnit piece = openEnds.remove(index);
                placePiece(piece.start, piece.depth, piece.rotation, piece.region, (Bricks) piece.previous);
            }
        }
    }

    public static void takeStep() {
        if (openEnds.size() > 0) {
            int len = openEnds.size();

            Random rand = new Random();
            int index = rand.nextInt(len);
            BrickUnit piece = openEnds.remove(index);
            placePiece(piece.start, piece.depth, piece.rotation, piece.region, (Bricks) piece.previous);
        }
    }

    public static void clear() {
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(FaweAPI.getWorld(DungeonManager.world.getName()))) {
            CuboidRegion region = new CuboidRegion(BlockVector3.at(maxX, 50, minZ), BlockVector3.at(minX, 130, maxZ));
            editSession.setBlocks((com.sk89q.worldedit.regions.Region) region, BlockTypes.AIR);
        }

//        for (int z = minZ; z < maxZ; z += 5) {
//            for (int x = -48; x > minX; x -= 5) {
//                getServer().dispatchCommand(Bukkit.getConsoleSender(), "fill " + x + " 51 " + z + " " + (x - 5) + " 130 " + (z + 5) + " minecraft:air");
//            }
//        }
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

        Location offset = piece.getOffset();

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
                finalOffset = BuilderUtils.applyRotation(BuilderUtils.applyMirror(piece.getOffset(), isEven), rotation);
                cornerOffset = BuilderUtils.applyRotation(BuilderUtils.applyMirror(new Location(getWorld("Dungeon"), piece.getLength() - 1, piece.getHeight() - 1, piece.getWidth() - 1), isEven), rotation);
            } else {
                finalOffset = BuilderUtils.applyRotation(piece.getOffset(), rotation);
                cornerOffset = BuilderUtils.applyRotation(new Location(getWorld("Dungeon"), piece.getLength() - 1, piece.getHeight() - 1, piece.getWidth() - 1), rotation);
            }
            current.add(finalOffset);
            corner = new Location(current.getWorld(), current.getX(), current.getY(), current.getZ());
            corner.add(cornerOffset);
        }

        BuilderUtils.fillMap(map, current, corner);
        DungeonManager.updateRegionMap(current, corner, Region.BRICK);
        BrickPiecePicker.update(piece, region);
        piece.place(current, rotation, mirrorType);
        // For debugging:
        if (isWool && BrickPiecePicker.latestAssignmentSpot > 0) {
            coverWithWool(BrickPiecePicker.latestAssignmentSpot, current, corner, tries);
        }

        corner.subtract(cornerOffset);
        current.subtract(finalOffset);
        int newDepth = depth + 1;

        // HANDLE FOCUSES
        for (Focus foc: piece.getFocuses()) {
            Focus newFoc = foc.makeCopy(foc);
            Location newLoc = current.clone();
            if(mirror) {
                newFoc.mirror = StructureMirror.LEFT_RIGHT;
                newFoc.location = BuilderUtils.applyMirrorFocus(newFoc.location, isEven);
                newFoc.location = BuilderUtils.applyRotation(newFoc.location, rotation);
                newFoc.location = newFoc.location.add(newLoc);
            } else {
                newFoc.mirror = StructureMirror.NONE;
                newFoc.location = BuilderUtils.applyRotation(newFoc.location, rotation);
                newFoc.location = newFoc.location.add(newLoc);
            }
            newFoc.rotation = rotation;
            newFoc.start(Region.BRICK);
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
        if (isDelayed) {
            BukkitTask task = new BrickStepTask().runTaskLater(Dungeon.getPlugin(), 4);
        }
    }

    private static void coverWithWool(int assignmentIndex, Location corner1, Location corner2, int tries) {
        int startX = Math.min((int) corner1.getX(), (int) corner2.getX());
        int endX = Math.max((int) corner1.getX(), (int) corner2.getX());
        int startZ = Math.min((int) corner1.getZ(), (int) corner2.getZ());
        int endZ = Math.max((int) corner1.getZ(), (int) corner2.getZ());

        Material woolType = Material.BROWN_WOOL;
        switch (assignmentIndex) {
            case 1:
                // Necessary empty, end or straight shape
                woolType = Material.PINK_WOOL;
                break;
            case 2:
                // Necessary empty, other shape
                woolType = Material.RED_WOOL;
                break;
            case 3:
                // Necessary empty, all rooms used
                woolType = Material.LIGHT_BLUE_WOOL;
                break;
            case 4:
                // Necessary used
                woolType = Material.BLUE_WOOL;
                break;
            case 5:
                // End layout
                woolType = Material.YELLOW_WOOL;
                break;
            case 6:
                // Straight layout
                woolType = Material.ORANGE_WOOL;
                break;
            case 7:
                // Room layout
                woolType = Material.CYAN_WOOL;
                break;
            case 8:
                // Turn layout
                woolType = Material.PURPLE_WOOL;
                break;
            case 9:
                // T layout, stick with T
                woolType = Material.LIME_WOOL;
                break;
            case 10:
                // T layout, replace with hall
                woolType = Material.GREEN_WOOL;
                break;
            case 11:
                // Cross layout, stick with cross
                woolType = Material.WHITE_WOOL;
                break;
            case 12:
                // Cross layout, replace with T
                woolType = Material.LIGHT_GRAY_WOOL;
                break;
            case 13:
                // Cross layout, replace with hall
                woolType = Material.GRAY_WOOL;
                break;
            case 14:
                // Cross layout, replace with room
                woolType = Material.BLACK_WOOL;
                break;
            case 15:
                // Any layout, used by default
                woolType = Material.MAGENTA_WOOL;
                break;
        }

        for (int i = 1; i <= tries; i++) {
            DungeonManager.world.getBlockAt(new Location(DungeonManager.world, startX, corner2.getY() + 1 + i, startZ)).setType(Material.BROWN_WOOL);
        }
        for (int xVal = startX; xVal <= endX; xVal++) {
            for (int zVal = startZ; zVal <= endZ; zVal++) {
                DungeonManager.world.getBlockAt(new Location(DungeonManager.world, xVal, corner2.getY() + 1, zVal)).setType(woolType);
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
