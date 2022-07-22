package com.gmail.seanduffy797.dungeon.builders.maze;

import java.util.ArrayList;

public class MazeUnit {

    private MazeConnection forward;
    public boolean forwardException = false;
    private MazeConnection right;
    public boolean rightException = false;
    private MazeConnection back;
    public boolean backException = false;
    private MazeConnection left;
    public boolean leftException = false;

    private boolean isExplored;

    public MazeUnit() {
        forward = null;
        right = null;
        back = null;
        left = null;

        isExplored = false;
    }
    public void setExplored(boolean explored) {
        this.isExplored = explored;
    }
    public boolean isExplored() {
        return isExplored;
    }
    public void setForward(MazeConnection forward) {
        this.forward = forward;
    }
    public void setRight(MazeConnection right) {
        this.right = right;
    }
    public void setBack(MazeConnection back) {
        this.back = back;
    }
    public void setLeft(MazeConnection left) {
        this.left = left;
    }
    public boolean isForwardOpen() {
        if (this.forward == null) {
            return forwardException;
        } else {
            return this.forward.isOpen();
        }
    }
    public boolean isRightOpen() {
        if (this.right == null) {
            return rightException;
        } else {
            return this.right.isOpen();
        }
    }
    public boolean isBackOpen() {
        if (this.back == null) {
            return backException;
        } else {
            return this.back.isOpen();
        }
    }
    public boolean isLeftOpen() {
        if (this.left == null) {
            return leftException;
        } else {
            return this.left.isOpen();
        }
    }
    public MazeUnit getForwardUnit() {
        if (this.forward == null) {
            return null;
        } else {
            return this.forward.getIncreasingUnit();
        }
    }
    public MazeUnit getRightUnit() {
        if (this.right == null) {
            return null;
        } else {
            return this.right.getIncreasingUnit();
        }
    }
    public MazeUnit getBackUnit() {
        if (this.back == null) {
            return null;
        } else {
            return this.back.getDecreasingUnit();
        }
    }
    public MazeUnit getLeftUnit() {
        if (this.left == null) {
            return null;
        } else {
            return this.left.getDecreasingUnit();
        }
    }
    public ArrayList<MazeConnection> getConnections() {
        ArrayList<MazeConnection> list = new ArrayList<>();
        if (this.forward != null) {
            list.add(this.forward);
        }
        if (this.right != null) {
            list.add(this.right);
        }
        if (this.back != null) {
            list.add(this.back);
        }
        if (this.left != null) {
            list.add(this.left);
        }
        return list;
    }
}
