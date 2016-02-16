package admin.dashboard;

public class StockStatus {
	private String libelle;
	private int qte;
	private int criticalZone;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getCriticalZone() {
		return criticalZone;
	}

	public void setCriticalZone(int criticalZone) {
		this.criticalZone = criticalZone;
	}

}
