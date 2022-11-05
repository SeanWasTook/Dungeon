package com.gmail.seanduffy797.dungeon.builders;

import com.gmail.seanduffy797.dungeon.builders.wavefunction.Direction;
import com.gmail.seanduffy797.dungeon.regions.BorderPoint;

public class RelativeExit {
    int[] coords;
    Direction dir;
    BorderPoint borderPoint;

    public RelativeExit(int[] coords, Direction dir, BorderPoint border) {
        this.coords = coords;
        this.dir = dir;
        this.borderPoint = border;
    }
    public int[] getCoords() {
        return coords;
    }
    public Direction getDir() {
        return dir;
    }
    public BorderPoint getBorderPoint() {
        return borderPoint;
    }
}
