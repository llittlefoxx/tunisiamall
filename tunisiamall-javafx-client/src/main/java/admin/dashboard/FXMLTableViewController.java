package admin.dashboard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FXMLTableViewController implements Initializable{
	@FXML
	private TableView<Person> tableView;
	//@FXML
	//private TextField firstNameField;
	//@FXML
	//private TextField lastNameField;
	//@FXML
	//private TextField emailField;
	//@FXML
	//private TableColumn<Person, String> firstNameColumn;

	@FXML
	protected void addPerson() {
		Person p = new Person("aaaa@gma.xx", "sdsss", "ssss");
		ObservableList<Person> data = tableView.getItems();
		data.add(p);
		tableView.setItems(data);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		addPerson();
	}
}
