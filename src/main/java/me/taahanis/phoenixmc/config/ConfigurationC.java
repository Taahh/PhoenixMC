package me.taahanis.phoenixmc.config;

import cn.nukkit.utils.Config;
import me.taahanis.phoenixmc.PhoenixMC;

import java.io.File;

public class ConfigurationC {

	public Config config;
	public String path;
	public File file;

	public ConfigurationC(Config c, String p, File f) {
		this.config = c;
		this.path = p;
		this.file = f;
		f = new File(PhoenixMC.plugin.getDataFolder(), p);
		c.load(f.getName());
	}

	public Config getConfig() {
		return config;
	}
}
