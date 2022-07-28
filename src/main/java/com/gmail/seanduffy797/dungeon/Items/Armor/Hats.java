package com.gmail.seanduffy797.dungeon.Items.Armor;

import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Hats {
    public static ItemStack waterHat;
    public static ItemStack fireHat;
    public static ItemStack projectileHat;
    public static ItemStack blastHat;

    public static ItemStack createWaterHat() {
        waterHat = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta hatMeta = (LeatherArmorMeta) waterHat.getItemMeta();
        hatMeta.setColor(Color.fromRGB(0, 0, 255));
        hatMeta.displayName(Component.text("Water Hat"));
        hatMeta.addEnchant(Enchantment.OXYGEN, 1, true);
        hatMeta.addEnchant(Enchantment.WATER_WORKER, 1, true);
        waterHat.setItemMeta(hatMeta);
        return waterHat;
    }
    public static ItemStack createFireHat() {
        fireHat = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta hatMeta = (LeatherArmorMeta) fireHat.getItemMeta();
        hatMeta.setColor(Color.fromRGB(255, 0, 0));
        hatMeta.displayName(Component.text("Fire Hat"));
        hatMeta.addEnchant(Enchantment.PROTECTION_FIRE, 3, true);
        fireHat.setItemMeta(hatMeta);
        return fireHat;
    }
    public static ItemStack createProjectileHat() {
        projectileHat = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta hatMeta = (LeatherArmorMeta) projectileHat.getItemMeta();
        hatMeta.setColor(Color.fromRGB(100, 100, 90));
        hatMeta.displayName(Component.text("Anti-Projectile Hat"));
        hatMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 3, true);
        projectileHat.setItemMeta(hatMeta);
        return projectileHat;
    }
    public static ItemStack createBlastHat() {
        blastHat = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta hatMeta = (LeatherArmorMeta) blastHat.getItemMeta();
        hatMeta.setColor(Color.fromRGB(0, 255, 100));
        hatMeta.displayName(Component.text("Blasting Hat"));
        hatMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
        blastHat.setItemMeta(hatMeta);
        return blastHat;
    }
}
