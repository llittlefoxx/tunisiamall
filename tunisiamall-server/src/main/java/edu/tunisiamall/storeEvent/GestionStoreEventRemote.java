package edu.tunisiamall.storeEvent;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Storeevent;

@Remote
public interface GestionStoreEventRemote {
	public List<Storeevent> findAllStoreEvent();
	public Boolean addStoreEvent(Storeevent storeevent);

}
