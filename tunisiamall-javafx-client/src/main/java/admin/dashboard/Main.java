package admin.dashboard;

import java.util.List;

import Delegates.StoreDelegate;
import GUI.ShopRequestInterfaces.ViewShopRequestAdminController;
import edu.tunisiamall.entities.Store;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Main {

	public static void main(String[] args) {
		List<Store> l = StoreDelegate.findAllStore();
		  System.out.println("count: " + l.size());
	}
}
