package messaging;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.application.LauncherImpl;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
    
    public static User u = UserDelagate.find(2);
    public static User u2 = UserDelagate.find(1);

    @FXML
    void initialize() {
    	List<Message> list = MessageDelegate.getMessagesFromTo(u, u2);
    	conversationVBox.setPadding(new Insets(5, 5, 5, 5));
    	conversationVBox.setPrefHeight(conversationVBox.USE_COMPUTED_SIZE);
    	conversationVBox.setSpacing(5);
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
    	    		StackPane container = createMessagePane(m);
    	    		conversationVBox.getChildren().add(container);
    	    		//conversationVBox.setPrefHeight(conversationVBox.getHeight() + container.getHeight() + 100);
    	    		userInput.clear();
    	    	}
    		}
    	}
    	else if(userInput.getText().trim().length() > 0){
	    		Message m = MessageDelegate.sendMessage(u, u2, userInput.getText().trim());
	    		StackPane container = createMessagePane(m);
	    		conversationVBox.getChildren().add(container);
	    		conversationVBox.setPrefHeight(conversationVBox.getHeight() + container.getHeight() + 100);
	    		userInput.clear();
    	}
    	refresh();
    }
    
    private void refresh(){
    	//conversationVBox.resize(conversationVBox.getWidth() + 1,conversationVBox.getHeight() + 1);
    	//conversationVBox.resize(conversationVBox.getWidth() - 1,conversationVBox.getHeight() - 1);
    	conversationScroll.setVvalue(1);
    }
    
    private StackPane createMessagePane(Message m){
    	Label text = new Label(m.getText());
    	text.setWrapText(true);
    	text.setPadding(new Insets(5));
    	text.setPrefHeight(text.USE_COMPUTED_SIZE);
    	BackgroundFill textBackground = new BackgroundFill(Color.GREEN, new CornerRadii(5), new Insets(0));
    	text.setBackground(new Background(textBackground));
    	Region r = new Region();
    	Label date = new Label(m.getDate().toString());
    	date.setMinWidth(120);
    	HBox box = new HBox();
    	if(m.getUser().getIdUser() == u.getIdUser()){
    		box.getChildren().addAll(text,r,date);
    	}
    	else{
    		box.getChildren().addAll(date,r,text);
    	}
    	box.setHgrow(r, Priority.ALWAYS);
    	box.setAlignment(Pos.CENTER);
    	StackPane container = new StackPane(box);
    	container.setAlignment(Pos.CENTER_LEFT);
    	return container;
    }
    
    public static void start(Parent parent, int x){
    	parent.getChildrenUnmodifiable().clear();
    	System.out.println("integer: " + x);
    }
}
