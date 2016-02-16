package Delegates;

import java.util.List;

import Locator.ServiceLocator;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.GestionStoreRemote;



public class StoreDelegate {
	static String jndiName="tunisiamall-server/GestionStore!edu.tunisiamall.storeServices.GestionStoreLocal";
	
	public static GestionStoreRemote getProxy(){
	return (GestionStoreRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	
	public static List<Store> findAllStore(){
		return getProxy().findAllStore();
	}
}
