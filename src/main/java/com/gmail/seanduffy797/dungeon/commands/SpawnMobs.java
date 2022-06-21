package com.gmail.seanduffy797.dungeon.commands;

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
                if (args.length >= 2) {
                    EntityType entity = EntityType.BAT;
                    int numMobs = 1;
                    if(args[0].equalsIgnoreCase("Mayor")) {
                        EntityManager.spawnMayor(player.getLocation());
                        return true;
                    }
                    try {
                        entity = EntityType.valueOf(args[0].toUpperCase());
                        numMobs = Integer.parseInt(args[1]);
                    } catch (IllegalArgumentException e) { sender.sendMessage("Invalid Argument"); return true; }
                    for (int i = 0; i < numMobs; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                } else {
                    sender.sendMessage("Usage: /spawnmobs <mob> <amount>");
                }
            } else {
                World world = getServer().getWorld("Dungeon");
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
