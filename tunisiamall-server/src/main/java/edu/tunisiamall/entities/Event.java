package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvent;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEvent;

	private String description;

	private int periodEvent;

	private String typeEvent;

	//bi-directional many-to-one association to Storeevent
	@OneToMany(mappedBy="event")
	private List<Storeevent> storeevents;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="event")
	private List<Subscription> subscriptions;

	public Event() {
	}

	public int getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public Date getDateEvent() {
		return this.dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPeriodEvent() {
		return this.periodEvent;
	}

	public void setPeriodEvent(int periodEvent) {
		this.periodEvent = periodEvent;
	}

	public String getTypeEvent() {
		return this.typeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}

	public List<Storeevent> getStoreevents() {
		return this.storeevents;
	}

	public void setStoreevents(List<Storeevent> storeevents) {
		this.storeevents = storeevents;
	}

	public Storeevent addStoreevent(Storeevent storeevent) {
		getStoreevents().add(storeevent);
		storeevent.setEvent(this);

		return storeevent;
	}

	public Storeevent removeStoreevent(Storeevent storeevent) {
		getStoreevents().remove(storeevent);
		storeevent.setEvent(null);

		return storeevent;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setEvent(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setEvent(null);

		return subscription;
	}

}