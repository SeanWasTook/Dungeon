package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Trigger extends Focus {

    public Integer puzzleId;

    public Trigger(Location location, Integer puzzleId) {
        this.location = location;
        this.puzzleId = puzzleId;
    }

    public Trigger makeCopy(Focus other) {
        if (other instanceof Trigger) {
            Trigger trigger = (Trigger) other;
            return new Trigger(other.location.clone(), trigger.puzzleId);
        } else {
            return null;
        }
    }

    @Override
    public void start(Region region) {
        this.location.setYaw(0);
        this.location.setPitch(0);
        FocusMeta.triggers.put(this.location, this);
    }

    // Generally used by buttons
    public boolean trigger(Player player) {
        ArrayList<ItemFrameChecker> frames = FocusMeta.puzzleFrames;
        for (ItemFrameChecker frame : frames) {
            if(frame.puzzleId.equals(this.puzzleId)) {
                player.sendMessage("Mark 1");
                if(!frame.isCorrect(player)) {
                    player.sendMessage("Frame is Incorrect");
                    return false;
                }
            }
        }
        player.sendMessage("Mark 5");
        ArrayList<EditableBlock> blocks = FocusMeta.puzzleBlocks;
        for (EditableBlock block : blocks) {
            if(block.puzzleId.equals(this.puzzleId)) {
                block.create();
            }
        }
        return true;
    }

    // Generally used by levers
    public boolean trigger(Player player, boolean isOn) {
        ArrayList<ItemFrameChecker> frames = FocusMeta.puzzleFrames;
        for (ItemFrameChecker frame : frames) {
            if(frame.puzzleId.equals(this.puzzleId)) {
                player.sendMessage("Mark 1");
                if(!frame.isCorrect(player)) {
                    player.sendMessage("Frame is Incorrect");
                    return false;
                }
            }
        }
        player.sendMessage("Mark 5");
        ArrayList<EditableBlock> blocks = FocusMeta.puzzleBlocks;
        for (EditableBlock block : blocks) {
            if(block.puzzleId.equals(this.puzzleId)) {
                if ((isOn && block.existsWhenOff) || (!isOn && !block.existsWhenOff)) {
                    player.sendMessage("Mark 6");
                    block.destroy();
                } else {
                    player.sendMessage("Mark 7");
                    block.create();
                }
            }
        }
        return true;
    }
}
