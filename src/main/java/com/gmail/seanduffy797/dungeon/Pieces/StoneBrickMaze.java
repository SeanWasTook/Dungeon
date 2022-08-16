package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.builders.PieceData;
import com.gmail.seanduffy797.dungeon.builders.PieceParser;
import com.gmail.seanduffy797.dungeon.builders.maze.MazeUnitShape;
import com.gmail.seanduffy797.dungeon.builders.maze.PieceTableEntry;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.logging.Level;

public enum StoneBrickMaze {
    STRAIGHT("stone_bricks/straight", MazeUnitShape.STRAIGHT, 1, 0, 999),
    STRAIGHT_DOOR("stone_bricks/straight_door", MazeUnitShape.STRAIGHT, 2, 0, 999),
    STRAIGHT_PAINTINGS("stone_bricks/straight_paintings", MazeUnitShape.STRAIGHT, 2, 0, 999),
    STRAIGHT_COBWEBS("stone_bricks/straight_cobwebs", MazeUnitShape.STRAIGHT, 2, 0, 999),
    STRAIGHT_SECRET("stone_bricks/straight_secret", MazeUnitShape.STRAIGHT, 1, 0, 999),
    STRAIGHT_WOOD("stone_bricks/straight_wood", MazeUnitShape.STRAIGHT, 3, 0, 999),
    STRAIGHT_MAGMA("stone_bricks/straight_magma", MazeUnitShape.STRAIGHT, 1, 0, 999),
    STRAIGHT_TRAP("stone_bricks/straight_trap", MazeUnitShape.STRAIGHT, 2, 0, 999),
    STRAIGHT_NOISY("stone_bricks/straight_noisy", MazeUnitShape.STRAIGHT, 2, 0, 999),
    STRAIGHT_LADDER_UP("stone_bricks/straight_ladder_up", MazeUnitShape.STRAIGHT_UP, 1, 0, 999),
    STRAIGHT_LADDER_DOWN("stone_bricks/straight_ladder_down", MazeUnitShape.STRAIGHT_DOWN, 1, 0, 999),
    STRAIGHT_LADDER_MIDDLE("stone_bricks/straight_ladder_middle", MazeUnitShape.STRAIGHT_MIDDLE, 1, 0, 999),

    TURN("stone_bricks/turn", MazeUnitShape.TURN, 1, 0, 999),
    TURN_OPEN("stone_bricks/turn_open", MazeUnitShape.TURN, 1, 0, 999),
    TURN_BOOKS("stone_bricks/turn_books", MazeUnitShape.TURN, 2, 0, 999),
    TURN_CANDLES("stone_bricks/turn_candles", MazeUnitShape.TURN, 1, 0, 999),
    TURN_DOORS("stone_bricks/turn_doors", MazeUnitShape.TURN, 1, 0, 999),
    TURN_LIGHT("stone_bricks/turn_light", MazeUnitShape.TURN, 1, 0, 999),
    TURN_PLANT("stone_bricks/turn_plant", MazeUnitShape.TURN, 1, 0, 999),
    TURN_WOOD("stone_bricks/turn_wood", MazeUnitShape.TURN, 2, 0, 999),
    TURN_LADDER_UP("stone_bricks/turn_ladder_up", MazeUnitShape.TURN_UP, 1, 0, 999),
    TURN_LADDER_DOWN("stone_bricks/turn_ladder_down", MazeUnitShape.TURN_DOWN, 1, 0, 999),
    TURN_LADDER_MIDDLE("stone_bricks/turn_ladder_middle", MazeUnitShape.TURN_MIDDLE, 1, 0, 999),

    T("stone_bricks/t", MazeUnitShape.T, 1, 0, 999),
    T_OPEN("stone_bricks/t_open", MazeUnitShape.T, 1, 0, 999),
    T_BOOKS("stone_bricks/t_books", MazeUnitShape.T, 2, 0, 999),
    T_TABLE("stone_bricks/t_table", MazeUnitShape.T, 2, 0, 999),
    T_SHELF("stone_bricks/t_shelf", MazeUnitShape.T, 1, 0, 999),
    T_SHELF2("stone_bricks/t_shelf2", MazeUnitShape.T, 2, 0, 999),
    T_SHELF3("stone_bricks/t_shelf3", MazeUnitShape.T, 2, 0, 999),
    T_SHELF4("stone_bricks/t_shelf4", MazeUnitShape.T, 2, 0, 999),
    T_PILLARS("stone_bricks/t_pillars", MazeUnitShape.T, 2, 0, 999),
    T_CRAWL("stone_bricks/t_crawl", MazeUnitShape.T, 1, 0, 999),
    T_DOOR("stone_bricks/t_door", MazeUnitShape.T, 2, 0, 999),
    T_PLANT("stone_bricks/t_plant", MazeUnitShape.T, 2, 0, 999),
    T_CLOCK("stone_bricks/t_clock", MazeUnitShape.T, 1, 0, 999),
    T_LADDER_UP("stone_bricks/t_ladder_up", MazeUnitShape.T_UP, 1, 0, 999),
    T_LADDER_DOWN("stone_bricks/t_ladder_down", MazeUnitShape.T_DOWN, 1, 0, 999),
    T_LADDER_MIDDLE("stone_bricks/t_ladder_middle", MazeUnitShape.T_MIDDLE, 1, 0, 999),

