package edu.tunisiamall.storeServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Store;

@Remote
public interface GestionStoreRemote {
	public List<Store> findAllStore();
}
