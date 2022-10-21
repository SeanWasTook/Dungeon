package com.gmail.seanduffy797.dungeon.curses;

import com.gmail.seanduffy797.dungeon.regions.Region;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import static java.lang.Math.max;

public class Curse {

    public Region region;
    public int minThreshold;
    public int maxThreshold;
    public double probability;
    public int maxCoolDown;
    public PotionEffect effect;
    public Consumer<Player> consumer = null;

    public Map<UUID, Integer> coolDowns = new HashMap<>();

    private Curse(Region region, int minThreshold, int maxThreshold, double probability, int maxCoolDown, PotionEffect effect) {
        this.region = region;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.probability = probability;
        this.maxCoolDown = maxCoolDown;
        this.effect = effect;
    }
    public static Curse constantCurse(Region region, PotionEffect effect) {
        int coolDown = effect.getDuration();
        Curse curse = new Curse(region, 0, -1, 1.0, coolDown - 1, effect);
        return curse;
    }
    public static Curse constantCurse(Region region, int coolDown, Consumer<Player> consumer) {
        Curse curse = new Curse(region, 0, -1, 1.0, coolDown, null);
        curse.consumer = consumer;
        return curse;
    }
    public static Curse warningCurse(Region region, int threshold, TextComponent component) {
        Curse curse = new Curse(region, threshold, threshold + 1, 1.0, 100, null);
        curse.consumer = player -> player.sendActionBar(component);
        return curse;
    }
    public static Curse warningCurse(Region region, int threshold, Consumer<Player> consumer) {
        Curse curse = new Curse(region, threshold, threshold + 1, 1.0, 100, null);
        curse.consumer = consumer;
        return curse;
    }
    public static Curse randomCurse(Region region, int minThreshold, int maxThreshold, double probability, int maxCoolDown, PotionEffect effect) {
        return new Curse(region, minThreshold, maxThreshold, probability, maxCoolDown, effect);
    }
    public static Curse randomCurse(Region region, int minThreshold, int maxThreshold, double probability, int maxCoolDown, Consumer<Player> consumer) {
        Curse curse =  new Curse(region, minThreshold, maxThreshold, probability, maxCoolDown, null);
        curse.consumer = consumer;
        return curse;
    }
    public void invokeCurse(Player player) {
        if (effect != null) {
            player.addPotionEffect(effect);
        }
        if (consumer != null) {
            consumer.accept(player);
        }
        coolDowns.put(player.getUniqueId(), maxCoolDown);
    }
    public boolean checkCurse(UUID uuid, int score) {
        if (!coolDowns.containsKey(uuid)) {
            coolDowns.put(uuid, 0);
        }
        coolDowns.put(uuid, max(coolDowns.get(uuid) - 1, 0));
        if (score < minThreshold || (score > maxThreshold && maxThreshold != -1) || coolDowns.get(uuid) > 0) {
            return false;
        }
        if (probability > .9999) {
            return true;
        }
        return Math.random() < probability;
    }
}
