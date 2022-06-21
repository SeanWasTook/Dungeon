package com.gmail.seanduffy797.dungeon.commands;

import com.gmail.seanduffy797.dungeon.Items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getServer;

public class GiveCommand implements CommandExecutor {

    // A special give command to use for custom items
    // Currently supported: wand
    // Can be:
    // /dgive [item]
    // /dgive [player name] [item]
    // /dgive [player name] [item] [count]
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // Must specify a player to give to, if not called by a player
        if (!(sender instanceof Player) && args.length < 2){
            sender.sendMessage("Refer to the proper format please");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("dgive")){

            // If only one argument is given, that argument is assumed to be the item, which is given to the caller
            if (args.length == 1) {
                Player player = (Player) sender;
                if (args[0].equalsIgnoreCase("wand")) {
                    player.getInventory().addItem(ItemManager.wand);
                }
                else {
                    sender.sendMessage("Invalid Item");
                }
            }

            // Case where two arguments are given, player name and item
            else if (args.length == 2) {
                String playerName = args[0];
                Player receiver = getServer().getPlayer(playerName);
                if (receiver != null) {
                    if (args[1].equalsIgnoreCase("wand")) {
                        receiver.getInventory().addItem(ItemManager.wand);
                    } else {
                        sender.sendMessage("Invalid Item");
                    }
                } else {
                    sender.sendMessage("Could not find player " + playerName);
                }
            }

            // Case where 3 arguments are given, any additional commands are ignored
            else if (args.length >= 3) {
                String playerName = args[0];
                Player receiver = getServer().getPlayer(playerName);
                if (receiver != null) {
                    if (args[1].equalsIgnoreCase("wand")) {
                        int count = Integer.parseInt(args[2]);
                        ItemStack stack = ItemManager.wand;
                        stack.setAmount(count);
                        try {
                            receiver.getInventory().addItem(stack);
                        } catch (IllegalArgumentException e) { sender.sendMessage("You did something wrong"); }
                    } else {
                        sender.sendMessage("Invalid Item");
                    }
                } else {
                    sender.sendMessage("Could not find player " + playerName);
                }
            }
        }

        return true;
    }
}
