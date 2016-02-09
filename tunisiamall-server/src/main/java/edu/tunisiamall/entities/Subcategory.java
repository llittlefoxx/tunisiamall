package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subcategory database table.
 * 
 */
@Entity
@NamedQuery(name="Subcategory.findAll", query="SELECT s FROM Subcategory s")
public class Subcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSubCategory;

	private String description;

	private String libelle;

	//bi-directional many-to-many association to Store
	@ManyToMany(mappedBy="subcategories")
	private List<Store> stores;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="subcategory")
	private List<Product> products;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="IdCategory")
	private Category category;

	public Subcategory() {
	}

	public int getIdSubCategory() {
		return this.idSubCategory;
	}

	public void setIdSubCategory(int idSubCategory) {
		this.idSubCategory = idSubCategory;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Store> getStores() {
		return this.stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSubcategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSubcategory(null);

		return product;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}