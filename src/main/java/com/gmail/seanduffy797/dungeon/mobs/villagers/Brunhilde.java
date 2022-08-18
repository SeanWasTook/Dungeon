package com.gmail.seanduffy797.dungeon.mobs.villagers;

import com.gmail.seanduffy797.dungeon.DungeonItem;
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

public class Brunhilde extends CustomVillager {
    public Brunhilde() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.WEAPONSMITH);
        villager.customName(Component.text("Brunhilde"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.SAVANNA);
        villager.setVillagerLevel(4);
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 12),
                null,
                new ItemStack(Material.STONE_AXE, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 12),
                null,
                new ItemStack(Material.STONE_SWORD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 44),
                null,
                DungeonItem.BRUNHILDES_FURY.getItemStack());
        return villager;
    }
}
