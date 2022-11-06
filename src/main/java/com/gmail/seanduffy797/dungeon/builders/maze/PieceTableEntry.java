package com.gmail.seanduffy797.dungeon.builders.maze;

import com.gmail.seanduffy797.dungeon.Pieces.PieceStructure;
import com.gmail.seanduffy797.dungeon.Pieces.StoneBrickMaze;

public class PieceTableEntry {

    PieceStructure piece;
    MazeUnitShape shape;
    int weight;
    int minCount = 0;
    int maxCount = 999;

    public PieceTableEntry(PieceStructure piece, MazeUnitShape shape, int weight, int minCount, int maxCount) {
        this.piece = piece;
        this.shape = shape;
        this.weight = weight;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }
    // Gets a copied version with a new weight
    public PieceTableEntry getCopyWithWeight(int newWeight) {
        return new PieceTableEntry(this.piece, this.shape, newWeight, this.minCount, this.maxCount);
    }


    public MazeUnitShape getShape() {
        return shape;
    }
}
