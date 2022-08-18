package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.Pieces.Mine;
import com.gmail.seanduffy797.dungeon.mobs.*;
import com.gmail.seanduffy797.dungeon.mobs.villagers.*;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

public enum DungeonMob {

    BRICK_HUSK(new BrickHusk()),
    BRICK_SKELETON(new BrickSkeleton()),
    AXE_VINDICATOR(new AxeVindicator()),
    COMMON_SPIDER(new CommonSpider()),
    COMMON_DROWNED(new CommonDrowned()),
    TRIDENT_DROWNED(new TridentDrowned()),
    GUARD_SKELETON(new SkeletonGuard()),
    PERSISTENT_ZOMBIE_VILLAGER(new PersistentZombieVillager()),
    PERSISTENT_PILLAGER(new PersistentPillager()),
    GLADIATOR_SKELETON(new GladiatorSkeleton()),
    RUDIARIUS(new Rudiarius()),
    CESTUS(new Cestus()),
    DIMACHAERUS(new Dimachaerus()),
    SAGITTARIUS(new Sagittarius()),
    EDITOR(new Editor()),
    GATEKEEPER_SKELETON(new GatekeeperSkeleton()),
    APOTHECARY(new Apothecary()),
    ARMOR_MERCHANT(new ArmorMerchant()),
    BAKER(new Baker()),
    BUNDLE_MERCHANT(new BundleMerchant()),
    BUTCHER(new Butcher()),
    CANDLESTICK_MAKER(new CandlestickMaker()),
    HABADASHER(new Habadasher()),
    WEAPON_MERCHANT(new WeaponMerchant()),
    BLACKSMITH(new Blacksmith()),
    LIEUTENANT(new Lieutenant()),
    MINE_FOREMAN(new MineForeman()),
    BRUNHILDE(new Brunhilde()),
    FLYNN(new Flynn()),
    GRISHA(new Grisha()),
    LUXAN(new Luxan()),
    ROSANDE(new Rosande()),
    SETTE(new Sette()),
    VEAL(new Veal()),
    WYATT(new Wyatt()),
    JEREMIAH(new Jeremiah()),
    DUNGEON_MOOSHROOM(new DungeonMooshroom()),
    BABY_MOOSHROOM(new BabyMooshroom()),
    DUNGEON_PIG(new DungeonPig()),
    DUNGEON_LLAMA(new DungeonLlama());

    private final CustomMob mobClass;
    public static final NamespacedKey customId = new NamespacedKey(Dungeon.getPlugin(), "customId");

    DungeonMob(CustomMob mobClass) {
        this.mobClass = mobClass;
    }

    public Entity spawn(Location location) {
        Entity entity = mobClass.spawn(location);
        entity.getPersistentDataContainer().set(
                DungeonManager.customMobKey, PersistentDataType.STRING, this.name());
        EntityManager.addEntity(entity);
        return entity;
    }
    public Entity spawn(Location location, int id) {
        Entity entity = spawn(location);
        entity.getPersistentDataContainer().set(
                customId, PersistentDataType.INTEGER, id);
        return entity;
    }
}
