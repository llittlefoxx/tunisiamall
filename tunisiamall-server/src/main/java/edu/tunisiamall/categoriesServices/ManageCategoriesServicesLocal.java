package edu.tunisiamall.categoriesServices;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Category;

@Local
public interface ManageCategoriesServicesLocal {
	public void addCategory(Category c);
	public void deleteCategory(Category c);
	public void updateCategory(Category c);
	public Category findCtegoryById(Integer id);
	public List<Category> findAllCategory();
}
