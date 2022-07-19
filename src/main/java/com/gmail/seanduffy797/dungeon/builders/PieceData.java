package com.gmail.seanduffy797.dungeon.builders;

import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.Region;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Map;

public class PieceData {

    public String templatePath;
    public String structurePath;
    public String name = null;
    public int length;
    public int height;
    public int width;
    public boolean isEven;
    public Location offset;
    public Map<Location, Region> exits;
    public ArrayList<Focus> foci;

    public PieceData() {}

    public String toString() {
        String template = "Template Path: " + templatePath + ", ";
        String structure = "Structure Path: " + structurePath + ", ";
        String nameText = "Name: " + name + ", ";
        String sizeText = "Size: " + length + " x " + height + " x " + width + ", ";
        String isEvenText = "IsEven: " + isEven + ", ";
        String offsetText = "Offset: " + offset.getX() + ", " + offset.getY() + ", " + offset.getZ() + ", ";
        String exitsText = "Exits: " + exits.toString() + ", ";
        String fociText = "Foci: " + foci.toString();
        return template + structure + nameText + sizeText + isEvenText + offsetText + exitsText + fociText;
    }
}
