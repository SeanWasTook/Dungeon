package com.gmail.seanduffy797.dungeon.builders.wavefunction;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.Pueblo;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Bukkit.getServer;

public class WavePiecePicker {

    StructureMirror[] mirrors = {StructureMirror.NONE, StructureMirror.LEFT_RIGHT};

    public WavePiecePicker() {

    }

    public ArrayList<PuebloOutline> getPieceForLayout(PuebloPieceLayout layout) {
        ArrayList<PuebloOutline> possibilities = new ArrayList<>();
        for (Pueblo piece: Pueblo.values()) {
            if (piece.getEdges() != null) {
                possibilities.addAll(getMatchingOutlinesForPiece(layout, piece));
            }
        }
        return possibilities;
    }

    public ArrayList<PuebloOutline> getMatchingOutlinesForPiece(PuebloPieceLayout layout, Pueblo piece) {
        ArrayList<PuebloOutline> possibilities = new ArrayList<>();
        for (StructureRotation rotation: StructureRotation.values()) {
            for (StructureMirror mirror: mirrors) {
                Map<Direction, PuebloEdge> connectors = new HashMap<>();
                for (Direction dir: Direction.values()) {
                    Direction newDir = Direction.getAppliedTransforms(dir, rotation, mirror);
                    PuebloEdge connection = piece.getEdges().get(dir);
                    if (connection == null) {
                        getServer().getConsoleSender().sendMessage
                                (ChatColor.RED + "[Dungeon]: null value for direction " + dir.name() +
                                        " in piece " + piece.name());
                        continue;
                    }
                    if (mirror == StructureMirror.LEFT_RIGHT) {
                        connection = connection.mirror();
                    }
                    connectors.put(newDir, connection);
                }
                if (doConnectionsMatchLayout(layout, connectors)) {
                    possibilities.add(new PuebloOutline(piece, rotation, mirror));
                }
            }
        }
        return possibilities;
    }

    public boolean doConnectionsMatchLayout(PuebloPieceLayout layout, Map<Direction, PuebloEdge> connectors) {
        if (layout.getNorth().contains(connectors.get(Direction.NORTH)) &&
                layout.getEast().contains(connectors.get(Direction.EAST)) &&
                layout.getSouth().contains(connectors.get(Direction.SOUTH)) &&
                layout.getWest().contains(connectors.get(Direction.WEST)) &&
                layout.getUp().contains(connectors.get(Direction.UP)) &&
                layout.getDown().contains(connectors.get(Direction.DOWN))) {
            return true;
        } else {
            return false;
        }
    }
}
