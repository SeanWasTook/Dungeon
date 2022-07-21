package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;

import java.util.Random;

public class DungeonPig extends CustomMob {

    private final String[] names = {"Peppa", "Porky", "Babe", "Waddles", "Lawrence",
            "Arthur", "Louis", "Hopper", "Humphrey", "Charles", "Margarine", "Miss Piggy",
            "Bubba", "Piglet", "Plopper the Pig", "Mr Bacon"};

    public DungeonPig() {}

    public Entity spawn(Location location) {
        World world = DungeonManager.world;
        Pig pig = (Pig) world.spawnEntity(location, EntityType.PIG);
        int rnd = new Random().nextInt(names.length);
        pig.customName(Component.text(names[rnd]));
        return pig;
    }
}
