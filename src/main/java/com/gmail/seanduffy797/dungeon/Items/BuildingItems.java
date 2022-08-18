package com.gmail.seanduffy797.dungeon.Items;

import com.destroystokyo.paper.Namespaced;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BuildingItems {

    public static ItemStack chiseledStonePick;
    public static ArrayList<Namespaced> lights = new ArrayList<>(Arrays.asList(
            Material.TORCH.getKey(),
            Material.WALL_TORCH.getKey(),
            Material.SOUL_TORCH.getKey(),
            Material.SOUL_WALL_TORCH.getKey(),
            Material.CANDLE.getKey(),
            Material.LANTERN.getKey(),
            Material.SOUL_LANTERN.getKey()
    ));

    public static void init() {
        createChiseledStonePick();
    }

    public static ItemStack createChiseledStonePick() {
        chiseledStonePick = new ItemStack(Material.GOLDEN_PICKAXE);
        Damageable meta = (Damageable) chiseledStonePick.getItemMeta();
        meta.setDestroyableKeys(Collections.singletonList(Material.CHISELED_STONE_BRICKS.getKey()));
        meta.setDamage(31);
        meta.displayName(Component.text("Chiseled Stone Brick Pick"));
        chiseledStonePick.setItemMeta(meta);
        return chiseledStonePick;
    }

    public static ItemStack createLightbreakerPick() {
        ItemStack lightbreakerPick = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta meta = lightbreakerPick.getItemMeta();
        meta.setDestroyableKeys(lights);
        meta.displayName(Component.text("Lightbreaker Pick"));
        lightbreakerPick.setItemMeta(meta);
        return lightbreakerPick;
    }
    public static ItemStack createCandleLighter() {
        ItemStack candleLighter = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta meta = candleLighter.getItemMeta();
        meta.setPlaceableKeys(Collections.singletonList(Material.CANDLE.getKey()));
        candleLighter.setItemMeta(meta);
        return candleLighter;
    }
    public static ItemStack createCoalPick() {
        ItemStack coalPick = new ItemStack(Material.GOLDEN_PICKAXE);
        Damageable meta = (Damageable) coalPick.getItemMeta();
        meta.setDestroyableKeys(Collections.singletonList(Material.COAL_ORE.getKey()));
        meta.displayName(Component.text("Coal Pick"));
        coalPick.setItemMeta(meta);
        return coalPick;
    }
    public static ItemStack createNovicePick() {
        ItemStack novicePick = new ItemStack(Material.GOLDEN_PICKAXE);
        Damageable meta = (Damageable) novicePick.getItemMeta();
        meta.setDestroyableKeys(Arrays.asList(Material.COAL_ORE.getKey(), Material.IRON_ORE.getKey()));
        meta.displayName(Component.text("Novice Miner's Pick"));
        novicePick.setItemMeta(meta);
        return novicePick;
    }
}
