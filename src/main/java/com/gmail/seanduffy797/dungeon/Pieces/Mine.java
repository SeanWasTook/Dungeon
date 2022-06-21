package com.gmail.seanduffy797.dungeon.Pieces;

import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import org.bukkit.Location;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

public interface Mine extends PieceStructure {

    public String getName();
    public Path getPath();
    public int getLength();
    public int getHeight();
    public int getWidth();
    public Location getStartOffset();
    public Map<Location, Region> getExits();
    public ArrayList<Focus> getFocuses();
}
