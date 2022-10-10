package com.gmail.seanduffy797.dungeon.events;

import com.destroystokyo.paper.event.player.PlayerPostRespawnEvent;
import com.gmail.seanduffy797.dungeon.DungeonItem;
import com.gmail.seanduffy797.dungeon.DungeonManager;
import com.gmail.seanduffy797.dungeon.DungeonMob;
import com.gmail.seanduffy797.dungeon.Pieces.Focuses.FocusMeta;
import com.gmail.seanduffy797.dungeon.mobs.NPCEnum;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class DungeonEventTest implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String name = ((TextComponent)player.displayName()).content();
        player.sendMessage(ChatColor.AQUA + "Welcome " + name + " to the server! Please enjoy, the server is currently in the pre-alpha phase");
        if (player.getWorld().equals(DungeonManager.world) && DungeonManager.isPlaying) {
            DungeonManager.bossBarCountdown.addPlayer(player);
        }
    }

    @EventHandler
    public static void onPlayerRespawn(PlayerPostRespawnEvent event) {
        Player player = event.getPlayer();
        player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
        player.getInventory().addItem(new ItemStack(Material.BREAD, 3));
        player.getInventory().addItem(DungeonItem.SOUL_TORCH.getItemStackNoNBT(16));
    }

    @EventHandler
    public static void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();
        String entityName = null;
        if (entity.customName() != null){
            entityName = ((TextComponent) entity.customName()).content();
        }
        DungeonMob customEntityType = null;
        PersistentDataContainer entityTags = entity.getPersistentDataContainer();
        if (entityTags.has(DungeonManager.customMobKey)) {
            String mobName = entityTags.get(DungeonManager.customMobKey, PersistentDataType.STRING);
            customEntityType = DungeonMob.valueOf(mobName);
        }

        EquipmentSlot slot = event.getHand();
        PlayerInventory inventory = player.getInventory();
        ItemStack item = inventory.getItem(slot);

        // Name Color Check: BAF3BD
        if (entity.getType() == EntityType.PARROT && entityName != null && entityName.equalsIgnoreCase("Mayor")) {
            player.sendMessage("Hello, I am the Mayor. Bring me 10 Carrots and I'll give you a Diamond");
        } else if (customEntityType == DungeonMob.GATEKEEPER_SKELETON && entityTags.has(DungeonMob.customId)){
            if(item.getItemMeta() != null) {
                PersistentDataContainer tags = item.getItemMeta().getPersistentDataContainer();
                if (tags.has(DungeonManager.customItemKey)) {
                    String itemName = tags.get(DungeonManager.customItemKey, PersistentDataType.STRING);
                    DungeonItem dungeonItem = DungeonItem.valueOf(itemName);
                    player.sendMessage(ChatColor.BLUE + "You may pass");
                    if (dungeonItem == DungeonItem.PALM_BRANCH) {
                        Skeleton skelly = (Skeleton) entity;
                        int number = entityTags.get(DungeonMob.customId, PersistentDataType.INTEGER);
                        FocusMeta.ironGates.get(number).destroy();
                        item.subtract();
                        skelly.remove();
                        return;
                    }
                }
            }
            if(!slot.equals(EquipmentSlot.OFF_HAND)) {
                player.sendMessage(ChatColor.BLUE + "You must give me a Palm Branch to prove your worth");
            }
            // Legacy code in case this breaks:
//        } else if (entity.getType() == EntityType.SKELETON && entityName != null && entityName.equalsIgnoreCase("GATEKEEPER")){
//            if(item.getItemMeta() != null) {
//                PersistentDataContainer tags = item.getItemMeta().getPersistentDataContainer();
//                if (tags.has(DungeonManager.customItemKey)) {
//                    String itemName = tags.get(DungeonManager.customItemKey, PersistentDataType.STRING);
//                    DungeonItem dungeonItem = DungeonItem.valueOf(itemName);
//                    player.sendMessage(ChatColor.BLUE + "You may pass");
//                    if (dungeonItem == DungeonItem.PALM_BRANCH) {
//                        Skeleton skelly = (Skeleton) entity;
//                        int number = (int) skelly.getHealth();
//                        FocusMeta.ironGates.get(number).destroy();
//                        item.subtract();
//                        skelly.remove();
//                        return;
//                    }
//                }
//            }
//            if(!slot.equals(EquipmentSlot.OFF_HAND)) {
//                player.sendMessage(ChatColor.BLUE + "You must give me a Palm Branch to prove your worth");
//            }
        } else if (entityName != null) {
            for (NPCEnum npc : NPCEnum.values()) {
                if (entityName.equalsIgnoreCase(npc.getName())) {
                    for (String line : npc.getDialogue()) {
                        player.sendMessage(line);
                    }
                }
            }
        }
    }


    // Disabled cause I don't know if this effects performance much or anything but better safe than sorry

//    @EventHandler
//    public static void onWandUse(PlayerInteractEvent event) {
//        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
//            if (event.getItem() != null) {
//                if (event.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
//                    Player player = event.getPlayer();
//                    player.getWorld().createExplosion(event.getClickedBlock().getLocation(), 2.0f);
//                }
//            }
//        }
//    }
}
