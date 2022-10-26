package com.gmail.seanduffy797.dungeon.curses;

import com.gmail.seanduffy797.dungeon.regions.Region;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CurseManager {

    public static Map<Region, ArrayList<Curse>> curses = new HashMap<>();
    // Important to note that curses can be either positive or negative
    public static void init() {
        curses.put(Region.SPAWN, new ArrayList<>());
        curses.put(Region.BRICK, new ArrayList<>());
        curses.put(Region.STONE_BRICK, new ArrayList<>());
        curses.put(Region.MINE, new ArrayList<>());

        curses.get(Region.SPAWN).add(Curse.constantCurse(
                Region.SPAWN,
                new PotionEffect(PotionEffectType.SATURATION, 100, 0)
        ));
        curses.get(Region.SPAWN).add(Curse.constantCurse(
                Region.SPAWN,
                new PotionEffect(PotionEffectType.REGENERATION, 100, 0)
        ));
        curses.get(Region.BRICK).add(Curse.randomCurse(
                Region.BRICK,
                20000,
                -1,
                .002,
                400,
                new PotionEffect(PotionEffectType.HUNGER, 200, 0)
        ));
        curses.get(Region.BRICK).add(Curse.randomCurse(
                Region.BRICK,
                30000,
                -1,
                .002,
                400,
                new PotionEffect(PotionEffectType.CONFUSION, 200, 0)
        ));
        curses.get(Region.BRICK).add(Curse.warningCurse(
                Region.BRICK,
                19000,
                Component.text("You feel a twisting in your stomach")
        ));
        curses.get(Region.STONE_BRICK).add(Curse.randomCurse(
                Region.STONE_BRICK,
                14000,
                -1,
                .002,
                400,
                new PotionEffect(PotionEffectType.BLINDNESS, 150, 0)
        ));
        curses.get(Region.STONE_BRICK).add(Curse.randomCurse(
                Region.STONE_BRICK,
                14000,
                -1,
                .001,
                900,
                player -> player.sendMessage(Component.text("OOOOooooOOOOoooooOOOOoooo"))
        ));
    }
    public static void dispatchCurse(Player player, Region region, int regionScore) {
        if (curses.containsKey(region)) {
            UUID uuid = player.getUniqueId();
            for (Curse curse: curses.get(region)) {
                if (curse.checkCurse(uuid, regionScore)) {
                    curse.invokeCurse(player);
                }
            }
        }
    }
}
