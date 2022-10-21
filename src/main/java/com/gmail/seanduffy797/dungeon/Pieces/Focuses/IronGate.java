package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class IronGate extends Focus {

    public int number;

    public IronGate(Location location, int number) {
        this.location = location;
        this.number = number;
    }

    public IronGate makeCopy(Focus gate) {
        if (gate instanceof IronGate) {
            IronGate other = (IronGate) gate;
            return new IronGate(other.location, other.number);
        } else {
            return null;
        }
    }

    @Override
    public void start(Region region) {
        FocusMeta.ironGates.put(this.number, this);
    }

    public void destroy() {
        Block block = this.location.getBlock();
        block.setType(Material.AIR);
        Block block2 = block.getRelative(0,1,0);
        block2.setType(Material.AIR);

        Block[] blocks = {
                block.getRelative(1,0,0),
                block.getRelative(-1,0,0),
                block.getRelative(0,0,1),
                block.getRelative(0,0,-1),
                block2.getRelative(1,0,0),
                block2.getRelative(-1,0,0),
                block2.getRelative(0,0,1),
                block2.getRelative(0,0,-1)
        };

        for(Block b : blocks) {
            if (b.getType().equals(Material.IRON_BARS)) {
                b.setType(Material.AIR);
            }
        }
    }
}
