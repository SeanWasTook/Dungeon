package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import org.bukkit.Location;
import org.bukkit.Rotation;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getWorld;

import java.util.Collection;

public class ItemFrameChecker extends Focus {

    public Rotation goal;
    public Integer puzzleId;

    public ItemFrameChecker(Location location, Rotation goal) {
        this.location = location;
        this.goal = goal;
    }

    public ItemFrameChecker(Location location, Rotation goal, Integer puzzleId) {
        this.location = location;
        this.goal = goal;
        this.puzzleId = puzzleId;
    }

    public ItemFrameChecker makeCopy(Focus other) {
        if (other instanceof ItemFrameChecker) {
            ItemFrameChecker frame = (ItemFrameChecker) other;
            return new ItemFrameChecker(frame.location.clone(), frame.goal, frame.puzzleId);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        FocusMeta.puzzleFrames.add(this);
    }

    public boolean isCorrect(Player player) {
        player.sendMessage("Mark 2: jLocation: " + this.location);
        World world  = getWorld("Dungeon");
        if(world == null) { return false;}
        Collection<Entity> entities = world.getNearbyEntities(this.location, 1, 1, 1);
        for(Entity entity : entities) {
            player.sendMessage("Mark 3");
            if(entity.getType().equals(EntityType.ITEM_FRAME)) {
                player.sendMessage("Mark 4");
                ItemFrame itemFrame = (ItemFrame) entity;
                Rotation rotation = itemFrame.getRotation();
                player.sendMessage("Rotation: " + rotation);
                return rotation == goal;
            }
        }
        return false;
    }
}
