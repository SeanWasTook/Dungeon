package com.gmail.seanduffy797.dungeon.builders.maze;

import java.util.ArrayList;

public class MazeOptions {
    public int height; // In "maze units", not minecraft blocks
    public int length; // In "maze units", not minecraft blocks
    public int width; // In "maze units", not minecraft blocks
    public int[] startIndexes = new int[3];
    public ArrayList<int[]> exits = new ArrayList<>();
    public double[] loopingFactors; // Scale of 0-1, higher numbers mean more loops

    public MazeOptions(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;

        loopingFactors = new double[height];
    }

    public void setStart(int startY, int startX, int startZ) {
        this.startIndexes[0] = startY;
        this.startIndexes[1] = startX;
        this.startIndexes[2] = startZ;
    }

    // Adds an exit to the exit list. Should be along edges
    // 0 = forward, 90 = right, 1 = up, 2 = down
    public void addExit(int y, int x, int z, int direction) {
        int[] exit = new int[4];
        exit[0] = y;
        exit[1] = x;
        exit[2] = z;
        exit[3] = direction;
        exits.add(exit);
    }

    public void setLoopingFactors(double[] factors) {
        for (int i = 0; i < height && i < factors.length; i++) {
            loopingFactors[i] = factors[i];
        }
    }
}
