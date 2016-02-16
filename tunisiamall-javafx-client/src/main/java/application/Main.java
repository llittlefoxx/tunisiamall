package application;
	
import EventFX.TunisiaMallEventController;
import edu.tunisiamall.eventServices.GestionEventRemote;
import fxSoufieneInterfaces.authentificatController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	/*@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(TunisiaMallEventController.class.getResource("TunisiaMallEvent.fxml"));
			//BorderPane root = new BorderPane();
			TitledPane root = (TitledPane) loader.load();
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(TunisiaMallEventController.class.getResource("TunisiaMallEvents.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
	     } 
		catch(Exception e) {
			e.printStackTrace();
		}}
	
	public static void main(String[] args) {
		launch(args);
	}
}
