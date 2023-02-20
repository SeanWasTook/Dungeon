package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.builders.PieceData;
import com.gmail.seanduffy797.dungeon.builders.PieceParser;
import com.gmail.seanduffy797.dungeon.builders.maze.PieceTableEntry;
import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

import static org.bukkit.Bukkit.getPluginManager;

public enum MiscPiece implements SizeablePiece {

    PUEBLO_TRANSITION("stone_bricks/pueblo_transition"),
    PUEBLO_LEVER("misc/pueblo_lever");

    private final PieceData data;
    MiscPiece(String path) {
        String templatePath = "PieceTemplates/" + path + ".json";
        String structurePath = "PieceStructures/" + path + ".nbt";
        this.data = new PieceData();
        data.templatePath = templatePath;
        data.structurePath = structurePath;
        PieceParser.ParseJSON(data);
    }

    public Location getOffset() {
        return data.offset;
    }
    public ArrayList<Focus> getFocuses() {
        return data.foci;
    }
    public int getLength() {return data.length; }
    public int getWidth() {return data.width; }
    public int getHeight() {return data.height; }
    public Map<Location, Region> getExits() {return data.exits; }

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
