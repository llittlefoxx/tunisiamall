package edu.tunisiamall.shopRequestServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.tunisiamall.entities.ShopRequest;

/**
 * Session Bean implementation class ManageShopRequestServices
 */
@Stateless
public class ManageShopRequestServices implements ManageShopRequestServicesRemote, ManageShopRequestServicesLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
	
    public ManageShopRequestServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addShopRequest(ShopRequest srequest) {
		em.persist(srequest);
		
	}

	@Override
	public void deleteShopRequest(ShopRequest srequest) {
		em.remove(em.merge(srequest));
		
	}

	@Override
	public void updateShopRequest(ShopRequest srequest) {
		em.merge(srequest);
		
	}



	@Override
	public List<ShopRequest> findAllShopRequest() {
		Query query = em.createQuery("select s from ShopRequest s ");
		return query.getResultList();
		
	}

	
	@Override
	public ShopRequest findShopRequestById(Integer id) {
		return em.find(ShopRequest.class, id);
		
		 
	}

	@Override
	public List<ShopRequest> findAllShopRequestByCategory(String caegory) {
		return null;
	
	}

	@Override
	public List<ShopRequest> findAllShopRequestByRcptDate(Date date) {
		Query query = em.createQuery("select s from ShopRequest s where s.rcptDate:= rcptDate");
		query.setParameter("rcptDate", date);
		return query.getResultList();
		
	}

	@Override
	public List<ShopRequest> findAllShopRequestSearchTools(String category, String status, Date rcptDate) {
		
		List<ShopRequest> lists = new ArrayList<ShopRequest>();

        String sql = "select s from ShopRequest ";
        if (category != null || rcptDate != null || status != null ) {
            sql += "where ";
            if (category != null && !category.equals("")) {
                sql += "s.category:='" + category + "' and ";
            }
            if (status != null) {
                sql += "s.status:='" + status + "' and ";
            }
            if (rcptDate != null) {
                sql += "s.rcptDate:='" + rcptDate + "' and ";
            }
            sql = sql.substring(0, sql.length() - 4);
        }
        Query query = em.createQuery(sql);
		query.setParameter("rcptDate", rcptDate).setParameter("status", status).setParameter("category", category);
		return query.getResultList();
	}

}
