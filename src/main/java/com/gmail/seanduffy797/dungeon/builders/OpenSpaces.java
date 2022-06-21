package com.gmail.seanduffy797.dungeon.builders;

import org.bukkit.Location;
import org.bukkit.World;

import static org.bukkit.Bukkit.getWorld;

public class OpenSpaces {

    static World world = getWorld("Dungeon");

    public static Location l1Start = new Location(world, 1, 0, -5);
    public static Location l1Corner = new Location(world, 9, 5, -6);
    public static Location l2Start = new Location(world, 1, 0, -20);
    public static Location l2Corner = new Location(world, 9, 5, -21);
    public static Location r1Start = new Location(world, 1, 0, 5);
    public static Location r1Corner = new Location(world, 9, 5, 6);
    public static Location r2Start = new Location(world, 1, 0, 20);
    public static Location r2Corner = new Location(world, 9, 5, 21);
    public static Location f1Start = new Location(world, 9, 0, -3);
    public static Location f1Corner = new Location(world, 10, 5, 3);
    public static Location f2Start = new Location(world, 26, 0, -3);
    public static Location f2Corner = new Location(world, 27, 5, 3);

    public boolean left1;
    public boolean left2;
    public boolean right1;
    public boolean right2;
    public boolean front1;
    public boolean front2;

    public OpenSpaces (boolean left1, boolean left2, boolean right1, boolean right2, boolean front1, boolean front2) {
        this.left1 = left1;
        this.left2 = left2;
        this.right1 = right1;
        this.right2 = right2;
        this.front1 = front1;
        this.front2 = front2;
    }
    public OpenSpaces () {
        this.left1 = false;
        this.left2 = false;
        this.right1 = false;
        this.right2 = false;
        this.front1 = false;
        this.front2 = false;
    }
}
