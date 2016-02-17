package fxSoufieneInterfaces;

import java.io.IOException;

import javax.xml.crypto.URIReference;

import Delegates.UserDelagate;
import application.Main;
import application.MainControler;
import edu.tunisiamall.entities.Administrator;
import edu.tunisiamall.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class authentificatController {
	@FXML
	TextField login;
	@FXML
	PasswordField password;
	public static Stage s;
	
	@FXML
	public void hello (ActionEvent acEvent){
		
		User user=new User();
		//Administrator user=new Administrator();
		user=UserDelagate.authentificate(login.getText(), password.getText());
		login.setText("");
		password.setText("");
		System.out.println(user.getLogin());
		if(user.getIdUser()>0){
			Main.PrimaryStage.close();
			try {
			Stage primaryStage =new Stage();
		
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(MainControler.class.getResource("Main.fxml"));
			//TitledPane root =(TitledPane)loader.load();
			BorderPane root = (BorderPane) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			s=primaryStage;
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
	}

}
