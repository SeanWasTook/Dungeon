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

public class Sette extends CustomVillager {
    public Sette() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.FISHERMAN);
        villager.customName(Component.text("Sette"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.SAVANNA);
        villager.setVillagerLevel(2);
        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.BEETROOT, 6),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.BREAD, 2),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.CARROT, 3),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.MUSHROOM_STEW, 1),
                null,
                new ItemStack(Material.EMERALD, 1));
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 22),
                null,
                DungeonItem.ANCIENT_GOLD_AXE.getItemStack(),
                1);
        return villager;
    }
}

