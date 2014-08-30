package fr.skyforce77.TMCommands.commands;
import fr.skyforce77.towerminer.TowerMiner;
import fr.skyforce77.towerminer.api.Utils;
import fr.skyforce77.towerminer.api.commands.Argument;
import fr.skyforce77.towerminer.api.commands.Argument.ArgumentType;
import fr.skyforce77.towerminer.api.commands.Command;
import fr.skyforce77.towerminer.menus.MultiPlayer;
import fr.skyforce77.towerminer.menus.SinglePlayer;

public class CommandGive extends Command {

	@Override
	public void onTyped(String[] args) {
		Integer i = Integer.parseInt(args[0]);
		
		if(!(TowerMiner.menu instanceof MultiPlayer) && TowerMiner.menu instanceof SinglePlayer) {
			SinglePlayer sp = (SinglePlayer)TowerMiner.menu;
			sp.or = sp.or+i;
			Utils.write("Gived "+i+" golds");
		} else {
			Utils.write("This command is singleplayer only");
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
		setArguments(new Argument("amount", ArgumentType.Integer));
	}

}
