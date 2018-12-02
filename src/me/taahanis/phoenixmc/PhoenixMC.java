package me.taahanis.phoenixmc;

import cn.nukkit.command.Command;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.ConfigSection;
import cn.nukkit.utils.TextFormat;
import me.taahanis.phoenixmc.cmds.CMD_phoenixmc;
import me.taahanis.phoenixmc.config.ConfigurationC;
import me.taahanis.phoenixmc.listeners.JoinListener;

import java.io.File;
import java.io.IOException;

public class PhoenixMC extends PluginBase{

    public static PhoenixMC plugin;
    Config plyrs;
    File plyrsFile;


    public static PlayerManager pm;
    @Override
    public void onEnable()
    {
        if (!this.getDataFolder().exists())
        {
            this.getDataFolder().mkdir();
        }

        playerFileCreate();

        registerCMD("phoenixmc", new CMD_phoenixmc("phoenixmc"));
        getServer().getNetwork().setName(TextFormat.RED + "Phoenix" + TextFormat.YELLOW + "OP");


        pm = new PlayerManager(this);


        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
    }

    @Override
    public void onDisable()
    {

    }


    void registerCMD(String name, Command cmd)
    {
        getServer().getCommandMap().register(name, cmd);
    }
    void playerFileCreate(){
        plyrsFile = new File(this.getDataFolder(), "players.yml");

        if (getResource("players.yml") == null){
            saveResource("players.yml");
        }
        plyrs = new Config(new File(this.getDataFolder(), "players.yml"), Config.YAML);
    }
    public Config getPlayers()
    {
        return plyrs;
    }
}
