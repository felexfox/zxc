package org.flx.zxc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.flx.zxc.Eventsformdr.CulturesBreakEvent;
import org.flx.zxc.Eventsformdr.NoVillagersDiscount;
import org.flx.zxc.Eventsformdr.SnowBreakEvent;

public final class Zxc extends JavaPlugin {
    private static Zxc instance;

    public static Zxc getInstance() {
        return instance;
    }



    @Override
    public void onEnable() {

        saveDefaultConfig();

        instance = this;

        Bukkit.getConsoleSender().sendMessage("[zxc] Plugin successfully loaded!");

        Bukkit.getPluginManager().registerEvents(new CulturesBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SnowBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new NoVillagersDiscount(), this);
    }

    @Override
    public void onDisable() {

    }
}
