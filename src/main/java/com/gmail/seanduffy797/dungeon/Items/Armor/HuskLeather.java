package com.gmail.seanduffy797.dungeon.Items.Armor;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;

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
        hatMeta.getPersistentDataContainer()
                .set(DungeonManager.customItemKey, PersistentDataType.STRING, DungeonItem.HUSK_LEATHER_HAT.name());
        hat.setItemMeta(hatMeta);

        tunic = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta tunicMeta = (LeatherArmorMeta) tunic.getItemMeta();
        tunicMeta.setColor(color);
        tunicMeta.displayName(Component.text("Husk Leather Tunic"));
        tunicMeta.getPersistentDataContainer()
                .set(DungeonManager.customItemKey, PersistentDataType.STRING, DungeonItem.HUSK_LEATHER_TUNIC.name());
        tunic.setItemMeta(tunicMeta);

        pants = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta pantsMeta = (LeatherArmorMeta) pants.getItemMeta();
        pantsMeta.setColor(color);
        pantsMeta.displayName(Component.text("Husk Leather Pants"));
        pantsMeta.getPersistentDataContainer()
                .set(DungeonManager.customItemKey, PersistentDataType.STRING, DungeonItem.HUSK_LEATHER_PANTS.name());
        pants.setItemMeta(pantsMeta);

        boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(color);
        bootsMeta.displayName(Component.text("Husk Leather Boots"));
        bootsMeta.getPersistentDataContainer()
                .set(DungeonManager.customItemKey, PersistentDataType.STRING, DungeonItem.HUSK_LEATHER_BOOTS.name());
        boots.setItemMeta(bootsMeta);
    }
}
