package com.gmail.seanduffy797.dungeon.builders.maze;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.Pieces.StoneBrickMaze;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.Location;

import java.util.ArrayList;

public class StoneBrickMazeBuilder {

    public static final int MAZE_SCALE = 3;
    public static final int VERTICAL_SCALE = 4;
    private final int height = 3;
    private final int length;
    private final int width;
    private int[] start;
    private ArrayList<int[]> exits;
    private double loopChance;

    public StoneBrickMazeBuilder(int length, int width, int[] start, ArrayList<int[]> exits, double loopChance) {
        this.length = length;
        this.width = width;
        this.start = start;
        this.exits = exits;
        this.loopChance = loopChance;
    }

    public void buildStoneBrickMaze(Location startLocation, StructureRotation facing) {
        MazeBuilder mazeBuilder = new MazeBuilder(length, width, start, exits, loopChance);

        PieceOutline[][][] outlines = mazeBuilder.getMazePieceOutlines();

        StoneBrickMaze[][][] pieces = getPiecesFromOutline(outlines);

        int startY = start[0];
        int startX = start[1];
        int startZ = start[2];

        // Hey, it's ugly! gotta find a better solution to not hard code this, maybe
        Location center = new Location(DungeonManager.world, -1, -1, -1);
        Location centerToFront = new Location(DungeonManager.world, -1, 0, 0);
        Location[][][] offsets = getLocationOffsets(startY, startX, startZ, facing);

        TaskList.tasks = new ArrayList<>();
        FocusMeta.init();

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    StoneBrickMaze piece = pieces[k][i][j];
                    StructureRotation rotation = BuilderUtils.addRotations(outlines[k][i][j].rotation, facing);
                    StructureMirror mirror = StructureMirror.NONE;
                    Location pieceOffset = BuilderUtils.applyRotation(center, rotation);
                    Location location = offsets[k][i][j].add(startLocation).add(pieceOffset);
                    piece.place(location, rotation, mirror);

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
                        newFoc.start();
                    }
                }
            }
        }
        DungeonManager.isGenerated = true;
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
        double rand = Math.random();
        if (outline.shape == MazeUnitShape.STRAIGHT) {
            if (outline.goingUp) {
                if (outline.goingDown) {
                    return StoneBrickMaze.STRAIGHT_LADDER_MIDDLE;
                }
                return StoneBrickMaze.STRAIGHT_LADDER_UP;
            }
            if (outline.goingDown) {
                return StoneBrickMaze.STRAIGHT_LADDER_DOWN;
            }
            if (rand < 0.25) {
                return StoneBrickMaze.STRAIGHT;
            } else if (rand < 0.5) {
                return StoneBrickMaze.STRAIGHT_DOOR;
            } else if (rand < 0.75) {
                return StoneBrickMaze.STRAIGHT_COBWEBS;
            } else {
                return StoneBrickMaze.STRAIGHT_PAINTINGS;
            }
        } else if (outline.shape == MazeUnitShape.TURN) {
            if (outline.goingUp) {
                if (outline.goingDown) {
                    return StoneBrickMaze.TURN_LADDER_MIDDLE;
                }
                return StoneBrickMaze.TURN_LADDER_UP;
            }
            if (outline.goingDown) {
                return StoneBrickMaze.TURN_LADDER_DOWN;
            }
            if (rand < 0.25) {
                return StoneBrickMaze.TURN_OPEN;
            } else if (rand < 0.5) {
                return StoneBrickMaze.TURN_BOOKS;
            } else if (rand < 0.75) {
                return StoneBrickMaze.TURN_DOORS;
            } else {
                return StoneBrickMaze.TURN_CANDLES;
            }
        } else if (outline.shape == MazeUnitShape.T) {
            if (outline.goingUp) {
                if (outline.goingDown) {
                    return StoneBrickMaze.T_LADDER_MIDDLE;
                }
                return StoneBrickMaze.T_LADDER_UP;
            }
            if (outline.goingDown) {
                return StoneBrickMaze.T_LADDER_DOWN;
            }
            if (rand < 0.25) {
                return StoneBrickMaze.T_OPEN;
            } else if (rand < 0.4) {
                return StoneBrickMaze.T_TABLE;
            } else if (rand < 0.6) {
                return StoneBrickMaze.T_BOOKS;
            } else if (rand < 0.8) {
                return StoneBrickMaze.T_PILLARS;
            } else {
                return StoneBrickMaze.T_SHELF;
            }
        } else if (outline.shape == MazeUnitShape.CROSS) {
            if (outline.goingUp) {
                if (outline.goingDown) {
                    return StoneBrickMaze.CROSS_LADDER_MIDDLE;
                }
                return StoneBrickMaze.CROSS_LADDER_UP;
            }
            if (outline.goingDown) {
                return StoneBrickMaze.CROSS_LADDER_DOWN;
            }
            if (rand < 0.4) {
                return StoneBrickMaze.CROSS_OPEN;
            } else if (rand < 0.7) {
                return StoneBrickMaze.CROSS_PILLAR;
            } else {
                return StoneBrickMaze.CROSS_CANDLE;
            }
        } else if (outline.shape == MazeUnitShape.END) {
            if (outline.goingUp) {
                if (outline.goingDown) {
                    return StoneBrickMaze.END_LADDER_MIDDLE;
                }
                return StoneBrickMaze.END_LADDER_UP;
            }
            if (outline.goingDown) {
                return StoneBrickMaze.END_LADDER_DOWN;
            }
            if (rand < 0.25) {
                return StoneBrickMaze.END;
            } else if (rand < 0.5) {
                return StoneBrickMaze.END_CHEST;
            } else if (rand < 0.75) {
                return StoneBrickMaze.END_PEARL;
            } else {
                return StoneBrickMaze.END_SPAWNER;
            }
        } else if (outline.shape == MazeUnitShape.SOLID) {
            if (outline.goingUp) {
                if (outline.goingDown) {
                    return StoneBrickMaze.SOLID_LADDER_MIDDLE;
                }
                return StoneBrickMaze.SOLID_LADDER_UP;
            }
            if (outline.goingDown) {
                return StoneBrickMaze.SOLID_LADDER_DOWN;
            }
        }
        return StoneBrickMaze.CROSS;
    }

    public Location[][][] getLocationOffsets(int startY, int startX, int startZ, StructureRotation rotation) {
        Location[][][] offsets = new Location[height][length][width];
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    offsets[k][i][j] = BuilderUtils.applyRotation(
                            new Location(DungeonManager.world,
                                    MAZE_SCALE * (i - startX),
                                    VERTICAL_SCALE * (k - startY),
                                    MAZE_SCALE * (j - startZ)), rotation);
                }
            }
        }
        return offsets;
    }
}
