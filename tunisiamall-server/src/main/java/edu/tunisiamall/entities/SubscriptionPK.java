package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the subscriptions database table.
 * 
 */
@Embeddable
public class SubscriptionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idUser;

	@Column(insertable=false, updatable=false)
	private int idEvent;

	private int idSubscription;

	public SubscriptionPK() {
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdEvent() {
		return this.idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public int getIdSubscription() {
		return this.idSubscription;
	}
	public void setIdSubscription(int idSubscription) {
		this.idSubscription = idSubscription;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SubscriptionPK)) {
			return false;
		}
		SubscriptionPK castOther = (SubscriptionPK)other;
		return 
			(this.idUser == castOther.idUser)
			&& (this.idEvent == castOther.idEvent)
			&& (this.idSubscription == castOther.idSubscription);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser;
		hash = hash * prime + this.idEvent;
		hash = hash * prime + this.idSubscription;
		
		return hash;
	}
}