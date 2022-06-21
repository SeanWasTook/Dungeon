package com.gmail.seanduffy797.dungeon.builders;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.PieceStructure;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import com.gmail.seanduffy797.dungeon.Pieces.Bricks;
import org.bukkit.Location;


// This class is used to keep track of points where more building needs to be done
public class BrickUnit {

    public Region region;
    public Location start;
    public StructureRotation rotation;
    public StructureMirror mirror;
    public int depth;

    public PieceStructure previous; // Remove eventually maybe

    public BrickUnit(Region region, Location start, StructureRotation rotation, StructureMirror mirror, int depth, PieceStructure previous) {
        this.region = region;
        this.start = start;
        this.rotation = rotation;
        this.mirror = mirror;
        this.depth = depth;
        this.previous = previous;
    }
}
