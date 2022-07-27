package com.gmail.seanduffy797.dungeon.builders.maze;

import com.gmail.seanduffy797.dungeon.Pieces.StoneBrickMaze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MazePieceTable {

    public static Map<MazeUnitShape, ArrayList<PieceTableEntry>> table;

    public static void init() {
        table = new HashMap<>();
        for (MazeUnitShape shape : MazeUnitShape.values()) {
            ArrayList<PieceTableEntry> entries = new ArrayList<>();
            table.put(shape, entries);
        }
        for (StoneBrickMaze piece : StoneBrickMaze.values()) {
            table.get(piece.getEntry().shape).add(piece.getEntry());
        }
    }

    public static StoneBrickMaze getPiece(MazeUnitShape shape) {
        ArrayList<PieceTableEntry> entries = table.get(shape);

        double total = 0;
        for (PieceTableEntry entry : entries) {
            total += entry.weight;
        }

        int idx = 0;
        for (double rand = Math.random() * total; idx < entries.size() - 1; idx++) {
            rand -= entries.get(idx).weight;
            if (rand <= 0.0) {
                break;
            }
        }
        return entries.get(idx).piece;
    }
}
