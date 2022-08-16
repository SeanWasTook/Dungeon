package com.gmail.seanduffy797.dungeon.mobs.villagers;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class Blacksmith extends CustomVillager {

    public Blacksmith() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.TOOLSMITH);
        villager.customName(Component.text("Blacksmith"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.TAIGA);
        villager.setVillagerLevel(3);
        villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0);
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.COAL, 10),
                null,
                new ItemStack(Material.EMERALD));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.RAW_IRON, 3),
                null,
                new ItemStack(Material.EMERALD));
        return villager;
    }
}
