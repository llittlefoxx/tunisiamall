package edu.tunisiamall.categoriesServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Category;

/**
 * Session Bean implementation class ManageCategoriesServices
 */
@Stateless
public class ManageCategoriesServices implements ManageCategoriesServicesRemote, ManageCategoriesServicesLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
    public ManageCategoriesServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCategory(Category c) {
		em.persist(c);
		
	}

	@Override
	public void deleteCategory(Category c) {
		em.remove(em.merge(c));
		
	}

	@Override
	public void updateCategory(Category c) {
		em.merge(c);
		
		
	}

	@Override
	public Category findCtegoryById(Integer id) {
		return em.find(Category.class, id);
	}

	@Override
	public List<Category> findAllCategory() {
		Query query = em.createQuery("select c from Category c ");
		return query.getResultList();
	}

}
