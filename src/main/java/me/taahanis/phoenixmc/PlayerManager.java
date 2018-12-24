package me.taahanis.phoenixmc;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;

import java.io.File;

public class PlayerManager {

	// Set to private to prevent leaking
	private PhoenixMC plugin;
	File playersFile;
	Config c;

	public PlayerManager(PhoenixMC pl) {
		this.plugin = pl;
		this.playersFile = new File(plugin.getDataFolder(), "players.yml");
		this.c = new Config(playersFile, Config.YAML);
	}

	public boolean playerExists(Player player) {

		String thingy = c.getString("players." + player.getUniqueId().toString());
		if (thingy == null) {
			return false;
		}
		return true;
	}

	public void createPlayer(Player player) {
		String uuid = player.getUniqueId().toString();
		String ip = player.getAddress();
		String name = player.getName();
		c.set("players." + uuid + ".name", name);
		c.set("players." + uuid + ".ip", ip);
		c.save();
	}
}
