package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orerline database table.
 * 
 */
@Entity
@NamedQuery(name="Orerline.findAll", query="SELECT o FROM Orerline o")
public class Orerline implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrerlinePK id;

	private int qte;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="idOrder_FK")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idProduct_fk")
	private Product product;

	public Orerline() {
	}

	public OrerlinePK getId() {
		return this.id;
	}

	public void setId(OrerlinePK id) {
		this.id = id;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}