package fr.skyforce77.TMCommands.commands;
import fr.skyforce77.towerminer.TowerMiner;
import fr.skyforce77.towerminer.api.PluginUtils;
import fr.skyforce77.towerminer.api.commands.Argument;
import fr.skyforce77.towerminer.api.commands.Argument.ArgumentType;
import fr.skyforce77.towerminer.api.commands.Command;
import fr.skyforce77.towerminer.api.commands.CommandSender;
import fr.skyforce77.towerminer.menus.MultiPlayer;
import fr.skyforce77.towerminer.protocol.packets.Packet16Sound;

public class CommandMusic extends Command {

	@Override
	public void onTyped(CommandSender sender, String[] args) {
		args[0] = args[0].replaceAll("https", "http");
		
		if(TowerMiner.menu instanceof MultiPlayer) {
			PluginUtils.sendAllTCP(new Packet16Sound(0, true, args[0]));
			sender.sendMessage("Sent music");
		} else {
			sender.sendMessage("This command is multiplayer only");
		}
	}
	
	@Override
	public boolean isCorrect(String[] args) {
		if(args.length >= 0 && !args[0].equals("")) {
			return true;
		}
		return false;
	}
	
	@Override
	public void onInitialized(String label) {
		setArguments(new Argument("url", ArgumentType.Url));
	}

}
