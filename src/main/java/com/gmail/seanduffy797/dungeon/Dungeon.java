package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.Items.ItemManager;
import com.gmail.seanduffy797.dungeon.builders.PieceParser;
import com.gmail.seanduffy797.dungeon.commands.*;
import com.gmail.seanduffy797.dungeon.events.*;
import com.gmail.seanduffy797.dungeon.mobs.EntityManager;
import com.gmail.seanduffy797.dungeon.tasks.TickDungeon;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;

public class Dungeon extends JavaPlugin {

    private static Dungeon pluginInstance;
    private static final String worldName = "Dungeon";

    @Override
    public void onEnable() {
        pluginInstance = this;
        getServer().getPluginManager().registerEvents(new DungeonEventTest(), this);
        getServer().getPluginManager().registerEvents(new UseItemEvent(), this);
        getServer().getPluginManager().registerEvents(new ContainerInteractEvent(), this);
        getServer().getPluginManager().registerEvents(new HopperEvent(), this);
        getServer().getPluginManager().registerEvents(new DoorUnlockEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockPlacedEvent(), this);
        getServer().getPluginManager().registerEvents(new AgeBabyZombiesEvent(), this);
        getServer().getPluginManager().registerEvents(new ButtonPressEvent(), this);
        getServer().getPluginManager().registerEvents(new DungeonBlockBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new HitHangingEntityEvent(), this);
        getServer().getPluginManager().registerEvents(new MinecartDropEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemEntitySpawnEvent(), this);
        getServer().getPluginManager().registerEvents(new PaintingPlacedEvent(), this);
        DungeonManager.init(this, getServer().getWorld(worldName));
        ItemManager.init();
        EntityManager.init();
        getCommand("heal").setExecutor(new DungeonCommandsTest());
        getCommand("spawnmobs").setExecutor(new SpawnMobs());
        getCommand("dgive").setExecutor(new GiveCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("gear").setExecutor(new GearCommand());
        getCommand("place").setExecutor(new PlaceCommand());
        getServer().getConsoleSender().sendMessage("[Dungeon]: Plugin is enabled");

        BukkitTask dungeonTick = new TickDungeon(DungeonManager.world)
                .runTaskTimer(this, 50L, 10L);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[Dungeon]: Plugin is disabled");
    }

    public static Dungeon getPlugin() {
        return pluginInstance;
    }

}
