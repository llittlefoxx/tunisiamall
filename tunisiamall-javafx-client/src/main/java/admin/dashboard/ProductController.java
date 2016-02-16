package admin.dashboard;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.entities.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class ProductController implements Initializable {
	@FXML
	private TableView<Product> tableView;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		IndicatorsServiceRemote indicatorsServiceRemote;
		try {
			Context ctx = new InitialContext();
			indicatorsServiceRemote = (IndicatorsServiceRemote) ctx
					.lookup("tunisiamall-server/IndicatorsService!edu.tunisiamall.biservices.IndicatorsServiceRemote");
			
			System.out.println(indicatorsServiceRemote.getAllProducts().size());
			ObservableList<Product> data = FXCollections.observableArrayList();
			data.addAll(indicatorsServiceRemote.getAllProducts());
			tableView.setItems(data);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
