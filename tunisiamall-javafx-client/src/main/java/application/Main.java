package application;
	
import Delegates.CustomerDelegate;
import Delegates.ShopeOwnerDelegate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		 final PieChart chart = new PieChart(); 
	        chart.setTitle("Users"); 
	        chart.getData().setAll(new PieChart.Data("shopOwner", ShopeOwnerDelegate.count()), new PieChart.Data("Customer", CustomerDelegate.count()) 
	               
	        ); 
		
		
		
		
		
		try {
			// StackPane root = new StackPane(); 
	        //root.getChildren().add(chart); 
			
			 primaryStage.setTitle("FXML TableView Example");
			 Pane myPane = FXMLLoader.load(getClass().getResource
		    ("/fxSoufieneInterfaces/manage.fxml"));
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
