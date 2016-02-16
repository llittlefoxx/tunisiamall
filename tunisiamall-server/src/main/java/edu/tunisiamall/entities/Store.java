package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStroe;

	private String description;

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

}