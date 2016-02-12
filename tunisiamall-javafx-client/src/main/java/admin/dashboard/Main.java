package admin.dashboard;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			 primaryStage.setTitle("FXML TableView Example");
			 TitledPane myPane = (TitledPane)FXMLLoader.load(getClass().getResource
		    ("Test.fxml"));
		       Scene myScene = new Scene(myPane);
		       primaryStage.setScene(myScene);
		       primaryStage.show();
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		  
	}
}
