package com.gmail.seanduffy797.dungeon.builders;

import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.*;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.*;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Rotation;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.bukkit.Bukkit.getServer;

public class PieceParser {

    public static void ParseJSON(PieceData pieceData) {
        Plugin plugin = Dungeon.getPlugin();

        JSONObject json;

        String fullPath = pieceData.templatePath;

        InputStream s = plugin.getResource(fullPath);
        if (s == null) {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: does not exist " + fullPath);
            return;
        }
        try {
            json = (JSONObject) new JSONParser().parse(new InputStreamReader(s));
        } catch (Exception ex) {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: could not parse " + fullPath);
            ex.printStackTrace();
            return;
        }
        parseName(json, pieceData);
        parseLength(json, pieceData);
        parseHeight(json, pieceData);
        parseWidth(json, pieceData);
        parseIsEven(json, pieceData);
        parseOffset(json, pieceData);
        parseExits(json, pieceData);
        parseFoci(json, pieceData);
    }

    private static void parseName(JSONObject json, PieceData pieceData) {
        if (json.containsKey("name")) {
            pieceData.name = (String) json.get("name");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field name in " + pieceData.templatePath);
            pieceData.name = null;
        }
    }
    private static void parseLength(JSONObject json, PieceData pieceData) {
        if (json.containsKey("length")) {
            pieceData.length = (int) (long) json.get("length");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field length in " + pieceData.templatePath);
            pieceData.length = 5;
        }
    }
    private static void parseHeight(JSONObject json, PieceData pieceData) {
        if (json.containsKey("height")) {
            pieceData.height = (int) (long) json.get("height");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field height in " + pieceData.templatePath);
            pieceData.height = 5;
        }
    }
    private static void parseWidth(JSONObject json, PieceData pieceData) {
        if (json.containsKey("width")) {
            pieceData.width = (int) (long) json.get("width");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field width in " + pieceData.templatePath);
            pieceData.width = 5;
        }
    }
    private static void parseIsEven(JSONObject json, PieceData pieceData) {
        if (json.containsKey("isEven")) {
            pieceData.isEven = (boolean) json.get("isEven");
        } else {
            pieceData.isEven = false;
        }
    }
    private static void parseOffset(JSONObject json, PieceData pieceData) {
        JSONArray offset;
        if (json.containsKey("offset")) {
            offset = (JSONArray) json.get("offset");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field offset in " + pieceData.templatePath);
            pieceData.offset = new Location(DungeonManager.world, 0, -1, 0);
            return;
        }
        int x = (int) (long) offset.get(0);
        int y = (int) (long) offset.get(1);
        int z = (int) (long) offset.get(2);

        pieceData.offset = new Location(DungeonManager.world, x, y, z);
    }
    private static void parseExits(JSONObject json, PieceData pieceData) {
        JSONArray exits;
        if (json.containsKey("exits")) {
            exits = (JSONArray) json.get("exits");
        } else {
            pieceData.exits = Collections.emptyMap();
            return;
        }
        pieceData.exits = new HashMap<>();
        for (Object exit : exits) {
            JSONObject jsonExit = (JSONObject) exit;
            JSONArray coords;
            if (jsonExit.containsKey("loc")) {
                coords = (JSONArray) jsonExit.get("loc");
            } else {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in exit in " + pieceData.templatePath);
                continue;
            }
            int x = (int) (long) coords.get(0);
            int y = (int) (long) coords.get(1);
            int z = (int) (long) coords.get(2);
            int yaw;
            if (jsonExit.containsKey("direction")) {
                yaw = (int) (long) jsonExit.get("direction");
            } else {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: no field direction in exit in " + pieceData.templatePath);
                continue;
            }
            Region region;
            if (jsonExit.containsKey("region")) {
                try {
                    region = Region.valueOf(((String) jsonExit.get("region")).toUpperCase());
                } catch (IllegalArgumentException e) {
                    getServer().getConsoleSender().sendMessage
                            (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                    " exit at " + x + " " + y + " " + z +
                                    " has invalid region " + jsonExit.get("region"));
                    region = Region.INHERIT;
                }
            } else {
                region = Region.INHERIT;
            }
            pieceData.exits.put(
                    new Location(DungeonManager.world, x, y, z, yaw, 0), region);
        }
    }
    private static void parseFoci(JSONObject json, PieceData pieceData) {
        JSONArray foci;
        pieceData.foci = new ArrayList<>();
        if (json.containsKey("foci")) {
            foci = (JSONArray) json.get("foci");
        } else {
            return;
        }
        for (Object focus : foci) {
            JSONObject jsonFocus = (JSONObject) focus;
            FocusType type;
            if (jsonFocus.containsKey("type")) {
                try {
                    type = FocusType.valueOf(((String) jsonFocus.get("type")).toUpperCase());
                } catch (IllegalArgumentException e) {
                    getServer().getConsoleSender().sendMessage
                            (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                    " has invalid focus type " + jsonFocus.get("type"));
                    continue;
                }
            } else {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: no field type in a focus in " + pieceData.templatePath);
                continue;
            }
            switch(type) {
                case CHEST:
                    parseChest(jsonFocus, pieceData);
                    break;
                case DUNGEONENTITY:
                    parseDungeonEntity(jsonFocus, pieceData);
                    break;
                case EDITABLEBLOCK:
                    parseEditableBlock(jsonFocus, pieceData);
                    break;
                case IRONGATE:
                    parseIronGate(jsonFocus, pieceData);
                    break;
                case ITEMFRAMECHECKER:
                    parseItemFrameChecker(jsonFocus, pieceData);
                    break;
                case ITEMFRAMESPAWNER:
                    parseItemFrameSpawner(jsonFocus, pieceData);
                    break;
                case LOCKEDDOOR:
                    parseLockedDoor(jsonFocus, pieceData);
                    break;
                case LOCKEDTRAPDOOR:
                    parseLockedTrapdoor(jsonFocus, pieceData);
                    break;
                case PAINTINGSPAWNER:
                    parsePaintingSpawner(jsonFocus, pieceData);
                    break;
                case SPAWNER:
                    parseSpawner(jsonFocus, pieceData);
                    break;
                case TRIGGER:
                    parseTrigger(jsonFocus, pieceData);
                    break;
            }
        }
    }
    private static Location getLocation(JSONArray json) {
        int x = (int) (long) json.get(0);
        int y = (int) (long) json.get(1);
        int z = (int) (long) json.get(2);
        if (json.size() > 3) {
            int yaw = (int) (long) json.get(3);
            return new Location(DungeonManager.world, x, y, z, yaw, 0);
        }
        return new Location(DungeonManager.world, x, y, z);
    }
    private static void parseChest(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in chest focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        Loot loot;
        if (json.containsKey("lootType")) {
            try {
                loot = Loot.valueOf(((String) json.get("lootType")).toUpperCase());
            } catch (IllegalArgumentException e) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                " has invalid value of lootType in chest focus");
                return;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field lootType in chest focus in " + pieceData.templatePath);
            return;
        }
        boolean refill;
        if (json.containsKey("refill")) {
            refill = (boolean) json.get("refill");
        } else {
            refill = false;
        }
        int refillCoolDown;
        if (json.containsKey("refillCoolDown")) {
            refillCoolDown = (int) (long) json.get("refillCoolDown");
        } else {
            refillCoolDown = 0;
        }
        boolean prime;
        if (json.containsKey("prime")) {
            prime = (boolean) json.get("prime");
        } else {
            prime = true;
        }
        pieceData.foci.add(new Chest(location, loot, refillCoolDown, prime, refill));
    }
    private static void parseDungeonEntity(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in dungeonEntity focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        DungeonMob mobType;
        if (json.containsKey("mobType")) {
            try {
                mobType = DungeonMob.valueOf(((String) json.get("mobType")).toUpperCase());
            } catch (IllegalArgumentException e) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                " has invalid value of mobType in dungeonEntity focus");
                return;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field mobType in dungeonEntity focus in " + pieceData.templatePath);
            return;
        }
        int respawnCoolDown;
        if (json.containsKey("respawnCoolDown")) {
            respawnCoolDown = (int) (long) json.get("respawnCoolDown");
        } else {
            respawnCoolDown = 0;
        }
        pieceData.foci.add(new DungeonEntity(location, mobType, respawnCoolDown));
    }
    private static void parseEditableBlock(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in editableBlock focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        Material material;
        if (json.containsKey("material")) {
            try {
                material = Material.valueOf(((String) json.get("material")).toUpperCase());
            } catch (IllegalArgumentException e2) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                " has invalid value of material in editableBlock focus");
                return;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field material in editableBlock focus in " + pieceData.templatePath);
            return;
        }
        Integer puzzleId;
        if (json.containsKey("puzzleId")) {
            puzzleId = (Integer) (int) (long) json.get("puzzleId");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field puzzleId in editableBlock focus in " + pieceData.templatePath);
            puzzleId = 0;
        }
        pieceData.foci.add(new EditableBlock(location, material, puzzleId));
    }
    private static void parseIronGate(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in ironGate focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        int number;
        if (json.containsKey("number")) {
            number = (int) (long) json.get("number");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field number in ironGate focus in " + pieceData.templatePath);
            return;
        }
        pieceData.foci.add(new IronGate(location, number));
    }
    private static void parseItemFrameChecker(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in itemFrameChecker focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        Rotation goal;
        if (json.containsKey("goal")) {
            try {
            goal = Rotation.valueOf(((String) json.get("goal")).toUpperCase());
            } catch (IllegalArgumentException e) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                " has invalid value of rotation in itemFrameChecker focus");
                return;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field goal in itemFrameChecker focus in " + pieceData.templatePath);
            return;
        }
        Integer puzzleId;
        if (json.containsKey("puzzleId")) {
            puzzleId = (Integer) (int) (long) json.get("puzzleId");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field puzzleId in itemFrameChecker focus in " + pieceData.templatePath);
            puzzleId = 0;
        }
        pieceData.foci.add(new ItemFrameChecker(location, goal, puzzleId));
    }
    private static void parseItemFrameSpawner(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in itemFrameSpawner focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        String targetItem;
        ItemStack contents = null;
        if (json.containsKey("contents")) {
            targetItem = ((String) json.get("contents")).toUpperCase();
            try {
                contents = new ItemStack(Material.valueOf(targetItem));
            } catch (IllegalArgumentException e) {
                try {
                    ArrayList<String> itemArgs = new ArrayList<>();
                    JSONArray jsonArray;
                    if (json.containsKey("itemArgs")) {
                        jsonArray = (JSONArray) json.get("itemArgs");
                        if (jsonArray != null) {
                            for (Object o : jsonArray) {
                                itemArgs.add(o.toString());
                            }
                        }
                    }
                    String[] args = new String[itemArgs.size()];
                    args = itemArgs.toArray(args);
                    contents = ItemManager.getItem(DungeonItem.valueOf(targetItem), args);
                } catch (IllegalArgumentException e2) {
                    getServer().getConsoleSender().sendMessage
                            (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                    " has invalid value of item in itemFrameSpawner focus");
                }
            }
        }
        StructureRotation facing;
        if (json.containsKey("facing")) {
            int rotation = (int) (long) json.get("facing");
            switch(rotation) {
                case(0): default:
                    facing = StructureRotation.NONE;
                    break;
                case(90):
                    facing = StructureRotation.ROTATION_90;
                    break;
                case(180):
                    facing = StructureRotation.ROTATION_180;
                    break;
                case(270):
                    facing = StructureRotation.ROTATION_270;
                    break;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field facing in itemFrameSpawner focus in " + pieceData.templatePath);
            return;
        }
        boolean isGlow;
        if (json.containsKey("isGlow")) {
            isGlow = (boolean) json.get("isGlow");
        } else {
            isGlow = false;
        }
        boolean isFixed;
        if (json.containsKey("isFixed")) {
            isFixed = (boolean) json.get("isFixed");
        } else {
            isFixed = false;
        }
        pieceData.foci.add(new ItemFrameSpawner(location, contents, facing, isGlow, isFixed));
    }
    private static void parseLockedDoor(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in lockedDoor focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        LockEnum lock;
        if (json.containsKey("lock")) {
            try {
                lock = LockEnum.valueOf(((String) json.get("lock")).toUpperCase());
            } catch (IllegalArgumentException e) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                " has invalid value of lock in lockedDoor focus");
                return;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field lock in lockedDoor focus in " + pieceData.templatePath);
            return;
        }
        pieceData.foci.add(new LockedDoor(location, lock));
    }
    private static void parseLockedTrapdoor(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in lockedTrapdoor focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        LockEnum lock;
        if (json.containsKey("lock")) {
            try {
                lock = LockEnum.valueOf(((String) json.get("lock")).toUpperCase());
            } catch (IllegalArgumentException e) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                " has invalid value of lock in lockedTrapdoor focus");
                return;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field lock in lockedTrapdoor focus in " + pieceData.templatePath);
            return;
        }
        pieceData.foci.add(new LockedTrapdoor(location, lock));
    }
    private static void parsePaintingSpawner(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in paintingSpawner focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        String motif;
        if (json.containsKey("motif")) {
            motif = (String) json.get("motif");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field motif in paintingSpawner focus in " + pieceData.templatePath);
            return;
        }
        StructureRotation facing;
        if (json.containsKey("facing")) {
            int rotation = (int) (long) json.get("facing");
            switch(rotation) {
                case(0): default:
                    facing = StructureRotation.NONE;
                    break;
                case(90):
                    facing = StructureRotation.ROTATION_90;
                    break;
                case(180):
                    facing = StructureRotation.ROTATION_180;
                    break;
                case(270):
                    facing = StructureRotation.ROTATION_270;
                    break;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field facing in paintingSpawner focus in " + pieceData.templatePath);
            return;
        }
        boolean isEven;
        if (json.containsKey("isEven")) {
            isEven = (boolean) json.get("isEven");
        } else {
            isEven = false;
        }
        pieceData.foci.add(new PaintingSpawner(location, motif, facing, isEven));
    }
    private static void parseSpawner(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in spawner focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        SpawnerEnum spawnerType;
        if (json.containsKey("spawnerType")) {
            try {
                spawnerType = SpawnerEnum.valueOf(((String) json.get("spawnerType")).toUpperCase());
            } catch (IllegalArgumentException e) {
                getServer().getConsoleSender().sendMessage
                        (ChatColor.RED + "[Dungeon]: Parsing Error: " + pieceData.templatePath +
                                " has invalid value of spawnerType in spawner focus");
                return;
            }
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field spawnerType in spawner focus in " + pieceData.templatePath);
            return;
        }
        pieceData.foci.add(new Spawner(location, spawnerType));
    }
    private static void parseTrigger(JSONObject json, PieceData pieceData) {
        JSONArray jsonLoc;
        if (json.containsKey("loc")) {
            jsonLoc = (JSONArray) json.get("loc");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field loc in trigger focus in " + pieceData.templatePath);
            return;
        }
        Location location = getLocation(jsonLoc);
        Integer puzzleId;
        if (json.containsKey("puzzleId")) {
            puzzleId = (Integer) (int) (long) json.get("puzzleId");
        } else {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: Parsing Error: no field puzzleId in trigger focus in " + pieceData.templatePath);
            puzzleId = 0;
        }
        pieceData.foci.add(new Trigger(location, puzzleId));
    }
}
