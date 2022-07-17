package com.gmail.seanduffy797.dungeon.Items;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.KeyLocation;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class TeleportPearl {

    public static final NamespacedKey destinationKey = new NamespacedKey(Dungeon.getPlugin(), "destination");

    public static ItemStack createItemStack(KeyLocation destination) {
        ItemStack teleportPearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = teleportPearl.getItemMeta();
        meta.displayName(Component.text("Pearl of Teleportation"));
        PersistentDataContainer tags = meta.getPersistentDataContainer();
        tags.set(DungeonManager.customItemKey, PersistentDataType.STRING, DungeonItem.TELEPORT_PEARL.name());
        tags.set(destinationKey, PersistentDataType.STRING, destination.name());
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Teleports you to Spawn").color(NamedTextColor.GOLD));
        teleportPearl.setItemMeta(meta);
        teleportPearl.lore(lore);
        return teleportPearl;
    }
}
