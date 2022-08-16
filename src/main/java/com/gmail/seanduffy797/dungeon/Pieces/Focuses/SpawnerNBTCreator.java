package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.DungeonMob;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTCompoundList;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTListCompound;

public class SpawnerNBTCreator {

    public static NBTContainer gladiatorSpawner() {
        NBTContainer container = new NBTContainer();
        container.setInteger("SpawnCount", 1);
        container.setInteger("Delay", 200);
        container.setInteger("MinSpawnDelay", 400);
        container.setInteger("MaxSpawnDelay", 900);
        container.setInteger("MaxNearbyEntities", 6);
        container.setInteger("RequiredPlayerRange", 24);

        NBTCompound spawnData = container.addCompound("SpawnData");
        NBTCompound data = spawnData.addCompound("entity");
        data.setString("id", "skeleton");
        data.setString("CustomName", "{\"text\":\"" + DungeonMob.CESTUS.name() + "\"}");

        NBTCompoundList potentials = container.getCompoundList( "SpawnPotentials");

        NBTListCompound mob1 = potentials.addCompound();
        mob1.setInteger("weight", 1);
        NBTCompound data1 = mob1.addCompound("data");
        NBTCompound skelly1 = data1.addCompound("entity");
        skelly1.setString("id", "skeleton");
        skelly1.setString("CustomName", "{\"text\":\"" + DungeonMob.GLADIATOR_SKELETON.name() + "\"}");

        NBTListCompound mob2 = potentials.addCompound();
        mob2.setInteger("weight", 1);
        NBTCompound data2 = mob2.addCompound("data");
        NBTCompound skelly2 = data2.addCompound("entity");
        skelly2.setString("id", "skeleton");
        skelly2.setString("CustomName", "{\"text\":\"" + DungeonMob.RUDIARIUS.name() + "\"}");

        NBTListCompound mob3 = potentials.addCompound();
        mob3.setInteger("weight", 2);
        NBTCompound data3 = mob3.addCompound("data");
        NBTCompound skelly3 = data3.addCompound("entity");
        skelly3.setString("id", "skeleton");
        skelly3.setString("CustomName", "{\"text\":\"" + DungeonMob.CESTUS.name() + "\"}");

        NBTListCompound mob4 = potentials.addCompound();
        mob4.setInteger("weight", 1);
        NBTCompound data4 = mob4.addCompound("data");
        NBTCompound skelly4 = data4.addCompound("entity");
        skelly4.setString("id", "skeleton");
        skelly4.setString("CustomName", "{\"text\":\"" + DungeonMob.DIMACHAERUS.name() + "\"}");

        NBTListCompound mob5 = potentials.addCompound();
        mob5.setInteger("weight", 2);
        NBTCompound data5 = mob5.addCompound("data");
        NBTCompound skelly5 = data5.addCompound("entity");
        skelly5.setString("id", "skeleton");
        skelly5.setString("CustomName", "{\"text\":\"" + DungeonMob.SAGITTARIUS.name() + "\"}");

        NBTListCompound mob6 = potentials.addCompound();
        mob6.setInteger("weight", 1);
        NBTCompound data6 = mob6.addCompound("data");
        NBTCompound skelly6 = data6.addCompound("entity");
        skelly6.setString("id", "skeleton");
        skelly6.setString("CustomName", "{\"text\":\"" + DungeonMob.EDITOR.name() + "\"}");

        return container;
    }

    public static NBTContainer brickHuskSpawner() {
        NBTContainer container = new NBTContainer();
        container.setInteger("SpawnCount", 3);
        container.setInteger("Delay", 200);
        container.setInteger("MinSpawnDelay", 500);
        container.setInteger("MaxSpawnDelay", 900);
        container.setInteger("MaxNearbyEntities", 4);
        container.setInteger("RequiredPlayerRange", 20);

        NBTCompound spawnData = container.addCompound("SpawnData");
        NBTCompound data = spawnData.addCompound("entity");
        data.setString("id", "husk");
        data.setString("CustomName", "{\"text\":\"" + DungeonMob.BRICK_HUSK.name() + "\"}");

        NBTCompoundList potentials = container.getCompoundList( "SpawnPotentials");

        NBTListCompound mob1 = potentials.addCompound();
        mob1.setInteger("weight", 1);
        NBTCompound data1 = mob1.addCompound("data");
        NBTCompound skelly1 = data1.addCompound("entity");
        skelly1.setString("id", "husk");
        skelly1.setString("CustomName", "{\"text\":\"" + DungeonMob.BRICK_HUSK.name() + "\"}");

        return container;
    }

