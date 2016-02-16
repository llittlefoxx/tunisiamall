package application;

import java.io.IOException;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

import javax.ejb.HomeHandle;

import GUI.ShopRequestInterfaces.ViewShopRequestAdminController;
import Gategories.ManageCategoriesController;
import GuestBookEntries.ManageGuestBookEntryController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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
    public static Pane biPane;
    public static Pane eventsPane;
    public static Pane categoriesPane;
    public static Pane messagingPane;
    public static Pane guestbookPane;

    
    @FXML
    void initialize() {
		try {
			cadre = homePane;
			shopPane = FXMLLoader.load(ViewShopRequestAdminController.class.getResource("ViewShopRequestAdmin.fxml"));
			messagingPane = FXMLLoader.load(InboxControler.class.getResource("Inbox.fxml"));
			categoriesPane = FXMLLoader.load(ManageCategoriesController.class.getResource("ManageGategories.fxml"));
			guestbookPane = FXMLLoader.load(ManageGuestBookEntryController.class.getResource("InterfaceManageEntries.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void shopTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(shopPane);
    }

    @FXML
    void usersTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(shopPane);
    }

    @FXML
    void biTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(shopPane);
    }

    @FXML
    void eventsTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(shopPane);
    }

    @FXML
    void categoriesTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(categoriesPane);
    }

    @FXML
    void messagingTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(messagingPane);
    }

    @FXML
    void guestbookTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(guestbookPane);
    }
}

