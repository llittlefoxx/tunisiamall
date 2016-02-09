package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the storeevent database table.
 * 
 */
@Embeddable
public class StoreeventPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idEvent;

	private int idStoreEvent;

	public StoreeventPK() {
	}
	public int getIdEvent() {
		return this.idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public int getIdStoreEvent() {
		return this.idStoreEvent;
	}
	public void setIdStoreEvent(int idStoreEvent) {
		this.idStoreEvent = idStoreEvent;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StoreeventPK)) {
			return false;
		}
		StoreeventPK castOther = (StoreeventPK)other;
		return 
			(this.idEvent == castOther.idEvent)
			&& (this.idStoreEvent == castOther.idStoreEvent);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEvent;
		hash = hash * prime + this.idStoreEvent;
		
		return hash;
	}
}