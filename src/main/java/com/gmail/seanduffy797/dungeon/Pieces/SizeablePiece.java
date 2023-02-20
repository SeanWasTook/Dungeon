package com.gmail.seanduffy797.dungeon.Pieces;

import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.Location;

import java.util.Map;

public interface SizeablePiece extends PieceStructure {

    public int getLength();
    public int getWidth();
    public int getHeight();
    public Map<Location, Region> getExits();
}
