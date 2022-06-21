package com.gmail.seanduffy797.dungeon.builders;

import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.PieceLayout;
import com.gmail.seanduffy797.dungeon.tasks.FillChests;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public class BuilderUtils {

    public static boolean checkValid(Location loc) {
        if (loc.getX() < 40) {
            return false;
        }
        return true;
    }

    public static boolean checkMap(boolean[][] map, Location current, Location corner) {

        if (current.getX() < BrickBuilder.minX || current.getX() > BrickBuilder.maxX ||
                current.getZ() < BrickBuilder.minZ || current.getZ() > BrickBuilder.maxZ ||
                corner.getX() < BrickBuilder.minX || corner.getX() > BrickBuilder.maxX ||
                corner.getZ() < BrickBuilder.minZ || corner.getZ() > BrickBuilder.maxZ) {
            return true;
        }

        for(int i = (int)(corner.getX() > current.getX() ? current.getX() : corner.getX()); i <= (int)(corner.getX() > current.getX() ? corner.getX() : current.getX()); i++) {
            for (int j = ((int) (corner.getZ() > current.getZ() ? current.getZ() : corner.getZ()) + 150); j <= ((int) (corner.getZ() > current.getZ() ? corner.getZ() : current.getZ()) + 150); j++) {
                if (map[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkMap(boolean[][][] map, Location current, Location corner) {
        if (current.getX() < BrickBuilder.minX || current.getX() > BrickBuilder.maxX ||
                current.getZ() < BrickBuilder.minZ || current.getZ() > BrickBuilder.maxZ ||
                corner.getX() < BrickBuilder.minX || corner.getX() > BrickBuilder.maxX ||
                corner.getZ() < BrickBuilder.minZ || corner.getZ() > BrickBuilder.maxZ) {
            //getPluginManager().getPlugin("Dungeon").getLogger().log(Level.INFO, ChatColor.RED + "Out of bounds at: " + current.getX() + " " + current.getZ() + ". Tried to place " + name);
            return true;
        }

        for(int i = (int)(corner.getX() > current.getX() ? current.getX() : corner.getX()); i <= (int)(corner.getX() > current.getX() ? corner.getX() : current.getX()); i++) {
            for (int j = ((int) (corner.getZ() > current.getZ() ? current.getZ() : corner.getZ()) + 150); j <= ((int) (corner.getZ() > current.getZ() ? corner.getZ() : current.getZ()) + 150); j++) {
                for (int k = (int)(corner.getY() > current.getY() ? current.getY() : corner.getY()); k <= (int)(corner.getY() > current.getY() ? corner.getY() : current.getY()); k++) {
                    if (map[i][j][k]) {
                        //getPluginManager().getPlugin("Dungeon").getLogger().log(Level.INFO, ChatColor.RED + "Intersection at: " + i + " " + k + " " + (j - 150) + ". Tried to place " + name);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void fillMap(boolean[][] map, Location current, Location corner) {
        for(int i = (int)(corner.getX() > current.getX() ? current.getX() : corner.getX()); i <= (int)(corner.getX() > current.getX() ? corner.getX() : current.getX()); i++) {
            for (int j = ((int)(corner.getZ() > current.getZ() ? current.getZ() : corner.getZ()) + 150); j <= ((int)(corner.getZ() > current.getZ() ? corner.getZ() : current.getZ()) + 150); j++) {
                map[i][j] = true;
            }
        }
    }

    public static void fillMap(boolean[][][] map, Location current, Location corner) {
        for(int i = (int)(corner.getX() > current.getX() ? current.getX() : corner.getX()); i <= (int)(corner.getX() > current.getX() ? corner.getX() : current.getX()); i++) {
            for (int j = ((int)(corner.getZ() > current.getZ() ? current.getZ() : corner.getZ()) + 150); j <= ((int)(corner.getZ() > current.getZ() ? corner.getZ() : current.getZ()) + 150); j++) {
                for (int k = (int)(corner.getY() > current.getY() ? current.getY() : corner.getY()); k <= (int)(corner.getY() > current.getY() ? corner.getY() : current.getY()); k++) {
                    map[i][j][k] = true;
                }
            }
        }
    }

    public static boolean checkBounds(Location current, Location corner, int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
        if (current.getX() <= minX || current.getX() >= maxX ||
                current.getY() <= minY || current.getY() >= maxY ||
                current.getZ() <= minZ || current.getZ() >= maxZ ||
                corner.getX() <= minX || corner.getX() >= maxX ||
                corner.getY() <= minY || corner.getY() >= maxY ||
                corner.getZ() <= minZ || corner.getZ() >= maxZ) {
            return true;
        }
        return false;
    }

    public static PieceLayout pickLayout(OpenSpaces spaces) {
        PieceLayout shape;
        if(spaces.left2 && spaces.front2 && spaces.right2){
            shape = PieceLayout.CROSS;
        } else if (spaces.left1 && !spaces.front1 && !spaces.right1) {
            shape = PieceLayout.LEFTTURN;
        } else if (!spaces.left1 && !spaces.front1 && spaces.right1) {
            shape = PieceLayout.RIGHTTURN;
        } else if (!spaces.left1 && spaces.front1 && !spaces.right1) {
            shape = PieceLayout.STRAIGHT;
        } else if (!spaces.left1 && !spaces.front1 && !spaces.right1) {
            shape = PieceLayout.END;
        } else if (!spaces.left1 && spaces.front1 && spaces.right1) {
            shape = PieceLayout.RIGHT_T;
        } else if (spaces.left1 && spaces.front1 && !spaces.right1) {
            shape = PieceLayout.LEFT_T;
        } else if (spaces.left1 && spaces.right1 && !spaces.front1) {
            if (Math.random() < 0.5) {
                shape = PieceLayout.LEFTTURN;
            } else {
                shape = PieceLayout.RIGHTTURN;
            }
        } else if (!spaces.left2 && !spaces.front2 && !spaces.right2) {
            shape = PieceLayout.ROOM;
        } else {
            if (spaces.front2 && spaces.right2) {
                shape = PieceLayout.RIGHT_T;
            } else if (spaces.front2 && spaces.left2) {
                shape = PieceLayout.LEFT_T;
            } else {
                shape = PieceLayout.STRAIGHT;
            }
        }

        return shape;
    }

    public static void fillChests(ArrayList<Location> chests, Location start, StructureRotation rotation, boolean mirror, boolean even, String path) {
        for (Location chest: chests) {
            Location chestOffset;
            if(mirror){
                chestOffset = applyRotation(applyMirrorChest(chest, even), rotation);
            } else {
                chestOffset = applyRotation(chest, rotation);
            }
            Location finalLocation = start.add(chestOffset);

            Plugin plugin = getPluginManager().getPlugin("Dungeon");
            if(plugin == null) {return;}

            BukkitTask task = new FillChests(new Location(getWorld("Dungeon"), finalLocation.getX(), finalLocation.getY(), finalLocation.getZ()), path).runTaskLater(plugin, 40L);

            start.subtract(chestOffset);
        }
    }

    // Applies transformations to all the offsets. Thanks linear algebra
    public static Location applyRotation(Location input, StructureRotation rotation) {
        if(rotation == StructureRotation.NONE) {
            return input;
        } else if (rotation == StructureRotation.ROTATION_90) {
            return new Location(getWorld("Dungeon"), input.getZ() * -1, input.getY(), input.getX());
        } else if (rotation == StructureRotation.ROTATION_180) {
            return new Location(getWorld("Dungeon"), input.getX() * -1, input.getY(), input.getZ() * -1);
        } else if (rotation == StructureRotation.ROTATION_270) {
            return new Location(getWorld("Dungeon"), input.getZ(), input.getY(), input.getX() * -1);
        }
        return input;
    }

    // Only does left-right mirroring for now, and maybe forever
    // Warning: nightmare fuel
    public static Location applyMirror(Location input, boolean even) {
        if (!even) {
            return new Location(getWorld("Dungeon"), input.getX(), input.getY(), input.getZ() * -1);
        } else {
            Location newLoc;
            if (input.getX() == 0 && (int)input.getYaw() == 0) {
                newLoc = new Location(getWorld("Dungeon"), input.getX(), input.getY(), (input.getZ() - 1) * -1);
                return newLoc;
            }
            if ((int)input.getYaw() == 90) {
                newLoc = new Location(getWorld("Dungeon"), input.getX() - 1, input.getY(), input.getZ() * -1 + 1);
                return newLoc;
            } else if ((int)input.getYaw() == 270) {
                newLoc = new Location(getWorld("Dungeon"), input.getX() + 1, input.getY(), input.getZ() * -1 + 1);
                return newLoc;
            } else if ((int)input.getYaw() == 180) {
                newLoc = new Location(getWorld("Dungeon"), input.getX(), input.getY(), (input.getZ() - 1) * -1 + 1);
                return newLoc;
            } else {
                newLoc = new Location(getWorld("Dungeon"), input.getX(), input.getY(), (input.getZ() - 1) * -1 - 1);
                return newLoc;
            }
        }
    }

    // Only partially implemented, this one is for when it transitions from even to odd and maybe even vice versa
    // I thought the last one was painful, this is worse lol.
    public static Location applyMirror(Location input, boolean even, boolean transition) {
        if (even) {
            // Completely unimplemented even-to-odd transition
            return new Location(getWorld("Dungeon"), input.getX(), input.getY(), input.getZ() * -1);
        } else {
            Location newLoc;
            if (input.getX() == 0 && (int)input.getYaw() == 0) {
                newLoc = new Location(getWorld("Dungeon"), input.getX(), input.getY(), (input.getZ() - 1) * -1);
                return newLoc;
            }
            if ((int)input.getYaw() == 90) {
                newLoc = new Location(getWorld("Dungeon"), input.getX() - 1, input.getY(), input.getZ() * -1);
                return newLoc;
            } else if ((int)input.getYaw() == 270) {
                newLoc = new Location(getWorld("Dungeon"), input.getX() + 1, input.getY(), input.getZ() * -1);
                return newLoc;
            } else if ((int)input.getYaw() == 180) {
                newLoc = new Location(getWorld("Dungeon"), input.getX(), input.getY(), (input.getZ() - 1) * -1);
                return newLoc;
            } else {
                // This is the only thing that is currently relevant. Praying I don't have to do the rest
                newLoc = new Location(getWorld("Dungeon"), input.getX(), input.getY(), (input.getZ() - 1) * -1 - 2);
                return newLoc;
            }
        }
    }

    private static Location applyMirrorChest(Location input, boolean even) {
        if (!even) {
            return new Location(getWorld("Dungeon"), input.getX(), input.getY(), input.getZ() * -1);
        } else {
            Location newLoc;
            newLoc = new Location(getWorld("Dungeon"), input.getX(), input.getY(), (input.getZ() - 1) * -1);
            return newLoc;
        }
    }

    // Takes in two rotations and adds them together. Unfortunately this might actually be the cleanest way
    public static StructureRotation addRotations(StructureRotation rot1, StructureRotation rot2) {
        if(rot1 == StructureRotation.NONE && rot2 == StructureRotation.NONE) {
            return StructureRotation.NONE;
        } else if(rot1 == StructureRotation.NONE && rot2 == StructureRotation.ROTATION_90) {
            return StructureRotation.ROTATION_90;
        } else if(rot1 == StructureRotation.NONE && rot2 == StructureRotation.ROTATION_180) {
            return StructureRotation.ROTATION_180;
        } else if(rot1 == StructureRotation.NONE && rot2 == StructureRotation.ROTATION_270) {
            return StructureRotation.ROTATION_270;
        } else if(rot1 == StructureRotation.ROTATION_90 && rot2 == StructureRotation.NONE) {
            return StructureRotation.ROTATION_90;
        } else if(rot1 == StructureRotation.ROTATION_90 && rot2 == StructureRotation.ROTATION_90) {
            return StructureRotation.ROTATION_180;
        } else if(rot1 == StructureRotation.ROTATION_90 && rot2 == StructureRotation.ROTATION_180) {
            return StructureRotation.ROTATION_270;
        } else if(rot1 == StructureRotation.ROTATION_90 && rot2 == StructureRotation.ROTATION_270) {
            return StructureRotation.NONE;
        } else if(rot1 == StructureRotation.ROTATION_180 && rot2 == StructureRotation.NONE) {
            return StructureRotation.ROTATION_180;
        } else if(rot1 == StructureRotation.ROTATION_180 && rot2 == StructureRotation.ROTATION_90) {
            return StructureRotation.ROTATION_270;
        } else if(rot1 == StructureRotation.ROTATION_180 && rot2 == StructureRotation.ROTATION_180) {
            return StructureRotation.NONE;
        } else if(rot1 == StructureRotation.ROTATION_180 && rot2 == StructureRotation.ROTATION_270) {
            return StructureRotation.ROTATION_90;
        } else if(rot1 == StructureRotation.ROTATION_270 && rot2 == StructureRotation.NONE) {
            return StructureRotation.ROTATION_270;
        } else if(rot1 == StructureRotation.ROTATION_270 && rot2 == StructureRotation.ROTATION_90) {
            return StructureRotation.NONE;
        } else if(rot1 == StructureRotation.ROTATION_270 && rot2 == StructureRotation.ROTATION_180) {
            return StructureRotation.ROTATION_90;
        } else if(rot1 == StructureRotation.ROTATION_270 && rot2 == StructureRotation.ROTATION_270) {
            return StructureRotation.ROTATION_180;
        }
        return StructureRotation.NONE;
    }
}
