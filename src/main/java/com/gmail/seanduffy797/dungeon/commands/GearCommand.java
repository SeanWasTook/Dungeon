package com.gmail.seanduffy797.dungeon.commands;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GearCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("You have to be a player");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("gear")){
            Player player = (Player) sender;
            player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
            player.getInventory().addItem(new ItemStack(Material.APPLE, 3));
            for (int i = 0; i < 16; i++) {
                player.getInventory().addItem(DungeonItem.SOUL_TORCH.getItemStack());
            }
        }
        return true;
    }
}
