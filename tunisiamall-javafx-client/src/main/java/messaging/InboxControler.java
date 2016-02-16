package messaging;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;

public class InboxControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane MessagesScrollPane;

    @FXML
    private ListView<String> InboxOptionsList;

    @FXML
    private AnchorPane firstAnchorPane;

    @FXML
    private HBox InboxRootHBox;

    @FXML
    private VBox MessagesVBox;
    
    @FXML
    private Pagination pagination;
    
    @FXML
    private VBox SideVBox;

    @FXML
    private Button SearchButton;

    @FXML
    private HBox SideHBox;
    
    @FXML
    private TextField SearchField;
    
    @FXML
    private VBox FixedVBox;

    // Constant
    private static final Image delete_icon = new Image(InboxControler.class.getResourceAsStream("/messaging/delete.png"));
    private static final Image search_icon = new Image(InboxControler.class.getResourceAsStream("/messaging/search.png"));
    private static final int displayCount = 10;
    
    // Vars
    private static List<HBox> AllMessagesList = new ArrayList<>();
    private static List<HBox> ReadMessagesList = new ArrayList<>();
    private static List<HBox> UnreadMessagesList = new ArrayList<>();
    
    @FXML
    void initialize() {
    	AllMessagesList = getAllMessagesList();
        SearchButton.setGraphic(new ImageView(search_icon));
        pagination.setPageFactory(new Callback<Integer, Node>() {
        	
            @Override
            public Node call(Integer pageIndex) {          
                return MessagesScrollPane;
            }
            
        });
        displayMessages(AllMessagesList);
        displayPagination(AllMessagesList, 0);
        InboxOptionsList.getItems().setAll("  All (" +  AllMessagesList.size() + ")","  Unread (" + UnreadMessagesList.size() + ")","  Read (" + ReadMessagesList.size() + ")");
        InboxOptionsList.getSelectionModel().clearAndSelect(0);
    }
    
    @FXML
    void selectMessagesFilter(MouseEvent event) {
    	List<HBox> messagesList;
    	int index = InboxOptionsList.getSelectionModel().getSelectedIndex();
    	if(index == 0){
    		AllMessagesList = getAllMessagesList();
    		displayMessages(AllMessagesList);
    		displayPagination(AllMessagesList, 0);
    	}
    	else if(index == 1){
    		UnreadMessagesList = getUnreadMessagesList();
    		displayMessages(UnreadMessagesList);
    		displayPagination(UnreadMessagesList, 0);
    	}
    	else if(index == 2){
    		ReadMessagesList = getReadMessagesList();
    		displayMessages(ReadMessagesList);
    		displayPagination(ReadMessagesList, 0);
    	}
    }
    
    @FXML
    void selectPage(MouseEvent event) {
    	
    }
    
    private void displayMessages(List<HBox> messages){
    	MessagesVBox.getChildren().clear();
    	MessagesVBox.setPrefHeight(100 * messages.size());
        MessagesVBox.getChildren().addAll(messages);
        MessagesVBox.setPadding(new Insets(10,10,10,10));
        MessagesVBox.setSpacing(10);
    }
    
    public void displayPagination(List<HBox> messagesList, int index){
    	if (messagesList.size() % displayCount == 0){
    		pagination.setPageCount(messagesList.size() / displayCount);
    	}
    	else{
    		pagination.setPageCount(messagesList.size() / displayCount + 1);
    	}
    	pagination.setCurrentPageIndex(index);
    }
    
    private HBox createMessageHBox(Message m){
    	Text idUser = new Text("" + m.getUser().getIdUser());
    	idUser.setVisible(false);
    	VBox container = new VBox();
    	Label username = new Label(m.getUser().getFirstName() + " " + m.getUser().getLastName());
    	username.setUnderline(true);
    	username.setCursor(Cursor.HAND);
    	username.setFont(Font.font("arial black", 15));
    	Label text = new Label(m.getText());
    	text.setWrapText(true);
    	text.setCursor(Cursor.HAND);
    	Label date = new Label(m.getDate().toString());
    	container.getChildren().addAll(username, text, date);
    	ImageView imageView = new ImageView(delete_icon);
        Button button = new Button("", imageView);
    	HBox result = new HBox();
    	result.getChildren().addAll(idUser, container, button);
    	result.setHgrow(container, Priority.ALWAYS);
    	result.setPrefHeight(90);
    	result.setMargin(container, new Insets(5,0,0,0));
    	result.setMargin(button, new Insets(30,5,0,0));
    	result.setStyle("-fx-border-color:red;-fx-border-radius:5");
    	return result;
    }
    
    private List<HBox> getAllMessagesList(){
    	List<HBox> messagesList = new ArrayList<>();
        User u1 = new User();
        u1.setIdUser(1);
        u1.setFirstName("Elyes");
        u1.setLastName("Ben Abdelkader");
        User u2 = new User();
        u2.setIdUser(2);
        u2.setFirstName("Foulen");
        u2.setLastName("Ben Foulen");
        Message m = new Message(u1, u2, "Hello world sdkjflksdjflksdj lkfjlskd jflksqdj lkfjqskld flksqd lkfjqsdlk jflksqdj flksqjd flkj lkqjsdf lkjsqdl fjlkqsdjflksqdklf sqdlkj lkqsdjf sdhfihzeiuhfeiuzh iufzehiu fidh fuihsd uifhsdiu hfiuqsdh fiuqhsd iufhqsdiufh iuqsdhf iusqdhfiuh iuhfdsiufh iuqsdh");
    	messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
    	return messagesList;
    }
    
    private List<HBox> getReadMessagesList(){
    	List<HBox> messagesList = new ArrayList<>();
        User u1 = new User();
        u1.setIdUser(1);
        u1.setFirstName("Elyes");
        u1.setLastName("Ben Abdelkader");
        User u2 = new User();
        u2.setIdUser(2);
        u2.setFirstName("Foulen");
        u2.setLastName("Ben Foulen");
        Message m = new Message(u1, u2, "Hello world sdkjflksdjflksdj lkfjlskd jflksqdj lkfjqskld flksqd lkfjqsdlk jflksqdj flksqjd flkj lkqjsdf lkjsqdl fjlkqsdjflksqdklf sqdlkj lkqsdjf sdhfihzeiuhfeiuzh iufzehiu fidh fuihsd uifhsdiu hfiuqsdh fiuqhsd iufhqsdiufh iuqsdhf iusqdhfiuh iuhfdsiufh iuqsdh");
    	messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
        messagesList.add(createMessageHBox(m));
    	return messagesList;
    }
    
    private List<HBox> getUnreadMessagesList(){
    	List<HBox> messagesList = new ArrayList<>();
    	return messagesList;
    }
    
}
