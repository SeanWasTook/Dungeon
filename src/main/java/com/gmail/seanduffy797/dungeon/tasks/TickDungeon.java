package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.builders.BrickBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

import static org.bukkit.Bukkit.getServer;

public class TickDungeon extends BukkitRunnable {

    private World world;

    public TickDungeon(World world) {
        this.world = world;
    }

    @Override
    public void run() {
        Random rd = new Random();
        int i = rd.nextInt(200);
        int j = rd.nextInt(200);
        if (BrickBuilder.map[i][j][50]) {
            for (int y = 40; y < 70; y++) {
                Location loc = new Location(world, i, y, j - 150);
                Block block = loc.getBlock();
                if (block.getType().equals(Material.GRANITE) || block.getType().equals(Material.POLISHED_GRANITE)){
                    Block block2 = block.getRelative(0, 1, 0);
                    if (block2.getType().equals(Material.AIR) && (block2.getLightLevel() < 13)) {
                        //getServer().getConsoleSender().sendMessage("Placed Mushroom at " + ((int)loc.getX()) + ", " + ((int)loc.getY() + 1) + ", " + ((int)loc.getZ()));
                        if (Math.random() < 0.5) {
                            block2.setType(Material.BROWN_MUSHROOM);
                        } else {
                            block2.setType(Material.RED_MUSHROOM);
                        }
                        break;
                    }
                }
            }
        }
        for (int y = 1; y < 100; y++) {
            Location loc = new Location(world, i, y, j - 150);
            Block block = loc.getBlock();
            if (block.getType().equals(Material.STONE_BRICKS)){
                Block block2 = block.getRelative(0,1, 0);
                Block block3 = block.getRelative(0,2, 0);
                if (block2.getType().equals(Material.AIR) && block3.getType().equals(Material.AIR) && block2.getLightLevel() < 8) {
                    Skeleton skelly = (Skeleton)world.spawnEntity(block2.getLocation(), EntityType.SKELETON);
                    if (Math.random() < 0.5) {
                        skelly.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_SWORD));
                    }
                    getServer().getConsoleSender().sendMessage("Spawned Skeleton at " + ((int)loc.getX()) + ", " + ((int)loc.getY() + 1) + ", " + ((int)loc.getZ()));
                }
            }
        }
    }
}
