package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import de.tr7zw.nbtapi.NBTContainer;

public enum SpawnerEnum {
    GLADIATOR (SpawnerNBTCreator.gladiatorSpawner());

    private final NBTContainer nbtContainer;

    SpawnerEnum(NBTContainer nbtContainer) {
        this.nbtContainer = nbtContainer;
    }

    public NBTContainer getNBTContainer() {return nbtContainer; }
}
