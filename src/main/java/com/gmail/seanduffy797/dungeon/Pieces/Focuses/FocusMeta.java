package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FocusMeta {

    public static Map<Integer, IronGate> ironGates = new HashMap<>();
    public static Map<Location, LockedDoor> doors = new HashMap<>();
    public static Map<Location, Trigger> triggers = new HashMap<>();

    public static ArrayList<EditableBlock> puzzleBlocks = new ArrayList<>();
    public static ArrayList<ItemFrameChecker> puzzleFrames = new ArrayList<>();

    public static void init() {
        // Need to reset all of these every time build is run anew
        ironGates = new HashMap<>();
        doors = new HashMap<>();
        triggers = new HashMap<>();

        puzzleBlocks = new ArrayList<>();
        puzzleFrames = new ArrayList<>();
    }
}
