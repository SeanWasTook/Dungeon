package com.gmail.seanduffy797.dungeon.builders.wavefunction;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Pueblo;
import com.gmail.seanduffy797.dungeon.regions.Region;
import com.gmail.seanduffy797.dungeon.builders.BuilderUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import static org.bukkit.Bukkit.getServer;

public class PuebloBuilder {

    public static final int HORIZONTAL_SCALE = 7;
    public static final int VERTICAL_SCALE = 4;

    int height;
    int sizeNorthSouth;
    int sizeEastWest;
    Location startLocation; // Where the SOUTH WEST bottom corner will be
    int[] startLocationRelative;
    PuebloOutline startingPiece;

    public PuebloBuilder() {
        height = 5;
        sizeNorthSouth = 10;
        sizeEastWest = 10;
        startLocation = new Location(DungeonManager.world, 100, 50, 0);
        startLocationRelative = new int[] {0, 0, 0};
        startingPiece = new PuebloOutline(Pueblo.LAYOUT13bt, StructureRotation.ROTATION_90, StructureMirror.NONE);
    }

    public void build(Location startLocationParam, Direction facing) {
        startLocation = new Location(startLocationParam.getWorld(), startLocationParam.getX(),
                startLocationParam.getY() - 1,
                startLocationParam.getZ() - 3);
        switch (facing) {
            case NORTH:
                break;
            case EAST:
                this.startLocation = new Location(DungeonManager.world,
                        startLocation.getX() - HORIZONTAL_SCALE*sizeNorthSouth,
                        startLocation.getY(),
                        startLocation.getZ());
                startLocationRelative[0] = sizeNorthSouth - 1 - startLocationRelative[1];
                startLocationRelative[1] = 0;
                break;
            case SOUTH:
                this.startLocation = new Location(DungeonManager.world,
                        startLocation.getX() - HORIZONTAL_SCALE*sizeNorthSouth,
                        startLocation.getY(),
                        startLocation.getZ() - HORIZONTAL_SCALE*sizeEastWest);
                startLocationRelative[0] = sizeNorthSouth - 1;
                startLocationRelative[1] = sizeEastWest - 1 - startLocationRelative[1];
                break;
            case WEST:
                this.startLocation = new Location(DungeonManager.world,
                        startLocation.getX(),
                        startLocation.getY(),
                        startLocation.getZ() - HORIZONTAL_SCALE*sizeEastWest);
                startLocationRelative[0] = startLocationRelative[1];
                startLocationRelative[1] = sizeEastWest - 1;
                break;
        }
        build();
    }

