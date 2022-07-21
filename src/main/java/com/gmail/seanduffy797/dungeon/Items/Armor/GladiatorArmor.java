package com.gmail.seanduffy797.dungeon.Items.Armor;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GladiatorArmor {

    public static ItemStack helmet;
    public static ItemStack chestplate;
    public static ItemStack greaves;
    public static ItemStack boots;

    public static void init() { createArmor();}

    private static void createArmor() {

        helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();
        helmetMeta.displayName(Component.text("Gladiator Helmet"));
        helmet.setItemMeta(helmetMeta);

        chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        chestplateMeta.displayName(Component.text("Gladiator Chestplate"));
        chestplate.setItemMeta(chestplateMeta);

        greaves = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta greavesMeta = greaves.getItemMeta();
        greavesMeta.displayName(Component.text("Gladiator Greaves"));
        greaves.setItemMeta(greavesMeta);

        boots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.displayName(Component.text("Gladiator Boots"));
        boots.setItemMeta(bootsMeta);
    }
}
