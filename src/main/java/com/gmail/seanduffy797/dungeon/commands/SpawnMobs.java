package com.gmail.seanduffy797.dungeon.commands;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.mobs.EntityManager;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class SpawnMobs implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawnmobs")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                World world = DungeonManager.world;
                if (args.length >= 4) {
                    DungeonMob mob;
                    double x = 0, y = 0, z = 0;
                    try {
                        mob = DungeonMob.valueOf(args[0].toUpperCase());
                        x = Double.parseDouble(args[1]);
                        y = Double.parseDouble(args[2]);
                        z = Double.parseDouble(args[3]);
                        mob.spawn(new Location(world, x, y, z));
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                        sender.sendMessage("Invalid Argument");
                    }
                }
            } else {
                World world = DungeonManager.world;
                if (args.length >= 5) {
                    EntityType entity = EntityType.BAT;
                    int numMobs = 1;
                    int x = 0, y = 0, z = 0;
                    try {
                        entity = EntityType.valueOf(args[0].toUpperCase());
                        numMobs = Integer.parseInt(args[1]);
                        x = Integer.parseInt(args[2]);
                        y = Integer.parseInt(args[3]);
                        z = Integer.parseInt(args[4]);
                    } catch (IllegalArgumentException e) { sender.sendMessage("Invalid Argument"); }

                    for (int i = 0; i < numMobs; i++) {
                        world.spawnEntity(new Location(world, x, y, z), entity);
                    }
                } else {
                    sender.sendMessage("Usage: /spawnmobs <mob> <amount> <x> <y> <z>");
                }
            }
        }

        return true;
    }
}
