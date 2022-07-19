package com.gmail.seanduffy797.dungeon.mobs;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Llama;

import java.util.Random;

public class DungeonLlama extends CustomMob {

    private final String[] names = {"Kuzco", "Yzma", "Pacha", "Kronk", "Chicha", "Chaca", "Tipo"};

    public DungeonLlama() {}

    public Entity spawn(Location location) {
        World world = DungeonManager.world;
        Llama llama = (Llama) world.spawnEntity(location, EntityType.LLAMA);
        int rnd = new Random().nextInt(names.length);
        llama.customName(Component.text(names[rnd]));
        return llama;
    }
}
