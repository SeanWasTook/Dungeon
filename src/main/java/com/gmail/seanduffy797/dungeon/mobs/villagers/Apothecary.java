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
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class Apothecary extends CustomVillager {

    public Apothecary() {}

    public Entity spawn(Location location) {
        Villager villager = (Villager) DungeonManager.world.spawnEntity(location, EntityType.VILLAGER);
        villager.setProfession(Villager.Profession.CLERIC);
        villager.customName(Component.text("Apothecary"));
        villager.setPersistent(true);
        villager.setVillagerType(Villager.Type.SWAMP);
        villager.setVillagerLevel(3);
        villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0);

        List<MerchantRecipe> newRecipes = new ArrayList<>();
        villager.setRecipes(newRecipes);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 3),
                null,
                new ItemStack(Material.HONEY_BOTTLE));

        ItemStack item1 = new ItemStack(Material.POTION);
        PotionMeta potionMeta1 = (PotionMeta) item1.getItemMeta();
        potionMeta1.setBasePotionData(new PotionData(PotionType.REGEN));
        item1.setItemMeta(potionMeta1);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 15),
                null,
                item1);

        ItemStack item2 = new ItemStack(Material.POTION);
        PotionMeta potionMeta2 = (PotionMeta) item2.getItemMeta();
        potionMeta2.setBasePotionData(new PotionData(PotionType.SPEED));
        item2.setItemMeta(potionMeta2);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 15),
                null,
                item2);

        ItemStack item3 = new ItemStack(Material.POTION);
        PotionMeta potionMeta3 = (PotionMeta) item3.getItemMeta();
        potionMeta3.setBasePotionData(new PotionData(PotionType.NIGHT_VISION));
        item3.setItemMeta(potionMeta3);
        CustomVillager.addTrade(villager,
                new ItemStack(Material.EMERALD, 15),
                null,
                item3);
        return villager;
    }
}
