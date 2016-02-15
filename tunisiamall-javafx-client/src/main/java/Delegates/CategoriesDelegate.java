package Delegates;
import java.util.List;

import edu.tunisiamall.categorieServices.CategoryServicesRemote;
import edu.tunisiamall.entities.Category;


public class CategoriesDelegate {

	private static CategoryServicesRemote remote;
	private static String jndiName = "/tunisiamall-server/CategoryServices!edu.tunisiamall.categorieServices.CategoryServicesRemote";
	
	private static CategoryServicesRemote getProxy() {
		return (CategoryServicesRemote) Locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public void create(Category c){
		getProxy().addCategory(c);
	}
	public void delete(int idCategory){
		getProxy().deleteCategory(idCategory);
	}
	public void update(Category c){
		getProxy().updateCategroy(c);
	}
	public List <Category> findAll(){
		return getProxy().findAll();
	}
	public List<Category> SearchCategory(String L){
		return getProxy().SearchCategory(L);
	}
	}


