package fr.skyforce77.TMCommands.commands;
import fr.skyforce77.towerminer.TowerMiner;
import fr.skyforce77.towerminer.achievements.Popup;
import fr.skyforce77.towerminer.api.Utils;
import fr.skyforce77.towerminer.api.commands.Argument;
import fr.skyforce77.towerminer.api.commands.Argument.ArgumentType;
import fr.skyforce77.towerminer.api.commands.Command;
import fr.skyforce77.towerminer.api.commands.CommandSender;
import fr.skyforce77.towerminer.menus.MultiPlayer;
import fr.skyforce77.towerminer.protocol.packets.Packet12Popup;

public class CommandNotif extends Command {

	@Override
	public void onTyped(CommandSender sender, String[] args) {
		String s = "";
		for(String arg : args) {
			if(!s.equals("")) {
				s = s+" "+arg;
			} else {
				s = s+arg;
			}
		}
		
		if(TowerMiner.menu instanceof MultiPlayer) {
			Utils.sendAllTCP(new Packet12Popup(s));
		} else {
			new Popup(s, 8000);
		}
	}
	
	@Override
	public boolean isCorrect(String[] args) {
		if(args.length >= 1 && !args[0].equals("")) {
			return true;
		}
		return false;
	}
	
	@Override
	public void onInitialized(String label) {
		setAlias("notify-send");
		setArguments(new Argument("text", ArgumentType.String));
	}

}
