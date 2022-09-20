package com.gmail.seanduffy797.dungeon.Items;

import com.destroystokyo.paper.Namespaced;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTStringList;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        ItemStack coalPick = new ItemStack(Material.WOODEN_PICKAXE);
        Damageable meta = (Damageable) coalPick.getItemMeta();
        meta.setDestroyableKeys(Collections.singletonList(Material.COAL_ORE.getKey()));
        meta.displayName(Component.text("Coal Pick"));
        coalPick.setItemMeta(meta);
        return coalPick;
    }
    public static ItemStack createNovicePick() {
        ItemStack novicePick = new ItemStack(Material.STONE_PICKAXE);
        Damageable meta = (Damageable) novicePick.getItemMeta();
        meta.setDestroyableKeys(Arrays.asList(Material.COAL_ORE.getKey(), Material.IRON_ORE.getKey()));
        meta.displayName(Component.text("Novice Miner's Pick"));
        novicePick.setItemMeta(meta);
        return novicePick;
    }
    public static ItemStack createExcavator() {
        ItemStack excavator = new ItemStack(Material.STONE_SHOVEL);
        Damageable meta = (Damageable) excavator.getItemMeta();
        meta.setDestroyableKeys(Collections.singletonList(Material.GRAVEL.getKey()));
        meta.displayName(Component.text("Excavator"));
        excavator.setItemMeta(meta);
        return excavator;
    }

    public static ItemStack createShroomHoe() {
        ItemStack shroomHoe = new ItemStack(Material.WOODEN_HOE);
        Damageable meta = (Damageable) shroomHoe.getItemMeta();
        meta.setDestroyableKeys(Arrays.asList(Material.BROWN_MUSHROOM.getKey(), Material.RED_MUSHROOM.getKey()));
        meta.displayName(Component.text("Shroom Hoe"));
        shroomHoe.setItemMeta(meta);
        return shroomHoe;
    }

    public static ItemStack createFarmingHoe() {
        ItemStack farmingHoe = new ItemStack(Material.STONE_HOE);
        Damageable meta = (Damageable) farmingHoe.getItemMeta();
        meta.setDestroyableKeys(Arrays.asList(Material.BROWN_MUSHROOM.getKey(),
                Material.RED_MUSHROOM.getKey(),
                Material.BEETROOTS.getKey(),
                Material.WHEAT.getKey(),
                Material.CARROTS.getKey(),
                Material.POTATOES.getKey()));
        meta.displayName(Component.text("Farming Hoe"));
        farmingHoe.setItemMeta(meta);
        return farmingHoe;
    }

    public static ItemStack spawnerDestroyer() {
        ItemStack spawnerDestroyer = new ItemStack(Material.GOLDEN_AXE);
        Damageable meta = (Damageable) spawnerDestroyer.getItemMeta();
        meta.setDestroyableKeys(Collections.singletonList(Material.SPAWNER.getKey()));
        meta.displayName(Component.text("Spawner Destroyer"));
        spawnerDestroyer.setItemMeta(meta);
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("Can Break Monster Spawners").color(NamedTextColor.GOLD));
        spawnerDestroyer.lore(lore);
        return spawnerDestroyer;
    }

    public static ItemStack createRailPick() {
        ItemStack railPick = new ItemStack(Material.STONE_PICKAXE);
        Damageable meta = (Damageable) railPick.getItemMeta();
        meta.displayName(Component.text("Rail Pick"));
        railPick.setItemMeta(meta);
        NBTItem nbti = new NBTItem(railPick);
        NBTStringList blocks = (NBTStringList) nbti.getStringList("CanDestroy");
        blocks.add("#minecraft:rails");
        railPick = nbti.getItem();
        return railPick;
    }
}
