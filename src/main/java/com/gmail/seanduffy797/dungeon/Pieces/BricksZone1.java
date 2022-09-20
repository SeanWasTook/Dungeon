package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
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
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 3, 0, -4), Loot.BRICKT1, true, 40000),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 5, 1, -3), new ItemStack(Material.HONEY_BOTTLE), StructureRotation.ROTATION_180)))),
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
            new ArrayList<>(Arrays.asList(
                    new DungeonEntity(new Location(DungeonManager.world, 3, 0, -2.5), DungeonMob.GUARD_SKELETON),
                    new DungeonEntity(new Location(DungeonManager.world, 3, 0, 3.5), DungeonMob.GUARD_SKELETON)
            ))),
    HALL10 ("hall10", 12, 12, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 12, 0, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Spawner(new Location(DungeonManager.world, 5, 5, 1), SpawnerEnum.COMMON_SPIDER)))),
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
            new ArrayList<>(Collections.singletonList(
                    new DungeonEntity(new Location(DungeonManager.world, 3, 0, 0.5), DungeonMob.COMMON_SPIDER, 10000)
            ))),
    HALL16 ("hall16", 9, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 9, 0, 0), Region.INHERIT)),
            new ArrayList<>(Collections.singletonList(
                    new DungeonEntity(new Location(DungeonManager.world, 3.5, 0, 0.5), DungeonMob.PERSISTENT_PILLAGER)
            ))),
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
                    new Chest(new Location(getWorld("Dungeon"), 2, -5, -2), Loot.BRICKT1, true, 35000)))),
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
                    new Chest(new Location(getWorld("Dungeon"), 1, 1, -2), Loot.BRICKT1, true, 35000)))),
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
                    new Chest(new Location(getWorld("Dungeon"), 2, 0, 0), Loot.BRICKT1, true, 20000)))),
    END4 ("end4", 5, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>()),
    END5 ("end5", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 1, 1), Loot.BRICKT1),
                    new Chest(new Location(getWorld("Dungeon"), 2, 1, -1), Loot.BRICKT1),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 0, 1, 0), DungeonItem.CHISELED_STONE_PICK.getItemStack(), StructureRotation.ROTATION_180, true)))),
    END6 ("end6", 5, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>()),
    END7 ("end7", 4, 6, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>()),
    END8 ("end8", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -3, -3), false,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 3, 0, 0), Loot.BRICKT1, true, 20000)))),
    END9 ("end9", 4, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 1, 2), Loot.BRICKT1, true, 25000)))),
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
            new ArrayList<>(Arrays.asList(
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 0, 1, 0), "wasteland", StructureRotation.ROTATION_180, false),
                    new Chest(new Location(getWorld("Dungeon"), 2, 1, 0), Loot.BRICKT1, true, 40000)))),
    END14 ("end14", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 1, 1, 2), Loot.BRICKT1, true, 25000),
                    new Chest(new Location(getWorld("Dungeon"), 1, 1, -2), Loot.BRICKT1, true, 25000)))),
    END15 ("end15", 2, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 0, 1, 0), "sea", StructureRotation.ROTATION_180, true),
                    new PaintingSpawner(new Location(getWorld("Dungeon"), 0, 2, -1), "sunset", StructureRotation.ROTATION_180, true)))),

    ROOM1 ("room1", 13, 7, 13, new Location(getWorld("Dungeon"), 0, -1, -6), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Spawner(new Location(getWorld("Dungeon"), 6, 1, 0), SpawnerEnum.BRICK_HUSK),
                    new Chest(new Location(getWorld("Dungeon"), 10, 1, -5), Loot.BRICKT1, true, 35000),
                    new Chest(new Location(getWorld("Dungeon"), 9, 0, 5), Loot.BRICKT1, true, 35000)))),
    ROOM2 ("room2", 17, 9, 17, new Location(getWorld("Dungeon"), 0, -5, -8), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 13, -2, -7), Loot.BRICKT1, true, 35000),
                    new Chest(new Location(getWorld("Dungeon"), 14, 0, -7), Loot.BRICKT1, true, 35000),
                    new Chest(new Location(getWorld("Dungeon"), 15, -1, -5), Loot.BRICKT1, true, 35000),
                    new Chest(new Location(getWorld("Dungeon"), 15, -1, -4), Loot.BRICKT1, true, 35000),
                    new Chest(new Location(getWorld("Dungeon"), 1, -1, 6), Loot.BRICKT1, true, 35000),
                    new DungeonEntity(new Location(DungeonManager.world, 8.5, -4, 0.5), DungeonMob.TRIDENT_DROWNED, 8000),
                    new Spawner(new Location(DungeonManager.world, 11, -1, 0), SpawnerEnum.COMMON_DROWNED),
                    new Spawner(new Location(DungeonManager.world, 3, -1, 5), SpawnerEnum.BRICK_SKELETON),
                    new PaintingSpawner(new Location(DungeonManager.world, 9, -1, -7), "skull_and_roses", StructureRotation.ROTATION_90, true)))),
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
                    new Chest(new Location(getWorld("Dungeon"), 6, 0, 3), Loot.BRICKT1, true, 35000),
                    new Chest(new Location(getWorld("Dungeon"), 6, 3, 3), Loot.BRICKT2, true, 35000),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 4, 1, 3), DungeonItem.PILLAGER_CROSSBOW.getItemStack(), StructureRotation.ROTATION_270),
                    new DungeonEntity(new Location(DungeonManager.world, 5.5, 0, 0.5), DungeonMob.PERSISTENT_PILLAGER)))),
    ROOM5 ("room5", 15, 8, 15, new Location(getWorld("Dungeon"), 0, -2, -7), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 1, 3, -5), Loot.BRICKT1, true, 50000),
                    new Chest(new Location(getWorld("Dungeon"), 13, -1, -1), Loot.BRICKT1, true, 50000),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 2, 1, 1), new ItemStack(Material.WOODEN_SWORD), StructureRotation.NONE, false, false),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 12, 0, 1), new ItemStack(Material.WOODEN_SWORD), StructureRotation.ROTATION_180, false, true),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 12, 0, 2), null, StructureRotation.ROTATION_180, false, true),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 12, 1, 1), new ItemStack(Material.BOW), StructureRotation.ROTATION_180, false, true),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 12, 1, 2), new ItemStack(Material.WOODEN_SWORD), StructureRotation.ROTATION_180, false, true),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 5, 1, -4), new ItemStack(Material.BEETROOT_SOUP), StructureRotation.ROTATION_270, false, false),
                    new PaintingSpawner(new Location(DungeonManager.world, 1, 1, -5), "plant", StructureRotation.NONE, false),
                    new DungeonEntity(new Location(DungeonManager.world, 6.5, 0, 0.5), DungeonMob.FLYNN),
                    new DungeonEntity(new Location(DungeonManager.world, 6.5, 0, 0.5), DungeonMob.VEAL),
                    new DungeonEntity(new Location(DungeonManager.world, 6.5, 0, 0.5), DungeonMob.BRUNHILDE)
                    ))),
    ROOM6 ("room6", 9, 6, 9, new Location(getWorld("Dungeon"), 0, -1, -4), false,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new PaintingSpawner(new Location(DungeonManager.world, 7, 2, -1), "pool", StructureRotation.ROTATION_180, true),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 3, 1, -3), new ItemStack(Material.WOODEN_SWORD), StructureRotation.ROTATION_90, false, false),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 5, 1, -3), new ItemStack(Material.GOLDEN_APPLE), StructureRotation.ROTATION_90, false, false)
            ))),
    ROOM7 ("room7", 12, 10, 12, new Location(getWorld("Dungeon"), 0, -1, -6), true,
            new HashMap<>(),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 10, 0, 4), Loot.BRICKT1, true, 30000),
                    new Chest(new Location(getWorld("Dungeon"), 10, 6, 4), Loot.BRICKT1, true, 30000),
                    new DungeonEntity(new Location(DungeonManager.world, 5.5, 0, 0.5), DungeonMob.DUNGEON_MOOSHROOM),
                    new DungeonEntity(new Location(DungeonManager.world, 5.5, 0, 0.5), DungeonMob.DUNGEON_MOOSHROOM),
                    new DungeonEntity(new Location(DungeonManager.world, 5.5, 0, 0.5), DungeonMob.BABY_MOOSHROOM),
                    new DungeonEntity(new Location(DungeonManager.world, 5.5, 0, 0.5), DungeonMob.BABY_MOOSHROOM)))),
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
            new ArrayList<>(Arrays.asList(
                    new DungeonEntity(new Location(getWorld("Dungeon"), 6, 0, 0), DungeonMob.DUNGEON_LLAMA),
                    new DungeonEntity(new Location(getWorld("Dungeon"), 6, 0, 1), DungeonMob.DUNGEON_LLAMA),
                    new DungeonEntity(new Location(getWorld("Dungeon"), 6, 0, 2), DungeonMob.DUNGEON_LLAMA)))),

    T1 ("t1", 7, 5, 9, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 0, 4), Loot.BRICKT1, true, 30000),
                    new DungeonEntity(new Location(DungeonManager.world, 3.5, 0, 3.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER)))),
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
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 0, 4), Loot.BRICKT1, true, 35000),
                    new DungeonEntity(new Location(DungeonManager.world, 4.5, 0, 2.5), DungeonMob.PERSISTENT_PILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 4.5, 0, 2.5), DungeonMob.PERSISTENT_PILLAGER)))),
    T5 ("t5", 9, 6, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 9, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 4, 0, -5, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new ItemFrameSpawner(new Location(DungeonManager.world, 5, 1, 3), DungeonItem.SPECIAL_LEATHER_HAT.getItemStack(), StructureRotation.ROTATION_270)
            ))),
    T6 ("t6", 9, 5, 8, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 9, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 4, 0, -5, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new DungeonEntity(new Location(DungeonManager.world, 4.5, 0, 0.5), DungeonMob.BRICK_HUSK, 12000)
            ))),
    T7 ("t7", 7, 7, 10, new Location(getWorld("Dungeon"), 0, -3, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>(Arrays.asList(
                    new DungeonEntity(new Location(getWorld("Dungeon"), 3.5, -2, 3.5), DungeonMob.BRICK_HUSK, 2703),
                    new DungeonEntity(new Location(getWorld("Dungeon"), 3.5, -2, 3.5), DungeonMob.BRICK_SKELETON, 4100),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 1, -1, 4), new ItemStack(Material.BONE), StructureRotation.NONE)))),
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
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 1, 1, 3), Loot.BRICKT1, true, 32000),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 4, 1, 4), new ItemStack(Material.EXPERIENCE_BOTTLE), StructureRotation.ROTATION_270)))),
    T11 ("t11", 7, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 3, 2, 2), Loot.BRICKT1, true, 25000)))),

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
                    new Chest(new Location(getWorld("Dungeon"), 29, 6, -2), Loot.BRICKT2, true, 20000),
                    new Chest(new Location(getWorld("Dungeon"), 17, 3, -8), Loot.BRICKT2, true, 20000),
                    new Chest(new Location(getWorld("Dungeon"), 7, 0, 12), Loot.BRICKT2, true, 20000),
                    new Chest(new Location(getWorld("Dungeon"), 8, 0, 12), Loot.BRICKT2, true, 20000),
                    new Chest(new Location(getWorld("Dungeon"), 29, 0, 16), Loot.BRICKT2, true, 20000),
                    new Spawner(new Location(DungeonManager.world, 21, 1, 2), SpawnerEnum.BRICK_HUSK),
                    new Spawner(new Location(DungeonManager.world, 27, 3, 14), SpawnerEnum.BRICK_HUSK),
                    new Spawner(new Location(DungeonManager.world, 16, 0, -8), SpawnerEnum.BRICK_HUSK),
                    new DungeonEntity(new Location(DungeonManager.world, 12.5, 3, 5.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 12.5, 3, 5.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 12.5, 3, 5.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 12.5, 3, 5.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 17.5, 0, 5.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 25.5, 0, 15.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 2.5, 0, -5.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 2.5, 0, 5.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 6.5, 5, 16.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER),
                    new DungeonEntity(new Location(DungeonManager.world, 21.5, 0, -7.5), DungeonMob.PERSISTENT_ZOMBIE_VILLAGER)))),
    CROSS4 ("cross4", 11, 7, 11, new Location(getWorld("Dungeon"), 0, -1, -5), false,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 11, 0, 0, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 5, 0, 6, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 5, 0, -6, 270, 0), Region.BRICK)),
            new ArrayList<>(Collections.singletonList(
                    new DungeonEntity(new Location(getWorld("Dungeon"), 5.5, 0, 0.5), DungeonMob.BRICK_HUSK, 7000)))),
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
                    new LockedDoor(new Location(DungeonManager.world, 3, 0, 0), LockEnum.SKELETONKEY),
                    new Chest(new Location(getWorld("Dungeon"), 6, 6, 0), Loot.BRICKT2, false, 15000),
                    new Chest(new Location(getWorld("Dungeon"), 6, 6, 2), Loot.BRICKT1, true, 15000),
                    new Chest(new Location(getWorld("Dungeon"), 9, 6, 1), Loot.BRICKT1, true, 15000),
                    new Chest(new Location(getWorld("Dungeon"), 8, 6, -2), Loot.BRICKT1, true, 15000),
                    new Spawner(new Location(DungeonManager.world, 7, 0, -1), SpawnerEnum.BRICK_SKELETON),
                    new Spawner(new Location(DungeonManager.world, 6, 3, 0), SpawnerEnum.BRICK_SKELETON),
                    new PaintingSpawner(new Location(DungeonManager.world, 13, 1, -5), "alban", StructureRotation.ROTATION_180, false),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 7, 1, 1), new ItemStack(Material.BONE), StructureRotation.ROTATION_90),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 7, 4, 3), new ItemStack(Material.BONE), StructureRotation.ROTATION_270),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 7, 4, -3), new ItemStack(Material.ARROW), StructureRotation.ROTATION_90)))),
    CROSS11 ("cross11", 19, 9, 15, new Location(getWorld("Dungeon"), 0, -1, -7), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 3, 0, 8, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 3, 0, -8, 270, 0), Region.BRICK)),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 17, 4, 6), Loot.BRICKT1, false, 40000),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 7, 1, 1), new ItemStack(Material.STONE_SWORD), StructureRotation.NONE, false, true),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 7, 1, -2), new ItemStack(Material.STONE_SWORD), StructureRotation.NONE, false, true),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 10, 1, 6), new ItemStack(Material.WHEAT), StructureRotation.ROTATION_270),
                    new DungeonEntity(new Location(DungeonManager.world, 12.5, 0, 0.5), DungeonMob.SETTE),
                    new DungeonEntity(new Location(DungeonManager.world, 12.5, 0, 0.5), DungeonMob.ROSANDE),
                    new DungeonEntity(new Location(DungeonManager.world, 12.5, 0, 0.5), DungeonMob.LUXAN),
                    new DungeonEntity(new Location(DungeonManager.world, 12.5, 0, 0.5), DungeonMob.GRISHA),
                    new DungeonEntity(new Location(DungeonManager.world, 8.5, 0, 4.5), DungeonMob.DUNGEON_LLAMA),
                    new DungeonEntity(new Location(DungeonManager.world, 8.5, 0, 4.5), DungeonMob.DUNGEON_LLAMA)))),
    CROSS12 ("cross12", 17, 5, 17, new Location(getWorld("Dungeon"), 0, -1, -8), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 17, 0, 0, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 8, 0, 9, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 8, 0, -9, 270, 0), Region.BRICK)),
            new ArrayList<>()),
    CROSS13 ("cross13", 9, 11, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 9, 0, 0, 0, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 4, 0, 5, 90, 0), Region.BRICK,
                    new Location(getWorld("Dungeon"), 4, 0, -5, 270, 0), Region.BRICK)),
            new ArrayList<>()),

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
                    new Chest(new Location(DungeonManager.world, 1, -3, -2), Loot.BRICKT1, true, 33000),
                    new Chest(new Location(DungeonManager.world, 1, -4, -4), Loot.BRICKT1, true, 33000),
                    new Chest(new Location(DungeonManager.world, 1, -4, -5), Loot.BRICKT1, true, 33000),
                    new Chest(new Location(DungeonManager.world, 2, -4, -6), Loot.BRICKT1, true, 33000),
                    new Chest(new Location(DungeonManager.world, 5, -4, 1), Loot.BRICKT1, true, 33000),
                    new Chest(new Location(DungeonManager.world, 1, -4, 13), Loot.BRICKT1, true, 33000),
                    new DungeonEntity(new Location(getWorld("Dungeon"), 29.5, 0, 0.5, 90, 0), DungeonMob.GATEKEEPER_SKELETON, -1, 3),
                    new IronGate(new Location(getWorld("Dungeon"), 30, 0, 0), 3),

                    new DungeonEntity(new Location(getWorld("Dungeon"), 29.5, 0, 16.5, 90, 0), DungeonMob.GATEKEEPER_SKELETON, -1, 4),
                    new IronGate(new Location(getWorld("Dungeon"), 30, 0, 16), 4),

                    new DungeonEntity(new Location(getWorld("Dungeon"), 7.5, 0, 22.5, 180, 0), DungeonMob.GATEKEEPER_SKELETON, -1, 6),
                    new IronGate(new Location(getWorld("Dungeon"), 7, 0, 23), 6),

                    new DungeonEntity(new Location(getWorld("Dungeon"), 23.5, 0, 22.5, 180, 0), DungeonMob.GATEKEEPER_SKELETON, -1, 5),
                    new IronGate(new Location(getWorld("Dungeon"), 23, 0, 23), 5),

                    new DungeonEntity(new Location(getWorld("Dungeon"), 1.5, 0, 16.5, 270, 0), DungeonMob.GATEKEEPER_SKELETON, -1, 7),
                    new IronGate(new Location(getWorld("Dungeon"), 0, 0, 16), 7),

                    new DungeonEntity(new Location(getWorld("Dungeon"), 7.5, 0, -5.5, 0, 0), DungeonMob.GATEKEEPER_SKELETON, -1, 1),
                    new IronGate(new Location(getWorld("Dungeon"), 7, 0, -7), 1),

                    new DungeonEntity(new Location(getWorld("Dungeon"), 23.5, 0, -4.5, 0, 0), DungeonMob.GATEKEEPER_SKELETON, -1, 2),
                    new IronGate(new Location(getWorld("Dungeon"), 23, 0, -7), 2),
                    new Spawner(new Location(getWorld("Dungeon"), 10, 6, 8), SpawnerEnum.GLADIATOR),
                    new Spawner(new Location(getWorld("Dungeon"), 15, 6, 3), SpawnerEnum.GLADIATOR),
                    new Spawner(new Location(getWorld("Dungeon"), 20, 6, 8), SpawnerEnum.GLADIATOR),
                    new Spawner(new Location(getWorld("Dungeon"), 15, 6, 13), SpawnerEnum.GLADIATOR),
                    new ItemFrameSpawner(new Location(DungeonManager.world, 11, -2, 20), new ItemStack(Material.CLOCK), StructureRotation.ROTATION_90))));

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
