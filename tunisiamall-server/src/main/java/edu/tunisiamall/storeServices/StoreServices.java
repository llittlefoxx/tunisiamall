package edu.tunisiamall.storeServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Store;

/**
 * Session Bean implementation class StoreServices
 */
@Stateless
public class StoreServices implements StoreServicesRemote, StoreServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public StoreServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addStore(Store store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStore(Store store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStore(Store store) {
		em.merge(store);
		
	}

	@Override
	public Store findStoreById(Integer id) {
		return em.find(Store.class, id);
	}


	@Override
	public List<Store> findAllSStoreByCategory(Category category) {
		Query query=em.createQuery("select st from Store st where st.category=:id")
				.setParameter("id", category);
		return query.getResultList();
	}

	

}
