package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import com.gmail.seanduffy797.dungeon.tasks.SummonPainting;
import org.bukkit.Art;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public class PaintingSpawner extends Focus {

    public String motif;
    public StructureRotation facing;
    public boolean isEven;

    public PaintingSpawner(Location location, String motif, StructureRotation facing, boolean isEven) {
        this.location = location;
        this.motif = motif;
        this.facing = facing;
        this.isEven = isEven;
    }

    public PaintingSpawner makeCopy(Focus other) {
        if(other instanceof PaintingSpawner) {
            PaintingSpawner paintingSpawner = (PaintingSpawner) other;
            return new PaintingSpawner(paintingSpawner.location.clone(), paintingSpawner.motif, paintingSpawner.facing, paintingSpawner.isEven);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        Plugin plugin = Dungeon.getPlugin();
        World world = DungeonManager.world;
        StructureRotation finalRotation = BuilderUtils.addRotations(rotation, facing);
        // More mirroring nightmares
        int x = (int) this.location.getX();
        int y = (int) this.location.getY();
        int z = (int) this.location.getZ();
        if (mirror.equals(StructureMirror.LEFT_RIGHT) &&
                (facing.equals(StructureRotation.ROTATION_90) || facing.equals(StructureRotation.ROTATION_270))) {
            switch(finalRotation) {
                case NONE:
                    finalRotation = StructureRotation.ROTATION_180;
                    if (isEven) {
                        location = new Location(world, x, y, z-1);
                    }
                    break;
                case ROTATION_90:
                    finalRotation = StructureRotation.ROTATION_270;
                    if (isEven) {
                        location = new Location(world, x+1, y, z);
                    }
                    break;
                case ROTATION_180:
                    finalRotation = StructureRotation.NONE;
                    if (isEven) {
                        location = new Location(world, x, y, z+1);
                    }
                    break;
                case ROTATION_270:
                    finalRotation = StructureRotation.ROTATION_90;
                    if (isEven) {
                        location = new Location(world, x-1, y, z);
                    }
                    break;
            }
        } else if (isEven && mirror.equals(StructureMirror.LEFT_RIGHT) &&
                (facing.equals(StructureRotation.NONE) || facing.equals(StructureRotation.ROTATION_180))) {
            switch(finalRotation) {
                case NONE:
                    location = new Location(world, x, y, z+1);
                    break;
                case ROTATION_90:
                        location = new Location(world, x-1, y, z);
                    break;
                case ROTATION_180:
                        location = new Location(world, x, y, z-1);
                    break;
                case ROTATION_270:
                        location = new Location(world, x+1, y, z);
                    break;
            }
        }
        // 0 = south = +z, 1 = west = -x, 2 = north = -z, 3 = east = +x
        int intFacing = 4;
        switch(finalRotation) {
            case NONE:
                intFacing = 3;
                break;
            case ROTATION_90:
                intFacing = 0;
                break;
            case ROTATION_180:
                intFacing = 1;
                break;
            case ROTATION_270:
                intFacing = 2;
                break;
        }
        BukkitTask task = new SummonPainting(location, motif, intFacing)
                .runTaskLater(plugin, 400L);
    }
}
