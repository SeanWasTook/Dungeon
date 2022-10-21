package com.gmail.seanduffy797.dungeon.players;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.regions.Region;
import com.gmail.seanduffy797.dungeon.curses.CurseManager;
import com.gmail.seanduffy797.dungeon.display.DungeonScoreboard;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static java.lang.Math.max;

public class PlayerManager {

    public static NamespacedKey brickScoreKey = new NamespacedKey(Dungeon.getPlugin(), "brick_score");
    public static NamespacedKey mineScoreKey = new NamespacedKey(Dungeon.getPlugin(), "mine_score");
    public static NamespacedKey mazeScoreKey = new NamespacedKey(Dungeon.getPlugin(), "maze_score");
    public static NamespacedKey puebloScoreKey = new NamespacedKey(Dungeon.getPlugin(), "pueblo_score");
    private static NamespacedKey[] scores = new NamespacedKey[]
            {brickScoreKey, mineScoreKey, mazeScoreKey, puebloScoreKey};
    public static NamespacedKey currentRegionKey = new NamespacedKey(Dungeon.getPlugin(), "current_region");

    public static void playerJoin(Player player) {
        if (player.getWorld().equals(DungeonManager.world) && DungeonManager.isPlaying) {
            DungeonManager.bossBarCountdown.addPlayer(player);
        }
        DungeonManager.addOnlinePlayer(player);
        DungeonScoreboard.addToPlayer(player);
        givePlayerPersistentData(player);
    }

    public static void updatePlayer(Player player) {
        Location loc = player.getLocation();
        Region currentRegion = DungeonManager.getRegionAt(loc);
        PersistentDataContainer container = player.getPersistentDataContainer();
        if (container.has(currentRegionKey, PersistentDataType.STRING)) {
            Region previousRegion = Region.valueOf(container.get(currentRegionKey, PersistentDataType.STRING));
            if (currentRegion != previousRegion) {
                if (currentRegion != Region.NONE) {
                    player.sendMessage("You are entering the domain of " + currentRegion.display());
                }
                container.set(currentRegionKey, PersistentDataType.STRING, currentRegion.name());
            }
        } else {
            container.set(currentRegionKey, PersistentDataType.STRING, currentRegion.name());
        }

        switch (currentRegion) {
            case BRICK:
                updateScores(container, brickScoreKey);
                break;
            case MINE:
                updateScores(container, mineScoreKey);
                break;
            case STONE_BRICK:
                updateScores(container, mazeScoreKey);
                break;
            case PUEBLO:
                updateScores(container, puebloScoreKey);
                break;
            default:
                decreaseAllScores(container);
        }
        if (currentRegion != Region.NONE) {
            CurseManager.dispatchCurse(
                    player,
                    currentRegion,
                    getScoreForRegion(player, currentRegion)
            );
        }
        DungeonScoreboard.updateScoreboard(player);
    }

    public static void givePlayerPersistentData(Player player) {
        PersistentDataContainer container = player.getPersistentDataContainer();

        for (NamespacedKey key: scores) {
            if (!container.has(key, PersistentDataType.INTEGER)) {
                container.set(key, PersistentDataType.INTEGER, 0);
            }
        }

    }
    private static void updateScores(PersistentDataContainer container, NamespacedKey key) {
        if (container.has(key, PersistentDataType.INTEGER)) {
            int score = container.get(key, PersistentDataType.INTEGER) + 1;
            container.set(key, PersistentDataType.INTEGER, score);
        }
        for (NamespacedKey otherKey: scores) {
            if (!otherKey.equals(key) && container.has(otherKey, PersistentDataType.INTEGER)) {
                int score = container.get(otherKey, PersistentDataType.INTEGER) - 1;
                container.set(otherKey, PersistentDataType.INTEGER, max(score, 0));
            }
        }
    }
    private static void decreaseAllScores(PersistentDataContainer container) {
        for (NamespacedKey otherKey: scores) {
            if (container.has(otherKey, PersistentDataType.INTEGER)) {
                int score = container.get(otherKey, PersistentDataType.INTEGER) - 1;
                container.set(otherKey, PersistentDataType.INTEGER, max(score, 0));
            }
        }
    }
    public static int getScoreForRegion(Player player, Region region) {
        PersistentDataContainer container = player.getPersistentDataContainer();

        NamespacedKey key = null;
        switch (region) {
            case BRICK:
                key = brickScoreKey;
                break;
            case MINE:
                key = mineScoreKey;
                break;
            case STONE_BRICK:
                key = mazeScoreKey;
                break;
            case PUEBLO:
                key = puebloScoreKey;
                break;
        }
        if (key != null) {
            if (container.has(key, PersistentDataType.INTEGER)) {
                return container.get(key, PersistentDataType.INTEGER);
            }
        }
        return 0;
    }
    public static Region getCurrentRegion(Player player) {
        PersistentDataContainer container = player.getPersistentDataContainer();
        if (container.has(currentRegionKey, PersistentDataType.STRING)) {
            return Region.valueOf(container.get(currentRegionKey, PersistentDataType.STRING));
        }
        return Region.NONE;
    }
}
