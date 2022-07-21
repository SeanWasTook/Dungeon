package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;

public class GatekeeperSkeleton extends CustomMob {

    public GatekeeperSkeleton() {}

    @Override
    public Entity spawn(Location location) {
        Skeleton skelly = (Skeleton) DungeonManager.world.spawnEntity(location, EntityType.SKELETON);
        skelly.setRotation(location.getYaw(), 0);
        skelly.setAI(false);
        skelly.setPersistent(true);
        skelly.setInvulnerable(true);
        skelly.customName(Component.text("GATEKEEPER"));
        EntityEquipment gear = skelly.getEquipment();
        gear.setItemInMainHand(null);
        gear.setHelmet(null);
        gear.setChestplate(null);
        gear.setLeggings(null);
        gear.setBoots(null);
        return skelly;
    }
}
