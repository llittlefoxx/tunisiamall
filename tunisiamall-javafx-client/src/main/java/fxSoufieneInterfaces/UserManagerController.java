package fxSoufieneInterfaces;

import java.util.List;

import Delegates.UserDelagate;

import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;

public class UserManagerController {

	
	
	
	@FXML
	private TableView<User> customertable;

	@FXML
	public void afficherCos (ActionEvent acEvent){
		List<User> customers;
		customers= UserDelagate.findAll();
		final ObservableList<User> customerData = FXCollections.observableArrayList(customers);
		customertable.setItems(customerData);
	}
	
	
	
	
	public void lister (ActionEvent acEvent){
		
		
		
		//UserDelagate userdelg =new UserDelagate();
		//List<User> user;
		//user=userdelg.findAll();
		//for (int i = 0; i < user.size(); i++) {
			//System.out.println(user.get(i).getLogin());
			
		//}
		//usertable.setUserData(user.get(1));
		
		
		
	}

}
