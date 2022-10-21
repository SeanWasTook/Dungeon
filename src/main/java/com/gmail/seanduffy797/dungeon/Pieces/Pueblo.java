package com.gmail.seanduffy797.dungeon.Pieces;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.builders.PieceData;
import com.gmail.seanduffy797.dungeon.builders.PieceParser;
import com.gmail.seanduffy797.dungeon.builders.wavefunction.Direction;
import com.gmail.seanduffy797.dungeon.builders.wavefunction.PuebloEdge;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;

public enum Pueblo {
    FLOOR("pueblo/floor", 0),
    ERROR("pueblo/error", 0),
    LAYOUT0("pueblo/layout0", 1),
//    LAYOUT1("pueblo/layout1", 1),
//    LAYOUT2("pueblo/layout2", 1),
//    LAYOUT3("pueblo/layout3", 1),
//    LAYOUT4("pueblo/layout4", 1),
//    LAYOUT5("pueblo/layout5", 1),
//    LAYOUT6("pueblo/layout6", 1),
//    LAYOUT7("pueblo/layout7", 1),
//    LAYOUT8("pueblo/layout8", 1),
//    LAYOUT9("pueblo/layout9", 1),
//    LAYOUT10("pueblo/layout10", 1),
//    LAYOUT11("pueblo/layout11", 1),
//    LAYOUT12("pueblo/layout12", 1),
//    LAYOUT13("pueblo/layout13", 1),
    LAYOUT0b("pueblo/layout0b", 1),
//    LAYOUT1b("pueblo/layout1b", 1),
//    LAYOUT2b("pueblo/layout2b", 1),
//    LAYOUT3b("pueblo/layout3b", 1),
//    LAYOUT4b("pueblo/layout4b", 1),
//    LAYOUT5b("pueblo/layout5b", 1),
//    LAYOUT6b("pueblo/layout6b", 1),
//    LAYOUT7b("pueblo/layout7b", 1),
//    LAYOUT8b("pueblo/layout8b", 1),
//    LAYOUT9b("pueblo/layout9b", 1),
//    LAYOUT10b("pueblo/layout10b", 1),
//    LAYOUT11b("pueblo/layout11b", 1),
//    LAYOUT12b("pueblo/layout12b", 1),
//    LAYOUT13b("pueblo/layout13b", 1),
    LAYOUT1bt("pueblo/layout1bt",4),
    LAYOUT2bt("pueblo/layout2bt", 4),
    LAYOUT3bt("pueblo/layout3bt", 6),
    LAYOUT4bt("pueblo/layout4bt", 6),
    LAYOUT5bt("pueblo/layout5bt", 1),
    LAYOUT6bt("pueblo/layout6bt", 1),
    LAYOUT7bt("pueblo/layout7bt", 1),
    LAYOUT8bt("pueblo/layout8bt", 1),
    LAYOUT9bt("pueblo/layout9bt", 1),
    LAYOUT10bt("pueblo/layout10bt", 4),
    LAYOUT11bt("pueblo/layout11bt", 4),
    LAYOUT12bt("pueblo/layout12bt", 4),
    LAYOUT13bt("pueblo/layout13bt", 25),
    LAYOUT1t("pueblo/layout1t", 4),
    LAYOUT2t("pueblo/layout2t", 5),
    LAYOUT3t("pueblo/layout3t", 7),
    LAYOUT4t("pueblo/layout4t", 7),
    LAYOUT5t("pueblo/layout5t", 1),
    LAYOUT6t("pueblo/layout6t", 2),
    LAYOUT7t("pueblo/layout7t", 2),
    LAYOUT8t("pueblo/layout8t", 2),
    LAYOUT9t("pueblo/layout9t", 2),
    LAYOUT10t("pueblo/layout10t", 4),
    LAYOUT11t("pueblo/layout11t", 5),
    LAYOUT12t("pueblo/layout12t", 5),
    LAYOUT13t("pueblo/layout13t", 19);

    private final PieceData data;
    public final int weight;

    Pueblo(String path, int weight) {
        this.weight = weight;
        String templatePath = "PieceTemplates/" + path + ".json";
        String structurePath = "PieceStructures/" + path + ".nbt";
        this.data = new PieceData();
        data.templatePath = templatePath;
        data.structurePath = structurePath;
        PieceParser.ParseJSON(data);
        this.data.height = 4;
        this.data.width = 7;
        this.data.length = 7;
        this.data.offset = new Location(DungeonManager.world, -3, 0, -3);
    }
    public Location getOffset() {
        return this.data.offset.clone();
    }
    public ArrayList<Focus> getFocuses() {
        return this.data.foci;
    }
    public Map<Direction, PuebloEdge> getEdges() {
        return this.data.puebloEdges;
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
