package org.flx.zxc.listener;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.flx.zxc.Zxc;
import org.flx.zxc.util.HintUtil;

public class HintListener implements Listener {

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
        switch (key.toLowerCase()) {
            case "adventure/trade" -> Bukkit.getScheduler().runTaskLater(Zxc.getInstance(), ( ) -> HintUtil.show(player, "discounts"), 0);
            case "nether/brew_potion" -> Bukkit.getScheduler().runTaskLater(Zxc.getInstance(), ( ) -> HintUtil.show(player, "potions"), 0);
        }
    }
    @EventHandler
    public void PlaceBlockEvent(BlockPlaceEvent bpe) {
        Block block = bpe.getBlock();
        Player player = bpe.getPlayer();
        switch (block.getType()) {
            case FLETCHING_TABLE -> HintUtil.show(player, "fletching");
            case BREWING_STAND, CAULDRON -> HintUtil.show(player, "brewery");
            default -> {}
        }
    }
    @EventHandler
    public void PlayerPickupItemEvent(PlayerPickupItemEvent ppie) {
        ItemStack itemStack = ppie.getItem().getItemStack();
        Player player = ppie.getPlayer();
        switch (itemStack.getType()) {
            case TOTEM_OF_UNDYING -> HintUtil.show(player, "totems");
            default -> {}
        }
    }
}