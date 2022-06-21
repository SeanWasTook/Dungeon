package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class DoorUnlockEvent implements Listener {

    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.LEFT_CLICK_BLOCK)) {
            ItemStack itemStack = event.getItem();
            Block block = event.getClickedBlock();
            if (block != null && itemStack != null && (block.getType().equals(Material.IRON_DOOR) || block.getType().equals(Material.IRON_TRAPDOOR)) && itemStack.getType().equals(Material.TRIPWIRE_HOOK)){
                TextComponent textComponent = (TextComponent)itemStack.getItemMeta().displayName();
                if (textComponent == null) {return;}
                String name = textComponent.content();
                if(block.getRelative(0,-1,0).getType().equals(Material.IRON_DOOR)) {
                    block = block.getRelative(0, -1, 0);
                }
                boolean success;
                if(FocusMeta.doors.containsKey(block.getLocation())) {
                    success = FocusMeta.doors.get(block.getLocation()).open(name);
                } else {
                    success = false;
                }
                if(success) {
                    itemStack.subtract();
                } else {
                    player.sendMessage("The key doesn't fit");
                }
            }
        }
    }
}
