package edu.tunisiamall.communication;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;

@Local
public interface MessageServiceLocal {
	public List<Message> getMessages(User u);
	public void sendMessage(User src, User dest, String text);
	public void deleteMessage(Message m);
	public void setMessageSeen(Message m);
}
