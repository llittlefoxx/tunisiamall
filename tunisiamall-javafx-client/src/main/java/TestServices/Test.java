package TestServices;

import java.util.List;

import Delegates.MessageDelegate;
import Locator.ServiceLocator;
import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesRemote;

public class Test {

	public static void main(String[] args) {
		ServiceLocator locator = ServiceLocator.getInstance();
		userServicesRemote remoteUser = (userServicesRemote) locator.getProxy("tunisiamall-server/userServices!edu.tunisiamall.userServices.userServicesRemote");
		User u1 = remoteUser.find(1);
		User u2 = remoteUser.find(2);
		User u3 = remoteUser.find(3);
		User u4 = remoteUser.find(4);
		/*
		MessageDelegate.sendMessage(u3, u1, "yow");
		MessageDelegate.sendMessage(u1, u3, "aa");
		MessageDelegate.sendMessage(u3, u1, "ahla bik");
		MessageDelegate.sendMessage(u1, u3, "mriguil ?");
		*/
		/*
		List<Message> listOfMessages = MessageDelegate.getMessagesFor(u1);
		for (Message message : listOfMessages) {
			System.out.println(message.getText());
		}*/
		
		List<Message> listofMessages = MessageDelegate.getMessagesFromTo(u1, u2);
		for (Message message : listofMessages) {
			System.out.println(message.getText());
		}
	}

}
