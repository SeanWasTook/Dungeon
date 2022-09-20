package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.Items.*;
import com.gmail.seanduffy797.dungeon.Items.Armor.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.function.Supplier;

public enum DungeonItem {

    TELEPORT_PEARL,
    GUARD_BOW (Weapons::createGuardBow),
    PILLAGER_CROSSBOW (Weapons::createPillagerCrossbow),
    ARACHNICIDE (Weapons::createArachnicide),
    ACHILLOBATOR (Weapons::createAchillobator),
    VINDICATORS_AXE (VindicatorsAxe::createAxe),
    BRUNHILDES_FURY (Weapons::createBrunhildesFury),
    ANCIENT_GOLD_AXE (Weapons::createAncientGoldAxe),
    SKELETON_KEY (Keys::createSkeletonKey),
    BASEMENT_KEY (Keys::createBasementKey),
    OLD_KEY (Keys::createOldKey),
    CHISELED_STONE_PICK (BuildingItems::createChiseledStonePick),
    LIGHTBREAKER_PICK (BuildingItems::createLightbreakerPick),
    COAL_PICK (BuildingItems::createCoalPick),
    NOVICE_PICK (BuildingItems::createNovicePick),
    EXCAVATOR (BuildingItems::createExcavator),
    SHROOM_HOE (BuildingItems::createShroomHoe),
    FARMING_HOE (BuildingItems::createFarmingHoe),
    SPAWNER_DESTROYER (BuildingItems::spawnerDestroyer),
    RAIL_PICK (BuildingItems::createRailPick),
    RAILS (Placeables::createRails),
    POWERED_RAILS (Placeables::createPoweredRails),
    ACTIVATOR_RAILS (Placeables::createActivatorRails),
    DETECTOR_RAILS (Placeables::createDetectorRails),
    SEA_PICKLES (Placeables::createSeaPickles),
    LILY_PAD (Placeables::createLilyPad),
    MINECART (Placeables::createMinecart),
    CANDLE_LIGHTER (BuildingItems::createCandleLighter),
    TORCH (Torch::createTorch),
    SOUL_TORCH (Torch::createSoulTorch),
    LANTERN (Torch::createLantern),
    SOUL_LANTERN (Torch::createSoulLantern),
    CANDLE (Torch::createCandle),
    WATER_HAT (Hats::createWaterHat),
    FIRE_HAT (Hats::createFireHat),
    PROJECTILE_HAT (Hats::createProjectileHat),
    BLAST_HAT (Hats::createBlastHat),
    GLADIATOR_HELMET (GladiatorArmor::createHelmet),
    GLADIATOR_CHESTPLATE (GladiatorArmor::createChestplate),
    GLADIATOR_GREAVES (GladiatorArmor::createGreaves),
    GLADIATOR_BOOTS (GladiatorArmor::createBoots),
    GLADIUS (GladiatorWeapons::createGladius),
    RUDIS (GladiatorWeapons::createRudis),
    SICA (GladiatorWeapons::createSica),
    REFLEX_BOW (GladiatorWeapons::createReflexBow),
    PALM_BRANCH (GladiatorWeapons::createPalmBranch),
    RUDIARIUS_HELMET (RudiariusArmor::createHelmet),
    RUDIARIUS_CHESTPLATE (RudiariusArmor::createChestplate),
    RUDIARIUS_GREAVES (RudiariusArmor::createGreaves),
    RUDIARIUS_BOOTS (RudiariusArmor::createBoots),
    HUSK_LEATHER_HAT (HuskLeather::createHat),
    HUSK_LEATHER_TUNIC (HuskLeather::createTunic),
    HUSK_LEATHER_PANTS (HuskLeather::createPants),
    HUSK_LEATHER_BOOTS (HuskLeather::createBoots),
    SKELETON_LEATHER_HAT (SkeletonLeather::createHat),
    SKELETON_LEATHER_TUNIC (SkeletonLeather::createTunic),
    SKELETON_LEATHER_PANTS (SkeletonLeather::createPants),
    SKELETON_LEATHER_BOOTS (SkeletonLeather::createBoots),
    SPECIAL_LEATHER_HAT (SpecialLeather::createSpecialLeatherHat),
    JEREMIAHS_SOUP (FoodItems::createJeremiahsSoup),
    RARE_STEAK (FoodItems::createRareSteak);

    private final Supplier<ItemStack> supplier;

    DungeonItem(){
        this.supplier = null;
    }

    DungeonItem(Supplier<ItemStack> supplier) {
        this.supplier = supplier;
    }

    public boolean hasItemStack() {
        return this.supplier != null;
    }

    public ItemStack getItemStack() {
        return this.getItemStack(1);
    }
    public ItemStack getItemStack(int count) {
        if (this.supplier != null) {
            ItemStack item = this.supplier.get();
            item.setAmount(count);
            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer()
                    .set(DungeonManager.customItemKey, PersistentDataType.STRING, this.name());
            item.setItemMeta(meta);
            return item;
        } else {
            return null;
        }
    }
    // This is hacky and should be phased out, but it's a good band-aid fix
    // Makes custom items stack with vanilla items
    public ItemStack getItemStackNoNBT(int count) {
        if (this.supplier != null) {
            ItemStack item = this.supplier.get();
            item.setAmount(count);
            return item;
        } else {
            return null;
        }
    }
}
