package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.EntityEquipment;

public class Editor extends CustomMob {

    public Editor() {}

    public Entity spawn(Location loc) {
        Skeleton skelly = (Skeleton) DungeonManager.world.spawnEntity(loc, EntityType.SKELETON);
        skelly.customName(Component.text("Editor"));
        EntityEquipment gear = skelly.getEquipment();
        gear.setItemInMainHand(DungeonItem.PALM_BRANCH.getItemStack());
        gear.setItemInMainHandDropChance(1f);
        gear.setHelmet(null);
        gear.setChestplate(null);
        gear.setLeggings(null);
        gear.setBoots(null);
        return skelly;
    }
}
