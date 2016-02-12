package Delegates;

import java.util.List;

import edu.tunisiamall.shopRequestServices.ManageShopRequestServicesRemote;
import edu.tunisiamall.entities.ShopRequest;
import Locator.ServiceLocator;

public class ManageShopRequestDelegate {
	
	private static ManageShopRequestServicesRemote remote;
	
	private static ManageShopRequestServicesRemote getProxy(){
		return (ManageShopRequestServicesRemote) ServiceLocator.getInstance().getProxy("ejb-pidev-kenza/ManageShopRequestServices!edu.esprit.services.shoprequest.ManageShopRequestServicesRemote");
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
	
	

}

