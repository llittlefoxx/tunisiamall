package admin.dashboard;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.entities.Product;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class DashboardController implements Initializable {
	@FXML
	private TableView<Product> tableviewHotProduct;

	@FXML
	private TableColumn<Product, Double> value;
	
	public ObservableValue<String> x =new ObservableStringValue() {
		
		@Override
		public void removeListener(InvalidationListener listener) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void addListener(InvalidationListener listener) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void removeListener(ChangeListener<? super String> listener) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return "ssss";
		}
		
		@Override
		public void addListener(ChangeListener<? super String> listener) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public String get() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	IndicatorsServiceRemote indicatorsServiceRemote;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Context ctx = new InitialContext();
			indicatorsServiceRemote = (IndicatorsServiceRemote) ctx
					.lookup("tunisiamall-server/IndicatorsService!edu.tunisiamall.biservices.IndicatorsServiceRemote");

			System.out.println(indicatorsServiceRemote.getAllProducts().size());
			ObservableList<Product> data = FXCollections.observableArrayList();
			List<Product> listeBrute=new ArrayList<Product>(indicatorsServiceRemote.getAllProducts());
			for (Product p : listeBrute) {
				p.setCriticalZone(p.getCriticalZone()*2);
			}
			//data.addAll(listeBrute);
			
			
			ObservableList<Product> productpromData = FXCollections.observableArrayList();
			List<Product> listeProdProm=new ArrayList<Product>(indicatorsServiceRemote.getAllProducts());
		
			productpromData.addAll(listeProdProm);
			tableviewHotProduct.setItems(productpromData);
			
			
			
			
			
			
			
			TableColumn<Product,String> valueColumn = new TableColumn<Product,String>("Promotion2");
			valueColumn.setCellValueFactory(new Callback<CellDataFeatures<Product, String>, ObservableValue<String>>() {
			     public ObservableValue<String> call(CellDataFeatures<Product, String> p) {
			    		for (Product pr : listeProdProm) {
							
			    			p.getValue(); //returns the Person instance for a particular TableView row		
						}
			    	 
			    	 
			    	 return x;
			     }
			  });
			 
			tableviewHotProduct.getColumns().add(valueColumn);
			
			
			
			
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