    CROSS("stone_bricks/cross", MazeUnitShape.CROSS, 1, 0, 999),
    CROSS_OPEN("stone_bricks/cross_open", MazeUnitShape.CROSS, 1, 0, 999),
    CROSS_CANDLE("stone_bricks/cross_candle", MazeUnitShape.CROSS, 2, 0, 999),
    CROSS_PILLAR("stone_bricks/cross_pillar", MazeUnitShape.CROSS, 2, 0, 999),
    CROSS_LOGS("stone_bricks/cross_logs", MazeUnitShape.CROSS, 2, 0, 999),
    CROSS_BOOKS("stone_bricks/cross_books", MazeUnitShape.CROSS, 2, 0, 999),
    CROSS_CHEST("stone_bricks/cross_chest", MazeUnitShape.CROSS, 1, 0, 999),
    CROSS_SPAWNER("stone_bricks/cross_spawner", MazeUnitShape.CROSS, 1, 0, 999),
    CROSS_SKELETON_DOOR("stone_bricks/cross_skeleton_door", MazeUnitShape.CROSS, 1, 0, 999),
    CROSS_LADDER_UP("stone_bricks/cross_ladder_up", MazeUnitShape.CROSS_UP, 1, 0, 999),
    CROSS_LADDER_UP2("stone_bricks/cross_ladder_up2", MazeUnitShape.CROSS_UP, 1, 0, 999),
    CROSS_LADDER_DOWN("stone_bricks/cross_ladder_down", MazeUnitShape.CROSS_DOWN, 1, 0, 999),
    CROSS_LADDER_DOWN2("stone_bricks/cross_ladder_down2", MazeUnitShape.CROSS_DOWN, 2, 0, 999),
    CROSS_LADDER_MIDDLE("stone_bricks/cross_ladder_middle", MazeUnitShape.CROSS_MIDDLE, 1, 0, 999),

    END("stone_bricks/end", MazeUnitShape.END, 1, 0, 999),
    END_CHEST("stone_bricks/end_chest", MazeUnitShape.END, 3, 0, 999),
    END_PEARL("stone_bricks/end_pearl", MazeUnitShape.END, 1, 0, 999),
    END_SWORD("stone_bricks/end_sword", MazeUnitShape.END, 1, 0, 999),
    END_KEY("stone_bricks/end_key", MazeUnitShape.END, 1, 0, 999),
    END_SPAWNER("stone_bricks/end_spawner", MazeUnitShape.END, 2, 0, 999),
    END_SKULL("stone_bricks/end_skull", MazeUnitShape.END, 1, 0, 999),
    END_PLANT("stone_bricks/end_plant", MazeUnitShape.END, 2, 0, 999),
    END_NOISY("stone_bricks/end_noisy", MazeUnitShape.END, 2, 0, 999),
    END_BOOKS("stone_bricks/end_books", MazeUnitShape.END, 2, 0, 999),
    END_LADDER_UP("stone_bricks/end_ladder_up", MazeUnitShape.END_UP, 2, 0, 999),
    END_LADDER_UP_DOOR("stone_bricks/end_ladder_up_door", MazeUnitShape.END_UP, 1, 0, 999),
    END_LADDER_DOWN("stone_bricks/end_ladder_down", MazeUnitShape.END_DOWN, 1, 0, 999),
    END_LADDER_MIDDLE("stone_bricks/end_ladder_middle", MazeUnitShape.END_MIDDLE, 1, 0, 999),

    SOLID_LADDER_UP("stone_bricks/solid_ladder_up", MazeUnitShape.SOLID_UP, 1, 0, 999),
    SOLID_LADDER_DOWN("stone_bricks/solid_ladder_down", MazeUnitShape.SOLID_DOWN, 2, 0, 999),
    SOLID_LADDER_DOWN2("stone_bricks/solid_ladder_down2", MazeUnitShape.SOLID_DOWN, 1, 0, 999),
    SOLID_LADDER_MIDDLE("stone_bricks/solid_ladder_middle", MazeUnitShape.SOLID_MIDDLE, 1, 0, 999),

    ROOF("stone_bricks/roof", MazeUnitShape.END, 0, 0, 0);

    private final PieceData data;
    private final PieceTableEntry entry;

    StoneBrickMaze(String path, MazeUnitShape shape, int weight, int minCount, int maxCount) {
        String templatePath = "PieceTemplates/" + path + ".json";
        String structurePath = "PieceStructures/" + path + ".nbt";
        this.data = new PieceData();
        data.templatePath = templatePath;
        data.structurePath = structurePath;
        PieceParser.ParseJSON(data);
        this.entry = new PieceTableEntry(this, shape, weight, minCount, maxCount);
    }

    public Location getStartOffset() {
        return data.offset;
    }
    public ArrayList<Focus> getFocuses() {
        return data.foci;
    }
    public PieceTableEntry getEntry() {return entry;}

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
