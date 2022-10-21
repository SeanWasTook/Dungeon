package com.gmail.seanduffy797.dungeon.Pieces;

import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.Location;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

public interface Bricks extends PieceStructure {

    public String getName();
    public Path getPath();
    public int getLength();
    public int getHeight();
    public int getWidth();
    public boolean getMirror();
    public boolean isEven();
    public Map<Location, Region> getExits();
}
