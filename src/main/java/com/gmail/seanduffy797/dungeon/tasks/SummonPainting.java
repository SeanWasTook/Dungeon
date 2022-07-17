package com.gmail.seanduffy797.dungeon.tasks;

import org.bukkit.Art;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class SummonPainting extends BukkitRunnable {

    private Location loc;
    private String motif;
    private BlockFace facing;

    public SummonPainting(Location loc, String motif, BlockFace facing) {
        this.loc = loc;
        this.motif = motif;
        this.facing = facing;
    }

    @Override
    public void run() {
        World world = getServer().getWorld("Dungeon");
        Painting painting = (Painting) world.spawnEntity(loc, EntityType.PAINTING);
        painting.setArt(Art.valueOf(motif.toUpperCase()));
        painting.setFacingDirection(facing);

//        getServer().dispatchCommand(Bukkit.getConsoleSender(),
//                "summon minecraft:painting " +
//                        ((int)loc.getX()) + " " +
//                        ((int)loc.getY()) + " " +
//                        ((int)loc.getZ()) +
//                        " {variant:\"minecraft:" + motif + "\", facing: " + facing + "b}");
    }
}
