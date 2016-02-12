package edu.tunisiamall.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PromotionSuggest
 *
 */
@Entity

public class PromotionSuggest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPromotionSuggest;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date suggestionDate;
	
	@OneToMany(mappedBy="PromotionSuggest")
	private List<Product> products;
	
	public PromotionSuggest() {
		super();
	}

	public int getIdPromotionSuggest() {
		return idPromotionSuggest;
	}

	public void setIdPromotionSuggest(int idPromotionSuggest) {
		this.idPromotionSuggest = idPromotionSuggest;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSuggestionDate() {
		return suggestionDate;
	}

	public void setSuggestionDate(Date suggestionDate) {
		this.suggestionDate = suggestionDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
