package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.entity.StructureEntity;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.EntityManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public enum Sewer implements Bricks{

    HALL4 ("hall4", 13, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 13, 0, 0), Region.SEWER)),
            new ArrayList<>()),
    CROSS2 ("cross2", 41, 25, 41, new Location(getWorld("Dungeon"), 0, -8, -20), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 41, 0, 0, 0, 0), Region.SEWER,
                    new Location(getWorld("Dungeon"), 20, 0, 21, 90, 0), Region.SEWER,
                    new Location(getWorld("Dungeon"), 20, 0, -21, 270, 0), Region.SEWER,
                    new Location(getWorld("Dungeon"), 41, 11, -7, 0, 0), Region.PIPE2,
                    new Location(getWorld("Dungeon"), 27, 7, 21, 90, 0), Region.PIPE3)),
            new ArrayList<>(Arrays.asList(
                    new Chest(new Location(getWorld("Dungeon"), 4, 0, 9), Loot.BRICKWATER, true, 30000),
                    new Chest(new Location(getWorld("Dungeon"), 10, 9, -1), Loot.BRICKT1, true, 30000),
                    new Chest(new Location(getWorld("Dungeon"), 4, 6, 15), Loot.BRICKWATER, true, 30000),
                    new Chest(new Location(getWorld("Dungeon"), 22, 9, 10), Loot.BRICKT1, true, 30000),
                    new Chest(new Location(getWorld("Dungeon"), 27, 13, 7), Loot.BRICKT2, true, 30000),
                    new DungeonEntity(new Location(DungeonManager.world, 20.5, -5, -1.5), DungeonMob.COMMON_DROWNED, 8000),
                    new DungeonEntity(new Location(DungeonManager.world, 20.5, -5, 2.5), DungeonMob.COMMON_DROWNED, 8000)))),

    SEWERTRANSITION ("sewertransition", 1, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 1, 0, 0), Region.SEWER)),
            new ArrayList<>()),
    SEWERHALL2 ("sewerhall2", 5, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.SEWER)),
            new ArrayList<>(Collections.singletonList(
                    new DungeonEntity(new Location(DungeonManager.world, 2.5, -3, 0.5), DungeonMob.COMMON_DROWNED, 8000)
            ))),
    SEWERTURN1 ("sewerturn1", 7, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.SEWER)),
            new ArrayList<>(Collections.singletonList(
                    new PaintingSpawner(new Location(DungeonManager.world, 2, 2, 2), "wasteland", StructureRotation.ROTATION_270, false)
            ))),
    SEWERT1 ("sewert1", 7, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.SEWER,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.SEWER)),
            new ArrayList<>()),

    SEWEREND0 ("sewerend0", 1, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    SEWEREND1 ("sewerend1", 3, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    SEWEREND2 ("sewerend2", 3, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 1, 1, -1), Loot.BRICKWATER, true, 35000)))),

    SEWERROOM1 ("sewerroom1", 12, 15, 13, new Location(getWorld("Dungeon"), 0, -5, -6), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 12, 2, 0, 0, 0), Region.PIPE3,
                    new Location(getWorld("Dungeon"), 6, 5, 7, 90, 0), Region.PIPE2,
                    new Location(getWorld("Dungeon"), 5, 5, -7, 270, 0), Region.PIPE2)),
            new ArrayList<>(Arrays.asList(
                    new Spawner(new Location(DungeonManager.world, 6, 1,3), SpawnerEnum.COMMON_DROWNED),
                    new Chest(new Location(getWorld("Dungeon"), 1, 6, -3), Loot.BRICKWATER, true, 30000),
                    new Chest(new Location(getWorld("Dungeon"), 7, -4, 2), Loot.BRICKWATER, true, 30000),
                    new DungeonEntity(new Location(DungeonManager.world, 5.5, -2, 0.5), DungeonMob.COMMON_DROWNED, 8000)))),
    SEWERROOM2 ("sewerroom2", 4, 10, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 4, 1, 0), Region.PIPE3)),
            new ArrayList<>()),

    SEWERBIGPIPE1 ("sewerbigpipe1", 4, 14, 11, new Location(getWorld("Dungeon"), 0, -5, -5), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 4, 0, 0), Region.BIGPIPE)),
            new ArrayList<>()),

    BIGPIPEHALL1 ("bigpipehall1", 1, 9, 9, new Location(getWorld("Dungeon"), 0, -2, -4), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 1, 0, 0), Region.BIGPIPE)),
            new ArrayList<>()),
    BIGPIPETURN1 ("bigpipeturn1", 9, 9, 9, new Location(getWorld("Dungeon"), 0, -2, -4), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 4, 0, -5), Region.BIGPIPE)),
            new ArrayList<>()),

    HALLPIPE2T ("hallpipe2t", 9, 10, 10, new Location(getWorld("Dungeon"), 0, -5, -4), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 9, 0, 0), Region.SEWER,
                    new Location(getWorld("Dungeon"), 4, 0, -5, 270, 0), Region.SEWER,
                    new Location(getWorld("Dungeon"), 4, 2, 6, 90, 0), Region.PIPE2)),
            new ArrayList<>(Collections.singletonList(
                    new Chest(new Location(getWorld("Dungeon"), 6, 0, 4), Loot.BRICKWATER, true, 35000)))),

    HALLPIPE3CROSS ("hallpipe3cross", 9, 13, 7, new Location(getWorld("Dungeon"), 0, -5, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 9, 0, 0, 0, 0), Region.SEWER,
                    new Location(getWorld("Dungeon"), 4, 5, 4, 90, 0), Region.PIPE3,
                    new Location(getWorld("Dungeon"), 4, 5, -4, 270, 0), Region.PIPE3)),
            new ArrayList<>());

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

    Sewer(String name, int length, int height, int width, Location startOffset, boolean mirror, Map<Location, Region> exits, ArrayList<Focus> focuses) {
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

    Sewer(String name, int length, int height, int width, Location startOffset, boolean mirror, boolean even, Map<Location, Region> exits, ArrayList<Focus> focuses) {
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
