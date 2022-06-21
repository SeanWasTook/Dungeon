package com.gmail.seanduffy797.dungeon.mobs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Parrot;


import static org.bukkit.Bukkit.getServer;

public class EntityManager {

    public static Entity parrot;

    public static void init() {
        //createMayorParrot();
    }

    public static ParrotMayor spawnMayor(Location location) {
        return new ParrotMayor(location);
    }

    private static void createMayorParrot() {
        World world = getServer().getWorld("Dungeon");
        Parrot mayorParrot = (Parrot) world.spawnEntity(new Location(world, 2.0, 20.0, 2.0), EntityType.PARROT);
        mayorParrot.setCustomName("Mayor");
        mayorParrot.setCustomNameVisible(true);
        mayorParrot.setAI(false);
        mayorParrot.setInvulnerable(true);
        mayorParrot.setCollidable(false);
        mayorParrot.setVariant(Parrot.Variant.RED);
        mayorParrot.setSitting(true);
        parrot = mayorParrot;
    }
}
