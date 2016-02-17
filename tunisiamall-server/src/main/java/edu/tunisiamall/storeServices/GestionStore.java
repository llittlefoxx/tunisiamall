package edu.tunisiamall.storeServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Store;


/**
 * Session Bean implementation class GestionStore
 */
@Stateless
public class GestionStore implements GestionStoreRemote, GestionStoreLocal {

	@PersistenceContext(unitName="tunisiamall-server")
	EntityManager entityManager;
    public GestionStore() {}
       
    	public List<Store> findAllStore() {
    		Query query=entityManager.createQuery("select s from  Store");
    		return query.getResultList();
    		
    	}


}
