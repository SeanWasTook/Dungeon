package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Items.TeleportPearl;
import com.gmail.seanduffy797.dungeon.KeyLocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class UseItemEvent implements Listener {

    @EventHandler
    public static void onItemUse(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
            if (event.getItem() != null) {
                ItemStack item = event.getItem();
                PersistentDataContainer tags = item.getItemMeta().getPersistentDataContainer();
                if (tags.has(DungeonManager.customItemKey)) {
                    String itemName = tags.get(DungeonManager.customItemKey, PersistentDataType.STRING);
                    DungeonItem dungeonItem = DungeonItem.valueOf(itemName);
                    // Pearl of Teleportation functionality
                    if (dungeonItem == DungeonItem.TELEPORT_PEARL) {
                        Player player = event.getPlayer();
                        String destination = tags.get(TeleportPearl.destinationKey, PersistentDataType.STRING);
                        KeyLocation keyLocation = KeyLocation.valueOf(destination);
                        Location loc = DungeonManager.keyLocations.get(keyLocation);
                        player.teleport(loc);
                        event.setCancelled(true);
                        item.subtract();
                    }
                }
            }
        }
    }
}
