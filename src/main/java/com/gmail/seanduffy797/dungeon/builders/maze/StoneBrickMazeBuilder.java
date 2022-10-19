package com.gmail.seanduffy797.dungeon.builders.maze;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import com.gmail.seanduffy797.dungeon.Pieces.StoneBrickMaze;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class StoneBrickMazeBuilder {

    public static final int MAZE_SCALE = 3;
    public static final int VERTICAL_SCALE = 4;
    private final int height;
    private final int length;
    private final int width;
    private int[] start;
    private ArrayList<int[]> exits;
    private double loopChance;
    private static Location corner1;
    private static Location corner2;

    public StoneBrickMazeBuilder(int height, int length, int width, int[] start, ArrayList<int[]> exits, double loopChance) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.start = start;
        this.exits = exits;
        this.loopChance = loopChance;
    }

    public void buildStoneBrickMaze(Location startLocation, StructureRotation facing) {
        MazeBuilder mazeBuilder = new MazeBuilder(height, length, width, start, exits, loopChance);

        PieceOutline[][][] outlines = mazeBuilder.getMazePieceOutlines();

        MazePieceTable.init();
        StoneBrickMaze[][][] pieces = getPiecesFromOutline(outlines);

        int startY = start[0];
        int startX = start[1];
        int startZ = start[2];

        // Hey, it's ugly! gotta find a better solution to not hard code this, maybe
        // "center" is used to rotate the pieces around their center point
        // "center to front" is used for focuses, since they're saved relative to the front
        Location center = new Location(DungeonManager.world, -1, -1, -1);
        Location centerToFront = new Location(DungeonManager.world, -1, 0, 0);
        Location[][][] offsets = getLocationOffsets(startY, startX, startZ, facing);

        if (!DungeonManager.isGenerated) {
            FocusMeta.init();
            DungeonManager.isGenerated = true;
        }

        // Keep track of opposite corners of the maze, so it can be cleared efficiently afterwards
        corner1 = offsets[0][0][0].clone()
                .add(startLocation)
                .add(BuilderUtils.applyRotation(center, facing));
        corner2 = offsets[height-1][length-1][width-1].clone()
                .add(startLocation)
                .add(BuilderUtils.applyRotation(center, facing))
                .add(BuilderUtils.applyRotation(new Location(DungeonManager.world,
                        MAZE_SCALE-1,
                        VERTICAL_SCALE,
                        MAZE_SCALE-1),
                        facing));

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    StoneBrickMaze piece = pieces[k][i][j];
                    StructureRotation rotation = BuilderUtils.addRotations(outlines[k][i][j].rotation, facing);
                    StructureMirror mirror = StructureMirror.NONE;
                    Location pieceOffset = BuilderUtils.applyRotation(center, rotation);
                    Location location = offsets[k][i][j].add(startLocation).add(pieceOffset);
                    piece.place(location, rotation, mirror);

                    if (k == height - 1) {
                        StoneBrickMaze roof = StoneBrickMaze.ROOF;
                        Location roofLocation = location.clone().add(new Location(DungeonManager.world, 0, VERTICAL_SCALE, 0));
                        roof.place(roofLocation, rotation, mirror);
                    }

                    Location loc = location.subtract(pieceOffset);

                    // Handle focuses
                    for (Focus foc : piece.getFocuses()) {
                        Focus newFoc = foc.makeCopy(foc);
                        newFoc.location.add(centerToFront);
                        Location newLoc = loc.clone();
                        if (mirror.equals(StructureMirror.LEFT_RIGHT)) {
                            newFoc.mirror = StructureMirror.LEFT_RIGHT;
                            newFoc.location = newLoc.add(BuilderUtils.applyRotation(BuilderUtils.applyMirror(newFoc.location, false), rotation));
                        } else {
                            newFoc.mirror = StructureMirror.NONE;
                            newFoc.location = newLoc.add(BuilderUtils.applyRotation(newFoc.location, rotation));
                        }
                        newFoc.rotation = rotation;
                        newFoc.start(Region.STONE_BRICK);
                    }
                }
            }
        }
        DungeonManager.updateRegionMap(corner1, corner2, Region.STONE_BRICK);
    }

    public StoneBrickMaze[][][] getPiecesFromOutline(PieceOutline[][][] outlines) {
        StoneBrickMaze[][][] pieces = new StoneBrickMaze[height][length][width];
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    pieces[k][i][j] = getPieceFromOutline(outlines[k][i][j]);
                }
            }
        }
        return pieces;
    }
    public StoneBrickMaze getPieceFromOutline(PieceOutline outline) {
        return MazePieceTable.getPiece(outline.shape);
    }

    public Location[][][] getLocationOffsets(int startY, int startX, int startZ, StructureRotation rotation) {
        Location[][][] offsets = new Location[height][length][width];
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    offsets[k][i][j] = BuilderUtils.applyRotation(
                            new Location(DungeonManager.world,
                                    MAZE_SCALE * (i - startX) + 1,
                                    VERTICAL_SCALE * (k - startY),
                                    MAZE_SCALE * (j - startZ)), rotation);
                }
            }
        }
        return offsets;
    }

    public static void clear() {
        for (int x = (int) Math.min(corner1.getX(), corner2.getX()); x <= Math.max(corner1.getX(), corner2.getX()); x++) {
            for (int y = (int) Math.min(corner1.getY(), corner2.getY()); y <= Math.max(corner1.getY(), corner2.getY()); y++) {
                for (int z = (int) Math.min(corner1.getZ(), corner2.getZ()); z <= Math.max(corner1.getZ(), corner2.getZ()); z++) {
                    Block block = DungeonManager.world.getBlockAt(x, y, z);
                    if (block.getType() != Material.AIR) {
                        block.setType(Material.AIR);
                    }
                }
            }
        }
    }
}
