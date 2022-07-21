package com.gmail.seanduffy797.dungeon.Items;

import com.gmail.seanduffy797.dungeon.Items.Armor.GladiatorArmor;
import com.gmail.seanduffy797.dungeon.Items.Armor.HuskLeather;
import com.gmail.seanduffy797.dungeon.Items.Armor.RudiariusArmor;
import com.gmail.seanduffy797.dungeon.Items.Armor.SkeletonLeather;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class ItemManager {

    public static ItemStack wand;

    public static void init() {
        HuskLeather.init();
        SkeletonLeather.init();
        createWand();
        VindicatorsAxe.init();
        GladiatorArmor.init();
        RudiariusArmor.init();
        GladiatorWeapons.init();
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("§6The Stick of Truth"));
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("§6This Powerful Relic"));
        lore.add(Component.text("§6Is an Ancient Minecraftian Artifact"));
        meta.addEnchant(Enchantment.KNOCKBACK, 3, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        item.lore(lore);
        wand = item;
    }
}
