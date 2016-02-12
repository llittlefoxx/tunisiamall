package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrder;

	private BigDecimal amountPayed;

	private String cardHolder;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datePay;

	private String orderStatus;

	private String statusPayment;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="idUser")
	private Customer customer;

	//bi-directional many-to-one association to Orerline
	@OneToMany(mappedBy="order")
	private List<Orerline> orerlines;

	public Order() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public BigDecimal getAmountPayed() {
		return this.amountPayed;
	}

	public void setAmountPayed(BigDecimal amountPayed) {
		this.amountPayed = amountPayed;
	}

	public String getCardHolder() {
		return this.cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDatePay() {
		return this.datePay;
	}

	public void setDatePay(Date datePay) {
		this.datePay = datePay;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStatusPayment() {
		return this.statusPayment;
	}

	public void setStatusPayment(String statusPayment) {
		this.statusPayment = statusPayment;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Orerline> getOrerlines() {
		return this.orerlines;
	}

	public void setOrerlines(List<Orerline> orerlines) {
		this.orerlines = orerlines;
	}

	public Orerline addOrerline(Orerline orerline) {
		getOrerlines().add(orerline);
		orerline.setOrder(this);

		return orerline;
	}

	public Orerline removeOrerline(Orerline orerline) {
		getOrerlines().remove(orerline);
		orerline.setOrder(null);

		return orerline;
	}

}