package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;

public class GladiatorSkeleton extends CustomMob {

    public GladiatorSkeleton() {}

    public Entity spawn(Location loc) {
        Skeleton skelly = (Skeleton) DungeonManager.world.spawnEntity(loc, EntityType.SKELETON);
        skelly.setLeftHanded(true);
        skelly.customName(Component.text("Gladiator"));
        EntityEquipment gear = skelly.getEquipment();
        gear.setItemInMainHand(DungeonItem.GLADIUS.getItemStack());
        gear.setItemInMainHandDropChance(0.1f);
        gear.setHelmet(DungeonItem.GLADIATOR_HELMET.getItemStack());
        gear.setHelmetDropChance(0.1f);
        gear.setChestplate(DungeonItem.GLADIATOR_CHESTPLATE.getItemStack());
        gear.setChestplateDropChance(0.1f);
        gear.setLeggings(DungeonItem.GLADIATOR_GREAVES.getItemStack());
        gear.setLeggingsDropChance(0.1f);
        gear.setBoots(DungeonItem.GLADIATOR_BOOTS.getItemStack());
        gear.setBootsDropChance(0.1f);
        return skelly;
    }
}
