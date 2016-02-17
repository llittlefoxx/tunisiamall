package edu.tunisiamall.storeEvent;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Event;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.entities.Storeevent;

/**
 * Session Bean implementation class GestionStoreEvent
 */
@Stateless
public class GestionStoreEvent implements GestionStoreEventRemote, GestionStoreEventLocal {

	@PersistenceContext(unitName = "tunisiamall-server")
	EntityManager entityManager;
	
    public GestionStoreEvent() {}
    	public List<Storeevent> findAllStoreEvent(){
    		Query query = entityManager.createNamedQuery("Storeevent.findAll");
			return query.getResultList();
    	
    }
    	
    	public Boolean addStoreEvent(Storeevent storeevent) {
    		try {
    			entityManager.persist(storeevent);
    			return true;
    		} catch (Exception e) {
    			return false;
    			
    		}
    		
    	}

}
