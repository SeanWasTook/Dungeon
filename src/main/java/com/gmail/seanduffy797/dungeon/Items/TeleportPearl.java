package com.gmail.seanduffy797.dungeon.Items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TeleportPearl {

    public static ItemStack teleportPearl;

    public static void init() { createTeleportPearl();}

    private static void createTeleportPearl() {
        teleportPearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = teleportPearl.getItemMeta();
        meta.displayName(Component.text("Pearl of Teleportation"));
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("§6Teleports you to Spawn"));
        teleportPearl.setItemMeta(meta);
        teleportPearl.lore(lore);
    }
}
