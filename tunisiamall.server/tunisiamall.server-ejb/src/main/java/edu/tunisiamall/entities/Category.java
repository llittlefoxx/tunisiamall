package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.tunisiamall.entities.ShopRequest;

import java.util.List;


@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategory;

	private String description;

	private String libelle;
	
	@OneToMany(mappedBy="category")
	@JsonBackReference
	private List<ShopRequest> requests;
	
	@OneToMany(mappedBy="category")
	@JsonBackReference
	private List<Store> stores;
	
	//bi-directional many-to-one association to Subcategory
	@OneToMany(mappedBy="category")
	@JsonIgnore
	private List<Subcategory> subcategories;

	public Category() {
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Subcategory> getSubcategories() {
		return this.subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public List<ShopRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<ShopRequest> requests) {
		this.requests = requests;
	}

	public Subcategory addSubcategory(Subcategory subcategory) {
		getSubcategories().add(subcategory);
		subcategory.setCategory(this);

		return subcategory;
	}

	public Subcategory removeSubcategory(Subcategory subcategory) {
		getSubcategories().remove(subcategory);
		subcategory.setCategory(null);

		return subcategory;
	}
	
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", description=" + description + ", libelle=" + libelle
				 + "]";
	}

	@Override
	public int hashCode() {
		return idCategory;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (idCategory != other.idCategory)
			return false;
		return true;
	}
	
}
