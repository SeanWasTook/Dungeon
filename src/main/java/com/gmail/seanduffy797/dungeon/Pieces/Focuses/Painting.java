package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.tasks.SummonPainting;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import static org.bukkit.Bukkit.getPluginManager;

public class Painting extends Focus {

    public String motive;

    public Painting(Location location, String motive) {
        this.location = location;
        this.motive = motive;
    }

    public Painting makeCopy(Focus other) {
        if(other instanceof  Painting) {
            Painting painting = (Painting) other;
            return new Painting(painting.location.clone(), painting.motive);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        Plugin plugin = getPluginManager().getPlugin("Dungeon");
        BukkitTask task = new SummonPainting(location, motive).runTaskLater(plugin, 400L);
    }
}
