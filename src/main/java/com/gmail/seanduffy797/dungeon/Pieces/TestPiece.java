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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

import static com.bergerkiller.bukkit.mw.MyWorlds.plugin;

public enum TestPiece implements Bricks {

    PAINTING("painting"),
    MANY_ENTITIES("many_entities"),
    ITEMFRAME("itemFrame"),
    BASIC("basic"),
    ALL("all");

    private final PieceData data;

    TestPiece(String path) {
        String templatePath = "PieceTemplates/" + path + ".json";
        String structurePath = "PieceStructures/" + path + ".nbt";
        this.data = new PieceData();
        data.templatePath = templatePath;
        data.structurePath = structurePath;
        PieceParser.ParseJSON(data);
    }

    public String getName() {
        return data.name;
    }
    public Path getPath() {
        // This is complete bullshit right now because I don't know what I'm doing
        // I mean I don't really need it so it's not a big deal but yeah
        return plugin.getDataFolder().toPath().resolve("brick/");
    }
    public int getLength() {
        return data.length;
    }
    public int getHeight() {
        return data.height;
    }
    public int getWidth() {
        return data.width;
    }
    public boolean isEven() {
        return data.isEven;
    }
    public Location getStartOffset() {
        return data.offset;
    }
    public boolean getMirror() {
        return true;
    }
    public Map<Location, Region> getExits() {
        return data.exits;
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
