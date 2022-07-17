package com.gmail.seanduffy797.dungeon.tasks;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class SpawnItemFrame extends BukkitRunnable {

    private Location loc;
    private ItemStack contents;
    private BlockFace facing;

    public SpawnItemFrame(Location loc, ItemStack contents, BlockFace facing) {
        this.loc = loc;
        this.contents = contents;
        this.facing = facing;
    }

    @Override
    public void run() {
        World world = getServer().getWorld("Dungeon");
        ItemFrame itemFrame = (ItemFrame) world.spawnEntity(loc, EntityType.ITEM_FRAME);
        itemFrame.setItem(contents);
        itemFrame.setFacingDirection(facing);
    }
}
