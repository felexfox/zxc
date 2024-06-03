package org.flx.zxc.Eventsformdr;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class CulturesBreakEvent implements Listener {

    private boolean messageSent = false;

    private static final MiniMessage mm = MiniMessage.miniMessage();

    @EventHandler
    public void BreakBlockEvent(BlockBreakEvent bbe){
        if (bbe.getBlock().getType().equals(Material.WHEAT) && !messageSent) {
            bbe.getPlayer().sendMessage(mm.deserialize("●<gradient:#FFFFFF:#BCBAB8><b> Modoru</gradient>"+": Вы сломали пшеницу! Вы так же можете просто её <underlined><bold>собрать</underlined>" + " нажав ПКМ по любой культуре!" + "<click:open_url:https://wiki.modoru.fun/other/crops><bold> Подробнее тут.</click>"));
            for (Player player : Bukkit.getOnlinePlayers()){
                player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1.0F, 1.0F);
            }
            messageSent = true;
        }
        else if (bbe.getBlock().getType().equals(Material.POTATOES) && !messageSent) {
            bbe.getPlayer().sendMessage(mm.deserialize("●<gradient:#FFFFFF:#BCBAB8><b> Modoru</gradient>"+": Вы сломали картофель! Вы так же можете просто его <underlined><bold>собрать</underlined>" + " нажав ПКМ по любой культуре!" + "<click:open_url:https://wiki.modoru.fun/other/crops><bold> Подробнее тут.</click>"));
            for (Player player : Bukkit.getOnlinePlayers()){
                player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1.0F, 1.0F);
            }
            messageSent = true;
        }
        else if (bbe.getBlock().getType().equals(Material.BEETROOTS) && !messageSent) {
            bbe.getPlayer().sendMessage(mm.deserialize("●<gradient:#FFFFFF:#BCBAB8><b> Modoru</gradient>"+": Вы сломали свеклу! Вы так же можете просто её <underlined><bold>собрать</underlined>" + " нажав ПКМ по любой культуре!" + "<click:open_url:https://wiki.modoru.fun/other/crops><bold> Подробнее тут.</click>"));
            for (Player player : Bukkit.getOnlinePlayers()){
                player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1.0F, 1.0F);
            }
            messageSent = true;
        }
        else if (bbe.getBlock().getType().equals(Material.CARROTS) && !messageSent) {
            bbe.getPlayer().sendMessage(mm.deserialize("●<gradient:#FFFFFF:#BCBAB8><b> Modoru</gradient>"+": Вы сломали морковь! Вы так же можете просто её <underlined><bold>собрать</underlined>" + " нажав ПКМ по любой культуре!" + "<click:open_url:https://wiki.modoru.fun/other/crops><bold> Подробнее тут.</click>"));
            for (Player player : Bukkit.getOnlinePlayers()){
                player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1.0F, 1.0F);
            }
            messageSent = true;
        }finalize();
    }
}
