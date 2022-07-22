package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.builders.PieceData;
import com.gmail.seanduffy797.dungeon.builders.PieceParser;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.logging.Level;

public enum StoneBrickMaze {
    STRAIGHT("stone_bricks/straight"),
    STRAIGHT_DOOR("stone_bricks/straight_door"),
    STRAIGHT_PAINTINGS("stone_bricks/straight_paintings"),
    STRAIGHT_COBWEBS("stone_bricks/straight_cobwebs"),
    TURN("stone_bricks/turn"),
    TURN_OPEN("stone_bricks/turn_open"),
    TURN_BOOKS("stone_bricks/turn_books"),
    TURN_CANDLES("stone_bricks/turn_candles"),
    TURN_DOORS("stone_bricks/turn_doors"),
    T("stone_bricks/t"),
    T_OPEN("stone_bricks/t_open"),
    T_BOOKS("stone_bricks/t_books"),
    T_TABLE("stone_bricks/t_table"),
    T_SHELF("stone_bricks/t_shelf"),
    T_PILLARS("stone_bricks/t_pillars"),
    CROSS("stone_bricks/cross"),
    CROSS_OPEN("stone_bricks/cross_open"),
    CROSS_CANDLE("stone_bricks/cross_candle"),
    CROSS_PILLAR("stone_bricks/cross_pillar"),
    END("stone_bricks/end"),
    END_CHEST("stone_bricks/end_chest"),
    END_PEARL("stone_bricks/end_pearl"),
    END_SPAWNER("stone_bricks/end_spawner"),
    END_LADDERS("stone_bricks/end_ladders");

    private final PieceData data;

    StoneBrickMaze(String path) {
        String templatePath = "PieceTemplates/" + path + ".json";
        String structurePath = "PieceStructures/" + path + ".nbt";
        this.data = new PieceData();
        data.templatePath = templatePath;
        data.structurePath = structurePath;
        PieceParser.ParseJSON(data);
    }

    public Location getStartOffset() {
        return data.offset;
    }
    public ArrayList<Focus> getFocuses() {
        return data.foci;
    }

    public void place(Location location, StructureRotation rotation, StructureMirror mirror) {
        Plugin plugin = Dungeon.getPlugin();

        StructureBlockLibApi.INSTANCE
                .loadStructure(plugin)
                .at(location)
                .includeEntities(true)
                .mirror(mirror)
                .rotation(rotation)
                .loadFromInputStream(plugin.getResource(data.structurePath))
                .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to load structure. " + data.name, e));
    }
}
