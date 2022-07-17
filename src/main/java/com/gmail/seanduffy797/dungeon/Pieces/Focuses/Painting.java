package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import com.gmail.seanduffy797.dungeon.tasks.SummonPainting;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public class Painting extends Focus {

    public String motif;
    public StructureRotation facing;
    public boolean isEven;

    public Painting(Location location, String motif, StructureRotation facing, boolean isEven) {
        this.location = location;
        this.motif = motif;
        this.facing = facing;
        this.isEven = isEven;
    }

    public Painting makeCopy(Focus other) {
        if(other instanceof  Painting) {
            Painting painting = (Painting) other;
            return new Painting(painting.location.clone(), painting.motif, painting.facing, painting.isEven);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        World world = getWorld("Dungeon");
        StructureRotation finalRotation = BuilderUtils.addRotations(rotation, facing);
        // More mirroring nightmares
        if (mirror.equals(StructureMirror.LEFT_RIGHT) && (facing.equals(StructureRotation.ROTATION_90) || facing.equals(StructureRotation.ROTATION_270))) {
            switch(finalRotation) {
                case NONE:
                    finalRotation = StructureRotation.ROTATION_180;
                    if (isEven) {
                        location = new Location(world, location.getX(), location.getY(), location.getZ()-1);
                    }
                    break;
                case ROTATION_90:
                    finalRotation = StructureRotation.ROTATION_270;
                    if (isEven) {
                        location = new Location(world, location.getX()+1, location.getY(), location.getZ());
                    }
                    break;
                case ROTATION_180:
                    finalRotation = StructureRotation.NONE;
                    if (isEven) {
                        location = new Location(world, location.getX(), location.getY(), location.getZ()+1);
                    }
                    break;
                case ROTATION_270:
                    finalRotation = StructureRotation.ROTATION_90;
                    if (isEven) {
                        location = new Location(world, location.getX()-1, location.getY(), location.getZ());
                    }
                    break;
            }
        } else if (isEven && mirror.equals(StructureMirror.LEFT_RIGHT) &&
                (facing.equals(StructureRotation.NONE)) || facing.equals(StructureRotation.ROTATION_180)) {
            switch(finalRotation) {
                case NONE:
                    location = new Location(world, location.getX(), location.getY(), location.getZ()+1);
                    break;
                case ROTATION_90:
                        location = new Location(world, location.getX()-1, location.getY(), location.getZ());
                    break;
                case ROTATION_180:
                        location = new Location(world, location.getX(), location.getY(), location.getZ()-1);
                    break;
                case ROTATION_270:
                        location = new Location(world, location.getX()+1, location.getY(), location.getZ());
                    break;
            }
        }
        // 0 = south = +z, 1 = west = -x, 2 = north = -z, 3 = east = +x
        int intFacing;
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
            default:
                intFacing = 4;
        }
        BukkitTask task = new SummonPainting(location, motif, intFacing).runTaskLater(plugin, 400L);
    }
}
