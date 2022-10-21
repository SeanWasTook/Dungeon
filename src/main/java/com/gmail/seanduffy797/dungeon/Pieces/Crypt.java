package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public enum Crypt {

    HALL1 ("hall1", 6, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 6, 0, 0))),
            new ArrayList<>()),
    HALL2 ("hall2", 6, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 6, 0, 0))),
            new ArrayList<>()),
    HALL3 ("hall3", 6, 5, 8, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 6, 0, 0))),
            new ArrayList<>()),
    HALL4 ("hall4", 6, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 6, 0, 0))),
            new ArrayList<>()),
    HALL5 ("hall5", 5, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 5, 0, 0))),
            new ArrayList<>()),
    HALL6 ("hall6", 8, 7, 8, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 8, 0, 0))),
            new ArrayList<>()),
    HALL7 ("hall7", 11, 7, 8, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 11, 0, 0))),
            new ArrayList<>()),

    DOOR1 ("door1", 1, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 1, 0, 0))),
            new ArrayList<>()),

    WALL ("wall", 1, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), false,
            new ArrayList<>(),
            new ArrayList<>()),

    END1 ("end1", 2, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(),
            new ArrayList<>()),
    END2 ("end2", 7, 5, 8, new Location(getWorld("Dungeon"), 0, -1, -3), false,
            new ArrayList<>(),
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 5, 1, 0),
                    new Location(getWorld("Dungeon"), 5, 1, 1)))),
    END3 ("end3", 5, 5, 8, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new ArrayList<>(),
            new ArrayList<>()),
    END4 ("end4", 4, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(),
            new ArrayList<>()),
    END5 ("end5", 5, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(),
            new ArrayList<>()),
    END6 ("end6", 4, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(),
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 1, 0, -1)))),

    ROOM1 ("room1", 10, 6, 14, new Location(getWorld("Dungeon"), 0, -1, -7), true,
            new ArrayList<>(),
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 8, 0, 0),
                    new Location(getWorld("Dungeon"), 8, 0, 1),
                    new Location(getWorld("Dungeon"), 1, -1, -4)))),
    ROOM2 ("room2", 11, 7, 12, new Location(getWorld("Dungeon"), 0, -1, -5), true,
            new ArrayList<>(),
            new ArrayList<>()),

    T1 ("t1", 8, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 8, 0, 0),
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0))),
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 3, 0, 3),
                    new Location(getWorld("Dungeon"), 4, 0, 3)))),
    T2 ("t2", 8, 5, 8, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 8, 0, 0),
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0))),
            new ArrayList<>()),

    STAIR1 ("stair1", 6, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 3, 2, 4, 90, 0))),
            new ArrayList<>()),
    STAIR2 ("stair2", 6, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 3, 2, 4, 90, 0),
                    new Location(getWorld("Dungeon"), 2, 2, -3, 270, 0))),
            new ArrayList<>()),
    STAIR3 ("stair3", 7, 12, 6, new Location(getWorld("Dungeon"), 0, -8, -2), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 7, -7, 0))),
            new ArrayList<>()),

    LAVAHALL1 ("lavahall1", 8, 7, 8, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 8, 0, 0))),
            new ArrayList<>()),
    LAVAHALL2 ("lavahall2", 11, 7, 8, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 11, 0, 0))),
            new ArrayList<>()),
    LAVATURN1 ("lavaturn1", 8, 7, 8, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 4, 0, 5, 90, 0))),
            new ArrayList<>()),
    LAVAT1 ("lavat1", 8, 7, 8, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 4, 0, 5, 90, 0),
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0))),
            new ArrayList<>()),
    LAVAROOM1 ("lavaroom1", 8, 7, 10, new Location(getWorld("Dungeon"), 0, -2, -4), false,
            new ArrayList<>(),
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 6, 1, 0),
                    new Location(getWorld("Dungeon"), 6, 1, 1)))),

    CROSS1 ("cross1", 13, 12, 14, new Location(getWorld("Dungeon"), 0, -1, -6), true,
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 13, 0, 0, 0, 0),
                    new Location(getWorld("Dungeon"), 10, 0, 8, 90, 0),
                    new Location(getWorld("Dungeon"), 9, 0, -7, 270, 0))),
            new ArrayList<>()),
    CROSS2 ("cross2", 18, 10, 18, new Location(getWorld("Dungeon"), 0, -1, -8), true,
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 18, 0, 0, 0, 0),
                    new Location(getWorld("Dungeon"), 11, 0, 10, 90, 0),
                    new Location(getWorld("Dungeon"), 7, 0, -9, 270, 0))),
            new ArrayList<>()),
    CROSS3 ("cross3", 9, 5, 6, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new ArrayList<>(Arrays.asList(
                    new Location(getWorld("Dungeon"), 9, 0, 0, 0, 0),
                    new Location(getWorld("Dungeon"), 4, 0, 4, 90, 0),
                    new Location(getWorld("Dungeon"), 4, 0, -3, 270, 0))),
            new ArrayList<>()),
    CROSS4 ("cross4", 12, 10, 14, new Location(getWorld("Dungeon"), 0, -3, -8), true,
            new ArrayList<>(Arrays.asList(
                new Location(getWorld("Dungeon"), 12, -2, -1, 0, 0),
                new Location(getWorld("Dungeon"), 12, 3, -4, 0, 0),
                new Location(getWorld("Dungeon"), 2, 1, 6, 90, 0),
                new Location(getWorld("Dungeon"), 8, 3, 6, 90, 0),
                new Location(getWorld("Dungeon"), 8, -1, -9, 270, 0))),
            new ArrayList<>(Collections.singletonList(
                    new Location(getWorld("Dungeon"), 9, -1, -3))));


    private final String name;
    private final Path path;
    private final int length;
    private final int height;
    private final int width;
    private final Location startOffset;
    private final boolean canMirror;
    private final ArrayList<Location> exits;
    private final ArrayList<Location> chests;

    Crypt(String name, int length, int height, int width, Location startOffset, boolean mirror, ArrayList<Location> exits, ArrayList<Location> chests) {
        this.name = name;
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        this.path = plugin.getDataFolder().toPath().resolve("crypt/" + this.name + ".nbt");
        this.length = length;
        this.height = height;
        this.width = width;
        this.startOffset = startOffset;
        this.canMirror = mirror;
        this.exits = exits;
        this.chests = chests;
    }

    public String getName() {return name;}
    public Path getPath() {return path;}
    public int getLength() {return length;}
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public Location getOffset() {return startOffset;}
    public boolean getMirror() {return canMirror;}
    public ArrayList<Location> getExits() {return exits;}
    public ArrayList<Location> getChests() {return chests;}

    public void place(Location location, StructureRotation rotation, StructureMirror mirror) {
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        if (plugin == null){ return;}

        StructureBlockLibApi.INSTANCE
                .loadStructure(plugin)
                .at(location)
                .includeEntities(true)
                .mirror(mirror)
                .rotation(rotation)
                .loadFromPath(path)
                .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to load structure." + name, e))
                .onResult(e -> plugin.getLogger().log(Level.INFO, ChatColor.GREEN + "Loaded structure: " + name));
    }
}
