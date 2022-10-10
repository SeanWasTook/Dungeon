package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import org.bukkit.Location;

public abstract class Focus {

    public Location location;
    public StructureRotation rotation;
    public StructureMirror mirror;

    public abstract Focus makeCopy(Focus focus);

    public abstract void start(Region region);

    // Only exists to be a parent
    // Used for when the dungeon needs to do something special at a location,
    // Such as lock doors, fill chests, or spawn mobs
}

