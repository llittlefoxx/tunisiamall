package edu.tunisiamall.shopRequestServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.ShopRequest;

@Remote
public interface ManageShopRequestServicesRemote {

	public void addShopRequest(ShopRequest srequest);
	public void deleteShopRequest(ShopRequest srequest);
	public void updateShopRequest(ShopRequest srequest);
	public ShopRequest findShopRequestById(Integer id);
	public List<ShopRequest> findAllShopRequest();
	public List<ShopRequest> findAllShopRequestByCategory(String caegory);
	public List<ShopRequest> findAllShopRequestByRcptDate(Date date);
	public List<ShopRequest> findAllShopRequestSearchTools(String category, String status, Date rcptDate);
	
}
