package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Items.VindicatorsAxe;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vindicator;
import org.bukkit.inventory.EntityEquipment;

import static org.bukkit.Bukkit.getServer;

public class AxeVindicator extends CustomMob {

    public AxeVindicator() {}

    public Entity spawn(Location location) {
        World world = DungeonManager.world;
        Vindicator vindicator = (Vindicator) world.spawnEntity(location, EntityType.VINDICATOR);
        vindicator.setRotation(location.getYaw(), 0);
        vindicator.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1);
        EntityEquipment gear = vindicator.getEquipment();
        gear.setItemInMainHand(VindicatorsAxe.vindicatorsAxe);
        gear.setItemInMainHandDropChance(0.5f);
        return vindicator;
    }
}
