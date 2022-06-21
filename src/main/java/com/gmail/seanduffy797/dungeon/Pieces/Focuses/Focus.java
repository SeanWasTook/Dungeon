package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import org.bukkit.Location;

public abstract class Focus {

    public Location location;

    public abstract Focus makeCopy(Focus focus);

    public abstract void start();

    // Only exists to be a parent
    // Used for when the dungeon needs to do something special at a location,
    // Such as lock doors, fill chests, or spawn mobs
}

