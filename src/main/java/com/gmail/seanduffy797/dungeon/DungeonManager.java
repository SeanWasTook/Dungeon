package com.gmail.seanduffy797.dungeon;

import com.destroystokyo.paper.Namespaced;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.builders.maze.MazeOptions;
import com.gmail.seanduffy797.dungeon.regions.Region;
import com.gmail.seanduffy797.dungeon.builders.BrickBuilder;
import com.gmail.seanduffy797.dungeon.builders.MineBuilder;
import com.gmail.seanduffy797.dungeon.builders.maze.StoneBrickMazeBuilder;
import com.gmail.seanduffy797.dungeon.builders.wavefunction.PuebloBuilder;
import com.gmail.seanduffy797.dungeon.curses.CurseManager;
import com.gmail.seanduffy797.dungeon.display.BossBarCountdown;
import com.gmail.seanduffy797.dungeon.players.PlayerManager;
import com.gmail.seanduffy797.dungeon.regions.RegionManager;
import com.gmail.seanduffy797.dungeon.regions.StoneBrickManager;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

import static org.bukkit.Bukkit.getServer;

public class DungeonManager {

    // Less Dynamic Values
    public static final int totalLifetimeTicks = 108000; // 1.5 hours
    public static NamespacedKey customItemKey;
    public static NamespacedKey customMobKey;
    public static World world;
    public static ArrayList<Namespaced> commonBlocks;
    public static BossBarCountdown bossBarCountdown;

    // More Dynamic Values
    public static BukkitScheduler scheduler;
    public static Map<UUID, Player> onlinePlayers = new HashMap<>();
    public static boolean isPlaying;
    public static boolean isGenerated;
    public static RegionMap regionMap = null;
    public static Map<Region, Boolean> isRegionGenerated = new HashMap<>();
    public static Map<Region, EntityList> entityLists = new HashMap<>();
    public static Map<Region, TaskList> taskLists = new HashMap<>();
    public static Map<KeyLocation, Location> keyLocations = new HashMap<>();
    public static Map<Region, PuebloBuilder> builders = new HashMap<>();
    public static Map<Region, RegionManager> regionManagers = new HashMap<>();

    public static void init(Plugin plugin, World dungeonWorld) {
        customItemKey = new NamespacedKey(plugin, "customItem");
        customMobKey = new NamespacedKey(plugin, "customMob");
        DungeonManager.world = dungeonWorld;
        scheduler = getServer().getScheduler();

        isPlaying = false;
        isGenerated = false;
        keyLocations.put(KeyLocation.SPAWN, new Location(world, 0.5, 102, 0.5));
        keyLocations.put(KeyLocation.ARENA, new Location(world, 0.5, 152, 0.5));

        commonBlocks = new ArrayList<>(Arrays.asList(Material.GRANITE.getKey(),
                Material.POLISHED_GRANITE.getKey(),
                Material.BRICKS.getKey(),
                Material.STONE_BRICKS.getKey(),
                Material.STONE.getKey(),
                Material.SPRUCE_PLANKS.getKey()));

        builders.put(Region.PUEBLO, new PuebloBuilder());
        CurseManager.init();
    }

    public static void startPlaying() {
        if (!isPlaying) {
            isPlaying = true;
            regionManagers.put(Region.STONE_BRICK, new StoneBrickManager());
            bossBarCountdown = new BossBarCountdown(totalLifetimeTicks);
            scheduler.scheduleSyncRepeatingTask(Dungeon.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    DungeonManager.tick();
                }
            }, 0L, 1L);
        }
    }

    public static void tick() {
        for (Player player: onlinePlayers.values()) {
            PlayerManager.updatePlayer(player);
        }
        if (!isPlaying) {
            return;
        }
        bossBarCountdown.tick();
    }

    public static void addEntityToRegion(Region region, Entity entity) {
        if (entityLists.containsKey(region)) {
            entityLists.get(region).addEntity(entity);
        } else {
            entityLists.put(region, new EntityList());
            entityLists.get(region).addEntity(entity);
        }
    }
    public static void clearEntitiesFromRegion(Region region) {
        if (entityLists.containsKey(region)) {
            entityLists.get(region).clearEntities();
        }
    }
    public static void addTaskToRegion(Region region, BukkitTask task) {
        if (taskLists.containsKey(region)) {
            taskLists.get(region).addTask(task);
        } else {
            taskLists.put(region, new TaskList());
            taskLists.get(region).addTask(task);
        }
    }
    public static void clearTasksForRegion(Region region) {
        if (taskLists.containsKey(region)) {
            taskLists.get(region).clear();
        }
    }
    public static void buildRegion(Region region) {
        isRegionGenerated.put(region, true);
        isGenerated = true;
        startPlaying();
        if (regionMap == null) {
            regionMap = new RegionMap();
            Location spawnCorner1 = new Location(world, -48, 97, -48);
            Location spawnCorner2 = new Location(world, 48, 143, 48);
            regionMap.fillRegionData(spawnCorner1, spawnCorner2, Region.SPAWN);
        }
        switch (region) {
            case BRICK:
                BrickBuilder.build();
                break;
            case MINE:
                MineBuilder.build();
                break;
            case STONE_BRICK:
                regionManagers.get(Region.STONE_BRICK).build();
                break;
            case PUEBLO:
                builders.get(Region.PUEBLO).build();
                break;
        }
    }
    public static void buildAll() {
        buildRegion(Region.BRICK);
        buildRegion(Region.MINE);
        buildRegion(Region.STONE_BRICK);
        startPlaying();
    }

    public static void clearRegion(Region region) {
        if (isRegionGenerated.containsKey(region) && isRegionGenerated.get(region)) {
            switch (region) {
                case BRICK:
                    BrickBuilder.clear();
                    break;
                case MINE:
                    MineBuilder.clear();
                    break;
                case STONE_BRICK:
                    regionManagers.get(Region.STONE_BRICK).clear();
                    break;
                case PUEBLO:
                    builders.get(Region.PUEBLO).clear();
                    break;
            }
            clearEntitiesFromRegion(region);
            clearTasksForRegion(region);
            isRegionGenerated.put(region, false);
        }
    }
    public static void clearAll() {
        for (Region region: isRegionGenerated.keySet()) {
            if (isRegionGenerated.get(region)) {
                clearRegion(region);
            }
        }
        clearEntitiesFromRegion(Region.NONE);
        clearTasksForRegion(Region.NONE);
        isPlaying = false;
        isGenerated = false;
        regionMap = null;
        bossBarCountdown.cancel();
    }
    public static void clearFluff() {
        for (Region region: entityLists.keySet()) {
            clearEntitiesFromRegion(region);
        }
        for (Region region: taskLists.keySet()) {
            clearTasksForRegion(region);
        }
    }
    public static void updateRegionMap(Location corner1, Location corner2, Region region) {
        regionMap.fillRegionData(corner1, corner2, region);
    }
    public static Region getRegionAt(Location location) {
        if (regionMap != null) {
            return regionMap.getRegionAtLocation(location);
        } else {
            return Region.NONE;
        }
    }
    public static void addOnlinePlayer(Player player) {
        onlinePlayers.put(player.getUniqueId(), player);
    }
    public static void removeOnlinePlayer(UUID uuid) {
        onlinePlayers.remove(uuid);
    }
}
