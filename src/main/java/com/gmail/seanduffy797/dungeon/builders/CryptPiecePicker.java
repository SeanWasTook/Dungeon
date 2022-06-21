package com.gmail.seanduffy797.dungeon.builders;

import com.gmail.seanduffy797.dungeon.Pieces.Crypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CryptPiecePicker {

    public static Crypt[] halls = {Crypt.HALL1, Crypt.HALL2, Crypt.HALL3, Crypt.HALL4, Crypt.HALL5, Crypt.HALL6, Crypt.HALL7};
    public static Crypt[] narrowHalls = {Crypt.HALL1, Crypt.HALL2, Crypt.HALL4};
    public static Crypt[] ends = {Crypt.END1, Crypt.END2, Crypt.END3, Crypt.END4, Crypt.END5, Crypt.END6};
    public static Crypt[] crosses = {Crypt.CROSS1, Crypt.CROSS2, Crypt.CROSS3, Crypt.CROSS4};
    public static Crypt[] stairs = {Crypt.STAIR1, Crypt.STAIR2, Crypt.STAIR3};
    public static Crypt[] ts = {Crypt.T1, Crypt.T2};
    public static Crypt[] rooms = {Crypt.ROOM1, Crypt.ROOM2};
    public static Crypt[] lava = {Crypt.LAVAHALL1, Crypt.LAVAHALL2, Crypt.LAVATURN1, Crypt.LAVAT1, Crypt.LAVAROOM1};
    public static Crypt[] doors = {Crypt.DOOR1, Crypt.HALL1};
    public static ArrayList<Crypt> necessary;

    public static Map<Crypt, Integer> counts = new HashMap<>();

    public static Map<Crypt, Integer> weights = new HashMap<>();

    public static int openings;
    public static boolean isLava;
    public static int lavaDepth;
    public static int lavaOpenings;

    public static void init(){
        necessary = new ArrayList<>(Arrays.asList(Crypt.CROSS1, Crypt.CROSS2, Crypt.ROOM1, Crypt.ROOM2, Crypt.HALL3));

        openings = 0;
        isLava = false;
        lavaDepth = 0;
        lavaOpenings = 0;

        for(Crypt piece: Crypt.values()) {
            counts.put(piece, 0);
        }

        initializeWeights();
    }

    public static void initializeWeights(){
        weights.put(Crypt.HALL1, 20);
        weights.put(Crypt.HALL2, 10);
        weights.put(Crypt.HALL3, 0);
        weights.put(Crypt.HALL4, 12);
        weights.put(Crypt.HALL5, 12);
        weights.put(Crypt.HALL6, 0);
        weights.put(Crypt.HALL7, 0);

        weights.put(Crypt.DOOR1, 5);

        weights.put(Crypt.END1, 0);
        weights.put(Crypt.END2, 2);
        weights.put(Crypt.END3, 5);
        weights.put(Crypt.END4, 5);
        weights.put(Crypt.END5, 5);
        weights.put(Crypt.END6, 5);

        weights.put(Crypt.CROSS1, 2);
        weights.put(Crypt.CROSS2, 1);
        weights.put(Crypt.CROSS3, 4);
        weights.put(Crypt.CROSS4, 4);

        weights.put(Crypt.STAIR1, 3);
        weights.put(Crypt.STAIR2, 3);
        weights.put(Crypt.STAIR3, 3);

        weights.put(Crypt.T1, 2);
        weights.put(Crypt.T2, 4);

        weights.put(Crypt.ROOM1, 3);
        weights.put(Crypt.ROOM2, 1);

        weights.put(Crypt.LAVAHALL1, 4);
        weights.put(Crypt.LAVAHALL2, 4);
        weights.put(Crypt.LAVATURN1, 2);
        weights.put(Crypt.LAVAT1, 2);

        weights.put(Crypt.LAVAROOM1, 0);
        weights.put(Crypt.WALL, 0);
    }

    public static Crypt pick(int depth, Crypt previous) {
        Crypt piece;
        Integer weight = 0;
        if (previous != null) {
            weight = weights.get(previous);
            weights.put(previous, weight - 5);
        }

        if (isLava && lavaOpenings > 0) {
            piece = pickLava();
        } else {
            if (depth < 2) {
                piece = getPiece(halls);
            } else if (depth == 2) {
                piece = getPiece(crosses);
                weights.put(Crypt.HALL3, 3);
            } else if (depth > 12) {
                if (necessary.size() == 0) {
                    piece = getPiece(ends);
                } else {
                    if (openings < 4 || Math.random() < 0.1) {
                        piece = necessary.get(0);
                    } else {
                        piece = getPiece(ends);
                    }
                }
            } else if (depth > 3 && depth < 10 && Math.random() < 0.15) {
                piece = getPiece(doors);
            } else if (depth > 4 && Math.random() < 0.3) {
                if (necessary.size() == 0) {
                    if (Math.random() < 0.1) {
                        piece = getPiece(rooms);
                    } else if (Math.random() < .3) {
                        piece = getPiece(halls);
                    } else {
                        piece = getPiece(stairs);
                    }
                } else {
                    if (openings > 5) {
                        piece = getPiece(rooms);
                    } else {
                        piece = getPiece(crosses);
                    }
                }
            } else if (Math.random() < 0.2) {
                piece = getPiece(ts);
            } else if (Math.random() < 0.2) {
                piece = getPiece(stairs);
            } else {
                piece = getPiece(halls);
            }
        }
        if (previous != null) {
            weights.put(previous, weight);
        }
        return piece;
    }

    public static Crypt getPiece(Crypt[] type){
        double total = 0;
        for(Crypt piece: type) {
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

    public static void update(Crypt placedPiece) {
        Integer count = counts.get(placedPiece);
        counts.put(placedPiece, count + 1);
        Integer weight = weights.get(placedPiece);
        weights.put(placedPiece, weight - 1);

        if(!placedPiece.equals(Crypt.END1)){
            isLava = false;
        } else {
            if (isLava) {
                lavaOpenings--;
            }
        }

        if(placedPiece.equals(Crypt.HALL3)){
            isLava = true;
            weights.put(Crypt.HALL3, 0);
            lavaOpenings = 1;
        }
        for(Crypt c: lava) {
            if(placedPiece.equals(c)){
                isLava = true;
                lavaDepth++;
                int lavaExits = placedPiece.getExits().size();
                lavaOpenings = lavaOpenings + lavaExits - 1;
                break;
            }
        }

        int numExits = placedPiece.getExits().size();
        openings = openings + numExits - 1;

        for (int i = 0; i < necessary.size(); i++) {
            Crypt piece = necessary.get(i);

            if (placedPiece.equals(piece)) {
                necessary.remove(i);
                break;
            }
        }
    }

    public static Crypt pickLava() {
        Crypt piece;
        if (lavaDepth < 3) {
            piece = getPiece(lava);
        } else if (lavaDepth > 7) {
            piece = Crypt.LAVAROOM1;
        } else {
            if (Math.random() < 0.5) {
                piece = getPiece(lava);
            } else {
                piece = Crypt.LAVAROOM1;
            }
        }
        return piece;
    }

    public static Crypt getEnd() {
        double rand = Math.random();
        if (rand < 0.2) {
            return Crypt.END2;
        } else if (rand < 0.4) {
            return Crypt.END3;
        } else if (rand < 0.6) {
            return Crypt.END4;
        } else if (rand < 0.8) {
            return Crypt.END5;
        } else {
            return Crypt.END6;
        }
    }
    public static Crypt getRoom() {
        double rand = Math.random();
        if (rand < 0.5) {
            return Crypt.ROOM1;
        } else {
            return Crypt.ROOM2;
        }
    }
    public static Crypt getT(){
        double rand = Math.random();
        if (rand < 0.4) {
            return Crypt.T1;
        } else {
            return Crypt.T2;
        }
    }
    public static Crypt getCross(){
        double rand = Math.random();
        if (rand < 0.2) {
            return Crypt.CROSS1;
        } else if (rand < 0.4){
            return Crypt.CROSS2;
        } else if (rand < 0.7) {
            return Crypt.CROSS3;
        } else {
            return Crypt.CROSS4;
        }
    }
    public static Crypt getHall() {
        double rand = Math.random();
        if (rand < 0.14) {
            return Crypt.HALL1;
        } else if (rand < 0.28) {
            return Crypt.STAIR1;
        } else if (rand < 0.42) {
            return Crypt.HALL3;
        } else if (rand < 0.56) {
            return Crypt.HALL4;
        } else if (rand < 0.70) {
            return Crypt.HALL5;
        } else if (rand < 0.85) {
            return Crypt.STAIR2;
        } else {
            return Crypt.STAIR3;
        }
    }
}
