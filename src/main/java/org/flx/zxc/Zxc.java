package org.flx.zxc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.flx.zxc.Eventsformdr.CulturesBreakEvent;
import org.flx.zxc.Eventsformdr.SnowBreakEvent;

public final class Zxc extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("[zxc] Plugin successfully loaded!");

        Bukkit.getPluginManager().registerEvents(new CulturesBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SnowBreakEvent(), this);
    }

    @Override
    public void onDisable() {

    }
}
