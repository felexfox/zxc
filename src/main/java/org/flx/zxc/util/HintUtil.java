package org.flx.zxc.util;

import net.kyori.adventure.text.Component;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.flx.zxc.Zxc;

import java.util.List;

public class HintUtil {


    /**
     * Выводит подсказку по ID. DRY.
     * @param player Игрок которому будет выведена подсказка
     * @param id Определяет по какому айди будет браться строка из конфига + для хранения данных о уже полученной подсказки
     */
    public static void show(Player player, String id) {
        FileConfiguration cfg = Zxc.getInstance().getConfig();

        List<String> viewedHints = cfg.getStringList("data." + player.getName() + ".hints.viewed");
        if(viewedHints.contains(id)) return;
        viewedHints.add(id);
        cfg.set("data." + player.getName() + ".hints.viewed", viewedHints);
        Zxc.getInstance().saveConfig();

        String format = cfg.getString("hints.format", "");
        String message = cfg.getString("hints.list." + id, "");

        Component msg = TextUtil.wrap(format.replaceAll("%hint%", message));
        player.sendMessage(msg);
        player.playSound(player, Sound.BLOCK_AMETHYST_BLOCK_PLACE, 1f, 1.9f);
    }

}