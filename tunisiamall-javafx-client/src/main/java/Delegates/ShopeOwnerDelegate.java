package Delegates;


import java.util.List;


import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.shopOwnerServices.shopOwnerServiceRemote;



public class ShopeOwnerDelegate {
	
	private static shopOwnerServiceRemote remote;
	private final static String jndiName="tunisiamall.server-ear/tunisiamall.server-ejb/shopOwnerService!edu.tunisiamall.shopOwnerServices.shopOwnerServiceRemote"; 
	
	private static shopOwnerServiceRemote getProxy() {
		return (shopOwnerServiceRemote) Locator.ServiceLocator.getInstance().getProxy(
				jndiName);

	}
	
	public static List<Shopowner> findAllSO(){
		return getProxy().findAllSO();
	}
	public static void create(Shopowner so){
		getProxy().create(so);
	}
	
	public static void delete(Shopowner so){
		getProxy().delete(so);
		
	}
	public static void updateShopOwner(Shopowner so){
		getProxy().updateShopeOwner(so);
	}
	public static long count(){
		return getProxy().count();
	}
	public static List<Shopowner> find(String chaine, String value){
		return getProxy().find(chaine, value);
	}

}
