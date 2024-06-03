package org.flx.zxc.Eventsformdr;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.flx.zxc.Zxc;

public class SnowBreakEvent implements Listener {

    private static final MiniMessage mm = MiniMessage.miniMessage();

    private boolean messageSent = false;

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent bbe) {
        if (bbe.getBlock().getType().equals(Material.SNOW) && !messageSent) {
            bbe.getPlayer().sendMessage(mm.deserialize(Zxc.getInstance().getConfig().getString("SnowBreakEvent.snow")));
            for (Player player : Bukkit.getOnlinePlayers()){
                player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1.0F, 1.0F);
            }
            messageSent = true;
        }
    }

}
