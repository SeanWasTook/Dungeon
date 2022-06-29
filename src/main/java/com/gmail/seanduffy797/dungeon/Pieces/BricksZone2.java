package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.EntityManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.plugin.Plugin;

import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public enum BricksZone2 implements Bricks {

    HALL101 ("hall101", 6, 6, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 6, 0, 0), Region.BRICK2)),
            new ArrayList<>()),
    HALL102 ("hall102", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.BRICK2)),
            new ArrayList<>()),
    HALL103 ("hall103", 3, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.BRICK2)),
            new ArrayList<>()),
    HALL104 ("hall104", 5, 6, 9, new Location(getWorld("Dungeon"), 0, -1, -4), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.BRICK2)),
            new ArrayList<>()),

    HALL105 ("hall105", 7, 7, 11, new Location(getWorld("Dungeon"), 0, -2, -8), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -1, 3, 90, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL106 ("hall106", 7, 7, 5, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -1, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, -3, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL107 ("hall107", 7, 7, 5, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -1, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, -3, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL108 ("hall108", 7, 7, 5, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -1, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, -3, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL109 ("hall109", 7, 7, 5, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, 0, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, 0, -3, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL110 ("hall110", 7, 7, 7, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -1, 4, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, -4, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL111 ("hall111", 7, 7, 5, new Location(getWorld("Dungeon"), 0, -1, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, 0, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, 0, -3, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL112 ("hall112", 7, 7, 5, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -1, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, -3, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL113 ("hall113", 7, 7, 5, new Location(getWorld("Dungeon"), 0, -2, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -1, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, -3, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    HALL114 ("hall114", 7, 7, 5, new Location(getWorld("Dungeon"), 0, -3, -2), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -2, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -2, -3, 270, 0), Region.HOUSE)),
            new ArrayList<>()),

    HALL115 ("hall115", 7, 8, 7, new Location(getWorld("Dungeon"), 0, -3, -3), false,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK2)),
            new ArrayList<>(Arrays.asList(
                    new Trigger(new Location(getWorld("Dungeon"), 3, 1, 0), 1),
                    new EditableBlock(new Location(getWorld("Dungeon"), 2, -2, 2), Material.REDSTONE_BLOCK, 1),
                    new EditableBlock(new Location(getWorld("Dungeon"), 2, 4, 2), Material.REDSTONE_BLOCK, 1),
                    new ItemFrameChecker(new Location(getWorld("Dungeon"), 0, 1, -1), Rotation.COUNTER_CLOCKWISE, 1),
                    new ItemFrameChecker(new Location(getWorld("Dungeon"), 2, 1, -1), Rotation.FLIPPED, 1),
                    new ItemFrameChecker(new Location(getWorld("Dungeon"), 0, 1, 1), Rotation.COUNTER_CLOCKWISE_45, 1),
                    new ItemFrameChecker(new Location(getWorld("Dungeon"), 2, 1, 1), Rotation.CLOCKWISE, 1))
            )),
    HALL116 ("hall116", 5, 5, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.BRICK2)),
            new ArrayList<>()),

    TURN101 ("turn101", 7, 7, 7, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, -1, 0, 0, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, 4, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK2)),
            new ArrayList<>()),
    TURN102 ("turn102", 9, 7, 9, new Location(getWorld("Dungeon"), 0, -1, -5), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 9, 0, 0, 0, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 5, 0, 4, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 5, 0, -6, 270, 0), Region.BRICK2)),
            new ArrayList<>()),

    T101 ("t101", 11, 7, 16, new Location(getWorld("Dungeon"), 0, -2, -5), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 11, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 5, 0, -6, 270, 0), Region.BRICK2)),
            new ArrayList<>()),
    T102 ("t102", 7, 7, 6, new Location(getWorld("Dungeon"), 0, -2, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, -1, 3, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK2)),
            new ArrayList<>()),
    T103 ("t103", 7, 5, 10, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.BRICK2)),
            new ArrayList<>()),

    END101 ("end101", 2, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 2, 0, 0), Region.HOUSE)),
            new ArrayList<>()),

    ROOM101 ("room101", 5, 5, 11, new Location(getWorld("Dungeon"), 0, -1, -5), true,
            new HashMap<>(),
            new ArrayList<>()),
    ROOM102 ("room102", 7, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 7, 0, 0, 0, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, 0, 4, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, 0, -4, 270, 0), Region.HOUSE)),
            new ArrayList<>()),
    ROOM103 ("room103", 21, 8, 21, new Location(getWorld("Dungeon"), 0, -3, -10), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 21, -1, 7, 0, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 21, -1, 0, 0, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 21, -1, -7, 0, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, 11, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 10, -1, 11, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 17, -1, 11, 90, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 3, -1, -11, 270, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 10, -1, -11, 270, 0), Region.HOUSE,
                    new Location(getWorld("Dungeon"), 17, -1, -11, 270, 0), Region.HOUSE)),
            new ArrayList<>()),

    CROSS1 ("cross1", 23, 5, 23, new Location(getWorld("Dungeon"), 0, -1, -11), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 23, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 11, 0, 12, 90, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 11, 0, -12, 270, 0), Region.BRICK2)),
            new ArrayList<>()),
    CROSS4 ("cross4", 11, 7, 11, new Location(getWorld("Dungeon"), 0, -1, -5), false,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 11, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 5, 0, 6, 90, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 5, 0, -6, 270, 0), Region.BRICK2)),
            new ArrayList<>()),
    CROSS6 ("cross6", 21, 11, 21, new Location(getWorld("Dungeon"), 0, -6, -8), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 21, 0, 0, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 8, 0, 13, 90, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 12, 0, -9, 270, 0), Region.BRICK2)),
            new ArrayList<>()),
    CROSS7 ("cross7", 22, 9, 29, new Location(getWorld("Dungeon"), 0, -2, -14), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 22, -1, -1, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 13, 0, 15, 90, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 14, 0, -15, 270, 0), Region.BRICK2)),
            new ArrayList<>(Collections.singletonList(
                    new Entity(new Location(getWorld("Dungeon"), 14, -1, 0.5), Mob.AXEVINDICATOR, 10000)))),
    CROSS8 ("cross8", 11, 16, 9, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Map.of(
                    new Location(getWorld("Dungeon"), 11, 2, 1, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 4, 0, 6, 90, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 6, 1, -4, 270, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 11, 10, 2, 0, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 7, 10, 6, 90, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), 5, 8, -4, 270, 0), Region.BRICK2,
                    new Location(getWorld("Dungeon"), -1, 8, 1, 180, 0), Region.BRICK2)),
            new ArrayList<>()),

    HOUSE0 ("house0", 1, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE1 ("house1", 2, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE2 ("house2", 3, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE3 ("house3", 6, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE4 ("house4", 4, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE5 ("house5", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE6 ("house6", 6, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE7 ("house7", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE8 ("house8", 6, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE9 ("house9", 6, 10, 7, new Location(getWorld("Dungeon"), 0, -4, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE10 ("house10", 6, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE11 ("house11", 6, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE12 ("house12", 6, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE13 ("house13", 6, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),

    HOUSE14 ("house14", 4, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 4, 0, 0), Region.HOUSE)),
            new ArrayList<>()),
    HOUSE15 ("house15", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 5, 0, 0), Region.HOUSE)),
            new ArrayList<>()),
    HOUSE16 ("house16", 3, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.HOUSE)),
            new ArrayList<>()),
    HOUSE17 ("house17", 2, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 2, 0, 0), Region.HOUSE)),
            new ArrayList<>()),
    HOUSE24 ("house24", 3, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.HOUSE)),
            new ArrayList<>()),
    HOUSE25 ("house25", 4, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 4, 0, 0), Region.HOUSE)),
            new ArrayList<>()),
    HOUSE26 ("house26", 3, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 3, 0, 0), Region.HOUSE)),
            new ArrayList<>()),

    HOUSE18 ("house18", 6, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE19 ("house19", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE20 ("house20", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE21 ("house21", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE22 ("house22", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE23 ("house23", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE27 ("house27", 4, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE28 ("house28", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE29 ("house29", 5, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(),
            new ArrayList<>()),
    HOUSE30 ("house30", 6, 12, 7, new Location(getWorld("Dungeon"), 0, -6, -3), true,
            new HashMap<>(),
            new ArrayList<>(Collections.singletonList(
                    new LockedTrapdoor(new Location(getWorld("Dungeon"), 3, -1, 2), LockEnum.BASEMENTKEY)))),

    HOUSEHALL1 ("househall1", 7, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK2)),
            new ArrayList<>()),
    HOUSEHALL2 ("househall2", 7, 7, 7, new Location(getWorld("Dungeon"), 0, -1, -3), true,
            new HashMap<>(Collections.singletonMap(
                    new Location(getWorld("Dungeon"), 7, 0, 0), Region.BRICK2)),
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

    BricksZone2(String name, int length, int height, int width, Location startOffset, boolean mirror, Map<Location, Region> exits, ArrayList<Focus> focuses) {
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

    BricksZone2(String name, int length, int height, int width, Location startOffset, boolean mirror, boolean even, Map<Location, Region> exits, ArrayList<Focus> focuses) {
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
                .onProcessEntity(entity -> {
                    if (entity.getEntity().isPresent()) {
                        EntityManager.addEntity(entity.getEntity().get().getUniqueId());
                    }
                    return true;
                })
                .loadFromPath(path)
                .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to load structure." + name, e));
    }
}
