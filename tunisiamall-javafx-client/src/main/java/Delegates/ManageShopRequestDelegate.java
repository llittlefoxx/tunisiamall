package Delegates;

import java.util.Date;
import java.util.List;

import edu.tunisiamall.shopRequestServices.ManageShopRequestServicesRemote;
import edu.tunisiamall.entities.ShopRequest;
import Locator.ServiceLocator;

public class ManageShopRequestDelegate {
	
	private static ManageShopRequestServicesRemote remote;
	
	private static ManageShopRequestServicesRemote getProxy(){
		return (ManageShopRequestServicesRemote) ServiceLocator.getInstance().getProxy("tunisiamall-server/ManageShopRequestServices!edu.tunisiamall.shopRequestServices.ManageShopRequestServicesRemote");
	}
	public static void doAddShopRequest(ShopRequest srequest)
	{
		getProxy().addShopRequest(srequest);
	}
	
	public static void doDeleteShopRequest(ShopRequest srequest)
	{
		getProxy().deleteShopRequest(srequest);
	}
	public static void doUpdateShopRequest(ShopRequest srequest)
	{
		getProxy().updateShopRequest(srequest);
	}
	public static ShopRequest doFindShopRequestById(Integer id)
	{
		return getProxy().findShopRequestById(id);
	}
	public static List<ShopRequest> doFindAllShopRequest()
	{
		 return getProxy().findAllShopRequest();
	}
	public static List<ShopRequest> doFindAllShopRequestByCategory(String caegory){
		return getProxy().findAllShopRequestByCategory(caegory);
	}
	public static List<ShopRequest> doFindAllShopRequestUnchecked(){
		return getProxy().findAllShopRequestUnchecked();
	}
	public static List<ShopRequest> doFindAllShopRequestSearchTools(String email, int storeimall){
		return getProxy().findAllShopRequestSearchTools(email, storeimall);
	}
	public static List<ShopRequest> doFindAllShopRequestByWord(String word) {
		return getProxy().findAllShopRequestByWord(word);
	}
	
	public static List<ShopRequest> findAllShopRequestByRcptDate(Date date){
		return getProxy().findAllShopRequestByRcptDate(date);
	}

}

