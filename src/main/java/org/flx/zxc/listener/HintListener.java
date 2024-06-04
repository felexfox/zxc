package org.flx.zxc.listener;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.flx.zxc.Zxc;
import org.flx.zxc.util.HintUtil;

public class HintListener implements Listener {

    private static final MiniMessage mm = MiniMessage.miniMessage();

    @EventHandler
    public void BreakBlockEvent(BlockBreakEvent event){
        Block block = event.getBlock();
        Player player = event.getPlayer();
        switch (block.getType()) {
            case WHEAT, POTATOES, BEETROOTS, CARROTS, COCOA_BEANS -> HintUtil.show(player, "crops");
            case SNOW -> HintUtil.show(player, "snow");
            default -> {}
        }
    }

    @EventHandler
    public void onPlayerAchievement(PlayerAdvancementDoneEvent pade) {
        Player player = pade.getPlayer();
        String key = pade.getAdvancement().getKey().getKey();
        if (key.equalsIgnoreCase("adventure/trade")) {
            Bukkit.getScheduler().runTaskLater(Zxc.getInstance(), ( ) -> HintUtil.show(player, "discounts"), 0);
        }
    }

}