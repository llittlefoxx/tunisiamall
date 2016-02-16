package messaging;

import java.util.ArrayList;
import java.util.List;

import Delegates.MessageDelegate;
import Delegates.UserDelagate;
import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConversationControler {

    @FXML
    private HBox controlsHBox;

    @FXML
    private ScrollPane conversationScroll;

    @FXML
    private Button backButton;

    @FXML
    private VBox rootVBox;

    @FXML
    private TextArea userInput;

    @FXML
    private VBox buttonsVBox;

    @FXML
    private Button sendButton;
    
    @FXML
    private VBox conversationVBox;
    
    private static User u = UserDelagate.find(2);
    private static User u2 = UserDelagate.find(1);

    @FXML
    void initialize() {
    	List<Message> list = MessageDelegate.getMessagesFromTo(u, u2);
    	conversationVBox.setPadding(new Insets(5, 5, 5, 5));
    	conversationVBox.setPrefHeight(list.size() * 50);
    	List<Pane> aux = new ArrayList<Pane>();
    	for(int i = list.size() - 1; i >= 0;i--){
    		conversationVBox.getChildren().add(createMessagePane(list.get(i)));
    	}
    	conversationScroll.setVvalue(1);
    }
    
    @FXML
    void sendMessage(Event event){
    	if(event.getEventType().toString() == "KEY_RELEASED"){
    		KeyEvent a = (KeyEvent) event;
    		if(a.getCode().toString() == "ENTER"){
    			if(userInput.getText().trim().length() > 0){
    	    		MessageDelegate.sendMessage(u, u2, userInput.getText().trim());
    	    		Message m = new Message();
    	    		m.setText(userInput.getText().trim());
    	    		m.setReceiver(u2);
    	    		m.setUser(u);
    	    		Pane container = createMessagePane(m);
    	    		conversationVBox.getChildren().add(container);
    	    		conversationVBox.setPrefHeight(conversationVBox.getHeight() + container.getHeight() + 100);
    	    		userInput.clear();
    	    	}
    		}
    	}
    	else if(userInput.getText().trim().length() > 0){
	    		MessageDelegate.sendMessage(u, u2, userInput.getText().trim());
	    		Message m = new Message();
	    		m.setText(userInput.getText().trim());
	    		m.setReceiver(u2);
	    		m.setUser(u);
	    		Pane container = createMessagePane(m);
	    		conversationVBox.getChildren().add(container);
	    		conversationVBox.setPrefHeight(conversationVBox.getHeight() + container.getHeight() + 100);
	    		userInput.clear();
    	}
    	refresh();
    }
    
    private void refresh(){
    	conversationVBox.resize(conversationVBox.getWidth() + 1,conversationVBox.getHeight() + 1);
    	conversationVBox.resize(conversationVBox.getWidth() - 1,conversationVBox.getHeight() - 1);
    	conversationScroll.setVvalue(1);
    }
    private Pane createMessagePane(Message m){
    	Text text = new Text(m.getText());
    	AnchorPane fix = new AnchorPane();
    	fix.getChildren().add(text);
    	fix.setTopAnchor(text, 5.0);
    	fix.setRightAnchor(text, 5.0);
    	fix.setBottomAnchor(text, 5.0);
    	fix.setLeftAnchor(text, 5.0);
    	Rectangle rectangle = new Rectangle();
    	rectangle.setFill(Color.GRAY);
    	Group g = new Group(rectangle, fix);
    	Region r = new Region();
    	if(m.getReceiver().getIdUser() == u.getIdUser()){
    		r.setPrefWidth(0);
    	}
    	else{
    		r.setPrefWidth(300);
    	}
    	HBox hbox = new HBox(r,g);
    	Pane container = new Pane(hbox);
    	container.prefHeightProperty().bind(fix.heightProperty().add(60));

    	rectangle.widthProperty().bind(container.widthProperty().subtract(r.getWidth() + 300));
    	text.wrappingWidthProperty().bind(rectangle.widthProperty());
    	rectangle.heightProperty().bind(fix.heightProperty().add(5));
    	return container;
    }
}
