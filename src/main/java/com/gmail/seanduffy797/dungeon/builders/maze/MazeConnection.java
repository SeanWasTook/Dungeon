package com.gmail.seanduffy797.dungeon.builders.maze;

public class MazeConnection {

    public MazeUnit decreasingUnit; // Unit with the lower index (to the back or the left)
    public MazeUnit increasingUnit; // Unit with the higher index (to the front or the right)

    private boolean isOpen;

    public MazeConnection(MazeUnit lower, MazeUnit upper) {
        this.decreasingUnit = lower;
        this.increasingUnit = upper;
        this.isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }
    public void open() {
        this.isOpen = true;
    }
    public MazeUnit getIncreasingUnit() {
        return decreasingUnit;
    }
    public MazeUnit getDecreasingUnit() {
        return increasingUnit;
    }
    public boolean isExplored() {
        return decreasingUnit.isExplored() && increasingUnit.isExplored();
    }
    public void markExplored() {
        this.decreasingUnit.setExplored(true);
        this.increasingUnit.setExplored(true);
    }
    public MazeUnit getUnexploredUnit() {
        if (!this.decreasingUnit.isExplored()) {
            return decreasingUnit;
        } else {
            return increasingUnit;
        }
    }
}
