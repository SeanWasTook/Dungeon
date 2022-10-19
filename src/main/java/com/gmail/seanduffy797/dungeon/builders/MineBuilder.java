package com.gmail.seanduffy797.dungeon.builders;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.Pieces.Mine;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public class MineBuilder {

    private static World world = Bukkit.getWorld("Dungeon");

    private static int minX = -30;
    private static int maxX = 41;
    private static int minY = 20;
    private static int maxY = 96;
    private static int minZ = 36;
    private static int maxZ = 128;

    // USES X, Y, Z ORDER
    public static boolean[][][] map = new boolean[Math.abs(maxX - minX + 2)][Math.abs(maxY - minY) + 2][Math.abs(maxZ - minZ) + 2];

    public static List<Location> starts = Arrays.asList(
            new Location(world, -12, 97, 42),
            new Location(world, 4, 97, 38),
            new Location(world, 12, 97, 41)
    );

    public static ArrayList<BrickUnit> openEnds = new ArrayList<>();

    public static void build() {
        if(world == null) {
            getServer().getConsoleSender().sendMessage("[Dungeon]: Dungeon world not loaded");
        }

        fillWithStone();
        MinePiecePicker.init();
        if (!DungeonManager.isGenerated) {
            FocusMeta.init();
            DungeonManager.isGenerated = true;
        }

        for (boolean[][] row: map)
            for (boolean[] col: row)
                Arrays.fill(col, false);

        Location corner1 = new Location(DungeonManager.world, minX, minY, minZ);
        Location corner2 = new Location(DungeonManager.world, maxX, maxY, maxZ);
        DungeonManager.updateRegionMap(corner1, corner2, Region.MINE);

        buildQueue(Region.MINE, starts, StructureRotation.ROTATION_90);
    }

    public static void buildQueue(Region region, List<Location> startPoints, StructureRotation rotation) {
        for (Location start: startPoints) {
            openEnds.add(new BrickUnit(region, start, rotation, StructureMirror.NONE, 0, null));
        }

        while (openEnds.size() > 0) {
            int len = openEnds.size();

            // Gets a random number, weighted more heavily towards lower numbers
            Random rand = new Random();
            double index = rand.nextGaussian();
            if (index < 0) {
                index = -1 * index;
            }
            if (index >= 3) {
                index = 0;
            }
            int intIndex = (int)index;
            if (intIndex >= len) {
                getServer().getConsoleSender().sendMessage("[Dungeon]: You fucked up");
                intIndex = 0;
            }

            BrickUnit piece = openEnds.remove(intIndex);
            placePiece(piece.start, piece.depth, piece.rotation, piece.region, (Mine) piece.previous);
        }
    }

    public static void placePiece(Location current, int depth, StructureRotation rotation, Region region, Mine previous) {
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        if(plugin == null) {return;}

        Mine piece;
        piece = MinePiecePicker.pick(depth, region, previous);
        if(piece == null) {return;}

        Location start = current.clone();

        Location offset = piece.getStartOffset();
        int length = piece.getLength();
        int width = piece.getWidth();
        int height = piece.getHeight();
        Location cornerOffset = new Location(getWorld("Dungeon"), length - 1, height - 1, width - 1);

        boolean mirror = false;
        StructureMirror mirrorType = StructureMirror.NONE;
        if (Math.random() < 0.5) {
            mirror = true;
            offset = BuilderUtils.applyMirror(offset, false);
            cornerOffset = BuilderUtils.applyMirror(cornerOffset, false);
            mirrorType = StructureMirror.LEFT_RIGHT;
        }

        Location finalOffset = BuilderUtils.applyRotation(offset, rotation);
        cornerOffset = BuilderUtils.applyRotation(cornerOffset, rotation);
        start.add(finalOffset);
        Location corner = new Location(start.getWorld(), start.getX(), start.getY(), start.getZ());
        corner.add(cornerOffset);

        if (depth > 1 && BuilderUtils.checkBounds(start, corner, minX, maxX, minY, maxY, minZ, maxZ)) {
            return;
        }
        if (depth > 1 && BuilderUtils.checkMap(map, current, corner, minX, minY, minZ)) {
            if (Math.random() < 0.9) {
                return;
            }
        }

        BuilderUtils.fillMap(map, current, corner, minX, minY, minZ);
        MinePiecePicker.update(piece);
        piece.place(start, rotation, mirrorType);
        int newDepth = depth + 1;

        // HANDLE FOCUSES
        for (Focus foc: piece.getFocuses()) {
            Focus newFoc = foc.makeCopy(foc);
            Location newLoc = current.clone();
            if(mirror) {
                newFoc.location = newLoc.add(BuilderUtils.applyRotation(BuilderUtils.applyMirror(newFoc.location, false), rotation));
            } else {
                newFoc.location = newLoc.add(BuilderUtils.applyRotation(newFoc.location, rotation));
            }
            newFoc.start(Region.MINE);
        }

        // PREPARING THE NEXT SECTIONS
        for (Location loc: piece.getExits().keySet()) {
            StructureRotation newRotation = StructureRotation.NONE;

            Region newRegion = piece.getExits().get(loc);
            if(newRegion == Region.INHERIT) {
                newRegion = region;
            }

            switch((int)loc.getYaw()) {
                case 90:
                    newRotation = StructureRotation.ROTATION_90;
                    if (mirror) {newRotation = StructureRotation.ROTATION_270;}
                    break;
                case 180:
                    newRotation = StructureRotation.ROTATION_180;
                    break;
                case 270:
                    newRotation = StructureRotation.ROTATION_270;
                    if (mirror) {newRotation = StructureRotation.ROTATION_90;}
            }

            newRotation = BuilderUtils.addRotations(newRotation, rotation);
            Location newLoc = new Location(getWorld("Dungeon"), current.getX(), current.getY(), current.getZ());

            if(mirror) {
                openEnds.add(new BrickUnit(newRegion, newLoc.add(BuilderUtils.applyRotation(BuilderUtils.applyMirror(loc, false), rotation)), newRotation, StructureMirror.NONE, newDepth, piece));
            } else {
                openEnds.add(new BrickUnit(newRegion, newLoc.add(BuilderUtils.applyRotation(loc, rotation)), newRotation, StructureMirror.NONE, newDepth, piece));
            }
        }
    }

    public static void fillWithStone() {
        World world = Bukkit.getWorld("Dungeon");
        if (world == null) {
            return;
        }
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() != Material.STONE) {
                        block.setType(Material.STONE);
                    }
                    double rand = Math.random();
                    if(rand < 0.03) {
                        block.setType(Material.COAL_ORE);
                    } else if(rand < 0.045) {
                        block.setType(Material.IRON_ORE);
                    }
                }
            }
        }
    }

    public static void clear() {
        World world = Bukkit.getWorld("Dungeon");
        if (world == null) {
            return;
        }
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() != Material.AIR) {
                        block.setType(Material.AIR);
                    }
                }
            }
        }
    }
}
