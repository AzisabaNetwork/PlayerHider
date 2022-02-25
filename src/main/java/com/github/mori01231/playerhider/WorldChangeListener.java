package com.github.mori01231.playerhider;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldChangeListener  implements Listener {

    private PlayerHider plugin;
    public WorldChangeListener(PlayerHider plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onWorldChange(PlayerChangedWorldEvent event) {
        if(event.getFrom().getName().equals("world") || event.getPlayer().getWorld().getName().equals("world")) {
            for (Player toHide : Bukkit.getServer().getOnlinePlayers()) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if(player.getWorld().getName().equals("world") && toHide.getWorld().getName().equals("world")){
                        player.hidePlayer(plugin,toHide);
                        toHide.hidePlayer(plugin,player);
                    }
                    else{
                        player.showPlayer(plugin,toHide);
                        toHide.showPlayer(plugin,player);
                    }
                }
            }
        }
    }
}
