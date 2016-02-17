package Delegates;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.PromotionSuggest;
import edu.tunisiamall.entities.Store;

public class DashBoardDelegate {

	private static IndicatorsServiceRemote indicatorsServiceRemote;
	private final static String jndiName = "tunisiamall-server/IndicatorsService!edu.tunisiamall.biservices.IndicatorsServiceRemote";

	private static IndicatorsServiceRemote getProxy() {
		return (IndicatorsServiceRemote) Locator.ServiceLocator.getInstance().getProxy(jndiName);

	}

	public static double getNetGainPercentage(double buyPrice, double sellPrice, double tax) {
		return getProxy().getNetGainPercentage(buyPrice, sellPrice, tax);
	}

	public static List<Product> getAllProducts() {
		return getProxy().getAllProducts();
	}

	public static List<Product> getAllPromotionProducts() {
		return getProxy().getAllPromotionProducts();
	}

	public static HashMap<Product, Integer> getHotProducts() {
		return getProxy().getHotProducts();
	}

	public static HashMap<Store, Double> getTopSellingStores() {
		return getProxy().getTopSellingStores();
	}

	public static double getTotalIncome() {
		return getProxy().getTotalIncome();
	}

	public static Map<String, Double> getMonthlyIncome() {
		return getProxy().getMonthlyIncome();
	}

	public static List<Product> findProductByLib(String lib) {
		return getProxy().findProductByLib(lib);
	}

	public static Product findProductById(int id) {
		return getProxy().findProductById(id);
	}

	public static HashMap<Store, Promotion> getPromotionByStore() {
		return getProxy().getPromotionByStore();
	}

	public static Promotion findPromotionById(Long idprom) {
		return getProxy().findPromotionById(idprom);
	}

	public static Store findStoreById(int idStore) {
		return getProxy().findStoreById(idStore);
	}

	// report

	public static void CreateReport(String name, String mesure, Date startDate, Date endDate) {
		getProxy().CreateReport(name, mesure, startDate, endDate);
	}

	public static void DeleteReport(String name) {
		getProxy().DeleteReport(name);
	}

	// promotionsSuggest

	public static void createPromotionSuggest(PromotionSuggest promotionSuggest) {
		getProxy().createPromotionSuggest(promotionSuggest);
	}

	public static void deletePromotionSuggest(int idPromotionSuggest) {
		getProxy().deletePromotionSuggest(idPromotionSuggest);
	}

	public static void editPromotionSuggest(PromotionSuggest promotionSuggest) {
		getProxy().editPromotionSuggest(promotionSuggest);
	}

	public static List<PromotionSuggest> getAllPromotionSuggest() {
		return getProxy().getAllPromotionSuggest();
	}

	public static PromotionSuggest findPromotionSuggestById(int id) {
		return getProxy().findPromotionSuggestById(id);
	}

	public static List<PromotionSuggest> findPromotionSuggestByName(String name) {
		return getProxy().findPromotionSuggestByName(name);
	}

	public static void affectPromotionSuggestToProduct(int prod, int prom) {
		getProxy().affectPromotionSuggestToProduct(prod, prom);
	}

	public static void removePromotionSuggestFromProduct(int idproduct) {
		getProxy().removePromotionSuggestFromProduct(idproduct);
	}

	public static List<Product> getProductsByPromotionSugg(int idSugP) {
		return getProxy().getProductsByPromotionSugg(idSugP);
	}

	public static PromotionSuggest findPromotionSuggestByIdProd(int idProd) {
		return getProxy().findPromotionSuggestByIdProd(idProd);
	}

}
