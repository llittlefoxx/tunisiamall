package edu.tunisiamall.GuestBookServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public void deleteEntries(int idEntries) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Gestbookentry> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gestbookentry findEntryById(int idEtries) {
		// TODO Auto-generated method stub
		return em.find(Gestbookentry.class, idEtries);
	}

}
