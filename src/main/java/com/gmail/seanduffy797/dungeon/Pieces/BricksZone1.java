package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;

import static org.bukkit.Bukkit.*;

public enum BricksZone1 implements Bricks {

    HALL1 ("hall1", 7, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL2 ("hall2", 7, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL3 ("hall3", 7, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
//    HALL4 ("hall4", 13, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
//            new HashMap<>(Collections.singletonMap(
//                    new Location(getWorld("Dungeon"), 13, 0, 0), Region.SEWER)),
//            new ArrayList<>()),
    HALL5 ("hall5", 7, 5, 9, new Location(getWorld("Dungeon"), 0, -1, -5), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 3, 0, -4), Loot.BRICKT1)))),
    HALL6 ("hall6", 7, 5, 8, new Location(getWorld("Dungeon"), 0, -1, -4), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK)),
            new ArrayList<>()),
    HALL7 ("hall7", 13, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 13, 0, 0), Region.BRICK)),
            new ArrayList<>()),
    HALL8 ("hall8", 7, 7, 7, new Location(getWorld("Dungeon"), 0, -3, -3), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK)),
            new ArrayList<>()),
    HALL9 ("hall9", 7, 5, 11, new Location(getWorld("Dungeon"), 0, -1, -5), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK)),
            new ArrayList<>()),
    HALL10 ("hall10", 12, 12, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 12, 0, 0), Region.BRICK)),
            new ArrayList<>()),
    HALL11 ("hall11", 6, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 6, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL12 ("hall12", 6, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 6, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL13 ("hall13", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL14 ("hall14", 10, 7, 7, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 10, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL15 ("hall15", 6, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 6, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL16 ("hall16", 9, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 9, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL17 ("hall17", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL18 ("hall18", 3, 8, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL19 ("hall19", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL20 ("hall20", 6, 10, 7, new Location(getWorld("Dungeon"), 0, -6, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 6, 0, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 2, -5, -2), Loot.BRICKT1)))),
    HALL21 ("hall21", 7, 10, 7, new Location(getWorld("Dungeon"), 0, -6, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK)),
            new ArrayList<>()),
    HALL22 ("hall22", 7, 11, 7, new Location(getWorld("Dungeon"), 0, -6, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK)),
            new ArrayList<>()),
    HALL23 ("hall23", 5, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.INHERIT)),
            new ArrayList<>()),
    HALL24 ("hall24", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 4, 0, 0), Region.INHERIT)),
            new ArrayList<>(Collections.singletonList(
                    new ItemFrameSpawner(new Location(getWorld("Dungeon"), 1, 1, -2), new ItemStack(Material.DRAGON_BREATH), StructureRotation.NONE)))),
    HALL25 ("hall25", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.INHERIT)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 1, 1, -2), Loot.BRICKT1, false, 35000)))),
    HALL26 ("hall26", 3, 6, 8, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.INHERIT)),
            new ArrayList<>()),

    STAIRDOWN1 ("stairdown1", 3, 9, 7, new Location(getWorld("Dungeon"), 0, -4, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, -3, 0), Region.SEWER)),
            new ArrayList<>()),
    STAIRDOWNU1 ("stairdownu1", 8, 9, 14, new Location(getWorld("Dungeon"), 0, -5, -10), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), -1, -4, -7, 180, 0), Region.SEWER)),
            new ArrayList<>()),
    STAIRUP1 ("stairup1", 3, 8, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 3, 0), Region.BRICK)),
            new ArrayList<>()),

    END0 ("end0", 1, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>()),
    END1 ("end1", 2, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>()),
    END2 ("end2", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    END3 ("end3", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 0, 0), Loot.BRICKT1, false, 20000)))),
    END4 ("end4", 5, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>()),
    END5 ("end5", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 1, 1), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 2, 1, -1), Loot.BRICKT1)))),
    END6 ("end6", 5, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>()),
    END7 ("end7", 4, 6, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>()),
    END8 ("end8", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -3, -3), false,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 3, 0, 0), Loot.BRICKT1)))),
    END9 ("end9", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 1, 2), Loot.BRICKT1)))),
    END10 ("end10", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    END11 ("end11", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    END12 ("end12", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    END13 ("end13", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 1, 0), Loot.BRICKT1)))),

    ROOM1 ("room1", 13, 7, 13, new Location(getWorld("Dungeon"), 0, -1, -6), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 10, 1, -5), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 9, 0, 5), Loot.BRICKT1)))),
    ROOM2 ("room2", 17, 9, 17, new Location(getWorld("Dungeon"), 0, -5, -8), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 13, -2, -7), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 14, 0, -7), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 15, -1, -5), Loot.BRICKT1)))),
    ROOM3 ("room3", 8, 5, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new LockedDoor(new Location(getWorld("Dungeon"), 3, 0, -1), LockEnum.OLDKEY),
                    new Chest(new Location(getWorld("Dungeon"), 4, 0, 0), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 6, 1, 0), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 6, 1, -2), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 4, 0, -3), Loot.BRICKT1)))),
    ROOM4 ("room4", 9, 7, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 6, 0, 3), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 6, 3, 3), Loot.BRICKT1)))),
    ROOM5 ("room5", 15, 8, 15, new Location(getWorld("Dungeon"), 0, -2, -7), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 1, 3, -5), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 13, -1, -1), Loot.BRICKT1)))),
    ROOM6 ("room6", 9, 6, 9, new Location(getWorld("Dungeon"), 0, -1, -4), false,
            new HashMap<>(),
            new ArrayList<>()),
    ROOM7 ("room7", 12, 10, 12, new Location(getWorld("Dungeon"), 0, -1, -6), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 10, 0, 4), Loot.BRICKT1, false, 30000),
                    new Chest(new Location(getWorld("Dungeon"), 10, 6, 4), Loot.BRICKT1, false, 30000)))),
    ROOM8 ("room8", 11, 6, 11, new Location(getWorld("Dungeon"), 0, -1, -5), true,
            new HashMap<>(),
            new ArrayList<>()),

    SHRINE1 ("shrine1", 9, 6, 9, new Location(getWorld("Dungeon"), 0, -1, -4), false,
            new HashMap<>(),
            new ArrayList<>()),

    DOOR1 ("door1", 5, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.BRICK)),
            new ArrayList<>()),

    TURN1 ("turn1", 8, 5, 8, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 4, 0, -5, 270, 0), Region.BRICK)),
            new ArrayList<>()),
    TURN2 ("turn2", 10, 5, 10, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 4, 0, -5, 270, 0), Region.BRICK)),
            new ArrayList<>()),

    T1 ("t1", 7, 5, 9, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 0, 4), Loot.BRICKT1)))),
    T2 ("t2", 7, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>()),
    T3 ("t3", 13, 9, 7, new Location(getWorld("Dungeon"), 0, -3, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 13, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 6, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>()),
    T4 ("t4", 11, 7, 10, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 11, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 5, 0, -5, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 0, 4), Loot.BRICKT1)))),
    T5 ("t5", 9, 6, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 9, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 4, 0, -5, 270, 0), Region.BRICK)),
            new ArrayList<>()),
    T6 ("t6", 9, 5, 8, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 9, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 4, 0, -5, 270, 0), Region.BRICK)),
            new ArrayList<>()),
    T7 ("t7", 7, 7, 10, new Location(getWorld("Dungeon"), 0, -3, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>(Arrays.asList(
                    new DungeonEntity(new Location(getWorld("Dungeon"), 3, -2, 3.5), DungeonMob.BRICK_HUSK, 1703),
                    new DungeonEntity(new Location(getWorld("Dungeon"), 3, -2, 3.5), DungeonMob.BRICK_SKELETON, 2100)))),
    T8 ("t8", 7, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>()),
    T9 ("t9", 8, 6, 12, new Location(getWorld("Dungeon"), 0, -1, -6), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 8, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 4, 1, -7, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 3, 1, -4), "pointer", StructureRotation.ROTATION_90, true)))),
    T10 ("t10", 7, 5, 9, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 1, 1, 3), Loot.BRICKT1, false, 32000)))),
    T11 ("t11", 7, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 3, 2, 2), Loot.BRICKT1, false, 25000)))),

    CROSS1 ("cross1", 23, 5, 23, new Location(getWorld("Dungeon"), 0, -1, -11), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 23, 0, 0, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 11, 0, 12, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 11, 0, -12, 270, 0), Region.BRICK)),
            new ArrayList<>()),
