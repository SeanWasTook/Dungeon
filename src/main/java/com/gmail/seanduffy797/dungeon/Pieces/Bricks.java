package com.gmail.seanduffy797.dungeon.Pieces;

import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.Location;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

public interface Bricks extends PieceStructure, SizeablePiece {

    public String getName();
    public Path getPath();
    public boolean getMirror();
    public boolean isEven();
}
