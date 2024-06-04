package org.flx.zxc.cmd;

import com.google.common.collect.Lists;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.flx.zxc.Zxc;
import org.flx.zxc.util.SortUtil;
import org.flx.zxc.util.TextUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class HintsCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return true;
        else if (args.length == 0) return true;

        switch (args[0].toLowerCase()) {
            case "on" -> {
                Zxc plugin = Zxc.getInstance();
                plugin.getConfig().set("data." + player.getName() + ".hints.enabled", true);
                plugin.saveConfig();

                player.sendMessage(TextUtil.wrap("Вы <u><green>включили</green></u> подсказки."));
            }
            case "off" -> {
                Zxc plugin = Zxc.getInstance();
                plugin.getConfig().set("data." + player.getName() + ".hints.enabled", false);
                plugin.saveConfig();

                player.sendMessage(TextUtil.wrap("Вы <u><red>отключили</red></u> подсказки."));
            }
            case "reload" -> {
                if(sender.hasPermission("*")) {
                    Zxc.getInstance().reloadConfig();
                    player.sendMessage("Configuration reloaded");
                }
            }
            default -> {}
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> args = Lists.newArrayList("on", "off");
        if(sender.hasPermission("*")) args.add("reload");
        return SortUtil.search(args, strings[strings.length - 1]);
    }

}