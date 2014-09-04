package fr.skyforce77.TMCommands.commands;

import fr.skyforce77.towerminer.api.Utils;
import fr.skyforce77.towerminer.api.commands.Command;
import fr.skyforce77.towerminer.api.commands.CommandSender;

public class CommandStop extends Command {

	@Override
	public void onTyped(CommandSender sender, String[] args) {
		Utils.broadcast("Stopping internal server in 10s...");
		new Thread() {
			public void run() {
				try {
					Thread.sleep(10000l);
				} catch (InterruptedException e) {}
				System.exit(1);
			};
		}.start();
	}
	
	@Override
	public boolean isCorrect(String[] args) {
		if(args.length == 1 && args[0].equals("")) {
			return true;
		}
		return false;
	}

}
