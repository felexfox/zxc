package org.flx.zxc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.flx.zxc.Eventsformdr.WheatBreakEvent;

public final class Zxc extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("[zxc] Plugin successfully loaded!");
        getServer().getPluginManager().registerEvents(new WheatBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new EventHandler(), this);

    }

    @Override
    public void onDisable() {

    }
}
