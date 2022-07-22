package com.gmail.seanduffy797.dungeon.builders.maze;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.builders.maze.MazeUnitShape;

public class PieceOutline {

    public MazeUnitShape shape;

    public StructureRotation rotation;

    public StructureMirror mirror;

    public PieceOutline(MazeUnitShape shape, StructureRotation rotation, StructureMirror mirror) {
        this.shape = shape;
        this.rotation = rotation;
        this.mirror = mirror;
    }
}
