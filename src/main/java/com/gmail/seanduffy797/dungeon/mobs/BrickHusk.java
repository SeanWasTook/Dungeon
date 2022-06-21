package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.Items.Armor.HuskLeather;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Husk;
import org.bukkit.inventory.EntityEquipment;

import static org.bukkit.Bukkit.getServer;

public class BrickHusk {

    public BrickHusk(Location location) {
        World world = getServer().getWorld("Dungeon");
        Husk brickHusk = (Husk) world.spawnEntity(location, EntityType.HUSK);
        brickHusk.setAdult();
        EntityEquipment gear = brickHusk.getEquipment();
        if(Math.random() < 0.5) {
            gear.setHelmet(HuskLeather.hat);
            gear.setHelmetDropChance(0.05f);
        }
        if(Math.random() < 0.5) {
            gear.setChestplate(HuskLeather.tunic);
            gear.setChestplateDropChance(0.05f);
        }
        if(Math.random() < 0.5) {
            gear.setLeggings(HuskLeather.pants);
            gear.setLeggingsDropChance(0.05f);
        }
        if(Math.random() < 0.5) {
            gear.setBoots(HuskLeather.boots);
            gear.setBootsDropChance(0.05f);
        }
    }
}
