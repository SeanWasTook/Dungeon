package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import org.bukkit.Location;

import java.util.ArrayList;

public interface PieceStructure {
    Location getOffset();
    ArrayList<Focus> getFocuses();
    void place(Location location, StructureRotation rotation, StructureMirror mirror);
}
