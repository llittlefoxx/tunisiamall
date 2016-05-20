package Delegates;

import java.util.List;

import Locator.ServiceLocator;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.StoreServicesRemote;;



public class StoreDelegate {
	private final static String jndiName="tunisiamall.server-ear/tunisiamall.server-ejb/StoreServices!edu.tunisiamall.storeServices.StoreServicesRemote";
	
	public static StoreServicesRemote getProxy(){
	return (StoreServicesRemote) ServiceLocator.getInstance().getProxy(jndiName);
	
	}
	
	public static List<Store> findAllStore(){
		return getProxy().findAllStore();
	}
}
