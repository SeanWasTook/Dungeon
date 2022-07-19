package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.Items.TeleportPearl;
import org.bukkit.inventory.ItemStack;

public class ItemManager {

    public static ItemStack getItem(DungeonItem item, String[] args) {
        if (item.hasItemStack()) {
            return item.getItemStack();
        }

        // It's a switch statement, even though it makes intellij angry, in case I need more later
        switch (item) {
            case TELEPORT_PEARL:
                KeyLocation destination = KeyLocation.valueOf(args[0].toUpperCase());
                return TeleportPearl.createItemStack(destination);
            default:
                return null;
        }
    }
}
