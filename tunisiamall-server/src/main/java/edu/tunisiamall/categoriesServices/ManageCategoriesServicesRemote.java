package edu.tunisiamall.categoriesServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.*;

@Remote
public interface ManageCategoriesServicesRemote {

	public void addCategory(Category c);
	public void deleteCategory(Category c);
	public void updateCategory(Category c);
	public Category findCtegoryById(Integer id);
	public List<Category> findAllCategory();
}
