package Delegates;

import java.util.List;

import Locator.ServiceLocator;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.StoreServicesRemote;

public class StoreServicesDelegate {

	private static StoreServicesRemote remote;
	private static StoreServicesRemote getProxy(){
		return (StoreServicesRemote) ServiceLocator.getInstance().getProxy("tunisiamall-server/StoreServices!edu.tunisiamall.storeServices.StoreServicesRemote");
	}	
	public static void addStore(Store store){
		getProxy().addStore(store);
	}
	public static void deleteStore(Store store){
		getProxy().deleteStore(store.getIdStore());
	}
	public static void updateStore(Store store){
		getProxy().updateStore(store.getIdStore());
	}
	public static Store findStoreById(Integer id){
		return getProxy().findStoreById(id);
	}
	public static List<Store> findAllSStoreByCategory(Category category){
		return getProxy().findAllStoreByCategory(category.getLibelle());
	}

}
