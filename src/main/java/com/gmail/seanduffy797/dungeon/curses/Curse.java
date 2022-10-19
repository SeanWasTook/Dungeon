package com.gmail.seanduffy797.dungeon.curses;

import com.gmail.seanduffy797.dungeon.Pieces.Region;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.lang.reflect.Method;
import java.util.function.Consumer;

public class Curse {

    public Region region;
    public int minThreshold;
    public double probabilityMultiplier = 1.0;
    public PotionEffect effect = null;
    public Consumer<Player> consumer = null;

    public Curse(Region region, int minThreshold, PotionEffect effect) {
        this.region = region;
        this.minThreshold = minThreshold;
        this.effect = effect;
    }
    public Curse(Region region, int minThreshold, Consumer<Player> consumer) {
        this.region = region;
        this.minThreshold = minThreshold;
        this.consumer = consumer;
    }
    public void invokeCurse(Player player) {
        if (effect != null) {
            player.addPotionEffect(effect);
        }
        if (consumer != null) {
            consumer.accept(player);
        }
    }
}
