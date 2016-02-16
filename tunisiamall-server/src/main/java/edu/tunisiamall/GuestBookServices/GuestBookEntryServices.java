package edu.tunisiamall.GuestBookServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Gestbookentry;

/**
 * Session Bean implementation class GuestBookEntryServices
 */
@Stateless
public class GuestBookEntryServices implements GuestBookEntryServicesRemote, GuestBookEntryServicesLocal {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public GuestBookEntryServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void deleteEntries(Gestbookentry g) {
		em.remove(em.merge(g));
		
	}

	@Override
	public List<Gestbookentry> findAll() {
		Query query = em.createNamedQuery("Gestbookentry.findAll");
		return query.getResultList();
	}

	@Override
	public Gestbookentry findEntryById(int idEtries) {
		// TODO Auto-generated method stub
		return em.find(Gestbookentry.class, idEtries);
	}

}
