package edu.tunisiamall.communication;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;

@Stateless
public class MessageService implements MessageServiceRemote, MessageServiceLocal {

	@PersistenceContext(unitName="tunisiamall-server")
	EntityManager em;
	
    public MessageService() {
    	
    }

	@Override
	public List<Message> getMessages(User u) {
		
		return null;
	}

	@Override
	public void sendMessage(User src, User dest, String text) {
		
	}

	@Override
	public void deleteMessage(Message m) {
		
	}

	@Override
	public void setMessageSeen(Message m) {
		
	}

}
