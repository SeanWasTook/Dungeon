package com.gmail.seanduffy797.dungeon.regions;

import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.BricksZone1;
import com.gmail.seanduffy797.dungeon.Pieces.MiscPiece;
import com.gmail.seanduffy797.dungeon.Pieces.StoneBrickMaze;
import com.gmail.seanduffy797.dungeon.builders.SingularBuilder;
import com.gmail.seanduffy797.dungeon.builders.maze.MazeOptions;
import com.gmail.seanduffy797.dungeon.builders.maze.PieceTableEntry;
import com.gmail.seanduffy797.dungeon.builders.maze.StoneBrickMazeBuilder;
import com.gmail.seanduffy797.dungeon.builders.wavefunction.Direction;
import com.gmail.seanduffy797.dungeon.builders.wavefunction.PuebloBuilder;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Arrays;

public class StoneBrickManager implements RegionManager {
    Location startLocation = new Location(DungeonManager.world, -2, 100, -47);
    StructureRotation startRotation = StructureRotation.ROTATION_270;
    BorderPoint border1 = new BorderPoint(SubRegion.STONE_BRICK_MAZE_ENTRY, SubRegion.STONE_BRICK_MAZE_MAIN);
    BorderPoint border2 = new BorderPoint(SubRegion.STONE_BRICK_MAZE_MAIN, SubRegion.STONE_BRICK_MAZE_HALLWAY);
    BorderPoint border3 = new BorderPoint(SubRegion.STONE_BRICK_MAZE_MAIN, SubRegion.STONE_BRICK_ROOM);
    BorderPoint border4 = new BorderPoint(SubRegion.STONE_BRICK_MAZE_MAIN, SubRegion.STONE_BRICK_ROOM);
    BorderPoint border5 = new BorderPoint(SubRegion.STONE_BRICK_MAZE_MAIN, SubRegion.STONE_BRICK_ROOM);
    StoneBrickMazeBuilder builder1;
    StoneBrickMazeBuilder builder2;
    StoneBrickMazeBuilder builder3;
    SingularBuilder builder4;
    SingularBuilder builder5;
    SingularBuilder builder6;
    PuebloBuilder puebloBuilder = new PuebloBuilder();
    ArrayList<PieceTableEntry> basic_pieces = new ArrayList<>(Arrays.asList(
            StoneBrickMaze.STRAIGHT.getDefaultEntry().getCopyWithWeight(10),
            StoneBrickMaze.STRAIGHT_WOOD.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.STRAIGHT_NOISY.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.TURN.getDefaultEntry().getCopyWithWeight(10),
            StoneBrickMaze.TURN_WOOD.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.TURN_CANDLES.getDefaultEntry().getCopyWithWeight(3),
            StoneBrickMaze.T.getDefaultEntry().getCopyWithWeight(10),
            StoneBrickMaze.T_DOOR.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.T_PILLARS.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.T_CLOCK.getDefaultEntry().getCopyWithWeight(1),
            StoneBrickMaze.CROSS.getDefaultEntry().getCopyWithWeight(5),
            StoneBrickMaze.CROSS_LOGS.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.CROSS_PILLAR.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.CROSS_CANDLE.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.END.getDefaultEntry().getCopyWithWeight(10),
            StoneBrickMaze.END_CHEST.getDefaultEntry().getCopyWithWeight(1),
            StoneBrickMaze.END_SKULL.getDefaultEntry().getCopyWithWeight(2),
            StoneBrickMaze.END_PEARL.getDefaultEntry().getCopyWithWeight(1),
            StoneBrickMaze.END_KEY.getDefaultEntry().getCopyWithWeight(1)
    ));

    public StoneBrickManager() {
        MazeOptions options = new MazeOptions(1, 10, 10);
        options.setStart(0, 0, 5);
        options.addExit(0, 9, 5, Direction.NORTH, border1);
        options.setLoopingFactors(new double[]{0});
        builder1 = new StoneBrickMazeBuilder(options, basic_pieces);

        MazeOptions options2 = new MazeOptions(6, 20, 18);
        options2.setStart(1, 0, 5);
        options2.addExit(1, 15, 0, Direction.WEST, border4);
        options2.addExit(0, 19, 15, Direction.NORTH, border3);
        options2.addExit(4, 11, 17, Direction.EAST, border2);
        options2.setLoopingFactors(new double[]{.05, .03, .05, .1, .3, .1});
        builder2 = new StoneBrickMazeBuilder(options2);

        MazeOptions options3 = new MazeOptions(3, 20, 5);
        options3.setStart(1, 0, 2);
        options3.addExit(1, 19, 2, Direction.NORTH, border5);
        builder3 = new StoneBrickMazeBuilder(options3);

        builder4 = new SingularBuilder(BricksZone1.SHRINE1);
        builder5 = new SingularBuilder(MiscPiece.PUEBLO_LEVER);
        builder6 = new SingularBuilder(MiscPiece.PUEBLO_TRANSITION);
    }

    public void build() {
        builder1.buildStoneBrickMaze(startLocation, startRotation);
        builder2.buildStoneBrickMaze(border1.getLocation(), Direction.getDirectionAsRotation(border1.getDirection()));
        builder3.buildStoneBrickMaze(border2.getLocation(), Direction.getDirectionAsRotation(border2.getDirection()));
        builder4.build(border3.getLocation(), border3.getDirection(), Region.STONE_BRICK);
        builder5.build(border4.getLocation(), border4.getDirection(), Region.STONE_BRICK);
        builder6.build(border5.getLocation(), border5.getDirection(), Region.STONE_BRICK);
        for (BorderPoint exitBP: builder6.exits) {
            puebloBuilder.build(exitBP.getLocation(), exitBP.getDirection());
            break; // just in case
        }
    }

    public void clear() {
        builder1.clear();
        builder2.clear();
        builder3.clear();
        builder4.clear();
        builder5.clear();
        builder6.clear();
        puebloBuilder.clear();
    }
}
