package admin.dashboard;

public class ProductInPromSuggest {

	private int id;
	private String libelle;
	private double sellprice;
	private double buyprice;
	private double gain;
	private String promotionsuggName;

	public String getLibelle() {
		return libelle;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getSellprice() {
		return sellprice;
	}

	public void setSellprice(double sellprice) {
		this.sellprice = sellprice;
	}

	public double getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(double buyprice) {
		this.buyprice = buyprice;
	}

	public double getGain() {
		return gain;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}

	public String getPromotionsuggName() {
		return promotionsuggName;
	}

	public void setPromotionsuggName(String promotionsuggName) {
		this.promotionsuggName = promotionsuggName;
	}

}
