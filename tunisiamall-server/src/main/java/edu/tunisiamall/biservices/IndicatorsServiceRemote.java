package edu.tunisiamall.biservices;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Store;

@Remote
public interface IndicatorsServiceRemote {
	public List<Product> getAllProducts();
	public List<Product> getAllPromotionProducts();
	public List<Product> getHotProducts();
	public List<Product> getStockStatus();
	public List<Store> getTopSellingStores();
	public Map<String, Double> getIncomeByPeriod(Date startDate,Date endDate);
	
}