//    CROSS2 ("cross2", 41, 25, 41, new Location(getWorld("Dungeon"), 0, -8, -20), true,
//            new HashMap<>(Map.of(
//                    new Location(getWorld("Dungeon"), 41, 0, 0, 0, 0), Region.SEWER,
//                    new Location(getWorld("Dungeon"), 20, 0, 21, 90, 0), Region.SEWER,
//                    new Location(getWorld("Dungeon"), 20, 0, -21, 270, 0), Region.SEWER,
//                    new Location(getWorld("Dungeon"), 41, 11, -7, 0, 0), Region.PIPE2,
//                    new Location(getWorld("Dungeon"), 27, 7, 21, 90, 0), Region.PIPE3)),
//            new ArrayList<>()),
    CROSS3 ("cross3", 31, 10, 31, new Location(getWorld("Dungeon"), 0, -1, -11), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 31, 0, 8, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 19, 0, 20, 90, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 21, 5, -12, 270, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 12, 0, -12, 270, 0), Region.BRICK2)),
            new ArrayList<>(Arrays.asList(
                    new LockedDoor(new Location(getWorld("Dungeon"), 25, 0, 15), LockEnum.SKELETONKEY),
                    new Chest(new Location(getWorld("Dungeon"), 29, 6, -2), Loot.BRICKT2),
                    new Chest(new Location(getWorld("Dungeon"), 17, 3, -8), Loot.BRICKT2),
                    new Chest(new Location(getWorld("Dungeon"), 8, 0, 12), Loot.BRICKT2)))),
    CROSS4 ("cross4", 11, 7, 11, new Location(getWorld("Dungeon"), 0, -1, -5), false,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 11, 0, 0, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 5, 0, 6, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 5, 0, -6, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new DungeonEntity(new Location(getWorld("Dungeon"), 5.5, 0, 0.5), DungeonMob.BRICK_HUSK, 6000)))),
    CROSS9 ("cross9", 11, 5, 11, new Location(getWorld("Dungeon"), 0, -1, -5), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 6, 0, 6, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 6, 0, -6, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 9, 0, 0), Loot.BRICKT1, false, 20000)))),
    CROSS10 ("cross10", 15, 10, 15, new Location(getWorld("Dungeon"), 0, -1, -7), false,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 15, 0, 0, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 7, 0, 8, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 7, 0, -8, 270, 0), Region.BRICK)),
            new ArrayList<>(Arrays.asList(
                    new DungeonEntity(new Location(getWorld("Dungeon"), 6, 0, 0), DungeonMob.BRICK_SKELETON, 1000),
                    new DungeonEntity(new Location(getWorld("Dungeon"), 6, 3, 0), DungeonMob.BRICK_SKELETON, 1300),
                    new Chest(new Location(getWorld("Dungeon"), 6, 6, 0), Loot.BRICKT2, false, 15000)))),
    CROSS11 ("cross11", 19, 9, 15, new Location(getWorld("Dungeon"), 0, -1, -7), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 3, 0, 8, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -8, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 17, 4, 6), Loot.BRICKT1, false, 40000)))),

    PAINTING_TEST ("painting_test", 7, 6, 5, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 2, 2, -1), "pointer", StructureRotation.ROTATION_90, true),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 1, 0, 0), "sea", StructureRotation.NONE, true),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 1, 2, 1), "match", StructureRotation.NONE, true),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 1, 1, 1), "aztec2", StructureRotation.NONE, false),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 4, 1, 1), "pool", StructureRotation.ROTATION_270, true),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 3, 3, 1), "aztec2", StructureRotation.ROTATION_270, false),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 5, 0, 0), "bomb", StructureRotation.ROTATION_180, false),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 5, 2, -1), "bust", StructureRotation.ROTATION_180, true),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 5, 4, 0), "courbet", StructureRotation.ROTATION_180, true)))),

    ITEM_FRAME_TEST ("painting_test", 7, 6, 5, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new ItemFrameSpawner(new Location(getWorld("Dungeon"), 1, 1, 0), new ItemStack(Material.APPLE), StructureRotation.NONE, true),
                    new ItemFrameSpawner(new Location(getWorld("Dungeon"), 2, 1, -1), new ItemStack(Material.DIAMOND_SWORD), StructureRotation.ROTATION_90, true),
                    new ItemFrameSpawner(new Location(getWorld("Dungeon"), 5, 1, 0), new ItemStack(Material.STONE_BRICKS), StructureRotation.ROTATION_180, true),
                    new ItemFrameSpawner(new Location(getWorld("Dungeon"), 2, 1, 1), new ItemStack(Material.PUMPKIN_SEEDS), StructureRotation.ROTATION_270, true)))),

    ARENA ("arena", 31, 23, 31, new Location(getWorld("Dungeon"), 0, -5, -7), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 31, 0, 0, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 31, 0, 16, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 7, 0, 24, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 23, 0, 24, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), -1, 0, 16, 180, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 7, 0, -8, 270, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 23, 0, -8, 270, 0), Region.BRICK)),
            new ArrayList<>(Arrays.asList(
                    new IronGate(new Location(getWorld("Dungeon"), 30, 0, 0), 3),
                    new IronGate(new Location(getWorld("Dungeon"), 30, 0, 16), 4),
                    new IronGate(new Location(getWorld("Dungeon"), 7, 0, 23), 6),
                    new IronGate(new Location(getWorld("Dungeon"), 23, 0, 23), 5),
                    new IronGate(new Location(getWorld("Dungeon"), 0, 0, 16), 7),
                    new IronGate(new Location(getWorld("Dungeon"), 7, 0, -7), 1),
                    new IronGate(new Location(getWorld("Dungeon"), 23, 0, -7), 2),
                    new Spawner(new Location(getWorld("Dungeon"), 10, 6, 8), SpawnerEnum.GLADIATOR),
                    new Spawner(new Location(getWorld("Dungeon"), 15, 6, 3), SpawnerEnum.GLADIATOR),
                    new Spawner(new Location(getWorld("Dungeon"), 20, 6, 8), SpawnerEnum.GLADIATOR),
                    new Spawner(new Location(getWorld("Dungeon"), 15, 6, 13), SpawnerEnum.GLADIATOR))));

    private final String name;
    private final Path path;
    private final int length;
    private final int height;
    private final int width;
    private final Location startOffset;
    private final boolean canMirror;
    private final boolean isEven;
    private final Map<Location, Region> exits;
    private final ArrayList<Focus> focuses;

    BricksZone1(String name, int length, int height, int width, Location startOffset, boolean mirror, Map<Location, Region> exits, ArrayList<Focus> focuses) {
        this.name = name;
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        this.path = plugin.getDataFolder().toPath().resolve("brick/" + this.name + ".nbt");
        this.length = length;
        this.height = height;
        this.width = width;
        this.startOffset = startOffset;
        this.canMirror = mirror;
        this.exits = exits;
        this.focuses = focuses;
        this.isEven = false;
    }

    BricksZone1(String name, int length, int height, int width, Location startOffset, boolean mirror, boolean even, Map<Location, Region> exits, ArrayList<Focus> focuses) {
        this.name = name;
        Plugin plugin = Dungeon.getPlugin();
        this.path = plugin.getDataFolder().toPath().resolve("brick/" + this.name + ".nbt");
        this.length = length;
        this.height = height;
        this.width = width;
        this.startOffset = startOffset;
        this.canMirror = mirror;
        this.exits = exits;
        this.focuses = focuses;
        this.isEven = even;
    }

    public String getName() {return name;}
    public Path getPath() {return path;}
    public int getLength() {return length;}
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public Location getStartOffset() {return startOffset;}
    public boolean getMirror() {return canMirror;}
    public boolean isEven() {return isEven;}
    public Map<Location, Region> getExits() {return exits;}
    public ArrayList<Focus> getFocuses() {return focuses;}

    public void place(Location location, StructureRotation rotation, StructureMirror mirror) {
        Plugin plugin = Dungeon.getPlugin();

        StructureBlockLibApi.INSTANCE
                .loadStructure(plugin)
                .at(location)
                .includeEntities(true)
                .mirror(mirror)
                .rotation(rotation)
                .loadFromPath(path)
                .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to load structure." + name, e));
    }
}
