package com.gmail.seanduffy797.dungeon.builders.wavefunction;

import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Pieces.Pueblo;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.HashSet;

import static org.bukkit.Bukkit.getServer;

public class WaveBuilder {

    int maxNorthSouth;
    int maxEastWest;
    int maxUpDown;
    int[] startCoords;
    PuebloOutline startPiece;
    public PuebloPieceLayout[][][] unexplored;
    public PuebloOutline[][][] explored;
    public HashSet<Integer> frontier;
    public WavePiecePicker piecePicker;

    public WaveBuilder(int maxNorthSouth, int maxEastWest, int maxUpDown, int[] startCoords, PuebloOutline startPiece) {
        this.maxNorthSouth = maxNorthSouth;
        this.maxEastWest = maxEastWest;
        this.maxUpDown = maxUpDown;
        this.startCoords = startCoords;
        this.startPiece = startPiece;

        // Everything uses X Z Y ordering again for some reason
        unexplored = new PuebloPieceLayout[maxNorthSouth][maxEastWest][maxUpDown];
        explored = new PuebloOutline[maxNorthSouth][maxEastWest][maxUpDown];

        for (int i = 0; i < maxNorthSouth; i++) {
            for (int j = 0; j < maxEastWest; j++) {
                for (int k = 0; k < maxUpDown; k++) {
                    unexplored[i][j][k] = new PuebloPieceLayout();
                    explored[i][j][k] = null;
                    if (k == 0) {
                        unexplored[i][j][k].setDown(PuebloEdge.FLOOR_SOLID);
                        unexplored[i][j][k].isReady = true;
                    }
                    if (j == 0 && k < 3) {
                        unexplored[i][j][k].setWest(PuebloEdge.INSIDE);
                    }
                    if (j == maxEastWest - 1 && k < 2) {
                        unexplored[i][j][k].setEast(PuebloEdge.INSIDE);
                    }
                }
            }
        }

        frontier = new HashSet<>();
        piecePicker = new WavePiecePicker();
    }

    public void startExploration() {
        updateMaps(startPiece, startCoords);
    }

    public void exploreFrontier() {
        if (frontier.size() == 0) {
            return;
        }

        int minOptions = 100000000;
        int[] finalCoords = new int[3];
        ArrayList<PuebloOutline> finalPossibilities = null;
        for (Integer intCoords: frontier) {
            int[] coords = convertIntegerToCoords(intCoords);
            PuebloPieceLayout layout = unexplored[coords[0]][coords[1]][coords[2]];
            ArrayList<PuebloOutline> possibilities = piecePicker.getPieceForLayout(layout);
            int options = possibilities.size();
            if (options > 0 && options < minOptions && layout.isReady) {
                minOptions = options;
                finalCoords = coords;
                finalPossibilities = possibilities;
            }
        }
        if (finalPossibilities == null || finalPossibilities.isEmpty()) {
            getServer().getConsoleSender().sendMessage
                    (ChatColor.RED + "[Dungeon]: WaveBuilder ran out of options on frontier");
            for (Integer intCoords: frontier) {
                int[] coords = convertIntegerToCoords(intCoords);
                explored[coords[0]][coords[1]][coords[2]] = new PuebloOutline(Pueblo.ERROR, StructureRotation.NONE, StructureMirror.NONE);
                unexplored[coords[0]][coords[1]][coords[2]].printLayout();
            }
            frontier.clear();
        } else {
            frontier.remove(convertCoordsToInteger(finalCoords));
            updateMaps(pickOutline(finalPossibilities), finalCoords);
        }
    }

    public PuebloOutline pickOutline(ArrayList<PuebloOutline> possibilities) {
        double total = 0;
        for (PuebloOutline puebloOutline : possibilities) {
            total += puebloOutline.pueblo.weight;
        }

        int idx = 0;
        for (double rand = Math.random() * total; idx < possibilities.size() - 1; idx++) {
            rand -= possibilities.get(idx).pueblo.weight;
            if (rand <= 0.0) {
                break;
            }
        }
        return possibilities.get(idx);
    }

    public void updateMaps(PuebloOutline outline, int[] coords) {
        int x = coords[0];
        int z = coords[1];
        int y = coords[2];
        explored[x][z][y] = outline;

        if (x > 0 && explored[x-1][z][y] == null) {
            PuebloPieceLayout frontierLayout = unexplored[x-1][z][y];
            frontierLayout.setNorth(outline.layout.getSouth().get(0).mirror());
            frontier.add(convertCoordsToInteger(new int[] {x - 1, z, y}));
        }
        if (x < maxNorthSouth - 1 && explored[x+1][z][y] == null) {
            PuebloPieceLayout frontierLayout = unexplored[x+1][z][y];
            frontierLayout.setSouth(outline.layout.getNorth().get(0).mirror());
            frontier.add(convertCoordsToInteger(new int[] {x + 1, z, y}));
        }
        if (z > 0 && explored[x][z-1][y] == null) {
            PuebloPieceLayout frontierLayout = unexplored[x][z-1][y];
            frontierLayout.setEast(outline.layout.getWest().get(0).mirror());
            frontier.add(convertCoordsToInteger(new int[] {x, z-1, y}));
        }
        if (z < maxEastWest - 1 && explored[x][z+1][y] == null) {
            PuebloPieceLayout frontierLayout = unexplored[x][z+1][y];
            frontierLayout.setWest(outline.layout.getEast().get(0).mirror());
            frontier.add(convertCoordsToInteger(new int[] {x, z+1, y}));
        }
        if (y > 0 && explored[x][z][y-1] == null) {
            PuebloPieceLayout frontierLayout = unexplored[x][z][y-1];
            frontierLayout.setUpConnection(outline.layout.getDown().get(0));
            frontier.add(convertCoordsToInteger(new int[] {x, z, y-1}));
        }
        if (y < maxUpDown - 1 && explored[x][z][y+1] == null) {
            PuebloPieceLayout frontierLayout = unexplored[x][z][y+1];
            // frontierLayout.setDown(outline.layout.getUp().get(0));
            frontierLayout.constrain(Direction.DOWN, outline.layout.getUp().get(0));
            if (outline.layout.getUp().get(0) == PuebloEdge.VERTICAL_SOLID
                    || outline.layout.getUp().get(0) == PuebloEdge.VERTICAL_OPEN) {
                frontierLayout.constrain(Direction.NORTH, outline.layout.getNorth().get(0));
                frontierLayout.constrain(Direction.EAST, outline.layout.getEast().get(0));
                frontierLayout.constrain(Direction.SOUTH, outline.layout.getSouth().get(0));
                frontierLayout.constrain(Direction.WEST, outline.layout.getWest().get(0));
            }
            frontierLayout.isReady = true;
            frontier.add(convertCoordsToInteger(new int[] {x, z, y+1}));
        }

        exploreFrontier();
    }

    private Integer convertCoordsToInteger(int[] coords) {
        return coords[0]*1000000 + coords[1]*1000 + coords[2];
    }
    private int[] convertIntegerToCoords(Integer integer) {
        return new int[] {integer / 1000000, (integer / 1000) % 1000, integer % 1000};
    }
}
