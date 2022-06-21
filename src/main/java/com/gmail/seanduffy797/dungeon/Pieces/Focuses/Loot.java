package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

public enum Loot {

    BRICKT1 ("d:chests/brick"),

    BRICKT2 ("d:chests/brickt2"),

    BRICKWATER ("d:chests/brickwater"),

    MINE1 ("d:chests/mine"),

    CRYPTT1 ("d:chests/cryptt1");

    private final String path;

    Loot(String path) {
        this.path = path;
    }

    public String getPath() {return path;}
}
