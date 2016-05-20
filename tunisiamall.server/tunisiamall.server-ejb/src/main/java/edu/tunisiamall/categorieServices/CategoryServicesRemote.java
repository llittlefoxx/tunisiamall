package edu.tunisiamall.categorieServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Subcategory;

@Remote
public interface CategoryServicesRemote {
	public Category addCategory(Category category);

	public Product findProductById(int id);

	public void addProduct(Product product);

	public void updateProduct(Product product);

	public Subcategory addSubCategory(Subcategory subcategory);

	public Category findCategoryByName(String name);

	public Subcategory findSubCatByName(String name);

	public void updateCategroy(Category c);

	public void deleteCategory(Category c);

	public Category findCategoryById(int idCategory);

	public List<Category> findAll();

	public List<Category> SearchCategory(String L);

	public Category SearchCategory2(String L);
}
