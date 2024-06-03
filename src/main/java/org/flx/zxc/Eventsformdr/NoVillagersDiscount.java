package org.flx.zxc.Eventsformdr;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.flx.zxc.Zxc;


public class NoVillagersDiscount implements Listener {

    private final MiniMessage mm = MiniMessage.miniMessage();

    @EventHandler
    public void onPlayerAchievement(PlayerAdvancementDoneEvent pade) {
        Player player = pade.getPlayer();
        String advancementName = pade.getAdvancement().getKey().getKey();
        if (advancementName.equalsIgnoreCase("adventure/trade")) {
            Bukkit.getScheduler().runTaskLater(Zxc.getInstance(), ( ) -> {player.sendMessage(mm.deserialize("●<gradient:#FFFFFF:#BCBAB8><b> Modoru</gradient>"));}, 0);
finalize();
        }
    }

}
