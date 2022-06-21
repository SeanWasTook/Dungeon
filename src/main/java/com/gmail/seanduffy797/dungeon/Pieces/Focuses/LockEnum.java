package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

public enum LockEnum {
    BASEMENTKEY("Basement Key"),
    SKELETONKEY("Skeleton Key"),
    OLDKEY("Old Key");

    private final String keyName;

    LockEnum(String keyName) {this.keyName = keyName;}

    public String getKeyName() {return this.keyName;}
}
