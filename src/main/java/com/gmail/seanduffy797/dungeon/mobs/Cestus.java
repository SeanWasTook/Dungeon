package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;

public class Cestus extends CustomMob {

    public Cestus() {}

    public Entity spawn(Location loc) {
        Skeleton skelly = (Skeleton) DungeonManager.world.spawnEntity(loc, EntityType.SKELETON);
        skelly.customName(Component.text("Cestus"));
        EntityEquipment gear = skelly.getEquipment();
        gear.setItemInMainHand(null);
        gear.setHelmet(null);
        gear.setChestplate(null);
        gear.setLeggings(null);
        gear.setBoots(null);
        return skelly;
    }
}
