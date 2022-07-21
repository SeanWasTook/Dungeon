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
        container.setInteger("Delay", 60);
        container.setInteger("MinSpawnDelay", 300);
        container.setInteger("MaxSpawnDelay", 600);
        container.setInteger("MaxNearbyEntities", 8);
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
}
