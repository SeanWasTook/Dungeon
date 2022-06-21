package com.gmail.seanduffy797.dungeon.mobs;

import java.util.ArrayList;
import java.util.Arrays;

public enum NPCEnum {

    ROSANDE("Rosande", new ArrayList<>(Arrays.asList(
            "Welcome to our camp",
            "We've been struggling to live here ever since we were driven out of our homes by the Pillagers"
    )));

    private final String name;
    private final ArrayList<String> dialogue;

    NPCEnum(String name, ArrayList<String> dialogue) {this.name = name; this.dialogue = dialogue;}

    public String getName() {return this.name;}
    public ArrayList<String> getDialogue() {return this.dialogue;}
}
