package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class TridentDrowned extends CustomMob {

    public TridentDrowned() {}

    public Entity spawn(Location location) {
        Drowned drowned = (Drowned) DungeonManager.world.spawnEntity(location, EntityType.DROWNED);
        EntityEquipment gear = drowned.getEquipment();
        gear.setItemInMainHand(new ItemStack(Material.TRIDENT));
        gear.setItemInMainHandDropChance(0.1f);
        gear.setHelmet(null);
        gear.setChestplate(null);
        gear.setLeggings(null);
        gear.setBoots(null);
        return drowned;
    }
}