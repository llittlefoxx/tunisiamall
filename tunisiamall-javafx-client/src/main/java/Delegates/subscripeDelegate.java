package Delegates;

import java.util.List;

import Locator.ServiceLocator;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.entities.Subscription;
import edu.tunisiamall.subService.GestionSubscripeRemote;

public class subscripeDelegate {
private final static String jndiName="tunisiamall-server/GestionSubscripe!edu.tunisiamall.GestionSubscripeRemote";
	
	public static GestionSubscripeRemote getProxy(){
	return (GestionSubscripeRemote) ServiceLocator.getInstance().getProxy(jndiName);
	
	}
	
	public List<Subscription> findAllSub(){
		return getProxy().findAllSub();
	}

}
