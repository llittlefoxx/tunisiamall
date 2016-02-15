package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;


@Embeddable
public class OrerlinePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;


	private int idOrderLine;
	
	public OrerlinePK() {
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + idOrderLine;

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrerlinePK other = (OrerlinePK) obj;

		if (idOrderLine != other.idOrderLine)
			return false;

		return true;
	}



}