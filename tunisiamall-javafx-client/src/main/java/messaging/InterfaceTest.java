package messaging;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;


public class InterfaceTest extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(InterfaceTest.class.getResource("Inbox.fxml"));
			HBox root = (HBox) loader.load();
			Scene scene = new Scene(root,640,480);
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
