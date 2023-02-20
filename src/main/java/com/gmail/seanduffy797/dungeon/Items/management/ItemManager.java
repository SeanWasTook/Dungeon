package com.gmail.seanduffy797.dungeon.Items.management;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.Items.TeleportPearl;
import com.gmail.seanduffy797.dungeon.KeyLocation;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

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

    public static void addRarity(ItemStack item, Rarity rarity) {
        List<Component> lore = item.lore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        lore.add(Component.text("Rarity: ").color(NamedTextColor.GRAY).append(rarity.display()));
        item.lore(lore);
    }
}
