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

public class Flynn extends CustomVillager {
    public Flynn() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.FLETCHER);
        villager.customName(Component.text("Flynn"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.SAVANNA);
        villager.setVillagerLevel(2);
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.FLINT, 3),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.FEATHER, 3),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 1),
                null,
                new ItemStack(Material.ARROW, 6));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 5),
                null,
                new ItemStack(Material.BOW, 1));
        return villager;
    }
}
