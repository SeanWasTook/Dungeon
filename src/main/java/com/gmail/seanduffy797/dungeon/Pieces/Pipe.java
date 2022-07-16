package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.entity.StructureEntity;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.EntityManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Chest;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Loot;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public enum Pipe implements Bricks{

    P2HALL1 ("pipe/2hall1", 3, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -1), true, true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.PIPE2)),
            new ArrayList<>()),
    P2HALL2 ("pipe/2hall2", 1, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -1), true, true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 1, 0, 0), Region.PIPE2)),
            new ArrayList<>()),
    P2TURN1 ("pipe/2turn1", 4, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -1), true, true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 1, 0, -2, 270, 0), Region.PIPE2)),
            new ArrayList<>()),
    P2T1 ("pipe/2t1", 4, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -1), false, true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 2, 0, 3, 90, 0), Region.PIPE2,
                    new Location(getWorld("Dungeon"), 1, 0, -2, 270, 0), Region.PIPE2)),
            new ArrayList<>()),
    P2CROSS1 ("pipe/2cross1", 4, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -1), false, true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 4, 0, 0), Region.PIPE2,
                    new Location(getWorld("Dungeon"), 2, 0, 3, 90, 0), Region.PIPE2,
                    new Location(getWorld("Dungeon"), 1, 0, -2, 270, 0), Region.PIPE2)),
            new ArrayList<>()),
    P2END0 ("pipe/2end0", 1, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -1), true, true,
            new HashMap<>(),
            new ArrayList<>()),
    P2END1 ("pipe/2end1", 4, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -1), true, true,
            new HashMap<>(),
            new ArrayList<>()),
    P2END2 ("pipe/2end2", 4, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -1), true, true,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 2, 0, 0), Loot.BRICKWATER, false, 6000)))),

    P3HALL1 ("pipe/3hall1", 3, 5, 5, new Location(getWorld("Dungeon"), 0, -2, -2), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3HALL2 ("pipe/3hall2", 1, 5, 5, new Location(getWorld("Dungeon"), 0, -2, -2), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 1, 0, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3HALL3 ("pipe/3hall3", 1, 5, 5, new Location(getWorld("Dungeon"), 0, -2, -2), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 1, 0, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3HALL4 ("pipe/3hall4", 3, 5, 5, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3HALL5 ("pipe/3hall5", 3, 5, 5, new Location(getWorld("Dungeon"), 0, -2, -2), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3HALL6 ("pipe/3hall6", 1, 5, 5, new Location(getWorld("Dungeon"), 0, -2, -2), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 1, 0, 0), Region.PIPE3)),
            new ArrayList<>()),

    P3TURN1 ("pipe/3turn1", 5, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 2, 0, -3, 270, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3T1 ("pipe/3t1", 5, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.PIPE3,
                    new Location(getWorld("Dungeon"), 2, 0, -3, 270, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3CROSS1 ("pipe/3cross1", 5, 5, 4, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.PIPE3,
                    new Location(getWorld("Dungeon"), 2, 0, 3, 90, 0), Region.PIPE3,
                    new Location(getWorld("Dungeon"), 2, 0, -3, 270, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3CROSS2 ("pipe/3cross2", 7, 5, 7, new Location(getWorld("Dungeon"), 0, -6, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.PIPE3,
                    new Location(getWorld("Dungeon"), 3, 0, 4, 90, 0), Region.PIPE3,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.PIPE3)),
            new ArrayList<>()),
    P3END0 ("pipe/3end0", 1, 5, 5, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(),
            new ArrayList<>()),
    P3END1 ("pipe/3end1", 4, 5, 5, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(),
            new ArrayList<>()),
    P3ROOM1 ("pipe/3room1", 7, 8, 7, new Location(getWorld("Dungeon"), 0, -4, -3), true,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 4, 1, 0), Loot.BRICKWATER, false, 6000))));

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

    Pipe(String name, int length, int height, int width, Location startOffset, boolean mirror, Map<Location, Region> exits, ArrayList<Focus> focuses) {
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

    Pipe(String name, int length, int height, int width, Location startOffset, boolean mirror, boolean even, Map<Location, Region> exits, ArrayList<Focus> focuses) {
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
