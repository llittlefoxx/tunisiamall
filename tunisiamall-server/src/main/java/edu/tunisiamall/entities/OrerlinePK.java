package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the orerline database table.
 * 
 */
@Embeddable
public class OrerlinePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idOrder;

	@Column(insertable=false, updatable=false)
	private int idProduct;

	private int idOrderLine;

	public OrerlinePK() {
	}
	public int getIdOrder() {
		return this.idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public int getIdProduct() {
		return this.idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdOrderLine() {
		return this.idOrderLine;
	}
	public void setIdOrderLine(int idOrderLine) {
		this.idOrderLine = idOrderLine;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrerlinePK)) {
			return false;
		}
		OrerlinePK castOther = (OrerlinePK)other;
		return 
			(this.idOrder == castOther.idOrder)
			&& (this.idProduct == castOther.idProduct)
			&& (this.idOrderLine == castOther.idOrderLine);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrder;
		hash = hash * prime + this.idProduct;
		hash = hash * prime + this.idOrderLine;
		
		return hash;
	}
}