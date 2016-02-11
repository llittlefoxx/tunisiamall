package edu.tunisiamall.categorieServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Category;

@Remote
public interface CategoryServicesRemote {
	public void addCategory(Category c);
	public void updateCategroy(Category c);
	public void deleteCategory(int idCategory);
	public Category findCategoryById(int idCategory);
	public List<Category> findAll();
	public List<Category> SearchCategory(String L);
}
