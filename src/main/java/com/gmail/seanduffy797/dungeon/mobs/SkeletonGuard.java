package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;

public class SkeletonGuard extends CustomMob {

    public SkeletonGuard() {}

    @Override
    public Entity spawn(Location location) {
        Skeleton skelly = (Skeleton) DungeonManager.world.spawnEntity(location, EntityType.SKELETON);
        EntityEquipment gear = skelly.getEquipment();
        gear.setItemInMainHand(DungeonItem.GUARD_BOW.getItemStack());
        gear.setItemInMainHandDropChance(0.1f);
        gear.setHelmet(null);
        gear.setChestplate(null);
        gear.setLeggings(null);
        gear.setBoots(null);
        return skelly;
    }
}
