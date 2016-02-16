package admin.dashboard;

import java.util.Date;

public class PromotionsByStore {

	private String storeName;
	private String peomoName;
	private Date startDate;
	private Date endDate;
	private double value;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getPeomoName() {
		return peomoName;
	}

	public void setPeomoName(String peomoName) {
		this.peomoName = peomoName;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
