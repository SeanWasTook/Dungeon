package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.tasks.TaskList;
import com.gmail.seanduffy797.dungeon.tasks.FillChests;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;
import static org.bukkit.Bukkit.getWorld;

public class Chest extends Focus {

    public Loot lootType;
    public boolean refill;
    public int refillCoolDown;
    public boolean prime; // If true, the chest will be filled upon loading in.
    // If false, it will not be refilled until after the cooldown has passed

    public Chest(Location location, Loot type) {
        this.location = location;
        this.lootType = type;
        this.refill = false;
        this.refillCoolDown = 0;
        this.prime = true;
    }

    public Chest(Location location, Loot type, boolean prime, int coolDown) {
        this.location = location;
        this.lootType = type;
        this.refill = true;
        this.refillCoolDown = coolDown;
        this.prime = prime;
    }

    public Chest(Location location, Loot type, int coolDown, boolean prime, boolean refill) {
        this.location = location;
        this.lootType = type;
        this.refill = refill;
        this.refillCoolDown = coolDown;
        this.prime = prime;
    }

    public Chest makeCopy(Focus chest) {
        if (chest instanceof Chest) {
            Chest other = (Chest) chest;
            return new Chest(other.location.clone(), other.lootType, other.refillCoolDown, other.prime, other.refill);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        Plugin plugin = Dungeon.getPlugin();
        if(prime) {
            BukkitTask task = new FillChests(location, lootType.getPath())
                    .runTaskLater(plugin, 400L);
        }
        if(refill) {
            BukkitTask dungeonTick = new FillChests(location, lootType.getPath())
                    .runTaskTimer(plugin, 400L < refillCoolDown ? refillCoolDown : 400L, refillCoolDown);
            TaskList.tasks.add(dungeonTick);
        }
    }
}
