package edu.tunisiamall.biservices;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.PromotionSuggest;
import edu.tunisiamall.entities.Store;

@Remote
public interface IndicatorsServiceRemote {

	// indicators
	public List<Product> getAllProducts();

	public List<Product> getAllPromotionProducts();

	public HashMap<Product,Integer> getHotProducts();

	public List<Store> getTopSellingStores();

	public Map<String, Double> getIncomeByPeriod(Date startDate, Date endDate);

	// report

	public void CreateReport(String name, String mesure, Date startDate, Date endDate);

	public void DeleteReport(String name);

	// promotionsSuggest

	public void createPromotionSuggest(PromotionSuggest promotionSuggest);

	public void deletePromotionSuggest(int idPromotionSuggest);

	public void editPromotionSuggest(PromotionSuggest promotionSuggest);

	public List<PromotionSuggest> getAllPromotionSuggest();

	public PromotionSuggest findPromotionSuggestById(int id);

	public void affectPromotionSuggestToProduct(int p, int pr);
	
	public List<Product> getProductsByPromotionSugg(int idSugP);
}
