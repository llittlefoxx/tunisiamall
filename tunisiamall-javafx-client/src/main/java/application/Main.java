package application;
	
<<<<<<< HEAD
import Gategories.ManageCategoriesController;
=======
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

>>>>>>> refs/heads/master

import fxSoufieneInterfaces.authentificatController;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
		/*try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(authentificatController.class.getResource("authentificate.fxml"));
			//BorderPane root = new BorderPane();
			TitledPane root = (TitledPane) loader.load();
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
	     }

			
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	}
<<<<<<< HEAD
	
	//@Override
/*	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
			
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(ManageCategoriesController.class.getResource("/Categories/ManageCategories.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Manage Categories");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
