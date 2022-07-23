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
    STRAIGHT_LADDER_UP("stone_bricks/straight_ladder_up"),
    STRAIGHT_LADDER_DOWN("stone_bricks/straight_ladder_down"),
    STRAIGHT_LADDER_MIDDLE("stone_bricks/straight_ladder_middle"),
    TURN("stone_bricks/turn"),
    TURN_OPEN("stone_bricks/turn_open"),
    TURN_BOOKS("stone_bricks/turn_books"),
    TURN_CANDLES("stone_bricks/turn_candles"),
    TURN_DOORS("stone_bricks/turn_doors"),
    TURN_LADDER_UP("stone_bricks/turn_ladder_up"),
    TURN_LADDER_DOWN("stone_bricks/turn_ladder_down"),
    TURN_LADDER_MIDDLE("stone_bricks/turn_ladder_middle"),
    T("stone_bricks/t"),
    T_OPEN("stone_bricks/t_open"),
    T_BOOKS("stone_bricks/t_books"),
    T_TABLE("stone_bricks/t_table"),
    T_SHELF("stone_bricks/t_shelf"),
    T_PILLARS("stone_bricks/t_pillars"),
    T_LADDER_UP("stone_bricks/t_ladder_up"),
    T_LADDER_DOWN("stone_bricks/t_ladder_down"),
    T_LADDER_MIDDLE("stone_bricks/t_ladder_middle"),
    CROSS("stone_bricks/cross"),
    CROSS_OPEN("stone_bricks/cross_open"),
    CROSS_CANDLE("stone_bricks/cross_candle"),
    CROSS_PILLAR("stone_bricks/cross_pillar"),
    CROSS_LADDER_UP("stone_bricks/cross_ladder_up"),
    CROSS_LADDER_DOWN("stone_bricks/cross_ladder_down"),
    CROSS_LADDER_MIDDLE("stone_bricks/cross_ladder_middle"),
    END("stone_bricks/end"),
    END_CHEST("stone_bricks/end_chest"),
    END_PEARL("stone_bricks/end_pearl"),
    END_SPAWNER("stone_bricks/end_spawner"),
    END_LADDER_UP("stone_bricks/end_ladder_up"),
    END_LADDER_DOWN("stone_bricks/end_ladder_down"),
    END_LADDER_MIDDLE("stone_bricks/end_ladder_middle"),
    SOLID_LADDER_UP("stone_bricks/solid_ladder_up"),
    SOLID_LADDER_DOWN("stone_bricks/solid_ladder_down"),
    SOLID_LADDER_MIDDLE("stone_bricks/solid_ladder_middle"),
    ROOF("stone_bricks/roof");

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
