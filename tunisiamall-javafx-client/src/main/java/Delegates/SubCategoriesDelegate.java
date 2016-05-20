package Delegates;

import java.util.List;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Subcategory;
import edu.tunisiamall.subCategoriesServices.SubCategoriesServicesRemote;

public class SubCategoriesDelegate {
	private static SubCategoriesServicesRemote remote;
	private static String jndiName = "tunisiamall.server-ear/tunisiamall.server-ejb/SubCategoriesServices!edu.tunisiamall.subCategoriesServices.SubCategoriesServicesRemote";
	
	private static SubCategoriesServicesRemote getProxy() {
		return (SubCategoriesServicesRemote) Locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}
	
	public static List<Subcategory> findAll(){
		
		return getProxy().findAll();
	}

}
