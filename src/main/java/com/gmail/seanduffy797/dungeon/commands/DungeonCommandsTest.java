package com.gmail.seanduffy797.dungeon.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DungeonCommandsTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can use this command");
            return true;
        }
        Player player = (Player) sender;

        // /heal
        if (cmd.getName().equalsIgnoreCase("heal")){
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
            double currentHealth = player.getHealth();
            player.setHealth(maxHealth);
            player.sendMessage(ChatColor.AQUA + "Healed " + (maxHealth - currentHealth) + " health");
        }

        return true;
    }
}
