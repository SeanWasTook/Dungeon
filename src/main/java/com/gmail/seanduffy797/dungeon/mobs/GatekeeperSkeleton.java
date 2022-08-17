package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;

import static org.bukkit.Bukkit.getServer;

public class GatekeeperSkeleton extends CustomMob {

    public GatekeeperSkeleton() {}

    @Override
    public Entity spawn(Location location) {
        Skeleton skelly = (Skeleton) DungeonManager.world.spawnEntity(location, EntityType.SKELETON);
        skelly.setAI(false);
        skelly.setRotation(location.getYaw(), 0);
        skelly.setPersistent(true);
        skelly.setRemoveWhenFarAway(false);
        skelly.setInvulnerable(true);
        skelly.customName(Component.text("GATEKEEPER").color(NamedTextColor.BLUE));
        EntityEquipment gear = skelly.getEquipment();
        gear.setItemInMainHand(null);
        gear.setHelmet(null);
        gear.setChestplate(null);
        gear.setLeggings(null);
        gear.setBoots(null);
        return skelly;
    }
}
