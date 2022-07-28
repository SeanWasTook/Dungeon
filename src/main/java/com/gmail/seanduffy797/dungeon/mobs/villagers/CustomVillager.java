package com.gmail.seanduffy797.dungeon.mobs.villagers;

import com.gmail.seanduffy797.dungeon.mobs.CustomMob;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class CustomVillager extends CustomMob {

    public static void addTrade(Villager villager, ItemStack input1, @Nullable ItemStack input2, ItemStack output) {
        MerchantRecipe newRecipe = new MerchantRecipe(output, 99999999);
        newRecipe.addIngredient(input1);
        if(input2 != null) {
            newRecipe.addIngredient(input2);
        }

        List<MerchantRecipe> newRecipes = new ArrayList<>(villager.getRecipes());
        newRecipes.add(newRecipe);
        villager.setRecipes(newRecipes);
    }
}
