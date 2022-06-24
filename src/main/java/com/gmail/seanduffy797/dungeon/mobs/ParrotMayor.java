package com.gmail.seanduffy797.dungeon.mobs;

import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Parrot;

import static org.bukkit.Bukkit.getServer;

public class ParrotMayor {
    public ParrotMayor(Location location){
        World world = getServer().getWorld("Dungeon");
        Parrot mayorParrot = (Parrot) world.spawnEntity(location, EntityType.PARROT);
        mayorParrot.customName(Component.text("Mayor"));
        mayorParrot.setCustomNameVisible(true);
        mayorParrot.setAI(false);
        mayorParrot.setInvulnerable(true);
        mayorParrot.setCollidable(false);
        mayorParrot.setVariant(Parrot.Variant.RED);
        mayorParrot.setSitting(true);
    }

}
