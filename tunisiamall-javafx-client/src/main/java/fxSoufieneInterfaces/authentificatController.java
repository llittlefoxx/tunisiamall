package fxSoufieneInterfaces;

import Delegates.UserDelagate;
import edu.tunisiamall.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class authentificatController {
	@FXML
	TextField login;
	@FXML
	PasswordField password;
	@FXML
	public void hello (ActionEvent acEvent){
		UserDelagate userdelg =new UserDelagate();
		User user=new User();
		user=userdelg.authentificate(login.getText(), password.getText());
		login.setText("");
		password.setText("");
		System.out.println(user.getLogin());
		
	}

}
