package com.gmail.seanduffy797.dungeon.Pieces.Focuses;

import org.bukkit.Location;
import org.bukkit.Material;

public class EditableBlock extends Focus {

    public Material material;
    public Integer puzzleId;

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

    public EditableBlock makeCopy(Focus other) {
        if (other instanceof EditableBlock) {
            EditableBlock block = (EditableBlock) other;
            return new EditableBlock(block.location.clone(), block.material, block.puzzleId);
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        FocusMeta.puzzleBlocks.add(this);
    }

    public void destroy() {
        this.location.getBlock().setType(Material.AIR);
    }

    public void create() {
        this.location.getBlock().setType(this.material);
    }
}
