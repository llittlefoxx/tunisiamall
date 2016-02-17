package messaging;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Delegates.MessageDelegate;
import Delegates.UserDelagate;
import application.MainControler;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;
import fxSoufieneInterfaces.authentificatController;

public class InboxControler {

	@FXML
	private ResourceBundle resources;

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
	private HBox SideHBox;

	@FXML
	private TextField SearchField;

	@FXML
	private VBox FixedVBox;

	@FXML
	private Button sendButton;

	// Constant
	private static final Image delete_icon = new Image(
			InboxControler.class.getResourceAsStream("/messaging/delete.png"));
	private static final int displayCount = 10;

	// Vars
	private static List<Message> AllMessagesList;
	public static Stage newMessageStage = new Stage();

	@FXML
	void initialize() {
		AllMessagesList = MessageDelegate.getMessagesFor(authentificatController.connectedUser);
		pagination.setPageFactory(new Callback<Integer, Node>() {

			@Override
			public Node call(Integer pageIndex) {
				int index = InboxOptionsList.getSelectionModel().getSelectedIndex();
				if (index == 0) {
					displayMessages(getAllMessagesList(pageIndex));
				} else if (index == 1) {
					displayMessages(getUnreadMessagesList(pageIndex));
				} else if (index == 2) {
					displayMessages(getReadMessagesList(pageIndex));
				}
				displayMessages(getAllMessagesList(pageIndex + 1));
				return MessagesScrollPane;
			}

		});
		displayMessages(getAllMessagesList(1));
		displayPagination(getAllMessagesList(0));
		InboxOptionsList.getItems().setAll("  All (" + AllMessagesList.size() + ")",
				"  Unread (" + getUnreadMessagesList(0).size() + ")", "  Read (" + getReadMessagesList(0).size() + ")");
		InboxOptionsList.getSelectionModel().clearAndSelect(0);
		try {
			Pane pop = FXMLLoader.load(SendMessageControler.class.getResource("SendMessage.fxml"));
			Scene popup = new Scene(pop);
			newMessageStage.setScene(popup);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void selectMessagesFilter(MouseEvent event) {
		int index = InboxOptionsList.getSelectionModel().getSelectedIndex();
		if (index == 0) {
			displayPagination(getAllMessagesList(0));
			displayMessages(getAllMessagesList(1));
		} else if (index == 1) {
			displayPagination(getUnreadMessagesList(0));
			displayMessages(getUnreadMessagesList(1));
		} else if (index == 2) {
			displayPagination(getReadMessagesList(0));
			displayMessages(getReadMessagesList(1));
		}
	}

	@FXML
	void selectPage(MouseEvent event) {

	}

	private void displayMessages(List<HBox> messages) {
		MessagesVBox.getChildren().clear();
		MessagesVBox.setPrefHeight(100 * messages.size());
		MessagesVBox.getChildren().addAll(messages);
		MessagesVBox.setPadding(new Insets(10, 10, 10, 10));
		MessagesVBox.setSpacing(10);
	}

	public void displayPagination(List<HBox> messagesList) {
		if (messagesList.size() % displayCount == 0) {
			pagination.setPageCount(messagesList.size() / displayCount);
		} else {
			pagination.setPageCount(messagesList.size() / displayCount + 1);
		}
	}

	private HBox createMessageHBox(Message m) {
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
		username.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				jumpTo(m);
			}
		});
		Label date = new Label(m.getDate().toString());
		container.getChildren().addAll(username, text, date);
		container.setVgrow(text, Priority.ALWAYS);
		ImageView imageView = new ImageView(delete_icon);
		Button button = new Button("", imageView);
		button.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				MessagesVBox.getChildren().remove(m);
			}
		});
		HBox result = new HBox();
		result.getChildren().addAll(idUser, container, button);
		result.setHgrow(container, Priority.ALWAYS);
		result.setPrefHeight(90);
		result.setMaxHeight(90);
		result.setMinHeight(90);
		result.setMargin(container, new Insets(5, 0, 0, 0));
		result.setMargin(button, new Insets(30, 5, 0, 0));
		result.setStyle("-fx-border-color:green;-fx-border-radius:5");
		if (m.getSeen() == 0) {
			result.setStyle("-fx-border-color:red;-fx-border-radius:5");
		}
		System.out.println("333");
		return result;
	}

	private List<HBox> getAllMessagesList(int page) {
		List<HBox> messagesList = new ArrayList<>();
		if (page == 0) {
			for (Message message : AllMessagesList) {
				messagesList.add(createMessageHBox(message));
			}
		} else {
			for (int i = (page - 1) * displayCount; i < page * displayCount && i < AllMessagesList.size(); i++) {
				messagesList.add(createMessageHBox(AllMessagesList.get(i)));
			}
		}
		return messagesList;
	}

	private List<HBox> getUnreadMessagesList(int page) {
		List<HBox> messagesList = new ArrayList<>();
		for (Message message : AllMessagesList) {
			if (message.getSeen() == 0) {
				messagesList.add(createMessageHBox(message));
			}
		}
		if (page == 0) {
			return messagesList;
		} else {
			List<HBox> result = new ArrayList<>();
			for (int i = (page - 1) * displayCount; i < page * displayCount && i < messagesList.size(); i++) {
				result.add(messagesList.get(i));
			}
			return result;
		}
	}

	private List<HBox> getReadMessagesList(int page) {
		List<HBox> messagesList = new ArrayList<>();
		for (Message message : AllMessagesList) {
			if (message.getSeen() == 1) {
				messagesList.add(createMessageHBox(message));
			}
		}
		if (page == 0) {
			return messagesList;
		} else {
			List<HBox> result = new ArrayList<>();
			for (int i = (page - 1) * displayCount; i < page * displayCount && i < messagesList.size(); i++) {
				result.add(messagesList.get(i));
			}
			return result;
		}
	}

	private void jumpTo(Message m) {
		try {
			MainControler.cadre.getChildren().clear();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ConversationControler.class.getResource("Conversation.fxml"));
			ConversationControler c = (ConversationControler) loader.getController();
			c.u = m.getUser();
			MainControler.cadre.getChildren().add(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void sendNewMessage() {
		newMessageStage.show();
	}

	public static void refresh(){
		AllMessagesList = MessageDelegate.getMessagesFor(authentificatController.connectedUser);
	}
}
