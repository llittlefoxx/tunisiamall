package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStroe;

	private String description;
	
	
	@ManyToOne
	@JoinColumn(name="category_fk")
	private Category category;
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date openingDay;

	private String status;

	private String tel;

	//bi-directional many-to-many association to Subcategory
	@ManyToMany
	@JoinTable(
		name="assstoresubcategorie"
		, joinColumns={
			@JoinColumn(name="IdStroe")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IdSubCategory")
			}
		)
	private List<Subcategory> subcategories;

	//bi-directional many-to-one association to Shopowner
	@ManyToOne
	@JoinColumn(name="idUser")
	private Shopowner shopowner;

	//bi-directional many-to-one association to Storeevent
	@OneToMany(mappedBy="store")
	private List<Storeevent> storeevents;
	
	//bi-derictional onetomany with product
	@OneToMany(mappedBy="store",fetch=FetchType.EAGER)
	private List<Product> products;

	public Store() {
	}

	public int getIdStroe() {
		return this.idStroe;
	}

	public void setIdStroe(int idStroe) {
		this.idStroe = idStroe;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpeningDay() {
		return this.openingDay;
	}

	public void setOpeningDay(Date openingDay) {
		this.openingDay = openingDay;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Subcategory> getSubcategories() {
		return this.subcategories;
	}

	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}

	public Shopowner getShopowner() {
		return this.shopowner;
	}

	public void setShopowner(Shopowner shopowner) {
		this.shopowner = shopowner;
	}

	public List<Storeevent> getStoreevents() {
		return this.storeevents;
	}

	public void setStoreevents(List<Storeevent> storeevents) {
		this.storeevents = storeevents;
	}

	public Storeevent addStoreevent(Storeevent storeevent) {
		getStoreevents().add(storeevent);
		storeevent.setStore(this);

		return storeevent;
	}

	public Storeevent removeStoreevent(Storeevent storeevent) {
		getStoreevents().remove(storeevent);
		storeevent.setStore(null);

		return storeevent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + idStroe;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((openingDay == null) ? 0 : openingDay.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idStroe != other.idStroe)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (openingDay == null) {
			if (other.openingDay != null)
				return false;
		} else if (!openingDay.equals(other.openingDay))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	
	

}