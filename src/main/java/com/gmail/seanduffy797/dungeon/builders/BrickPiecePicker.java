package com.gmail.seanduffy797.dungeon.builders;

import com.gmail.seanduffy797.dungeon.Pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrickPiecePicker {
    public static Bricks[] halls = {BricksZone1.HALL1, BricksZone1.HALL2, BricksZone1.HALL3, BricksZone1.STAIRDOWN1, BricksZone1.HALL5, BricksZone1.HALL6, BricksZone1.HALL7, BricksZone1.HALL8, BricksZone1.HALL9, BricksZone1.HALL10, BricksZone1.HALL11, BricksZone1.HALL12, BricksZone1.HALL13, BricksZone1.HALL14, BricksZone1.HALL15, BricksZone1.HALL16, BricksZone1.HALL17, BricksZone1.HALL18, BricksZone1.HALL19, BricksZone1.HALL20, BricksZone1.HALL21, BricksZone1.HALL22, BricksZone1.HALL23, BricksZone1.HALL24, BricksZone1.HALL25, BricksZone1.HALL26, BricksZone1.DOOR1};
    public static Bricks[] narrowHalls = {BricksZone1.HALL1, BricksZone1.HALL2, BricksZone1.HALL3, BricksZone1.HALL11, BricksZone1.HALL12, BricksZone1.HALL13, BricksZone1.HALL14, BricksZone1.HALL15, BricksZone1.HALL16, BricksZone1.HALL17, BricksZone1.HALL18, BricksZone1.HALL19, BricksZone1.HALL23, BricksZone1.HALL24, BricksZone1.HALL25, BricksZone1.HALL26};
    public static Bricks[] earlyHalls = {BricksZone1.HALL1, BricksZone1.HALL2, BricksZone1.HALL5, BricksZone1.HALL11, BricksZone1.HALL12, BricksZone1.HALL18, BricksZone1.HALL23};
    public static Bricks[] ends = {BricksZone1.END2, BricksZone1.END3, BricksZone1.END4, BricksZone1.END5, BricksZone1.END6, BricksZone1.END7, BricksZone1.END8, BricksZone1.END9, BricksZone1.END10, BricksZone1.END11, BricksZone1.END12, BricksZone1.END13};
    public static Bricks[] crosses = {BricksZone1.CROSS1, BricksZone1.CROSS3, BricksZone1.CROSS4, BricksZone1.CROSS9, BricksZone1.CROSS10, BricksZone1.CROSS11, BricksZone1.ARENA};
    public static Bricks[] ts = {BricksZone1.T1, BricksZone1.T2, BricksZone1.T3, BricksZone1.T4, BricksZone1.T5, BricksZone1.T6, BricksZone1.T7, BricksZone1.T8, BricksZone1.T9, BricksZone1.T10, BricksZone1.T11};
    public static Bricks[] turns = {BricksZone1.TURN1,  BricksZone1.TURN2};
    public static Bricks[] rooms = {BricksZone1.ROOM1, BricksZone1.ROOM2, BricksZone1.ROOM3, BricksZone1.ROOM4, BricksZone1.ROOM5, BricksZone1.SHRINE1, BricksZone1.ROOM6, BricksZone1.ROOM7, BricksZone1.ROOM8};

    public static Bricks[] sewer = {BricksZone1.STAIRDOWN1, BricksZone1.STAIRUP1, Sewer.HALL4, Sewer.CROSS2, Sewer.HALLPIPE2T, Sewer.HALLPIPE3CROSS};
    public static Bricks[] sewerHalls = {Sewer.HALL4, Sewer.SEWERHALL2};
    public static Bricks[] sewerEnds = {Sewer.SEWEREND1, Sewer.SEWEREND2};
    public static Bricks[] sewerCrosses = {Sewer.HALLPIPE2T, Sewer.CROSS2, Sewer.HALLPIPE3CROSS};
    public static Bricks[] sewerTs = {Sewer.SEWERT1, Sewer.HALLPIPE2T};
    public static Bricks[] sewerRooms = {Sewer.SEWEREND1, Sewer.SEWEREND2, Sewer.SEWERROOM1, Sewer.SEWERROOM2};

    public static Bricks[] pipe2 = {Pipe.P2HALL1, Pipe.P2HALL2, Pipe.P2TURN1, Pipe.P2T1, Pipe.P2CROSS1, Pipe.P2END1, Pipe.P2END2};
    public static Bricks[] pipe2Halls = {Pipe.P2HALL1, Pipe.P2HALL2};
    public static Bricks[] pipe2Ends = {Pipe.P2END1, Pipe.P2END2};
    public static Bricks[] pipe3 = {Pipe.P3HALL1, Pipe.P3HALL2, Pipe.P3HALL3, Pipe.P3HALL4, Pipe.P3HALL5, Pipe.P3HALL6, Pipe.P3TURN1, Pipe.P3T1, Pipe.P3CROSS1, Pipe.P3CROSS2, Pipe.P3END1, Pipe.P3ROOM1};
    public static Bricks[] pipe3Halls = {Pipe.P3HALL1, Pipe.P3HALL2, Pipe.P3HALL3, Pipe.P3HALL4, Pipe.P3HALL5, Pipe.P3HALL6};
    public static Bricks[] pipe3Ends = {Pipe.P3END1, Pipe.P3ROOM1};

    public static Bricks[] halls2 = {BricksZone2.HALL101, BricksZone2.HALL102, BricksZone2.HALL103, BricksZone2.HALL104, BricksZone2.HALL115, BricksZone2.HALL116, BricksZone2.HALL105, BricksZone2.HALL106, BricksZone2.HALL107, BricksZone2.HALL108, BricksZone2.HALL109, BricksZone2.HALL110, BricksZone2.HALL111, BricksZone2.HALL112, BricksZone2.HALL113, BricksZone2.HALL114};
    public static Bricks[] turns2 = {BricksZone2.TURN101, BricksZone2.TURN102};
    public static Bricks[] ts2 = {BricksZone2.T101, BricksZone2.T102, BricksZone2.T103};
    public static Bricks[] crosses2 = {BricksZone2.CROSS1, BricksZone2.CROSS4, BricksZone2.CROSS6, BricksZone2.CROSS7, BricksZone2.CROSS8};
    public static Bricks[] rooms2 = {BricksZone2.ROOM102, BricksZone1.SHRINE1, BricksZone2.ROOM101, BricksZone2.ROOM103, BricksZone1.ROOM6, BricksZone2.END101};

    public static Bricks[] houses = {BricksZone2.HOUSE3, BricksZone2.HOUSE4, BricksZone2.HOUSE5, BricksZone2.HOUSE6, BricksZone2.HOUSE7, BricksZone2.HOUSE8, BricksZone2.HOUSE9, BricksZone2.HOUSE10, BricksZone2.HOUSE11, BricksZone2.HOUSE12, BricksZone2.HOUSE13, BricksZone2.HOUSE14, BricksZone2.HOUSE15, BricksZone2.HOUSE16, BricksZone2.HOUSE17, BricksZone2.HOUSE18, BricksZone2.HOUSE19, BricksZone2.HOUSE20, BricksZone2.HOUSE21, BricksZone2.HOUSE22, BricksZone2.HOUSE23, BricksZone2.HOUSE24, BricksZone2.HOUSE25, BricksZone2.HOUSE26, BricksZone2.HOUSE27, BricksZone2.HOUSE28, BricksZone2.HOUSE29, BricksZone2.HOUSE30};
    public static Bricks[] houseHalls = {BricksZone2.HOUSEHALL1, BricksZone2.HOUSEHALL2};

    public static Map<Bricks, Integer> counts = new HashMap<>();
    public static Map<Bricks, Integer> weights = new HashMap<>();

    public static boolean flag;

    public static Map<Region, Integer> regionCounts = new HashMap<>();
    public static Map<Region, Integer> openings = new HashMap<>();
    public static Map<Region, ArrayList<Bricks>> necessarys = new HashMap<>();

    public static void init(){
        necessarys.put(Region.BRICK, new ArrayList<>(Arrays.asList(BricksZone1.END5, BricksZone1.END6, BricksZone1.ROOM1, BricksZone1.ROOM2, BricksZone1.ROOM3, BricksZone1.ROOM4, BricksZone1.ROOM5, BricksZone1.SHRINE1, BricksZone1.CROSS3, BricksZone1.CROSS11, BricksZone1.ROOM8)));
        necessarys.put(Region.BRICK2, new ArrayList<>(Arrays.asList(BricksZone2.CROSS7, BricksZone2.HALL104, BricksZone2.HALL115)));
        necessarys.put(Region.SEWER, new ArrayList<>(Arrays.asList(Sewer.CROSS2, Sewer.SEWERROOM1)));

        for(Region region: Region.values()) {
            regionCounts.put(region, 0);
            openings.put(region, 0);
        }
        openings.put(Region.BRICK, 1);
        flag = false;

        for(Bricks piece: BricksZone1.values()) { counts.put(piece, 0); }
        for(Bricks piece: BricksZone2.values()) { counts.put(piece, 0); }
        for(Bricks piece: Sewer.values()) { counts.put(piece, 0); }
        for(Bricks piece: Pipe.values()) { counts.put(piece, 0); }
        for(Bricks piece: BricksZone2.values()) { counts.put(piece, 0); }

        initializeWeights();
    }

    public static void initializeWeights() {
        System.out.println("Testing the build worked");
        weights.put(BricksZone1.HALL1, 2);
        weights.put(BricksZone1.HALL2, 2);
        weights.put(BricksZone1.HALL3, 2);
        weights.put(Sewer.HALL4, 4);
        weights.put(BricksZone1.HALL5, 3);
        weights.put(BricksZone1.HALL6, 5);
        weights.put(BricksZone1.HALL7, 2);
        weights.put(BricksZone1.HALL8, 0);
        weights.put(BricksZone1.HALL9, 4);
        weights.put(BricksZone1.HALL10, 0);
        weights.put(BricksZone1.HALL11, 3);
        weights.put(BricksZone1.HALL12, 3);
        weights.put(BricksZone1.HALL13, 3);
        weights.put(BricksZone1.HALL14, 3);
        weights.put(BricksZone1.HALL15, 3);
        weights.put(BricksZone1.HALL16, 3);
        weights.put(BricksZone1.HALL17, 4);
        weights.put(BricksZone1.HALL18, 1);
        weights.put(BricksZone1.HALL19, 1);
        weights.put(BricksZone1.HALL20, 1);
        weights.put(BricksZone1.HALL21, 2);
        weights.put(BricksZone1.HALL22, 2);
        weights.put(BricksZone1.HALL23, 2);
        weights.put(BricksZone1.HALL24, 1);
        weights.put(BricksZone1.HALL25, 2);
        weights.put(BricksZone1.HALL26, 3);

        weights.put(BricksZone1.DOOR1, 5);

        weights.put(BricksZone1.END0, 0);
        weights.put(BricksZone1.END1, 0);
        weights.put(BricksZone1.END2, 4);
        weights.put(BricksZone1.END3, 3);
        weights.put(BricksZone1.END4, 1);
        weights.put(BricksZone1.END5, 1);
        weights.put(BricksZone1.END6, 1);
        weights.put(BricksZone1.END7, 2);
        weights.put(BricksZone1.END8, 1);
        weights.put(BricksZone1.END9, 2);
        weights.put(BricksZone1.END10, 4);
        weights.put(BricksZone1.END11, 4);
        weights.put(BricksZone1.END12, 2);
        weights.put(BricksZone1.END13, 1);

        weights.put(BricksZone1.CROSS1, 2);
        weights.put(Sewer.CROSS2, 3);
        weights.put(BricksZone1.CROSS3, 0);
        weights.put(BricksZone1.CROSS4, 3);
        weights.put(BricksZone1.CROSS9, 2);
        weights.put(BricksZone1.CROSS10, 0);
        weights.put(BricksZone1.CROSS11, 4);

        weights.put(BricksZone1.ARENA, 0);

        weights.put(BricksZone1.TURN1, 5);
        weights.put(BricksZone1.TURN2, 4);

        weights.put(BricksZone1.T1, 3);
        weights.put(BricksZone1.T2, 4);
        weights.put(BricksZone1.T3, 2);
        weights.put(BricksZone1.T4, 2);
        weights.put(BricksZone1.T5, 1);
        weights.put(BricksZone1.T6, 2);
        weights.put(BricksZone1.T7, 3);
        weights.put(BricksZone1.T8, 4);
        weights.put(BricksZone1.T9, 1);
        weights.put(BricksZone1.T10, 1);
        weights.put(BricksZone1.T11, 1);

        weights.put(BricksZone1.ROOM1, 0);
        weights.put(BricksZone1.ROOM2, 0);
        weights.put(BricksZone1.ROOM3, 1);
        weights.put(BricksZone1.ROOM4, 0);
        weights.put(BricksZone1.ROOM5, 0);
        weights.put(BricksZone1.ROOM6, 2);
        weights.put(BricksZone1.ROOM7, 2);
        weights.put(BricksZone1.ROOM8, 1);
        weights.put(BricksZone1.SHRINE1, 2);

        weights.put(BricksZone1.STAIRDOWN1, 6);
        weights.put(BricksZone1.STAIRDOWNU1, 0);
        weights.put(BricksZone1.STAIRUP1, 2);

        weights.put(Sewer.SEWERTRANSITION, 0);
        weights.put(Sewer.SEWEREND0, 0);
        weights.put(Sewer.SEWEREND1, 10);
        weights.put(Sewer.SEWEREND2, 5);
        weights.put(Sewer.SEWERHALL2, 10);
        weights.put(Sewer.SEWERTURN1, 3);
        weights.put(Sewer.SEWERT1, 4);
        weights.put(Sewer.SEWERROOM1, 2);
        weights.put(Sewer.SEWERROOM2, 2);

        weights.put(Sewer.SEWERBIGPIPE1, 0);
        weights.put(Sewer.BIGPIPEHALL1, 0);
        weights.put(Sewer.BIGPIPETURN1, 0);

        weights.put(Sewer.HALLPIPE2T, 3);
        weights.put(Sewer.HALLPIPE3CROSS, 2);

        weights.put(Pipe.P2HALL1, 3);
        weights.put(Pipe.P2HALL2, 9);
        weights.put(Pipe.P2TURN1, 1);
        weights.put(Pipe.P2T1, 4);
        weights.put(Pipe.P2CROSS1, 3);
        weights.put(Pipe.P2END0, 0);
        weights.put(Pipe.P2END1, 4);
        weights.put(Pipe.P2END2, 3);

        weights.put(Pipe.P3HALL1, 3);
        weights.put(Pipe.P3HALL2, 6);
        weights.put(Pipe.P3HALL3, 6);
        weights.put(Pipe.P3HALL4, 3);
        weights.put(Pipe.P3HALL5, 3);
        weights.put(Pipe.P3HALL6, 5);
        weights.put(Pipe.P3TURN1, 2);
        weights.put(Pipe.P3T1, 6);
        weights.put(Pipe.P3CROSS1, 3);
        weights.put(Pipe.P3CROSS2, 3);
        weights.put(Pipe.P3END0, 0);
        weights.put(Pipe.P3END1, 8);
        weights.put(Pipe.P3ROOM1, 3);

        weights.put(BricksZone2.HALL101, 2);
        weights.put(BricksZone2.HALL102, 4);
        weights.put(BricksZone2.HALL103, 3);
        weights.put(BricksZone2.HALL104, 0);
        weights.put(BricksZone2.HALL115, 1);
        weights.put(BricksZone2.HALL116, 2);

        weights.put(BricksZone2.HALL105, 1);
        weights.put(BricksZone2.HALL106, 2);
        weights.put(BricksZone2.HALL107, 2);
        weights.put(BricksZone2.HALL108, 2);
        weights.put(BricksZone2.HALL109, 2);
        weights.put(BricksZone2.HALL110, 2);
        weights.put(BricksZone2.HALL111, 2);
        weights.put(BricksZone2.HALL112, 2);
        weights.put(BricksZone2.HALL113, 1);
        weights.put(BricksZone2.HALL114, 2);

        weights.put(BricksZone2.TURN101, 2);
        weights.put(BricksZone2.TURN102, 2);

        weights.put(BricksZone2.T101, 1);
        weights.put(BricksZone2.T102, 4);
        weights.put(BricksZone2.T103, 3);

        weights.put(BricksZone2.ROOM101, 1);
        weights.put(BricksZone2.ROOM103, 1); // Out of order for hopefully a good reason- avoid room103 being chosen when all are 0
        weights.put(BricksZone2.ROOM102, 3);

        weights.put(BricksZone2.END101, 3);

        weights.put(BricksZone2.CROSS1, 1);
        weights.put(BricksZone2.CROSS6, 1);
        weights.put(BricksZone2.CROSS7, 3);
        weights.put(BricksZone2.CROSS8, 1);
        weights.put(BricksZone2.CROSS4, 1);

        weights.put(BricksZone2.HOUSE0, 1);
        weights.put(BricksZone2.HOUSE1, 1);
        weights.put(BricksZone2.HOUSE2, 1);
        weights.put(BricksZone2.HOUSE3, 2);
        weights.put(BricksZone2.HOUSE4, 2);
        weights.put(BricksZone2.HOUSE5, 2);
        weights.put(BricksZone2.HOUSE6, 1);
        weights.put(BricksZone2.HOUSE7, 2);
        weights.put(BricksZone2.HOUSE8, 1);
        weights.put(BricksZone2.HOUSE9, 1);
        weights.put(BricksZone2.HOUSE10, 2);
        weights.put(BricksZone2.HOUSE11, 2);
        weights.put(BricksZone2.HOUSE12, 1);
        weights.put(BricksZone2.HOUSE13, 2);
        weights.put(BricksZone2.HOUSE14, 2);
        weights.put(BricksZone2.HOUSE15, 1);
        weights.put(BricksZone2.HOUSE16, 2);
        weights.put(BricksZone2.HOUSE17, 2);
        weights.put(BricksZone2.HOUSE18, 2);
        weights.put(BricksZone2.HOUSE19, 3);
        weights.put(BricksZone2.HOUSE20, 1);
        weights.put(BricksZone2.HOUSE21, 2);
        weights.put(BricksZone2.HOUSE22, 1);
        weights.put(BricksZone2.HOUSE23, 1);
        weights.put(BricksZone2.HOUSE24, 2);
        weights.put(BricksZone2.HOUSE25, 1);
        weights.put(BricksZone2.HOUSE26, 1);
        weights.put(BricksZone2.HOUSE27, 2);
        weights.put(BricksZone2.HOUSE28, 2);
        weights.put(BricksZone2.HOUSE29, 2);
        weights.put(BricksZone2.HOUSE30, 2);
        weights.put(BricksZone2.HOUSEHALL1, 2);
        weights.put(BricksZone2.HOUSEHALL2, 2);
    }

    public static Bricks pick(PieceLayout layout, Region region, int depth, Bricks previous){
        Bricks piece;

        if (depth < 3) {
            piece = getPiece(earlyHalls);
            return piece;
        }
        if (!flag && depth > 6) {
            flag = true;
            weights.put(BricksZone1.ROOM1, 1);
            weights.put(BricksZone1.ROOM2, 1);
            weights.put(BricksZone1.ROOM4, 2);
            weights.put(BricksZone1.ROOM5, 1);
            weights.put(BricksZone1.HALL10, 3);
            weights.put(BricksZone1.CROSS10, 2);
            weights.put(BricksZone1.ARENA, 6);
        }
        if (depth > 10 && counts.get(BricksZone1.CROSS3) == 0) {
            weights.put(BricksZone1.CROSS3, 5);
        }

        if (previous != null && (previous.equals(BricksZone1.STAIRDOWN1) || previous.equals(BricksZone1.STAIRDOWNU1))) {
            if (counts.get(BricksZone1.STAIRDOWN1) < 8) {
                if (layout == PieceLayout.RIGHTTURN || layout == PieceLayout.LEFTTURN || layout == PieceLayout.END){
                    piece = BricksZone1.STAIRDOWNU1;
                } else {
                    piece = BricksZone1.STAIRDOWN1;
                }
            } else {
                piece = Sewer.SEWERTRANSITION;
            }
            return piece;
        }

        if (region == Region.PIPE2) {
            piece = pickPipe2Piece(layout);
        } else if (region == Region.PIPE3) {
            piece = pickPipe3Piece(layout);
        } else if (region == Region.BRICK2) {
            piece = pickZone2Piece(layout);
        } else if (region == Region.HOUSE) {
            piece = pickHousePiece(layout);
        } else if (region == Region.SEWER) {
            piece = pickSewerPiece(layout);
        } else {
            piece = pickZone1Piece(layout);
        }

        return piece;
    }

    public static Bricks replace(Region region, int tries, Bricks piece) {
        if (region == Region.BRICK || region == Region.BRICK2) {
            if (tries == 1) {
                return getPiece(narrowHalls);
            } else if (tries == 2) {
                return getPiece(ends);
            } else if (tries == 3) {
                return BricksZone1.END1;
            } else {
                return BricksZone1.END0;
            }
        } else if (region.equals(Region.SEWER)) {
            if (piece == BricksZone1.STAIRDOWN1 || piece == BricksZone1.STAIRDOWNU1) {
                weights.put(BricksZone1.STAIRDOWN1, 8);
                counts.put(BricksZone1.STAIRDOWN1, 0);
            }
            if (tries == 1) {
                return getPiece(sewerHalls);
            } else if (tries == 2) {
                return getPiece(sewerEnds);
            } else {
                return Sewer.SEWEREND0;
            }
        } else if (region.equals(Region.PIPE3)) {
            if (tries == 1) {
                return getPiece(pipe3Halls);
            } else if (tries == 2) {
                return getPiece(pipe3Ends);
            } else {
                return Pipe.P3END0;
            }
        } else if (region.equals(Region.PIPE2)) {
            if (tries == 1) {
                return getPiece(pipe2Halls);
            } else if (tries == 2) {
                return getPiece(pipe2Ends);
            } else {
                return Pipe.P2END0;
            }
        } else if (region.equals(Region.HOUSE)) {
            if (tries == 1) {
                return BricksZone2.HOUSE2;
            } else if (tries == 2) {
                return BricksZone2.HOUSE1;
            } else {
                return BricksZone2.HOUSE0;
            }
        } else {
            return BricksZone1.END0;
        }
    }

    public static Bricks pickZone1Piece(PieceLayout layout) {
        Bricks piece = getPiece(halls);

        if ((weights.get(BricksZone1.T1) == 0 || weights.get(BricksZone1.HALL1) == 0 || weights.get(BricksZone1.CROSS4) == 0) && weights.get(BricksZone1.STAIRDOWN1) == 0) {
            if (necessarys.get(Region.BRICK).size() == 0) {
                piece = getPiece(ends);
            } else {
                piece = necessarys.get(Region.BRICK).get(0);
            }
            return piece;
        }

        if(layout == PieceLayout.END) {
            piece = getPiece(ends);
        } else if(layout == PieceLayout.STRAIGHT) {
            piece = getPiece(halls);
        } else if(layout == PieceLayout.ROOM) {
            piece = getPiece(rooms);
        } else if(layout == PieceLayout.LEFTTURN || layout == PieceLayout.RIGHTTURN) {
            piece = getPiece(turns);
        } else if(layout == PieceLayout.LEFT_T || layout == PieceLayout.RIGHT_T) {
            if (Math.random() < 0.45) {
                piece = getPiece(ts);
            } else {
                piece = getPiece(halls);
            }
        } else if(layout == PieceLayout.CROSS) {
            if (openings.get(Region.BRICK) < 3 || (Math.random() < 0.3)) {
                piece = getPiece(crosses);
            } else if (openings.get(Region.BRICK) < 5 || Math.random() < 0.4) {
                piece = getPiece(ts);
            } else if (Math.random() < 0.4) {
                piece = getPiece(halls);
            }else {
                piece = getPiece(rooms);
            }
        }

        return piece;
    }

    public static Bricks pickZone2Piece(PieceLayout layout) {
        Bricks piece = getPiece(halls);

        int total = 0;
        for(Bricks cross: crosses2) {
            total += weights.get(cross);
        }

        if (weights.get(BricksZone2.HALL101) == 0 || weights.get(BricksZone2.HOUSE7) == 0) {
            if (necessarys.get(Region.BRICK2).size() == 0) {
                int totalRooms = 0;
                for(Bricks cross: crosses2) {
                    totalRooms += weights.get(cross);
                }
                if (totalRooms > 0) {
                    piece = getPiece(rooms2);
                } else {
                    piece = getPiece(ends);
                }
            } else {
                piece = necessarys.get(Region.BRICK2).get(0);
            }
            return piece;
        }

        if(layout == PieceLayout.END) {
            piece = getPiece(ends);
        } else if (layout == PieceLayout.CROSS) {
            if (total > 0 && Math.random() < 0.4) {
                piece = getPiece(crosses2);
            } else if (Math.random() < 0.3) {
                piece = getPiece(ts2);
            } else {
                piece = getPiece(halls2);
            }
        } else if (layout == PieceLayout.LEFTTURN || layout == PieceLayout.RIGHTTURN) {
            piece = getPiece(turns2);
        } else if (layout == PieceLayout.RIGHT_T || layout == PieceLayout.LEFT_T) {
            if (Math.random() < 0.2) {
                piece = getPiece(ts2);
            } else {
                piece = getPiece(halls2);
            }
        } else if (layout == PieceLayout.ROOM) {
            piece = getPiece(rooms2);
        } else if (layout == PieceLayout.STRAIGHT) {
            piece = getPiece(halls2);
        }

        return piece;
    }

    public static Bricks pickHousePiece(PieceLayout layout) {
        Bricks piece = getPiece(houses);

        if(weights.get(BricksZone2.HOUSEHALL1) == 0 && weights.get(BricksZone2.HOUSEHALL2) == 0){
            piece = getPiece(houses);
        } else if(layout == PieceLayout.END || layout == PieceLayout.LEFTTURN || layout == PieceLayout.RIGHTTURN) {
            piece = getPiece(houses);
        } else if (layout == PieceLayout.CROSS && Math.random() < 0.3) {
            piece = getPiece(houseHalls);
        } else if (Math.random() < 0.1) {
            piece = getPiece(houseHalls);
        }

        return piece;
    }

    public static Bricks pickSewerPiece(PieceLayout layout) {
        Bricks piece = Sewer.HALL4;

        if (layout == PieceLayout.END) {
            piece = getPiece(sewerEnds);
        } else if (layout == PieceLayout.STRAIGHT) {
            piece = getPiece(sewerHalls);
        } else if (layout == PieceLayout.ROOM) {
            piece = Sewer.SEWERROOM1;
        } else if (layout == PieceLayout.LEFTTURN || layout == PieceLayout.RIGHTTURN) {
            piece = Sewer.SEWERTURN1;
        } else if (layout == PieceLayout.LEFT_T || layout == PieceLayout.RIGHT_T) {
            if (openings.get(Region.SEWER) < 3 || Math.random() < 0.4) {
                piece = getPiece(sewerTs);
            } else {
                piece = getPiece(sewerHalls);
            }
        } else if (layout == PieceLayout.CROSS) {
            piece = getPiece(sewerCrosses);
        }

        if (regionCounts.get(Region.SEWER) > 20) {
            if (necessarys.get(Region.SEWER).size() == 0) {
                piece = getPiece(sewerRooms);
            } else {
                piece = necessarys.get(Region.SEWER).get(0);
            }
        }
        return piece;
    }

    public static Bricks pickPipe3Piece(PieceLayout layout) {
        Bricks piece;
        if (layout == PieceLayout.LEFTTURN || layout == PieceLayout.RIGHTTURN) {
            piece = Pipe.P3TURN1;
        } else {
            piece = getPiece(pipe3);
        }
        return piece;
    }

    public static Bricks pickPipe2Piece(PieceLayout layout) {
        Bricks piece;
        if (layout == PieceLayout.LEFTTURN || layout == PieceLayout.RIGHTTURN) {
            piece = Pipe.P2TURN1;
        } else {
            piece = getPiece(pipe2);
        }
        return piece;
    }

    public static Bricks getPiece(Bricks[] type){
        double total = 0;
        for(Bricks piece: type) {
            total += weights.get(piece);
        }

        // Kinda wonky, this is the weighted random piece picker
        int idx = 0;
        for(double rand = Math.random() * total; idx < type.length - 1; idx++) {
            rand -= weights.get(type[idx]);
            if (rand <= 0.0) {
                break;
            }
        }

        return type[idx];
    }

    public static void update(Bricks placedPiece, Region region) {
        Integer count = counts.get(placedPiece);
        counts.put(placedPiece, count + 1);
        Integer weight = weights.get(placedPiece);
        weights.put(placedPiece, weight - 1);

        if (placedPiece.equals(Sewer.CROSS2)) {
            weights.put(Sewer.CROSS2, 0);
        } else if (placedPiece.equals(BricksZone1.CROSS3)) {
            weights.put(BricksZone1.CROSS3, 0);
        } else if (placedPiece.equals(BricksZone1.ARENA)) {
            weights.put(BricksZone1.ARENA, 0);
        } else if (placedPiece.equals(BricksZone1.CROSS11)) {
            weights.put(BricksZone1.CROSS11, 0);
        } else if (placedPiece == BricksZone1.STAIRDOWN1) {
            weights.put(BricksZone1.STAIRDOWN1, 0);
        } else if (placedPiece == BricksZone2.HOUSE30) {
            weights.put(BricksZone2.HOUSE30, 0);
        } else if (placedPiece == BricksZone2.HALL115) {
            weights.put(BricksZone2.HALL115, 0);
        } else if (placedPiece == BricksZone2.CROSS7) {
            weights.put(BricksZone2.HALL104, 2);
            weights.put(BricksZone2.CROSS7, 0);
        }

        regionCounts.put(region, regionCounts.get(region) + 1);
        openings.put(region, openings.get(region) - 1);
        for (Region exit: placedPiece.getExits().values()) {
            if (exit == Region.INHERIT) {
                exit = region;
            }
            openings.put(exit, openings.get(exit) + 1);
        }
        if (necessarys.containsKey(region)) {
            for (int i = 0; i < necessarys.get(region).size(); i++) {
                Bricks piece = necessarys.get(region).get(i);

                if (placedPiece.equals(piece)) {
                    necessarys.get(region).remove(i);
                    break;
                }
            }
        }
    }
}
