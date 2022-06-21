package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.Items.ItemManager;
import com.gmail.seanduffy797.dungeon.commands.*;
import com.gmail.seanduffy797.dungeon.events.*;
import com.gmail.seanduffy797.dungeon.mobs.EntityManager;
import com.gmail.seanduffy797.dungeon.tasks.TickDungeon;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;

public class Dungeon extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DungeonEventTest(), this);
        getServer().getPluginManager().registerEvents(new HopperEvent(), this);
        getServer().getPluginManager().registerEvents(new DoorUnlockEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockPlacedEvent(), this);
        getServer().getPluginManager().registerEvents(new AgeBabyZombiesEvent(), this);
        getServer().getPluginManager().registerEvents(new ButtonPressEvent(), this);
        getServer().getPluginManager().registerEvents(new DungeonBlockBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new MinecartDropEvent(), this);
        getCommand("heal").setExecutor(new DungeonCommandsTest());
        getCommand("spawnmobs").setExecutor(new SpawnMobs());
        ItemManager.init();
        EntityManager.init();
        getCommand("dgive").setExecutor(new GiveCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("gear").setExecutor(new GearCommand());
        getServer().getConsoleSender().sendMessage("[Dungeon]: Plugin is enabled");

        BukkitTask dungeonTick = new TickDungeon(getServer().getWorld("Dungeon")).runTaskTimer(getPluginManager().getPlugin("Dungeon"), 50L, 10L);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[Dungeon]: Plugin is disabled");
    }

}
