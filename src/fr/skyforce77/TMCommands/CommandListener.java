package fr.skyforce77.TMCommands;

import java.awt.Color;

import fr.skyforce77.towerminer.TowerMiner;
import fr.skyforce77.towerminer.api.EventHandler;
import fr.skyforce77.towerminer.api.TMListener;
import fr.skyforce77.towerminer.api.events.chat.CommandTypedEvent;
import fr.skyforce77.towerminer.api.events.menu.MenuUsedEvent;
import fr.skyforce77.towerminer.menus.MultiPlayer;
import fr.skyforce77.towerminer.menus.SinglePlayer;
import fr.skyforce77.towerminer.protocol.chat.ChatMessage;
import fr.skyforce77.towerminer.protocol.chat.ChatModel;
import fr.skyforce77.towerminer.protocol.chat.MessageModel;

public class CommandListener extends TMListener{
	
	@EventHandler
	public void onMenuUsed(MenuUsedEvent e) {
		if(e.getMenu().getClass().equals(SinglePlayer.class)) {
			SinglePlayer sp = ((SinglePlayer)e.getMenu());
			sp.chatmenu.setVisible(true);
			sp.chatfield.setVisible(true);
	        sp.enablechat.setVisible(true);
		}
	}
	
	@EventHandler
	public void onCommandTyped(CommandTypedEvent e) {
		if(TowerMiner.menu instanceof MultiPlayer) {
			MultiPlayer mp = (MultiPlayer)TowerMiner.menu;
			if(!mp.server) {
				ChatModel m = new ChatModel("You can't use commands if you are not the host");
				m.setForegroundColor(Color.RED);
				m.setMouseModel(new MessageModel("Will be available in a future version"));
				mp.chat.onMessageReceived(new ChatMessage(m));
				e.setCancelled(true);
			}
		}
	}

}
