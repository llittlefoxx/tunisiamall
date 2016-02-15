package Delegates;


import java.util.List;

import edu.tunisiamall.entities.*;
import edu.tunisiamall.categorieServices.CategoryServicesRemote;
import Locator.ServiceLocator;

public class CategoryDelegate {

		
		private static CategoryServicesRemote remote;
		
		private static CategoryServicesRemote getProxy(){
			return (CategoryServicesRemote) ServiceLocator.getInstance().getProxy("tunisiamall-server/CategoryServices!edu.tunisiamall.categorieServices.CategoryServicesRemote");
		}
		public static void doAddCategory(Category c)
		{
			getProxy().addCategory(c);;
		}
		
		public static void doDeleteCategory(int idCategory)
		{
			getProxy().deleteCategory(idCategory);
		}
		public static void doUpdateCategory(Category c)
		{
			getProxy().updateCategroy(c);;
		}
		public static Category doFindCategoryById(Integer id)
		{
			return getProxy().findCategoryById(id);
		}
		public static List<Category> doFindAllCategory()
		{
			 return getProxy().findAll();
		}
		public static Category doFindAllCategoryByLibelle(String l)
		{
			 return getProxy().SearchCategory(l);
		}
		
		

	


}
