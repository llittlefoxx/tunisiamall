package edu.tunisiamall.categorieServices;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Category;

/**
 * Session Bean implementation class CategoryServices
 */
@Stateless
public class CategoryServices implements CategoryServicesRemote, CategoryServicesLocal {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CategoryServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		em.persist(c);
		
	}

	@Override
	public void updateCategroy(Category c) {
		// TODO Auto-generated method stub
		em.merge(c);
		
	}

	@Override
	public void deleteCategory(int idCategory) {
		// TODO Auto-generated method stub
		em.remove(findCategoryById(idCategory));
	}

	@Override
	public Category findCategoryById(int idCategory) {
		// TODO Auto-generated method stub
		return em.find(Category.class, idCategory);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String queryText = "select c from Category c";
		Query query = em.createQuery(queryText);
		//query.getSingleResult();
		return query.getResultList();
	}

	@Override
	public Category SearchCategory(String L) {
		// TODO Auto-generated method stub
		//String queryText = 
		Query query = em.createQuery("select c.name from Category c where c.name like :Name")
				.setParameter("Name",L);
		return (Category) query.getSingleResult();
		
	}

}
