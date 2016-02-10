package edu.tunisiamall.communication;

import java.util.List;
import javax.ejb.Remote;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.entities.Message;

@Remote
public interface MessageServiceRemote {
	public List<Message> getMessages(User u);
	public void sendMessage(User src, User dest, String text);
	public void deleteMessage(Message m);
	public void setMessageSeen(Message m);
}
