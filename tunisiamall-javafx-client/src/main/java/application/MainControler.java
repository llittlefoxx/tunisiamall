package application;

import java.io.IOException;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

import javax.ejb.HomeHandle;

import EventFX.TunisiaMallEventController;
import GUI.ShopRequestInterfaces.ViewShopRequestAdminController;
import Gategories.ManageCategoriesController;
import GuestBookEntries.ManageGuestBookEntryController;
import admin.dashboard.DashboardController;
import fxSoufieneInterfaces.authentificatController;
import fxSoufieneInterfaces.manageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import messaging.InboxControler;

public class MainControler {

	@FXML
	private ResourceBundle resources;

	@FXML
	private Button biButton;

	@FXML
	private Button messagingButton;

	@FXML
	private AnchorPane homePane;

	@FXML
	private Button shopButton;

	@FXML
	private Button usersButton;

	@FXML
	private Button eventsButton;

	@FXML
	private Button GuestbookButton;

	@FXML
	private Button categoriesButton;

	// Panes
	public static Pane cadre;
	public static Pane shopPane;
	public static Pane usersPane;
	public static TitledPane biPane;
	public static Pane eventsPane;
	public static Pane categoriesPane;
	public static Pane messagingPane;
	public static Pane guestbookPane;

	@FXML
	void initialize() {
		try {
			cadre = homePane;
			categoriesPane = FXMLLoader.load(ManageCategoriesController.class.getResource("ManageGategories.fxml"));
			shopPane = FXMLLoader.load(ViewShopRequestAdminController.class.getResource("ViewShopRequestAdmin.fxml"));
			messagingPane = FXMLLoader.load(InboxControler.class.getResource("Inbox.fxml"));
			guestbookPane = FXMLLoader
					.load(ManageGuestBookEntryController.class.getResource("InterfaceManageEntries.fxml"));
			eventsPane = FXMLLoader.load(TunisiaMallEventController.class.getResource("TunisiaMallEvents.fxml"));
			biPane = FXMLLoader.load(DashboardController.class.getResource("DashBoard.fxml"));
			usersPane = FXMLLoader.load(manageController.class.getResource("manage.fxml"));
			homePane.getChildren().add(shopPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void shopTab(MouseEvent event) {
		homePane.getChildren().clear();
		homePane.getChildren().add(shopPane);
		homePane.setTopAnchor(shopPane, 0.0);
		homePane.setRightAnchor(shopPane, 0.0);
		homePane.setBottomAnchor(shopPane, 0.0);
		homePane.setLeftAnchor(shopPane, 0.0);
	}

	@FXML
	void usersTab(MouseEvent event) {
		homePane.getChildren().clear();
		homePane.getChildren().add(usersPane);
	}

	@FXML
	void biTab(MouseEvent event) {
		homePane.getChildren().clear();
		homePane.getChildren().add(biPane);
	}

	@FXML
	void eventsTab(MouseEvent event) {
		homePane.getChildren().clear();
		homePane.getChildren().add(eventsPane);
	}

	@FXML
	void categoriesTab(MouseEvent event) {
		homePane.getChildren().clear();
		homePane.getChildren().add(categoriesPane);
	}

	@FXML
	void messagingTab(MouseEvent event) {
		homePane.getChildren().clear();
		InboxControler.refresh();
		homePane.getChildren().add(messagingPane);
		homePane.setTopAnchor(messagingPane, 0.0);
		homePane.setRightAnchor(messagingPane, 0.0);
		homePane.setBottomAnchor(messagingPane, 0.0);
		homePane.setLeftAnchor(messagingPane, 0.0);
	}

	@FXML
	void guestbookTab(MouseEvent event) {
		homePane.getChildren().clear();
		homePane.getChildren().add(guestbookPane);
	}

	@FXML
	void signOut(ActionEvent acEvent) {
		authentificatController.s.close();
		Main.PrimaryStage.show();
	}
}
