package com.gmail.seanduffy797.dungeon;

import com.gmail.seanduffy797.dungeon.mobs.*;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

public enum DungeonMob {

    BRICK_HUSK(new BrickHusk()),
    BRICK_SKELETON(new BrickSkeleton()),
    AXE_VINDICATOR(new AxeVindicator()),
    COMMON_SPIDER(new CommonSpider()),
    GUARD_SKELETON(new SkeletonGuard()),
    GLADIATOR_SKELETON(new GladiatorSkeleton()),
    RUDIARIUS(new Rudiarius()),
    CESTUS(new Cestus()),
    DIMACHAERUS(new Dimachaerus()),
    SAGITTARIUS(new Sagittarius()),
    EDITOR(new Editor()),
    GATEKEEPER_SKELETON(new GatekeeperSkeleton()),
    DUNGEON_PIG(new DungeonPig()),
    DUNGEON_LLAMA(new DungeonLlama());

    private final CustomMob mobClass;

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
}
