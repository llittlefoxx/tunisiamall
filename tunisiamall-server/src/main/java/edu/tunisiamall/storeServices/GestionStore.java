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

	@PersistenceContext(unitName = "tunisiamall-server")
	EntityManager entityManager;

	public GestionStore() {
	}

	public List<Store> findAllStore() {
		try {
			Query query = entityManager.createNamedQuery("Store.findAll");
			return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
