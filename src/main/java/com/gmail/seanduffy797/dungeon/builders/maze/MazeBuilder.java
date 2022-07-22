package com.gmail.seanduffy797.dungeon.builders.maze;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;

import java.util.ArrayList;
import java.util.Random;

public class MazeBuilder {

    public int length = 21; // Number of pieces front to back
    public int width = 21; // Number of pieces left to right
    public MazeUnit[][] maze = new MazeUnit[length][width];
    public MazeUnit startUnit;
    public double loopingChance;

    public MazeBuilder() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = new MazeUnit();
                if (i > 0) {
                    // Order of args is important - increasing index = going forward
                    MazeConnection connection = new MazeConnection(maze[i-1][j], maze[i][j]);
                    maze[i][j].setBack(connection);
                    maze[i-1][j].setForward(connection);
                }
                if (j > 0) {
                    // Order of args is important - increasing index = going to the right
                    MazeConnection connection = new MazeConnection(maze[i][j-1], maze[i][j]);
                    maze[i][j].setLeft(connection);
                    maze[i][j-1].setRight(connection);
                }
            }
        }

        startUnit = maze[0][10];
        startUnit.setExplored(true);
        startUnit.backException = true;
        ArrayList<MazeConnection> frontier = startUnit.getConnections();
        ExploreMaze(frontier);
    }

    public void ExploreMaze(ArrayList<MazeConnection> frontier) {
        if (frontier.size() == 0) {
            return;
        }

        Random rnd = new Random();
        int index = rnd.nextInt(frontier.size());

        MazeConnection connection = frontier.remove(index);
        connection.open();
        MazeUnit newUnit = connection.getUnexploredUnit();
        connection.markExplored();
        for (MazeConnection next: newUnit.getConnections()) {
            if (next != connection) {
                if (next.isExplored()) {
                    frontier.remove(next);
                    if (Math.random() < loopingChance) {
                        next.open();
                    }
                } else {
                    frontier.add(next);
                }
            }
        }
        ExploreMaze(frontier);
    }

    public MazeUnit[][] getMaze() {
        return maze;
    }

    public PieceOutline[][] getMazePieceOutlines() {
        PieceOutline[][] outlines = new PieceOutline[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                outlines[i][j] = getOutlineForMazeUnit(maze[i][j]);
            }
        }
        return outlines;
    }

    public PieceOutline getOutlineForMazeUnit(MazeUnit unit) {
        boolean forward = unit.isForwardOpen();
        boolean right = unit.isRightOpen();
        boolean back = unit.isBackOpen();
        boolean left = unit.isLeftOpen();
        PieceOutline outline;
        if (forward && back && !right && !left) { // front-back straight
            outline = new PieceOutline(MazeUnitShape.STRAIGHT, StructureRotation.NONE, StructureMirror.NONE);
        } else if (!forward && !back && right && left) { // left-right straight
            outline = new PieceOutline(MazeUnitShape.STRAIGHT, StructureRotation.ROTATION_90, StructureMirror.NONE);
        } else if (!forward && back && !right && left) {
            outline = new PieceOutline(MazeUnitShape.TURN, StructureRotation.NONE, StructureMirror.NONE);
        } else if (forward && !back && !right && left) {
            outline = new PieceOutline(MazeUnitShape.TURN, StructureRotation.ROTATION_90, StructureMirror.NONE);
        } else if (forward && !back && right && !left) {
            outline = new PieceOutline(MazeUnitShape.TURN, StructureRotation.ROTATION_180, StructureMirror.NONE);
        } else if (!forward && back && right && !left) {
            outline = new PieceOutline(MazeUnitShape.TURN, StructureRotation.ROTATION_270, StructureMirror.NONE);
        } else if (!forward && back && !right && !left) {
            outline = new PieceOutline(MazeUnitShape.END, StructureRotation.NONE, StructureMirror.NONE);
        } else if (!forward && !back && !right && left) {
            outline = new PieceOutline(MazeUnitShape.END, StructureRotation.ROTATION_90, StructureMirror.NONE);
        } else if (forward && !back && !right && !left) {
            outline = new PieceOutline(MazeUnitShape.END, StructureRotation.ROTATION_180, StructureMirror.NONE);
        } else if (!forward && !back && right && !left) {
            outline = new PieceOutline(MazeUnitShape.END, StructureRotation.ROTATION_270, StructureMirror.NONE);
        } else if (forward && back && !right && left) {
            outline = new PieceOutline(MazeUnitShape.T, StructureRotation.NONE, StructureMirror.NONE);
        } else if (forward && !back && right && left) {
            outline = new PieceOutline(MazeUnitShape.T, StructureRotation.ROTATION_90, StructureMirror.NONE);
        } else if (forward && back && right && !left) {
            outline = new PieceOutline(MazeUnitShape.T, StructureRotation.ROTATION_180, StructureMirror.NONE);
        } else if (!forward && back && right && left) {
            outline = new PieceOutline(MazeUnitShape.T, StructureRotation.ROTATION_270, StructureMirror.NONE);
        } else if (forward && back && right && left) {
            outline = new PieceOutline(MazeUnitShape.CROSS, StructureRotation.NONE, StructureMirror.NONE);
        } else {
            outline = new PieceOutline(MazeUnitShape.CROSS, StructureRotation.NONE, StructureMirror.LEFT_RIGHT);
        }
        return outline;
    }
}
