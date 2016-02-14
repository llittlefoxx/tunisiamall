package edu.tunisiamall.biservices;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.In;

import edu.tunisiamall.categorieServices.CategoryServicesLocal;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.PromotionSuggest;
import edu.tunisiamall.entities.Store;

/**
 * Session Bean implementation class IndicatorsService
 */
@Stateless
public class IndicatorsService implements IndicatorsServiceRemote, IndicatorsServiceLocal {

	/**
	 * Default constructor.
	 */
	@EJB
	private CategoryServicesLocal categoryServicesLocal;

	@PersistenceContext
	EntityManager em;

	public IndicatorsService() {
	}

	@Override
	public List<Product> getAllProducts() {
		Query query = em.createNamedQuery("Product.findAll");
		return query.getResultList();
	}

	@Override
	public List<Product> getAllPromotionProducts() {
		Query query = em.createQuery("select p from Product p where p.Promotion IS NOT NULL");
		return query.getResultList();
	}

	@Override
	public HashMap<Product, Integer> getHotProducts() {

		HashMap<Product, Integer> result = new HashMap<Product, Integer>();
		Product product = new Product();
		List<Object[]> itemsList = (ArrayList<Object[]>) em
				.createNativeQuery(
						"select product.idProduct ,sum(orderline.qte) from product ,orderline where product.idProduct=orderline.idProduct_fk group by orderline.idProduct_fk")
				.getResultList();

		for (Object[] objects : itemsList) {
			int id = Integer.parseInt((objects[0]).toString());
			product = categoryServicesLocal.findProductById(id);
			int qte = Integer.parseInt((objects[1]).toString());
			result.put(product, qte);
			
			System.out.println("produit : "+product.getLibelle()+" Sells qte: "+qte);
		}
		return result;
	}

	@Override
	public List<Store> getTopSellingStores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getIncomeByPeriod(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CreateReport(String name, String mesure, Date startDate, Date endDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteReport(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPromotionSuggest(PromotionSuggest promotionSuggest) {
		em.persist(promotionSuggest);
	}

	@Override
	public void deletePromotionSuggest(int idPromotionSuggest) {
		List<Product> listP = new ArrayList<Product>();

		listP = getProductsByPromotionSugg(idPromotionSuggest);

		System.out.println(listP.size());
		for (Product product : listP) {
			product.setPromotionSuggest(null);
			categoryServicesLocal.updateProduct(product);
		}

		em.remove(findPromotionSuggestById(idPromotionSuggest));

	}

	@Override
	public void editPromotionSuggest(PromotionSuggest promotionSuggest) {
		em.merge(promotionSuggest);

	}

	@Override
	public List<PromotionSuggest> getAllPromotionSuggest() {
		Query query = em.createNamedQuery("PromotionSuggest.findAll");
		return query.getResultList();
	}

	@Override
	public PromotionSuggest findPromotionSuggestById(int id) {
		return em.find(PromotionSuggest.class, id);
	}

	@Override
	public void affectPromotionSuggestToProduct(int idpr, int idsugg) {
		Product p = new Product();
		p = categoryServicesLocal.findProductById(idpr);
		PromotionSuggest prs = new PromotionSuggest();
		prs = findPromotionSuggestById(idsugg);
		p.setPromotionSuggest(prs);
		categoryServicesLocal.updateProduct(p);
	}

	@Override
	public List<Product> getProductsByPromotionSugg(int idSugP) {
		Query query = em.createQuery("select p from Product p where p.promotionSuggest.idPromotionSuggest = :idSugP")
				.setParameter("idSugP", idSugP);

		return query.getResultList();
	}

}
