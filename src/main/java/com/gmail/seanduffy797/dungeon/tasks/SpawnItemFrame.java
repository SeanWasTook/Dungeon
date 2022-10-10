package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.EntityList;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SpawnItemFrame extends BukkitRunnable {

    private Location loc;
    private ItemStack contents;
    private BlockFace facing;
    private boolean isGlow;
    private boolean isFixed;

    public SpawnItemFrame(Location loc, ItemStack contents, BlockFace facing, boolean isGlow, boolean isFixed) {
        this.loc = loc;
        this.contents = contents;
        this.facing = facing;
        this.isGlow = isGlow;
        this.isFixed = isFixed;
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
        if (contents != null) {
            itemFrame.setItem(contents);
        }
        if (isFixed) {
            itemFrame.setFixed(true);
        }
        itemFrame.setFacingDirection(facing);
        DungeonManager.addEntityToRegion(Region.NONE, itemFrame);
    }
}
