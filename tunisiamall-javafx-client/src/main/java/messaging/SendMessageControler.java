package messaging;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Delegates.MessageDelegate;
import Delegates.UserDelagate;
import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;
import fxSoufieneInterfaces.authentificatController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

public class SendMessageControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<User> usersCombo;

    @FXML
    private TextArea userInput;

    @FXML
    private Button sendButton;

    @FXML
    void sendMessage(Event event) {
    	User u = usersCombo.getSelectionModel().getSelectedItem();
    	if(event.getEventType().toString() == "KEY_RELEASED"){
    		KeyEvent a = (KeyEvent) event;
    		if(a.getCode().toString() == "ENTER"){
    			if(userInput.getText().trim().length() > 0 && u != null){
    				Message m = MessageDelegate.sendMessage(authentificatController.connectedUser, u, userInput.getText().trim());
    	    		userInput.clear();
    	    		cancel();
    	    	}
    		}
    	}
    	else if(userInput.getText().trim().length() > 0 && event.getEventType().toString() == "MOUSE_CLICKED" && u != null){
    				Message m = MessageDelegate.sendMessage(authentificatController.connectedUser, u, userInput.getText().trim());
    				userInput.clear();
    				cancel();
    	}
    }

    @FXML
    void cancel() {
    	InboxControler.newMessageStage.hide();
    }

    @FXML
    void initialize() {
    	List<User> usersList = UserDelagate.findAll();
    	usersCombo.setItems(FXCollections.observableList(usersList));
    }
}
