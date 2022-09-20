package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.builders.BrickPiecePicker;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Door;

import static org.bukkit.Bukkit.getServer;

public class LockedDoor extends Focus {

    public LockEnum lock;

    public LockedDoor(Location location, LockEnum lock) {
        this.location = location;
        this.lock = lock;
    }

    public LockedDoor makeCopy(Focus door) {
        if (door instanceof LockedDoor) {
            LockedDoor other = (LockedDoor) door;
            return new LockedDoor(other.location.clone(), other.lock);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        this.location.setYaw(0);
        this.location.setPitch(0);
        FocusMeta.doors.put(this.location, this);
    }

    public boolean open(String keyName) {
        if (lock.getKeyName().equalsIgnoreCase(keyName)) {
            if(location.getBlock().getType() == Material.IRON_DOOR) {
                Door door;
                Block block = location.getBlock();
                door = (Door)block.getState().getBlockData();
                if(door.isOpen()) {
                    return false;
                }
                door.setOpen(true);
                block.setBlockData(door);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
