package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Trigger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ButtonPressEvent implements Listener {

    @EventHandler
    public static void buttonPressEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        Block block = event.getClickedBlock();
        if(block != null && block.getType() == Material.STONE_BUTTON && action.equals(Action.RIGHT_CLICK_BLOCK)) {
            Location location = block.getLocation();
            Trigger trigger = FocusMeta.triggers.get(location);
            player.sendMessage("Clicked Location: " + location);
            player.sendMessage("Trigger Location: " + FocusMeta.triggers.keySet());
            if (trigger != null) {
                trigger.trigger(player);
            }
        }
    }
}
