package com.gmail.seanduffy797.dungeon.regions;

import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.StoneBrickMaze;
import com.gmail.seanduffy797.dungeon.builders.maze.MazeOptions;
import com.gmail.seanduffy797.dungeon.builders.maze.StoneBrickMazeBuilder;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Arrays;

public class StoneBrickManager implements RegionManager {
    Location startLocation = new Location(DungeonManager.world, -2, 100, -47);
    StructureRotation startRotation = StructureRotation.ROTATION_270;
    Location startLocation2 = new Location(DungeonManager.world, -2, 100, -77);
    StructureRotation startRotation2 = StructureRotation.ROTATION_270;
    StoneBrickMazeBuilder builder1;
    StoneBrickMazeBuilder builder2;
    ArrayList<StoneBrickMaze> basic_pieces = new ArrayList<>(Arrays.asList(
            StoneBrickMaze.STRAIGHT,
            StoneBrickMaze.TURN,
            StoneBrickMaze.T,
            StoneBrickMaze.CROSS,
            StoneBrickMaze.END
    ));

    public StoneBrickManager() {
        MazeOptions options = new MazeOptions(1, 10, 10);
        options.setStart(0, 0, 5);
        options.addExit(0, 9, 5, 0);
        options.setLoopingFactors(new double[]{0});
        builder1 = new StoneBrickMazeBuilder(options, basic_pieces);

        MazeOptions options2 = new MazeOptions(6, 20, 18);
        options2.setStart(1, 0, 5);
        options2.addExit(1, 15, 0, 270);
        options2.addExit(0, 19, 15, 0);
        options2.addExit(4, 11, 17, 90);
        options2.setLoopingFactors(new double[]{.05, .03, .05, .1, .3, .1});
        builder2 = new StoneBrickMazeBuilder(options2);
    }

    public void build() {
        builder1.buildStoneBrickMaze(startLocation, startRotation);
        builder2.buildStoneBrickMaze(startLocation2, startRotation2);
    }

    public void clear() {
        builder1.clear();
        builder2.clear();
    }
}
