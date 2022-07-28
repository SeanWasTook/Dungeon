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

public class ArmorMerchant extends CustomVillager {

    public ArmorMerchant() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.ARMORER);
        villager.customName(Component.text("Armor Merchant"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.TAIGA);
        villager.setVillagerLevel(3);
        villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0);
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 10),
                null,
                new ItemStack(Material.LEATHER_HELMET));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 20),
                null,
                new ItemStack(Material.LEATHER_CHESTPLATE));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 15),
                null,
                new ItemStack(Material.LEATHER_LEGGINGS));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 10),
                null,
                new ItemStack(Material.LEATHER_BOOTS));
        return villager;
    }
}
