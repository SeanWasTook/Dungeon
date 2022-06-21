package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.Items.VindicatorsAxe;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vindicator;
import org.bukkit.inventory.EntityEquipment;

import static org.bukkit.Bukkit.getServer;

public class AxeVindicator {

    public AxeVindicator(Location location) {
        World world = getServer().getWorld("Dungeon");
        Vindicator vindicator = (Vindicator) world.spawnEntity(location, EntityType.VINDICATOR);
        vindicator.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1);
        EntityEquipment gear = vindicator.getEquipment();
        gear.setItemInMainHand(VindicatorsAxe.vindicatorsAxe);
        gear.setItemInMainHandDropChance(0.5f);
    }
}