    public static NBTContainer commonSpiderSpawner() {
        NBTContainer container = new NBTContainer();
        container.setInteger("SpawnCount", 3);
        container.setInteger("Delay", 60);
        container.setInteger("MinSpawnDelay", 500);
        container.setInteger("MaxSpawnDelay", 900);
        container.setInteger("MaxNearbyEntities", 4);
        container.setInteger("RequiredPlayerRange", 21);

        NBTCompound spawnData = container.addCompound("SpawnData");
        NBTCompound data = spawnData.addCompound("entity");
        data.setString("id", "spider");
        data.setString("CustomName", "{\"text\":\"" + DungeonMob.COMMON_SPIDER.name() + "\"}");

        NBTCompoundList potentials = container.getCompoundList( "SpawnPotentials");

        NBTListCompound mob1 = potentials.addCompound();
        mob1.setInteger("weight", 1);
        NBTCompound data1 = mob1.addCompound("data");
        NBTCompound skelly1 = data1.addCompound("entity");
        skelly1.setString("id", "spider");
        skelly1.setString("CustomName", "{\"text\":\"" + DungeonMob.COMMON_SPIDER.name() + "\"}");

        return container;
    }

    public static NBTContainer commonDrownedSpawner() {
        NBTContainer container = new NBTContainer();
        container.setInteger("SpawnCount", 3);
        container.setInteger("Delay", 600);
        container.setInteger("MinSpawnDelay", 700);
        container.setInteger("MaxSpawnDelay", 1500);
        container.setInteger("MaxNearbyEntities", 5);
        container.setInteger("RequiredPlayerRange", 21);

        NBTCompound spawnData = container.addCompound("SpawnData");
        NBTCompound data = spawnData.addCompound("entity");
        data.setString("id", "zombie");
        data.setString("CustomName", "{\"text\":\"" + DungeonMob.COMMON_DROWNED.name() + "\"}");

        NBTCompoundList potentials = container.getCompoundList( "SpawnPotentials");

        NBTListCompound mob1 = potentials.addCompound();
        mob1.setInteger("weight", 1);
        NBTCompound data1 = mob1.addCompound("data");
        NBTCompound skelly1 = data1.addCompound("entity");
        skelly1.setString("id", "zombie");
        skelly1.setString("CustomName", "{\"text\":\"" + DungeonMob.COMMON_DROWNED.name() + "\"}");

        return container;
    }

    public static NBTContainer brickSkeletonSpawner() {
        NBTContainer container = new NBTContainer();
        container.setInteger("SpawnCount", 2);
        container.setInteger("Delay", 150);
        container.setInteger("MinSpawnDelay", 500);
        container.setInteger("MaxSpawnDelay", 900);
        container.setInteger("MaxNearbyEntities", 3);
        container.setInteger("RequiredPlayerRange", 16);

        NBTCompound spawnData = container.addCompound("SpawnData");
        NBTCompound data = spawnData.addCompound("entity");
        data.setString("id", "skeleton");
        data.setString("CustomName", "{\"text\":\"" + DungeonMob.BRICK_SKELETON.name() + "\"}");

        NBTCompoundList potentials = container.getCompoundList( "SpawnPotentials");

        NBTListCompound mob1 = potentials.addCompound();
        mob1.setInteger("weight", 1);
        NBTCompound data1 = mob1.addCompound("data");
        NBTCompound skelly1 = data1.addCompound("entity");
        skelly1.setString("id", "skeleton");
        skelly1.setString("CustomName", "{\"text\":\"" + DungeonMob.BRICK_SKELETON.name() + "\"}");

        return container;
    }
}
