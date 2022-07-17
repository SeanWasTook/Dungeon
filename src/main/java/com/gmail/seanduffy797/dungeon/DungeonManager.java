package com.gmail.seanduffy797.dungeon;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class DungeonManager {

    public static NamespacedKey customItemKey;
    public static boolean isGenerated;
    public static World world;
    public static Map<KeyLocation, Location> keyLocations = new HashMap<>();

    public static void init(Plugin plugin, World dungeonWorld) {
        customItemKey = new NamespacedKey(plugin, "customItem");
        DungeonManager.world = dungeonWorld;
        isGenerated = false;
        keyLocations.put(KeyLocation.SPAWN, new Location(world, 0.5, 102, 0.5));
        keyLocations.put(KeyLocation.ARENA, new Location(world, 0.5, 152, 0.5));
    }
}
