package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class SpawnItemFrame extends BukkitRunnable {

    private Location loc;
    private ItemStack contents;
    private BlockFace facing;
    private boolean isGlow;

    public SpawnItemFrame(Location loc, ItemStack contents, BlockFace facing, boolean isGlow) {
        this.loc = loc;
        this.contents = contents;
        this.facing = facing;
        this.isGlow = isGlow;
    }

    @Override
    public void run() {
        ItemFrame itemFrame;
        if (isGlow) {
            itemFrame = (GlowItemFrame) DungeonManager.world
                    .spawnEntity(loc, EntityType.GLOW_ITEM_FRAME);
        } else {
            itemFrame = (ItemFrame) DungeonManager.world
                    .spawnEntity(loc, EntityType.ITEM_FRAME);
        }
        itemFrame.setItem(contents);
        itemFrame.setFacingDirection(facing);
    }
}
