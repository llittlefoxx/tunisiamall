package admin.dashboard;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.categorieServices.CategoryServicesRemote;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Subcategory;

public class TestClasse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CategoryServicesRemote categoryServicesRemote;
		
		try {
		Context ctxCategory = new InitialContext();
			categoryServicesRemote = (CategoryServicesRemote) ctxCategory.lookup(
					"tunisiamall-server/CategoryServices!edu.tunisiamall.categorieServices.CategoryServicesRemote");
			// creation et ajout d'une categorie
			Category category = new Category();
			category.setLibelle("aaaa");
			category.setDescription("ssssss");
			//categoryServicesRemote.addCategory(category);
			//subcategory
			Subcategory subcategory = new Subcategory();
			subcategory.setLibelle("ssssssss");
			subcategory.setDescription("sssss");
			subcategory.setCategory(categoryServicesRemote.findCategoryByName("aaaa"));
			//categoryServicesRemote.addSubCategory(subcategory);
			//product
			Date date = new Date(2016, 02, 11);
			Product product = new Product();
			product.setLibelle("ccccc");
			product.setSellPrice(12.88);
			product.setBuyPrice(12.5);
			product.setExpDate(date);
			product.setQte(10);
			product.setTax(11.0);
			product.setCriticalZone(5);
			product.setSubcategory(categoryServicesRemote.findSubCatByName("ssssssss"));
			categoryServicesRemote.addProduct(product);

			
	
			// test getallproducts
			//for (Product p : categoryServicesRemote.getAllProducts()) {
			//	System.out.println(p.toString());
		//	}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
