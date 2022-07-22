package com.gmail.seanduffy797.dungeon.builders.maze;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.StoneBrickMaze;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import com.gmail.seanduffy797.dungeon.builders.maze.MazeBuilder;
import com.gmail.seanduffy797.dungeon.builders.maze.MazeUnitShape;
import com.gmail.seanduffy797.dungeon.builders.maze.PieceOutline;
import org.bukkit.Location;

public class StoneBrickMazeBuilder {

    public static final int MAZE_SCALE = 3;

    public void buildStoneBrickMaze(Location start, StructureRotation facing) {
        MazeBuilder mazeBuilder = new MazeBuilder();
        PieceOutline[][] outlines = mazeBuilder.getMazePieceOutlines();

        StoneBrickMaze[][] pieces = getPiecesFromOutline(outlines);

        int startX = 0;
        int startZ = 10;

        // Hey, it's ugly! gotta find a better solution to this, maybe
        Location center = new Location(DungeonManager.world, -1, -1, -1);
        Location[][] offsets = getLocationOffsets(startX, startZ, facing);

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                StoneBrickMaze piece = pieces[i][j];
                StructureRotation rotation = BuilderUtils.addRotations(outlines[i][j].rotation, facing);
                StructureMirror mirror = StructureMirror.NONE;
                Location pieceOffset = BuilderUtils.applyRotation(center, rotation);
                Location location = offsets[i][j].add(start).add(pieceOffset);
                piece.place(location, rotation, mirror);
            }
        }
    }

    public StoneBrickMaze[][] getPiecesFromOutline(PieceOutline[][] outlines) {
        StoneBrickMaze[][] pieces = new StoneBrickMaze[21][21];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                pieces[i][j] = getPieceFromOutline(outlines[i][j]);
            }
        }
        return pieces;
    }
    public StoneBrickMaze getPieceFromOutline(PieceOutline outline) {
        if (outline.shape == MazeUnitShape.STRAIGHT) {
            return StoneBrickMaze.STRAIGHT;
        } else if (outline.shape == MazeUnitShape.TURN) {
            return StoneBrickMaze.TURN;
        } else if (outline.shape == MazeUnitShape.T) {
            return StoneBrickMaze.T;
        } else if (outline.shape == MazeUnitShape.CROSS) {
            return StoneBrickMaze.CROSS;
        } else if (outline.shape == MazeUnitShape.END) {
            return StoneBrickMaze.END;
        }
        return StoneBrickMaze.CROSS;
    }

    public Location[][] getLocationOffsets(int startX, int startZ, StructureRotation rotation) {
        Location[][] offsets = new Location[21][21];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                offsets[i][j] = BuilderUtils.applyRotation(
                        new Location(DungeonManager.world,
                                MAZE_SCALE*(i-startX),
                                0,
                                MAZE_SCALE*(j-startZ)), rotation);
            }
        }
        return offsets;
    }
}
