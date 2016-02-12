package application;
	
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import GUI.ShopRequestInterfaces.ViewShopRequestAdminPannel;
import fxSoufieneInterfaces.authentificatController;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		final SwingNode swingNode = new SwingNode();
        createAndSetSwingContent(swingNode);

        Pane pane = new Pane();
        pane.getChildren().add(swingNode); // Adding swing node

        primaryStage.setScene(new Scene(pane, 100, 50));
        primaryStage.show();
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

private void createAndSetSwingContent(final SwingNode swingNode) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
        	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.generalNoTranslucencyShadow;
			 UIManager.put("RootPane.setupButtonVisible",false);
	        try {
				org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            JPanel panel = new ViewShopRequestAdminPannel();
         //   panel.add(new JButton("Click me!"));
            swingNode.setContent(panel);
        }
    });
}

	public static void main(String[] args) {
		launch(args);
	}
}
