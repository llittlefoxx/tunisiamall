package application;

import fxSoufieneInterfaces.authentificatController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import messaging.InboxControler;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	public static Stage PrimaryStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			PrimaryStage = primaryStage;
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(authentificatController.class.getResource("authentificate.fxml"));
			TitledPane root =(TitledPane)loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
