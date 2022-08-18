package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pillager;
import org.bukkit.inventory.EntityEquipment;

public class PersistentPillager extends CustomMob {

    public PersistentPillager() {
    }

    @Override
    public Entity spawn(Location location) {
        Pillager pilly = (Pillager) DungeonManager.world.spawnEntity(location, EntityType.PILLAGER);
        pilly.setPersistent(true);
        pilly.setRemoveWhenFarAway(false);
        EntityEquipment gear = pilly.getEquipment();
        gear.setItemInMainHand(DungeonItem.PILLAGER_CROSSBOW.getItemStack());
        gear.setItemInMainHandDropChance(0.1f);
        return pilly;
    }
}