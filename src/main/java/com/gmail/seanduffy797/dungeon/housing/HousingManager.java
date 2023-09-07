package com.gmail.seanduffy797.dungeon.housing;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.regions.SubRegion;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class HousingManager {


    String path = "housing/meta";

    HashMap<SubRegion, ArrayList<House>> houses = new HashMap<>();

    public boolean parseHouses() {
        Plugin plugin = Dungeon.getPlugin();
        String metaPath = plugin.getDataFolder().toPath().resolve(path).toString();

        File dir = new File(metaPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                House house = readHouseFromFile(child.getPath());
                if (house != null) {
                    addHouseToHashMap(house);
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public House readHouseFromFile(String path) {
        JSONParser parser = new JSONParser();
        Object obj;
        try {
            obj = parser.parse(new FileReader(path));
        } catch (Exception ex) {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: could not parse houses file");
            ex.printStackTrace();
            return null;
        }
        JSONObject json = (JSONObject)obj;
        String ownerUuid;
        String ownerUsername;
        String houseUuid;
        HouseTier tier;
        SubRegion subRegion;

        if (json.containsKey("ownerUuid")) {
            ownerUuid = (String) json.get("ownerUuid");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field ownerUuid in " + path);
            return null;
        }
        if (json.containsKey("ownerUsername")) {
            ownerUsername = (String) json.get("ownerUsername");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field ownerUsername in " + path);
            ownerUsername = null;
        }
        if (json.containsKey("houseUuid")) {
            houseUuid = (String) json.get("houseUuid");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field houseUuid in " + path);
            return null;
        }
        if (json.containsKey("tier")) {
            try {
                tier = HouseTier.valueOf(((String) json.get("tier")).toUpperCase());
            } catch (IllegalArgumentException e) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: invalid tier in " + path);
                return null;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field tier in " + path);
            tier = HouseTier.TIER1;
        }
        if (json.containsKey("subRegion")) {
            try {
                subRegion = SubRegion.valueOf(((String) json.get("subRegion")).toUpperCase());
            } catch (IllegalArgumentException e) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: invalid subregion in " + path);
                return null;
            }
        } else {
            return null;
        }

        return new House(UUID.fromString(ownerUuid), ownerUsername, UUID.fromString(houseUuid), tier, subRegion);
    }

    public House createHouse(Player player, SubRegion subRegion) {
        House house = new House(player.getUniqueId(),
                ((TextComponent)player.displayName()).content(),
                UUID.randomUUID(),
                HouseTier.TIER1,
                subRegion);

        Plugin plugin = Dungeon.getPlugin();
        try {
            Files.copy(plugin.getDataFolder().toPath().resolve("housing/hometier1.nbt"),
                    plugin.getDataFolder().toPath().resolve("housing/structureNbt/" + house.houseUuid.toString() + ".nbt"));
        } catch (IOException e) {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Failed to write initial structure");
            return null;
        }

        addHouseToHashMap(house);
        return house;
    }

    private void addHouseToHashMap(House house) {
        SubRegion region = house.subRegion;

        if (houses.containsKey(region)) {
            ArrayList<House> houseList = houses.get(region);
            houseList.add(house);
        } else {
            ArrayList<House> houseList = new ArrayList<>();
            houseList.add(house);
            houses.put(region, houseList);
        }
    }

    private void writeHouseToJSON(House house) {
        JSONObject json = new JSONObject();
        json.put("ownerUuid", house.ownerUuid.toString());
        json.put("ownerUsername", house.ownerName);
        json.put("houseUuid", house.houseUuid.toString());
        json.put("tier", house.tier.name());
        json.put("subRegion", house.subRegion.name());

        Plugin plugin = Dungeon.getPlugin();
        String metaPath = plugin.getDataFolder().toPath().resolve(path + "/" + house.houseUuid.toString() + ".json").toString();
        try (FileWriter file = new FileWriter(metaPath)) {
            file.write(json.toJSONString());
            System.out.println("JSON Object write to a File successfully");
            System.out.println("JSON Object: " + json);
        } catch (IOException e) {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Failed to write house to file: " + json);
        }
    }

    public void saveHouses() {
        for (ArrayList<House> houseList: houses.values()) {
            for (House house: houseList) {
                house.save();
                writeHouseToJSON(house);
            }
        }
    }

    public ArrayList<House> getHousesForPlayer(Player player) {
        ArrayList<House> retHouses = new ArrayList<>();
        for (ArrayList<House> houseList: houses.values()) {
            for (House house: houseList) {
                if (house.ownerUuid.equals(player.getUniqueId())) {
                    retHouses.add(house);
                }
            }
        }
        return retHouses;
    }
}
