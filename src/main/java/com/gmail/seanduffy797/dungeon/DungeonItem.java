package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.Items.Armor.GladiatorArmor;
import com.gmail.seanduffy797.dungeon.Items.Armor.HuskLeather;
import com.gmail.seanduffy797.dungeon.Items.Armor.RudiariusArmor;
import com.gmail.seanduffy797.dungeon.Items.Armor.SkeletonLeather;
import com.gmail.seanduffy797.dungeon.Items.GladiatorWeapons;
import com.gmail.seanduffy797.dungeon.Items.VindicatorsAxe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import static org.bukkit.Bukkit.getServer;

public enum DungeonItem {

    TELEPORT_PEARL,
    VINDICATORS_AXE (VindicatorsAxe.vindicatorsAxe),
    GLADIATOR_HELMET (GladiatorArmor.helmet),
    GLADIATOR_CHESTPLATE (GladiatorArmor.chestplate),
    GLADIATOR_GREAVES (GladiatorArmor.greaves),
    GLADIATOR_BOOTS (GladiatorArmor.boots),
    GLADIUS (GladiatorWeapons.gladius),
    RUDIS (GladiatorWeapons.rudis),
    SICA (GladiatorWeapons.sica),
    REFLEX_BOW (GladiatorWeapons.reflexBow),
    PALM_BRANCH (GladiatorWeapons.palmBranch),
    RUDIARIUS_HELMET (RudiariusArmor.helmet),
    RUDIARIUS_CHESTPLATE (RudiariusArmor.chestplate),
    RUDIARIUS_GREAVES (RudiariusArmor.greaves),
    RUDIARIUS_BOOTS (RudiariusArmor.boots),
    HUSK_LEATHER_HAT (HuskLeather.hat),
    HUSK_LEATHER_TUNIC (HuskLeather.tunic),
    HUSK_LEATHER_PANTS (HuskLeather.pants),
    HUSK_LEATHER_BOOTS (HuskLeather.boots),
    SKELETON_LEATHER_HAT (SkeletonLeather.hat),
    SKELETON_LEATHER_TUNIC (SkeletonLeather.tunic),
    SKELETON_LEATHER_PANTS (SkeletonLeather.pants),
    SKELETON_LEATHER_BOOTS (SkeletonLeather.boots);

    private final ItemStack itemStack;

    DungeonItem(){
        this.itemStack = null;
    }

    DungeonItem(ItemStack itemStack) {
        this.itemStack = itemStack;
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer()
                .set(DungeonManager.customItemKey, PersistentDataType.STRING, this.name());
    }

    public boolean hasItemStack() {
        return this.itemStack != null;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }
}
