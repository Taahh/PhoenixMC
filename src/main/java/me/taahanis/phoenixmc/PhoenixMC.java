package me.taahanis.phoenixmc;

import cn.nukkit.command.Command;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import me.taahanis.phoenixmc.cmds.CMD_phoenixmc;
import me.taahanis.phoenixmc.listeners.JoinListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhoenixMC extends PluginBase {

	public final List<String> players = new ArrayList<>();
	public static PhoenixMC plugin;
	Config plyrs;
	File plyrsFile;

	public static PlayerManager pm;

	@Override
	public void onLoad() {
		PhoenixMC.plugin = this;
	}
	
	@Override
	public void onEnable() {
		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

		playerFileCreate();

		registerCMD("phoenixmc", new CMD_phoenixmc("phoenixmc"));
		getServer().getNetwork().setName(TextFormat.RED + "Phoenix" + TextFormat.YELLOW + "OP");

		pm = new PlayerManager(this);

		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
	}

	void registerCMD(String name, Command cmd) {
		getServer().getCommandMap().register(name, cmd);
	}

	void playerFileCreate() {
		plyrsFile = new File(getDataFolder(), "players.yml");

		if (getResource("players.yml") == null) {
			saveResource("players.yml");
		}
		plyrs = new Config(new File(getDataFolder(), "players.yml"), Config.YAML);
	}

	public Config getPlayers() {
		return plyrs;
	}
}
