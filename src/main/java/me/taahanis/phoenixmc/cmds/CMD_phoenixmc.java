package me.taahanis.phoenixmc.cmds;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class CMD_phoenixmc extends Command {

	public CMD_phoenixmc(String name) {
		super(name);
	}

	@Override
	public boolean execute(CommandSender sender, String label, String[] args) {
		sender.sendMessage(TextFormat.AQUA + " This is a test!! :) ");
		return true;
	}
}
