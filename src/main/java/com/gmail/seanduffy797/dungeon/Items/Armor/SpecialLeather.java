package com.gmail.seanduffy797.dungeon.Items.Armor;

import com.gmail.seanduffy797.dungeon.Items.management.ItemManager;
import com.gmail.seanduffy797.dungeon.Items.management.Rarity;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class SpecialLeather {

    public static ItemStack createSpecialLeatherHat() {
        ItemStack hat = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta hatMeta = (LeatherArmorMeta) hat.getItemMeta();
        hatMeta.setColor(Color.fromRGB(98,43,37));
        hat.setItemMeta(hatMeta);
        ItemManager.addRarity(hat, Rarity.RARE);
        return hat;
    }
}
