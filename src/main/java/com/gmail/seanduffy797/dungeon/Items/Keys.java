package com.gmail.seanduffy797.dungeon.Items;

import com.gmail.seanduffy797.dungeon.Items.management.ItemManager;
import com.gmail.seanduffy797.dungeon.Items.management.Rarity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class Keys {

    public static ItemStack skeletonKey;
    public static ItemStack basementKey;
    public static ItemStack oldKey;

    public static void init() {
        createSkeletonKey();
        createBasementKey();
        createOldKey();
    }

    public static ItemStack createSkeletonKey() {
        skeletonKey = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = skeletonKey.getItemMeta();
        meta.displayName(Component.text("Skeleton Key"));
        skeletonKey.setItemMeta(meta);
        ItemManager.addRarity(skeletonKey, Rarity.UNCOMMON);
        return skeletonKey;
    }
    public static ItemStack createBasementKey() {
        basementKey = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = basementKey.getItemMeta();
        meta.displayName(Component.text("Basement Key"));
        basementKey.setItemMeta(meta);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Key to the basement of the home Grisha left behind").color(NamedTextColor.GOLD));
        basementKey.lore(lore);
        ItemManager.addRarity(basementKey, Rarity.RARE);
        return basementKey;
    }
    public static ItemStack createOldKey() {
        oldKey = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = oldKey.getItemMeta();
        meta.displayName(Component.text("Old Key"));
        oldKey.setItemMeta(meta);
        ItemManager.addRarity(oldKey, Rarity.RARE);
        return oldKey;
    }
}
