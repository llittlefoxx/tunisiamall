package fxSoufieneInterfaces;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import Delegates.CustomerDelegate;
import Delegates.ShopeOwnerDelegate;
import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.Shopowner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class manageController implements Initializable {

	
	@FXML
	private TableView<Shopowner> tabShopOwner;
	@FXML
	private TableColumn<Shopowner, String> soadresse;
	@FXML
	private TableColumn<Shopowner, String>sogender;
	@FXML
	private TableColumn<Shopowner, String>sofirstName;
	@FXML
	private TableColumn<Shopowner, String>solastName;
	@FXML
	private TableColumn<Shopowner, String>sojob;
	@FXML
	private TableColumn<Shopowner, String>sologin;
	@FXML
	private TableColumn<Shopowner, String>soemail;
	@FXML
	private TableColumn<Shopowner, String>sopassowrd;
	@FXML
	private TableColumn<Shopowner, String>sophone;
	@FXML
	private TableColumn<Shopowner, Boolean> sobaned;
	@FXML
	private TableColumn<Shopowner, Date> sobirthdate; 
	@FXML
	private TableColumn<Shopowner, Date>sodateActivation;
	@FXML
	private TableColumn<Shopowner, String>sopictureUrl;
	@FXML
	private TableView<Customer> tabCustomer;
	@FXML
	private TableColumn<Customer, String> cadresse;
	@FXML
	private TableColumn<Customer, String> cfirstName;
	@FXML
	private TableColumn<Customer, String> cgender;
	@FXML
	private TableColumn<Customer, String> cjob;
	@FXML
	private TableColumn<Customer, String>clastName;
	@FXML
	private TableColumn<Customer, String>clogin;
	@FXML
	private TableColumn<Customer, String>cemail;
	@FXML
	private TableColumn<Customer, String>cpassword;
	@FXML
	private TableColumn<Customer, String>cphone;
	@FXML
	private TableColumn<Customer, String>cfacturationAddr;
	@FXML
	private TableColumn<Customer, String>cshipmentAddr;
	@FXML
	private TableColumn<Customer, String> cpictureUrl;
	@FXML
	private TableColumn<Customer, Date> cbirthdate;
	@FXML 
	TableColumn<Customer, Boolean>cbaned;
	@FXML
	private ChoiceBox<String> rechercheElement; 
	@FXML 
	private TextField rechercheTxt;
	@FXML
	private TabPane tabPaneUsers;
	@FXML
	private PieChart statUsers;
	
	
	@FXML
	public void unbanir(ActionEvent event){
		String tab =tabPaneUsers.getSelectionModel().getSelectedItem().getText();	
		
		if (tab.equalsIgnoreCase("Shope Owner")){
		
		Shopowner so = tabShopOwner.getSelectionModel().getSelectedItem();
		so.setBaned(false);
		ShopeOwnerDelegate.updateShopOwner(so);
		
		}
		if (tab.equalsIgnoreCase("Customer")){
			Customer cut = tabCustomer.getSelectionModel().getSelectedItem();
			cut.setBaned(false);
			CustomerDelegate.updateCustomer(cut);
			
			
		}
	}
	@FXML
	public void banir(ActionEvent event){
		
		String tab =tabPaneUsers.getSelectionModel().getSelectedItem().getText();	
		
		if (tab.equalsIgnoreCase("Shope Owner")){
		
		Shopowner so = tabShopOwner.getSelectionModel().getSelectedItem();
		so.setBaned(true);
		ShopeOwnerDelegate.updateShopOwner(so);
		
		}
		if (tab.equalsIgnoreCase("Customer")){
			Customer cut = tabCustomer.getSelectionModel().getSelectedItem();
			cut.setBaned(true);
			CustomerDelegate.updateCustomer(cut);
			
			
		}
	}
	
	@FXML
	public void recherche(ActionEvent event){
		System.out.println(tabPaneUsers.getSelectionModel().getSelectedItem().getText());
		String value=rechercheElement.getSelectionModel().getSelectedItem();
		String chaine=rechercheTxt.getText();
		String tab =tabPaneUsers.getSelectionModel().getSelectedItem().getText();
		List<Shopowner> so;
		List<Customer> cust;
		if (tab.equalsIgnoreCase("Shope Owner")){
			
			so=ShopeOwnerDelegate.find(chaine, value);
			System.out.println(so.size());
			tabShopOwner.getItems().clear();
			tabShopOwner.setItems(FXCollections.observableArrayList(so));
			if (chaine.isEmpty()){
				afficherShopOwner();
			}
		}
		if (tab.equalsIgnoreCase("Customer")){
		cust=CustomerDelegate.find(chaine, value);
		tabCustomer.getItems().clear();
		tabCustomer.setItems(FXCollections.observableArrayList(cust));
		if (chaine.isEmpty()){
			afficherCustomer();
		}
		}
		
		
		
	}
	
	public void afficherShopOwner (){
		
		soadresse.setCellFactory(TextFieldTableCell.forTableColumn());
		soadresse.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setAddress(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		});
		
		
		
		soemail.setCellFactory(TextFieldTableCell.forTableColumn());
		soemail.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setMail(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		}); 
		
		sofirstName.setCellFactory(TextFieldTableCell.forTableColumn());
		sofirstName.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setFirstName(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		}); 
		
		sogender.setCellFactory(TextFieldTableCell.forTableColumn());
		sogender.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setGender(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		}); 
		
		sojob.setCellFactory(TextFieldTableCell.forTableColumn());
		sojob.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setJob(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		}); 
		
		solastName.setCellFactory(TextFieldTableCell.forTableColumn());
		solastName.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setLastName(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		}); 
		
		sologin.setCellFactory(TextFieldTableCell.forTableColumn());
		sologin.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setLogin(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		}); 
		
		
		sopassowrd.setCellFactory(TextFieldTableCell.forTableColumn());
		sopassowrd.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setPassword(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		});
		
		
		sophone.setCellFactory(TextFieldTableCell.forTableColumn());
		sophone.setOnEditCommit(new EventHandler<CellEditEvent<Shopowner, String>>() {
			@Override
			public void handle(CellEditEvent<Shopowner, String> event) {
				
					Shopowner so = event.getTableView().getItems().get(event.getTablePosition().getRow());
					so.setPhone(event.getNewValue());
					ShopeOwnerDelegate.updateShopOwner(so);	
			}
		});
		tabShopOwner.setEditable(true);
		sophone.setVisible(false);
		soadresse.setVisible(false);
		sogender.setVisible(false);
		sojob.setVisible(false);
		sopassowrd.setVisible(false);
		sophone.setVisible(false);
		sobirthdate.setVisible(false);
		sopictureUrl.setVisible(false);
		List<Shopowner> shopeOwners ;
		shopeOwners= ShopeOwnerDelegate.findAllSO();
		final ObservableList<Shopowner> soData = FXCollections.observableArrayList(shopeOwners);
		tabShopOwner.setItems(soData);
	}
	
	public void afficherCustomer (){
		
		
		cadresse.setCellFactory(TextFieldTableCell.forTableColumn());
		cadresse.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setAddress(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		}); 
		
		
		cfirstName.setCellFactory(TextFieldTableCell.forTableColumn());
		cfirstName.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setFirstName(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		
		cgender.setCellFactory(TextFieldTableCell.forTableColumn());
		cgender.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setGender(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		
		cjob.setCellFactory(TextFieldTableCell.forTableColumn());
		cjob.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setJob(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		
		clastName.setCellFactory(TextFieldTableCell.forTableColumn());
		clastName.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setLastName(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		
		clogin.setCellFactory(TextFieldTableCell.forTableColumn());
		clogin.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setLogin(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		
		cemail.setCellFactory(TextFieldTableCell.forTableColumn());
		cemail.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setMail(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		
		cpassword.setCellFactory(TextFieldTableCell.forTableColumn());
		cpassword.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setPassword(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		
		cphone.setCellFactory(TextFieldTableCell.forTableColumn());
		cphone.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setPhone(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		cfacturationAddr.setCellFactory(TextFieldTableCell.forTableColumn());
		cfacturationAddr.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setFacturationAddr(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		cshipmentAddr.setCellFactory(TextFieldTableCell.forTableColumn());
		cshipmentAddr.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>() {
			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				
					Customer c = event.getTableView().getItems().get(event.getTablePosition().getRow());
					c.setShipementAddr(event.getNewValue());
					CustomerDelegate.updateCustomer(c);	
			}
		});
		
		 tabCustomer.setEditable(true);
		 cadresse.setVisible(false);	 
		 cbirthdate.setVisible(false);	 
		 cfacturationAddr.setVisible(false);
		 cgender.setVisible(false);
		 cjob.setVisible(false);
		 cphone.setVisible(false);
		 cpictureUrl.setVisible(false);
		 cshipmentAddr.setVisible(false);
		 
		 
		tabCustomer.getItems().clear();
		List<Customer> customers;
		customers= CustomerDelegate.findAllCos();
		final ObservableList<Customer> custData = FXCollections.observableArrayList(customers);
		tabCustomer.setItems(custData);
	}
	
	@FXML
	void delete(ActionEvent event) {
	String tab =tabPaneUsers.getSelectionModel().getSelectedItem().getText();	
		
		if (tab.equalsIgnoreCase("Shope Owner")){
		
		Shopowner so = tabShopOwner.getSelectionModel().getSelectedItem();
		ShopeOwnerDelegate.delete(so);
		tabShopOwner.getItems().remove(so);
		}
		if (tab.equalsIgnoreCase("Customer")){
			Customer cut = tabCustomer.getSelectionModel().getSelectedItem();
			CustomerDelegate.delete(cut);
			tabCustomer.getItems().remove(cut);
			
		}
		statistic();
		
	
	}
public void statistic(){
	statUsers.setTitle("Users"); 
	statUsers.getData().setAll(new PieChart.Data("shopOwner", ShopeOwnerDelegate.count()), new PieChart.Data("Customer", CustomerDelegate.count()) 
            );
}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		statistic();
		afficherShopOwner();
		afficherCustomer();
	}
}
