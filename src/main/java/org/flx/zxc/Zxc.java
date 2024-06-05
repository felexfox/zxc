package org.flx.zxc;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.flx.zxc.cmd.HintsCommand;
import org.flx.zxc.listener.HintListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Zxc extends JavaPlugin {


    private static Zxc instance;

    public static Zxc getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        saveDefaultConfig();

        instance = this;

        Bukkit.getPluginManager().registerEvents(new HintListener(), this);

        Bukkit.getConsoleSender().sendMessage("Plugin successfully enabled!");
    }

    @Override
    public void onDisable() {

        PluginCommand cmd = getCommand("hints");
        if (cmd != null) {
            HintsCommand hints = new HintsCommand();
            cmd.setExecutor(hints);
            cmd.setTabCompleter(hints);
        }
    }
}