package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import de.tr7zw.nbtapi.NBTTileEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class FillChests extends BukkitRunnable {

    private Location loc;
    private String path;

    public FillChests(Location loc, String path) {
        this.loc = loc;
        this.path = path;
    }

    @Override
    public void run() {

        //getServer().getConsoleSender().sendMessage("Inserted " + path + " at " + ((int)loc.getX()) + ", " + ((int)loc.getY()) + ", " + ((int)loc.getZ()));

        Block block = DungeonManager.world.getBlockAt(loc);
        BlockData data = block.getBlockData();
        Material mat = data.getMaterial();
        if (mat == Material.CHEST || mat == Material.TRAPPED_CHEST || mat == Material.BARREL) {
            NBTTileEntity tent = new NBTTileEntity(block.getState());
            tent.setString("LootTable", path);
//            getServer().dispatchCommand(Bukkit.getConsoleSender(),
//                    "data modify block " + ((int)loc.getX()) + " " + ((int)loc.getY()) + " " + ((int)loc.getZ()) + " LootTable set value \"" + path + "\"");
        } else {
            getServer().getConsoleSender().sendMessage("Failed to fill chest (not container): could not fill " + path + " at " + ((int)loc.getX()) + ", " + ((int)loc.getY()) + ", " + ((int)loc.getZ()));
        }
    }
}
