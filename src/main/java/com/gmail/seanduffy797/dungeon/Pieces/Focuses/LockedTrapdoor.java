package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.TrapDoor;

import static org.bukkit.Bukkit.getServer;

public class LockedTrapdoor extends LockedDoor {

    public LockedTrapdoor(Location location, LockEnum lockEnum) {
        super(location, lockEnum);
    }

    public LockedTrapdoor makeCopy(Focus door) {
        if (door instanceof LockedDoor) {
            LockedTrapdoor other = (LockedTrapdoor) door;
            return new LockedTrapdoor(other.location.clone(), other.lock);
        } else {
            return null;
        }
    }

    @Override
    public boolean open(String keyName) {
        if (lock.getKeyName().equalsIgnoreCase(keyName)) {
            if(location.getBlock().getType() == Material.IRON_TRAPDOOR) {
                TrapDoor trapDoor;
                Block block = location.getBlock();
                trapDoor = (TrapDoor) block.getState().getBlockData();
                if(trapDoor.isOpen()) {
                    return false;
                }
                trapDoor.setOpen(true);
                block.setBlockData(trapDoor);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
