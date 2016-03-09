package edu.tunisiamall.storeServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Store;

@Remote
public interface StoreServicesRemote {

	public void addStore(Store store);
	public void deleteStore(Store store);
	public void updateStore(Store store);
	public Store findStoreById(Integer id);
	public List<Store> findAllSStoreByCategory(Category category);

	
}
