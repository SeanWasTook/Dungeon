package com.gmail.seanduffy797.dungeon.housing;

import com.fastasyncworldedit.core.FaweAPI;
import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.enumeration.StructureMirror;
import com.github.shynixn.structureblocklib.api.enumeration.StructureRotation;
import com.gmail.seanduffy797.dungeon.Dungeon;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.Focus;
import com.gmail.seanduffy797.dungeon.Pieces.SizeablePiece;
import com.gmail.seanduffy797.dungeon.builders.wavefunction.Direction;
import com.gmail.seanduffy797.dungeon.regions.Region;
import com.gmail.seanduffy797.dungeon.regions.SubRegion;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.world.block.BlockTypes;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class House implements SizeablePiece {

    public static final Location WORK_AREA = new Location(DungeonManager.world, 10, 50, 10);

    public static boolean isSaveBlocked;

    public UUID ownerUuid;
    public String ownerName;
    public UUID houseUuid;
    public HouseTier tier;
    public SubRegion subRegion;

    public Location southWestCorner;
    public Direction facing;

    public House(UUID ownerUuid, String ownerName, UUID houseUuid, HouseTier tier, SubRegion subRegion) {
        this.ownerUuid = ownerUuid;
        this.ownerName = ownerName;
        this.houseUuid = houseUuid;
        this.tier = tier;
        this.subRegion = subRegion;
    }

    public int getLength() {
        return tier.length;
    }
    public int getWidth() {
        return tier.width;
    }
    public int getHeight() {
        return tier.height;
    }
    public Location getOffset() {
        return tier.offset;
    }
    public Map<Location, Region> getExits() {
        return new HashMap<>();
    }
    public ArrayList<Focus> getFocuses() {
        return new ArrayList<>();
    }

    // For now, they should exclusively be placed facing north. Might change this later
    public void place(Location location, StructureRotation rotation, StructureMirror mirror) {
        this.southWestCorner = location.clone().add(getOffset());
        this.facing = Direction.getDirectionFromRotation(rotation);

        DungeonManager.updateRegionMap(southWestCorner,
                new Location(DungeonManager.world,
                        southWestCorner.getX() + tier.length - 1,
                        southWestCorner.getY() + tier.height - 1,
                        southWestCorner.getZ() + tier.width - 1),
                Region.PLAYER_HOME);
        DungeonManager.updateHouseMap(southWestCorner,
                new Location(DungeonManager.world,
                        southWestCorner.getX() + tier.length - 1,
                        southWestCorner.getY() + tier.height - 1,
                        southWestCorner.getZ() + tier.width - 1),
                this);

        Plugin plugin = Dungeon.getPlugin();

        StructureBlockLibApi.INSTANCE
                .loadStructure(plugin)
                .at(southWestCorner)
                .includeEntities(true)
                .mirror(mirror)
                .rotation(rotation)
                .loadFromPath(plugin.getDataFolder().toPath().resolve("housing/structureNbt/" + houseUuid.toString() + ".nbt"))
                .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to load house. " + houseUuid.toString(), e));
    }

    public void save() {
//        isSaveBlocked = true;
        Plugin plugin = Dungeon.getPlugin();
        StructureBlockLibApi.INSTANCE
                        .saveStructure(plugin)
                        .at(southWestCorner)
                        .sizeX(tier.length)
                        .sizeY(tier.height)
                        .sizeZ(tier.width)
                        .saveToPath(plugin.getDataFolder().toPath().resolve("housing/structureNbt/" + houseUuid.toString() + ".nbt"))
                        .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to save house.", e));

        // Irrelevant for now, temporarily they will always be facing north
//        switch (facing) {
//            case NORTH:
//                StructureBlockLibApi.INSTANCE
//                        .saveStructure(plugin)
//                        .at(southWestCorner)
//                        .sizeX(tier.length)
//                        .sizeY(tier.height)
//                        .sizeZ(tier.width)
//                        .saveToPath(plugin.getDataFolder().toPath().resolve("housing/structureNbt/" + houseUuid.toString() + ".json"))
//                        .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to save house.", e));
//                isSaveBlocked = false;
//                break;
//            case EAST:
//                save(southWestCorner, tier.width, tier.length, StructureRotation.ROTATION_270);
//                isSaveBlocked = false;
//                break;
//            case SOUTH:
//                save(southWestCorner, tier.length, tier.width, StructureRotation.ROTATION_180);
//                isSaveBlocked = false;
//                break;
//            case WEST:
//                save(southWestCorner, tier.width, tier.length, StructureRotation.ROTATION_90);
//                isSaveBlocked = false;
//                break;
//        }
    }

    public void clear() {
        try (EditSession editSession = WorldEdit.getInstance().newEditSession(FaweAPI.getWorld(DungeonManager.world.getName()))) {
            CuboidRegion region = new CuboidRegion(BlockVector3.at(southWestCorner.getX(), southWestCorner.getY(), southWestCorner.getZ()),
                    BlockVector3.at(southWestCorner.getX() + tier.length - 1, southWestCorner.getY() + tier.height - 1, southWestCorner.getZ() + tier.width - 1));
            editSession.setBlocks((com.sk89q.worldedit.regions.Region) region, BlockTypes.AIR);
        }
    }

    // Might be necessary if they're placed rotated
    private void save(Location location, int length, int width, StructureRotation rotation) {
        Plugin plugin = Dungeon.getPlugin();
        StructureBlockLibApi.INSTANCE
                .saveStructure(plugin)
                .at(location)
                .sizeX(length)
                .sizeY(tier.height)
                .sizeZ(width)
                .saveToPath(plugin.getDataFolder().toPath().resolve("housing/structureNbt/" + houseUuid.toString() + ".json"))
                .onException(e -> plugin.getLogger().log(Level.SEVERE, "Failed to save house.", e))
                .onResult(e -> StructureBlockLibApi.INSTANCE
                        .loadStructure(plugin)
                        .at(WORK_AREA)
                        .rotation(rotation)
                        .includeEntities(true)
                        .loadFromPath(plugin.getDataFolder().toPath().resolve("housing/structureNbt/" + houseUuid.toString() + ".json"))
                        .onException(e2 -> plugin.getLogger().log(Level.SEVERE, "Failed to load house. " + houseUuid.toString(), e2))
                        .onResult(e2 -> StructureBlockLibApi.INSTANCE
                                .saveStructure(plugin)
                                .at(WORK_AREA)
                                .sizeX(tier.length)
                                .sizeY(tier.height)
                                .sizeZ(tier.width)
                                .saveToPath(plugin.getDataFolder().toPath().resolve("housing/structureNbt/" + houseUuid.toString() + ".json"))
                                .onException(e3 -> plugin.getLogger().log(Level.SEVERE, "Failed to save house v2.0.", e3))
                                .onResult(e3 -> isSaveBlocked = false)
                        )
                );
    }
}
