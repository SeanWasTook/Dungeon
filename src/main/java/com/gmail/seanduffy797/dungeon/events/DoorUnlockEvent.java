package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Items.Keys;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.LockedDoor;
import com.gmail.seanduffy797.dungeon.housing.House;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class DoorUnlockEvent implements Listener {

    @EventHandler
    public static void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        if (action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.LEFT_CLICK_BLOCK)) {
            ItemStack itemStack = event.getItem();
            Block block = event.getClickedBlock();
            if (block != null && itemStack != null && (block.getType().equals(Material.IRON_DOOR) || block.getType().equals(Material.IRON_TRAPDOOR)) && itemStack.getType().equals(Material.TRIPWIRE_HOOK)){
                PersistentDataContainer tags = itemStack.getItemMeta().getPersistentDataContainer();
                if (tags.has(DungeonManager.customItemKey)){
                    String itemName = tags.get(DungeonManager.customItemKey, PersistentDataType.STRING);
                    DungeonItem dungeonItem = DungeonItem.valueOf(itemName);
                    if (dungeonItem == DungeonItem.HOUSE_KEY) {
                        String houseUuid = tags.get(Keys.houseUuidKey, PersistentDataType.STRING);
                        House currentHouse = DungeonManager.getHouseAt(block.getLocation());
                        if (currentHouse != null && currentHouse.houseUuid.toString().equals(houseUuid)) {
                            if(block.getRelative(0,-1,0).getType().equals(Material.IRON_DOOR)) {
                                block = block.getRelative(0, -1, 0);
                            }
                            Door door = (Door)block.getState().getBlockData();
                            door.setOpen(!door.isOpen());
                            block.setBlockData(door);
                            return;
                        }
                    }
                }

                TextComponent textComponent = (TextComponent)itemStack.getItemMeta().displayName();
                if (textComponent == null) {return;}
                String name = textComponent.content();
                if(block.getRelative(0,-1,0).getType().equals(Material.IRON_DOOR)) {
                    block = block.getRelative(0, -1, 0);
                }
                boolean success;
                if(FocusMeta.doors.containsKey(block.getLocation())) {
//                    player.sendMessage("Test 1: " + name);
                    success = FocusMeta.doors.get(block.getLocation()).open(name);
                } else {
                    success = false;
//                    player.sendMessage("Test 2");
//                    for (Location loc: FocusMeta.doors.keySet()) {
//                        player.sendMessage(loc.toString() + " " + FocusMeta.doors.get(loc));
//                    }
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
