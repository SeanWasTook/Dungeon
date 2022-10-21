package com.gmail.seanduffy797.dungeon.regions;

public enum Region {
    NONE ("Nowhere"),
    SPAWN ("Eliavalia"),
    BRICK ("Ranic"),
    BRICK2 ("Deep Ranic"),
    HOUSE ("Ranic House"),
    SEWER ("Ranic Aqua"),
    PIPE2 ("Ranic pipe 2"),
    PIPE3 ("Ranic pipe 3"),
    BIGPIPE ("Ranic big pipe"),
    CRYPT ("Hades"),
    STONE_BRICK ("Khoregixa"),
    MINE ("Ferrous"),
    MINE_DECO ("Ferrous deco"),
    PUEBLO ("Rurian"),
    INHERIT ("Inherit"),
    TEST ("Test");

    private final String display;

    Region(String display) {
        this.display = display;
    }

    public String display() {return this.display;}
}
