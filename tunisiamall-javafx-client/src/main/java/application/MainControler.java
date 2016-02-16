package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainControler {

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
    public static Pane shopPane;
    public static Pane usersPane;
    public static Pane biPane;
    public static Pane eventsPane;
    public static Pane categoriesPane;
    public static Pane messagingPane;
    public static Pane guestbookPane;


    @FXML
    void initialize() {
    	
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
    	homePane.getChildren().add(shopPane);
    }

    @FXML
    void messagingTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(shopPane);
    }

    @FXML
    void guestbookTab(MouseEvent event) {
    	homePane.getChildren().clear();
    	homePane.getChildren().add(shopPane);
    }
}

