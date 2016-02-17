package Delegates;

import java.util.List;

import Locator.ServiceLocator;

import edu.tunisiamall.entities.Storeevent;
import edu.tunisiamall.storeEvent.GestionStoreEventRemote;


public class StoreEventDelegate {
private final static String jndiName="tunisiamall-server/GestionStoreEvent!edu.tunisiamall.storeEvent.GestionStoreEventRemote";
	
	public static GestionStoreEventRemote getProxy(){
	return (GestionStoreEventRemote) ServiceLocator.getInstance().getProxy(jndiName);
	
	}
	
	public static List<Storeevent> findAllStoreEvent(){
		return getProxy().findAllStoreEvent();
	}
	public static Boolean addStoreEvent(Storeevent storeevent){
		return getProxy().addStoreEvent(storeevent);
	}

}
