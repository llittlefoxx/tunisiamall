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
@DiscriminatorValue("shopowner")
@NamedQuery(name="Shopowner.findAll", query="SELECT s FROM User s")
public class Shopowner extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateActivation;


	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="shopowner")
	private List<Store> stores;

	public Shopowner() {
	}

	public Date getDateActivation() {
		return dateActivation;
	}

	public void setDateActivation(Date dateActivation) {
		this.dateActivation = dateActivation;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}