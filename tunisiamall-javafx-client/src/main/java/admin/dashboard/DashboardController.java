package admin.dashboard;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Entity;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.PromotionSuggest;
import edu.tunisiamall.entities.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DashboardController implements Initializable {

	IndicatorsServiceRemote indicatorsServiceRemote;

	// dates of the promotion suggest
	@FXML
	private TextField promsugname;
	@FXML
	private DatePicker startdate;
	@FXML
	private DatePicker enddate;
	@FXML
	private TextField promotionsuggestValue;
	@FXML
	private TextArea promotionsugdescription;
	@FXML
	private TextField keyword;

	@FXML
	private TextField selectedproductName;
	@FXML
	private TextField selectedPromSug;
	@FXML
	private TextField selectedValue;

	@FXML
	private TextField keywordpormotionSuggest;

	// hot product tableview
	@FXML
	private TableView<HotProduct> tableviewHotProduct;
	// best Seller tableview
	@FXML
	private TableView<BestSeller> tablevbestSeller;
	// stock status tableview
	@FXML
	private TableView<StockStatus> stockStatusTableView;
	// prod suggest tableview
	@FXML
	private TableView<ProductInPromSuggest> prodSugtableview;
	
	//tableview promotionss by store
	@FXML
	private TableView<PromotionsByStore> tvPromotionsByStore;

	@FXML
	private TableView<PromotionSuggest> promsuglistfxml;

	private static int selectedProductId;
	private static int selectedPromSuggestId;

	// stock status table view stuff
	ObservableList<StockStatus> stockStatusData = FXCollections.observableArrayList();
	List<Product> allProductsList = new ArrayList<Product>();
	List<StockStatus> listeStockStatus = new ArrayList<StockStatus>();
	
	// stock status table view stuff
		ObservableList<ProductInPromSuggest> prodInPromSugData = FXCollections.observableArrayList();
		List<ProductInPromSuggest> allProSugList = new ArrayList<ProductInPromSuggest>();
		List<Product> listproductForSug = new ArrayList<Product>();

	// hot product tableview stuff
	ObservableList<HotProduct> hotProductData = FXCollections.observableArrayList();
	HashMap<Product, Integer> selects = new HashMap<Product, Integer>();
	List<HotProduct> listeHotProductEditedQte = new ArrayList<HotProduct>();

	public void fillHotProductTV() {

		selects = indicatorsServiceRemote.getHotProducts();
		for (Entry<Product, Integer> iterable_element : selects.entrySet()) {
			HotProduct hotProduct = new HotProduct();
			hotProduct.setProductlibelle(iterable_element.getKey().getLibelle());
			hotProduct.setSoldqte(iterable_element.getValue());
			listeHotProductEditedQte.add(hotProduct);
		}
		hotProductData.addAll(listeHotProductEditedQte);
		tableviewHotProduct.setItems(hotProductData);

	}
	
	//tableview promotions by store stuff
	ObservableList<PromotionsByStore> promByStoreData=FXCollections.observableArrayList();
	List<PromotionsByStore> listeFxPromByStore=new ArrayList<PromotionsByStore>();
	HashMap<Store, Promotion> hashMapPromotionByStore=new HashMap<Store, Promotion>();
	
	public void fillPromotionStoreTV(){
		hashMapPromotionByStore=indicatorsServiceRemote.getPromotionByStore();
		for (Entry<Store, Promotion> iterable : hashMapPromotionByStore.entrySet()) {
			PromotionsByStore prsotre=new PromotionsByStore();
			prsotre.setStoreName(iterable.getKey().getName());
			prsotre.setEndDate(iterable.getValue().getEndDate());
			prsotre.setStartDate(iterable.getValue().getStartDate());
			prsotre.setValue(iterable.getValue().getValue());
			prsotre.setPeomoName(iterable.getValue().getName());
			listeFxPromByStore.add(prsotre);
			
		}
		promByStoreData.addAll(listeFxPromByStore);
		tvPromotionsByStore.setItems(promByStoreData);
	}
	//bestSeller tv stuff
	ObservableList<BestSeller> bestSellerDATA=FXCollections.observableArrayList();
	List<BestSeller> listBestSeller=new ArrayList<BestSeller>();
	HashMap<Store, Double> hashMapBestSeller=new HashMap<Store, Double>();
	public void fillBestSellerTV(){
		hashMapBestSeller=indicatorsServiceRemote.getTopSellingStores();
		for (Entry<Store, Double> bestSeller : hashMapBestSeller.entrySet()) {
			BestSeller bs=new BestSeller();
			bs.setShop(bestSeller.getKey().getName());
			bs.setIncome(bestSeller.getValue());
			double total=indicatorsServiceRemote.getTotalIncome();
			bs.setPercent(bestSeller.getValue()*100/total);
			listBestSeller.add(bs);
		}
		bestSellerDATA.addAll(listBestSeller);
		tablevbestSeller.setItems(bestSellerDATA);
	}
	

	public void fillStockStatusTV() {

		for (Product product : allProductsList) {
			StockStatus stkStatus = new StockStatus();
			stkStatus.setLibelle(product.getLibelle());
			stkStatus.setQte(product.getQte());
			stkStatus.setCriticalZone(product.getCriticalZone());
			listeStockStatus.add(stkStatus);
		}
		stockStatusData.addAll(listeStockStatus);
		stockStatusTableView.setItems(stockStatusData);
	}

	public Date dateFormatter(DatePicker datepicker) throws ParseException {
		String initialDate = String.valueOf(datepicker.getValue());
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
		Date dateFormatted = dt.parse(initialDate);
		return dateFormatted;
	}

	public void createPromotionSuggest() throws ParseException {
		PromotionSuggest promotionSuggest = new PromotionSuggest();
		promotionSuggest.setName(promsugname.getText());
		promotionSuggest.setDesccription(promotionsugdescription.getText());
		promotionSuggest.setEndDate(dateFormatter(enddate));
		promotionSuggest.setStartDate((dateFormatter(startdate)));
		promotionSuggest.setValue(Integer.parseInt(promotionsuggestValue.getText()));
		Date dateact=new Date();
		promotionSuggest.setSuggestionDate(dateact);
		indicatorsServiceRemote.createPromotionSuggest(promotionSuggest);
		// promotionSuggest.setStartDate();

	}


	public void fillProdPromSuggTV() {

		for (Product prodInitial : listproductForSug) {
			ProductInPromSuggest prSec = new ProductInPromSuggest();
			prSec.setId(prodInitial.getIdProduct());
			prSec.setSellprice(prodInitial.getSellPrice());
			prSec.setBuyprice(prodInitial.getBuyPrice());
			prSec.setLibelle(prodInitial.getLibelle());
			prSec.setGain(
					indicatorsServiceRemote.getNetGainPercentage(prodInitial.getBuyPrice(), prodInitial.getSellPrice(), prodInitial.getTax()));
			PromotionSuggest prosug = new PromotionSuggest();
			prSec.setPromotionsuggName(
					indicatorsServiceRemote.findPromotionSuggestByIdProd(prodInitial.getIdProduct()).getName());
			allProSugList.add(prSec);
			// test fetch

		}
		prodInPromSugData.addAll(allProSugList);
		prodSugtableview.setItems(prodInPromSugData);
		prodSugtableview.refresh();

	}

	// tv all promotion suggest stuff
	ObservableList<PromotionSuggest> promSugData = FXCollections.observableArrayList();
	List<PromotionSuggest> promSugList = new ArrayList<PromotionSuggest>();

	// fill tv allPromSuggest
	public void fillAllPromSuggTV() {

		System.out.println("prom sug list promSugList " + promSugList.size());

		promSugData.addAll(promSugList);

		promsuglistfxml.setItems(promSugData);

	}

	// recherche de promotion suggest
	public void findPromotionSuggest() {
		promSugData.clear();
		promSugList.clear();

		promSugList = indicatorsServiceRemote.findPromotionSuggestByName(keywordpormotionSuggest.getText());
		System.out.println(promSugList.size());
		fillAllPromSuggTV();

	}

	// recherche produit dans promotion suggest
	public void findProductInPromSugg() {
		listproductForSug.clear();
		allProSugList.clear();
		prodInPromSugData.clear();
		fillProdPromSuggTV();
		listproductForSug = indicatorsServiceRemote.findProductByLib(keyword.getText());
		fillProdPromSuggTV();

	}

	// affect promotion to product
	public void affectPromToProd() {
		if (selectedProductId > 0 && selectedPromSuggestId > 0)
			indicatorsServiceRemote.affectPromotionSuggestToProduct(selectedProductId, selectedPromSuggestId);
	}

	// desafedt promotion from product
	public void desafecPromFromProd() {
		indicatorsServiceRemote.removePromotionSuggestFromProduct(selectedProductId);
	}

	// remove promotion suggest
	public void removePromSuggest() {
		indicatorsServiceRemote.deletePromotionSuggest(selectedPromSuggestId);
	}

	// update promotion suggest
	PromotionSuggest promotionSuggestUpdate = new PromotionSuggest();

	public void updatePromSuggest() throws ParseException {
		promSugData.clear();
		promSugList.clear();
		PromotionSuggest promotionSuggest = new PromotionSuggest();
		promotionSuggest = indicatorsServiceRemote.findPromotionSuggestById(selectedPromSuggestId);
		promotionSuggest.setDesccription(promsugname.getText());
		promotionSuggest.setName(promsugname.getText());
		promotionSuggest.setEndDate(dateFormatter(enddate));
		promotionSuggest.setStartDate((dateFormatter(startdate)));
		promotionSuggest.setValue(Double.parseDouble(promotionsuggestValue.getText()));
		indicatorsServiceRemote.editPromotionSuggest(promotionSuggest);
		promSugList = indicatorsServiceRemote.getAllPromotionSuggest();
		fillAllPromSuggTV();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			
			Context ctx = new InitialContext();
			indicatorsServiceRemote = (IndicatorsServiceRemote) ctx
					.lookup("tunisiamall-server/IndicatorsService!edu.tunisiamall.biservices.IndicatorsServiceRemote");

System.out.println("+++++++++ "+indicatorsServiceRemote.getTopSellingStores());
			// remplir la liste de produits
			allProductsList = indicatorsServiceRemote.getAllProducts();
			listproductForSug = indicatorsServiceRemote.getAllProducts();
			promSugList = indicatorsServiceRemote.getAllPromotionSuggest();

			// method that fills the stock status tableview
			fillStockStatusTV();
			fillHotProductTV();
			fillProdPromSuggTV();
			fillAllPromSuggTV();
			fillPromotionStoreTV();
			fillBestSellerTV();

			// test hot product

		} catch (Exception e) {
			// TODO: handle exception
		}

		// selection listener tableview promotion suggest
		promsuglistfxml.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				promsugname.clear();
				promsugname.setText(newSelection.getName());

				promotionSuggestUpdate = indicatorsServiceRemote
						.findPromotionSuggestById(newSelection.getIdPromotionSuggest());
				startdate.getEditor().clear();
				startdate
						.setValue(newSelection.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				enddate.getEditor().clear();
				enddate.setValue(newSelection.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				promotionsuggestValue.clear();
				promotionsuggestValue.setText(String.valueOf(newSelection.getValue()));

				promotionsugdescription.clear();
				promotionsugdescription.setText(newSelection.getDesccription());
				selectedPromSug.clear();
				selectedPromSug.setText(newSelection.getName());
				selectedValue.clear();
				selectedValue.setText(String.valueOf(newSelection.getValue()));

				selectedPromSuggestId = newSelection.getIdPromotionSuggest();

			}
		});

		prodSugtableview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {

				selectedproductName.clear();
				selectedproductName.setText(newSelection.getLibelle());
				selectedProductId = newSelection.getId();
			}
		});
	}

}
