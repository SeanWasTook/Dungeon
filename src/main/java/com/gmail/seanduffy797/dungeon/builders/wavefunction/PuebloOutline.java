package com.gmail.seanduffy797.dungeon.builders.wavefunction;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.Pueblo;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Collections;

import static org.bukkit.Bukkit.getServer;

public class PuebloOutline {

    public Pueblo pueblo;
    public StructureRotation rotation;
    public StructureMirror mirror;
    public PuebloPieceLayout layout;

    public PuebloOutline(Pueblo pueblo, StructureRotation rotation, StructureMirror mirror) {
        this.pueblo = pueblo;
        this.rotation = rotation;
        this.mirror = mirror;
        this.layout = new PuebloPieceLayout();

        if (pueblo.getEdges() != null) {
            for (Direction dir : Direction.values()) {
                Direction newDir = Direction.getAppliedTransforms(dir, rotation, mirror);
                PuebloEdge connection = pueblo.getEdges().get(dir);
                if (mirror == StructureMirror.LEFT_RIGHT) {
                    connection = connection.mirror();
                }
                this.layout.connections.put(newDir, new ArrayList<>(Collections.singletonList(connection)));
            }
        }
    }

    public void printOutline() {
        getServer().getConsoleSender().sendMessage
                (ChatColor.RED + "[Dungeon]: Outline: " + pueblo.name() +
                        " has rotation: " + rotation.name() +
                        " has mirror: " + mirror.name() +
                        " has north: " + layout.getNorth() +
                        " has east: " + layout.getEast() +
                        " has south: " + layout.getSouth() +
                        " has west: " + layout.getWest() +
                        " has up: " + layout.getUp() +
                        " has down: " + layout.getDown());
    }
}
