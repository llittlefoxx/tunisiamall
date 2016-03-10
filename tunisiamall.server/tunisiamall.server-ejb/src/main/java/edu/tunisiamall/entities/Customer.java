package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@DiscriminatorValue("customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer extends User implements Serializable {
	private static final long serialVersionUID = 1L;


	private String facturationAddr;

	private String shipementAddr;

	

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer")
	private List<Order> orders;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="customer")
	private List<Subscription> subscriptions;

	public Customer() {
	}

	public String getFacturationAddr() {
		return facturationAddr;
	}

	public void setFacturationAddr(String facturationAddr) {
		this.facturationAddr = facturationAddr;
	}

	public String getShipementAddr() {
		return shipementAddr;
	}

	public void setShipementAddr(String shipementAddr) {
		this.shipementAddr = shipementAddr;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}