package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.Items.Armor.SkeletonLeather;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;

import static org.bukkit.Bukkit.getServer;

public class BrickSkeleton {

    public BrickSkeleton(Location location) {
        World world = getServer().getWorld("Dungeon");
        Skeleton brickSkeleton = (Skeleton) world.spawnEntity(location, EntityType.SKELETON);
        EntityEquipment gear = brickSkeleton.getEquipment();
        if(Math.random() < 0.5) {
            gear.setHelmet(SkeletonLeather.hat);
            gear.setHelmetDropChance(0.05f);
        }
        if(Math.random() < 0.5) {
            gear.setChestplate(SkeletonLeather.tunic);
            gear.setChestplateDropChance(0.05f);
        }
        if(Math.random() < 0.5) {
            gear.setLeggings(SkeletonLeather.pants);
            gear.setLeggingsDropChance(0.05f);
        }
        if(Math.random() < 0.5) {
            gear.setBoots(SkeletonLeather.boots);
            gear.setBootsDropChance(0.05f);
        }
    }
}
