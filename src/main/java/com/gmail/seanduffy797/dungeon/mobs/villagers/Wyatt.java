package com.gmail.seanduffy797.dungeon.mobs.villagers;

import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class Wyatt extends CustomVillager {
    public Wyatt() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.FARMER);
        villager.customName(Component.text("Wyatt"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.SAVANNA);
        villager.setVillagerLevel(3);
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.STONE_SWORD, 1),
                null,
                new ItemStack(Material.EMERALD, 9));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                new ItemStack(Material.BEETROOT, 5));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                new ItemStack(Material.BOWL, 1));
        return villager;
    }
}
