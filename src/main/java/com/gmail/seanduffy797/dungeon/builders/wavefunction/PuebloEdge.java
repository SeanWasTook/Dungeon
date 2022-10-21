package com.gmail.seanduffy797.dungeon.builders.wavefunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PuebloEdge {
    OUTSIDE,
    INSIDE,
    WALL_LEFT, // Left and right are as viewed from the center of the piece
    WALL_RIGHT,
    WALL_BOTH,
    VERTICAL_SOLID,
    VERTICAL_OPEN,
    FLOOR_SOLID;

    // Necessary because one piece's left will be its connection's right
    public PuebloEdge mirror() {
        switch (this) {
            case WALL_LEFT:
                return WALL_RIGHT;
            case WALL_RIGHT:
                return WALL_LEFT;
            default:
                return this;
        }
    }
    public List<PuebloEdge> getConstraints() {
        switch (this) {
            case INSIDE:
                return Arrays.asList(INSIDE, WALL_LEFT, WALL_RIGHT, WALL_BOTH, OUTSIDE);
            case WALL_LEFT:
                return Arrays.asList(WALL_LEFT, OUTSIDE);
            case WALL_RIGHT:
                return Arrays.asList(WALL_RIGHT, OUTSIDE);
            case WALL_BOTH:
                return Arrays.asList(WALL_BOTH, WALL_RIGHT, WALL_LEFT, OUTSIDE);
            default:
                return Collections.singletonList(this);
        }
    }
}
