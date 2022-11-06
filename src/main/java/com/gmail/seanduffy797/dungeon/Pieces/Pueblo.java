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

public enum Pueblo implements PieceStructure {
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
    LAYOUT13bt("pueblo/layout13bt", 95),
    LAYOUT14bt("pueblo/layout14bt",4),
    LAYOUT15bt("pueblo/layout15bt", 4),
    LAYOUT16bt("pueblo/layout16bt", 6),
    LAYOUT17bt("pueblo/layout17bt", 6),
    LAYOUT18bt("pueblo/layout18bt", 3),
    LAYOUT19bt("pueblo/layout19bt", 3),
    LAYOUT20bt("pueblo/layout20bt", 3),
    LAYOUT21bt("pueblo/layout21bt", 3),
    LAYOUT22bt("pueblo/layout22bt", 3),
    LAYOUT23bt("pueblo/layout23bt", 4),
    LAYOUT24bt("pueblo/layout24bt", 4),
    LAYOUT25bt("pueblo/layout25bt", 4),
    LAYOUT26bt("pueblo/layout26bt", 3),
    LAYOUT27bt("pueblo/layout27bt",4),
    LAYOUT28bt("pueblo/layout28bt", 4),
    LAYOUT29bt("pueblo/layout29bt", 3),
    LAYOUT30bt("pueblo/layout30bt", 3),
    LAYOUT31bt("pueblo/layout31bt", 3),
    LAYOUT32bt("pueblo/layout32bt", 3),
    LAYOUT33bt("pueblo/layout33bt", 3),
    LAYOUT34bt("pueblo/layout34bt", 3),
    LAYOUT35bt("pueblo/layout35bt", 3),
    LAYOUT36bt("pueblo/layout36bt", 4),
    LAYOUT37bt("pueblo/layout37bt", 4),
    LAYOUT38bt("pueblo/layout38bt", 4),
    LAYOUT39bt("pueblo/layout39bt", 3),
    LAYOUT40bt("pueblo/layout40bt",4),
    LAYOUT41bt("pueblo/layout41bt", 4),
    LAYOUT42bt("pueblo/layout42bt", 3),
    LAYOUT43bt("pueblo/layout43bt", 3),
    LAYOUT44bt("pueblo/layout44bt", 3),
    LAYOUT45bt("pueblo/layout45bt", 3),
    LAYOUT746t("pueblo/layout46bt", 3),
    LAYOUT47bt("pueblo/layout47bt", 3),
    LAYOUT48bt("pueblo/layout48bt", 3),
    LAYOUT49bt("pueblo/layout49bt", 4),
    LAYOUT50bt("pueblo/layout50bt", 4),
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
    LAYOUT13t("pueblo/layout13t", 69),
    LAYOUT14t("pueblo/layout14t",4),
    LAYOUT15t("pueblo/layout15t", 4),
    LAYOUT16t("pueblo/layout16t", 3),
    LAYOUT17t("pueblo/layout17t", 1),
    LAYOUT18t("pueblo/layout18t", 3),
    LAYOUT19t("pueblo/layout19t", 3),
    LAYOUT20t("pueblo/layout20t", 3),
    LAYOUT21t("pueblo/layout21t", 3),
    LAYOUT22t("pueblo/layout22t", 3),
    LAYOUT23t("pueblo/layout23t", 4),
    LAYOUT24t("pueblo/layout24t", 4),
    LAYOUT25t("pueblo/layout25t", 4),
    LAYOUT26t("pueblo/layout26t", 3),
    LAYOUT27t("pueblo/layout27t",4),
    LAYOUT28t("pueblo/layout28t", 4),
    LAYOUT29t("pueblo/layout29t", 3),
    LAYOUT30t("pueblo/layout30t", 3),
    LAYOUT31t("pueblo/layout31t", 3),
    LAYOUT32t("pueblo/layout32t", 3),
    LAYOUT33t("pueblo/layout33t", 3),
    LAYOUT34t("pueblo/layout34t", 3),
    LAYOUT35t("pueblo/layout35t", 3),
    LAYOUT36t("pueblo/layout36t", 4),
    LAYOUT37t("pueblo/layout37t", 4),
    LAYOUT38t("pueblo/layout38t", 4),
    LAYOUT39t("pueblo/layout39t", 3),
    LAYOUT40t("pueblo/layout40t",4),
    LAYOUT41t("pueblo/layout41t", 4),
    LAYOUT42t("pueblo/layout42t", 3),
    LAYOUT43t("pueblo/layout43t", 3),
    LAYOUT44t("pueblo/layout44t", 3),
    LAYOUT45t("pueblo/layout45t", 3),
    LAYOUT74t("pueblo/layout46t", 3),
    LAYOUT47t("pueblo/layout47t", 3),
    LAYOUT48t("pueblo/layout48t", 3),
    LAYOUT49t("pueblo/layout49t", 4),
    LAYOUT50t("pueblo/layout50t", 4);

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
