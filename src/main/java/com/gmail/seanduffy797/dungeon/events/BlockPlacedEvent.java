package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.regions.Region;
import com.gmail.seanduffy797.dungeon.tasks.BurnOut;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;

public class BlockPlacedEvent implements Listener {

    @EventHandler
    public static void onBlockPlaced(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(player.getGameMode().equals(GameMode.ADVENTURE)) {
            Block block = event.getBlock();
            ItemStack item = event.getItemInHand();
            PersistentDataContainer tags = item.getItemMeta().getPersistentDataContainer();
            // Handles the burning out of torches placed by players
            if(block.getType() == Material.WALL_TORCH || block.getType() == Material.SOUL_WALL_TORCH
                    || block.getType() == Material.TORCH || block.getType() == Material.SOUL_TORCH) {
                Plugin plugin = getPluginManager().getPlugin("Dungeon");
                if(plugin == null) {return;}
                BukkitTask task = new BurnOut(block).runTaskLater(plugin, 12000L);
                DungeonManager.addTaskToRegion(Region.NONE, task);
            }
            if (tags.has(DungeonManager.customItemKey)) {
                String itemName = tags.get(DungeonManager.customItemKey, PersistentDataType.STRING);
                DungeonItem dungeonItem = DungeonItem.valueOf(itemName);
                // TODO: generalized handling of placing custom blocks (No current uses)
            }
        }
    }
}
