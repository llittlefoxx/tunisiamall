package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the storeevent database table.
 * 
 */
@Entity
@NamedQuery(name="Storeevent.findAll", query="SELECT s FROM Storeevent s")
public class Storeevent implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StoreeventPK id;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="IdStroe")
	private Store store;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="IdEvent")
	private Event event;

	public Storeevent() {
	}

	public StoreeventPK getId() {
		return this.id;
	}

	public void setId(StoreeventPK id) {
		this.id = id;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}