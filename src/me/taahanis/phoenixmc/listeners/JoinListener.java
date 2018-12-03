package me.taahanis.phoenixmc.listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import me.taahanis.phoenixmc.PhoenixMC;


public class JoinListener implements Listener {

    PhoenixMC plugin;
    public JoinListener(PhoenixMC plugin){
        this.plugin = plugin;
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
           if (!plugin.players.contains(player.getUniqueId().toString())){
               PhoenixMC.pm.createPlayer(player);
               plugin.players.add(player.getUniqueId().toString());

           }

    }
}
