package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import com.gmail.seanduffy797.dungeon.tasks.SummonPainting;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;

public class Painting extends Focus {

    public String motif;
    public StructureRotation facing;

    public Painting(Location location, String motif, StructureRotation facing) {
        this.location = location;
        this.motif = motif;
        this.facing = facing;
    }

    public Painting makeCopy(Focus other) {
        if(other instanceof  Painting) {
            Painting painting = (Painting) other;
            return new Painting(painting.location.clone(), painting.motif, painting.facing);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        // 3 = south = +z, 4 = west = -x, 2 = north = -z, 5 = east = +x, 1 is top, and 0 is bottom
        StructureRotation finalRotation = BuilderUtils.addRotations(rotation, facing);
        if (mirror.equals(StructureMirror.LEFT_RIGHT) && (facing.equals(StructureRotation.ROTATION_90) || facing.equals(StructureRotation.ROTATION_270))) {
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
        int intFacing;
        switch(finalRotation) {
            case NONE:
                intFacing = 5;
                break;
            case ROTATION_90:
                intFacing = 3;
                break;
            case ROTATION_180:
                intFacing = 4;
                break;
            case ROTATION_270:
                intFacing = 2;
                break;
            default:
                intFacing = 1;
        }
        BukkitTask task = new SummonPainting(location, motif, intFacing).runTaskLater(plugin, 400L);
    }
}
