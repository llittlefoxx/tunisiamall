package fxSoufieneInterfaces;

import Delegates.UserDelagate;
import application.Main;
import application.MainControler;
import edu.tunisiamall.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

	public static User connectedUser;

	@FXML
	public void hello(ActionEvent acEvent) {
		connectedUser = UserDelagate.authentificate(login.getText(), password.getText());
		login.setText("");
		password.setText("");
		if (connectedUser != null && connectedUser.getIdUser() > 0) {
			System.out.println(connectedUser.getLogin());
			Main.PrimaryStage.close();
			try {
				Stage primaryStage = new Stage();

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainControler.class.getResource("Main.fxml"));
				BorderPane root = (BorderPane) loader.load();
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
				s = primaryStage;
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Authentitication Failed");
			alert.setHeaderText(null);
			alert.setContentText("Username or password incorrect !");
			alert.showAndWait();
		}
	}

}
