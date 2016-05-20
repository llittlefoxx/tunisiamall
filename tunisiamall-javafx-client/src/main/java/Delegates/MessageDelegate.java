package Delegates;

import java.util.List;


import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.communication.MessageServiceRemote;;

public class MessageDelegate {
	private final static String jndiName="tunisiamall.server-ear/tunisiamall.server-ejb/MessageService!edu.tunisiamall.communication.MessageServiceRemote"; 
	
	private static MessageServiceRemote getProxy() {
		return (MessageServiceRemote) Locator.ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static List<Message> getMessagesFromTo(User src, User dest){
		return getProxy().getMessagesFromTo(src, dest);
	}
	
	public static List<Message> getMessagesFor(User u){
		return getProxy().getMessagesFor(u);
	}
	
	public static Message sendMessage(User src, User dest, String text){
		return getProxy().sendMessage(src, dest, text);
	}
	
	public static boolean deleteMessage(Message m){
		return getProxy().deleteMessage(m.getIdMessage());
	}
	
}
