package edu.tunisiamall.storeEvent;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Storeevent;

@Local
public interface GestionStoreEventLocal {
	public List<Storeevent> findAllStoreEvent();
	public Boolean addStoreEvent(Storeevent storeevent);

}