    public void build() {
        getServer().getConsoleSender().sendMessage("[Dungeon]: Building Pueblo at:  " +
                startLocation.getX() + ", " + startLocation.getY() + ", " + startLocation.getZ());
        WaveBuilder waveBuilder = new WaveBuilder(sizeNorthSouth, sizeEastWest, height, startLocationRelative, startingPiece);
        waveBuilder.startExploration();

        PuebloOutline[][][] level = waveBuilder.explored;
        placeFloor();

        int x = (int) startLocation.getX();
        int z = (int) startLocation.getZ();
        int y = (int) startLocation.getY();

        for (int i = 0; i < sizeNorthSouth; i++) {
            for (int j = 0; j < sizeEastWest; j++) {
                for (int k = 0; k < height; k++) {
                    PuebloOutline outline = level[i][j][k];
                    if (outline == null) {
                        continue;
                    }
                    Location offset = outline.pueblo.getOffset();
                    StructureMirror newMirror = StructureMirror.NONE;
                    if (outline.mirror == StructureMirror.LEFT_RIGHT) {
                        if (outline.rotation == StructureRotation.ROTATION_90 || outline.rotation == StructureRotation.ROTATION_270) {
                            newMirror = StructureMirror.FRONT_BACK;
                            offset = BuilderUtils.applyRotation(BuilderUtils.applyMirrorFrontBack(offset), outline.rotation);
                        } else {
                            newMirror = StructureMirror.LEFT_RIGHT;
                            offset = BuilderUtils.applyRotation(BuilderUtils.applyMirror(offset, false), outline.rotation);
                        }
                    } else {
                        offset = BuilderUtils.applyRotation(offset, outline.rotation);
                    }
                    Location location = new Location(DungeonManager.world,
                                                        x + i*HORIZONTAL_SCALE + 3,
                                                        y + k*VERTICAL_SCALE + 1,
                                                        z + j*HORIZONTAL_SCALE + 3);
                    location.add(offset);

                    outline.pueblo.place(location, outline.rotation, newMirror);

                    location.subtract(offset);

                    for (Focus foc : outline.pueblo.getFocuses()) {
                        Focus newFoc = foc.makeCopy(foc);
                        Location newLoc = location.clone();
                        if (outline.mirror.equals(StructureMirror.LEFT_RIGHT)) {
                            newFoc.mirror = StructureMirror.LEFT_RIGHT;
                            newFoc.location = newLoc.add(BuilderUtils.applyRotation(
                                    BuilderUtils.applyMirror(newFoc.location, false), outline.rotation));
                        } else {
                            newFoc.mirror = StructureMirror.NONE;
                            newFoc.location = newLoc.add(BuilderUtils.applyRotation(newFoc.location, outline.rotation));
                        }
                        newFoc.rotation = outline.rotation;
                        newFoc.start(Region.PUEBLO);
                    }
                }
            }
        }
        DungeonManager.updateRegionMap(
                startLocation,
                new Location(DungeonManager.world,
                        x + sizeNorthSouth*HORIZONTAL_SCALE - 1,
                        y + height*VERTICAL_SCALE,
                        z + sizeEastWest*HORIZONTAL_SCALE - 1),
                Region.PUEBLO);
    }
    public void placeFloor() {
        int x = (int) startLocation.getX();
        int z = (int) startLocation.getZ();
        int y = (int) startLocation.getY();

        for (int i = 0; i < sizeNorthSouth; i++) {
            for (int j = 0; j < sizeEastWest; j++) {
                Location loc = new Location(DungeonManager.world, x + i*HORIZONTAL_SCALE, y, z + j*HORIZONTAL_SCALE);
                Pueblo.FLOOR.place(loc, StructureRotation.NONE, StructureMirror.NONE);
                Location cielLoc = new Location(DungeonManager.world, x + i*HORIZONTAL_SCALE, y + height*VERTICAL_SCALE + 1, z + j*HORIZONTAL_SCALE);
                Pueblo.FLOOR.place(cielLoc, StructureRotation.NONE, StructureMirror.NONE);
            }
            for (int k = 0; k < height; k++) {
                // Left Wall
                Location loc = new Location(DungeonManager.world, x + i * HORIZONTAL_SCALE, y + k*VERTICAL_SCALE + 1, z - 1);
                Pueblo.WALL.place(loc, StructureRotation.NONE, StructureMirror.NONE);
                // Front Wall
                Location loc2 = new Location(DungeonManager.world, x - 1, y + k*VERTICAL_SCALE + 1, z + i * HORIZONTAL_SCALE);
                Pueblo.WALL.place(loc2, StructureRotation.ROTATION_90, StructureMirror.NONE);
                // Right Wall
                Location loc3 = new Location(DungeonManager.world, x + i * HORIZONTAL_SCALE, y + k*VERTICAL_SCALE + 1, z + sizeEastWest * HORIZONTAL_SCALE);
                Pueblo.WALL.place(loc3, StructureRotation.NONE, StructureMirror.NONE);
                // Back Wall
                Location loc4 = new Location(DungeonManager.world, x + sizeNorthSouth * HORIZONTAL_SCALE, y + k*VERTICAL_SCALE + 1, z + i * HORIZONTAL_SCALE);
                Pueblo.WALL.place(loc4, StructureRotation.ROTATION_90, StructureMirror.NONE);
            }
        }
    }

    public void clear() {
        for (int x = (int) startLocation.getX() - 1; x < (startLocation.getX() + sizeNorthSouth*HORIZONTAL_SCALE) + 1; x++) {
            for (int z = (int) startLocation.getZ() - 1; z < (startLocation.getZ() + sizeEastWest*HORIZONTAL_SCALE) + 1; z++) {
                for (int y = (int) startLocation.getY(); y < (startLocation.getY() + height*VERTICAL_SCALE + 2); y++) {
                    Block block = DungeonManager.world.getBlockAt(x, y, z);
                    if (block.getType() != Material.AIR) {
                        block.setType(Material.AIR);
                    }
                }
            }
        }
    }
}
