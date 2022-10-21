package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.*;
import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public enum Early implements Mine {

    DOWN1 ("down1", 3, 4, 3, new Location(getWorld("Dungeon"), 0, -4, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 0, -4, 0), Region.MINE)),
            new ArrayList<>()),
    DOWN2 ("down2", 3, 4, 3, new Location(getWorld("Dungeon"), 0, -4, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 0, -4, 0), Region.MINE)),
            new ArrayList<>()),
    DOWN3 ("down3", 3, 4, 3, new Location(getWorld("Dungeon"), 0, -4, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 0, -4, 0), Region.MINE)),
            new ArrayList<>()),

    TRANSITION1 ("transition1", 3, 3, 3, new Location(getWorld("Dungeon"), 0, -3, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, -2, 0), Region.MINE)),
            new ArrayList<>()),

    STRAIGHT1 ("straight1", 3, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.MINE)),
            new ArrayList<>()),
    STRAIGHT2 ("straight2", 3, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.MINE)),
            new ArrayList<>()),
    STRAIGHT3 ("straight3", 3, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.MINE)),
            new ArrayList<>()),
    STRAIGHT4 ("straight4", 3, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.MINE)),
            new ArrayList<>()),
    STRAIGHT5 ("straight5", 5, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.MINE,
                    new Location(getWorld("Dungeon"), 2, 0, 2, 90, 0), Region.MINE_DECO)),
            new ArrayList<>()),

    STAIRUP1 ("stairup1", 3, 6, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 3, 0), Region.MINE)),
            new ArrayList<>()),

    STAIRDOWN1 ("stairdown1", 3, 6, 3, new Location(getWorld("Dungeon"), 0, -3, -1),
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, -3, 0), Region.MINE)),
            new ArrayList<>()),

    T1 ("t1", 3, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.MINE,
                    new Location(getWorld("Dungeon"), 1, 0, -2, 270, 0), Region.MINE)),
            new ArrayList<>()),

    DECO1 ("deco1", 1, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 0, 0, 0), Loot.MINE1, true, 15000)))),
    DECO2 ("deco2", 2, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(),
            new ArrayList<>()),
    DECO3 ("deco3", 2, 3, 3, new Location(getWorld("Dungeon"), 0, 0, -1),
            new HashMap<>(),
            new ArrayList<>()),

    CROSS1 ("cross1", 5, 3, 5, new Location(getWorld("Dungeon"), 0, 0, -2),
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 5, 0, 0, 0, 0), Region.MINE,
                    new Location(getWorld("Dungeon"), 2, 0, 3, 90, 0), Region.MINE,
                    new Location(getWorld("Dungeon"), 2, 0, -3, 270, 0), Region.MINE)),
            new ArrayList<>()),
    CROSS2 ("cross2", 7, 3, 7, new Location(getWorld("Dungeon"), 0, 0, -3),
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.MINE,
                    new Location(getWorld("Dungeon"), 3, 0, 4, 90, 0), Region.MINE,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.MINE)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 5, 0, -3), Loot.MINE1, false, -1)))),
    CROSS3 ("cross3", 15, 5, 15, new Location(getWorld("Dungeon"), 0, 0, -7),
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 15, 0, 0, 0, 0), Region.MINE,
                    new Location(getWorld("Dungeon"), 7, 0, 8, 90, 0), Region.MINE,
                    new Location(getWorld("Dungeon"), 7, 0, -8, 270, 0), Region.MINE)),
            new ArrayList<>(Arrays.asList(
                    new Spawner(new Location(DungeonManager.world, 5, 0, -3), SpawnerEnum.COMMON_SPIDER),
                    new Chest(new Location(getWorld("Dungeon"), 2, 0, -4), Loot.MINE1, false, -1),
                    new Chest(new Location(getWorld("Dungeon"), 11, 0, 4), Loot.MINE1, false, -1)))),

    CROSS4 ("cross4", 5, 6, 5, new Location(getWorld("Dungeon"), 0, 0, -2),
            new HashMap<>(Map.of(
                new Location(getWorld("Dungeon"), 5, 0, 0, 0, 0), Region.MINE,
                new Location(getWorld("Dungeon"), 2, 3, 3, 90, 0), Region.MINE,
                new Location(getWorld("Dungeon"), 2, 3, -3, 270, 0), Region.MINE)),
            new ArrayList<>());

    private final String name;
    private final Path path;
    private final int length;
    private final int height;
    private final int width;
    private final Location startOffset;
    private final Map<Location, Region> exits;
    private final ArrayList<Focus> focuses;

    Early(String name, int length, int height, int width, Location startOffset, Map<Location, Region> exits, ArrayList<Focus> focuses) {
        this.name = name;
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        this.path = plugin.getDataFolder().toPath().resolve("mine/" + this.name + ".nbt");
        this.length = length;
        this.height = height;
        this.width = width;
        this.startOffset = startOffset;
        this.exits = exits;
        this.focuses = focuses;
    }

    public String getName() {return name;}
    public Path getPath() {return path;}
    public int getLength() {return length;}
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public Location getOffset() {return startOffset;}
    public Map<Location, Region> getExits() {return exits;}
    public ArrayList<Focus> getFocuses() {return focuses;}

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
                .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to load structure." + name, e));
    }
}
