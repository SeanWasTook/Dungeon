package com.gmail.seanduffy797.dungeon.builders.maze;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;

import java.util.ArrayList;
import java.util.Random;

public class MazeBuilder {

    public int height;
    public int length; // Number of pieces front to back
    public int width; // Number of pieces left to right
    public MazeUnit[][][] maze;
    public MazeUnit startUnit;
    public double loopingChance;

    public MazeBuilder(int height, int length, int width, int[] start, ArrayList<int[]> exits, double loopingChance) {
        this.height = height;
        this.length = length;
        this.width = width;
        maze = new MazeUnit[height][length][width];
        this.loopingChance = loopingChance;

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    maze[k][i][j] = new MazeUnit();
                    if (k > 0) {
                        // Order of args is important - increasing index = going up
                        MazeConnection connection = new MazeConnection(maze[k-1][i][j], maze[k][i][j]);
                        connection.setVertical();
                        maze[k][i][j].setDown(connection);
                        maze[k-1][i][j].setUp(connection);
                    }
                    if (i > 0) {
                        // Order of args is important - increasing index = going forward
                        MazeConnection connection = new MazeConnection(maze[k][i - 1][j], maze[k][i][j]);
                        maze[k][i][j].setBack(connection);
                        maze[k][i - 1][j].setForward(connection);
                    }
                    if (j > 0) {
                        // Order of args is important - increasing index = going to the right
                        MazeConnection connection = new MazeConnection(maze[k][i][j - 1], maze[k][i][j]);
                        maze[k][i][j].setLeft(connection);
                        maze[k][i][j - 1].setRight(connection);
                    }
                }
            }
        }

        // Open the exits to the outside
        for (int[] exit : exits) {
            switch(exit[3]) {
                case(0):
                    maze[exit[0]][exit[1]][exit[2]].forwardException = true;
                    break;
                case(90):
                    maze[exit[0]][exit[1]][exit[2]].rightException = true;
                    break;
                case(180):
                    maze[exit[0]][exit[1]][exit[2]].backException = true;
                    break;
                case(270):
                    maze[exit[0]][exit[1]][exit[2]].leftException = true;
                    break;
            }
        }

        startUnit = maze[start[0]][start[1]][start[2]];
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
            if (next != connection && !next.isLocked()) {
                if (next.isExplored()) {
                    frontier.remove(next);
                    if (!next.isVertical() && Math.random() < loopingChance) {
                        next.open();
                    }
                } else {
                    frontier.add(next);
                }
            }
        }
        ExploreMaze(frontier);
    }

    public MazeUnit[][][] getMaze() {
        return maze;
    }

    public PieceOutline[][][] getMazePieceOutlines() {
        PieceOutline[][][] outlines = new PieceOutline[height][length][width];

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    outlines[k][i][j] = getOutlineForMazeUnit(maze[k][i][j]);
                }
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
            outline = new PieceOutline(MazeUnitShape.CROSS, BuilderUtils.randomRotation(), StructureMirror.NONE);
        } else {
            outline = new PieceOutline(MazeUnitShape.SOLID, BuilderUtils.randomRotation(), StructureMirror.LEFT_RIGHT);
        }
        if (unit.isUpOpen()) {
            outline.goingUp = true;
        }
        if (unit.isDownOpen()) {
            outline.goingDown = true;
        }
        return outline;
    }
}
