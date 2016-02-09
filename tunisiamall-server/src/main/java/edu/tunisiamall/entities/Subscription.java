package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subscriptions database table.
 * 
 */
@Entity
@Table(name="subscriptions")
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SubscriptionPK id;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="idUser")
	private Customer customer;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="IdEvent")
	private Event event;

	public Subscription() {
	}

	public SubscriptionPK getId() {
		return this.id;
	}

	public void setId(SubscriptionPK id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}