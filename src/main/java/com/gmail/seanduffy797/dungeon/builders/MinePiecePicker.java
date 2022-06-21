package com.gmail.seanduffy797.dungeon.builders;

import com.gmail.seanduffy797.dungeon.Pieces.Bricks;
import com.gmail.seanduffy797.dungeon.Pieces.Early;
import com.gmail.seanduffy797.dungeon.Pieces.Mine;
import com.gmail.seanduffy797.dungeon.Pieces.Region;

import java.util.HashMap;
import java.util.Map;

import static org.bukkit.Bukkit.getServer;

public class MinePiecePicker {
    public static Mine[] downs = {Early.DOWN1, Early.DOWN2, Early.DOWN3};
    public static Mine[] straights = {Early.STRAIGHT1, Early.STRAIGHT2, Early.STRAIGHT3, Early.STRAIGHT4, Early.STRAIGHT5, Early.STAIRDOWN1, Early.STAIRUP1};
    public static Mine[] ts = {Early.T1};
    public static Mine[] decos = {Early.DECO1, Early.DECO2};
    public static Mine[] crosses = {Early.CROSS1, Early.CROSS2, Early.CROSS3};

    public static Map<Mine, Integer> weights = new HashMap<>();

    // This is a weird one: I want to try to prevent the vertical shafts from all being the same length,
    // so when one shaft ends I decrease the odds of the next one ending using this variable
    public static double modifyHeight = 0;

    public static void init() {
        initializeWeights();
    }

    public static void initializeWeights() {
        weights.put(Early.DOWN1, 0);
        weights.put(Early.DOWN2, 30);
        weights.put(Early.DOWN3, 4);

        weights.put(Early.TRANSITION1, 0);

        weights.put(Early.STRAIGHT1, 45);
        weights.put(Early.STRAIGHT2, 45);
        weights.put(Early.STRAIGHT3, 45);
        weights.put(Early.STRAIGHT4, 10);
        weights.put(Early.STRAIGHT5, 20);

        weights.put(Early.T1, 50);

        weights.put(Early.STAIRDOWN1, 30);
        weights.put(Early.STAIRUP1, 30);

        weights.put(Early.DECO1, 5);
        weights.put(Early.DECO2, 15);

        weights.put(Early.CROSS1, 25);
        weights.put(Early.CROSS2, 10);
        weights.put(Early.CROSS3, 4);
    }

    public static Mine pick(int depth, Region region, Mine previous) {
        Mine piece;
        boolean shaft = false;

        for (Mine down: downs) {
            if (down == previous){
                shaft = true;
            }
        }

        if (depth == 0) {
            shaft = true;
        }

        if(shaft) {
            if (depth < 5) {
                piece = getPiece(downs);
            } else if (depth > 13) {
                piece = Early.TRANSITION1;
            } else {
                double rand = Math.random();
                if (rand < (0.4 - modifyHeight)) {
                    piece = Early.TRANSITION1;
                    modifyHeight += 0.15;
                } else {
                    piece = getPiece(downs);
                }
            }
        } else if (region == Region.MINE_DECO) {
            piece = getPiece(decos);
        } else if (depth > 30) {
            piece = null;
        } else {
            double rand = Math.random();
            if (rand < 0.8 && weights.get(Early.STRAIGHT1) != 0) {
                piece = getPiece(straights);
            } else if (rand < 0.85 && weights.get(Early.T1) != 0) {
                piece = getPiece(ts);
            } else if (weights.get(Early.CROSS1) != 0) {
                piece = getPiece(crosses);
            } else {
                piece = null;
            }
        }

        return piece;
    }

    public static Mine getPiece(Mine[] type){
        double total = 0;
        for(Mine piece: type) {
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

    public static void update(Mine placedPiece) {
        Integer weight = weights.get(placedPiece);
        weights.put(placedPiece, weight - 1);
    }
}
