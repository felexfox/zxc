package org.flx.zxc.Eventsformdr;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class WheatBreakEvent implements Listener {

    private boolean messageSent = false;

    private static final MiniMessage mm = MiniMessage.miniMessage();

    @EventHandler
    public void BreakBlockEvent(BlockBreakEvent bbe){
        if (bbe.getBlock().getType().equals(Material.WHEAT) && !messageSent) {
            bbe.getPlayer().sendMessage(mm.deserialize("● <gradient:#FFFFFF:#BCBAB8><b> Modoru</gradient>"+": Вы сломали пшеницу! Вы так же можете просто её <underlined><bold>собрать</underlined>" + " нажав ПКМ по пшенице!"));
            messageSent = true;
        }
    }
}
