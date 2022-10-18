package com.gmail.seanduffy797.dungeon.builders.wavefunction;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;

public enum Direction {
    // These are all shameless lies. They don't correspond to the actual
    // North, East, South, and West directions in Minecraft. My north is
    // +x (west) direction in minecraft, east is +z (south), etc.
    // I made them up because they made more sense to me
    NORTH, // +x
    EAST, // +z
    SOUTH, // -x
    WEST, // -z
    UP,
    DOWN;

    public static Direction getRotated(Direction dir) {
        switch (dir) {
            case UP:
                return UP;
            case DOWN:
                return DOWN;
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return dir;
        }
    }

    public static Direction getMirrored(Direction dir) {
        switch (dir) {
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                return dir;
        }
    }

    public static Direction getAppliedTransforms(Direction dir, StructureRotation rotation, StructureMirror mirror) {
        Direction transformed = dir;
        switch (rotation) {
            case ROTATION_90:
                transformed = getRotated(transformed);
                break;
            case ROTATION_180:
                transformed = getRotated(getRotated(transformed));
                break;
            case ROTATION_270:
                transformed = getRotated(getRotated(getRotated(transformed)));
                break;
        }
        if (mirror == StructureMirror.LEFT_RIGHT) {
            transformed = getMirrored(transformed);
        }
        return transformed;
    }
}
