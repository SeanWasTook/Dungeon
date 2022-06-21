package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import org.bukkit.Location;

public interface PieceStructure {
    public void place(Location location, StructureRotation rotation, StructureMirror mirror);
}
