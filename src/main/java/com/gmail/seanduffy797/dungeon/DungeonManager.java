package com.gmail.seanduffy797.dungeon;

import com.destroystokyo.paper.Namespaced;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DungeonManager {

    public static NamespacedKey customItemKey;
    public static NamespacedKey customMobKey;
    public static boolean isGenerated;
    public static World world;
    public static Map<KeyLocation, Location> keyLocations = new HashMap<>();
    public static ArrayList<Namespaced> commonBlocks;

    public static void init(Plugin plugin, World dungeonWorld) {
        customItemKey = new NamespacedKey(plugin, "customItem");
        customMobKey = new NamespacedKey(plugin, "customMob");
        DungeonManager.world = dungeonWorld;
        isGenerated = false;
        keyLocations.put(KeyLocation.SPAWN, new Location(world, 0.5, 102, 0.5));
        keyLocations.put(KeyLocation.ARENA, new Location(world, 0.5, 152, 0.5));

        commonBlocks = new ArrayList<>(Arrays.asList(Material.GRANITE.getKey(),
                Material.POLISHED_GRANITE.getKey(),
                Material.BRICKS.getKey(),
                Material.STONE_BRICKS.getKey(),
                Material.STONE.getKey(),
                Material.SPRUCE_PLANKS.getKey()));
    }
}
