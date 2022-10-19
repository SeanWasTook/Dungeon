package com.gmail.seanduffy797.dungeon.display;

import com.gmail.seanduffy797.dungeon.Pieces.Region;
import com.gmail.seanduffy797.dungeon.players.PlayerManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class DungeonScoreboard {

    public static void addToPlayer(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective regionInfo = board.registerNewObjective(
                "Region",
                "dummy",
                Component.text("Domain").color(NamedTextColor.DARK_AQUA));
        regionInfo.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team currentRegion = board.registerNewTeam("currentRegion");
        currentRegion.addEntry(ChatColor.RED + "" + ChatColor.WHITE);
        currentRegion.prefix(Component.text("Nowhere").color(NamedTextColor.RED));
        regionInfo.getScore(ChatColor.RED + "" + ChatColor.WHITE).setScore(5);

        Team brickScore = board.registerNewTeam("brickScore");
        brickScore.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
        brickScore.prefix(Component.text("None").color(NamedTextColor.GRAY));
        regionInfo.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(4);

        Team mineScore = board.registerNewTeam("mineScore");
        mineScore.addEntry(ChatColor.DARK_GRAY + "" + ChatColor.WHITE);
        mineScore.prefix(Component.text("None").color(NamedTextColor.GRAY));
        regionInfo.getScore(ChatColor.DARK_GRAY + "" + ChatColor.WHITE).setScore(3);

        Team mazeScore = board.registerNewTeam("mazeScore");
        mazeScore.addEntry(ChatColor.GRAY + "" + ChatColor.WHITE);
        mazeScore.prefix(Component.text("None").color(NamedTextColor.GRAY));
        regionInfo.getScore(ChatColor.GRAY + "" + ChatColor.WHITE).setScore(2);

        Team puebloScore = board.registerNewTeam("puebloScore");
        puebloScore.addEntry(ChatColor.WHITE + "" + ChatColor.WHITE);
        puebloScore.prefix(Component.text("None").color(NamedTextColor.GRAY));
        regionInfo.getScore(ChatColor.WHITE + "" + ChatColor.WHITE).setScore(1);

        player.setScoreboard(board);
    }

    public static void updateScoreboard(Player player) {
        Region region = PlayerManager.getCurrentRegion(player);

        int brickValue = PlayerManager.getScoreForRegion(player, Region.BRICK);
        int mineValue = PlayerManager.getScoreForRegion(player, Region.MINE);
        int mazeValue = PlayerManager.getScoreForRegion(player, Region.STONE_BRICK);
        int puebloValue = PlayerManager.getScoreForRegion(player, Region.PUEBLO);

        Scoreboard board = player.getScoreboard();

        board.getTeam("currentRegion").prefix(Component.text(region.name()).color(NamedTextColor.RED));

        board.getTeam("brickScore").prefix(Component.text("Brick: ").color(NamedTextColor.GRAY)
                .append(Component.text(brickValue).color(NamedTextColor.DARK_RED)));
        board.getTeam("mineScore").prefix(Component.text("Mine: ").color(NamedTextColor.GRAY)
                .append(Component.text(mineValue).color(NamedTextColor.DARK_RED)));
        board.getTeam("mazeScore").prefix(Component.text("Maze: ").color(NamedTextColor.GRAY)
                .append(Component.text(mazeValue).color(NamedTextColor.DARK_RED)));
        board.getTeam("puebloScore").prefix(Component.text("Pueblo: ").color(NamedTextColor.GRAY)
                .append(Component.text(puebloValue).color(NamedTextColor.DARK_RED)));
    }
}
