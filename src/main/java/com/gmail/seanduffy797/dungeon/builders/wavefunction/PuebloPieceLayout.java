package com.gmail.seanduffy797.dungeon.builders.wavefunction;

import org.bukkit.ChatColor;

import java.util.*;

import static org.bukkit.Bukkit.getServer;

public class PuebloPieceLayout {

    Map<Direction, ArrayList<PuebloEdge>> connections;
    public boolean isReady = false; // Hack to prevent choosing a piece before the piece below it is known

    public PuebloPieceLayout() {
        connections = new HashMap<>();
        connections.put(Direction.NORTH, new ArrayList<>(Arrays.asList(PuebloEdge.values())));
        connections.put(Direction.EAST, new ArrayList<>(Arrays.asList(PuebloEdge.values())));
        connections.put(Direction.SOUTH, new ArrayList<>(Arrays.asList(PuebloEdge.values())));
        connections.put(Direction.WEST, new ArrayList<>(Arrays.asList(PuebloEdge.values())));
        connections.put(Direction.UP, new ArrayList<>(Arrays.asList(PuebloEdge.values())));
        connections.put(Direction.DOWN, new ArrayList<>(Arrays.asList(PuebloEdge.values())));
    }

    public void setNorth(PuebloEdge type) {
        List<PuebloEdge> list = connections.get(Direction.NORTH);
        list.clear();
        list.add(type);
    }
    public void setEast(PuebloEdge type) {
        List<PuebloEdge> list = connections.get(Direction.EAST);
        list.clear();
        list.add(type);
    }
    public void setSouth(PuebloEdge type) {
        List<PuebloEdge> list = connections.get(Direction.SOUTH);
        list.clear();
        list.add(type);
    }
    public void setWest(PuebloEdge type) {
        List<PuebloEdge> list = connections.get(Direction.WEST);
        list.clear();
        list.add(type);
    }
    public void setUpConnection(PuebloEdge type) {
        List<PuebloEdge> list = connections.get(Direction.UP);
        list.clear();
        list.add(type);
    }
    public void setDown(PuebloEdge type) {
        List<PuebloEdge> list = connections.get(Direction.DOWN);
        list.clear();
        list.add(type);
    }
    public List<PuebloEdge> getNorth() {
        return connections.get(Direction.NORTH);
    }
    public List<PuebloEdge> getEast() {
        return connections.get(Direction.EAST);
    }
    public List<PuebloEdge> getSouth() {
        return connections.get(Direction.SOUTH);
    }
    public List<PuebloEdge> getWest() {
        return connections.get(Direction.WEST);
    }
    public List<PuebloEdge> getUp() {
        return connections.get(Direction.UP);
    }
    public List<PuebloEdge> getDown() {
        return connections.get(Direction.DOWN);
    }

    public void constrain(Direction dir, PuebloEdge type) {
        List<PuebloEdge> list = connections.get(dir);
        if (list.size() > 1) {
            list.clear();
            list.addAll(type.getConstraints());
        }
    }

    public void printLayout() {
        getServer().getConsoleSender().sendMessage
                (ChatColor.RED + "[Dungeon]: Layout: " +
                        " has north: " + this.getNorth().toString() +
                        " has east: " + this.getEast().toString() +
                        " has south: " + this.getSouth().toString() +
                        " has west: " + this.getWest().toString() +
                        " has up: " + this.getUp().toString() +
                        " has down: " + this.getDown().toString());
    }
}
