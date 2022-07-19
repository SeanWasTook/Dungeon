package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import com.gmail.seanduffy797.dungeon.tasks.SpawnItemFrame;
import com.gmail.seanduffy797.dungeon.tasks.SummonPainting;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class ItemFrameSpawner extends Focus {

    public ItemStack contents;
    public StructureRotation facing;
    public boolean isGlow;

    public ItemFrameSpawner(Location location, ItemStack contents, StructureRotation facing) {
        this.location = location;
        this.contents = contents;
        this.facing = facing;
        isGlow = false;
    }
    public ItemFrameSpawner(Location location, ItemStack contents, StructureRotation facing, boolean isGlow) {
        this.location = location;
        this.contents = contents;
        this.facing = facing;
        this.isGlow = isGlow;
    }

    public ItemFrameSpawner makeCopy(Focus other) {
        if(other instanceof ItemFrameSpawner) {
            ItemFrameSpawner itemFrameSpawner = (ItemFrameSpawner) other;
            if (contents != null) {
                return new ItemFrameSpawner(itemFrameSpawner.location.clone(),
                        itemFrameSpawner.contents.clone(), facing, itemFrameSpawner.isGlow);
            } else {
                return new ItemFrameSpawner(itemFrameSpawner.location.clone(),
                        null, facing, itemFrameSpawner.isGlow);
            }
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        StructureRotation finalRotation = BuilderUtils.addRotations(rotation, facing);
        if (mirror.equals(StructureMirror.LEFT_RIGHT)
                && (facing.equals(StructureRotation.ROTATION_90)
                || facing.equals(StructureRotation.ROTATION_270))) {
            switch(finalRotation) {
                case NONE:
                    finalRotation = StructureRotation.ROTATION_180;
                    break;
                case ROTATION_90:
                    finalRotation = StructureRotation.ROTATION_270;
                    break;
                case ROTATION_180:
                    finalRotation = StructureRotation.NONE;
                    break;
                case ROTATION_270:
                    finalRotation = StructureRotation.ROTATION_90;
                    break;
            }
        }
        // 0 = south = +z, 1 = west = -x, 2 = north = -z, 3 = east = +x
        BlockFace blockFace = BlockFace.DOWN;
        switch(finalRotation) {
            case NONE:
                blockFace = BlockFace.EAST;
                break;
            case ROTATION_90:
                blockFace = BlockFace.SOUTH;
                break;
            case ROTATION_180:
                blockFace = BlockFace.WEST;
                break;
            case ROTATION_270:
                blockFace = BlockFace.NORTH;
                break;
        }
        BukkitTask task = new SpawnItemFrame(location, contents, blockFace, isGlow)
                .runTaskLater(Dungeon.getPlugin(), 400L);
    }
}
