package edu.tunisiamall.storeServices;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Store;

@Local
public interface GestionStoreLocal {
	public List<Store> findAllStore();

}
