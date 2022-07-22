package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.builders.PieceData;
import com.gmail.seanduffy797.dungeon.builders.PieceParser;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public enum StoneBrickMaze {
    STRAIGHT("stone_bricks/straight"),
    TURN("stone_bricks/turn"),
    TURN_OPEN("stone_bricks/turn_open"),
    T("stone_bricks/t"),
    T_OPEN("stone_bricks/t_open"),
    CROSS("stone_bricks/cross"),
    CROSS_OPEN("stone_bricks/cross_open"),
    END("stone_bricks/end");

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
