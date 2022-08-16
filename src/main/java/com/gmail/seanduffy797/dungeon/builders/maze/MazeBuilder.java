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
    public double[] chances;

    public MazeBuilder(int height, int length, int width, int[] start, ArrayList<int[]> exits, double loopingChance) {
        this.height = height;
        this.length = length;
        this.width = width;
        maze = new MazeUnit[height][length][width];
        this.loopingChance = loopingChance;
        chances = new double[height];
        chances[0] = 0.07;
        chances[1] = 0.01;
        chances[2] = 0.07;
        chances[3] = 0.15;
        chances[4] = 0.4;
        chances[5] = 0.1;

        for (int k = 0; k < height; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    maze[k][i][j] = new MazeUnit();
                    if (k > 0) {
                        // Order of args is important - increasing index = going up
                        MazeConnection connection = new MazeConnection(maze[k-1][i][j], maze[k][i][j]);
                        connection.height = k;
                        connection.setVertical();
                        maze[k][i][j].setDown(connection);
                        maze[k-1][i][j].setUp(connection);
                    }
                    if (i > 0) {
                        // Order of args is important - increasing index = going forward
                        MazeConnection connection = new MazeConnection(maze[k][i - 1][j], maze[k][i][j]);
                        connection.height = k;
                        maze[k][i][j].setBack(connection);
                        maze[k][i - 1][j].setForward(connection);
                    }
                    if (j > 0) {
                        // Order of args is important - increasing index = going to the right
                        MazeConnection connection = new MazeConnection(maze[k][i][j - 1], maze[k][i][j]);
                        connection.height = k;
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
        while (connection.isVertical()) {
            if (Math.random() < 0.05) {
                break;
            }
            frontier.add(connection);
            index = rnd.nextInt(frontier.size());
            connection = frontier.remove(index);
        }

        connection.open();
        MazeUnit newUnit = connection.getUnexploredUnit();
        connection.markExplored();

        for (MazeConnection next: newUnit.getConnections()) {
            if (next != connection && !next.isLocked()) {
                if (next.isExplored()) {
                    frontier.remove(next);
                    if (!next.isVertical() && Math.random() < chances[next.height]) {
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
        boolean up = unit.isUpOpen();
        boolean down = unit.isDownOpen();
        PieceOutline outline;
        if (forward && back && !right && !left) { // front-back straight
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.STRAIGHT_MIDDLE, StructureRotation.NONE, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.STRAIGHT_UP, StructureRotation.NONE, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.STRAIGHT_DOWN, StructureRotation.NONE, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.STRAIGHT, StructureRotation.NONE, StructureMirror.NONE);
            }
        } else if (!forward && !back && right && left) { // left-right straight
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.STRAIGHT_MIDDLE, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.STRAIGHT_UP, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.STRAIGHT_DOWN, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.STRAIGHT, StructureRotation.ROTATION_90, StructureMirror.NONE);
            }
        } else if (!forward && back && !right && left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.TURN_MIDDLE, StructureRotation.NONE, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.TURN_UP, StructureRotation.NONE, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.TURN_DOWN, StructureRotation.NONE, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.TURN, StructureRotation.NONE, StructureMirror.NONE);
            }
        } else if (forward && !back && !right && left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.TURN_MIDDLE, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.TURN_UP, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.TURN_DOWN, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.TURN, StructureRotation.ROTATION_90, StructureMirror.NONE);
            }
        } else if (forward && !back && right && !left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.TURN_MIDDLE, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.TURN_UP, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.TURN_DOWN, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.TURN, StructureRotation.ROTATION_180, StructureMirror.NONE);
            }
        } else if (!forward && back && right && !left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.TURN_MIDDLE, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.TURN_UP, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.TURN_DOWN, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.TURN, StructureRotation.ROTATION_270, StructureMirror.NONE);
            }
        } else if (!forward && back && !right && !left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.END_MIDDLE, StructureRotation.NONE, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.END_UP, StructureRotation.NONE, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.END_DOWN, StructureRotation.NONE, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.END, StructureRotation.NONE, StructureMirror.NONE);
            }
        } else if (!forward && !back && !right && left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.END_MIDDLE, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.END_UP, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.END_DOWN, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.END, StructureRotation.ROTATION_90, StructureMirror.NONE);
            }
        } else if (forward && !back && !right && !left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.END_MIDDLE, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.END_UP, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.END_DOWN, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.END, StructureRotation.ROTATION_180, StructureMirror.NONE);
            }
        } else if (!forward && !back && right && !left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.END_MIDDLE, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.END_UP, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.END_DOWN, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.END, StructureRotation.ROTATION_270, StructureMirror.NONE);
            }
        } else if (forward && back && !right && left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.T_MIDDLE, StructureRotation.NONE, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.T_UP, StructureRotation.NONE, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.T_DOWN, StructureRotation.NONE, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.T, StructureRotation.NONE, StructureMirror.NONE);
            }
        } else if (forward && !back && right && left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.T_MIDDLE, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.T_UP, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.T_DOWN, StructureRotation.ROTATION_90, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.T, StructureRotation.ROTATION_90, StructureMirror.NONE);
            }
        } else if (forward && back && right && !left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.T_MIDDLE, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.T_UP, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.T_DOWN, StructureRotation.ROTATION_180, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.T, StructureRotation.ROTATION_180, StructureMirror.NONE);
            }
        } else if (!forward && back && right && left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.T_MIDDLE, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.T_UP, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.T_DOWN, StructureRotation.ROTATION_270, StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.T, StructureRotation.ROTATION_270, StructureMirror.NONE);
            }
        } else if (forward && back && right && left) {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.CROSS_MIDDLE, BuilderUtils.randomRotation(), StructureMirror.NONE);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.CROSS_UP, BuilderUtils.randomRotation(), StructureMirror.NONE);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.CROSS_DOWN, BuilderUtils.randomRotation(), StructureMirror.NONE);
            } else {
                outline = new PieceOutline(MazeUnitShape.CROSS, BuilderUtils.randomRotation(), StructureMirror.NONE);
            }
            // Rotation here is randomized, since it doesn't matter
        } else {
            if (up && down) {
                outline = new PieceOutline(MazeUnitShape.SOLID_MIDDLE, BuilderUtils.randomRotation(), StructureMirror.LEFT_RIGHT);
            } else if (up) {
                outline = new PieceOutline(MazeUnitShape.SOLID_UP, BuilderUtils.randomRotation(), StructureMirror.LEFT_RIGHT);
            } else if (down) {
                outline = new PieceOutline(MazeUnitShape.SOLID_DOWN, BuilderUtils.randomRotation(), StructureMirror.LEFT_RIGHT);
            } else {
                outline = new PieceOutline(MazeUnitShape.SOLID, BuilderUtils.randomRotation(), StructureMirror.LEFT_RIGHT);
            }
            // Rotation here is randomized, since it doesn't matter
        }
        return outline;
    }
}
