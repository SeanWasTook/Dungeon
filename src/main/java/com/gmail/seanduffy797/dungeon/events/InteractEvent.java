package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Trigger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Powerable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class InteractEvent implements Listener {

    @EventHandler
    public static void interactEvent(org.bukkit.event.player.PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();
        // Handles the case of buttons
        if(block != null && block.getType() == Material.STONE_BUTTON && action.equals(Action.RIGHT_CLICK_BLOCK)) {
            Location location = block.getLocation();
            Trigger trigger = FocusMeta.triggers.get(location);
            if (trigger != null) {
                trigger.trigger(player);
            }
        }
        // Handles the case of levers
        if (block != null && block.getType() == Material.LEVER && action.equals(Action.RIGHT_CLICK_BLOCK)) {
            Location location = block.getLocation();
            Trigger trigger = FocusMeta.triggers.get(location);
            boolean isPowered = false;
            if (((Powerable) block.getState().getBlockData()).isPowered()) {
                isPowered = true;
            }
            if (trigger != null) {
                trigger.trigger(player, !isPowered); // isPowered is inverted because this event is called before the lever actually changes
            }
        }
    }
}
