package edu.tunisiamall.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * Entity implementation class for Entity: OrderLine
 *
 */
@Entity
@NamedQuery(name="OrderLine.findAll", query="SELECT o FROM OrderLine o")
public class OrderLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrerlinePK id;

	private int qte;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="idOrder_fk")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="idProduct_fk")
	private Product product;

	public OrderLine() {
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