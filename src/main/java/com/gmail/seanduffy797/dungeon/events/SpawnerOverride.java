package com.gmail.seanduffy797.dungeon.events;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import de.tr7zw.nbtapi.NBTEntity;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import static org.bukkit.Bukkit.getServer;

public class SpawnerOverride implements Listener {

    @EventHandler
    public static void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER) {
            LivingEntity creature = event.getEntity();
            if (creature.customName() == null) {
                return;
            }
            String name = "empty";
            try {
                name = ((TextComponent) creature.customName()).content();
                DungeonMob mob = DungeonMob.valueOf(name.toUpperCase());
                Location loc = event.getLocation();
                mob.spawn(loc);
                event.setCancelled(true);
            } catch (IllegalArgumentException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
