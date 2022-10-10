package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.Pieces.Region;
import org.bukkit.Location;

public class RegionMap {

    public static int x_offset = 300;
    public static int y_offset = 64;
    public static int z_offset = 300;

    private Region[][][] regionData = new Region[600][384][600];

    public RegionMap() {}

    public void fillRegionData(Location loc1, Location loc2, Region region) {
        int x1 = (int) Math.floor(loc1.getX());
        int y1 = (int) Math.floor(loc1.getY());
        int z1 = (int) Math.floor(loc1.getZ());
        int x2 = (int) Math.floor(loc2.getX());
        int y2 = (int) Math.floor(loc2.getY());
        int z2 = (int) Math.floor(loc2.getZ());

        for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
            for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                for (int z = Math.min(z1, z2); z <= Math.max(z1, z2); z++) {
                    fillXYZ(x, y, z, region);
                }
            }
        }
    }
    public void fillXYZ(int x, int y, int z, Region region) {
        regionData[x + x_offset][y + y_offset][z + z_offset] = region;
    }
    public Region getRegionAtLocation(Location loc) {
        int x = (int) Math.floor(loc.getX());
        int y = (int) Math.floor(loc.getY());
        int z = (int) Math.floor(loc.getZ());
        return getRegionAtXYZ(x, y, z);
    }
    public Region getRegionAtXYZ(int x, int y, int z) {
        if (x < x_offset || x >= -x_offset || y < -64 || y >= 320 || z < z_offset || z >= -z_offset) {
            return Region.NONE;
        }
        return regionData[x + x_offset][y + y_offset][z + z_offset];
    }
}
