package fr.skyforce77.TMCommands.commands;
import java.awt.Color;

import fr.skyforce77.towerminer.api.Plugin;
import fr.skyforce77.towerminer.api.PluginManager;
import fr.skyforce77.towerminer.api.commands.Command;
import fr.skyforce77.towerminer.api.commands.CommandSender;
import fr.skyforce77.towerminer.protocol.chat.ChatMessage;
import fr.skyforce77.towerminer.protocol.chat.ChatModel;
import fr.skyforce77.towerminer.protocol.chat.MessageModel;

public class CommandPlugins extends Command {

	@Override
	public void onTyped(CommandSender sender, String[] args) {
		ChatMessage message = new ChatMessage("Plugins: ");
		int i = 0;
		for(String s : PluginManager.getPlugins()) {
			Plugin p = PluginManager.getPlugin(s);
			ChatModel model = new ChatModel(p.getName());
			model.setMouseModel(new MessageModel("v"+p.getVersion()));
			message.addModel(model);
			message.addModel(new ChatModel(" "));
		}
		if(i != 0) {
			message = new ChatMessage("Nothing to see");
			message.getModels().get(0).setForegroundColor(Color.RED);
		}
		sender.sendMessage(message);
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
