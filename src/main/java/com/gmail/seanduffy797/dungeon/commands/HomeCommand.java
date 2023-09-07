package com.gmail.seanduffy797.dungeon.commands;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Items.Keys;
import com.gmail.seanduffy797.dungeon.housing.House;
import com.gmail.seanduffy797.dungeon.regions.SubRegion;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("home")){
            if (args.length >= 1 && sender instanceof Player) {
                Player player = (Player) sender;
                if (args[0].equalsIgnoreCase("buy")) {
                    House house = DungeonManager.housingManager.createHouse(player, SubRegion.SPAWN);
                    if (house == null) {
                        sender.sendMessage("House creation failed, please report this error");
                    } else {
                        sender.sendMessage("Your house has been created! It should be accessible soon");
                    }
                } else if (args[0].equalsIgnoreCase("load")) {
                    ArrayList<House> houses = DungeonManager.housingManager.getHousesForPlayer(player);
                    if (houses.isEmpty()){
                        sender.sendMessage("Sorry, you don't have any houses");
                        return true;
                    }
                    House house = houses.get(0);
                    if (!DungeonManager.isPlaying) {
                        DungeonManager.startPlaying();
                    }
                    house.place(new Location(DungeonManager.world, 55, 50, 0), StructureRotation.NONE, StructureMirror.NONE);
                    sender.sendMessage("Loaded house at x:55, y:50, z:0");
                } else if (args[0].equalsIgnoreCase("save")) {
                    DungeonManager.housingManager.saveHouses();
                    sender.sendMessage("Saved House");
                } else if (args[0].equalsIgnoreCase("clear")) {
                    House house = DungeonManager.housingManager.getHousesForPlayer(player).get(0);
                    house.clear();
                } else if (args[0].equalsIgnoreCase("key")) {
                    ArrayList<House> houses = DungeonManager.housingManager.getHousesForPlayer(player);
                    if (houses.isEmpty()){
                        sender.sendMessage("Sorry, you don't have any houses");
                        return true;
                    }
                    House house = houses.get(0);

                    ItemStack key = DungeonItem.HOUSE_KEY.getItemStack();
                    Keys.linkKeyToOwner(key, house);
                    player.getInventory().addItem(key);
                } else {
                    sender.sendMessage("Invalid Argument");
                }
            }
        }

        return true;
    }
}
