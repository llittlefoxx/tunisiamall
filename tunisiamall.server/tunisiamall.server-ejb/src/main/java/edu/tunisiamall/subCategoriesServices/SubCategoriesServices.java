package edu.tunisiamall.subCategoriesServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.Subcategory;

/**
 * Session Bean implementation class SubCategoriesServices
 */
@Stateless
public class SubCategoriesServices implements SubCategoriesServicesRemote, SubCategoriesServicesLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public SubCategoriesServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteSubCategories(int idSubCategory) {
		// TODO Auto-generated method stub
		em.remove(findSubCategoryById(idSubCategory));

	}

	@Override
	public List<Subcategory> findAll() {
		Query query = em.createNamedQuery("Subcategory.findAll");
		return query.getResultList();
	}


	@Override
	public Subcategory findSubCategoryById(int idSubCategory) {
		// TODO Auto-generated method stub
		return em.find(Subcategory.class, idSubCategory);
	}

	@Override
	public void addSubCategory(Subcategory subcategory) {
		em.persist(subcategory);

	}

	@Override
	public List<Subcategory> findSubCategoryByIdCategory(int idCategory) {
		
		String queryText = "Select Sub from Subcategory Sub where Sub.idCategory = :xxx";
		Query query = em.createQuery(queryText)
				.setParameter("xxx", idCategory);
		return query.getResultList();
	}

}
