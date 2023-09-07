package com.gmail.seanduffy797.dungeon.Items;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.Items.management.ItemManager;
import com.gmail.seanduffy797.dungeon.Items.management.Rarity;
import com.gmail.seanduffy797.dungeon.housing.House;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class Keys {

    public static final NamespacedKey houseUuidKey = new NamespacedKey(Dungeon.getPlugin(), "houseUuid");

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

    public static ItemStack createHouseKey() {
        ItemStack houseKey = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = houseKey.getItemMeta();
        meta.displayName(Component.text("House Key"));
        houseKey.setItemMeta(meta);
        ItemManager.addRarity(houseKey, Rarity.RARE);
        return houseKey;
    }

    public static ItemStack linkKeyToOwner(ItemStack houseKey, House house) {
        ItemMeta meta = houseKey.getItemMeta();
        PersistentDataContainer tags = meta.getPersistentDataContainer();
        tags.set(houseUuidKey, PersistentDataType.STRING, house.houseUuid.toString());
        List<Component> lore = meta.lore();
        lore.add(Component.text("Key to " + house.ownerName + "'s house").color(NamedTextColor.GRAY));
        houseKey.setItemMeta(meta);
        houseKey.lore(lore);
        return houseKey;
    }
}
