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

public class Luxan extends CustomVillager {
    public Luxan() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.TOOLSMITH);
        villager.customName(Component.text("Luxan"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.SAVANNA);
        villager.setVillagerLevel(2);
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                DungeonItem.SOUL_TORCH.getItemStackNoNBT(10));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                DungeonItem.TORCH.getItemStackNoNBT(6));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                DungeonItem.SOUL_LANTERN.getItemStackNoNBT(3));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                DungeonItem.LANTERN.getItemStackNoNBT(1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 3),
                null,
                DungeonItem.LIGHTBREAKER_PICK.getItemStack());
        return villager;
    }
}

