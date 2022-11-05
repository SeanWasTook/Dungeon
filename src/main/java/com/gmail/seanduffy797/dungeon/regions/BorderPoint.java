package com.gmail.seanduffy797.dungeon.regions;

import com.gmail.seanduffy797.dungeon.builders.wavefunction.Direction;
import org.bukkit.Location;

import java.util.ArrayList;

// Designed to hold data from builders about where exits are and what to build afterwards
public class BorderPoint {

    Location location;
    Direction direction;
    SubRegion fromSubRegion;
    SubRegion toSubRegion;

    public BorderPoint(SubRegion from, SubRegion to) {
        this.fromSubRegion = from;
        this.toSubRegion = to;
    }
    public void specify(Location loc, Direction dir) {
        this.location = loc;
        this.direction = dir;
    }
    public Location getLocation() {
        return location;
    }
    public Direction getDirection() {
        return direction;
    }
}
