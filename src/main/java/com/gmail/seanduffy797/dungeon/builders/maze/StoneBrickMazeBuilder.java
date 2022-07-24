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

        StoneBrickMaze[][][] pieces = getPiecesFromOutline(outlines);

        int startY = start[0];
        int startX = start[1];
        int startZ = start[2];

        // Hey, it's ugly! gotta find a better solution to not hard code this, maybe
        Location center = new Location(DungeonManager.world, -1, -1, -1);
        Location centerToFront = new Location(DungeonManager.world, -1, 0, 0);
        Location[][][] offsets = getLocationOffsets(startY, startX, startZ, facing);

        if (!DungeonManager.isGenerated) {
            TaskList.tasks = new ArrayList<>();
            FocusMeta.init();
            DungeonManager.isGenerated = true;
        }

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
            if (rand < 0.18) {
                return StoneBrickMaze.STRAIGHT;
            } else if (rand < 0.36) {
                return StoneBrickMaze.STRAIGHT_DOOR;
            } else if (rand < 0.54) {
                return StoneBrickMaze.STRAIGHT_COBWEBS;
            } else if (rand < 0.72) {
                return StoneBrickMaze.STRAIGHT_WOOD;
            } else if (rand < 0.84) {
                return StoneBrickMaze.STRAIGHT_SECRET;
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
            if (rand < 0.2) {
                return StoneBrickMaze.TURN_OPEN;
            } else if (rand < 0.4) {
                return StoneBrickMaze.TURN_BOOKS;
            } else if (rand < 0.6) {
                return StoneBrickMaze.TURN_DOORS;
            } else if (rand < 0.8) {
                return StoneBrickMaze.TURN_LIGHT;
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
            if (rand < 0.1) {
                return StoneBrickMaze.T_OPEN;
            } else if (rand < 0.2) {
                return StoneBrickMaze.T_TABLE;
            } else if (rand < 0.3) {
                return StoneBrickMaze.T_BOOKS;
            } else if (rand < 0.4) {
                return StoneBrickMaze.T_PILLARS;
            } else if (rand < 0.5) {
                return StoneBrickMaze.T_SHELF;
            } else if (rand < 0.6) {
                return StoneBrickMaze.T_SHELF2;
            } else if (rand < 0.7) {
                return StoneBrickMaze.T_SHELF3;
            } else if (rand < 0.8) {
                return StoneBrickMaze.T_SHELF4;
            } else {
                return StoneBrickMaze.T_DOOR;
            }
        } else if (outline.shape == MazeUnitShape.CROSS) {
            if (outline.goingUp) {
                if (outline.goingDown) {
                    return StoneBrickMaze.CROSS_LADDER_MIDDLE;
                }
                if (rand < .5) {
                    return StoneBrickMaze.CROSS_LADDER_UP;
                } else {
                    return StoneBrickMaze.CROSS_LADDER_UP2;
                }
            }
            if (outline.goingDown) {
                if (rand < .5) {
                    return StoneBrickMaze.CROSS_LADDER_DOWN;
                } else {
                    return StoneBrickMaze.CROSS_LADDER_DOWN2;
                }
            }
            if (rand < 0.16) {
                return StoneBrickMaze.CROSS_OPEN;
            } else if (rand < 0.32) {
                return StoneBrickMaze.CROSS_PILLAR;
            } else if (rand < 0.48) {
                return StoneBrickMaze.CROSS_LOGS;
            } else if (rand < 0.64) {
                return StoneBrickMaze.CROSS_BOOKS;
            } else if (rand < 0.80) {
                return StoneBrickMaze.CROSS_SKELETON_DOOR;
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
                if (rand < .5) {
                    return StoneBrickMaze.SOLID_LADDER_DOWN;
                } else {
                    return StoneBrickMaze.SOLID_LADDER_DOWN2;
                }
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
