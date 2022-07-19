package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.Items.Armor.HuskLeather;
import com.gmail.seanduffy797.dungeon.Items.Armor.SkeletonLeather;
import com.gmail.seanduffy797.dungeon.Items.VindicatorsAxe;
import org.bukkit.inventory.ItemStack;

public enum DungeonItem {

    TELEPORT_PEARL,
    VINDICATORS_AXE (VindicatorsAxe.vindicatorsAxe),
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
    }

    public boolean hasItemStack() {
        return this.itemStack != null;
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }
}
