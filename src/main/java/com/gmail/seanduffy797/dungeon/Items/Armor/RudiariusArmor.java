package com.gmail.seanduffy797.dungeon.Items.Armor;

import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class RudiariusArmor {

    public static Color color;

    public static ItemStack helmet;
    public static ItemStack chestplate;
    public static ItemStack greaves;
    public static ItemStack boots;

    public static void init() { createArmor();}

    private static void createArmor() {
        color = Color.fromRGB(189, 143, 136);

        helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta hatMeta = (LeatherArmorMeta) helmet.getItemMeta();
        hatMeta.setColor(color);
        hatMeta.displayName(Component.text("Rudiarius Helmet"));
        helmet.setItemMeta(hatMeta);

        chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta tunicMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        tunicMeta.setColor(color);
        tunicMeta.displayName(Component.text("Rudiarius Chestplate"));
        chestplate.setItemMeta(tunicMeta);

        greaves = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta pantsMeta = (LeatherArmorMeta) greaves.getItemMeta();
        pantsMeta.setColor(color);
        pantsMeta.displayName(Component.text("Rudiarius Greaves"));
        greaves.setItemMeta(pantsMeta);

        boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(color);
        bootsMeta.displayName(Component.text("Rudiarius Boots"));
        boots.setItemMeta(bootsMeta);
    }
}
