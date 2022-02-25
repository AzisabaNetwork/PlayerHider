package com.github.mori01231.playerhider;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerHider extends JavaPlugin {

    private static PlayerHider instance;

    public PlayerHider (){
        instance = this;
    }

    public static PlayerHider getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents(){

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new WorldChangeListener(this),  this);
    }
}
