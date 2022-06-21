package com.gmail.seanduffy797.dungeon.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCookEvent;
import org.bukkit.inventory.ItemStack;

public class StructureBlockPlacedEvent implements Listener {

    @EventHandler
    public static void onBlockCookEvent(BlockCookEvent b) {
        Block block = b.getBlock();
        if (block.getType() == Material.FURNACE) {
            Location loc = block.getLocation();
            Location structureLoc;
            World world = block.getWorld();
            Furnace f = ((Furnace) block);
            BlockFace direction = f.getFacing();
            if (direction == BlockFace.NORTH) {
                structureLoc = loc.add(0, 0, -1.0);
            } else if (direction == BlockFace.EAST) {
                structureLoc = loc.add(1.0, 0, 0);
            } else if (direction == BlockFace.SOUTH) {
                structureLoc = loc.add(0, 0, 1.0);
            } else {
                structureLoc = loc.add(-1.0, 0, 0);
            }

            block.breakNaturally(new ItemStack(Material.WOODEN_SHOVEL));
        }
    }
}
