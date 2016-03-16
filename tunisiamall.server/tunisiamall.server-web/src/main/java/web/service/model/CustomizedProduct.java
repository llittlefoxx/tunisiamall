package web.service.model;

import java.util.List;

import edu.tunisiamall.entities.Image;

public class CustomizedProduct {

	private int id;
	private String libelle;
	private int idCategory;
	private String category;
	private Double promotionVal;
	private int idSubCat;
	private String subCat;
    private List<Image> url;
    private Double price;
    private int qte;
	public CustomizedProduct(int id, int qte,String libelle, int idCategory, String category, Double promotionVal, int idSubCat,
			String subCat, List<Image> url, Double price) {
		super();
		this.id = id;
		this.qte=qte;
		this.libelle = libelle;
		this.idCategory = idCategory;
		this.category = category;
		this.promotionVal = promotionVal;
		this.idSubCat = idSubCat;
		this.subCat = subCat;
		this.url = url;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	
	
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPromotionVal() {
		return promotionVal;
	}
	public void setPromotionVal(Double promotionVal) {
		this.promotionVal = promotionVal;
	}
	public int getIdSubCat() {
		return idSubCat;
	}
	public void setIdSubCat(int idSubCat) {
		this.idSubCat = idSubCat;
	}
	public String getSubCat() {
		return subCat;
	}
	public void setSubCat(String subCat) {
		this.subCat = subCat;
	}
	public List<Image> getUrl() {
		return url;
	}
	public void setUrl(List<Image> url) {
		this.url = url;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
    
}
