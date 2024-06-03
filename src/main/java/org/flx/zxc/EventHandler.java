package org.flx.zxc;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventHandler implements Listener {
    @org.bukkit.event.EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        evt.getPlayer().sendActionBar(MiniMessage.miniMessage().deserialize("<gradient:#7B2869:#9D3C72><bold>Created by FLX</gradient>"));
    }
}