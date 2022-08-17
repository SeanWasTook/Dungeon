package com.gmail.seanduffy797.dungeon.tasks;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.builders.BrickBuilder;
import com.gmail.seanduffy797.dungeon.builders.BrickPiecePicker;
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
        int j = rd.nextInt(300);
        if (BrickBuilder.map[i][j][53]) {
            for (int y = 100; y < 120; y++) {
                Location loc = new Location(world, -i, y, j - 150);
                Block block = loc.getBlock();
                if (block.getType().equals(Material.GRANITE) || block.getType().equals(Material.POLISHED_GRANITE)){
                    Block block2 = block.getRelative(0, 1, 0);
                    if (block2.getType().equals(Material.AIR) && (block2.getLightLevel() < 11)) {
                        if (Math.random() < 0.05) {
                            Block block3 = block2.getRelative(-1, 0, 0);
                            Block block4 = block2.getRelative(0, 0, -1);
                            Block block5 = block2.getRelative(-1, 0, -1);
                            if (block3.getType().equals(Material.AIR) && block4.getType().equals(Material.AIR) && block5.getType().equals(Material.AIR)) {
                                DungeonMob.DUNGEON_PIG.spawn(block2.getLocation());
                                // getServer().getConsoleSender().sendMessage("[Dungeon]: Spawned Pig!");
                            }
                        }
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
//        for (int y = 1; y < 100; y++) {
//            Location loc = new Location(world, i, y, j - 150);
//            Block block = loc.getBlock();
//            if (block.getType().equals(Material.STONE_BRICKS)){
//                Block block2 = block.getRelative(0,1, 0);
//                Block block3 = block.getRelative(0,2, 0);
//                if (block2.getType().equals(Material.AIR) && block3.getType().equals(Material.AIR) && block2.getLightLevel() < 8) {
//                    Skeleton skelly = (Skeleton)world.spawnEntity(block2.getLocation(), EntityType.SKELETON);
//                    if (Math.random() < 0.5) {
//                        skelly.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_SWORD));
//                    }
//                    getServer().getConsoleSender().sendMessage("Spawned Skeleton at " + ((int)loc.getX()) + ", " + ((int)loc.getY() + 1) + ", " + ((int)loc.getZ()));
//                }
//            }
//        }
    }
}
