package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.inventory.EntityEquipment;

public class PersistentZombieVillager extends CustomMob {

    public PersistentZombieVillager() {}

    @Override
    public Entity spawn(Location location) {
        ZombieVillager zombie = (ZombieVillager) DungeonManager.world.spawnEntity(location, EntityType.ZOMBIE_VILLAGER);
        zombie.setPersistent(true);
        zombie.setRemoveWhenFarAway(false);
        return zombie;
    }
}
