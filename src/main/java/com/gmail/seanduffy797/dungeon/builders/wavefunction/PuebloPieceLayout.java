package com.gmail.seanduffy797.dungeon.builders.wavefunction;

import com.gmail.seanduffy797.dungeon.Pieces.Pueblo;

import java.util.*;

public class PuebloPieceLayout {

    Map<Direction, ArrayList<PuebloConnectType>> connections;

    public PuebloPieceLayout() {
        connections = new HashMap<>();
        connections.put(Direction.NORTH, new ArrayList<>(Arrays.asList(PuebloConnectType.values())));
        connections.put(Direction.EAST, new ArrayList<>(Arrays.asList(PuebloConnectType.values())));
        connections.put(Direction.SOUTH, new ArrayList<>(Arrays.asList(PuebloConnectType.values())));
        connections.put(Direction.WEST, new ArrayList<>(Arrays.asList(PuebloConnectType.values())));
        connections.put(Direction.UP, new ArrayList<>(Arrays.asList(PuebloConnectType.values())));
        connections.put(Direction.DOWN, new ArrayList<>(Collections.emptyList()));
    }

    public void setNorth(PuebloConnectType type) {
        List<PuebloConnectType> list = connections.get(Direction.NORTH);
        list.clear();
        list.add(type);
    }
    public void setEast(PuebloConnectType type) {
        List<PuebloConnectType> list = connections.get(Direction.EAST);
        list.clear();
        list.add(type);
    }
    public void setSouth(PuebloConnectType type) {
        List<PuebloConnectType> list = connections.get(Direction.SOUTH);
        list.clear();
        list.add(type);
    }
    public void setWest(PuebloConnectType type) {
        List<PuebloConnectType> list = connections.get(Direction.WEST);
        list.clear();
        list.add(type);
    }
    public void setUpConnection(PuebloConnectType type) {
        List<PuebloConnectType> list = connections.get(Direction.UP);
        list.clear();
        list.add(type);
    }
    public void setDown(PuebloConnectType type) {
        List<PuebloConnectType> list = connections.get(Direction.DOWN);
        list.clear();
        list.add(type);
    }
    public List<PuebloConnectType> getNorth() {
        return connections.get(Direction.NORTH);
    }
    public List<PuebloConnectType> getEast() {
        return connections.get(Direction.EAST);
    }
    public List<PuebloConnectType> getSouth() {
        return connections.get(Direction.SOUTH);
    }
    public List<PuebloConnectType> getWest() {
        return connections.get(Direction.WEST);
    }
    public List<PuebloConnectType> getUp() {
        return connections.get(Direction.UP);
    }
    public List<PuebloConnectType> getDown() {
        return connections.get(Direction.DOWN);
    }

    public void constrain(Direction dir, PuebloConnectType type) {
        List<PuebloConnectType> list = connections.get(dir);
        if (list.size() > 1) {
            list.clear();
            list.addAll(type.getConstraints());
        }
    }
}
