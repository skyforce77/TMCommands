package fr.skyforce77.TMCommands;
import fr.skyforce77.TMCommands.commands.CommandMusic;
import fr.skyforce77.TMCommands.commands.CommandNotif;
import fr.skyforce77.TMCommands.commands.CommandPlugins;
import fr.skyforce77.TMCommands.commands.CommandStop;
import fr.skyforce77.towerminer.api.Plugin;
import fr.skyforce77.towerminer.api.PluginManager;
import fr.skyforce77.towerminer.api.commands.CommandManager;


public class TMCommands extends Plugin{
	
	@Override
	public boolean isPluginNeededByClient() {
		return false;
	}
	
	@Override
	public void onEnable() {
		PluginManager.registerListener(new CommandListener());
		CommandManager.register("notif", new CommandNotif());
		CommandManager.register("stop", new CommandStop());
		CommandManager.register("music", new CommandMusic());
		CommandManager.register("plugins", new CommandPlugins());
	}

}
