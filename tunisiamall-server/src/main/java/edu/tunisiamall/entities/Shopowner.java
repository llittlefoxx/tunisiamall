package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the shopowner database table.
 * 
 */
@Entity
@NamedQuery(name="Shopowner.findAll", query="SELECT s FROM Shopowner s")
public class Shopowner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateActivation;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="idUser")
	private User user;

	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="shopowner")
	private List<Store> stores;

	public Shopowner() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getDateActivation() {
		return this.dateActivation;
	}

	public void setDateActivation(Date dateActivation) {
		this.dateActivation = dateActivation;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Store> getStores() {
		return this.stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setShopowner(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setShopowner(null);

		return store;
	}

}