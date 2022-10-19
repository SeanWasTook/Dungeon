package com.gmail.seanduffy797.dungeon.curses;

import com.gmail.seanduffy797.dungeon.Pieces.Region;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CurseManager {

    public static Map<Region, ArrayList<Curse>> curses = new HashMap<>();
    // Important to note that curses can be either positive or negative
    public static void init() {
        curses.put(Region.BRICK, new ArrayList<>());
        curses.put(Region.STONE_BRICK, new ArrayList<>());
        curses.put(Region.MINE, new ArrayList<>());

        curses.get(Region.BRICK).add(new Curse(
                Region.BRICK,
                5000,
                new PotionEffect(PotionEffectType.HUNGER, 100, 0)));
        curses.get(Region.BRICK).add(new Curse(
                Region.BRICK,
                7000,
                new PotionEffect(PotionEffectType.CONFUSION, 200, 0)));
        curses.get(Region.STONE_BRICK).add(new Curse(
                Region.STONE_BRICK,
                5000,
                new PotionEffect(PotionEffectType.BLINDNESS, 200, 0)));
        curses.get(Region.STONE_BRICK).add(new Curse(
                Region.STONE_BRICK,
                5000,
                player -> player.sendMessage(ChatColor.GRAY + "OOOOoooooOOOoooOOOooo")));
    }
    public static void dispatchCurse(Player player, Region region, int regionScore) {
        if (curses.containsKey(region)) {
            for (Curse curse: curses.get(region)) {
                if (regionScore > curse.minThreshold && Math.random() < .001) {
                    curse.invokeCurse(player);
                }
            }
        }
    }
}
