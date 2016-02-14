package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;

	private double buyPrice;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expDate;

	private String libelle;

	private int qte;

	private int criticalZone;
	
	private double sellPrice;

	private String state;

	private String tag;

	private double tax;
	

	
	@ManyToOne
	private Promotion Promotion;
	
	@ManyToOne
	@JoinColumn(name="IdPromotionSuggest_fk")
	private PromotionSuggest promotionSuggest;
	
	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="product")
	private List<Image> images;

	//bi-directional many-to-one association to Mvtstock
	@OneToMany(mappedBy="product")
	private List<Mvtstock> mvtstocks;

	//bi-directional many-to-one association to Orerline
	
	@OneToMany(mappedBy="product")
	private List<OrderLine> orderline;
	
	public List<OrderLine> getOrderline() {
		return orderline;
	}

	public void setOrderline(List<OrderLine> orderline) {
		this.orderline = orderline;
	}

	//bi-directional many-to-one association to Subcategory
	@ManyToOne
	@JoinColumn(name="IdSubCategory")
	private Subcategory subcategory;

	public Product() {
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public double getBuyPrice() {
		return this.buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQte() {
		return this.qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public double getTax() {
		return this.tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setProduct(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setProduct(null);

		return image;
	}

	public List<Mvtstock> getMvtstocks() {
		return this.mvtstocks;
	}

	public void setMvtstocks(List<Mvtstock> mvtstocks) {
		this.mvtstocks = mvtstocks;
	}

	public Mvtstock addMvtstock(Mvtstock mvtstock) {
		getMvtstocks().add(mvtstock);
		mvtstock.setProduct(this);

		return mvtstock;
	}

	public Mvtstock removeMvtstock(Mvtstock mvtstock) {
		getMvtstocks().remove(mvtstock);
		mvtstock.setProduct(null);

		return mvtstock;
	}


	public Subcategory getSubcategory() {
		return this.subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public Promotion getPromotion() {
		return Promotion;
	}

	public void setPromotion(Promotion promotion) {
		Promotion = promotion;
	}

	
	
	public int getCriticalZone() {
		return criticalZone;
	}

	public void setCriticalZone(int criticalZone) {
		this.criticalZone = criticalZone;
	}

	public PromotionSuggest getPromotionSuggest() {
		return promotionSuggest;
	}

	public void setPromotionSuggest(PromotionSuggest promotionSuggest) {
		this.promotionSuggest = promotionSuggest;
	}

	
}