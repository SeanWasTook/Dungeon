package com.gmail.seanduffy797.dungeon.builders.maze;

import com.gmail.seanduffy797.dungeon.Pieces.StoneBrickMaze;

public class PieceTableEntry {

    StoneBrickMaze piece;
    MazeUnitShape shape;
    int weight;
    int minCount;
    int maxCount;

    public PieceTableEntry(StoneBrickMaze piece, MazeUnitShape shape, int weight, int minCount, int maxCount) {
        this.piece = piece;
        this.shape = shape;
        this.weight = weight;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }
}
