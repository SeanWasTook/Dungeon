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

public class Veal extends CustomVillager {
    public Veal() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.FARMER);
        villager.customName(Component.text("Veal"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.SAVANNA);
        villager.setVillagerLevel(2);
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                new ItemStack(Material.BEETROOT, 5));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.BEETROOT_SEEDS, 10),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.WHEAT_SEEDS, 10),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.CARROT, 2),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                new ItemStack(Material.BREAD, 2));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 10),
                null,
                DungeonItem.RARE_STEAK.getItemStack());
        return villager;
    }
}
