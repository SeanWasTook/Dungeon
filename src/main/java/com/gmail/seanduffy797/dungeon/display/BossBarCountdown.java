package com.gmail.seanduffy797.dungeon.display;

import com.gmail.seanduffy797.dungeon.DungeonManager;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class BossBarCountdown {

    private BossBar bar;
    private int maxTime;
    private int currentTime;
    private boolean active;
    Component name = Component.text("The End Approaches...");

    public BossBarCountdown(int maxTime) {
        bar = BossBar.bossBar(name, 1, BossBar.Color.RED, BossBar.Overlay.PROGRESS);
        this.maxTime = maxTime;
        this.currentTime = maxTime;
        for (Player player: DungeonManager.world.getPlayers()) {
            player.showBossBar(bar);
        }
        active = true;
    }
    public void tick() {
        if (active) {
            currentTime = currentTime - 1;
            if (currentTime % 10 == 0) {
                bar.progress(((float) currentTime) / maxTime);
            }
            if (currentTime == 0) {
                // This will eventually be important
                for (Player player : DungeonManager.world.getPlayers()) {
                    player.hideBossBar(bar);
                }
                active = false;
            }
        }
    }
    public void addPlayer(Player player) {
        player.showBossBar(bar);
    }
    public void cancel(){
        for (Player player: DungeonManager.world.getPlayers()) {
            player.hideBossBar(bar);
        }
        active = false;
    }
}
