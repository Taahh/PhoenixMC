package me.taahanis.phoenixmc;

import cn.nukkit.Nukkit;
import cn.nukkit.Player;

import java.io.File;

public class PlayerManager {

    PhoenixMC plugin;
    public PlayerManager(PhoenixMC pl){
        this.plugin = pl;
    }


    public boolean playerExists(Player player){
        String uuid = plugin.getPlayers().getString("players." + player.getUniqueId().toString());
        return uuid != null;
    }

    public void createPlayer(Player player)
    {
        String uuid = player.getUniqueId().toString();
        String ip = player.getAddress();
        String name = player.getName();
        plugin.getPlayers().set("players." + uuid + ".name", name);
        plugin.getPlayers().set("players." + uuid +  ".ip", ip);
        plugin.getPlayers().save(new File(plugin.getDataFolder(), "players.yml"));
    }
}
