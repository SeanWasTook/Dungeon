package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import com.gmail.seanduffy797.dungeon.regions.Region;
import org.bukkit.Location;
import org.bukkit.Material;

public class EditableBlock extends Focus {

    public Material material;
    public Integer puzzleId;
    public boolean existsWhenOff = false; // If lever is off, this block exists. If the lever is on, it is destroyed

    public EditableBlock(Location location, Material material) {
        this.location = location;
        this.material = material;
        puzzleId = 0;
    }

    public EditableBlock(Location location, Material material, Integer puzzleId) {
        this.location = location;
        this.material = material;
        this.puzzleId = puzzleId;
    }
    public EditableBlock(Location location, Material material, Integer puzzleId, boolean existsWhenOff) {
        this.location = location;
        this.material = material;
        this.puzzleId = puzzleId;
        this.existsWhenOff = existsWhenOff;
    }

    public EditableBlock makeCopy(Focus other) {
        if (other instanceof EditableBlock) {
            EditableBlock block = (EditableBlock) other;
            return new EditableBlock(block.location.clone(), block.material, block.puzzleId, block.existsWhenOff);
        } else {
            return null;
        }
    }

    @Override
    public void start(Region region) {
        FocusMeta.puzzleBlocks.add(this);
    }

    public void destroy() {
        this.location.getBlock().setType(Material.AIR);
    }

    public void create() {
        this.location.getBlock().setType(this.material);
    }
}
