package com.gmail.seanduffy797.dungeon.builders;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.SizeablePiece;
import com.gmail.seanduffy797.dungeon.builders.wavefunction.Direction;
import com.gmail.seanduffy797.dungeon.regions.BorderPoint;
import com.gmail.seanduffy797.dungeon.regions.Region;
import com.gmail.seanduffy797.dungeon.regions.SubRegion;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;

public class SingularBuilder {

    SizeablePiece piece;
    Location location;
    Direction direction;
    Location corner1;
    Location corner2;
    public ArrayList<BorderPoint> exits = new ArrayList<>();

    public SingularBuilder(SizeablePiece piece) {
        this.piece = piece;
    }

    public void build(Location loc, Direction dir, Region region) {
        this.location =loc;
        this.direction = dir;
        StructureRotation rot = Direction.getDirectionAsRotation(direction);

        Location newOffset = BuilderUtils.applyRotation(
                piece.getOffset().clone(),
                rot);

        Location cornerOffset = new Location(
                DungeonManager.world,
                piece.getLength(),
                piece.getHeight(),
                piece.getWidth());
        cornerOffset = BuilderUtils.applyRotation(
                cornerOffset,
                rot);
        corner1 = location.clone().add(newOffset);
        corner2 = corner1.clone().add(cornerOffset);
        DungeonManager.updateRegionMap(corner1, corner2, region);
        piece.place(corner1, rot, StructureMirror.NONE);
        for (Focus foc: piece.getFocuses()) {
            Focus newFoc = foc.makeCopy(foc);
            Location newLoc = corner1.clone().subtract(newOffset);
            newFoc.mirror = StructureMirror.NONE;
            newFoc.location = BuilderUtils.applyRotation(newFoc.location, rot);
            newFoc.location = newFoc.location.add(newLoc);
            newFoc.rotation = rot;
            newFoc.start(region);
        }
        // Handles exits
        // Currently doesn't handle exits with any rotation (only straight halls work)
        for (Location exitLoc: piece.getExits().keySet()) {
            Location newLoc = corner1.clone().subtract(newOffset);
            Location newExitLoc = BuilderUtils.applyRotation(exitLoc, rot);
            newExitLoc = newExitLoc.add(newLoc);
            // This bit is very hardcoded because pieces don't correctly use subregions yet
            BorderPoint bp = new BorderPoint(SubRegion.STONE_BRICK_MAZE_HALLWAY, SubRegion.PUEBLO);
            bp.specify(newExitLoc.clone(), dir);
            exits.add(bp);
        }
    }

    public void clear() {
        for (int x = (int) Math.min(corner1.getX(), corner2.getX()); x <= Math.max(corner1.getX(), corner2.getX()); x++) {
            for (int y = (int) Math.min(corner1.getY(), corner2.getY()); y <= Math.max(corner1.getY(), corner2.getY()); y++) {
                for (int z = (int) Math.min(corner1.getZ(), corner2.getZ()); z <= Math.max(corner1.getZ(), corner2.getZ()); z++) {
                    Block block = DungeonManager.world.getBlockAt(x, y, z);
                    if (block.getType() != Material.AIR) {
                        block.setType(Material.AIR);
                    }
                }
            }
        }
    }
}
