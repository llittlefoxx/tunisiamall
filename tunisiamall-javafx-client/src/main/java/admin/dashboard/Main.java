package admin.dashboard;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			 primaryStage.setTitle("FXML TableView Example");
			 TitledPane myPane = (TitledPane)FXMLLoader.load(getClass().getResource
		    ("DashBoard.fxml"));
			 
		 
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
