package com.gmail.seanduffy797.dungeon.Items.Armor;

import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class HuskLeather {

    public static Color color;

    public static ItemStack hat;
    public static ItemStack tunic;
    public static ItemStack pants;
    public static ItemStack boots;

    public static void init() { createArmor();}

    private static void createArmor() {
        color = Color.fromRGB(217, 129, 60);

        hat = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta hatMeta = (LeatherArmorMeta) hat.getItemMeta();
        hatMeta.setColor(color);
        hatMeta.displayName(Component.text("Husk Leather Hat"));
        hat.setItemMeta(hatMeta);

        tunic = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta tunicMeta = (LeatherArmorMeta) tunic.getItemMeta();
        tunicMeta.setColor(color);
        tunicMeta.displayName(Component.text("Husk Leather Tunic"));
        tunic.setItemMeta(tunicMeta);

        pants = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta pantsMeta = (LeatherArmorMeta) pants.getItemMeta();
        pantsMeta.setColor(color);
        pantsMeta.displayName(Component.text("Husk Leather Pants"));
        pants.setItemMeta(pantsMeta);

        boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(color);
        bootsMeta.displayName(Component.text("Husk Leather Boots"));
        boots.setItemMeta(bootsMeta);
    }
    public static ItemStack createHat() {
        hat = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta hatMeta = (LeatherArmorMeta) hat.getItemMeta();
        hatMeta.setColor(color);
        hatMeta.displayName(Component.text("Husk Leather Hat"));
        hat.setItemMeta(hatMeta);
        return hat;
    }
    public static ItemStack createTunic() {
        tunic = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta tunicMeta = (LeatherArmorMeta) tunic.getItemMeta();
        tunicMeta.setColor(color);
        tunicMeta.displayName(Component.text("Husk Leather Tunic"));
        tunic.setItemMeta(tunicMeta);
        return tunic;
    }
    public static ItemStack createPants() {
        pants = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta pantsMeta = (LeatherArmorMeta) pants.getItemMeta();
        pantsMeta.setColor(color);
        pantsMeta.displayName(Component.text("Husk Leather Pants"));
        pants.setItemMeta(pantsMeta);
        return pants;
    }
    public static ItemStack createBoots() {
        boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(color);
        bootsMeta.displayName(Component.text("Husk Leather Boots"));
        boots.setItemMeta(bootsMeta);
        return boots;
    }
}
