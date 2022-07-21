package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.SpawnerEnum;
import de.tr7zw.nbtapi.*;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Skeleton;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Locale;

import static org.bukkit.Bukkit.getServer;

public class SetSpawner extends BukkitRunnable {

    private Location loc;
    private SpawnerEnum details;

    public SetSpawner(Location loc, SpawnerEnum details) {
        this.loc = loc;
        this.details = details;
    }

    @Override
    public void run() {
        Chunk chunk = loc.getChunk();
        boolean wasLoaded = true;
        if(!chunk.isLoaded()) {
            wasLoaded = false;
            chunk.load();
        }
        Block b = loc.getBlock();
        b.setType(Material.SPAWNER);
        NBTTileEntity tent = new NBTTileEntity(b.getState());
        NBTContainer container = details.getNBTContainer();
        tent.mergeCompound(container);

        if(!wasLoaded) {
            chunk.unload();
        }
    }
}
