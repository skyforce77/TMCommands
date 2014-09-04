package fr.skyforce77.TMCommands.commands;
import fr.skyforce77.towerminer.api.PluginManager;
import fr.skyforce77.towerminer.api.commands.Command;
import fr.skyforce77.towerminer.api.commands.CommandSender;

public class CommandPlugins extends Command {

	@Override
	public void onTyped(CommandSender sender, String[] args) {
		String st = "";
		int i = 0;
		for(String s : PluginManager.getPlugins()) {
			if(i < 2) {
				i++;
				st = st+s+", ";
			} else {
				i = 0;
				st = st+s+", ";
				sender.sendMessage(st);
			}
		}
		if(i != 0) {
			sender.sendMessage(st);
		}
	}
	
	@Override
	public boolean isCorrect(String[] args) {
		if(args.length == 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public void onInitialized(String label) {
		setAlias("pl");
	}

}
